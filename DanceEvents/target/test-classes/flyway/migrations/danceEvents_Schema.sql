drop database if exists danceEvents;
create database if not exists danceEvents;

use danceEvents;

drop table if exists events;
drop table if exists eventLocations;
drop table if exists organizers;
drop table if exists attendees;

create table attendees (
attendeeIdPK int(15) auto_increment,
username varChar(50) not null,
attendeeFirstName varChar(50) not null,
attendeeLastName varChar(50) not null,
PRIMARY KEY (attendeeIdPK),
UNIQUE KEY (username)
);

create table eventLocations (
locationIdPK int(15) not null auto_increment,
locationName varChar(50) not null,
locationAddress varChar(100) not null,
locationZip int(5) not null,
eventName varChar(50) not null,
PRIMARY KEY (locationName),
UNIQUE KEY (locationIdPK, locationAddress)
);

create table organizers (
organizerIdPK int(15) not null auto_increment,
username varChar(50) not null,
organizerFirstName varChar(50) not null,
organizerLastName varChar(50) not null,
eventName varChar(50) not null,
PRIMARY KEY (organizerIdPK),
UNIQUE KEY (username, organizerFirstName, organizerLastName)
);

create table events (
eventIdPK int(15) not null auto_increment,
eventName varChar(50) not null,
organizerUsername varChar(50) not null,
locationName varChar(50) not null,
PRIMARY KEY (eventIdPK),
UNIQUE KEY (eventName),
FOREIGN KEY (locationName) REFERENCES eventLocations (locationName) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (organizerUsername) REFERENCES organizers (username) ON DELETE CASCADE ON UPDATE CASCADE
);