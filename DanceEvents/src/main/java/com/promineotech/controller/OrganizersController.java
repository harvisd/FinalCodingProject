
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
import com.promineotech.entity.Organizers;
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
@RequestMapping("/Organizers")
@OpenAPIDefinition(info=@Info(title = "Organizer Service"),
servers = {@Server(url = "http://localhost:8080", description = "Local Server")}
)

public interface OrganizersController {
  
//@formatter:off
  @Operation(
      summary = "return a list of Organizers",
      description = "Returns a list of Organizers given a valid organizer username, organizer first name,"
          + " organizer last name or event name",
      responses = {
          
          @ApiResponse(
              
              responseCode = "200",
              description = "A list of organizers is returned.",
              content = @Content(
                  
                  mediaType = "application/json",
                  schema = @Schema(implementation = Organizers.class))),
          
          @ApiResponse(
              
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "404",
              description = "No Organizers were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "500",
              description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))
      },
      
      parameters = {
          
             
          @Parameter(
              
              name = "username",
              allowEmptyValue = false,
              required = false,
              description = "The organizer username(i.e., 'PolishGirl76')"),
          
          @Parameter(
              
              name = "organizerFirstName",
              allowEmptyValue = false,
              required = false,
              description = "The organizer's first name(i.e., 'Laura')"),
          
          @Parameter(
              
              name = "organizerLastName",
              allowEmptyValue = false,
              required = false,
              description = "The organizer last name(i.e., 'Smith')"),
          
          @Parameter(
              
              name = "eventName",
              allowEmptyValue = false,
              required = false,
              description = "The event name(i.e., '2022 Ballroom Costume Gala')")
      }
      )
  //@formatter:on
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Organizers> retrieveOrganizers(@RequestParam(required = false) String username, @RequestParam(required = false) String organizerFirstName, 
      @RequestParam(required = false) String organizerLastName, @RequestParam(required = false) String eventName);
  
  @Operation(
      summary = "Creating a new Organizer",
      description = "Creates a new Organizer when supplied with organizer username, organizer first Name, "
          + "organizer last Name, and event name",
      responses = {
          
          @ApiResponse(
              
              responseCode = "201",
              description = "The Organizer has been created.",
              content = @Content(
                  
                  mediaType = "application/json",
                  schema = @Schema(implementation = Organizers.class))),
          
          @ApiResponse(
              
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "404",
              description = "No Organizers were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "500",
              description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))
      },
          parameters = {
              
              @Parameter(
                  
                  name = "username",
                  allowEmptyValue = false,
                  required = false,
                  description = "The organizer username(i.e., 'PolishGirl76')"),
              
              @Parameter(
                  
                  name = "organizerFirstName",
                  allowEmptyValue = false,
                  required = false,
                  description = "The organizer's first name(i.e., 'Laura')"),
              
              @Parameter(
                  
                  name = "organizerLastName",
                  allowEmptyValue = false,
                  required = false,
                  description = "The organizer last name(i.e., 'Smith')"),
              
              @Parameter(
                  
                  name = "eventName",
                  allowEmptyValue = false,
                  required = false,
                  description = "The event name(i.e., '2022 Ballroom Costume Gala')")
          }
      )
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Organizers createOrganizer(@RequestParam(required = false) String username, @RequestParam(required = false) String organizerFirstName, 
      @RequestParam(required = false) String organizerLastName, @RequestParam(required = false) String eventName);
  
  @Operation(
      summary = "Updating an Organizer",
      description = "Updates an existing Organizer when supplied with username, "
          + "organizer first name, and organizer last name",
      responses = {
          
          @ApiResponse(
              
              responseCode = "200",
              description = "The organizer has been updated.",
              content = @Content(
                  
                  mediaType = "application/json",
                  schema = @Schema(implementation = Events.class))),
          
          @ApiResponse(
              
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "404",
              description = "No organizers were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "500",
              description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))
      },
          parameters = {
              
              @Parameter(
                  
                  name = "username",
                  allowEmptyValue = false,
                  required = false,
                  description = "The username(i.e., 'BoppingJimmy77')"),
              
              @Parameter(
                  
                  name = "organizerFirstName",
                  allowEmptyValue = false,
                  required = false,
                  description = "The organizer first name(i.e., 'Simon')"),
              
           @Parameter(
                  
                  name = "organizerLastName",
                  allowEmptyValue = false,
                  required = false,
                  description = "The organzier last name(i.e., 'Johnson')")
          }
      )
  
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Organizers updateOrganizer(@RequestParam(required = false) String username, @RequestParam(required = false) String organizerFirstName, 
      @RequestParam(required = false) String organizerLastName);
  
  @Operation(
      summary = "Deleting an Organizer",
      description = "Deletes an existing Organizer when supplied with username, "
          + "organizer First Name, and organizer Last Name",
      responses = {
          
          @ApiResponse(
              
              responseCode = "200",
              description = "The Organizer has been deleted.",
              content = @Content(
                  
                  mediaType = "application/json",
                  schema = @Schema(implementation = Events.class))),
          
          @ApiResponse(
              
              responseCode = "400",
              description = "The request parameters are invalid.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "404",
              description = "No Organizers were found with the input criteria.",
              content = @Content(mediaType = "application/json")),
          
          @ApiResponse(
              
              responseCode = "500",
              description = "An unplanned error occured.",
              content = @Content(mediaType = "application/json"))
      },
          parameters = {
              
              @Parameter(
                  
                  name = "username",
                  allowEmptyValue = false,
                  required = false,
                  description = "The username(i.e., 'CalvinH55')"),
              
              @Parameter(
                  
                  name = "organizerFirstName",
                  allowEmptyValue = false,
                  required = false,
                  description = "The event organizer's first name(i.e., 'Calvin')"),
              
              @Parameter(
                  
                  name = "organizerLastName",
                  allowEmptyValue = false,
                  required = false,
                  description = "The event organizer's last name(i.e., 'Harris')")
          }
      )
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  Organizers deleteOrganizer(@RequestParam(required = false) String username, @RequestParam(required = false) String organizerFirstName, 
                      @RequestParam(required = false) String organizerLastName);

}
