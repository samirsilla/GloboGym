CREATE SCHEMA `gymapp` ;

CREATE TABLE `gymapp`.`employee` (
  `Employee_Id` INT NOT NULL AUTO_INCREMENT,
  `First_Name` VARCHAR(45) NOT NULL,
  `Last_Name` VARCHAR(45) NOT NULL,
  `Employee_Number` VARCHAR(45) NOT NULL,
  `Phone_Number` VARCHAR(45) NULL,
  PRIMARY KEY (`Employee_Id`));
  
CREATE TABLE `gymapp`.`member` (
  `Member_Id` INT NOT NULL AUTO_INCREMENT,
  `First_Name` VARCHAR(45) NOT NULL,
  `Last_Name` VARCHAR(45) NOT NULL,
  `Phone_Number` VARCHAR(45) NULL,
  PRIMARY KEY (`Member_Id`));
  
CREATE TABLE `gymapp`.`user` (
  `User_Id` INT NOT NULL AUTO_INCREMENT,
  `First_Name` VARCHAR(45) NOT NULL,
  `Last_Name` VARCHAR(45) NOT NULL,
  `Phone_Number` VARCHAR(45) NULL,
  PRIMARY KEY (`User_Id`));