package com.invenia.organizationservice.services;

import com.invenia.organizationservice.model.Organization;
import com.invenia.organizationservice.repository.OrganizationRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

  private final OrganizationRepository orgRepository;

  public OrganizationService(OrganizationRepository orgRepository) {
    this.orgRepository = orgRepository;
  }

  public Organization getOrg(String organizationId) {

    Optional<Organization> organization = orgRepository.findById(organizationId);
    if (organization.isEmpty()) {
      throw new NullPointerException("organizationId-" + organizationId);
    }
    return organization.get();
  }

  public void saveOrg(Organization org) {
    org.setId(UUID.randomUUID().toString());

    orgRepository.save(org);

  }

  public void updateOrg(Organization org) {
    orgRepository.save(org);
  }

  public void deleteOrg(Organization org) {
    orgRepository.delete(org);
  }
}
