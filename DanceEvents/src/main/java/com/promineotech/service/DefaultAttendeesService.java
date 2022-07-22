/**
 * 
 */
package com.promineotech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.dao.AttendeesDao;
import com.promineotech.entity.Attendees;
import lombok.extern.slf4j.Slf4j;

/**
 * @author harvi
 *
 */
@Service
@Slf4j
public class DefaultAttendeesService implements AttendeesService {
  
  @Autowired
  private AttendeesDao attendeesDao;

  @Override
  public Attendees createAttendee(String username, String attendeeFirstName,
      String attendeeLastName) {
    log.info("For the Attendees service username={}, attendeeFirstName={}, attendeeLastName={}", 
        username, attendeeFirstName, attendeeLastName);
    
    return attendeesDao.createAttendee(username, attendeeFirstName, attendeeLastName);
  }

  @Override
  public Attendees updateAttendee(String username, String attendeeFirstName, String attendeeLastName) {
    log.info("For the Attendee service username={}, attendeeFirstName={}, attendeeLastName={}", 
        username, attendeeFirstName, attendeeLastName);
    
    return attendeesDao.updateAttendee(username, attendeeFirstName, attendeeLastName);
  }

  @Override
  public Attendees deleteAttendee(String username, String attendeeFirstName, String attendeeLastName) {
    log.info("For the Attendee service username={}, attendeeFirstName={}, attendeeLastName={}", 
        username, attendeeFirstName, attendeeLastName);
    
    return attendeesDao.deleteAttendee(username, attendeeFirstName, attendeeLastName);
  }

}
