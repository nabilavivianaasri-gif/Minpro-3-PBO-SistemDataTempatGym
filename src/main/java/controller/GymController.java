package controller;

import java.util.ArrayList;
import model.DataGym;
import model.Member;
import model.PaketGym;

public class GymController {
    private final DataGym dataGym;

    public GymController() {
        dataGym = new DataGym();
    }

    public boolean kosong() {
        return dataGym.kosong();
    }

    public int jumlahMember() {
        return dataGym.jumlahMember();
    }

    public int jumlahMemberAktif() {
        return dataGym.jumlahMemberAktif();
    }

    public int jumlahJenis(String jenis) {
        return dataGym.jumlahJenis(jenis);
    }

    public int jumlahPaket(PaketGym paket) {
        return dataGym.jumlahPaket(paket);
    }

    public long totalNilaiPaket() {
        return dataGym.totalNilaiPaket();
    }

    public Member tambahMember(String nama, int usia, PaketGym paket) {
        return dataGym.tambahMember(nama, usia, paket, 1);
    }

    public Member tambahMember(String nama, int usia, PaketGym paket, int jenisMember) {
        return dataGym.tambahMember(nama, usia, paket, jenisMember);
    }

    public ArrayList<Member> getDaftarMember() {
        return dataGym.getDaftarMember();
    }

    public Member cariMember(String id) {
        return dataGym.cariMember(id);
    }

    public ArrayList<Member> cariBerdasarkanNama(String nama) {
        return dataGym.cariBerdasarkanNama(nama);
    }

    public boolean updateMember(String id, String nama, int usia, PaketGym paket, int jenisMember) {
        return dataGym.updateMember(id, nama, usia, paket, jenisMember);
    }

    public boolean hapusMember(String id) {
        return dataGym.hapusMember(id);
    }

    public ArrayList<Member> urutkanNama() {
        return dataGym.urutkanNama();
    }
}
