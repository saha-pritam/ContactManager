drop database if exists contactmanager;
create database if not exists contactmanager;
use contactmanager;

CREATE TABLE `users` (
  `enabled` bit(1) DEFAULT NULL,
  `userid` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `imagename` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
);

CREATE TABLE `contacts` (
  `contactid` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `addresslabel` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `emaillabel` varchar(255) DEFAULT NULL,
  `fileas` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `middlename` varchar(255) DEFAULT NULL,
  `nameprefix` varchar(255) DEFAULT NULL,
  `namesuffix` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `phonelabel` varchar(255) DEFAULT NULL,
  `phoneticfirstname` varchar(255) DEFAULT NULL,
  `phoneticmiddlename` varchar(255) DEFAULT NULL,
  `phoneticsurname` varchar(255) DEFAULT NULL,
  `relatedperson` varchar(255) DEFAULT NULL,
  `relatedpersonlabel` varchar(255) DEFAULT NULL,
  `significantdate` varchar(255) DEFAULT NULL,
  `significantdatelabel` varchar(255) DEFAULT NULL,
  `sip` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `imagename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`contactid`),
  CONSTRAINT `fk_contacts_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) on delete cascade
);

CREATE TABLE `customfields` (
  `customfieldid` int NOT NULL AUTO_INCREMENT,
  `customfield` varchar(255) DEFAULT NULL,
  `customfieldlabel` varchar(255) DEFAULT NULL,
  `contactid` int DEFAULT NULL,
  PRIMARY KEY (`customfieldid`),
  CONSTRAINT `fk_customFields_1` FOREIGN KEY (`contactid`) REFERENCES `contacts` (`contactid`) ON DELETE CASCADE
);