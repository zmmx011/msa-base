package com.invenia.apigateway.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


public class GatewayController {


  public String index(Principal principal) {
    return principal.getName();
  }
}
