-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 01 juin 2021 à 17:58
-- Version du serveur :  5.7.17
-- Version de PHP :  7.1.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestionassociation`
--

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

CREATE TABLE `comment` (
  `idComment` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `upvoteNumber` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `comment`
--

INSERT INTO `comment` (`idComment`, `content`, `date`, `upvoteNumber`) VALUES
(1, 'C\'est un super site et un super club. Je vais aller m\'inscrire pour aller aux JO !', '2021-05-28', 2),
(2, 'J\'ai vraiment progressé dans ce club et j\'ai remporté plusieurs médaille aux JO ', '2021-05-28', 3),
(3, 'Je ne connaissais pas ce club avant mais à présent je vais aller m\'inscrire pour devenir un champion', '2021-05-28', 0),
(4, 'Je passe mon temps à nager. Mon excuse préférée: je ne peux pas j\'ai piscine', '2021-05-28', 1);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `pseudo` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `address`, `firstname`, `mail`, `name`, `password`, `pseudo`) VALUES
(1, '8 rue de la Piscine', 'Laure', 'laureManaudou@gmail.com', 'Manaudou', '$2a$10$feg88iMu7wwmd7PuALItWOjoepv9hly9groNY9zO/GrJqW/Vtja12', 'Lanageuse'),
(2, '5 rue des JO 11100 Narbonne', 'Camille', 'camilleLacourt@gmail.com', 'Lacourt', '$2a$10$ZWBX2Py88aW0BpEnEvgw5.bigFMIuMJPFNdVzI5Cm8MU5mMZgOa4i', 'CL'),
(3, '11 Avenue du Tremblay 75012 Paris', 'Florent', 'Florent.Manaudou@gmail.com', 'Manaudou', '$2a$10$92/M/y3cBb16QvGZJsyiw.rMZWUhGbFno0rbBowXkl1iTz.pRXjCq', 'FloM'),
(4, '4 rue de la victoire 75 500 Paris', 'Michael', 'Michael.Phelps@gmail.com', 'Phelps', '$2a$10$nWzPuFraj0kBLktuIXEVIePw7Em0qbT8eAy5petoIIORzB4n8A0vy', 'LeRequin'),
(5, '7 allee guy charff', 'sean', 'seananica1@gmail.com', 'anica', '$2a$10$1YEFZrxoYO.R7MYqJ1KjBe/ntIgWkC3.t8/a7SeTD.PxaLeG/dSku', 'sean'),
(6, 'l\'adresse de MylÃ¨ne Micoton', 'Mylene', 'MyleneMicoton@gmail.com', 'Micoton', '$2a$10$MSCQNrNE/tBZp68HeO16ZOlNbxWojyUw0xSDT3Jxv/P.8YN5.zjkC', 'mylene');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`idComment`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `comment`
--
ALTER TABLE `comment`
  MODIFY `idComment` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
