/**
 * 
 */
package com.promineotech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.entity.Locations;
import com.promineotech.service.LocationsService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author harvi
 *
 */
@RestController
@Slf4j 
public class DefaultLocationsController implements LocationsController {
  
  @Autowired
  private LocationsService locationsService;

  @Override
  public List<Locations> retrieveLocation(String locationName, String locationAddress,
      int locationZip) {
    
   log.info("The method to retrieve Location locationName={}, locationAddress={}, locationZip={}",
       locationName, locationAddress, locationZip);
   
    return locationsService.retrieveLocation(locationName, locationAddress, locationZip);
  }

  @Override
  public Locations createLocation(String locationName, String locationAddress, int locationZip, String eventName) {
    
    log.info("The method to create a Location locationName={}, locationAddress={}, locationZip={}, eventName={}",
        locationName, locationAddress, locationZip, eventName);
    
    return locationsService.createLocation(locationName, locationAddress, locationZip, eventName);
  }

  @Override
  public Locations updateLocation(String locationName, String locationAddress, int locationZip) {
    
    log.info("The method to update a Location locationName={}, locationAddress={}, locationZip={}",
        locationName, locationAddress, locationZip);
    
    return locationsService.updateLocation(locationName, locationAddress, locationZip);
  }

}
