CREATE DATABASE nebular CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `nebular`.`user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `middleName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


CREATE TABLE nebular.`role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `nebular`.`user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_role_roleid_idx` (`role_id`),
  CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `nebular`.role (id,name) values (1,"admin");
INSERT INTO `nebular`.user (id,username,password,firstName,middleName,lastName) values (1,"prasadprabha07@gmail.com","$2a$10$kIlPYtjii941JR.sXfFRnO0WjkM8VQwcfZziWunKqX.ZzdJH9EpBi","Prasad","Prabha","Suseela");
INSERT INTO `nebular`.user_role (user_id,role_id) values (1,1);