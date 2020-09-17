INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan2', 'harrison');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('gamer', 'nation');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('post', 'malone');
INSERT INTO `ims`.`items` (`name`, `price`) VALUES ('book', 6.99);
INSERT INTO `ims`.`items` (`name`, `price`) VALUES ('dvd', 9.99);
INSERT INTO `ims`.`items` (`name`, `price`) VALUES ('bluray', 19.99);
INSERT INTO `ims`.`orders` (`cid`) VALUES (1);
INSERT INTO `ims`.`orders` (`cid`) VALUES (2);
INSERT INTO `ims`.`orderline` (`oid`,`iid`,`quantity`) VALUES (1,1,1);
INSERT INTO `ims`.`orderline` (`oid`,`iid`,`quantity`) VALUES (2,3,10);
INSERT INTO `ims`.`orderline` (`oid`,`iid`,`quantity`) VALUES (1,2,10);

