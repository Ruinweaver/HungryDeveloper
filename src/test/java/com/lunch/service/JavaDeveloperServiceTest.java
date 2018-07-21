package com.lunch.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class JavaDeveloperServiceTest {
  @Mock private KitchenService kitchenService;

  @InjectMocks private JavaDeveloperService developerService;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Test that the date string will parse and be non null. If null passed return the current date
   */
  @Test
  public void parseDate() {
    assertNotNull(developerService);
    assertEquals(LocalDate.now(), developerService.parseDate(null));
    assertEquals(LocalDate.parse("2019-04-30"), developerService.parseDate("2019-04-30"));
  }

}
