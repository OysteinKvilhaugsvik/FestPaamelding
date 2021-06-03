DROP SCHEMA IF EXISTS FestDeltagere CASCADE;
CREATE SCHEMA FestDeltagere;
SET search_path = FestDeltagere;

CREATE TABLE Deltager
(
 
   fornavn          CHARACTER VARYING (20),
   etternavn 	    CHARACTER VARYING (20),
   mobil			Integer,
   passord			CHARACTER VARYING (100),
   kjonn			CHARACTER VARYING (20),
   PRIMARY KEY (mobil)
  
);

INSERT INTO Deltager VALUES 
	
	('Hans', 'Eriksen', '47708956', 'kawabunga', 'mann');