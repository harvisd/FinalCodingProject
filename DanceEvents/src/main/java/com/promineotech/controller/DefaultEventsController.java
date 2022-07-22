
package com.promineotech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.entity.Events;
import com.promineotech.service.EventsService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author harvi
 *
 */
@RestController
@Slf4j 
public class DefaultEventsController implements EventsController {
  
  @Autowired
  private EventsService eventsService;

  @Override
  public List<Events> retrieveEvents(String eventName, String locationName) {
    
    log.info("The method to retrieve Events eventName={}, locationName={}", eventName, locationName);
    
    return eventsService.retrieveEvents(eventName, locationName);
  }

  @Override
  public Events createEvent(String eventName, String locationName, String organizerUsername) {
    
   log.info("The method to create an Event eventName={}, locationName={}, organizerUsername={}", eventName, 
       locationName, organizerUsername);
   
    return eventsService.createEvent(eventName, organizerUsername, locationName);
  }

  @Override
  public Events updateEvent(String eventName, String locationName, String organizerUsername) {
    
    log.info("The method to update an Event eventName={}, locationName={}, organizerUsername={}", 
        eventName, locationName, organizerUsername);
    
    return eventsService.updateEvent(eventName, organizerUsername, locationName);
  }

  @Override
  public Events deleteEvent(String eventName, String organizerUsername, String locationName) {
    
    log.info("The method to delete an Event eventName={}, organizerUsernam={}, locationName={}", eventName, 
        organizerUsername, locationName);
    
    return eventsService.deleteEvent(eventName, organizerUsername, locationName);
  }

}
