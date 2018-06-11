-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.21-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных news_database
DROP DATABASE IF EXISTS `news_database`;
CREATE DATABASE IF NOT EXISTS `news_database` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `news_database`;

-- Дамп структуры для таблица news_database.author
DROP TABLE IF EXISTS `author`;
CREATE TABLE IF NOT EXISTS `author` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_database.author: ~4 rows (приблизительно)
DELETE FROM `author`;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` (`id`, `name`) VALUES
	(1, 'Клейников С.Д.'),
	(2, 'Толстой Л.Н.'),
	(3, 'Пушкин А.С.'),
	(4, 'Иванов И.И.');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;

-- Дамп структуры для таблица news_database.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_database.category: ~3 rows (приблизительно)
DELETE FROM `category`;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `name`) VALUES
	(1, 'спорт'),
	(2, 'политика'),
	(3, 'музыка');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Дамп структуры для таблица news_database.news
DROP TABLE IF EXISTS `news`;
CREATE TABLE IF NOT EXISTS `news` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `date` datetime NOT NULL,
  `category` int(11) unsigned NOT NULL,
  `text` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_news_category` (`category`),
  CONSTRAINT `FK_news_category` FOREIGN KEY (`category`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_database.news: ~10 rows (приблизительно)
DELETE FROM `news`;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`id`, `title`, `date`, `category`, `text`) VALUES
	(1, 'Белорусские футболисты проиграли в товарищеском матче финнам', '2018-06-10 15:49:46', 1, 'Белорусы удачно начали год, обыграв в товарищеских матчах Азербайджан \r\nи Словению, а также сыграв вничью с крепкой сборной Венгрии.'),
	(2, 'Серена Уильямс снялась с Открытого чемпионата Франции', '2018-06-10 15:51:00', 1, 'Американская теннисистка Серена Уильямс снялась с матча 1/8 финала Roland Garros.\r\n Как пояснила теннисистка на специальной пресс-конференции, такое решение она\r\n приняла из-за травмы руки.В 1/8 финала Уильямс должна была встречаться с российской\r\n теннисисткой Марией Шараповой.'),
	(3, 'Серена Уильямс снялась с Открытого чемпионата Франции', '2018-06-10 15:51:00', 1, 'Американская теннисистка Серена Уильямс снялась с матча 1/8 финала Roland Garros.\r\n Как пояснила теннисистка на специальной пресс-конференции, такое решение она \r\nприняла из-за травмы руки.В 1/8 финала Уильямс должна была встречаться с российской\r\n теннисисткой Марией Шараповой.'),
	(4, 'Серена Уильямс снялась с Открытого чемпионата Франции', '2018-06-10 15:51:00', 1, 'Американская теннисистка Серена Уильямс снялась с матча 1/8 финала Roland Garros.\r\n Как пояснила теннисистка на специальной пресс-конференции, такое решение она \r\nприняла из-за травмы руки.В 1/8 финала Уильямс должна была встречаться с российской\r\n теннисисткой Марией Шараповой.'),
	(5, 'Серена Уильямс снялась с Открытого чемпионата Франции', '2018-06-10 15:51:00', 1, 'Американская теннисистка Серена Уильямс снялась с матча 1/8 финала Roland Garros.\r\n Как пояснила теннисистка на специальной пресс-конференции, такое решение она \r\nприняла из-за травмы руки.В 1/8 финала Уильямс должна была встречаться с российской\r\n теннисисткой Марией Шараповой.'),
	(6, 'Серена Уильямс снялась с Открытого чемпионата Франции', '2018-06-10 15:51:00', 1, 'Американская теннисистка Серена Уильямс снялась с матча 1/8 финала Roland Garros.\r\n Как пояснила теннисистка на специальной пресс-конференции, такое решение она \r\nприняла из-за травмы руки.В 1/8 финала Уильямс должна была встречаться с российской\r\n теннисисткой Марией Шараповой.'),
	(7, 'Серена Уильямс снялась с Открытого чемпионата Франции', '2018-06-10 15:51:00', 1, 'Американская теннисистка Серена Уильямс снялась с матча 1/8 финала Roland Garros.\r\n Как пояснила теннисистка на специальной пресс-конференции, такое решение она \r\nприняла из-за травмы руки.В 1/8 финала Уильямс должна была встречаться с российской\r\n теннисисткой Марией Шараповой.'),
	(8, 'Серена Уильямс снялась с Открытого чемпионата Франции', '2018-06-10 15:51:00', 1, 'Американская теннисистка Серена Уильямс снялась с матча 1/8 финала Roland Garros.'),
	(9, 'Серена Уильямс снялась с Открытого чемпионата Франции', '2018-06-10 15:51:00', 1, 'Американская теннисистка Серена Уильямс снялась с матча 1/8 финала Roland Garros.');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;

-- Дамп структуры для таблица news_database.news_author
DROP TABLE IF EXISTS `news_author`;
CREATE TABLE IF NOT EXISTS `news_author` (
  `news_id` int(11) unsigned NOT NULL,
  `author_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`news_id`,`author_id`),
  KEY `FK_news_author_author` (`author_id`),
  CONSTRAINT `FK_news_author_author` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_news_author_news` FOREIGN KEY (`news_id`) REFERENCES `news` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_database.news_author: ~18 rows (приблизительно)
DELETE FROM `news_author`;
/*!40000 ALTER TABLE `news_author` DISABLE KEYS */;
INSERT INTO `news_author` (`news_id`, `author_id`) VALUES
	(1, 1),
	(2, 1),
	(3, 1),
	(5, 1),
	(7, 1),
	(8, 1),
	(9, 1),
	(4, 2),
	(6, 2),
	(7, 2),
	(8, 2),
	(3, 3),
	(2, 4),
	(3, 4),
	(5, 4),
	(6, 4),
	(7, 4);
/*!40000 ALTER TABLE `news_author` ENABLE KEYS */;

-- Дамп структуры для таблица news_database.news_tag
DROP TABLE IF EXISTS `news_tag`;
CREATE TABLE IF NOT EXISTS `news_tag` (
  `news_id` int(11) unsigned NOT NULL,
  `tag_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`news_id`,`tag_id`),
  KEY `FK_news_tag_tag` (`tag_id`),
  CONSTRAINT `FK_news_tag_news` FOREIGN KEY (`news_id`) REFERENCES `news` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_news_tag_tag` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_database.news_tag: ~20 rows (приблизительно)
DELETE FROM `news_tag`;
/*!40000 ALTER TABLE `news_tag` DISABLE KEYS */;
INSERT INTO `news_tag` (`news_id`, `tag_id`) VALUES
	(2, 2),
	(3, 2),
	(4, 2),
	(5, 2),
	(6, 2),
	(7, 2),
	(8, 2),
	(9, 2),
	(1, 3),
	(1, 4),
	(4, 4),
	(2, 5),
	(3, 5),
	(5, 5),
	(6, 5),
	(7, 5),
	(8, 5),
	(9, 5);
/*!40000 ALTER TABLE `news_tag` ENABLE KEYS */;

-- Дамп структуры для таблица news_database.tag
DROP TABLE IF EXISTS `tag`;
CREATE TABLE IF NOT EXISTS `tag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы news_database.tag: ~5 rows (приблизительно)
DELETE FROM `tag`;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` (`id`, `name`) VALUES
	(1, 'футбол'),
	(2, 'теннис'),
	(3, 'спорт'),
	(4, 'беларусь'),
	(5, 'отдых');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
