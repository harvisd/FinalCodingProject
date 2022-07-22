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
import com.promineotech.entity.Locations;
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
public class DefaultLocationsDao implements LocationsDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Locations> retrieveLocations(String locationName, String locationAddress,
      String locationZip) {
    log.info("To retrieve location locationName={}, locationAddress={}, locationZip={}",
        locationName, locationAddress, locationZip);

    // formatter:off
    String sql = " " + "SELECT * " + "FROM eventLocations "
        + "WHERE locationName= :locationName OR locationAddress= :locationAddress OR locationZip= :locationZip";
    // formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("locationName", locationName.toString());
    params.put("locationAddress", locationAddress.toString());
    params.put("locationZip", locationZip); 

    return jdbcTemplate.query(sql, params, new RowMapper<Locations>() {

      @Override
      public Locations mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Locations.builder().locationName(rs.getString("locationName"))
            .locationAddress(rs.getString("locationAddress")).locationZip(rs.getInt("locationZip"))
            .build();
      }
    });
  }

  public Locations createLocation(String locationName, String locationAddress, int locationZip, String eventName) {
    log.info("To create location locationName={}, locationAddress={}, locationZip={}, eventName={}", locationName,
        locationAddress, locationZip, eventName);

    // formatter:off
    String sql = " " + "INSERT INTO eventLocations (locationName, locationAddress, locationZip, eventName)"
        + "VALUES (" + ":locationName, :locationAddress, :locationZip, :eventName)";
    // formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("locationName", locationName.toString());
    params.put("locationAddress", locationAddress.toString());
    params.put("locationZip", locationZip);
    params.put("eventName", eventName);

    jdbcTemplate.update(sql, params);
    return Locations.builder().locationName(locationName).locationAddress(locationAddress)
        .locationZip(locationZip).eventName(eventName).build();
  }

  public Locations updateLocation(String locationName, String locationAddress, int locationZip) {
    log.info("To update location locationName={}, locationAddress={}, locationZip={}", locationName,
        locationAddress, locationZip);
    
    //formatter:off
    String sql = " "
        + "UPDATE eventLocations SET locationName = :locationName,"
        + "locationAddress = :locationAddress, locationZip = :locationZip "
        + "WHERE locationName = :locationName AND locationAddress = :locationAddress "
        + "AND locationZip = :locationZip";
    //formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("locationName", locationName.toString());
    params.put("locationAddress", locationAddress.toString());
    params.put("locationZip", locationZip);
    
    jdbcTemplate.update(sql, params);
    
    return Locations.builder()
        .locationName(locationName)
        .locationAddress(locationAddress)
        .locationZip(locationZip)
        .build();
  }

}
