SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema merlionLogisticDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `merlionLogisticDB` ;
CREATE SCHEMA IF NOT EXISTS `merlionLogisticDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `merlionLogisticDB` ;

-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`Company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`Company` (
  `companyId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(255) NULL,
  `contactPersonName` VARCHAR(45) NULL,
  `emailAddress` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`companyId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`SystemUser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`SystemUser` (
  `systemUserId` INT NOT NULL AUTO_INCREMENT,
  `emailAddress` VARCHAR(45) NOT NULL,
  `postalAddress` VARCHAR(45) NULL,
  `contactNumber` VARCHAR(45) NULL,
  `salution` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `locked` TINYINT(1) NULL,
  `firstTimeLogin` VARCHAR(45) NULL,
  `createdDate` TIMESTAMP NULL,
  `Company_companyId` INT NOT NULL,
  `userType` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`systemUserId`),
  INDEX `fk_SystemUser_Company1_idx` (`Company_companyId` ASC),
  UNIQUE INDEX `emailAddress_UNIQUE` (`emailAddress` ASC),
  CONSTRAINT `fk_SystemUser_Company1`
    FOREIGN KEY (`Company_companyId`)
    REFERENCES `merlionLogisticDB`.`Company` (`companyId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`SystemLog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`SystemLog` (
  `logId` INT NOT NULL AUTO_INCREMENT,
  `logTime` TIMESTAMP NULL,
  `action` VARCHAR(255) NULL,
  `SystemUser_systemUserId` INT NOT NULL,
  PRIMARY KEY (`logId`),
  INDEX `fk_SystemLog_SystemUser_idx` (`SystemUser_systemUserId` ASC),
  CONSTRAINT `fk_SystemLog_SystemUser`
    FOREIGN KEY (`SystemUser_systemUserId`)
    REFERENCES `merlionLogisticDB`.`SystemUser` (`systemUserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`Message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`Message` (
  `messageId` INT NOT NULL AUTO_INCREMENT,
  `messageTitle` VARCHAR(45) NULL,
  `messageType` VARCHAR(45) NULL,
  `messageBody` VARCHAR(45) NULL,
  `sender` VARCHAR(45) NULL,
  `receiver` VARCHAR(45) NULL,
  `sentTime` TIMESTAMP NULL,
  `status` VARCHAR(45) NULL,
  `SystemUser_systemUserId` INT NOT NULL,
  PRIMARY KEY (`messageId`),
  INDEX `fk_Message_SystemUser1_idx` (`SystemUser_systemUserId` ASC),
  CONSTRAINT `fk_Message_SystemUser1`
    FOREIGN KEY (`SystemUser_systemUserId`)
    REFERENCES `merlionLogisticDB`.`SystemUser` (`systemUserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`UserGroup`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`UserGroup` (
  `userGroupId` INT(64) NOT NULL AUTO_INCREMENT,
  `groupType` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`userGroupId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`Client` (
  `contactPersonFirstName` VARCHAR(45) NULL,
  `contactPersonLastName` VARCHAR(45) NULL,
  `companyName` VARCHAR(45) NULL,
  `credit` VARCHAR(45) NULL,
  `SystemUser_systemUserId` INT NOT NULL,
  INDEX `fk_Client_SystemUser1_idx` (`SystemUser_systemUserId` ASC),
  PRIMARY KEY (`SystemUser_systemUserId`),
  CONSTRAINT `fk_Client_SystemUser1`
    FOREIGN KEY (`SystemUser_systemUserId`)
    REFERENCES `merlionLogisticDB`.`SystemUser` (`systemUserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`ProductPOHeader`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`ProductPOHeader` (
  `productPOId` INT NOT NULL,
  `createdDate` TIMESTAMP NULL,
  `salesPersonId` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  `status` VARCHAR(45) NULL,
  `shipTo` VARCHAR(45) NULL,
  `billTo` VARCHAR(45) NULL,
  `contactPersonPhoneNumber` VARCHAR(45) NULL,
  `contactPersonName` VARCHAR(45) NULL,
  `Client_SystemUser_systemUserId` INT NOT NULL,
  PRIMARY KEY (`productPOId`),
  INDEX `fk_ProductPOHeader_Client1_idx` (`Client_SystemUser_systemUserId` ASC),
  CONSTRAINT `fk_ProductPOHeader_Client1`
    FOREIGN KEY (`Client_SystemUser_systemUserId`)
    REFERENCES `merlionLogisticDB`.`Client` (`SystemUser_systemUserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`Product` (
  `productId` INT NOT NULL AUTO_INCREMENT,
  `currency` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  `description` VARCHAR(45) NULL,
  `Company_companyId` INT(64) NOT NULL,
  PRIMARY KEY (`productId`),
  INDEX `fk_Product_Company1_idx` (`Company_companyId` ASC),
  CONSTRAINT `fk_Product_Company1`
    FOREIGN KEY (`Company_companyId`)
    REFERENCES `merlionLogisticDB`.`Company` (`companyId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`ProductPOLineItem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`ProductPOLineItem` (
  `Product_productId` INT NOT NULL,
  `ProductPOHeader_productPOId` INT NOT NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`Product_productId`, `ProductPOHeader_productPOId`),
  INDEX `fk_Product_has_ProductPOHeader_ProductPOHeader1_idx` (`ProductPOHeader_productPOId` ASC),
  INDEX `fk_Product_has_ProductPOHeader_Product1_idx` (`Product_productId` ASC),
  CONSTRAINT `fk_Product_has_ProductPOHeader_Product1`
    FOREIGN KEY (`Product_productId`)
    REFERENCES `merlionLogisticDB`.`Product` (`productId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_has_ProductPOHeader_ProductPOHeader1`
    FOREIGN KEY (`ProductPOHeader_productPOId`)
    REFERENCES `merlionLogisticDB`.`ProductPOHeader` (`productPOId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`ProductSOHeader`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`ProductSOHeader` (
  `productSOId` INT NOT NULL,
  `createdDate` TIMESTAMP NULL,
  `ProductSOHeadercol` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  `status` VARCHAR(45) NULL,
  `shipTo` VARCHAR(45) NULL,
  `billTo` VARCHAR(45) NULL,
  `contactPersonPhoneNumber` VARCHAR(45) NULL,
  `contactPersonName` VARCHAR(45) NULL,
  `text` VARCHAR(45) NULL,
  `ProductPOHeader_productPOId` INT NOT NULL,
  PRIMARY KEY (`productSOId`),
  INDEX `fk_ProductSOHeader_ProductPOHeader1_idx` (`ProductPOHeader_productPOId` ASC),
  CONSTRAINT `fk_ProductSOHeader_ProductPOHeader1`
    FOREIGN KEY (`ProductPOHeader_productPOId`)
    REFERENCES `merlionLogisticDB`.`ProductPOHeader` (`productPOId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`ProductSOLineItem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`ProductSOLineItem` (
  `Product_productId` INT NOT NULL,
  `ProductSOHeader_productSOId` INT NOT NULL,
  `status` VARCHAR(45) NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`Product_productId`, `ProductSOHeader_productSOId`),
  INDEX `fk_Product_has_ProductSOHeader_ProductSOHeader1_idx` (`ProductSOHeader_productSOId` ASC),
  INDEX `fk_Product_has_ProductSOHeader_Product1_idx` (`Product_productId` ASC),
  CONSTRAINT `fk_Product_has_ProductSOHeader_Product1`
    FOREIGN KEY (`Product_productId`)
    REFERENCES `merlionLogisticDB`.`Product` (`productId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_has_ProductSOHeader_ProductSOHeader1`
    FOREIGN KEY (`ProductSOHeader_productSOId`)
    REFERENCES `merlionLogisticDB`.`ProductSOHeader` (`productSOId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`Group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`Group` (
  `groupId` INT NOT NULL,
  `groupType` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`groupId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`Staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`Staff` (
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `Group_groupId` INT NOT NULL,
  `SystemUser_systemUserId` INT NOT NULL,
  INDEX `fk_Staff_SystemUser1_idx` (`SystemUser_systemUserId` ASC),
  PRIMARY KEY (`SystemUser_systemUserId`),
  CONSTRAINT `fk_Staff_Group1`
    FOREIGN KEY (`Group_groupId`)
    REFERENCES `merlionLogisticDB`.`Group` (`groupId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Staff_SystemUser1`
    FOREIGN KEY (`SystemUser_systemUserId`)
    REFERENCES `merlionLogisticDB`.`SystemUser` (`systemUserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
