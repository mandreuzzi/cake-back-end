-- -----------------------------------------------------
-- Schema cake-but-fake
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cake-repo`;

CREATE SCHEMA `cake-repo`;
USE `cake-repo` ;

-- -----------------------------------------------------
-- Table `cake-repo`.`DOLCI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cake-repo`.`DOLCI` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(255) DEFAULT NULL,
  `PREZZO` DECIMAL(13,2) DEFAULT NULL,
  `DESCRIZIONE` VARCHAR(255) DEFAULT NULL,
  `IMAGE_URL` VARCHAR(255) DEFAULT NULL,
  `IMAGE_NAME` VARCHAR(255) DEFAULT NULL,
  `SCADUTO` BIT DEFAULT 1,
  `UNITA_DISPONIBILI` INT(10) DEFAULT NULL,
  `DATA_CREAZIONE` DATETIME(6) DEFAULT NULL,
  `CALORIE` INT(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `cake-repo`.`INGREDIENTI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cake-repo`.`INGREDIENTI` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `NOME` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `cake-repo`.`DOLCI_INGREDIENTI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cake-repo`.`DOLCI_INGREDIENTI` (
  `DOLCE_ID` BIGINT(11) NOT NULL,
  `INGREDIENTE_ID` BIGINT(11) NOT NULL)
  ENGINE=InnoDB
  AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Add sample data DOLCI
-- -----------------------------------------------------

INSERT INTO DOLCI (NOME, PREZZO, DESCRIZIONE, IMAGE_URL, SCADUTO, UNITA_DISPONIBILI, CALORIE, DATA_CREAZIONE, IMAGE_NAME)
VALUES ('Tiramisù', 8.50 , 'Il tiramisù è sicuramente uno dei dessert più golosi e conosciuti al mondo.', 'http://localhost:8080/tiramisu.jpeg', 1, 10, 544, NOW(), 'tiramisu.jpeg');

INSERT INTO DOLCI (NOME, PREZZO, DESCRIZIONE, IMAGE_URL, SCADUTO, UNITA_DISPONIBILI, CALORIE, DATA_CREAZIONE, IMAGE_NAME)
VALUES ('Crepes alla nutella', 9.50 , 'Tentazione da gustare a merenda, per dessert o come spuntino di mezzanotte.', 'http://localhost:8080/crepes.jpeg', 1, 50, 285, NOW(), 'crepes.jpeg');

INSERT INTO DOLCI (NOME, PREZZO, DESCRIZIONE, IMAGE_URL, SCADUTO, UNITA_DISPONIBILI, CALORIE, DATA_CREAZIONE, IMAGE_NAME)
VALUES ('Cheese cake', 3.50 , 'Dolce americano preparato con una base di biscotti e una crema al formaggio cremoso.', 'http://localhost:8080/cheesecake.jpeg', 1, 30, 547, NOW(), 'cheesecake.jpeg');

INSERT INTO DOLCI (NOME, PREZZO, DESCRIZIONE, IMAGE_URL, SCADUTO, UNITA_DISPONIBILI, CALORIE, DATA_CREAZIONE, IMAGE_NAME)
VALUES ('Brownies', 4.50 , 'Dolcetti tipicamente americani realizzati con cioccolato fondente e nocciole.', 'http://localhost:8080/brownies.jpeg', 1, 100, 902, NOW(), 'brownies.jpeg');

INSERT INTO DOLCI (NOME, PREZZO, DESCRIZIONE, IMAGE_URL, SCADUTO, UNITA_DISPONIBILI, CALORIE, DATA_CREAZIONE, IMAGE_NAME)
VALUES ('Panna cotta', 4.00 , 'Dolce al cucchiaio delicato e gustoso di origine Piemontese.', 'http://localhost:8080/pannacotta.jpeg', 1, 15, 130, NOW(), 'pannacotta.jpeg');

INSERT INTO DOLCI (NOME, PREZZO, DESCRIZIONE, IMAGE_URL, SCADUTO, UNITA_DISPONIBILI, CALORIE, DATA_CREAZIONE, IMAGE_NAME)
VALUES ('Torta della nonna', 7.99 , 'Dolce classico, con frolla e crema pasticcera ricoperta di pinoli.', 'http://localhost:8080/tortanonna.jpeg', 1, 5, 613, NOW(), 'tortanonna.jpeg');


-- -----------------------------------------------------
-- Add sample data INGREDIENTI
-- -----------------------------------------------------
INSERT INTO INGREDIENTI (NOME) VALUES ('Savoiardi');
INSERT INTO INGREDIENTI (NOME) VALUES ('Mascarpone');
INSERT INTO INGREDIENTI (NOME) VALUES ('Caffè');
INSERT INTO INGREDIENTI (NOME) VALUES ('Uova');
INSERT INTO INGREDIENTI (NOME) VALUES ('Cacao in polvere');
INSERT INTO INGREDIENTI (NOME) VALUES ('Zucchero');
INSERT INTO INGREDIENTI (NOME) VALUES ('Zucchero a velo');
INSERT INTO INGREDIENTI (NOME) VALUES ('Farina 00');
INSERT INTO INGREDIENTI (NOME) VALUES ('Latte');
INSERT INTO INGREDIENTI (NOME) VALUES ('Burro');
INSERT INTO INGREDIENTI (NOME) VALUES ('Nutella');
INSERT INTO INGREDIENTI (NOME) VALUES ('Formaggio');
INSERT INTO INGREDIENTI (NOME) VALUES ('Biscotti');
INSERT INTO INGREDIENTI (NOME) VALUES ('Panna');
INSERT INTO INGREDIENTI (NOME) VALUES ('Vaniglia');
INSERT INTO INGREDIENTI (NOME) VALUES ('Amido di mais');
INSERT INTO INGREDIENTI (NOME) VALUES ('Menta');
INSERT INTO INGREDIENTI (NOME) VALUES ('Frutti di bosco');
INSERT INTO INGREDIENTI (NOME) VALUES ('Cioccolato');
INSERT INTO INGREDIENTI (NOME) VALUES ('Nocciole');
INSERT INTO INGREDIENTI (NOME) VALUES ('Sale');
INSERT INTO INGREDIENTI (NOME) VALUES ('Gelatina in fogli');
INSERT INTO INGREDIENTI (NOME) VALUES ('Biscotti Digestive');
INSERT INTO INGREDIENTI (NOME) VALUES ('Maizena');
INSERT INTO INGREDIENTI (NOME) VALUES ('Succo di limone');
INSERT INTO INGREDIENTI (NOME) VALUES ('Pinoli');
INSERT INTO INGREDIENTI (NOME) VALUES ('Scorza di limone');
INSERT INTO INGREDIENTI (NOME) VALUES ('Crema pasticcera');

-- -----------------------------------------------------
-- Add sample data DOLCI_INGREDIENTI
-- -----------------------------------------------------
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (1,1);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (1,2);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (1,3);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (1,4);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (1,5);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (1,6);

INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (2,4);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (2,9);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (2,8);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (2,10);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (2,11);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (2,7);

INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (3,12);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (3,14);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (3,6);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (3,4);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (3,25);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (3,15);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (3,18);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (3,17);

INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (4,19);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (4,4);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (4,20);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (4,10);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (4,6);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (4,21);

INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (5,14);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (5,15);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (5,6);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (5,22);

INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (6,8);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (6,10);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (6,6);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (6,4);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (6,27);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (6,28);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (6,26);
INSERT INTO DOLCI_INGREDIENTI (DOLCE_ID, INGREDIENTE_ID) VALUES (6,7);




