/**
 * 
 */
package com.promineotech.dao;

import java.util.List;
import com.promineotech.entity.Organizers;

/**
 * @author harvi
 *
 */
public interface OrganizersDao {
  List<Organizers> retrieveOrganizers(String username, String organizerFirstName,
      String organizerLastName, String eventName);

  /**
   * @param username
   * @param organizerFirstName
   * @param organizerLastName
   * @return
   */
  Organizers createOrganizer(String username, String organizerFirstName, String organizerLastName, String eventName);
  
  Organizers updateOrganizer(String username, String organizerFirstName, String organizerLastName);
  
  Organizers deleteOrganizer(String username, String organizerFirstName, String organizerLastName);
}
