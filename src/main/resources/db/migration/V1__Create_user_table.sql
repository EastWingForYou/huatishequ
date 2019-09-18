CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `token` char(36) DEFAULT NULL,
  `creat_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
)