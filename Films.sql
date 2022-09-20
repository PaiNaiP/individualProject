-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Сен 20 2022 г., 23:57
-- Версия сервера: 5.7.39
-- Версия PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `Films`
--

-- --------------------------------------------------------

--
-- Структура таблицы `actors`
--

CREATE TABLE `actors` (
  `id` int(11) NOT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `surname` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `actors`
--

INSERT INTO `actors` (`id`, `lastname`, `name`, `surname`) VALUES
(5, 'ИВАН', 'Екатерина', 'Батыгина');

-- --------------------------------------------------------

--
-- Структура таблицы `agelimit`
--

CREATE TABLE `agelimit` (
  `id` int(11) NOT NULL,
  `agelimitrus` varchar(100) DEFAULT NULL,
  `agelimitusa` varchar(10000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `agelimit`
--

INSERT INTO `agelimit` (`id`, `agelimitrus`, `agelimitusa`) VALUES
(1, '16', 'R');

-- --------------------------------------------------------

--
-- Структура таблицы `checks`
--

CREATE TABLE `checks` (
  `id` int(11) NOT NULL,
  `dating` varchar(100) DEFAULT NULL,
  `ticketlenght` int(11) NOT NULL,
  `ticketss_id` int(11) DEFAULT NULL,
  `users_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `checks`
--

INSERT INTO `checks` (`id`, `dating`, `ticketlenght`, `ticketss_id`, `users_id`) VALUES
(8, '06.01.22', 2, 7, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `direct`
--

CREATE TABLE `direct` (
  `id` int(11) NOT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `surnamey` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `direct`
--

INSERT INTO `direct` (`id`, `lastname`, `name`, `surnamey`) VALUES
(6, 'ИВАН', 'Алексей', 'nnn');

-- --------------------------------------------------------

--
-- Структура таблицы `films`
--

CREATE TABLE `films` (
  `id` int(11) NOT NULL,
  `film` varchar(100) DEFAULT NULL,
  `studiay` varchar(100) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `year` varchar(100) DEFAULT NULL,
  `actorsy_id` int(11) DEFAULT NULL,
  `agelimity_id` int(11) DEFAULT NULL,
  `directy_id` int(11) DEFAULT NULL,
  `genresy_id` int(11) DEFAULT NULL,
  `tagsy_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `films`
--

INSERT INTO `films` (`id`, `film`, `studiay`, `title`, `year`, `actorsy_id`, `agelimity_id`, `directy_id`, `genresy_id`, `tagsy_id`) VALUES
(1, 'nnn', 'hhh', 'hhhhhh', '1999', 5, 1, 6, 2, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `genres`
--

CREATE TABLE `genres` (
  `id` int(11) NOT NULL,
  `genre_description` varchar(100) DEFAULT NULL,
  `genree` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `genres`
--

INSERT INTO `genres` (`id`, `genre_description`, `genree`) VALUES
(2, 'это фильм или телефильм, сценарий которого строго вдохновлен реальными событиями', 'h');

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(11);

-- --------------------------------------------------------

--
-- Структура таблицы `places`
--

CREATE TABLE `places` (
  `id` int(11) NOT NULL,
  `hall` int(11) NOT NULL,
  `place` int(11) NOT NULL,
  `row` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `places`
--

INSERT INTO `places` (`id`, `hall`, `place`, `row`) VALUES
(4, 2, 8, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `reviews`
--

CREATE TABLE `reviews` (
  `id` int(11) NOT NULL,
  `likes` int(11) NOT NULL,
  `review` varchar(10000) DEFAULT NULL,
  `titling` varchar(100) DEFAULT NULL,
  `filmss_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `reviews`
--

INSERT INTO `reviews` (`id`, `likes`, `review`, `titling`, `filmss_id`) VALUES
(9, 7, 'Херня', 'cool', 1),
(10, 8, 'Херня', 'no', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `tags`
--

CREATE TABLE `tags` (
  `id` int(11) NOT NULL,
  `tags_description` varchar(10000) DEFAULT NULL,
  `titlee` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `tags`
--

INSERT INTO `tags` (`id`, `tags_description`, `titlee`) VALUES
(3, 'Фильмы с Райаном Гослингом', 'hhh');

-- --------------------------------------------------------

--
-- Структура таблицы `tickets`
--

CREATE TABLE `tickets` (
  `id` int(11) NOT NULL,
  `date` varchar(100) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  `filmss_id` int(11) DEFAULT NULL,
  `placess_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `tickets`
--

INSERT INTO `tickets` (`id`, `date`, `time`, `filmss_id`, `placess_id`) VALUES
(7, '01.01.22', '14:00', 1, 4);

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `active` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `active`, `password`, `username`) VALUES
(1, b'1', '$2a$08$VqlKkEiJDdkn8SxPjxJD3.z5CkWZxhPwdeRAH1GShrZk6H2kM7CdO', '5');

-- --------------------------------------------------------

--
-- Структура таблицы `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `roles` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user_role`
--

INSERT INTO `user_role` (`user_id`, `roles`) VALUES
(1, 'USER');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `actors`
--
ALTER TABLE `actors`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `agelimit`
--
ALTER TABLE `agelimit`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `checks`
--
ALTER TABLE `checks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpcgulq57imjeu3sb4mvb1grvy` (`ticketss_id`),
  ADD KEY `FKa0chi8922h7gqli0s7r1ininm` (`users_id`);

--
-- Индексы таблицы `direct`
--
ALTER TABLE `direct`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `films`
--
ALTER TABLE `films`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa3hlnl56392y5kyo4fqqro69y` (`actorsy_id`),
  ADD KEY `FKo1o57fw1cldy1nc64cq9mx6ih` (`agelimity_id`),
  ADD KEY `FK14dj030e6j77doghw0ovvby4v` (`directy_id`),
  ADD KEY `FKj4pt8sl3jpvb2golff5pilw9m` (`genresy_id`),
  ADD KEY `FKsri1w9wcyiwmv9cnq38ola6de` (`tagsy_id`);

--
-- Индексы таблицы `genres`
--
ALTER TABLE `genres`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `places`
--
ALTER TABLE `places`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2onhxo5uu61yp3v6uovx593bl` (`filmss_id`);

--
-- Индексы таблицы `tags`
--
ALTER TABLE `tags`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKds8mbkyx3ucsp0qagwk2f2d5a` (`filmss_id`),
  ADD KEY `FKm2x3nqkn2er5iu6m9yc16qteo` (`placess_id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `films`
--
ALTER TABLE `films`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `checks`
--
ALTER TABLE `checks`
  ADD CONSTRAINT `FKa0chi8922h7gqli0s7r1ininm` FOREIGN KEY (`users_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKpcgulq57imjeu3sb4mvb1grvy` FOREIGN KEY (`ticketss_id`) REFERENCES `tickets` (`id`);

--
-- Ограничения внешнего ключа таблицы `films`
--
ALTER TABLE `films`
  ADD CONSTRAINT `FK14dj030e6j77doghw0ovvby4v` FOREIGN KEY (`directy_id`) REFERENCES `direct` (`id`),
  ADD CONSTRAINT `FKa3hlnl56392y5kyo4fqqro69y` FOREIGN KEY (`actorsy_id`) REFERENCES `actors` (`id`),
  ADD CONSTRAINT `FKj4pt8sl3jpvb2golff5pilw9m` FOREIGN KEY (`genresy_id`) REFERENCES `genres` (`id`),
  ADD CONSTRAINT `FKo1o57fw1cldy1nc64cq9mx6ih` FOREIGN KEY (`agelimity_id`) REFERENCES `agelimit` (`id`),
  ADD CONSTRAINT `FKsri1w9wcyiwmv9cnq38ola6de` FOREIGN KEY (`tagsy_id`) REFERENCES `tags` (`id`);

--
-- Ограничения внешнего ключа таблицы `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `FK2onhxo5uu61yp3v6uovx593bl` FOREIGN KEY (`filmss_id`) REFERENCES `films` (`id`);

--
-- Ограничения внешнего ключа таблицы `tickets`
--
ALTER TABLE `tickets`
  ADD CONSTRAINT `FKds8mbkyx3ucsp0qagwk2f2d5a` FOREIGN KEY (`filmss_id`) REFERENCES `films` (`id`),
  ADD CONSTRAINT `FKm2x3nqkn2er5iu6m9yc16qteo` FOREIGN KEY (`placess_id`) REFERENCES `places` (`id`);

--
-- Ограничения внешнего ключа таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
