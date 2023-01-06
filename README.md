## Shoes Shop - Java Servlet

### Tool:
```bash
# database:
MySQL Workbench

# server:
Apache Tomcat v10.0
```

### Database (pvbshoesshop.sql):
```bash
CREATE DATABASE `pvbshoesshop`;

CREATE TABLE `pvbshoesshop`.`shoes` (
  `id_giay` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ten_giay` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ten_loai_giay` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ten_thuong_hieu` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mo_ta` longtext COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `don_gia` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hinh_anh_1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `hinh_anh_2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `hinh_anh_3` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `hinh_anh_4` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_giay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `pvbshoesshop`.`users` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ten_nguoi_dung` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phan_quyen` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `pvbshoesshop`.`users` (`ten_nguoi_dung`, `email`, `password`, `phan_quyen`) VALUES ('Admin', 'admin@gmail.com', 'admin123', 'admin');
```

## Dev: Phan Văn Bằng
###### Facebook: fb.com/it0902
###### Github: github.com/ilyouu
###### Email: pvbang23092002@gmail.com

