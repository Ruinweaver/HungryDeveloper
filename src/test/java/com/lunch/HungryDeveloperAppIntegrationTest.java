package com.lunch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HungryDeveloperAppIntegrationTest {
  private static final Logger logger = LoggerFactory.getLogger(HungryDeveloperApp.class);

  @Test
  public void testEnvironmentUp() {
    logger.info("Test Integration Environment UP SUCCESSFULLY!!");
  }
}
