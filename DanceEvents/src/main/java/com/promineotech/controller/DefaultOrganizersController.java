/**
 * 
 */
package com.promineotech.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.entity.Organizers;
import com.promineotech.service.OrganizersService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author harvi
 *
 */
@RestController
@Slf4j
public class DefaultOrganizersController implements OrganizersController {
  
  @Autowired
  private OrganizersService organizerService;

  @Override
  public List<Organizers> retrieveOrganizers(String username, String organizerFirstName,
      String organizerLastName, String eventName) {
    
    log.info("The method to retrieve Organizers username={}, organizerFirstName={}, eventName={}",
        username, organizerFirstName, organizerLastName);
    
    return organizerService.retrieveOrganizers(username, organizerFirstName, organizerLastName, eventName);
  }

  @Override
  public Organizers createOrganizer(String username, String organizerFirstName,
      String organizerLastName, String eventName) {
    
    log.info("The method to create an Organizer username={}, organizerFirstName={}, organizerLastName={}",
        username, organizerFirstName, organizerLastName);
    
    return organizerService.createOrganizer(username, organizerFirstName, organizerLastName, eventName);
  }

  @Override
  public Organizers updateOrganizer(String username, String organizerFirstName,
      String organizerLastName) {
    
    log.info("The method to update an Organizer username={}, organizerFirstName={}, organizerLastName={}", 
        username, organizerFirstName, organizerLastName);
    
    return organizerService.updateOrganizer(username, organizerFirstName, organizerLastName);
  }

  @Override
  public Organizers deleteOrganizer(String username, String organizerFirstName,
      String organizerLastName) {
    
    log.info("The method to delete an Organizer username={}, organizerFirstName={}, organizerLastName={}", 
        username, organizerFirstName, organizerLastName);
    
    return organizerService.deleteOrganizer(username, organizerFirstName, organizerLastName);
  }

}
