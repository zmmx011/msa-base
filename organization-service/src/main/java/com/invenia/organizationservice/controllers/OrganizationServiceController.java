package com.invenia.organizationservice.controllers;


import com.invenia.organizationservice.model.Organization;
import com.invenia.organizationservice.services.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/organizations")
public record OrganizationServiceController(OrganizationService orgService) {

  @RequestMapping(value = "/{organizationId}", method = RequestMethod.GET)
  public Organization getOrganization(@PathVariable String organizationId) {
    return orgService.getOrg(organizationId);
  }

  @RequestMapping(value = "/{organizationId}", method = RequestMethod.PUT)
  public void updateOrganization(@PathVariable String organizationId, @RequestBody Organization org) {
    orgService.updateOrg(org);
  }

  @RequestMapping(value = "/{organizationId}", method = RequestMethod.POST)
  public void saveOrganization(@RequestBody Organization org, @PathVariable String organizationId) {
    orgService.saveOrg(org);
  }

  @RequestMapping(value = "/{organizationId}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteOrganization(@RequestBody Organization org, @PathVariable String organizationId) {
    orgService.deleteOrg(org);
  }
}
