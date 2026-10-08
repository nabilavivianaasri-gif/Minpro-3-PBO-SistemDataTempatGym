# 🏋️ Sistem Data Tempat Gym

## 📌 Deskripsi Program
Program Sistem Data Tempat Gym adalah program berbasis Java yang digunakan untuk mengelola data member gym. Program ini menyediakan beberapa fitur utama seperti menambah member, menampilkan data member, mencari member, mengupdate member, menghapus member, mengurutkan data berdasarkan nama, serta menampilkan ringkasan data gym.

Setiap member memiliki data seperti ID member, nama, usia, jenis member, paket gym, biaya, tanggal daftar, tanggal berakhir, dan status keanggotaan. Jenis member dibagi menjadi Membership Standar dan Membership Premium, sedangkan paket gym terdiri dari Bulanan dan Tahunan.

Program ini juga menerapkan konsep Pemrograman Berorientasi Objek (PBO) seperti encapsulation, inheritance, abstraction, polymorphism, interface, access modifier, constructor, method overriding, method overloading, enum, validasi input, dan ArrayList. Abstraction diterapkan melalui abstract class Member dan abstract method getJenisMember().

Interface diterapkan melalui MemberBenefit yang digunakan untuk mengatur fasilitas member. Polymorphism diterapkan melalui class MemberReguler dan MemberPremium yang melakukan method overriding terhadap method seperti getJenisMember(), getFasilitas(), dan getBiaya(). Method overloading diterapkan pada method tambahMember() dengan parameter yang berbeda.

Program ini juga menggunakan struktur Model-View-Controller (MVC) untuk memisahkan pengelolaan data, tampilan, dan pengendalian program. Model digunakan untuk mengelola data dan logika program, View digunakan untuk menampilkan menu serta menerima input dari pengguna, sedangkan Controller digunakan sebagai penghubung antara Model dan View.

Secara keseluruhan, program dibuat untuk membantu proses pengelolaan data member gym secara lebih terstruktur, sehingga data dapat ditambah, dicari, diperbarui, dihapus, dan ditampilkan dengan lebih mudah melalui menu serta menerapkan konsep PBO dan MVC dalam satu program.

## 1.Penjelasan struktur package
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

<img width="323" height="325" alt="image" src="https://github.com/user-attachments/assets/f4e74aac-1f54-4bee-91af-430e4c03ad39" />


Pada proses ini, pengguna memilih menu Tambah Member kemudian memasukkan nama dan usia member. Setelah itu, program menampilkan pilihan jenis membership, yaitu Membership Standar dan Membership Premium beserta fasilitas yang diperoleh. Pengguna memilih Membership Premium, sehingga mendapatkan fasilitas tambahan dan biaya tambahan sebesar Rp500.000.

Selanjutnya, pengguna memilih paket gym Bulanan dengan biaya Rp350.000. Setelah semua data diisi, sistem menyimpan data member dan membuat ID member secara otomatis, yaitu GYM003. Program kemudian menampilkan hasil data member berupa jenis membership, paket yang dipilih, total biaya sebesar Rp850.000, serta tanggal berlakunya membership.

<img width="253" height="84" alt="image" src="https://github.com/user-attachments/assets/a650c3e0-5f0f-41bf-9abc-39edbb4fb79f" />


Program melakukan validasi pada nama dan usia. Nama harus berupa huruf, sedangkan usia harus berada di antara 15–100 tahun. Jika input tidak sesuai, program akan menolak dan meminta pengguna memasukkan data kembali.

### 2. Menampilkan Semu Member

<img width="213" height="361" alt="image" src="https://github.com/user-attachments/assets/378f784b-b9e5-4def-8db0-6a89766352d3" />

Pada menu ini, program menampilkan seluruh data member gym yang sudah tersimpan. Pengguna dapat memilih urutan tampilan berdasarkan ID atau nama. Data yang ditampilkan meliputi nama, usia, jenis member, paket, biaya, tanggal daftar, masa berlaku, dan status member lalu kembali ke menu utama.

<img width="224" height="219" alt="image" src="https://github.com/user-attachments/assets/95a34b9a-5bc0-4f5b-815c-9213ffead170" />

jika memilih mengurutkan berdasarkan nama program akan menampilkan data member berdasarkan urutan nama a-z

## 3. Cari Member

<img width="208" height="179" alt="image" src="https://github.com/user-attachments/assets/f5ddcd4f-eb5b-48f7-8563-ec9605553345" />

