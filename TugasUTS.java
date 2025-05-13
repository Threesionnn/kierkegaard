public class TugasUTS {
    public static void main(String[] args) {
        // Data Mahasiswa
        Mahasiswa[] daftarMahasiswa = {
            new Mahasiswa("23612091140", "Sion Yehezkiel Nababan", "BDRM23A", "Bandung"),
            new Mahasiswa("23612091053", "Natanael Siahaan", "BDRM23A", "Medan"),
            new Mahasiswa("23612091064", "T Rendi Wijaya", "BDRM23A", "Klaten")
        };

        // Data Mata Kuliah
        String[] mataKuliah = {"Algoritma & Pemrograman II + Praktikum", "E-Commerce + Praktikum"};

        // Nilai huruf masing-masing mahasiswa
        String[][] nilaiHuruf = {
            {"AB", "A"},     
            {"B", "A"},      
            {"A", "B"}       
        };

        // Cetak berdasarkan NIM
        System.out.println("=== Hasil Pencarian NIM ===");
        cariBerdasarkanNIM(daftarMahasiswa, nilaiHuruf, mataKuliah);

        // Hitung total nilai
        System.out.println("\n=== Total Nilai (Rekursif) ===");
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            double total = totalNilaiRekursif(nilaiHuruf[i], 0);
            System.out.println("Total nilai angka " + daftarMahasiswa[i].nama + ": " + total);
        }
    }

    // Fungsi pencarian berdasarkan NIM
    public static void cariBerdasarkanNIM(Mahasiswa[] mahasiswa, String[][] nilaiHuruf, String[] mataKuliah) {
        for (int i = 0; i < mahasiswa.length; i++) {
            System.out.println("NIM: " + mahasiswa[i].nim);
            System.out.println("Nama: " + mahasiswa[i].nama);
            System.out.println("Kelas: " + mahasiswa[i].kelas);
            System.out.println("Asal: " + mahasiswa[i].asal);
            for (int j = 0; j < mataKuliah.length; j++) {
                System.out.println("  Mata kuliah " + mataKuliah[j] + ": " + nilaiHuruf[i][j]);
            }
            System.out.println();
        }
    }

    // Fungsi rekursif untuk menghitung total nilai
    public static double totalNilaiRekursif(String[] nilai, int index) {
        if (index >= nilai.length) {
            return 0;
        }
        double nilaiAngka = konversiNilai(nilai[index]);
        return nilaiAngka + totalNilaiRekursif(nilai, index + 1);
    }

    // Fungsi konversi huruf ke angka
    public static double konversiNilai(String huruf) {
        return switch (huruf) {
            case "A" -> 4.0;
            case "AB" -> 3.5;
            case "B" -> 3.0;
            case "BC" -> 2.5;
            case "C" -> 2.0;
            case "D" -> 1.0;
            case "E" -> 0.0;
            default -> 0.0;
        };
    }
}
