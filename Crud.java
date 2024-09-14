package pertemuankeempat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Crud {

    private Connection conn;
    private PreparedStatement pstmt = null;

//    private String driver = "org.postgresql.Driver";
    private String koneksi = "jdbc:postgresql://localhost:5432/PBO_4";
    private String user = "postgres";
    private String password = "adelia19";
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public void tambah() {
        boolean isRunning = true;
        while (isRunning) {
            try {
                conn = DriverManager.getConnection(koneksi, user, password);
                conn.setAutoCommit(false); // Disable auto-commit

                String sql = "INSERT INTO barang (id_barang,nama_barang,harga) VALUES (?, ?, ?);";
                pstmt = conn.prepareStatement(sql);

                System.out.println("MASUKKAN DATA BARANG ");
                System.out.print("ID Barang : ");
                String id_barang = input.readLine().trim();
                System.out.print("Nama Barang : ");
                String nama_barang = input.readLine().trim();
                System.out.print("Harga : ");
                String harga = input.readLine().trim();

                pstmt.setInt(1, Integer.parseInt(id_barang));
                pstmt.setString(2, nama_barang);
                pstmt.setLong(3, Long.parseLong(harga));
                pstmt.executeUpdate();

                conn.commit(); // Commit transaction after successful insert
                System.out.println("Data berhasil ditambahkan.");
                System.out.print("Apakah Anda ingin memasukkan data barang lainnya? (iya/tidak): ");
                String pilihan = input.readLine().trim();
                if (pilihan.equalsIgnoreCase("tidak")) {
                    isRunning = false;
                }
            } catch (SQLException e) {
                System.out.println("Terjadi kesalahan saat melakukan operasi insert: " + e.getMessage());
                try {
                    if (conn != null) conn.rollback(); // Rollback on error
                } catch (SQLException rollbackEx) {
                    System.out.println("Gagal melakukan rollback: " + rollbackEx.getMessage());
                }
            } catch (IOException e) {
                System.out.println("Terjadi kesalahan input: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Pastikan ID Barang dan Harga adalah angka.");
            } finally {
                closeResources();
            }
        }
    }

    public void tampil() {
        try {
            String sql = "SELECT * FROM barang";
            conn = DriverManager.getConnection(koneksi, user, password);
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getLong(1) + " " + rs.getString(2) + " " + rs.getLong(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources();
        }
    }

    public void hapus() {
        try {
//            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            System.out.print("Masukkan ID Barang yang akan dihapus : ");
            String idBarangToDelete = input.readLine().trim();

            String deleteSql = "DELETE FROM barang WHERE id_barang = ?";
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.setLong(1, Long.parseLong(idBarangToDelete));
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("ID Barang " + idBarangToDelete + " berhasil dihapus!");
            } else {
                System.out.println("ID Barang " + idBarangToDelete + " tidak ditemukan.");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources();
        }
    }

    public void update() {
        try {
            conn = DriverManager.getConnection(koneksi, user, password);

            System.out.print("Masukkan ID Barang yang akan diupdate: ");
            String idBarang = input.readLine().trim();
            System.out.print("Nama Barang baru: ");
            String namaBarangBaru = input.readLine().trim();
            System.out.print("Harga baru: ");
            String hargaBaru = input.readLine().trim();

            String sql = "UPDATE barang SET nama_barang = ?, harga = ? WHERE id_barang = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, namaBarangBaru);
            pstmt.setLong(2, Long.parseLong(hargaBaru));
            pstmt.setLong(3, Long.parseLong(idBarang));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil diupdate.");
            } else {
                System.out.println("Data tidak ditemukan.");
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResources();
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\n ========= MENU UTAMA =========");
            System.out.println("1. Input Data");
            System.out.println("2. Tampil Data");
            System.out.println("3. Hapus Data");
            System.out.println("4. Update Data");
            System.out.println("0. Keluar");
            System.out.print("PILIHAN> ");

            try {
                int pilihan = Integer.parseInt(input.readLine());
                switch (pilihan) {
                    case 0:
                        System.out.println("Keluar dari program.");
                        return; // Exit the menu loop
                    case 1:
                        tambah();
                        break;
                    case 2:
                        tampil();
                        break;
                    case 3:
                        hapus();
                        break;
                    case 4:
                        update();
                        break;
                    default:
                        System.out.println("Pilihan salah! Silakan coba lagi.");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println("Input tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void closeResources() {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Gagal menutup koneksi.");
        }
    }

    public static void main(String[] args) {
        new Crud().menu();
    }
}