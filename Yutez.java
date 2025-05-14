package yutez;

class Mahasiswa {
    private String NIM;
    private String nama;
    private String kelas;
    private String alamat;

    public Mahasiswa(String NIM, String nama, String kelas, String alamat) {
        this.NIM = NIM;
        this.nama = nama;
        this.kelas = kelas;
        this.alamat = alamat;
    }

    public String getNIM() {
        return NIM;
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public String getAlamat() {
        return alamat;
    }
}

public class Yutez {
    public static void main(String[] args) {
        // 1. Data Mahasiswa
        Mahasiswa[] daftarMahasiswa = {
            new Mahasiswa("23612091140", "Natanael Siahaan", "BDRM23A", "Medan"),
            new Mahasiswa("23612091111", "Kasep", "BDRM23A", "Semarang"),
            new Mahasiswa("23612091607", "Saiful", "BDRM23A", "Tanjung kusta")
        };

        // 2. Matriks nilai (Sesuaikan dengan jumlah mahasiswa)
        String[][] nilaiMatriks = {
            {"AB", "A"},   // Nilai Natanael
            {"B", "BC"},   // Nilai Kasep
            {"CD", "E"}    // Nilai Saiful
        };

        // Menampilkan tabel nilai
        System.out.println("|    | Algoritma 1 | DDTI    |");
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            System.out.printf("| %-3s| %-10s | %-7s |\n", 
                daftarMahasiswa[i].getNama().substring(0, 3), // Ambil 3 karakter pertama nama
                nilaiMatriks[i][0], 
                nilaiMatriks[i][1]);
        }

        // 3. Pencarian nilai berdasarkan digit terakhir NIM
        System.out.println("\nHasil Pencarian Nilai:");
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            Mahasiswa mhs = daftarMahasiswa[i];
            String nim = mhs.getNIM();
            int lastDigit = Character.getNumericValue(nim.charAt(nim.length() - 1));

            System.out.println("Nama: " + mhs.getNama());
            System.out.println("NIM: " + nim + " (Digit Terakhir: " + lastDigit + ")");
            System.out.print("Nilai: ");
            
            String[] nilai = nilaiMatriks[i];
            if (lastDigit % 2 == 0) {
                for (String n : nilai) {
                    if (n.equals("A") || n.equals("C") || n.equals("E")) {
                        System.out.print(n + " ");
                    }
                }
            } else {
                for (String n : nilai) {
                    if (n.equals("AB") || n.equals("B") || n.equals("BC") || n.equals("CD")) {
                        System.out.print(n + " ");
                    }
                }
            }
            System.out.println("\n");
        }

        // 4. Fungsi rekursif: Faktorial
        int totalNilai = 5;
        System.out.println("Faktorial dari " + totalNilai + ": " + faktorial(totalNilai));
    }

    public static int faktorial(int n) {
        if (n <= 1) return 1;
        return n * faktorial(n - 1);
    }
}