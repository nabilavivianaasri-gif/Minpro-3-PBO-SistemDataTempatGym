# 🏋️ Sistem Data Tempat Gym

## 📌 Deskripsi Program
Program Sistem Data Tempat Gym adalah program berbasis Java yang digunakan untuk mengelola data member gym. Program ini menyediakan beberapa fitur utama seperti menambah member, menampilkan data member, mencari member, mengupdate member, menghapus member, mengurutkan data berdasarkan nama, serta menampilkan ringkasan data gym.

Setiap member memiliki data seperti ID member, nama, usia, jenis member, paket gym, biaya, tanggal daftar, tanggal berakhir, dan status keanggotaan. Jenis member dibagi menjadi Membership Standar dan Membership Premium, sedangkan paket gym terdiri dari Bulanan dan Tahunan.

Program ini juga menerapkan konsep Pemrograman Berorientasi Objek (PBO) seperti encapsulation, inheritance, abstraction, polymorphism, interface, access modifier, constructor, method overriding, method overloading, enum, validasi input, dan ArrayList. Abstraction diterapkan melalui abstract class Member dan abstract method getJenisMember().

Interface diterapkan melalui MemberBenefit yang digunakan untuk mengatur fasilitas member. Polymorphism diterapkan melalui class MemberReguler dan MemberPremium yang melakukan method overriding terhadap method seperti getJenisMember(), getFasilitas(), dan getBiaya(). Method overloading diterapkan pada method tambahMember() dengan parameter yang berbeda.

Program ini juga menggunakan struktur Model-View-Controller (MVC) untuk memisahkan pengelolaan data, tampilan, dan pengendalian program. Model digunakan untuk mengelola data dan logika program, View digunakan untuk menampilkan menu serta menerima input dari pengguna, sedangkan Controller digunakan sebagai penghubung antara Model dan View.

Secara keseluruhan, program dibuat untuk membantu proses pengelolaan data member gym secara lebih terstruktur, sehingga data dapat ditambah, dicari, diperbarui, dihapus, dan ditampilkan dengan lebih mudah melalui menu serta menerapkan konsep PBO dan MVC dalam satu program.

# 1.Penjelasan struktur package
Program Sistem Data Tempat Gym menggunakan struktur package yang menerapkan konsep Model-View-Controller (MVC). Pembagian package ini bertujuan untuk memisahkan bagian program berdasarkan tugasnya masing-masing, sehingga kode menjadi lebih terstruktur, mudah dipahami, dan lebih mudah dikembangkan.

Struktur package yang digunakan dalam program terdiri dari main, model, view, dan controller.
Package main

## Package main

Package main merupakan package yang digunakan sebagai tempat class utama untuk menjalankan program Sistem Data Tempat Gym. Package ini menjadi titik awal ketika program dijalankan.

Class yang terdapat pada package main:

### - Main

Class Main merupakan class utama yang digunakan untuk menjalankan program. Di dalam class ini terdapat method main() yang menjadi titik awal eksekusi program.

Class Main membuat objek Menu dari package view, kemudian memanggil menu utama agar pengguna dapat berinteraksi dengan sistem. Dengan demikian, class Main tidak menangani proses pengolahan data member secara langsung, tetapi hanya bertugas untuk memulai dan menjalankan aplikasi.

## Package Model
Package model merupakan bagian yang berisi data dan logika utama dari program. Package ini menjadi bagian penting dalam pengelolaan data member gym.

Beberapa class yang terdapat dalam package model yaitu:

### - Member
Merupakan abstract class yang menjadi dasar atau parent class untuk jenis member gym. Class ini menyimpan atribut umum seperti ID, nama, usia, paket gym, tanggal daftar, dan tanggal berakhir. Class ini juga memiliki abstract method getJenisMember().

### - MemberReguler
Merupakan turunan dari class Member yang digunakan untuk member dengan jenis Membership Standar. Class ini melakukan overriding terhadap beberapa method untuk menyesuaikan jenis member dan fasilitas yang diberikan.

### - MemberPremium
Merupakan turunan dari class Member yang digunakan untuk member dengan jenis Membership Premium. Class ini memiliki fasilitas dan biaya yang berbeda dengan member reguler serta melakukan overriding terhadap method yang diperlukan.

