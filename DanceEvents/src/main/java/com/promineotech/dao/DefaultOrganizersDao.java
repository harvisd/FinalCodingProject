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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.entity.Organizers;
import lombok.extern.slf4j.Slf4j;

/**
 * @author harvi
 *
 */
@Component
@Slf4j
public class DefaultOrganizersDao implements OrganizersDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Organizers> retrieveOrganizers(String username, String organizerFirstName,
      String organizerLastName, String eventName) {
    log.info("To retrieve an organizer username={}, organizerFirstName={}, organizerLastName={}, eventName={}", 
        username, organizerFirstName, organizerLastName, eventName);
    
    //formatter:off
    String sql = ""
        + "SELECT * FROM organizers "
        + "WHERE username = :username OR organizerFirstName = :organizerFirstName "
        + "OR organizerLastName = :organizerLastName OR eventName = :eventName";
    //formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("username", username.toString());
    params.put("organizerFirstName", organizerFirstName.toString());
    params.put("organizerLastName", organizerLastName.toString());
    params.put("eventName", eventName.toString());
    
    return jdbcTemplate.query(sql, params, new RowMapper<Organizers>() {

      @Override
      public Organizers mapRow(ResultSet rs, int rowNum) throws SQLException {
        //formatter:off
        
        return Organizers.builder()
            .username(rs.getString("username"))
            .organizerFirstName(rs.getString("organizerFirstName"))
            .organizerLastName(rs.getString("organizerLastName"))
            .eventName(rs.getString("eventName"))
            .build();
        //formatter:on
      }}); 
  }
  
  @Override
  public Organizers createOrganizer(String username, String organizerFirstName, String organizerLastName, 
      String eventName) {
    log.info("To create organizer username={}, organizerFirstName={}, organizerLastName={}, eventName={}", 
        username, organizerFirstName, organizerLastName);
    
    //formatter:off
    String sql = " "
        + "INSERT INTO organizers ("
        + "username, organizerFirstName, organizerLastName, eventName"
        + ") VALUES ("
        + ":username, :organizerFirstName, :organizerLastName, :eventName)";
    //formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("username", username.toString());
    params.put("organizerFirstName", organizerFirstName.toString());
    params.put("organizerLastName", organizerLastName.toString());
    params.put("eventName", eventName.toString());
    
    jdbcTemplate.update(sql, params);
    
    return Organizers.builder()
        .username(username)
        .organizerFirstName(organizerFirstName)
        .organizerLastName(organizerLastName)
        .eventName(eventName)
        .build();
    }

  @Override
  public Organizers updateOrganizer(String username, String organizerFirstName,
      String organizerLastName) {
    log.info("To update an Organizer username={}, organizerFirstName={}, organizerLastName={}", 
        username, organizerFirstName, organizerLastName);
    
    //formatter:off
    String sql = " "
        + "UPDATE organizers SET "
        + "username = :username, organizerFirstName = :organizerFirstName, "
        + "organizerLastName = :organizerLastName "
        + "WHERE username = :username AND organizerFirstName = :organizerFirstName AND "
        + "organizerLastName = :organizerLastName";
    //formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("username", username);
    params.put("organizerFirstName", organizerFirstName);
    params.put("organizerLastName", organizerLastName);
    
    jdbcTemplate.update(sql, params);
    
    return Organizers.builder()
        .username(username)
        .organizerFirstName(organizerFirstName)
        .organizerLastName(organizerLastName)
        .build();
  }

  @Override
  public Organizers deleteOrganizer(String username, String organizerFirstName,
      String organizerLastName) {
    log.info("To delete Organizer username={}, organizerFirstName={}, organizerLastName={}", 
        username, organizerFirstName, organizerLastName);
    
    //formatter:off
    String sql = " "
        + "DELETE FROM organizers "
        + "WHERE username = :username AND organizerFirstName = :organizerFirstName "
        + "AND organizerLastName = :organizerLastName";
    //formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("username", username);
    params.put("organizerFirstName", organizerFirstName);
    params.put("organizerLastName", organizerLastName);
    
    jdbcTemplate.update(sql, params);
    
    return Organizers.builder()
        .username(username)
        .organizerFirstName(organizerFirstName)
        .organizerLastName(organizerLastName)
        .build();
  }
  
}
