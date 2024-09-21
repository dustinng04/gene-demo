USE relativegene;

CREATE TABLE Person (
    PersonId INT PRIMARY KEY AUTO_INCREMENT,
	FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DateOfBirth DATE,
    Gender VARCHAR(10),
    PhoneNumber VARCHAR(12),
    IdentityId VARCHAR(12) UNIQUE,
    Address VARCHAR(100),
    AdditionalNotes TEXT
);

CREATE TABLE Relationship (
    id INT PRIMARY KEY AUTO_INCREMENT,
    relationship_type VARCHAR(50),
    Description VARCHAR(20)
);

CREATE TABLE Relative (
    RelativeId INT PRIMARY KEY AUTO_INCREMENT,
    PersonId INT,
    RelationshipId INT,
    FOREIGN KEY (PersonId) REFERENCES Person(PersonId),
    FOREIGN KEY (RelationshipId) REFERENCES Relationship(id)
);

CREATE TABLE SearchCase (
    CaseId INT PRIMARY KEY AUTO_INCREMENT,
	PersonId INT,
    ReportedBy INT,
    DateReported DATE,
    SearchStatus VARCHAR(50),
    LastKnownLocation VARCHAR(100),
    AdditionalInfo TEXT,
    FOREIGN KEY (PersonId) REFERENCES Person(PersonId),
    FOREIGN KEY (ReportedBy) REFERENCES Person(PersonId)
);

ALTER TABLE Person MODIFY Gender BOOLEAN;
select * from Person;

Insert into Relationship (relationship_type, Description) VALUES
('Truc he', 'Anh'),
('Truc he', 'Em'),
('Truc he', 'Bo'),
('Truc he', 'Me'),
('Truc he', 'Ong'),
('Truc he', 'Ba'),
('Pha he', 'Co'),
('Pha he', 'Chu'),
('Pha he', 'Bac'),
('Pha he', 'Anh em ho')

