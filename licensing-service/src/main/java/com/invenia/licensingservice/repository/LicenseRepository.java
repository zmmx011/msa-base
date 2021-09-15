package com.invenia.licensingservice.repository;

import com.invenia.licensingservice.entity.License;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends CrudRepository<License, String> {

  List<License> findByOrganizationId(String organizationId);

  License findByOrganizationIdAndLicenseId(String organizationId, String licenseId);

}
