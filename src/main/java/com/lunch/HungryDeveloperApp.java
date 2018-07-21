package com.lunch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** The Lunch Recipe Chooser for Hard working Java Developrs Spring Boot application. */
@SpringBootApplication
public class HungryDeveloperApp {
  private static final Logger logger = LoggerFactory.getLogger(HungryDeveloperApp.class);

  /** The main method that launches this amazing app. */
  public static void main(String[] args) {
    SpringApplication.run(HungryDeveloperApp.class, args);
    logger.info(
        "                                                            \n"
            + " %@@       (@@/   /@@( (@@&   *@@(   %@@@@@@(  /@@(   /@@( \n"
            + " %@@       /@@/   /@@( (@@@&, *@@( *@@&   /@@&./@@(   *@@( \n"
            + " %@@       /@@/   /@@( (@@@@@ *@@( %@@,        /@@%###%@@( \n"
            + " %@@       (@@/   /@@( (@@,&@@#@@(.&@@,        /@@&%%%&@@( \n"
            + " %@@       *@@#   #@@/ (@@, /@@@@( /@@%   *@@&./@@(   *@@( \n"
            + " %@@@@@@@@ %@@@@@@@/   (@@,  /@@@(  .@@@@@@@(  /@@(   *@@( \n"
            + "                                                           ");
  }
}
