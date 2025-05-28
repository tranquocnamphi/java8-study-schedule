-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 17, 2023 lúc 09:04 AM
-- Phiên bản máy phục vụ: 10.4.25-MariaDB
-- Phiên bản PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qltkb`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tkb`
--

CREATE TABLE `tkb` (
  `id` int(11) NOT NULL,
  `tenMonHoc` varchar(255) DEFAULT NULL,
  `gioBatDau` varchar(255) DEFAULT NULL,
  `gioKetThuc` varchar(25) DEFAULT NULL,
  `thu` varchar(8) DEFAULT NULL,
  `tuan` varchar(21) DEFAULT NULL,
  `listTuanHoc` varchar(50) DEFAULT NULL,
  `ngayHoc` date DEFAULT NULL,
  `loaiMonHoc` varchar(22) DEFAULT NULL,
  `phongHoc` varchar(22) DEFAULT NULL,
  `masv` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tkb`
--

INSERT INTO `tkb` (`id`, `tenMonHoc`, `gioBatDau`, `gioKetThuc`, `thu`, `tuan`, `listTuanHoc`, `ngayHoc`, `loaiMonHoc`, `phongHoc`, `masv`) VALUES
(9, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2022-10-10', 'LT+BT', 'CT-205', '637630'),
(10, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2022-10-17', 'LT+BT', 'CT-205', '637630'),
(11, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2022-10-24', 'LT+BT', 'CT-205', '637630'),
(12, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2022-10-31', 'LT+BT', 'CT-205', '637630'),
(13, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2022-11-07', 'LT+BT', 'CT-205', '637630'),
(14, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2022-11-14', 'LT+BT', 'CT-205', '637630'),
(15, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2022-11-21', 'LT+BT', 'CT-205', '637630'),
(16, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2022-11-28', 'LT+BT', 'CT-205', '637630'),
(17, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2022-12-05', 'LT+BT', 'CT-205', '637630'),
(18, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2022-12-19', 'LT+BT', 'CT-205', '637630'),
(19, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2022-12-26', 'LT+BT', 'CT-205', '637630'),
(20, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2023-01-02', 'LT+BT', 'CT-205', '637630'),
(21, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2023-01-09', 'LT+BT', 'CT-205', '637630'),
(22, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2023-01-30', 'LT+BT', 'CT-205', '637630'),
(23, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2023-02-06', 'LT+BT', 'CT-205', '637630'),
(24, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2023-02-13', 'LT+BT', 'CT-205', '637630'),
(25, 'Cơ sở dữ liệu', '6h45', '9h10', 'thứ 2', NULL, '2-10,12-15,18-21', '2023-02-20', 'LT+BT', 'CT-205', '637630'),
(26, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-10-11', 'LT+BT', 'CT-204', '637630'),
(27, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-10-18', 'LT+BT', 'CT-204', '637630'),
(28, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-10-25', 'LT+BT', 'CT-204', '637630'),
(29, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-11-01', 'LT+BT', 'CT-204', '637630'),
(30, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-11-08', 'LT+BT', 'CT-204', '637630'),
(31, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-11-15', 'LT+BT', 'CT-204', '637630'),
(32, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-11-22', 'LT+BT', 'CT-204', '637630'),
(33, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-11-29', 'LT+BT', 'CT-204', '637630'),
(34, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-12-06', 'LT+BT', 'CT-204', '637630'),
(35, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-12-20', 'LT+BT', 'CT-204', '637630'),
(36, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-12-27', 'LT+BT', 'CT-204', '637630'),
(37, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2023-01-03', 'LT+BT', 'CT-204', '637630'),
(38, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2023-01-10', 'LT+BT', 'CT-204', '637630'),
(39, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2023-01-31', 'LT+BT', 'CT-204', '637630'),
(40, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2023-02-07', 'LT+BT', 'CT-204', '637630'),
(41, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2023-02-14', 'LT+BT', 'CT-204', '637630'),
(42, 'Nhập môn công nghệ phần mềm', '6h45', '8h15', 'thứ 3', NULL, '2-10,12-15,18-21', '2023-02-21', 'LT+BT', 'CT-204', '637630'),
(43, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-10-11', 'LT+BT', 'CT-207', '637630'),
(44, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-10-18', 'LT+BT', 'CT-207', '637630'),
(45, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-10-25', 'LT+BT', 'CT-207', '637630'),
(46, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-11-01', 'LT+BT', 'CT-207', '637630'),
(47, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-11-08', 'LT+BT', 'CT-207', '637630'),
(48, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-11-15', 'LT+BT', 'CT-207', '637630'),
(49, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-11-22', 'LT+BT', 'CT-207', '637630'),
(50, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-11-29', 'LT+BT', 'CT-207', '637630'),
(51, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-12-06', 'LT+BT', 'CT-207', '637630'),
(52, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-12-20', 'LT+BT', 'CT-207', '637630'),
(53, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2022-12-27', 'LT+BT', 'CT-207', '637630'),
(54, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2023-01-03', 'LT+BT', 'CT-207', '637630'),
(55, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2023-01-10', 'LT+BT', 'CT-207', '637630'),
(56, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2023-01-31', 'LT+BT', 'CT-207', '637630'),
(57, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2023-02-07', 'LT+BT', 'CT-207', '637630'),
(58, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2023-02-14', 'LT+BT', 'CT-207', '637630'),
(59, 'Nhập môn trí tuệ nhân tạo', '8h25', '11h45', 'thứ 3', NULL, '2-10,12-15,18-21', '2023-02-21', 'LT+BT', 'CT-207', '637630'),
(60, 'Kỹ thuật lập trình', '6h45', '9h15', 'thứ 4', NULL, '8,10,12,14,18', '2022-11-23', 'TN', 'B1-203', '637630'),
(61, 'Kỹ thuật lập trình', '6h45', '9h15', 'thứ 4', NULL, '8,10,12,14,18', '2022-12-07', 'TN', 'B1-203', '637630'),
(62, 'Kỹ thuật lập trình', '6h45', '9h15', 'thứ 4', NULL, '8,10,12,14,18', '2022-12-21', 'TN', 'B1-203', '637630'),
(63, 'Kỹ thuật lập trình', '6h45', '9h15', 'thứ 4', NULL, '8,10,12,14,18', '2023-01-04', 'TN', 'B1-203', '637630'),
(64, 'Kỹ thuật lập trình', '6h45', '9h15', 'thứ 4', NULL, '8,10,12,14,18', '2023-02-01', 'TN', 'B1-203', '637630'),
(65, 'Thuật toán ứng dụng', '9h15', '11h45', 'thứ 4', NULL, '5,7,9,15,19', '2022-11-02', 'TN', 'B1-203', '637630'),
(66, 'Thuật toán ứng dụng', '9h15', '11h45', 'thứ 4', NULL, '5,7,9,15,19', '2022-11-16', 'TN', 'B1-203', '637630'),
(67, 'Thuật toán ứng dụng', '9h15', '11h45', 'thứ 4', NULL, '5,7,9,15,19', '2022-11-30', 'TN', 'B1-203', '637630'),
(68, 'Thuật toán ứng dụng', '9h15', '11h45', 'thứ 4', NULL, '5,7,9,15,19', '2023-01-11', 'TN', 'B1-203', '637630'),
(69, 'Thuật toán ứng dụng', '9h15', '11h45', 'thứ 4', NULL, '5,7,9,15,19', '2023-02-08', 'TN', 'B1-203', '637630');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `masv` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`masv`) VALUES
('637630');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tkb`
--
ALTER TABLE `tkb`
  ADD PRIMARY KEY (`id`),
  ADD KEY `msv` (`masv`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`masv`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tkb`
--
ALTER TABLE `tkb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tkb`
--
ALTER TABLE `tkb`
  ADD CONSTRAINT `msv` FOREIGN KEY (`masv`) REFERENCES `user` (`masv`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
