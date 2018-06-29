-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 26, 2018 at 02:18 PM
-- Server version: 5.7.19-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proxibanque_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `code_client` varchar(15) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `adresse` varchar(20) NOT NULL,
  `code_gestionnaire` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id`, `code_client`, `nom`, `prenom`, `email`, `adresse`, `code_gestionnaire`) VALUES
(1, 'PB-CLI-0001', 'TEST', 'Adolph', 'test@test', 'BP14 ABEN 08', 'PB-GEST-001'),
(2, 'PB-CLI-0002', 'BADJO', 'AMANI CHARLE', 'badjoamanicharle@yahoo.fr', 'BP 00 BKE 02', 'PB-GEST-002'),
(3, 'PB-CLI-0003', 'LOBO LOBO', 'ARISTIDE GOHOU', 'lobolobo@yahoo.fr', 'BP 00 BKE 02', 'PB-GEST-001'),
(4, 'PB-CLI-0004', 'GBANE', 'KOUDOU ROMARIC', 'gbanekou@gmail.com', 'BP 00 BKE 02', 'PB-GEST-003'),
(5, 'PB-CLI-0005', 'KONE', 'PARADJOGO', 'koneparadjogo@yahoo.fr', 'BP 00 BKE 02', 'PB-GEST-002'),
(6, 'PB-CLI-0006', 'OFFOUMOU', 'MAFOUE AHOU G', 'offoumou@gmail.com', 'BP 00 BKE 02', 'PB-GEST-001'),
(7, 'PB-CLI-0007', 'ZAPKA', 'TRABI LOU', 'zapka@yahoo.fr', 'BP 00 BKE 02', 'PB-GEST-002'),
(8, 'PB-CLI-0008', 'GNIZAKO GNIZAKO ', 'JEANNE ELODIE', 'gnizakojeanne@gmail.com', 'BP 00 BKE 02', 'PB-GEST-001'),
(9, 'PB-CLI-0009', 'ZADI', 'ZAOULI', 'zaouli@yahoo.fr', 'BP 00 BKE 02', 'PB-GEST-002'),
(10, 'PB-CLI-00010', 'KONAN', 'KOUADIO KAN ', 'konan@gmail.com', 'BP 00 BKE 02', 'PB-GEST-001'),
(11, 'PB-CLI-00011', 'BAKAYOKO', 'ABDOULAYE', 'ablo@gmail.com', 'BP 10 BKE 05', 'PB-GEST-002'),
(12, 'PB-CLI-00012', 'APOTCHI', 'MAHO', 'maho@gmail.com', 'BP 10 abj 01', 'PB-GEST-001'),
(13, 'PB-CLI-00013', 'IVANNE', 'ANGE', 'ange@yahoo.fr', 'BP 08 AGBO 01', 'PB-GEST-001'),
(14, 'PB-CLI-00014', 'N\'GANAN', 'DIABATE', 'diabate@yahoo.fr', 'BP 04 KGO 02', 'PB-GEST-001'),
(15, 'PB-CLI-00015', 'KABA', 'FRANCIS', 'kaba@gmail.com', 'BP 05 MAN 02', 'PB-GEST-001'),
(16, 'PB-CLI-00016', 'AYELO AYELO', 'OFFO OFFO', 'ayelooffo@gmail.com', 'BP 05 KGO 02', 'PB-GEST-001'),
(17, 'PB-CLI-00017', 'GNAORE', 'GAGOU', 'kaba@gmail.com', 'BP 05 MAN 02', 'PB-GEST-001'),
(18, 'PB-CLI-00018', 'KODJA', 'MARUIS', 'maruis@hotmail.com', 'BP 18 DAB 01', 'PB-GEST-001'),
(19, 'PB-CLI-00019', 'KATONGO', 'VAMISSA', 'vame@yahoo.fr', 'BP 04 YAKRO 02', 'PB-GEST-001'),
(20, 'PB-CLI-00020', 'N\'GUESSAN', 'NOELY', 'noely@gmail.com', 'BP 10 ABJ 01', 'PB-GEST-002'),
(21, 'PB-CLI-00021', 'KOFFI', 'EBOUE', 'koffi@gmail.com', 'BP 10 ABJ 01', 'PB-GEST-002'),
(22, 'PB-CLI-00022', 'DIDIER', 'JEAN JACQUE', 'didier@gmail.com', 'BP 10 ABJ 01', 'PB-GEST-002'),
(23, 'PB-CLI-00023', 'GAGOU', 'BLE', 'ble@yahoo.com', 'BP 18 DAB 01', 'PB-GEST-002'),
(24, 'PB-CLI-00024', 'YEO', 'SOUNGALO', 'yeo@gmail.com', 'BP 10 YOP 01', 'PB-GEST-002'),
(25, 'PB-CLI-00025', 'YAO', 'KOUASSI', 'yaokouassi@gmail.com', 'BP 10 BKE 05', 'PB-GEST-003'),
(26, 'PB-CLI-00026', 'ANNAISE', 'MARIE', 'anaise@gmail.com', 'BP 10 abj 01', 'PB-GEST-001'),
(27, 'PB-CLI-00027', 'YADJOGO', 'KARTOUM', 'kartoum@gmail.com', 'BP 05 KGO 02', 'PB-GEST-001'),
(28, 'PB-CLI-00028', 'KOUADIO', 'KOUAME', 'kouame@gmail.com', 'BP 05 KGO 02', 'PB-GEST-001'),
(29, 'PB-CLI-00029', 'YADJOGO', 'KARTOUM', 'kartoum@gmail.com', 'BP 05 KGO 02', 'PB-GEST-001'),
(30, 'PB-CLI-00030', 'KACOU', 'THIERRY', 'kacou@gmail.com', 'BP 10 abj 01', 'PB-GEST-001'),
(33, 'PB-CLI-00031', 'TEST', 'TEST TEST', 'test@test', 'BP14 ABEN 05', 'PB-GEST-002'),
(35, 'PB-CLI-00032', 'TEST', 'TEST TEST', 'test@test', 'BP14 ABEN 05', 'PB-GEST-002'),
(36, 'PB-CLI-00033', 'TEST', 'TEST TEST', 'test@test', 'BP14 ABEN 05', 'PB-GEST-003'),
(38, 'PB-CLI-00034', 'TEST', 'TEST TEST', 'test@test', 'BP14 ABEN 05', 'PB-GEST-003'),
(39, 'PB-CLI-00035', 'Koassi', 'Kouakou', 'kouakou@gmail.com', '15 BP 12', 'PB-GEST-001');

-- --------------------------------------------------------

--
-- Table structure for table `compte_courant`
--

CREATE TABLE `compte_courant` (
  `id` int(6) NOT NULL,
  `num_compte` varchar(15) NOT NULL,
  `solde_compte` double NOT NULL,
  `code_client` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `compte_courant`
--

INSERT INTO `compte_courant` (`id`, `num_compte`, `solde_compte`, `code_client`) VALUES
(1, 'PB-CC-0001', 2000000, 'PB-CLI-0005'),
(2, 'PB-CC-0002', 1400000, 'PB-CLI-0008'),
(3, 'PB-CC-0003', 4649700, 'PB-CLI-0001'),
(4, 'PB-CC-0004', 3500500, 'PB-CLI-00010'),
(5, 'PB-CC-0005', 1850000, 'PB-CLI-0004'),
(6, 'PB-CC-0006', 2550500, 'PB-CLI-0002'),
(7, 'PB-CC-0007', 700000, 'PB-CLI-0006'),
(8, 'PB-CC-0008', 4950000, 'PB-CLI-0009'),
(9, 'PB-CC-0009', 1410750, 'PB-CLI-0007'),
(10, 'PB-CC-00010', 250000, 'PB-CLI-0003'),
(13, 'PB-CC-00011', 349250, 'PB-CLI-00010'),
(20, 'PB-CC-00012', 1119425, 'PB-CLI-0003'),
(21, 'PB-CC-00013', 889000, 'PB-CLI-00011'),
(25, 'PB-CC-00014', 900300, 'PB-CLI-00012'),
(26, 'PB-CC-00015', 255690, 'PB-CLI-00013'),
(27, 'PB-CC-00016', 770880, 'PB-CLI-00014'),
(28, 'PB-CC-00017', 248090, 'PB-CLI-00015'),
(29, 'PB-CC-00018', 248090, 'PB-CLI-00016'),
(30, 'PB-CC-00019', 248190, 'PB-CLI-00017'),
(31, 'PB-CC-00020', 250000, 'PB-CLI-00018'),
(32, 'PB-CC-00021', 1770830, 'PB-CLI-00019'),
(33, 'PB-CC-00022', 9080700, 'PB-CLI-00020'),
(34, 'PB-CC-00023', 9080700, 'PB-CLI-00021'),
(35, 'PB-CC-00024', 9080700, 'PB-CLI-00022'),
(36, 'PB-CC-00025', 500700, 'PB-CLI-00023'),
(37, 'PB-CC-00026', 9042250, 'PB-CLI-00024'),
(38, 'PB-CC-00027', 555000, 'PB-CLI-00025'),
(39, 'PB-CC-00028', 1, 'PB-CLI-00026'),
(40, 'PB-CC-00029', 3900800, 'PB-CLI-00027'),
(41, 'PB-CC-00030', 4000800, 'PB-CLI-00028'),
(42, 'PB-CC-00031', 4000800, 'PB-CLI-00029'),
(43, 'PB-CC-00032', 140000, 'PB-CLI-00030'),
(44, 'PB-CC-00033', 0, 'PB-CLI-00035');

-- --------------------------------------------------------

--
-- Table structure for table `compte_epargne`
--

CREATE TABLE `compte_epargne` (
  `id` int(6) NOT NULL,
  `num_compte` varchar(15) NOT NULL,
  `solde_compte` double NOT NULL,
  `code_client` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `compte_epargne`
--

INSERT INTO `compte_epargne` (`id`, `num_compte`, `solde_compte`, `code_client`) VALUES
(1, 'PB-CE-0001', 5010000, 'PB-CLI-0001'),
(2, 'PB-CE-0002', 1100000, 'PB-CLI-00010'),
(3, 'PB-CE-0003', 2005270, 'PB-CLI-0005'),
(4, 'PB-CE-0004', 1850100, 'PB-CLI-0002'),
(5, 'PB-CE-0005', 3010000, 'PB-CLI-0006'),
(6, 'PB-CE-0006', 7163155, 'PB-CLI-0008'),
(7, 'PB-CE-0007', 3104540, 'PB-CLI-0004'),
(8, 'PB-CE-0008', 6600500, 'PB-CLI-0007'),
(9, 'PB-CE-0009', 4120300, 'PB-CLI-0009'),
(10, 'PB-CE-00010', 3029630, 'PB-CLI-0003'),
(11, 'PB-CE-00011', 4120350, 'PB-CLI-0009'),
(12, 'PB-CE-00012', 3010010, 'PB-CLI-0006'),
(13, 'PB-CE-00013', 5019000, 'PB-CLI-0001'),
(14, 'PB-CE-00014', 3229500, 'PB-CLI-0003'),
(15, 'PB-CE-00015', 3108500, 'PB-CLI-0004'),
(16, 'PB-CE-00016', 1044800, 'PB-CLI-00010'),
(17, 'PB-CE-00017', 1750000, 'PB-CLI-0002'),
(18, 'PB-CE-00018', 5800900, 'PB-CLI-0005'),
(19, 'PB-CE-00019', 8162500, 'PB-CLI-0008'),
(20, 'PB-CE-00020', 1750000, 'PB-CLI-0002'),
(23, 'PB-CE-00021', 1000000, 'PB-CLI-00010'),
(30, 'PB-CE-00022', 5484100, 'PB-CLI-0002'),
(31, 'PB-CE-00023', 5402010, 'PB-CLI-00011'),
(35, 'PB-CE-00024', 1080100, 'PB-CLI-00012'),
(36, 'PB-CE-00025', 2515080, 'PB-CLI-00013'),
(37, 'PB-CE-00026', 310200, 'PB-CLI-00014'),
(38, 'PB-CE-00027', 580010, 'PB-CLI-00015'),
(39, 'PB-CE-00028', 580010, 'PB-CLI-00016'),
(40, 'PB-CE-00029', 580010, 'PB-CLI-00017'),
(41, 'PB-CE-00030', 35990, 'PB-CLI-00018'),
(42, 'PB-CE-00031', 2580010, 'PB-CLI-00019'),
(43, 'PB-CE-00032', 2500200, 'PB-CLI-00020'),
(44, 'PB-CE-00033', 7500200, 'PB-CLI-00021'),
(45, 'PB-CE-00034', 7180200, 'PB-CLI-00022'),
(46, 'PB-CE-00035', 1400000, 'PB-CLI-00023'),
(47, 'PB-CE-00036', 8580500, 'PB-CLI-00024'),
(48, 'PB-CE-00037', 36000, 'PB-CLI-00025'),
(49, 'PB-CE-00038', 4590200, 'PB-CLI-00027'),
(50, 'PB-CE-00039', 4590200, 'PB-CLI-00028'),
(51, 'PB-CE-00040', 4590200, 'PB-CLI-00029'),
(52, 'PB-CE-00041', 850000, 'PB-CLI-00030'),
(53, 'PB-CE-00042', 500000, 'PB-CLI-00035');

-- --------------------------------------------------------

--
-- Table structure for table `gestionnaire`
--

CREATE TABLE `gestionnaire` (
  `id` int(11) NOT NULL,
  `code_gestionnaire` varchar(15) NOT NULL,
  `nom` varchar(15) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `adresse` varchar(20) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gestionnaire`
