package com.service.hi.servicehi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import org.springframework.web.client.RestTemplate;

import feign.RequestInterceptor;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:thomas.kang@hrx.ai">Thomas</a>
 * @version  04/13/2019 16:34
 */
@Configuration @EnableConfigurationProperties @EnableOAuth2Client public class OAuth2ClientConfig {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * clientCredentialsResourceDetails.
   *
   * @return  ClientCredentialsResourceDetails
   */
  @Bean
  @ConfigurationProperties(prefix = "security.oauth2.client")
  public ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
    return new ClientCredentialsResourceDetails();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

// @Bean
// public RequestInterceptor oauth2FeignRequestInterceptor() {
// return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails());
// }
//
  /**
   * restTemplate.
   *
   * @return  RestTemplate
   */
  @Bean @LoadBalanced public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * tokenService.
   *
   * @return  ResourceServerTokenServices
   */
  @Bean public ResourceServerTokenServices tokenService() {
    RemoteTokenServices tokenServices = new RemoteTokenServices();
    tokenServices.setRestTemplate(restTemplate());
    tokenServices.setClientId("client_2");
    tokenServices.setClientSecret("123456");
    tokenServices.setCheckTokenEndpointUrl("http://service-auth/oauth/check_token");

    return tokenServices;
  }
} // end class OAuth2ClientConfig
