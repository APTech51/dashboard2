-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 30, 2026 at 10:41 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_1`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `kd_brng` varchar(75) NOT NULL,
  `ktgrbrng` varchar(75) NOT NULL,
  `n_brng` varchar(75) NOT NULL,
  `ukuran` varchar(75) NOT NULL,
  `warna` varchar(75) NOT NULL,
  `Jmlh` int(11) NOT NULL DEFAULT 0,
  `hg_beli` int(11) NOT NULL DEFAULT 0,
  `hg_jual` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`kd_brng`, `ktgrbrng`, `n_brng`, `ukuran`, `warna`, `Jmlh`, `hg_beli`, `hg_jual`) VALUES
('DTBRNG01', 'Pakaian Atas', 'Baju Koko', 'L', 'Putih', 27, 50000, 0),
('DTBRNG02', 'Pakaian Atas', 'Jaket Kulit', 'L', 'Hitam', 0, 0, 0),
('DTBRNG03', 'Pakaian Bawah', 'Celana Jeans', 'L', 'Blue Denim', 0, 0, 0),
('DTBRNG04', 'Pakaian Atas', 'Baju Renang', 'XL', 'Biru', 28, 30000, 0),
('DTBRNG05', 'Pakaian Atas', 'Baju Tidur', 'S', 'Putih', 0, 85000, 0),
('DTBRNG06', 'Pakaian Atas', 'Baju FF', 'M', 'Biru', 50, 35000, 0),
('DTBRNG07', 'Pakaian Bawah', 'Celana Formal', 'XL', 'Hitam', 22, 70000, 0),
('DTBRNG08', 'Aksesoris', 'Bandana', 'All Size', 'Pink', 0, 45000, 0),
('DTBRNG09', 'Aksesoris', 'Kalung', 'All Size', 'Silver', 0, 0, 0),
('DTBRNG10', 'Pakaian Bawah', 'Celana Cargo', 'M', 'Hijau', 59, 100000, 0),
('DTBRNG11', 'Aksesoris', 'Cincin', 'All Size', 'Emas', 0, 0, 0),
('DTBRNG12', 'Pakaian Bawah', 'Rok', 'XXL', 'Lavender', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `db_petugas`
--

CREATE TABLE `db_petugas` (
  `id_petugas` varchar(75) NOT NULL,
  `nama_petugas` varchar(75) NOT NULL,
  `jabatan` varchar(75) NOT NULL,
  `no_telepon` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `db_petugas`
--

INSERT INTO `db_petugas` (`id_petugas`, `nama_petugas`, `jabatan`, `no_telepon`) VALUES
('PTG001', 'thomasmase', 'Staff', 432534242),
('PTG003', 'Lusiana', 'Staff', 96346043),
('PTG004', 'Susiana', 'Admin', 63271531),
('PTG005', 'Fsbianto', 'Staff', 34232352),
('PTG006', 'Gobang', 'Staff', 424214532),
('PTG007', 'Yantianti', 'Staff', 565645645);

-- --------------------------------------------------------

--
-- Table structure for table `pembeli`
--

CREATE TABLE `pembeli` (
  `kd_pembeli` varchar(100) NOT NULL,
  `nm_pembeli` varchar(100) NOT NULL,
  `almt` varchar(10000) NOT NULL,
  `n_tlpn` int(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembeli`
--

INSERT INTO `pembeli` (`kd_pembeli`, `nm_pembeli`, `almt`, `n_tlpn`) VALUES
('DTPMBLI01', 'martina', 'jl.nganggur 24', 812346345),
('DTPMBLI02', 'dosenaw', 'Jl lalat', 355223233),
('DTPMBLI03', 'werastino', 'Jl.sapudan 33', 85665645),
('DTPMBLI04', 'Brotoseno', 'Jl.Furinger 66', 885756445),
('DTPMBLI05', 'Werasito', 'Jl.Rajiantus', 867856432),
('DTPMBLI06', 'Holister', 'Jl.Megamendung 48', 876544323);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `KD_Supp` varchar(10) NOT NULL,
  `Nama_Supp` varchar(35) NOT NULL,
  `Alamat` varchar(75) NOT NULL,
  `NoTelp` int(15) NOT NULL,
  `Email` varchar(25) NOT NULL,
  `hg_beli` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`KD_Supp`, `Nama_Supp`, `Alamat`, `NoTelp`, `Email`, `hg_beli`) VALUES
('DTSPPLR01', 'CV.Raja Mutakhirnes', 'Jl.senggol Bacok 72', 2147483647, 'ansfasinas@gmail.com', 0),
('DTSPPLR02', 'Pt.Bangrkut Dah', 'Jl.Semberono 75', 2147483647, 'Ansafnsa@gmail.com', 0),
('DTSPPLR03', 'PT.Rajameowmeow', 'Jl.Lu siapa', 841421352, 'sdbaidbafuia@dexter.co.id', 0),
('DTSPPLR04', 'blablabla', 'jalan-jalan', 8234567, 'bbbbbbb@gmail.com', 0),
('DTSPPLR05', 'Penjilat  Biantara', 'Jl.Sampurasun', 28142342, 'teapso@yahoo.com', 0),
('DTSPPLR06', 'CV Ardian Pratama', 'Jl.Tunggalis 34', 95205273, 'aderaism@.gmail.com', 0),
('DTSPPLR07', 'PT.yuonag gelos', 'Kp.Babak Belur 234', 643557432, 'febrianus@gevke.com', 0),
('DTSPPLR08', 'Pt.Manuver', 'JLsialan Elu', 342422312, 'Asulaino@gebrek.com', 0),
('DTSPPLR09', 'CV.Lotus Rapur', 'Jl.Kojoranti 54', 435475653, 'opardi@market.co.id', 0),
('DTSPPLR10', 'Goriorio Manufactory', 'JL.Gatot Subroto', 643454354, 'defending@Indonesian.com', 0),
('DTSPPLR11', 'Ferdian Perdana', 'Layang Huruk No.91', 67633212, 'Bertanisu@koplo.com', 0),
('DTSPPLR12', 'Konsolidator PT', 'begundal No.67', 357656432, 'bubadibako@.gmail.com', 0),
('DTSPPLR13', 'ferdiand CV', 'Jl.Legowo 75', 587545323, 'Dududu@yahoo.com', 0),
('DTSPPLR14', 'koperasi Wahana CV', 'Jl.Tunggal Ika 66', 86764534, 'GebrakanBaru.Indon.co.id', 0),
('DTSPPLR15', 'Pt.duehfbfdudsu', 'jl.mawar', 1234567, 'bdaugdebda@gmail.com', 0);

