create database if not exists `blog`;

CREATE TABLE `article`
(`id` int(11) NOT NULL,
`title` varchar(45) NOT NULL,
`content` varchar(45) DEFAULT NULL,
`genre` varchar(45) DEFAULT NULL,
`registration_time` date DEFAULT NULL,
PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=UTF8
