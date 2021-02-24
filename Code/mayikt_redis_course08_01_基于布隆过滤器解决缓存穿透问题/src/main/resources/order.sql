/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.28 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `order_number` (
	`id` int (11),
	`order_name` varchar (765),
	`order_status` int (11),
	`order_token` varchar (765),
	`order_id` varchar (765)
); 
insert into `order_number` (`id`, `order_name`, `order_status`, `order_token`, `order_id`) values('21','蚂蚁课堂永久会员','12','de293ead-7314-499d','1574167533250');
insert into `order_number` (`id`, `order_name`, `order_status`, `order_token`, `order_id`) values('22','蚂蚁课堂永久会员','2','228c2bff-3bd6-4ff0-bef3-e69793bab3b8','1614055667192');
insert into `order_number` (`id`, `order_name`, `order_status`, `order_token`, `order_id`) values('23','蚂蚁课堂永久会员','2','dd34f5a1-fd74-491c-bfef-fa5325558dcc','1614055759702');
