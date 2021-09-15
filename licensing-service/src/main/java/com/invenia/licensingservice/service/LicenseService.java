package com.invenia.licensingservice.service;

import com.invenia.licensingservice.clients.OrganizationDiscoveryClient;
import com.invenia.licensingservice.clients.OrganizationFeignClient;
import com.invenia.licensingservice.clients.OrganizationRestTemplateClient;
import com.invenia.licensingservice.config.ServiceConfig;
import com.invenia.licensingservice.entity.License;
import com.invenia.licensingservice.model.Organization;
import com.invenia.licensingservice.repository.LicenseRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {

  private final OrganizationDiscoveryClient organizationDiscoveryClient;

  private final OrganizationFeignClient organizationFeignClient;

  private final OrganizationRestTemplateClient organizationRestClient;

  private final LicenseRepository licenseRepository;

  private final ServiceConfig config;

  public LicenseService(
      OrganizationDiscoveryClient organizationDiscoveryClient,
      OrganizationFeignClient organizationFeignClient,
      OrganizationRestTemplateClient organizationRestClient,
      LicenseRepository licenseRepository, ServiceConfig config) {
    this.organizationDiscoveryClient = organizationDiscoveryClient;
    this.organizationFeignClient = organizationFeignClient;
    this.organizationRestClient = organizationRestClient;
    this.licenseRepository = licenseRepository;
    this.config = config;
  }

  public License getLicense(String organizationId, String licenseId) {
    License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
    return license.withComment(config.getExampleProfile());
  }

  public License getLicense(String organizationId, String licenseId, String clientType) {
    License license = getLicense(organizationId, licenseId);
    Organization organization = retrieveOrgInfo(organizationId, clientType);
    return license
        .withOrganizationName(organization.name())
        .withContactName(organization.contactName())
        .withContactEmail(organization.contactEmail())
        .withContactPhone(organization.contactPhone())
        .withComment(config.getExampleProfile());
  }

  private Organization retrieveOrgInfo(String organizationId, String clientType) {
    return switch (clientType) {
      case "feign" -> organizationFeignClient.getOrganization(organizationId);
      case "discovery" -> organizationDiscoveryClient.getOrganization(organizationId);
      default -> organizationRestClient.getOrganization(organizationId);
    };
  }

  public List<License> getLicensesByOrganizationId(String organizationId) {
    return licenseRepository.findByOrganizationId(organizationId);
  }

  public void saveLicense(License license) {
    license.withLicenseId(UUID.randomUUID().toString());

    licenseRepository.save(license);
  }

  public void updateLicense(License license){
    licenseRepository.save(license);
  }

  public void deleteLicense(License license){
    licenseRepository.delete(license);
  }
}
