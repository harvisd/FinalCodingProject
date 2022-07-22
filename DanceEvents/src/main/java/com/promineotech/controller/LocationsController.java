
package com.promineotech.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.entity.Locations;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author harvi
 *
 */
@Validated
@RequestMapping("/Locations")
@OpenAPIDefinition(info=@Info(title = "Location Service"),
servers = {@Server(url = "http://localhost:8080", description = "Local Server")}
)

public interface LocationsController {

//@formatter:off
  @Operation(
      summary = "return a list of Locations",
      description = "Returns a list of Locations given a valid location name, location address or "
          + "location zip",
      responses = {
          
          @ApiResponse(
              
              responseCode = "200",
              description = "A list of Locations is returned.",
              content = @Content(
                  
                  mediaType = "application/json",
                  schema = @Schema(implementation = Locations.class))),
          
          @ApiResponse(
              
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "404",
              description = "No Locations were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "500",
              description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))
      },
      
      parameters = {
          
             
          @Parameter(
              
              name = "locationName",
              allowEmptyValue = false,
              required = false,
              description = "The event location name(i.e., 'Polish American Club')"),
          
          @Parameter(
              
              name = "locationAddress",
              allowEmptyValue = false,
              required = false,
              description = "The location address(i.e., '600 Main Street, Worcester, MA')"),
          
          @Parameter(
              
              name = "locationZip",
              allowEmptyValue = false,
              required = false,
              description = "The event ZipCode(i.e., '01608')")
      }
      )
  //@formatter:on
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Locations> retrieveLocation(@RequestParam(required = false) String locationName, @RequestParam(required = false) String locationAddress,
      @RequestParam(required = false) int locationZip);
  
  @Operation(
      summary = "Creating a new Location",
      description = "Creates a new Location when supplied with location name, location address, and "
          + "location zip",
      responses = {
          
          @ApiResponse(
              
              responseCode = "200",
              description = "The Location has been created.",
              content = @Content(
                  
                  mediaType = "application/json",
                  schema = @Schema(implementation = Locations.class))),
          
          @ApiResponse(
              
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "404",
              description = "No Locations were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "500",
              description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))
      },
          parameters = {
              
              @Parameter(
                  
                  name = "locationName",
                  allowEmptyValue = false,
                  required = false,
                  description = "The location name(i.e., 'Polish American Club')"),
              
              @Parameter(
                  
                  name = "locationAddress",
                  allowEmptyValue = false,
                  required = false,
                  description = "The event location address(i.e., '600 Main Street, Worcester, MA')"),
              
           @Parameter(
                  
                  name = "locationZip",
                  allowEmptyValue = false,
                  required = false,
                  description = "The event location ZipCode(i.e., '01608')")
          }
      )
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Locations createLocation(@RequestParam(required = false) String locationName, @RequestParam(required = false) String locationAddress, 
      @RequestParam(required = false) int locationZip, @RequestParam(required = false) String eventName);
  
  @Operation(
      summary = "Updating a Location",
      description = "Updates an existing Location when supplied with location name, location address "
          + "and location zip",
      responses = {
          
          @ApiResponse(
              
              responseCode = "200",
              description = "The Location has been updated.",
              content = @Content(
                  
                  mediaType = "application/json",
                  schema = @Schema(implementation = Locations.class))),
          
          @ApiResponse(
              
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "404",
              description = "No Locations were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "500",
              description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))
      },
          parameters = {
              
              
              @Parameter(
                  
                  name = "locationName",
                  allowEmptyValue = false,
                  required = false,
                  description = "The event location name(i.e., 'Polish American Club')"),
              
              @Parameter(
                  
                  name = "locationAddress",
                  allowEmptyValue = false,
                  required = false,
                  description = "The location address(i.e., '600 Main Street, Worcester, MA')"),
              
              @Parameter(
                  
                  name = "locationZip",
                  allowEmptyValue = false,
                  required = false,
                  description = "The event ZipCode(i.e., '01608')")
          }
      )
  
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Locations updateLocation(@RequestParam(required = false) String locationName, @RequestParam(required = false) String locationAddress, 
      @RequestParam(required = false) int locationZip);
  
 }
