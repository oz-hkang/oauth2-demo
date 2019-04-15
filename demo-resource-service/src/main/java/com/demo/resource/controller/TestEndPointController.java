package com.demo.resource.controller;

import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import org.springframework.web.bind.annotation.*;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:thomas.kang@hrx.ai">Thomas</a>
 * @version  04/13/2019 11:22
 */
@RestController public class TestEndPointController {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  Logger logger = LoggerFactory.getLogger(TestEndPointController.class);
  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for order.
   *
   * @param   id  String
   *
   * @return  String
   */
  @GetMapping("/order/{id}")
  public String getOrder(@PathVariable String id) {
    return "order id : " + id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for principle.
   *
   * @param   oAuth2Authentication  OAuth2Authentication
   * @param   principal             Principal
   * @param   authentication        Authentication
   *
   * @return  OAuth2Authentication
   */
  @GetMapping("/getPrinciple")
  public OAuth2Authentication getPrinciple(OAuth2Authentication oAuth2Authentication, Principal principal,
    Authentication authentication) {
    logger.info(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
    logger.info(oAuth2Authentication.toString());
    logger.info("principal.toString() " + principal.toString());
    logger.info("principal.getName() " + principal.getName());
    logger.info("authentication: " + authentication.getAuthorities().toString());

    return oAuth2Authentication;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for product.
   *
   * @param   id  String
   *
   * @return  String
   */
  @GetMapping("/product/{id}")
  public String getProduct(@PathVariable String id) {
    return "product id : " + id;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * testRole.
   *
   * @return  String
   */
  @GetMapping("/role")
  public String testRole() {
    return "Hello role";
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * testScope.
   *
   * @return  String
   */
  @GetMapping("/scope")
  public String testScope() {
    return "Hello scope ";
  }

} // end class TestEndPointController
