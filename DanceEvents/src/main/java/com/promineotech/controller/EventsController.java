
package com.promineotech.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.entity.Events;
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
@RequestMapping("/Events")
@OpenAPIDefinition(info=@Info(title = "Events Service"),
servers = {@Server(url = "http://localhost:8080", description = "Local Server")})

public interface EventsController {

  //@formatter:off
  @Operation(
      summary = "return a list of Events",
      description = "Returns a list of Events given a valid event name or event location name",
      responses = {
          
          @ApiResponse(
              
              responseCode = "200",
              description = "A list of Events is returned.",
              content = @Content(
                  
                  mediaType = "application/json",
                  schema = @Schema(implementation = Events.class))),
          
          @ApiResponse(
              
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "404",
              description = "No Events were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "500",
              description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))
      },
      
      parameters = {
          
          @Parameter(
              
              name = "eventName",
              allowEmptyValue = false,
              required = false,
              description = "The event name(i.e., 'American Dance Festival')"),
          
          @Parameter(
              
              name = "locationName",
              allowEmptyValue = false,
              required = false,
              description = "The event location name(i.e., 'Polish American Club')")
      }
      )
  //@formatter:on
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Events> retrieveEvents(@RequestParam(required = false) String eventName, @RequestParam(required = false) 
  String locationName);
  
  @Operation(
      summary = "Creating a new Event",
      description = "Creates a new Event when supplied with event name, location name, and organizer name",
      responses = {
          
          @ApiResponse(
              
              responseCode = "201",
              description = "The event has been created.",
              content = @Content(
                  
                  mediaType = "application/json",
                  schema = @Schema(implementation = Events.class))),
          
          @ApiResponse(
              
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "404",
              description = "No Events were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "500",
              description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))
      },
          parameters = {
              
              @Parameter(
                  
                  name = "eventName",
                  allowEmptyValue = false,
                  required = false,
                  description = "The event name(i.e., 'American Dance Festival')"),
              
              @Parameter(
                  
                  name = "locationName",
                  allowEmptyValue = false,
                  required = false,
                  description = "The event location name(i.e., 'Polish American Club')"),
              
           @Parameter(
                  
                  name = "organizerUsername",
                  allowEmptyValue = false,
                  required = false,
                  description = "The event organizer's username(i.e., 'SambaDancer87')")
          }
      )
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Events createEvent(@RequestParam(required = false) String eventName, @RequestParam(required = false) String locationName, 
      @RequestParam(required = false) String organizerUsername);
  
  @Operation(
      summary = "Updating an Event",
      description = "Updates an existing Event when supplied with event name, location name, "
          + "and organizer name",
      responses = {
          
          @ApiResponse(
              
              responseCode = "200",
              description = "The event has been updated.",
              content = @Content(
                  
                  mediaType = "application/json",
                  schema = @Schema(implementation = Events.class))),
          
          @ApiResponse(
              
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "404",
              description = "No Events were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "500",
              description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))
      },
          parameters = {
              
              @Parameter(
                  
                  name = "eventName",
                  allowEmptyValue = false,
                  required = false,
                  description = "The event name(i.e., 'American Dance Festival')"),
              
              @Parameter(
                  
                  name = "locationName",
                  allowEmptyValue = false,
                  required = false,
                  description = "The event location name(i.e., 'Polish American Club')"),
              
           @Parameter(
                  
                  name = "organizerUsername",
                  allowEmptyValue = false,
                  required = false,
                  description = "The event organizer's username(i.e., 'SambaDancer87')")
          }
      )
  
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Events updateEvent(@RequestParam(required = false) String eventName, @RequestParam(required = false) String locationName, 
      @RequestParam(required = false) String organizerUsername);
  
  @Operation(
      summary = "Deleting an Event",
      description = "Deletes an existing Event when supplied with event name",
      responses = {
          
          @ApiResponse(
              
              responseCode = "200",
              description = "The event has been deleted.",
              content = @Content(
                  
                  mediaType = "application/json",
                  schema = @Schema(implementation = Events.class))),
          
          @ApiResponse(
              
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "404",
              description = "No Events were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "500",
              description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))
      },
          parameters = {
              
              @Parameter(
                  
                  name = "eventName",
                  allowEmptyValue = false,
                  required = false,
                  description = "The event name(i.e., 'American Dance Festival')"),
              
              @Parameter(
                  
                  name = "organizerUsername",
                  allowEmptyValue = false,
                  required = false,
                  description = "The organizer username(i.e., 'BellyDancingGirl96')"),
              
              @Parameter(
                  
                  name = "locationName",
                  allowEmptyValue = false,
                  required = false,
                  description = "The location name(i.e., 'American Dance Institute')")
          }
      )
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  Events deleteEvent(@RequestParam(required = false) String eventName, @RequestParam(required = false) String organizerUsername, 
                      @RequestParam(required = false) String locationName);
}
