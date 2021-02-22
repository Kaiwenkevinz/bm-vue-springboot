
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
                        `username` VARCHAR(255) DEFAULT NULL,
                        `password` VARCHAR(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
                        `id` INT(11) NOT NULL AUTO_INCREMENT,
                        `coverPath` VARCHAR(255) DEFAULT '',
                        `title` VARCHAR(255) NOT NULL DEFAULT '',
                        `author` VARCHAR(255) DEFAULT '',
                        `date` VARCHAR(20) DEFAULT '',
                        `press` VARCHAR(255) DEFAULT '',
                        `abs` VARCHAR(255) DEFAULT NULL,
                        `cid` INT(11) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `fk_book_category_on_cid` (`cid`),
                        CONSTRAINT `fk_book_category_on_cid` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=INNODB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
                            `id` INT(11) NOT NULL,
                            `name` VARCHAR(255) NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
