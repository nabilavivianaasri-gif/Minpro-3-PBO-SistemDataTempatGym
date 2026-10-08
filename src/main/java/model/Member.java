package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Member implements MemberBenefit {
    private static final DateTimeFormatter FORMAT_TANGGAL =
            DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.of("id", "ID"));

    private final String idMember;
    private String nama;
    private int usia;
    private PaketGym paket;
    private final LocalDate tanggalDaftar;
    private LocalDate tanggalBerakhir;

    protected Member(String idMember, String nama, int usia, PaketGym paket) {
        validasiId(idMember);
        this.idMember = idMember.trim().toUpperCase();
        this.tanggalDaftar = LocalDate.now();
        setNama(nama);
        setUsia(usia);
        setPaket(paket);
    }

    private void validasiId(String idMember) {
        if (idMember == null || idMember.isBlank()) {
            throw new IllegalArgumentException("ID member tidak boleh kosong.");
        }
        if (!idMember.trim().toUpperCase().matches("GYM\\d{3,}")) {
            throw new IllegalArgumentException("Format ID harus seperti GYM001.");
        }
    }

    public String getIdMember() {
        return idMember;
    }

    public String getNama() {
        return nama;
    }

    public int getUsia() {
        return usia;
    }

    public PaketGym getPaket() {
        return paket;
    }

    public LocalDate getTanggalDaftar() {
        return tanggalDaftar;
    }

    public LocalDate getTanggalBerakhir() {
        return tanggalBerakhir;
    }

    public final void setNama(String nama) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong.");
        }
        String namaBersih = nama.trim().replaceAll("\\s+", " ");
        if (namaBersih.length() < 3) {
            throw new IllegalArgumentException("Nama minimal 3 karakter.");
        }
        if (namaBersih.length() > 50) {
            throw new IllegalArgumentException("Nama maksimal 50 karakter.");
        }
        if (!namaBersih.matches("[a-zA-ZÀ-ÿ .'-]+")) {
            throw new IllegalArgumentException("Nama hanya boleh berisi huruf dan tanda baca nama yang umum.");
        }
        this.nama = namaBersih;
    }

    public final void setUsia(int usia) {
        if (usia < 15 || usia > 100) {
            throw new IllegalArgumentException("Usia harus antara 15 sampai 100 tahun.");
        }
        this.usia = usia;
    }

    public final void setPaket(PaketGym paket) {
        if (paket == null) {
            throw new IllegalArgumentException("Paket gym wajib dipilih.");
        }
        this.paket = paket;
        hitungTanggalBerakhir();
    }

    private void hitungTanggalBerakhir() {
        tanggalBerakhir = paket == PaketGym.BULANAN
                ? tanggalDaftar.plusMonths(1)
                : tanggalDaftar.plusYears(1);
    }

    public abstract String getJenisMember();

    public int getBiaya() {
        return paket.getHarga();
    }

    public boolean isAktif() {
        return !LocalDate.now().isAfter(tanggalBerakhir);
    }

    public String getStatus() {
        return isAktif() ? "AKTIF" : "NONAKTIF";
    }

    public String getTanggalDaftarFormatted() {
        return tanggalDaftar.format(FORMAT_TANGGAL);
    }

    public String getTanggalBerakhirFormatted() {
        return tanggalBerakhir.format(FORMAT_TANGGAL);
    }
}
