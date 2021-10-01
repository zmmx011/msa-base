package com.invenia.licensingservice.service;

import com.invenia.licensingservice.client.OrganizationFeignClient;
import com.invenia.licensingservice.config.ServiceConfig;
import com.invenia.licensingservice.entity.License;
import com.invenia.licensingservice.model.Organization;
import com.invenia.licensingservice.repository.LicenseRepository;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {

  private final OrganizationFeignClient organizationFeignClient;
  private final LicenseRepository licenseRepository;
  private final ServiceConfig config;

  public LicenseService(
      OrganizationFeignClient organizationFeignClient,
      LicenseRepository licenseRepository, ServiceConfig config) {
    this.organizationFeignClient = organizationFeignClient;
    this.licenseRepository = licenseRepository;
    this.config = config;
  }

  @CircuitBreaker(name = "service", fallbackMethod = "getLicenseFallback")
  @Bulkhead(name = "service")
  public License getLicense(String organizationId, String licenseId) {
    License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
    Organization organization = organizationFeignClient.getOrganization(organizationId);
    return license
        .withOrganizationName(organization.name())
        .withContactName(organization.contactName())
        .withContactEmail(organization.contactEmail())
        .withContactPhone(organization.contactPhone())
        .withComment(config.getExampleProfile());
  }

  private License getLicenseFallback(String organizationId, String licenseId, RuntimeException e) {
    return licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
  }

  public List<License> getLicensesByOrganizationId(String organizationId) {
    return licenseRepository.findByOrganizationId(organizationId);
  }

  public void saveLicense(License license) {
    license.withLicenseId(UUID.randomUUID().toString());

    licenseRepository.save(license);
  }

  public void updateLicense(License license) {
    licenseRepository.save(license);
  }

  public void deleteLicense(License license) {
    licenseRepository.delete(license);
  }

  /* 랜덤 지연 */
  private void randomlyRunLong() {
    if (new Random().nextInt(10) <= 5) {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  /* 랜덤 에러 */
  private void randomException() {
    if(new Random().nextInt(10) <= 5) {
      throw new RuntimeException("failed");
    }
  }
}