### - DataGym
Digunakan untuk mengelola kumpulan data member gym. Class ini menangani berbagai proses seperti menambah member, menampilkan data, mencari member, mengupdate member, menghapus member, mengurutkan data, serta membuat ringkasan data gym.

### - PaketGym
Merupakan enum yang digunakan untuk menentukan pilihan paket gym, yaitu paket Bulanan dan Tahunan. Enum ini juga menyimpan informasi harga dan durasi dari masing-masing paket.

### - MemberBenefit
Merupakan interface yang digunakan untuk menentukan method fasilitas yang harus dimiliki oleh member. Interface ini kemudian diterapkan oleh class Member.

## Package view

Package view digunakan untuk menangani bagian tampilan program dan interaksi langsung dengan pengguna. Package ini menjadi bagian yang berhubungan dengan proses menampilkan informasi, menampilkan pilihan menu, serta menerima input dari pengguna.

Dalam struktur MVC, package view berperan sebagai bagian yang menampilkan informasi kepada pengguna dan menerima masukan yang diperlukan untuk menjalankan fitur program. Package ini tidak bertugas sebagai tempat utama untuk menyimpan atau mengelola data member, karena pengelolaan data dilakukan pada bagian model.

Class yang terdapat pada package view:

### - Menu

Class Menu merupakan class yang digunakan untuk mengatur tampilan menu utama dan interaksi pengguna dengan program. Class ini menampilkan berbagai pilihan fitur yang dapat digunakan oleh pengguna.

Fitur yang tersedia pada menu meliputi:

- Menambah member

- Menampilkan semua member

- Mencari member

- Mengupdate member

- Menghapus member

- Menampilkan ringkasan data gym

- Keluar dari program

Selain menampilkan menu, class Menu juga menangani input dan validasi dari pengguna, seperti validasi nama, usia, ID member, pilihan menu, serta konfirmasi sebelum melakukan proses tertentu.

Class Menu juga berkomunikasi dengan GymController untuk menjalankan proses yang berkaitan dengan data member. Dengan demikian, Menu berfokus pada bagian tampilan dan interaksi pengguna.

## Package controller

Package controller digunakan sebagai penghubung antara bagian view dan model dalam struktur MVC. Package ini bertugas menerima perintah atau data dari view, kemudian meneruskannya ke model untuk diproses.

Dengan adanya package controller, proses pengelolaan data tidak dilakukan langsung oleh view. Hal ini membuat pembagian tugas antar bagian program menjadi lebih jelas dan terstruktur sesuai dengan konsep MVC.

Class yang terdapat pada package controller:

### - GymController

Class GymController merupakan class yang berfungsi sebagai penghubung antara Menu yang berada di package view dengan class-class pengelola data yang berada di package model.

Class ini menerima data atau perintah dari Menu, kemudian menjalankan proses yang diperlukan melalui model. Setelah proses selesai, hasilnya dapat dikembalikan kepada Menu untuk ditampilkan kepada pengguna.

GymController juga memiliki method tambahMember() dengan parameter yang berbeda sebagai penerapan method overloading. Dengan adanya dua bentuk method tersebut, proses penambahan member dapat dilakukan dengan cara yang berbeda sesuai dengan parameter yang diberikan.

# 2. Alur Program

<img width="222" height="185" alt="image" src="https://github.com/user-attachments/assets/600cdd39-3e5b-42e4-97b5-45f5392fe623" />

Program dimulai dengan menampilkan judul Sistem Data Tempat Gym kemudian sistem menyiapkan data awal yang akan digunakan. Setelah data siap, program menampilkan menu utama yang berisi jumlah member dan pilihan proses yang dapat dilakukan.

Pengguna dapat memilih untuk menambah, menampilkan, mencari, memperbarui, atau menghapus data member. Selain itu, terdapat menu Ringkasan Data Gym untuk melihat informasi jumlah member berdasarkan status dan jenis membership. Setelah proses selesai, program akan kembali ke menu utama sehingga pengguna dapat melakukan proses lainnya.

Program akan terus berjalan selama pengguna masih memilih menu yang tersedia. Jika pengguna memilih Keluar, maka perulangan menu dihentikan dan program selesai dijalankan.

