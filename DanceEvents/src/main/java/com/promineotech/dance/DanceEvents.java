/**
 * 
 */
package com.promineotech.dance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentScanMarker;

/**
 * @author harvi
 *
 */
@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class})
public class DanceEvents {

  public static void main(String[] args) {
    SpringApplication.run(DanceEvents.class, args);
  }

}
