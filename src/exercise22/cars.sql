-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Авг 13 2022 г., 00:47
-- Версия сервера: 5.6.38
-- Версия PHP: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `cars`
--

-- --------------------------------------------------------

--
-- Структура таблицы `marki`
--

CREATE TABLE `marki` (
  `id` int(11) NOT NULL,
  `marka` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `marki`
--

INSERT INTO `marki` (`id`, `marka`) VALUES
(1, 'Ауди'),
(2, 'БМВ'),
(3, 'VW'),
(4, 'Skoda');

-- --------------------------------------------------------

--
-- Структура таблицы `models`
--

CREATE TABLE `models` (
  `id_model` int(11) NOT NULL,
  `title` varchar(10) NOT NULL,
  `id_mark` int(11) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `price` decimal(15,2) NOT NULL,
  `weight` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `models`
--

INSERT INTO `models` (`id_model`, `title`, `id_mark`, `description`, `price`, `weight`) VALUES
(1, 'А4', 1, 'Машина #1', '123123.00', 213),
(2, 'А6', 1, 'Машина #2', '234234.00', 123),
(3, 'Q5', 1, 'Машина #3', '235423.00', 342),
(4, 'X5', 2, 'Машина #4', '453.00', 234),
(5, 'x2', 2, 'Машина #5', '456456.00', 234),
(6, 'Polo', 3, 'Машина #6', '345.00', 345),
(7, 'Passat', 3, 'Машина #7', '345.00', 345),
(8, 'Oktavia', 4, 'Машина #8', '456546.00', 345),
(9, 'Superb', 4, 'Машина #9', '456.00', 345);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `marki`
--
ALTER TABLE `marki`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `models`
--
ALTER TABLE `models`
  ADD PRIMARY KEY (`id_model`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `marki`
--
ALTER TABLE `marki`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `models`
--
ALTER TABLE `models`
  MODIFY `id_model` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