### 1.Tambah Member


<img width="364" height="383" alt="image" src="https://github.com/user-attachments/assets/2d3a0f51-5723-40f6-ae60-f4e8a521e53b" />


Pada tampilan ini, pengguna memilih menu 1 (Tambah Member), lalu mengisi nama “Biluy” dan usia 25 tahun. Program menampilkan dua pilihan jenis membership beserta fasilitasnya, dan pengguna 

memilih Membership Premium yang memiliki biaya tambahan Rp500.000. Setelah itu pengguna memilih paket Bulanan seharga Rp350.000 untuk durasi 30 hari. Setelah data tersimpan, sistem membuat ID

member secara otomatis, yaitu GYM003, dan menampilkan hasilnya berupa jenis Premium, paket Bulanan, total biaya Rp850.000, serta masa berlaku hingga 08 November 2026.

Setelah proses selesai, program akan looping kembali ke menu utama sehingga pengguna dapat memilih menu lain

<img width="281" height="143" alt="image" src="https://github.com/user-attachments/assets/69e3b2e2-b66d-4e7d-9040-5b91a6388a81" />

Penjelasan Tambah member

Pada tampilan ini, pengguna memilih menu 1 (Tambah Member) lalu menguji validasi input. Saat nama diisi “3434”, program menolak dan menampilkan pesan bahwa nama hanya boleh berisi huruf dan

tanda baca nama yang umum, sehingga pengguna diminta mengisi ulang dan memasukkan nama “kiara”. Pada input usia, program menolak angka 13 dan 101 karena berada di luar rentang 15 sampai 100,

serta menolak input “ef” karena bukan angka. Setelah pengguna memasukkan usia 15 yang valid, program baru lanjut ke tahap pemilihan jenis member.

Proses validasi ini menggunakan perulangan (looping), yaitu program terus meminta input yang sama sampai pengguna memasukkan data yang benar.

### 2. Menampilkan Semua Member

<img width="289" height="411" alt="image" src="https://github.com/user-attachments/assets/21c4ce9f-b3c8-48cc-9859-7a2af9c030ca" />

Pada tampilan ini, pengguna memilih menu 2 (Tampilkan Semua Member), lalu memilih tampilan nomor 2, yaitu urut berdasarkan nama. Program menampilkan data member secara berurutan sesuai abjad

nama (Azmi, Biluy, kiara) tanpa membedakan huruf besar dan kecil. Setiap member ditampilkan lengkap dengan ID, nama, usia, jenis member, paket, biaya, tanggal daftar, tanggal berlaku, status

AKTIF, dan fasilitas sesuai jenis membership-nya. Member Premium (Azmi dan Biluy) mendapat fasilitas lengkap dengan biaya sudah termasuk tambahan Rp500.000, sedangkan member Standar (kiara)

mendapat fasilitas dasar dengan biaya sesuai harga paket.

Data ditampilkan menggunakan perulangan, yaitu program menampilkan informasi setiap member satu per satu dari daftar hingga semua data selesai ditampilkan, lalu kembali ke menu utama.

<img width="183" height="113" alt="image" src="https://github.com/user-attachments/assets/46ef53c5-e2af-430f-9b9d-e1a306fdfc0e" />

Penjelasan Validasi tampilkan menu

Pada tampilan ini, Pengguna menguji validasi dengan memasukkan angka 3, yang ditolak karena di luar rentang 1 sampai 2, kemudian memasukkan huruf “e”, yang ditolak karena input harus berupa

angka. Setelah pengguna memasukkan pilihan 1 yang valid, program menampilkan daftar member berdasarkan ID, dimulai dari member GYM001 atas nama Vivi.

Pada bagian ini program juga menggunakan perulangan (looping), yaitu terus meminta pilihan tampilan sampai pengguna memasukkan angka yang benar, lalu menampilkan data member satu per satu dan

kembali ke menu utama.

## 3. Cari Member

<img width="245" height="210" alt="image" src="https://github.com/user-attachments/assets/5fdaedf4-f3bc-415d-8a18-dc748984a70d" />

Pada tampilan ini, pengguna memilih menu 3 (Cari Member), lalu program menampilkan dua pilihan pencarian, yaitu berdasarkan ID dan berdasarkan Nama. Pengguna memilih pencarian berdasarkan nama

