/**
 * 
 */
package com.promineotech.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Events {
  private Long eventId;
  private String eventName;
  private String organizerUsername;
  private String locationName;
  }
