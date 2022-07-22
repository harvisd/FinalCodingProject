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
public class Attendees {
private Long attendeeId;
private String username;
private String attendeeFirstName;
private String attendeeLastName;
}