--

INSERT INTO `gestionnaire` (`id`, `code_gestionnaire`, `nom`, `prenom`, `email`, `adresse`, `login`, `password`) VALUES
(1, 'PB-GEST-001', 'YEO', 'SGLO', 'yeosoungalo@yahoo.fr', 'BP 00 ABJ 01', 'yeo', 'yeoyeo'),
(2, 'PB-GEST-002', 'ACHI', 'CEDRIC', 'blay12cedric@gmail.com', 'BP 00 ABJ 01', 'achi', 'achiachi'),
(3, 'PB-GEST-003', 'YAO', 'KOUASSI', 'yaokouassi@yahoo.fr', 'BP 00 ABJ 01', 'yao', 'yaoyao');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `login` varchar(15) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`login`, `role`) VALUES
('yeo', 'gestionnaire'),
('yao', 'gestionnaire'),
('achi', 'gestionnaire');

-- --------------------------------------------------------

--
-- Table structure for table `virement`
--

CREATE TABLE `virement` (
  `id` int(5) NOT NULL,
  `code_virement` varchar(40) NOT NULL,
  `montant` double NOT NULL,
  `num_compte_e` varchar(15) NOT NULL,
  `num_compte_b` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `virement`
--

INSERT INTO `virement` (`id`, `code_virement`, `montant`, `num_compte_e`, `num_compte_b`) VALUES
(5, '14/07/2016-12:40:00', 55000, 'PB-CE-00016', 'PB-CC-00027'),
(6, '14/07/2016-12:44:00', 500, 'PB-CC-00014', 'PB-CC-00025'),
(7, '14/07/2016-03:05:29', 40, 'PB-CE-0001', 'PB-CE-0007'),
(8, '14/07/2016-05:43:10', 50, 'PB-CE-00010', 'PB-CE-00011'),
(9, '14/07/2016-10:50:53', 10000, 'PB-CE-0001', 'PB-CE-0003'),
(10, '15/07/2016-07:45:02', 100000, 'PB-CC-00029', 'PB-CE-00016'),
(11, '15/07/2016-09:23:04', 1250, 'PB-CC-00011', 'PB-CE-0001'),
(12, '16/07/2016-06:17:38', 500, 'PB-CC-00012', 'PB-CE-00013'),
(13, '19/07/2016-02:00:05', 4000, 'PB-CE-0007', 'PB-CE-0003'),
(14, '12/09/2017-12:52:14', 470, 'PB-CE-0001', 'PB-CE-0003'),
(15, '26/01/2018-04:25:02', 500, 'PB-CE-00013', 'PB-CE-0006');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code_client` (`code_client`),
  ADD KEY `code_gestionnaire` (`code_gestionnaire`);

--
-- Indexes for table `compte_courant`
--
ALTER TABLE `compte_courant`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `num_compte` (`num_compte`),
  ADD KEY `code_client` (`code_client`);

--
-- Indexes for table `compte_epargne`
--
ALTER TABLE `compte_epargne`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `num_compte` (`num_compte`),
  ADD KEY `code_client` (`code_client`);

--
-- Indexes for table `gestionnaire`
--
ALTER TABLE `gestionnaire`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code_gestionnaire` (`code_gestionnaire`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD KEY `login` (`login`);

--
-- Indexes for table `virement`
--
ALTER TABLE `virement`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code_virement` (`code_virement`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT for table `compte_courant`
--
ALTER TABLE `compte_courant`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT for table `compte_epargne`
--
ALTER TABLE `compte_epargne`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;
--
-- AUTO_INCREMENT for table `gestionnaire`
--
ALTER TABLE `gestionnaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `virement`
--
ALTER TABLE `virement`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`code_gestionnaire`) REFERENCES `gestionnaire` (`code_gestionnaire`);

--
-- Constraints for table `compte_courant`
--
ALTER TABLE `compte_courant`
  ADD CONSTRAINT `compte_courant_ibfk_1` FOREIGN KEY (`code_client`) REFERENCES `client` (`code_client`);

--
-- Constraints for table `compte_epargne`
--
ALTER TABLE `compte_epargne`
  ADD CONSTRAINT `compte_epargne_ibfk_1` FOREIGN KEY (`code_client`) REFERENCES `client` (`code_client`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
