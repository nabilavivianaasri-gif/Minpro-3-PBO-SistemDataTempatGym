package view;

import controller.GymController;
import java.util.ArrayList;
import java.util.Scanner;
import model.Member;
import model.PaketGym;

public class Menu {
    private final GymController controller;
    private final Scanner scanner;

    public Menu() {
        controller = new GymController();
        scanner = new Scanner(System.in);
    }

    public void tampilkanMenu() {
        tampilkanPembuka();
        boolean berjalan = true;
        while (berjalan) {
            tampilkanHeader();
            tampilkanDashboardSingkat();
            tampilkanPilihanMenu();
            int pilihan = bacaInteger("Pilih menu (1-7): ", 1, 7);
            System.out.println();
            try {
                berjalan = jalankanMenu(pilihan);
            } catch (IllegalArgumentException e) {
                System.out.println("Operasi tidak dapat dilakukan: " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("Terjadi kesalahan saat memproses data. Silakan coba lagi.");
            }
        }
        scanner.close();
    }

    private boolean jalankanMenu(int pilihan) {
        switch (pilihan) {
            case 1 -> prosesTambahMember();
            case 2 -> prosesTampilkanMember();
            case 3 -> prosesCariMember();
            case 4 -> prosesUpdateMember();
            case 5 -> prosesHapusMember();
            case 6 -> tampilkanRingkasan();
            case 7 -> {
                animasi("Menutup sistem");
                System.out.println("Terima kasih telah menggunakan Sistem Data Tempat Gym.");
                return false;
            }
            default -> throw new IllegalArgumentException("Menu tidak tersedia.");
        }
        return true;
    }

    private void tampilkanPembuka() {
        System.out.println("====================================================");
        System.out.println("           SISTEM DATA TEMPAT GYM                 ");
        System.out.println("             MINI PROJECT 3                         ");
        System.out.println("====================================================");
        animasi("Menyiapkan data awal");
        System.out.println("Data dummy sudah tersedia dan siap dibaca.\n");
    }

    private void tampilkanHeader() {
        System.out.println("\n====================================================");
        System.out.println("                 MENU UTAMA GYM                    ");
        System.out.println("====================================================");
    }

    private void tampilkanDashboardSingkat() {
        System.out.println("Member : " + controller.jumlahMember()
                + " | Aktif : " + controller.jumlahMemberAktif()
                + " | Standar : " + controller.jumlahJenis("Standar")
                + " | Premium : " + controller.jumlahJenis("Premium"));
    }

    private void tampilkanPilihanMenu() {
        System.out.println("1. Tambah Member");
        System.out.println("2. Tampilkan Semua Member");
        System.out.println("3. Cari Member");
        System.out.println("4. Update Member");
        System.out.println("5. Hapus Member");
        System.out.println("6. Ringkasan Data Gym");
        System.out.println("7. Keluar");
    }

    private void prosesTambahMember() {
        System.out.println("===== TAMBAH MEMBER =====");
        String nama = bacaNama("Masukkan Nama : ");
        int usia = bacaInteger("Masukkan Usia (15-100) : ", 15, 100);
        int jenisMember = pilihJenisMember();
        PaketGym paket = pilihPaket();
        animasi("Menyimpan data member");
        Member member = controller.tambahMember(nama, usia, paket, jenisMember);
        System.out.println("Member berhasil ditambahkan!");
        System.out.println("ID Member : " + member.getIdMember());
        System.out.println("Jenis     : " + member.getJenisMember());
        System.out.println("Paket     : " + member.getPaket().getNama());
        System.out.println("Biaya     : Rp" + formatRupiah(member.getBiaya()));
        System.out.println("Berlaku   : " + member.getTanggalBerakhirFormatted());
    }

    private void prosesTampilkanMember() {
        if (controller.kosong()) {
            System.out.println("Belum ada data member gym.");
            return;
        }
        System.out.println("===== DAFTAR MEMBER GYM =====");
        System.out.println("1. Urut berdasarkan ID");
        System.out.println("2. Urut berdasarkan Nama");
        int pilihan = bacaInteger("Pilih tampilan (1-2): ", 1, 2);
        ArrayList<Member> daftar = pilihan == 1
                ? controller.getDaftarMember()
                : controller.urutkanNama();
        daftar.forEach(this::tampilkanInfoMember);
    }

    private void prosesCariMember() {
        if (controller.kosong()) {
            System.out.println("Belum ada data member untuk dicari.");
            return;
        }
        System.out.println("===== CARI MEMBER =====");
        System.out.println("1. Cari berdasarkan ID");
        System.out.println("2. Cari berdasarkan Nama");
        int pilihan = bacaInteger("Pilih pencarian (1-2): ", 1, 2);
        if (pilihan == 1) {
            String id = bacaId("Masukkan ID Member (contoh GYM001): ");
            Member member = controller.cariMember(id);
            if (member == null) {
                System.out.println("ID member tidak ditemukan.");
            } else {
                tampilkanInfoMember(member);
            }
            return;
        }
        String nama = bacaNonKosong("Masukkan nama/kata kunci: ");
        ArrayList<Member> hasil = controller.cariBerdasarkanNama(nama);
        if (hasil.isEmpty()) {
            System.out.println("Member dengan nama tersebut tidak ditemukan.");
            return;
        }
        System.out.println("Ditemukan " + hasil.size() + " member:");
        hasil.forEach(this::tampilkanInfoMember);
    }

    private void prosesUpdateMember() {
        if (controller.kosong()) {
            System.out.println("Belum ada data member yang bisa diupdate.");
            return;
        }
        System.out.println("===== UPDATE MEMBER =====");
        String id = bacaId("Masukkan ID Member yang ingin diupdate: ");
        Member member = controller.cariMember(id);
        if (member == null) {
            System.out.println("ID member tidak ditemukan. Update dibatalkan.");
            return;
        }
        System.out.println("Data lama:");
        tampilkanInfoMember(member);
        System.out.println("Masukkan data baru.");
        String nama = bacaNama("Nama baru : ");
        int usia = bacaInteger("Usia baru (15-100) : ", 15, 100);
        System.out.println();
        System.out.println("===== PILIH JENIS MEMBER BARU =====");
        int jenisMember = pilihJenisMember();
        System.out.println();
        System.out.println("===== PILIH PAKET GYM BARU =====");
        PaketGym paket = pilihPaket();
        if (!konfirmasi("Simpan perubahan data member? (Y/N): ")) {
            System.out.println("Update dibatalkan.");
            return;
        }
        controller.updateMember(id, nama, usia, paket, jenisMember);
        animasi("Memperbarui data");
        System.out.println("Data member berhasil diupdate.");
    }

    private void prosesHapusMember() {
        if (controller.kosong()) {
            System.out.println("Belum ada data member yang bisa dihapus.");
            return;
        }
        System.out.println("===== HAPUS MEMBER =====");
        String id = bacaId("Masukkan ID Member yang ingin dihapus: ");
        Member member = controller.cariMember(id);
        if (member == null) {
            System.out.println("ID member tidak ditemukan.");
            return;
        }
        tampilkanInfoMember(member);
        if (!konfirmasi("Yakin ingin menghapus member ini? (Y/N): ")) {
            System.out.println("Penghapusan dibatalkan.");
            return;
        }
        animasi("Menghapus data");
        controller.hapusMember(id);
        System.out.println("Data member berhasil dihapus.");
    }

    private int pilihJenisMember() {
        System.out.println("===== PILIH JENIS MEMBER =====");
        System.out.println();
        System.out.println("1. MEMBERSHIP STANDAR");
        System.out.println("   Keuntungan:");
        System.out.println("   - Akses alat gym (cardio & beban) pada jam operasional reguler");
        System.out.println("   - Loker harian (tanpa kunci pribadi)");
        System.out.println("   - Akses hanya di 1 cabang tempat daftar");
        System.out.println("   - Kamar mandi & shower standar");
        System.out.println();
        System.out.println("2. MEMBERSHIP PREMIUM (+Rp500.000)");
        System.out.println("   Keuntungan:");
        System.out.println("   - Akses gym 24 jam + semua alat/zona eksklusif");
        System.out.println("   - Personal trainer (beberapa sesi gratis per bulan)");
        System.out.println("   - Konsultasi & program latihan dan nutrisi personal");
        System.out.println("   - Akses ke semua cabang (multi-branch)");
        System.out.println("   - Fasilitas tambahan: sauna & kolam renang");
        System.out.println("   - Loker pribadi dengan kunci");
        System.out.println();
        int pilihan = bacaInteger("Pilih jenis member (1-2): ", 1, 2);
        System.out.println(pilihan == 1
                ? "Anda memilih Membership Standar."
                : "Anda memilih Membership Premium dengan fasilitas tambahan yang lebih lengkap.");
        return pilihan;
    }

    private PaketGym pilihPaket() {
        System.out.println("===== PILIH PAKET GYM =====");
        System.out.println("1. Bulanan - Rp" + formatRupiah(PaketGym.BULANAN.getHarga()) + " / " + PaketGym.BULANAN.getDurasi());
        System.out.println("2. Tahunan - Rp" + formatRupiah(PaketGym.TAHUNAN.getHarga()) + " / " + PaketGym.TAHUNAN.getDurasi());
        return PaketGym.dariPilihan(bacaInteger("Pilih paket (1-2): ", 1, 2));
    }

    private void tampilkanRingkasan() {
        System.out.println("===== RINGKASAN DATA GYM =====");
        System.out.println("Total member          : " + controller.jumlahMember());
        System.out.println("Member aktif          : " + controller.jumlahMemberAktif());
        System.out.println("Member reguler        : " + controller.jumlahJenis("Standar"));
        System.out.println("Member premium        : " + controller.jumlahJenis("Premium"));
        System.out.println("Paket bulanan         : " + controller.jumlahPaket(PaketGym.BULANAN));
        System.out.println("Paket tahunan         : " + controller.jumlahPaket(PaketGym.TAHUNAN));
        System.out.println("Total nilai membership: Rp" + formatRupiah(controller.totalNilaiPaket()));
    }

    private void tampilkanInfoMember(Member member) {
        System.out.println("-----------------------------------------------");
        System.out.println("ID Member       : " + member.getIdMember());
        System.out.println("Nama            : " + member.getNama());
        System.out.println("Usia            : " + member.getUsia() + " tahun");
        System.out.println("Jenis Member    : " + member.getJenisMember());
        System.out.println("Paket           : " + member.getPaket().getNama());
        System.out.println("Biaya           : Rp" + formatRupiah(member.getBiaya()));
        System.out.println("Tanggal Daftar  : " + member.getTanggalDaftarFormatted());
        System.out.println("Berlaku Sampai  : " + member.getTanggalBerakhirFormatted());
        System.out.println("Status          : " + member.getStatus());
        System.out.println("Fasilitas       : " + member.getFasilitas().replace("\n", "\n                  "));
        System.out.println("-----------------------------------------------");
    }

    private String bacaNama(String pesan) {
        while (true) {
            String nama = bacaNonKosong(pesan);
            if (nama.length() < 3) {
                System.out.println("Nama minimal 3 karakter.");
                continue;
            }
            if (nama.length() > 50) {
                System.out.println("Nama maksimal 50 karakter.");
                continue;
            }
            if (!nama.matches("[a-zA-ZÀ-ÿ .'-]+")) {
                System.out.println("Nama hanya boleh berisi huruf dan tanda baca nama yang umum.");
                continue;
            }
            return nama.trim().replaceAll("\\s+", " ");
        }
    }

    private String bacaId(String pesan) {
        while (true) {
            String id = bacaNonKosong(pesan).toUpperCase();
            if (!id.matches("GYM\\d{3,}")) {
                System.out.println("Format ID salah. Contoh yang benar: GYM001.");
                continue;
            }
            return id;
        }
    }

    private String bacaNonKosong(String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input tidak boleh kosong. Silakan isi kembali.");
        }
    }

    private int bacaInteger(String pesan, int minimal, int maksimal) {
        while (true) {
            String input = bacaNonKosong(pesan);
            try {
                int angka = Integer.parseInt(input);
                if (angka < minimal || angka > maksimal) {
                    System.out.println("Nilai harus berada di antara " + minimal + " dan " + maksimal + ".");
                    continue;
                }
                return angka;
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    private boolean konfirmasi(String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                return true;
            }
            if (input.equals("N")) {
                return false;
            }
            System.out.println("Masukkan Y untuk Ya atau N untuk Tidak.");
        }
    }

    private void animasi(String pesan) {
        System.out.print(pesan);
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            System.out.print(".");
        }
        System.out.println();
    }

    private String formatRupiah(long angka) {
        return String.format("%,d", angka).replace(',', '.');
    }
}
