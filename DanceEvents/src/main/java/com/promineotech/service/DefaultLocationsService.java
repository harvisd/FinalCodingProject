/**
 * 
 */
package com.promineotech.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.dao.LocationsDao;
import com.promineotech.entity.Locations;
import lombok.extern.slf4j.Slf4j;

/**
 * @author harvi
 *
 */
@Service
@Slf4j
public class DefaultLocationsService implements LocationsService {
  
  @Autowired
  private LocationsDao locationsDao;

  @Transactional(readOnly = true)
  @Override
  public List<Locations> retrieveLocation(String locationName, String locationAddress,
      int locationZip) {
    log.info("For the Locations service locationName={}, locationAddress={}, locationZip={}", 
        locationName, locationAddress, locationZip);
    
    return locationsDao.retrieveLocations(locationName, locationAddress, locationAddress);
  }

  @Override
  public Locations createLocation(String locationName, String locationAddress, int locationZip, String eventName) {
    log.info("For the Locations service locationName={}, locationAddress={}, locationZip={}",
        locationName, locationAddress, locationZip);
    
    return locationsDao.createLocation(locationName, locationAddress, locationZip, eventName);
  }

  @Override
  public Locations updateLocation(String locationName, String locationAddress, int locationZip) {
    log.info("For the Locations service locationName={}, locationAddress={}, locationZip={}",
        locationName, locationAddress, locationZip);
    
    return locationsDao.updateLocation(locationName, locationAddress, locationZip);
  }

}
