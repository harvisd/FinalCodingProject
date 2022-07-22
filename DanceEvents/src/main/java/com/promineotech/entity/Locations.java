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
public class Locations {
private Long locationId;
private String locationName;
private String locationAddress;
private int locationZip;
private String eventName;
}
