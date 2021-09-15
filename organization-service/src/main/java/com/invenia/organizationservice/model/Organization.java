package com.invenia.organizationservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

  @Id
  @Column(name = "organization_id", nullable = false)
  String id;

  @Column(name = "name", nullable = false)
  String name;

  @Column(name = "contact_name", nullable = false)
  String contactName;

  @Column(name = "contact_email", nullable = false)
  String contactEmail;

  @Column(name = "contact_phone", nullable = false)
  String contactPhone;
}
