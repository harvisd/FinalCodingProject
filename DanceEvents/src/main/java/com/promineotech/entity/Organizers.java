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
public class Organizers {
private Long organizerId;
private String username;
private String organizerFirstName;
private String organizerLastName;
private String eventName;
}
