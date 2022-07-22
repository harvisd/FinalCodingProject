/**
 * 
 */
package com.promineotech.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.dao.OrganizersDao;
import com.promineotech.entity.Organizers;
import lombok.extern.slf4j.Slf4j;

/**
 * @author harvi
 *
 */
@Service
@Slf4j
public class DefaultOrganizersService implements OrganizersService {
  
  @Autowired
  private OrganizersDao organizersDao;

  @Transactional(readOnly = true)
  @Override
  public List<Organizers> retrieveOrganizers(String username, String organizerFirstName,
      String organizerLastName, String eventName) {
    log.info("For the Organizers service usernam={}, organizerFirstName={}, organizerLastName={}, "
        + "eventName={}", username, organizerFirstName, organizerLastName, eventName);
    
    return organizersDao.retrieveOrganizers(username, organizerFirstName, organizerLastName, eventName);
  }

  @Override
  public Organizers createOrganizer(String username, String organizerFirstName,
      String organizerLastName, String eventName) {
    log.info("For the Organizers service username={}, organizerFirstName={}, organizerLastName={}, eventName={}",
        username, organizerFirstName, organizerLastName, eventName);
    
    return organizersDao.createOrganizer(username, organizerFirstName, organizerLastName, eventName);
  }

  @Override
  public Organizers updateOrganizer(String username, String organizerFirstName,
      String organizerLastName) {
    log.info("For the Organizers service username={}, organizerFirstName={}, organizerLastName={}", 
        username, organizerFirstName, organizerLastName);
    
    return organizersDao.updateOrganizer(username, organizerFirstName, organizerLastName);
  }

  @Override
  public Organizers deleteOrganizer(String username, String organizerFirstName,
      String organizerLastName) {
    log.info("For the Organizersn service username={}, organizerFirstName={}, organizerLastName={}", 
        username, organizerFirstName, organizerLastName);
    
    return organizersDao.deleteOrganizer(username, organizerFirstName, organizerLastName);
  }

}
