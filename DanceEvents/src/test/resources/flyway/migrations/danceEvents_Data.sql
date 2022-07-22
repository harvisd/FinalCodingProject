-- Attendees
INSERT INTO attendees (username, attendeeFirstName, attendeeLastName) VALUES ('jarvey1975', 'Jarvey', 'DeLeon');
INSERT INTO attendees (username, attendeeFirstName, attendeeLastName) VALUES ('maryCellis76', 'Mary', 'Orlando');
INSERT INTO attendees (username, attendeeFirstName, attendeeLastName) VALUES ('billMCG', 'Bill', 'Ryan');
INSERT INTO attendees (username, attendeeFirstName, attendeeLastName) VALUES ('bahamaMama92', 'Rosemary', 'Pantazis');
INSERT INTO attendees (username, attendeeFirstName, attendeeLastName) VALUES ('dancingStar2022', 'Rose', 'Zaparaskus');
INSERT INTO attendees (username, attendeeFirstName, attendeeLastName) VALUES ('nowhereButSomeWhere4', 'Kayla', 'Jones');
INSERT INTO attendees (username, attendeeFirstName, attendeeLastName) VALUES ('salsaLover83', 'Maggie', 'Bultaris');
INSERT INTO attendees (username, attendeeFirstName, attendeeLastName) VALUES ('miggyLopez2', 'Miguel', 'Santos');
INSERT INTO attendees (username, attendeeFirstName, attendeeLastName) VALUES ('WilltheDancer', 'William', 'Soto');
INSERT INTO attendees (username, attendeeFirstName, attendeeLastName) VALUES ('pat88886', 'Patrick', 'McGill');
INSERT INTO attendees (username, attendeeFirstName, attendeeLastName) VALUES ('mrMcLovin9', 'John', 'McCarthy');

-- EventLocations
INSERT INTO eventLocations (locationName, locationAddress, locationZip, eventName) VALUES ('Boston Marriott', '4645 South Street', '01567', 'Salsa Fest 2022');
INSERT INTO eventLocations (locationName, locationAddress, locationZip, eventName) VALUES ('Worcester City Hall', '455 Main Street', '01608', 'Main Street Swing Danceathon');
INSERT INTO eventLocations (locationName, locationAddress, locationZip, eventName) VALUES ('Amherst Youth Center', '25 Gage Street', '01257', 'Youth Center Fundraiser');
INSERT INTO eventLocations (locationName, locationAddress, locationZip, eventName) VALUES ('Hartford Hilton', '364 Vernon Street', '07452', '2022 Ballroom Costume Party');
INSERT INTO eventLocations (locationName, locationAddress, locationZip, eventName) VALUES ('Elm Park', '26 Park Avenue', '01602', 'Bachata In The Park');
INSERT INTO eventLocations (locationName, locationAddress, locationZip, eventName) VALUES ('Tumbao Music Studio', '86 Webster Street', '01610', 'Flamenco Showcase');
INSERT INTO eventLocations (locationName, locationAddress, locationZip, eventName) VALUES ('Marlboro Adult Learning Center', '4647 Granger Avenue', '01854', 'Dance Night Under The Stars');
INSERT INTO eventLocations (locationName, locationAddress, locationZip, eventName) VALUES ('Stamford Marriott', '68 Marconi Boulevard', '76243', '2022 Latin Dance Festival');
INSERT INTO eventLocations (locationName, locationAddress, locationZip, eventName) VALUES ('UMass Boston Campus', '100 William T Boulevard', '02125', 'Bring Da Hype');

-- Organizers
INSERT INTO organizers (username, organizerFirstName, organizerLastName, eventName) VALUES ('Thomas3D', 'Thomas', 'Jones', 'Salsa Fest 2022');
INSERT INTO organizers (username, organizerFirstName, organizerLastName, eventName) VALUES ('DancingDiva', 'Fran', 'Rivas', 'Main Street Swing Danceathon');
INSERT INTO organizers (username, organizerFirstName, organizerLastName, eventName) VALUES ('Kell1983', 'Kelly', 'Smith', 'Youth Center Fundraiser');
INSERT INTO organizers (username, organizerFirstName, organizerLastName, eventName) VALUES ('DanceMamba', 'John', 'Shider', '2022 Ballroom Costume Party');
INSERT INTO organizers (username, organizerFirstName, organizerLastName, eventName) VALUES ('dannyDancer', 'Dennis', 'Deleon', 'Bachata In The Park');
INSERT INTO organizers (username, organizerFirstName, organizerLastName, eventName) VALUES ('KristianK', 'Kristian', 'Castro', 'Flamenco Showcase');
INSERT INTO organizers (username, organizerFirstName, organizerLastName, eventName) VALUES ('LauraN', 'Laura', 'Novelline', 'Dance Night Under The Stars');
INSERT INTO organizers (username, organizerFirstName, organizerLastName, eventName) VALUES ('AnaG57', 'Ana', 'Gonzalez', '2022 Latin Dance Festival');
INSERT INTO organizers (username, organizerFirstName, organizerLastName, eventName) VALUES ('JhonnyM', 'John', 'Matthews', 'Bring Da Hype');

-- Events
INSERT INTO events (eventName, organizerUsername, locationName) VALUES ('Salsa Fest 2022', 'Thomas3D', 'Boston Marriott');
INSERT INTO events (eventName, organizerUsername, locationName) VALUES ('Main Street Swing Danceathon', 'DancingDiva', 'Worcester City Hall');
INSERT INTO events (eventName, organizerUsername, locationName) VALUES ('Youth Center Fundraiser', 'Kell1983', 'Amherst Youth Center');
INSERT INTO events (eventName, organizerUsername, locationName) VALUES ('2022 Ballroom Costume Party', 'DanceMamba', 'Hartford Hilton');
INSERT INTO events (eventName, organizerUsername, locationName) VALUES ('Bachata In The Park', 'dannyDancer', 'Elm Park');
INSERT INTO events (eventName, organizerUsername, locationName) VALUES ('Flamenco Showcase', 'KristianK', 'Tumbao Music Studio');
INSERT INTO events (eventName, organizerUsername, locationName) VALUES ('Dance Night Under The Stars', 'LauraN', 'Marlboro Adult Learning Center');
INSERT INTO events (eventName, organizerUsername, locationName) VALUES ('2022 Latin Dance Festival', 'AnaG57', 'Stamford Marriott');
INSERT INTO events (eventName, organizerUsername, locationName) VALUES ('Bring Da Hype', 'JhonnyM', 'UMass Boston Campus');
