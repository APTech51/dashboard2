# Sistem Manajemen Persediaan Barang Dan Transaksi Penjualan Pada Toko Butik MadeTirami

## Deskripsi

Sistem Manajemen Persediaan Barang Dan Transaksi Penjualan Pada Toko Butik MadeTirami merupakan aplikasi desktop berbasis Java yang dibuat menggunakan NetBeans IDE. Aplikasi ini bertujuan untuk membantu proses pengelolaan data barang, supplier, pembeli, petugas, transaksi barang masuk, transaksi barang keluar, serta pembuatan laporan secara cepat dan terkomputerisasi.

Database yang digunakan adalah MySQL, sedangkan pembuatan laporan menggunakan JasperReports.

---

## Fitur

- Login pengguna
- Dashboard
- Manajemen Data Barang
- Manajemen Data Supplier
- Manajemen Data Pembeli
- Manajemen Data Petugas
- Transaksi Barang Masuk
- Transaksi Barang Keluar
- Laporan Data Barang
- Laporan Supplier
- Laporan Barang Masuk
- Laporan Barang Keluar
- Laporan Pembeli
- Laporan Petugas

---

## Teknologi yang Digunakan

- Java
- NetBeans IDE
- MySQL Database
- JasperReports
- JDBC (MySQL Connector)

---

## Struktur Project

```
src/           -> Source code aplikasi
lib/           -> Library yang digunakan
nbproject/     -> Konfigurasi project NetBeans
build.xml      -> Script build Ant
manifest.mf    -> Manifest aplikasi
db_1.sql       -> Database MySQL
```

---

## Cara Menjalankan Aplikasi

1. Install XAMPP atau MySQL Server.
2. Import file **db_1.sql** ke phpMyAdmin.
3. Buka project menggunakan NetBeans.
4. Pastikan library JasperReports dan MySQL Connector telah terpasang.
5. Jalankan project.

---

## Modul Aplikasi

### Data Barang
Digunakan untuk menambah, mengubah, menghapus, dan melihat data barang beserta stok yang tersedia.

### Data Supplier
Digunakan untuk mengelola data supplier yang memasok barang.

### Data Pembeli
Digunakan untuk menyimpan informasi pembeli.

### Data Petugas
Digunakan untuk mengelola data petugas yang menggunakan aplikasi.

### Barang Masuk
Mencatat transaksi barang yang masuk sehingga stok barang bertambah secara otomatis.

### Barang Keluar
Mencatat transaksi barang yang keluar sehingga stok barang berkurang secara otomatis.

### Laporan
Menghasilkan laporan menggunakan JasperReports yang dapat dicetak.

---

## Database

Nama database:

```
db_1
```

File database terdapat pada:

```
db_1.sql
```

---

## Pengembang

Nama : Kelompok 3 Kelas RO Prodi Teknik Informatika

Project : Sistem Manajemen Persediaan Barang Dan Transaksi Penjualan Pada Toko Butik MadeTirami
