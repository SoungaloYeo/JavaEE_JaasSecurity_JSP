-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 27 Juin 2017 à 14:24
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxibanque`
--
CREATE DATABASE IF NOT EXISTS `proxibanque` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `proxibanque`;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `compteCourant_id` int(11) DEFAULT NULL,
  `compteEpargne_id` int(11) DEFAULT NULL,
  `conseiller_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id`, `adresse`, `email`, `nom`, `prenom`, `compteCourant_id`, `compteEpargne_id`, `conseiller_id`) VALUES
(1, 'bla', 'client@banque.com', 'Premier', 'Client', 2, 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `discriminant` varchar(31) NOT NULL,
  `id` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `solde` double DEFAULT NULL,
  `decouvertAutorise` double DEFAULT NULL,
  `tauxRemuneration` double DEFAULT NULL,
  `proprietaire_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`discriminant`, `id`, `numero`, `solde`, `decouvertAutorise`, `tauxRemuneration`, `proprietaire_id`) VALUES
('courant', 2, 1, 20000, 0, NULL, 1),
('epargne', 3, 2, 500, NULL, 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `conseiller`
--

CREATE TABLE `conseiller` (
  `id` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `motdepasse` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `conseiller`
--

INSERT INTO `conseiller` (`id`, `login`, `motdepasse`, `nom`, `prenom`) VALUES
(1, 'cr', 'cr', 'Roux', 'Clément');

-- --------------------------------------------------------

--
-- Structure de la table `conseiller_client`
--

CREATE TABLE `conseiller_client` (
  `Conseiller_id` int(11) NOT NULL,
  `listeClients_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `gerant`
--

CREATE TABLE `gerant` (
  `id` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `motdepasse` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `gerant`
--

INSERT INTO `gerant` (`id`, `login`, `motdepasse`, `nom`, `prenom`) VALUES
(0, 'gerant', 'gerant', 'Gerant', 'Mr');

-- --------------------------------------------------------

--
-- Structure de la table `gerant_conseiller`
--

CREATE TABLE `gerant_conseiller` (
  `Gerant_id` int(11) NOT NULL,
  `listeConseillers_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(4),
(4),
(4);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequences`
--

CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) NOT NULL,
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `hibernate_sequences`
--

INSERT INTO `hibernate_sequences` (`sequence_name`, `next_val`) VALUES
('default', 2);

-- --------------------------------------------------------

--
-- Structure de la table `virement`
--

CREATE TABLE `virement` (
  `id` int(11) NOT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `montant` double NOT NULL,
  `compteCrediteur_id` int(11) DEFAULT NULL,
  `compteDebiteur_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpbw7clvg5gis0jyi0ypsj7ba5` (`compteCourant_id`),
  ADD KEY `FKkjnbrudplworf5m15xwvr80hg` (`compteEpargne_id`),
  ADD KEY `FK6po1trkkux0kg3rxy49mo2adr` (`conseiller_id`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh9l5s97cmq9ivsjqvjns8spqa` (`proprietaire_id`);

--
-- Index pour la table `conseiller`
--
ALTER TABLE `conseiller`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6t18x41m1v16wp7wvk7dl9p5j` (`login`);

--
-- Index pour la table `conseiller_client`
--
ALTER TABLE `conseiller_client`
  ADD UNIQUE KEY `UK_qhk310x1sjac9rw4l0fk8p5sb` (`listeClients_id`),
  ADD KEY `FKr2moksgaj0gsvvue2lyxnwpu0` (`Conseiller_id`);

--
-- Index pour la table `gerant`
--
ALTER TABLE `gerant`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_p55ytx84x7kgdkenpqb7a3s3s` (`login`);

--
-- Index pour la table `gerant_conseiller`
--
ALTER TABLE `gerant_conseiller`
  ADD UNIQUE KEY `UK_pkygbfmxlxg7l8tgse6lfus0x` (`listeConseillers_id`),
  ADD KEY `FKxdrc13vhy5tsx2k5agwp1rxg` (`Gerant_id`);

--
-- Index pour la table `hibernate_sequences`
--
ALTER TABLE `hibernate_sequences`
  ADD PRIMARY KEY (`sequence_name`);

--
-- Index pour la table `virement`
--
ALTER TABLE `virement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6y5e9hir6f2xkijnowxagvtyv` (`compteCrediteur_id`),
  ADD KEY `FKq56l3g95oyjqangjkuvq40urt` (`compteDebiteur_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
