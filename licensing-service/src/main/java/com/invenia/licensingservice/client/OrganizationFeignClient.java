package com.invenia.licensingservice.client;


import com.invenia.licensingservice.model.Organization;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RefreshScope
@FeignClient("organizationservice")
public interface OrganizationFeignClient {

  @RequestMapping(method = RequestMethod.GET, value = "organization-service/v1/organizations/{organizationId}",
      consumes = "application/json")
  Organization getOrganization(@PathVariable("organizationId") String organizationId);
}
