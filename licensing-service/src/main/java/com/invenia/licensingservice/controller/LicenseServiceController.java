package com.invenia.licensingservice.controller;


import com.invenia.licensingservice.config.ServiceConfig;
import com.invenia.licensingservice.entity.License;
import com.invenia.licensingservice.service.LicenseService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "licensing-service/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

  private final LicenseService licenseService;

  private final ServiceConfig serviceConfig;

  public LicenseServiceController(LicenseService licenseService, ServiceConfig serviceConfig) {
    this.licenseService = licenseService;
    this.serviceConfig = serviceConfig;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<License> getLicenses(@PathVariable String organizationId) {
    return licenseService.getLicensesByOrganizationId(organizationId);
  }

  @RequestMapping(value = "/{licenseId}", method = RequestMethod.GET)
  public License getLicenses(@PathVariable String organizationId, @PathVariable String licenseId) {
    return licenseService.getLicense(organizationId, licenseId);
  }

  @RequestMapping(value = "{licenseId}", method = RequestMethod.PUT)
  public void updateLicenses(@PathVariable String licenseId, @RequestBody License license) {
    licenseService.updateLicense(license);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public void saveLicenses(@RequestBody License license) {
    licenseService.saveLicense(license);
  }

  @RequestMapping(value = "{licenseId}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteLicenses(@PathVariable String licenseId, @RequestBody License license) {
    licenseService.deleteLicense(license);
  }
}
