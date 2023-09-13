package com.spring.boot.log4j2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class WebController {

  @GetMapping(path = "/example")
  public String example() {

    log.trace("Message level trace");
    log.debug("Message level debug");
    log.info("Message level info");
    log.warn("Message level warn");
    log.error("Message level error");
    log.fatal("Message level fatal");

    return "Example Working";

  }

}
