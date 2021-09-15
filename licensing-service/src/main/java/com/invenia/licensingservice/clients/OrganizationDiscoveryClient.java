package com.invenia.licensingservice.clients;


import com.invenia.licensingservice.model.Organization;
import java.util.List;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrganizationDiscoveryClient {

  private final DiscoveryClient discoveryClient;

  public OrganizationDiscoveryClient(DiscoveryClient discoveryClient) {
    this.discoveryClient = discoveryClient;
  }

  public Organization getOrganization(String organizationId) {
    RestTemplate restTemplate = new RestTemplate();
    List<ServiceInstance> instances = discoveryClient.getInstances("organizationservice");

    if (instances.size() == 0) {
      return null;
    }
    String serviceUri = String.format("%s/v1/organizations/%s", instances.get(0).getUri().toString(), organizationId);

    ResponseEntity<Organization> restExchange =
        restTemplate.exchange(serviceUri, HttpMethod.GET, null, Organization.class, organizationId);
    return restExchange.getBody();
  }
}
