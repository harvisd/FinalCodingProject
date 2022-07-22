/**
 * 
 */
package com.promineotech.service;

import com.promineotech.entity.Attendees;

/**
 * @author harvi
 *
 */
public interface AttendeesService {
  Attendees createAttendee(String username, String attendeeFirstName, String attendeeLastName);
  
  /**
   * @param username
   * @param attendeeFirstName
   * @param attendeeLastName
   * @return
   */
  Attendees updateAttendee(String username, String attendeeFirstName, String attendeeLastName);

  /**
   * @param username
   * @param attendeeFirstName
   * @param attendeeLastName
   * @return
   */
  Attendees deleteAttendee(String username, String attendeeFirstName, String attendeeLastName);

}
