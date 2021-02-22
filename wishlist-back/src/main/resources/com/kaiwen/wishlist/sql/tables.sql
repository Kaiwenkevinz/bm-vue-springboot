-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
                        `username` VARCHAR(255) DEFAULT NULL,
                        `password` VARCHAR(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for wish
-- ----------------------------
DROP TABLE IF EXISTS `wish`;
CREATE TABLE `wish` (
                        `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
                        `imgpath` VARCHAR(255) DEFAULT '',
                        `wishname` VARCHAR(255) DEFAULT NULL,
                        `date` VARCHAR(20) DEFAULT '',
                        `cid` INT(11) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `fk_wish_category_on_cid` (`cid`),
                        CONSTRAINT `fk_wish_category_on_cid` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wish
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
                            `id` INT(11) NOT NULL,
                            `name` VARCHAR(255) NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
