drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `cid` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) NULL DEFAULT NULL,
    `surname` VARCHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY (`cid`)
);
CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `iid` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) NULL DEFAULT NULL,
    `price` DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (`iid`)
);
CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `oid` INT(11) NOT NULL AUTO_INCREMENT,
    `quantity` INT NOT NULL,
    `cid`INT(11) NOT NULL,
    `iid` INT(11) NOT NULL,
    FOREIGN KEY (cid) REFERENCES ims.customers (cid)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (iid) REFERENCES ims.items (iid)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY (`oid`)
);