dan memasukkan kata kunci “Azmi”. Program kemudian mencocokkan kata kunci tersebut dengan nama member tanpa membedakan huruf besar dan kecil, serta menampilkan jumlah hasil yang ditemukan, yaitu 1 member.
Data yang ditampilkan adalah member GYM002 atas nama Azmi, lengkap dengan usia, jenis member Premium, paket Tahunan, biaya Rp4.000.000, tanggal daftar, masa berlaku hingga 08 Oktober 2027, status AKTIF, dan fasilitas yang diperoleh.

<img width="200" height="110" alt="image" src="https://github.com/user-attachments/assets/64d30178-cd96-4f14-9d5c-aee288a15030" />

Penjelasan Validasi Pencarian

Pada tampilan ini, pengguna memilih menu 3 (Cari Member), lalu program menampilkan dua pilihan pencarian, yaitu berdasarkan ID dan berdasarkan Nama.

Pengguna menguji validasi dengan memasukkan angka 3, yang ditolak karena di luar rentang 1 sampai 2, kemudian memilih pencarian berdasarkan nama (pilihan 2) dan memasukkan kata kunci “bambang”. Karena tidak ada member yang namanya mengandung kata kunci tersebut, program menampilkan pesan bahwa member dengan nama tersebut tidak ditemukan.

Setelah pesan ditampilkan, program tidak berhenti, tetapi looping kembali ke menu utama sehingga pengguna dapat memilih menu lain. 

Perulangan juga terjadi pada validasi pilihan, yaitu program terus meminta input sampai pengguna memasukkan angka yang benar.

## 4. Update Member

<img width="290" height="419" alt="image" src="https://github.com/user-attachments/assets/8b132512-da27-40c3-a2e4-f70a7c213e5f" />

Pada tampilan ini, pengguna memilih menu 4 (Update Member), lalu memasukkan ID member yang ingin diubah, yaitu GYM004. Program mencari ID tersebut dan menampilkan data lama member, yaitu kiara, usia 15 tahun, jenis Standar, paket Bulanan. 

Setelah itu pengguna memasukkan data baru berupa nama “Venny” dan usia 32 tahun, kemudian memilih ulang jenis membership (Standar) dan paket gym (Bulanan). Sebelum perubahan disimpan, program meminta konfirmasi (Y/N). Karena pengguna menjawab “y”, program memperbarui data dan menampilkan pesan bahwa data member berhasil diupdate. Jika ID tidak ditemukan atau pengguna menjawab “N”, proses update dibatalkan.

Setelah proses selesai, program looping kembali ke menu utama.

<img width="214" height="74" alt="image" src="https://github.com/user-attachments/assets/66404aab-41ea-4325-9a7c-39a28b0d560c" />




<img width="250" height="78" alt="image" src="https://github.com/user-attachments/assets/ef521df3-f869-4519-af20-30faf0f49e95" />




<img width="313" height="170" alt="image" src="https://github.com/user-attachments/assets/c9982308-a883-4f33-9a88-e912846741d1" />


Penjelasan Validasi Update Member

Pada tampilan ini, pengguna memilih menu 4 (Update Member) dan menguji beberapa kondisi. Pertama, pengguna memasukkan ID “GYM009” yang tidak terdaftar, sehingga program menampilkan pesan bahwa ID member tidak ditemukan dan update dibatalkan.

Kedua, saat memasukkan data baru, nama “2323” ditolak karena nama hanya boleh berisi huruf dan tanda baca nama yang umum, sehingga pengguna mengisi ulang dengan nama “Giandra”. Pada input usia, angka 12 ditolak karena di luar rentang 15 sampai 100, dan “rg” ditolak karena bukan angka.

Ketiga, pada pemilihan jenis member dan paket gym, angka 3 ditolak karena hanya tersedia pilihan 1 sampai 2, lalu pengguna memilih Premium dan paket Bulanan. Pada konfirmasi simpan perubahan, input “h” ditolak karena hanya Y atau N yang diterima, kemudian pengguna menjawab “n” sehingga program membatalkan update dan data member tidak berubah.

