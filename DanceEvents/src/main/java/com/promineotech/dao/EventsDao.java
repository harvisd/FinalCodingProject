/**
 * 
 */
package com.promineotech.dao;

import java.util.List;
import com.promineotech.entity.Events;

/**
 * @author harvi
 *
 */
public interface EventsDao {
  List<Events> retrieveEvents(String eventName, String locationName);

  /**
   * @param eventName
   * @param locationName
   * @param organizerUsername
   * @return
   */
  Events createEvent(String eventName, String locationName, String organizerUsername);

  /**
   * @param eventName
   * @param locationName
   * @param organizerUsername
   * @return
   */
  Events updateEvent(String eventName, String locationName, String organizerUsername);

  /**
   * @param eventName
   * @return
   */
  Events deleteEvent(String eventName, String organizerUsername, String locationName);
}