Pada menu ini, pengguna memilih pencarian berdasarkan nama dan memasukkan kata kunci “Vivi”. Program kemudian mencari data yang sesuai dan menemukan 1 member, yaitu Vivi dengan ID GYM003. Hasil pencarian menampilkan data lengkap member seperti usia, jenis membership, paket, biaya, tanggal daftar, masa berlaku, dan status lalu kembali ke menu utama.

<img width="195" height="80" alt="image" src="https://github.com/user-attachments/assets/353a6d84-6783-407a-a5a4-e43e3393fc9a" />

Penjelasan Validasi Pencarian

Pada proses ini, pengguna salah memasukkan pilihan menu dengan angka 3, sehingga program meminta pilihan kembali dengan rentang 1–2. Setelah memilih pencarian berdasarkan nama, pengguna memasukkan kata kunci “324”, tetapi data dengan nama tersebut tidak ditemukan.

## 4. Update Member

<img width="278" height="368" alt="image" src="https://github.com/user-attachments/assets/91d4e992-1d8b-4002-a310-1c8de0388e48" />

Pada proses ini, pengguna memilih menu Update Member dan memasukkan ID GYM007 untuk mencari data yang ingin diubah. Program menampilkan data lama, kemudian pengguna memasukkan data baru berupa nama Jule, usia 23 tahun, jenis member Premium, dan paket gym yang dipilih. Setelah semua data selesai diisi, pengguna mengonfirmasi perubahan dengan memilih Y, sehingga sistem menyimpan dan memperbarui data member tersebut lalu kembali ke menu utama.

<img width="308" height="231" alt="image" src="https://github.com/user-attachments/assets/0f9c05fc-3d5c-4013-a92f-dfe6a3056a7c" />

Penjelasan Validasi Update Member

Pada proses ini, pengguna memilih menu Update Member lalu memasukkan ID member. Saat memasukkan d, sistem menolak karena format ID harus sesuai, contohnya GYM001. Setelah memasukkan GYM005, sistem kembali menolak karena ID tersebut tidak ditemukan, sehingga proses update dibatalkan dan program kembali ke menu utama.

## 5. Hapus Member


<img width="287" height="274" alt="image" src="https://github.com/user-attachments/assets/6c28587d-66d5-46f3-a345-57757d34bee0" />


Pada proses ini, pengguna memilih menu Hapus Member dan memasukkan ID GYM007. Program menampilkan data member yang akan dihapus, kemudian meminta konfirmasi dari pengguna. Setelah pengguna memilih Y, sistem menghapus data tersebut dan menampilkan pesan bahwa data member berhasil dihapus. Setelah itu, program kembali ke menu utama.

<img width="266" height="47" alt="image" src="https://github.com/user-attachments/assets/86413e08-4491-4afc-bdce-7ad4fd70b90f" />

Penjelasan Validasi Hapus Member

Pada proses ini, pengguna memasukkan ID GYM005 untuk dihapus. Namun, ID tersebut tidak ditemukan dalam data member, sehingga sistem menampilkan pesan “ID member tidak ditemukan” dan proses penghapusan tidak dapat dilakukan.

## 6. Ringkasan Data Gym

<img width="206" height="131" alt="image" src="https://github.com/user-attachments/assets/72c9b3ed-49d4-4881-878c-0416b20f26bb" />

Pada menu Ringkasan Data Gym, program menampilkan rangkuman keseluruhan data member yang tersimpan. Informasi yang ditampilkan meliputi total member, jumlah member aktif, jumlah member reguler dan premium, jumlah paket bulanan dan tahunan, serta total nilai membership. Setelah ringkasan ditampilkan, program kembali ke menu utama.

## 7. Keluar

<img width="418" height="125" alt="image" src="https://github.com/user-attachments/assets/cf5df089-bac1-4e61-a99f-62fe35a588f3" />

Pada proses ini, pengguna memilih menu 7. Keluar. Program kemudian menghentikan sistem dan menampilkan pesan bahwa program telah ditutup. Setelah itu, proses program selesai dan muncul keterangan BUILD SUCCESS yang menunjukkan bahwa program berhasil dijalankan tanpa error.

Penjelasan Validasi Menu

Pada proses ini, pengguna memasukkan pilihan menu 8, sedangkan menu yang tersedia hanya dari 1–7. Program menolak input tersebut dan menampilkan pesan bahwa nilai harus berada di antara 1 dan 7, kemudian pengguna diminta memasukkan pilihan yang benar.