Pada seluruh proses ini program menggunakan perulangan (looping), yaitu terus meminta input yang sama sampai pengguna memasukkan data yang benar, dan setelah update selesai atau dibatalkan, program kembali ke menu utama.

## 5. Hapus Member


<img width="325" height="202" alt="image" src="https://github.com/user-attachments/assets/aef8b7b5-82f5-420c-ba81-8c91850ead7d" />


Pada tampilan ini, pengguna memilih menu 5 (Hapus Member), lalu memasukkan ID member yang ingin dihapus, yaitu GYM004. Program mencari ID tersebut dan menampilkan data member yang ditemukan, yaitu Venny, usia 32 tahun, jenis Standar, paket Bulanan, dengan status AKTIF.

Sebelum data dihapus, program meminta konfirmasi (Y/N) untuk mencegah penghapusan yang tidak disengaja. Karena pengguna menjawab “y”, program menjalankan proses penghapusan dan menampilkan pesan bahwa data member berhasil dihapus. Jika ID tidak ditemukan atau pengguna menjawab “N”, penghapusan dibatalkan dan data tetap tersimpan.

Setelah proses selesai, program looping kembali ke menu utama. Perulangan juga terjadi pada validasi input ID dan konfirmasi Y/N, yaitu program terus meminta input sampai pengguna memasukkan data yang benar.

<img width="185" height="35" alt="image" src="https://github.com/user-attachments/assets/3094e0f7-7935-4cd0-ad46-cb458baf2c95" />



<img width="188" height="28" alt="image" src="https://github.com/user-attachments/assets/0e402175-7750-4668-9b9e-10cd2c116d2b" />

Penjelasan Validasi Hapus Member

pengguna memilih menu 5 (Hapus Member) dan menguji dua kondisi yang membuat data tidak terhapus. Pertama, pengguna memasukkan ID “GYM009” yang tidak terdaftar, sehingga program menampilkan pesan bahwa ID member tidak ditemukan dan proses hapus berhenti tanpa meminta konfirmasi. 

Kedua, pada konfirmasi “Yakin ingin menghapus member ini? (Y/N)”, pengguna menjawab “N”, sehingga program menampilkan pesan bahwa penghapusan dibatalkan dan data member tetap tersimpan.
Setelah proses selesai, program looping kembali ke menu utama. Perulangan juga terjadi pada validasi input ID dan konfirmasi Y/N, yaitu program terus meminta input sampai pengguna memasukkan data yang benar.

## 6. Ringkasan Data Gym

<img width="164" height="95" alt="image" src="https://github.com/user-attachments/assets/68ce2f28-968b-4005-88df-61ede49f6605" />

Pada tampilan ini, pengguna memilih menu 6 (Ringkasan Data Gym), lalu program menampilkan rekap seluruh data member. Hasilnya adalah total member berjumlah 3 dan semuanya berstatus aktif. 

Berdasarkan jenis membership, terdapat 1 member reguler (Standar) dan 2 member premium. Berdasarkan paket, terdapat 2 member paket bulanan dan 1 member paket tahunan. Total nilai membership sebesar Rp5.200.000 didapat dari penjumlahan biaya seluruh member, yaitu Rp350.000 (Standar Bulanan), Rp4.000.000 (Premium Tahunan), dan Rp850.000 (Premium Bulanan).

## 7. Keluar

<img width="304" height="91" alt="image" src="https://github.com/user-attachments/assets/6c45f825-1595-4606-b656-d7541534a871" />

Pada proses ini, pengguna memilih menu 7. Keluar. Program kemudian menghentikan sistem dan menampilkan pesan bahwa program telah ditutup. Setelah itu, proses program selesai dan muncul keterangan BUILD SUCCESS yang menunjukkan bahwa program berhasil dijalankan tanpa error.

Penjelasan Validasi Menu

<img width="156" height="22" alt="image" src="https://github.com/user-attachments/assets/b81dd386-53c3-4f4e-ab37-bf6bfb14b3f7" />


Pada proses ini, pengguna memasukkan pilihan menu 8, sedangkan menu yang tersedia hanya dari 1–7. Program menolak input tersebut dan menampilkan pesan bahwa nilai harus berada di antara 1 dan 7, kemudian pengguna diminta memasukkan pilihan yang benar.


