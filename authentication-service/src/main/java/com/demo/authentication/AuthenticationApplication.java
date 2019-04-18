package com.demo.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:thomas.kang@hrx.ai">Thomas</a>
 * @version  04/13/2019 16:33
 */
@EnableDiscoveryClient @EnableEurekaClient @EnableResourceServer @SpringBootApplication
public class AuthenticationApplication {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * main.
   *
   * @param  args  String[]
   */
  public static void main(String[] args) {
    SpringApplication.run(AuthenticationApplication.class, args);
  }
}
