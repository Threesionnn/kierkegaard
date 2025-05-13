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

public class TugasUTS {
    public static void main(String[] args) {
        // 1. Membuat data mahasiswa
        Mahasiswa[] daftarMahasiswa = {
            new Mahasiswa("1234567890", "Budi Santoso", "IF-01", "Jl. Merdeka No. 1")
        };

        // 2. Membuat matriks nilai mahasiswa
        String[][] nilaiMatriks = {
            {"AB", "A"}  // Nilai untuk Algoritma 1 dan DDTI
        };

        // Menampilkan tabel nilai
        System.out.println("|    | Algoritma 1 | DDTI    |");
        System.out.println("|---|---|---|");
        for (String[] nilai : nilaiMatriks) {
            System.out.printf("|    | %-6s | %-4s |\n", nilai[0], nilai[1]);
        }

        // 3. Pencarian nilai berdasarkan digit terakhir NIM
        System.out.println("\nHasil Pencarian Nilai:");
        for (Mahasiswa mhs : daftarMahasiswa) {
            String nim = mhs.getNIM();
            int lastDigit = Character.getNumericValue(nim.charAt(nim.length() - 1));

            System.out.println("NIM: " + nim + " (Digit Terakhir: " + lastDigit + ")");
            System.out.print("Nilai: ");
            
            String[] nilai = nilaiMatriks[0]; // Ambil nilai mahasiswa pertama
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
        int totalNilai = 5; // Contoh nilai
        System.out.println("Faktorial dari " + totalNilai + ": " + faktorial(totalNilai));
    }

    // Fungsi rekursif untuk menghitung faktorial
    public static int faktorial(int n) {
        if (n <= 1) return 1;
        return n * faktorial(n - 1);
    }
}