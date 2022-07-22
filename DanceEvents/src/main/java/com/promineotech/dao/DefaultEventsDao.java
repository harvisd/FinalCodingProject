/**
 * 
 */
package com.promineotech.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.promineotech.entity.Events;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
/**
 * @author harvi
 *
 */
@Component
@Slf4j
public class DefaultEventsDao implements EventsDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Events> retrieveEvents(String eventName, String locationName) {
   log.info("To retrieve Events eventName={}, locationName={}", eventName, locationName);
     
     //formatter:off
     String sql = " "
         + "SELECT * FROM events "
         + "WHERE eventName= :eventName OR locationName= :locationName";
     //formatter:on
     
     Map<String, Object> params = new HashMap<>();
     params.put("eventName", eventName.toString());
     params.put("locationName", locationName.toString());
     
    return jdbcTemplate.query(sql, params, new RowMapper<Events>() {
      
      @Override
      public Events mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        return Events.builder()
                     .eventName(rs.getString("eventName"))
                     .locationName(rs.getString("locationName"))
                     .build();
    }});
}
  @Override
  public Events createEvent(String eventName, String locationName, String organizerUsername) {
    log.info("To create an Event eventName={}, locationName={}, organizerUsername={}", 
              eventName, locationName, organizerUsername);
    
    //formatter:off
    String sql = " "
        + "INSERT INTO events "
        + "(eventName, locationName, organizerUsername) "
        + "VALUES ("
        + " :eventName, :locationName, :organizerUsername)";
    //formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("eventName", eventName.toString());
    params.put("locationName", locationName.toString());
    params.put("organizerUsername", organizerUsername.toString());
 
    
    jdbcTemplate.update(sql, params);
    return Events.builder()
                 .eventName(eventName)
                 .locationName(locationName)
                 .organizerUsername(organizerUsername)
                 .build();
  }
  
  @Override
  public Events updateEvent(String eventName, String locationName, String organizerUsername) {
    log.info("To update Event eventName={}, locationName={}, organizerUsername={}", 
                eventName, locationName, organizerUsername);
    
    //formatter:off
      String sql = " "
          + "UPDATE events SET "
          + "eventName = :eventName, locationName = :locationName, "
          + "organizerUsername = :organizerUsername "
          + "WHERE eventName = :eventName AND locationName = :locationName "
          + "AND organizerUsername = :organizerUsername";
      //formatter:on
      
      Map<String, Object> params = new HashMap<>();
      params.put("eventName", eventName.toString());
      params.put("locationName", locationName.toString());
      params.put("organizerUsername", organizerUsername.toString());
      
      jdbcTemplate.update(sql, params);
      
      return Events.builder()
          .eventName(eventName)
          .locationName(locationName)
          .organizerUsername(organizerUsername)
          .build();
  }
  
  @Override
  public Events deleteEvent(String eventName, String organizerUsername, String locationName) {
    log.info("To delete Event eventName={}", eventName);
    
    //formatter:off
       String sql = " "
           + "DELETE FROM events "
           + "WHERE eventName = :eventName AND organizerUsername = :organizerUsername "
           + "AND locationName = :locationName";
    //formatter:on
       
       Map<String, Object> params = new HashMap<>();
       params.put("eventName", eventName); 
       params.put("organizerUsername", organizerUsername);
       params.put("locationName", locationName);
       
       jdbcTemplate.update(sql, params);
       
       return Events.builder()
           .eventName(eventName)
           .organizerUsername(organizerUsername)
           .locationName(locationName)
           .build();
  }
}
