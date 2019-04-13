package com.service.hi.servicehi.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:thomas.kang@hrx.ai">Thomas</a>
 * @version  04/13/2019 11:23
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
   */
  @Override public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/order/**").authenticated().antMatchers("/scope/**/").access(
      "#oauth2.hasScope('read')").antMatchers("/role/**/").access("#oauth2.hasRole('ROLE_USER')"); // 配置order访问控制，必须认证后才可以访问
  }
}
