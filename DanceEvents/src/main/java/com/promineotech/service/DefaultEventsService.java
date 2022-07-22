/**
 * 
 */
package com.promineotech.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.dao.EventsDao;
import com.promineotech.entity.Events;
import lombok.extern.slf4j.Slf4j;

/**
 * @author harvi
 *
 */
@Service
@Slf4j
public class DefaultEventsService implements EventsService {
  
  @Autowired
  private EventsDao eventsDao;

  @Transactional(readOnly = true)
  @Override
  public List<Events> retrieveEvents(String eventName, String locationName) {
    log.info("For the Events Service eventName={}, locationName={}", eventName, locationName);
        
    return eventsDao.retrieveEvents(eventName, locationName);
  }

  @Override
  public Events createEvent(String eventName, String organizerUsername, String locationName) {
    log.info("For the Events Service eventname={}, organizerUsername={}, locationName={}", 
        eventName, organizerUsername, locationName);
    
   
    return eventsDao.createEvent(eventName, locationName, organizerUsername);
  }

  @Override
  public Events updateEvent(String eventName, String organizerUsername, String locationName) {
    log.info("For the Events DAO eventName={}, organizerUsername={}, locationName={}", 
        eventName, organizerUsername, locationName);
    
    return eventsDao.updateEvent(eventName, locationName, organizerUsername);
  }

  @Override
  public Events deleteEvent(String eventName, String organizerUsername, String locationName) {
    log.info("For the Events Service eventName={}, organizerUsername={}, locationName={}", 
        eventName, organizerUsername, locationName);
    
    return eventsDao.deleteEvent(eventName, organizerUsername, locationName);
  }

}
