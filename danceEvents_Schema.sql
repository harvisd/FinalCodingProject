create database if not exists danceEvents;

use danceEvents;

drop table if exists events;
drop table if exists eventLocations;
drop table if exists organizers;
drop table if exists attendees;

create table events(
eventId_PK int(15) not null auto_increment,
eventName varChar(50) not null,
organizerUsername varChar(50) not null,
locationName varChar(50) not null,
PRIMARY KEY (eventId_PK),
UNIQUE KEY (eventName),
FOREIGN KEY (locationName) REFERENCES eventLocations (locationName),
FOREIGN KEY (organizerUsername) REFERENCES organizers (username)
);

create table eventLocations(
locationId_PK int(15) not null auto_increment,
locationName varChar(50) not null,
locationAddress varChar(100) not null,
locationZip int(5) not null,
eventName varChar(50) not null,
PRIMARY KEY (locationId_PK),
UNIQUE KEY (locationName, locationAddress),
FOREIGN KEY (eventName) REFERENCES events (eventName)
);

create table organizers(
organizerId_PK int(15) not null auto_increment,
username varChar(50) not null,
organizer_FirstName varChar(50) not null,
organizer_LastName varChar(50) not null,
eventName varChar(50) not null,
PRIMARY KEY (organizerId_PK),
UNIQUE KEY (username, organizer_FirstName, organizer_LastName),
FOREIGN KEY (eventName) REFERENCES events (eventName)
);

create table attendees(
attendeeId_PK int(15) auto_increment,
username varChar(50) not null,
attendee_FirstName varChar(50) not null,
attendee_LastName varChar(50) not null,
PRIMARY KEY (attendeeId_PK),
UNIQUE KEY (username)
);