-- --------------------------------------------------------

--
-- Table structure for table `ts_brg_klr`
--

CREATE TABLE `ts_brg_klr` (
  `nm_brg` varchar(75) NOT NULL,
  `hg_jual` int(15) NOT NULL,
  `jm_keluar` int(10) NOT NULL,
  `nm_pembeli` varchar(75) DEFAULT NULL,
  `nm_petugas` varchar(75) DEFAULT NULL,
  `id_keluar` int(11) NOT NULL,
  `kd_brg` varchar(75) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ts_brg_klr`
--

INSERT INTO `ts_brg_klr` (`nm_brg`, `hg_jual`, `jm_keluar`, `nm_pembeli`, `nm_petugas`, `id_keluar`, `kd_brg`) VALUES
('Baju Koko', 55000, 5, 'martina', 'Lusiana', 35, 'DTBRNG01'),
('Baju Renang', 450000, 27, 'dosenaw', 'Gobang', 36, 'DTBRNG04'),
('Celana Cargo', 150000, 6, 'werastino', 'thomasmase', 37, 'DTBRNG10'),
('Bandana', 55000, 7, 'Holister', 'Susiana', 38, 'DTBRNG08'),
('Celana Formal', 90000, 18, 'Werasito', 'thomasmase', 39, 'DTBRNG07'),
('Baju Tidur', 100000, 15, 'martina', 'Lusiana', 40, 'DTBRNG05'),
('Bandana', 55000, 15, 'dosenaw', 'Fsbianto', 43, 'DTBRNG08');

-- --------------------------------------------------------

--
-- Table structure for table `ts_brg_msk`
--

CREATE TABLE `ts_brg_msk` (
  `id_masuk` int(11) NOT NULL,
  `kd_brg` varchar(75) NOT NULL,
  `nm_brg` varchar(75) NOT NULL,
  `supplier` varchar(75) NOT NULL,
  `hg_beli` int(15) NOT NULL,
  `jumlah` int(10) NOT NULL,
  `hg_jual` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ts_brg_msk`
--

INSERT INTO `ts_brg_msk` (`id_masuk`, `kd_brg`, `nm_brg`, `supplier`, `hg_beli`, `jumlah`, `hg_jual`) VALUES
(58, 'DTBRNG06', 'Baju FF', 'blablabla', 35000, 20, 0),
(59, 'DTBRNG01', 'Baju Koko', 'CV Ardian Pratama', 50000, 32, 0),
(60, 'DTBRNG04', 'Baju Renang', 'CV.Lotus Rapur', 30000, 55, 0),
(61, 'DTBRNG05', 'Baju Tidur', 'CV.Raja Mutakhirnes', 85000, 15, 0),
(62, 'DTBRNG08', 'Bandana', 'Ferdian Perdana', 45000, 22, 0),
(63, 'DTBRNG10', 'Celana Cargo', 'Goriorio Manufactory', 100000, 65, 0),
(64, 'DTBRNG07', 'Celana Formal', 'Konsolidator PT', 70000, 40, 0),
(66, 'DTBRNG06', 'Baju FF', 'blablabla', 35000, 30, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kd_brng`),
  ADD UNIQUE KEY `n_brng` (`n_brng`);

--
-- Indexes for table `db_petugas`
--
ALTER TABLE `db_petugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Indexes for table `pembeli`
--
ALTER TABLE `pembeli`
  ADD PRIMARY KEY (`kd_pembeli`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`KD_Supp`) USING BTREE;

--
-- Indexes for table `ts_brg_klr`
--
ALTER TABLE `ts_brg_klr`
  ADD PRIMARY KEY (`id_keluar`),
  ADD KEY `kd_brg` (`kd_brg`);

--
-- Indexes for table `ts_brg_msk`
--
ALTER TABLE `ts_brg_msk`
  ADD PRIMARY KEY (`id_masuk`),
  ADD KEY `idx_kd_brg` (`kd_brg`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ts_brg_klr`
--
ALTER TABLE `ts_brg_klr`
  MODIFY `id_keluar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `ts_brg_msk`
--
ALTER TABLE `ts_brg_msk`
  MODIFY `id_masuk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ts_brg_klr`
--
ALTER TABLE `ts_brg_klr`
  ADD CONSTRAINT `ts_brg_klr_ibfk_1` FOREIGN KEY (`kd_brg`) REFERENCES `barang` (`kd_brng`);

--
-- Constraints for table `ts_brg_msk`
--
ALTER TABLE `ts_brg_msk`
  ADD CONSTRAINT `ts_brg_msk_ibfk_1` FOREIGN KEY (`kd_brg`) REFERENCES `barang` (`kd_brng`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
