package com.lunch.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Jackson JSON config. */
@Configuration
public class JacksonConfig {

  /** Jackson JSON object mapper. */
  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }
}
