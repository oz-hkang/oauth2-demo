package com.demo.authentication.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;


/**
 * DOCUMENT ME!
 *
 * @author  Hao Kang <kanghao@sm.vvip-u.com>
 * @Date:   4/17/19 4:48 PM
 */
@Configuration @EnableSwagger2 public class SwaggerConfig {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** DOCUMENT ME! */
  public static final String AUTHORIZATION_HEADER = "Authorization";

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  @Bean public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(
          "com.demo")).paths(PathSelectors.any()).build().securityContexts(Collections.singletonList(
          securityContext())).securitySchemes(Collections.singletonList(apiKey())).apiInfo(apiEndPointsInfo());
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope  = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;

    return Lists.newArrayList(
        new SecurityReference("JWT", authorizationScopes));
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private ApiInfo apiEndPointsInfo() {
    return new ApiInfoBuilder().title("Spring Boot REST API").description("Management REST API").contact(
        new Contact("iunicorn", "hci.iunicorn.com", "kanghao@sm.vvip-u.com")).license("Apache 2.0").licenseUrl(
        "http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0").build();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private ApiKey apiKey() {
    return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private SecurityContext securityContext() {
    return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
  }


} // end class SwaggerConfig
