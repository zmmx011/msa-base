package com.invenia.licensingservice.clients;


import com.invenia.licensingservice.model.Organization;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/* Spring 5 부터는 아래의 RestTemplate 대신 WebClient API를 사용하라고 권고 하고 있음. */
@Component
public class OrganizationRestTemplateClient {

  private final RestTemplate restTemplate;

  public OrganizationRestTemplateClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Organization getOrganization(String organizationId) {
    ResponseEntity<Organization> restExchange =
        restTemplate.exchange(
            "http://organizationservice/v1/organizations/{organizationId}",
            HttpMethod.GET,
            null, Organization.class, organizationId);

    return restExchange.getBody();
  }
}
