/**
 * 
 */
package com.promineotech.service;

import java.util.List;
import com.promineotech.entity.Events;

/**
 * @author harvi
 *
 */
public interface EventsService {
List<Events> retrieveEvents(String eventName, String locationName);

Events createEvent(String eventName, String organizerUsername, String locationName);

Events updateEvent(String eventName, String organizerUsername, String locationName);

Events deleteEvent(String eventName, String organizerUsername, String locationName);
}
