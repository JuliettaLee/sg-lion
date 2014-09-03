SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema merlionLogisticDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `merlionLogisticDB` ;
CREATE SCHEMA IF NOT EXISTS `merlionLogisticDB` DEFAULT CHARACTER SET utf8 ;
USE `merlionLogisticDB` ;

-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`Company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`Company` (
  `companyId` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `contactNumber` VARCHAR(45) NULL,
  `contactPersonName` VARCHAR(45) NULL DEFAULT NULL,
  `emailAddress` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`companyId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`SystemUser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`SystemUser` (
  `systemUserId` INT(11) NOT NULL AUTO_INCREMENT,
  `emailAddress` VARCHAR(45) NOT NULL,
  `postalAddress` VARCHAR(45) NULL DEFAULT NULL,
  `contactNumber` VARCHAR(45) NULL DEFAULT NULL,
  `salution` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `locked` TINYINT(1) NULL DEFAULT NULL,
  `resetPasswordUponLogin` TINYINT(1) NULL DEFAULT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `Company_companyId` INT(11) NOT NULL,
  `userType` VARCHAR(45) NOT NULL,
  `activated` TINYINT(1) NOT NULL,
  PRIMARY KEY (`systemUserId`),
  UNIQUE INDEX `emailAddress_UNIQUE` (`emailAddress` ASC),
  INDEX `fk_SystemUser_Company1_idx` (`Company_companyId` ASC),
  CONSTRAINT `fk_SystemUser_Company1`
    FOREIGN KEY (`Company_companyId`)
    REFERENCES `merlionLogisticDB`.`Company` (`companyId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`Client` (
  `contactPersonFirstName` VARCHAR(45) NULL DEFAULT NULL,
  `contactPersonLastName` VARCHAR(45) NULL DEFAULT NULL,
  `companyName` VARCHAR(45) NULL DEFAULT NULL,
  `credit` VARCHAR(45) NULL DEFAULT NULL,
  `SystemUser_systemUserId` INT(11) NOT NULL,
  PRIMARY KEY (`SystemUser_systemUserId`),
  INDEX `fk_Client_SystemUser1_idx` (`SystemUser_systemUserId` ASC),
  CONSTRAINT `fk_Client_SystemUser1`
    FOREIGN KEY (`SystemUser_systemUserId`)
    REFERENCES `merlionLogisticDB`.`SystemUser` (`systemUserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`UserGroup`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`UserGroup` (
  `groupId` INT(11) NOT NULL,
  `groupType` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`groupId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`Message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`Message` (
  `messageId` INT(11) NOT NULL AUTO_INCREMENT,
  `messageTitle` VARCHAR(45) NULL DEFAULT NULL,
  `messageType` VARCHAR(45) NULL DEFAULT NULL,
  `messageBody` VARCHAR(45) NULL DEFAULT NULL,
  `sender` VARCHAR(45) NULL DEFAULT NULL,
  `receiver` VARCHAR(45) NULL DEFAULT NULL,
  `sentTime` TIMESTAMP NULL DEFAULT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `SystemUser_systemUserId` INT(11) NOT NULL,
  PRIMARY KEY (`messageId`),
  INDEX `fk_Message_SystemUser1_idx` (`SystemUser_systemUserId` ASC),
  CONSTRAINT `fk_Message_SystemUser1`
    FOREIGN KEY (`SystemUser_systemUserId`)
    REFERENCES `merlionLogisticDB`.`SystemUser` (`systemUserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`Product` (
  `productId` INT(11) NOT NULL AUTO_INCREMENT,
  `currency` VARCHAR(45) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `Company_companyId` INT(64) NOT NULL,
  PRIMARY KEY (`productId`),
  INDEX `fk_Product_Company1_idx` (`Company_companyId` ASC),
  CONSTRAINT `fk_Product_Company1`
    FOREIGN KEY (`Company_companyId`)
    REFERENCES `merlionLogisticDB`.`Company` (`companyId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`ProductPOHeader`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`ProductPOHeader` (
  `productPOId` INT(11) NOT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `salesPersonId` VARCHAR(45) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `shipTo` VARCHAR(45) NULL DEFAULT NULL,
  `billTo` VARCHAR(45) NULL DEFAULT NULL,
  `contactPersonPhoneNumber` VARCHAR(45) NULL DEFAULT NULL,
  `contactPersonName` VARCHAR(45) NULL DEFAULT NULL,
  `Client_SystemUser_systemUserId` INT(11) NOT NULL,
  PRIMARY KEY (`productPOId`),
  INDEX `fk_ProductPOHeader_Client1_idx` (`Client_SystemUser_systemUserId` ASC),
  CONSTRAINT `fk_ProductPOHeader_Client1`
    FOREIGN KEY (`Client_SystemUser_systemUserId`)
    REFERENCES `merlionLogisticDB`.`Client` (`SystemUser_systemUserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`ProductPOLineItem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`ProductPOLineItem` (
  `Product_productId` INT(11) NOT NULL,
  `ProductPOHeader_productPOId` INT(11) NOT NULL,
  `quantity` INT(11) NULL DEFAULT NULL,
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
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`ProductSOHeader`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`ProductSOHeader` (
  `productSOId` INT(11) NOT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `shipTo` VARCHAR(45) NULL DEFAULT NULL,
  `billTo` VARCHAR(45) NULL DEFAULT NULL,
  `contactPersonPhoneNumber` VARCHAR(45) NULL DEFAULT NULL,
  `contactPersonName` VARCHAR(45) NULL DEFAULT NULL,
  `text` VARCHAR(45) NULL DEFAULT NULL,
  `ProductPOHeader_productPOId` INT(11) NOT NULL,
  `staffId` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`productSOId`),
  INDEX `fk_ProductSOHeader_ProductPOHeader1_idx` (`ProductPOHeader_productPOId` ASC),
  CONSTRAINT `fk_ProductSOHeader_ProductPOHeader1`
    FOREIGN KEY (`ProductPOHeader_productPOId`)
    REFERENCES `merlionLogisticDB`.`ProductPOHeader` (`productPOId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`ProductSOLineItem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`ProductSOLineItem` (
  `Product_productId` INT(11) NOT NULL,
  `ProductSOHeader_productSOId` INT(11) NOT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `quantity` INT(11) NULL DEFAULT NULL,
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
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`Staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`Staff` (
  `firstName` VARCHAR(45) NULL DEFAULT NULL,
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  `SystemUser_systemUserId` INT(11) NOT NULL,
  `UserGroup_groupId` INT(11) NOT NULL,
  PRIMARY KEY (`SystemUser_systemUserId`),
  INDEX `fk_Staff_SystemUser1_idx` (`SystemUser_systemUserId` ASC),
  INDEX `fk_Staff_UserGroup1_idx` (`UserGroup_groupId` ASC),
  CONSTRAINT `fk_Staff_SystemUser1`
    FOREIGN KEY (`SystemUser_systemUserId`)
    REFERENCES `merlionLogisticDB`.`SystemUser` (`systemUserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Staff_UserGroup1`
    FOREIGN KEY (`UserGroup_groupId`)
    REFERENCES `merlionLogisticDB`.`UserGroup` (`groupId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `merlionLogisticDB`.`SystemLog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `merlionLogisticDB`.`SystemLog` (
  `logId` INT(11) NOT NULL AUTO_INCREMENT,
  `logTime` TIMESTAMP NULL DEFAULT NULL,
  `action` VARCHAR(255) NULL DEFAULT NULL,
  `SystemUser_systemUserId` INT(11) NOT NULL,
  PRIMARY KEY (`logId`),
  INDEX `fk_SystemLog_SystemUser_idx` (`SystemUser_systemUserId` ASC),
  CONSTRAINT `fk_SystemLog_SystemUser`
    FOREIGN KEY (`SystemUser_systemUserId`)
    REFERENCES `merlionLogisticDB`.`SystemUser` (`systemUserId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
