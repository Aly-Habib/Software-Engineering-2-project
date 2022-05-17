DROP DATABASE IF EXISTS swe2;
create database swe2;

CREATE TABLE `swe2`.`employee` (
    `id` INT NOT NULL,
    `fName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `userName` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `age` INT NOT NULL,
    `salary` INT NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `swe2`.`teamleader` (
    `id` INT NOT NULL,
    `fName` VARCHAR(45) NOT NULL,
    `lastName` VARCHAR(45) NOT NULL,
    `userName` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `age` INT NOT NULL,
    `salary` INT NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `swe2`.`task` (
    `id` INT NOT NULL,
    `title` VARCHAR(30),
    `assignEmp` INT NOT NULL,
    `Description` LONGTEXT NOT NULL,
    `fromTime` VARCHAR(20),
    `toTime` VARCHAR(20),
    `taskPhase` VARCHAR(20),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`assignEmp`)
        REFERENCES `swe2`.`employee` (`id`)
);



