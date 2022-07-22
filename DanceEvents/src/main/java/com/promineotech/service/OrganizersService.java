/**
 * 
 */
package com.promineotech.service;

import java.util.List;
import com.promineotech.entity.Organizers;

/**
 * @author harvi
 *
 */
public interface OrganizersService {
  List<Organizers> retrieveOrganizers(String username, String organizerFirstName,
      String organizerLastName, String eventName);
  
  Organizers createOrganizer(String username, String organizerFirstName, String organizerLastName, String eventName);
  
  Organizers updateOrganizer(String username, String organizerFirstName, String organizerLastName);
  
  Organizers deleteOrganizer(String username, String organizerFirstName, String organizerLastName);

}
