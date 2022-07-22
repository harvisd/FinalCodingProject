/**
 * 
 */
package com.promineotech.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.entity.Attendees;
import lombok.extern.slf4j.Slf4j;

/**
 * @author harvi
 *
 */
@Component
@Slf4j
public class DefaultAttendeesDao implements AttendeesDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Attendees createAttendee(String username, String attendeeFirstName,
      String attendeeLastName) {
    log.info("For the Attendee DAO username={}, attendeeFirstName={}, attendeeLastName={}", 
        username, attendeeFirstName, attendeeLastName);
    
    //formatter:off
    String sql = " "
        + "SELECT * FROM attendees "
        + "WHERE username = :username AND attendeeFirstName = :attendeeFirstName "
        + "AND attendeeLastName = :attendeeLastName";
    //formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("username", username.toString());
    params.put("attendeeFirstName", attendeeFirstName.toString());
    params.put("attendeeLastName", attendeeLastName.toString());
    
    jdbcTemplate.update(sql, params);
    return Attendees.builder()
        .username(username)
        .attendeeFirstName(attendeeFirstName)
        .attendeeLastName(attendeeLastName)
        .build();
        
        
  }

  @Override
  public Attendees updateAttendee(String username, String attendeeFirstName, String attendeeLastName) {
    log.info("For the Attendee DAO username={}, attendeeFirstname={}, attendeeLastName={}", 
        username, attendeeFirstName, attendeeLastName);
    
    //formatter:off
    String sql = " "
        + "UPDATE attendees SET username = :username, attendeeFirstName = :attendeeFirstName, "
        + "attendeeLastName = :attendeeLastName "
        + "WHERE username = :username AND attendeeFirstName = :attendeeFirstName "
        + "AND attendeeLastName = :attendeeLastName";
    //formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("username", username);
    params.put("attendeeFirstName", attendeeFirstName);
    params.put("attendeeLastName", attendeeLastName);
    
    jdbcTemplate.update(sql, params);
    
    return Attendees.builder()
        .username(username)
        .attendeeFirstName(attendeeFirstName)
        .attendeeLastName(attendeeLastName)
        .build();
  }

  @Override
 public Attendees deleteAttendee(String username, String attendeeFirstName, String attendeeLastName) {
    log.info("For the Attendee DAO username={}, attendeeFirstName={}, attendeeLastName={}", 
        username, attendeeFirstName, attendeeLastName);
    
    //formatter:off
    String sql = " "
        + "DELETE FROM attendees WHERE "
        + "username = :username AND attendeeFirstName = :attendeeFirstName "
        + "AND attendeeLastName = :attendeeLastName";
    //formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("username", username);
    params.put("attendeeFirstName", attendeeFirstName);
    params.put("attendeeLastName", attendeeLastName);
    
    jdbcTemplate.update(sql, params);    
    
    return Attendees.builder()
        .username(username)
        .attendeeFirstName(attendeeFirstName)
        .attendeeLastName(attendeeLastName)
        .build();
  }

  }

