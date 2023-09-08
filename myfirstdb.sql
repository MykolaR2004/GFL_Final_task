-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Сен 08 2023 г., 15:52
-- Версия сервера: 10.4.28-MariaDB
-- Версия PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `myfirstdb`
--

-- --------------------------------------------------------

--
-- Структура таблицы `archive`
--

CREATE TABLE `archive` (
  `id` int(11) NOT NULL,
  `pair` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `archive`
--

INSERT INTO `archive` (`id`, `pair`) VALUES
(9, 'Oliver Jones and Joseph Garcia'),
(10, 'Joel Davis and Emma Singh'),
(11, 'Jane Wilson and Jane Wilson'),
(12, 'Oliver Jones and Joseph Garcia');

-- --------------------------------------------------------

--
-- Структура таблицы `dating_agency`
--

CREATE TABLE `dating_agency` (
  `registration_number` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `surname` varchar(40) NOT NULL,
  `about_yourself` longtext DEFAULT NULL,
  `partner_requirements` longtext DEFAULT NULL,
  `sex` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `dating_agency`
--

INSERT INTO `dating_agency` (`registration_number`, `name`, `surname`, `about_yourself`, `partner_requirements`, `sex`) VALUES
(1, 'Jane', 'Wilson', 'Clever', 'Curious', 'female'),
(2, 'James', 'Smith', 'Pretty', 'Clever, Talkative', 'male'),
(3, 'Emily', 'Brown', 'Pretty', 'Curious', 'female'),
(4, 'Joel', 'Davis', 'Patient, Reliable', 'Creative, Charismatic', 'male'),
(5, 'Emily', 'Evans', 'Curious, Humorous', 'Talkative, Energetic', 'female'),
(6, 'Ava', 'Walsh', 'Pretty', 'Clever, Talkative, Curious', 'female'),
(7, 'George', 'O\'Brien', 'Enthusiastic', 'Humorous, Talkative', 'male'),
(8, 'Abigail', 'Anderson', 'Caring', 'Clever', 'female'),
(9, 'Ethan', 'Taylor', 'Patient, Reliable', 'Clever, Talkative', 'male'),
(10, 'Emma', 'Singh', 'Curious, Clever', 'Caring', 'female'),
(11, 'Oliver', 'Jones', 'Curious, Talkative', 'Humorous', 'male'),
(12, 'Joseph', 'Garcia', 'Pretty, Caring', 'Talkative', 'male'),
(13, 'Jessica', 'Gelbero', 'Clever, Caring', 'Curious, Energetic', 'female'),
(14, 'Michelle', 'Byrne', 'Curious, Clever', 'Clever, Talkative', 'female'),
(15, 'Amelia', 'Williams', 'Ambitious, Enthusiastic', 'Curious, Talkative', 'female'),
(16, 'Michelle', 'Garcia', 'Funny', 'Clever', 'male'),
(18, 'Ethan', 'Brown', 'Clever', 'Clever, Talkative', 'male'),
(19, 'Jessica', 'Brown', 'Clever', 'Funny', 'female'),
(21, 'Michelle', 'Фамилия', 'Funny', 'Clever, Talkative', 'male');

-- --------------------------------------------------------

--
-- Структура таблицы `dating_table`
--

CREATE TABLE `dating_table` (
  `id` int(11) NOT NULL,
  `first_person_id` int(11) NOT NULL,
  `first_person` text NOT NULL,
  `second_person_id` int(11) NOT NULL,
  `second_person` text NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `dating_table`
--

INSERT INTO `dating_table` (`id`, `first_person_id`, `first_person`, `second_person_id`, `second_person`, `time`) VALUES
(7, 4, 'Joel Davis', 10, 'Emma Singh', '2020-09-06 00:00:00'),
(8, 2, 'James Smith', 9, 'Ethan Taylor', '2020-09-06 00:00:00'),
(9, 1, 'Jane Wilson', 2, 'James Smith', '2020-09-06 00:00:00'),
(10, 11, 'Oliver Jones', 12, 'Joseph Garcia', '2022-09-07 00:00:00'),
(13, 1, 'Jane Wilson', 10, 'Emma Singh', '2023-09-08 16:54:00');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `archive`
--
ALTER TABLE `archive`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `dating_agency`
--
ALTER TABLE `dating_agency`
  ADD PRIMARY KEY (`registration_number`);

--
-- Индексы таблицы `dating_table`
--
ALTER TABLE `dating_table`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `archive`
--
ALTER TABLE `archive`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT для таблицы `dating_agency`
--
ALTER TABLE `dating_agency`
  MODIFY `registration_number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT для таблицы `dating_table`
--
ALTER TABLE `dating_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
