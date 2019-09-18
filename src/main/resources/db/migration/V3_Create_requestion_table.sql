CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `description` text,
  `creat_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `comment_count` int(11) DEFAULT '0',
  `review_count` int(11) DEFAULT '0',
  `like_count` int(11) DEFAULT '0',
  `tag` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
)