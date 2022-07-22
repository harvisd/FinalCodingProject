/**
 * 
 */
package com.promineotech.service;

import java.util.List;
import com.promineotech.entity.Locations;

/**
 * @author harvi
 *
 */
public interface LocationsService {
  List<Locations> retrieveLocation(String locationName, String locationAddress, int locationZip);
  
  Locations createLocation(String locationName, String locationAddress, int locationZip, String eventName);

  Locations updateLocation(String locationName, String locationAddress, int locationZip);
}
