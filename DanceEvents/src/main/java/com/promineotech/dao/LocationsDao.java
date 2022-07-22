/**
 * 
 */
package com.promineotech.dao;

import java.util.List;
import com.promineotech.entity.Locations;

/**
 * @author harvi
 *
 */
public interface LocationsDao {

  List<Locations> retrieveLocations(String locationName, String locationAddress,
      String locationZip);
  
  Locations createLocation(String locationName, String locationAddress, int locationZip, String eventName);
  
  Locations updateLocation(String locationName, String locationAddress, int locationZip);

}
