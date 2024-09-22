# CRUD DATABASE, TRY CATCH EXCEPTION, THROWS EXCEPTION, CUSTOM EXCEPTION

## 🗂️ Table Of Contents
- [Crud Database](https://github.com/adeliafhr/Tugas-Pertemuan-Keempat/blob/main/Crud.java)
- [Try Catch Exception](https://github.com/adeliafhr/Tugas-Pertemuan-Keempat/blob/main/BelajarException.java)
- [Throws Exception](https://github.com/adeliafhr/Tugas-Pertemuan-Keempat/blob/main/BelajarException.java)
- [Custom Exception](https://github.com/adeliafhr/Tugas-Pertemuan-Keempat/blob/main/AdelException.java)
---
## 📊 Crud Database
CRUD adalah singkatan dari Create, Read, Update, dan Delete, yaitu operasi dasar dalam pengolahan data di database.
### Create (tambah)
Create digunakan untuk memasukkan data baru ke dalam database. Pada operasi ini, pengguna memasukkan informasi Barang seperti ID Barang, Nama Braang, dan Harga. Data yang dimasukkan akan tersimpan pada tabel Barang. Jika sudah menambah satu data maka akan muncul opsi untuk menambah data lagi atau tidak.
### Read (tampil)
Read digunakan untuk menampilkan data yang tersimpan dalam database. Pada kode ini, SQL select digunakan untuk menampilkan data yang tersimpan pada database.
### Update (mengubah)
Update digunakan untuk mengubah data yang sudah ada dalam database. Pada operasi ini, pengguna memasukkan ID Barang yang akan diubah lalu mengubah informasi yang ingin diubah seperti Nama Barang dan Harga.
### Delete (Menghapus)
Delete digunakan untuk menghapus data yang ada pada database. Pada operasi ini, pengguna memasukkan ID Barang yang akan di hapus, kemudian data akan terhapus secara otomatis.

---
## ⚠️ Exception 
Exception adalah objek yang mewakili kesalahan ketika menjalankan kode program. Exception dapat dipakai untuk menghentikan program secara terkendali dan memberikan pesan kesalahan kepada pengguna.
### Jenis Exception
- ArithmeticException : Terjadi kesalahan aritmatika, seperti pembagian dengan nol.
- ArrayIndexOutOfBoundsException : Terjadi kesalahan karena mencoba mengakses elemen array di luar batas.

## 🛡️ Try Catch Exception
Try-catch adalah konstruksi dalam pemrograman yang digunakan untuk menangani pengecualian (exception) atau kesalahan yang mungkin terjadi selama eksekusi program. Dengan menggunakan try-catch, kita dapat mengelola kesalahan dengan cara yang terstruktur, sehingga program tidak berhenti secara tiba-tiba dan dapat memberikan umpan balik yang berguna kepada pengguna. 
### Struktur Try Catch
Struktur ini terdiri dari dua blok kode, yaitu blok try dan blok catch. 
- Blok try berisi kode yang berpotensi menimbulkan exceptions
- Blok catch digunakan untuk menangani exceptions yang terjadi di blok try.
### Berikut adalah source code dari try catch 
<pre>
 public static void main(String[] args) {
        BelajarException pembagian = new BelajarException();
        try{
            pembagian.bagiBilangan(5, 0);
        }catch (ArithmeticException e){
            System.out.println("Error Aritmetik");
        }
    }
</pre>
Output : 
<pre>
Error Aritmetik
</pre>
Dalam kode ini kita buat objek pembagian dari class BelajarException untuk memanggil metode yang ada di dalamnya
- **Blok Try** Dalam blok try, kita memanggil metode pembagian untuk mencoba program yang akan dijalankan yaitu memasukan angka 5 dibagi dengan 0. Namun, semua bilangan yang dibagi dengan 0 tidak bisa, maka ini akan menyebabkan kesalahan.
- **Blok Catch** Jika terjadi kesalahan pada blok try maka catch akan menangkap kesalahan tersebut : <br>
Pada kasus ini kesalahan yang terjadi adalah dikarenakan angka 5 tidak bisa dibagi dengan 0  maka program akan mencetak "Error Aritmetik".

## ⏳ Throws Exception
Throws adalah keyword yang digunakan dalam deklarasi metode untuk menyatakan bahwa metode tersebut dapat melempar (throw) satu atau lebih jenis exception. Ini memberi tahu pemanggil metode bahwa mereka perlu menangani exception tersebut, baik dengan menangkapnya menggunakan blok try-catch.
### Berikut adalah source code dari throws exception
<pre>
   public void bagiBilangan(int a, int b) throws ArithmeticException {
        int bil = a / b;
        System.out.println("Hasil: " + bil);
    }
</pre>
Dalam kode ini terdapat metode yang melakukan pembagian bilangan dimana metode ini menerima 2 parameter bertipe integer yaitu int a dan int b. Metode ini melakukan pembagian a dengan b dan menyimpan hasilnya dalam variabel bil. Jika b adalah nol, maka akan terjadi kesalahan (exception) aritmetika. Namun pada metode ini tidak ada penanganannya karena hanya menggunakan metode throws yang artinya kesalahan hanya di lempar saja tanpa di tangani. Meski kita tidak menangkapnya di sini, metode ini menyatakan bahwa bisa terjadi ArithmeticException.

---
## 🛠️ Custom Exception
Custom exception adalah exception yang dibuat oleh programmer sendiri dengan memperluas kelas Exception.
### Berikut adalah source code dari custom exception
<pre> 
  public class AdelException extends ArithmeticException {
    public AdelException(String s){
        super(s);
    }
    
    public static int bagiBilangan(int a, int b) throws AdelException {       
        if (b == 0) {
            throw new AdelException("pembagian dengan nol ");
        }
        return a / b;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            int result = bagiBilangan(5, 0);
            System.out.println("hasil  " + result);
        }catch (AdelException e){
            System.out.println("coba tangkap kesalahan " + e.getMessage() );
        }
    }
}
</pre>
Output : 
<pre>
coba tangkap kesalahan pembagian dengan nol 
</pre>
Dalam kode ini kita buat kelas baru bernama AdelException yang merupakan jenis kesalahan khusus untuk menangani pembagian dengan nol. Kelas ini mewarisi dari ArithmeticException yang berarti akan terjadi kesalahan aritmatika. Selanjutnya Buat metode bagiBilangan untuk melakukan operasi pembagian dua bilangan yaitu a / b. Jika b sama dengan nol maka metode ini akan melempar (throw) kesalahan AdelException dengan pesan "pembagian dengan nol". Namun, jika b tidak nol maka akan mengembalikan hasil nilai a / b. Kemudian Buat metode main untuk mengeksekusi program, dimana kita mencoba membagi 5 dengan 0, karena angka 5 dibagi dengan 0 maka kesalahan ini ditangkap dalam blok catch dan pesan kesalahan di tampilkan.

---
## 📝 Kesimpulan
- **CRUD** adalah operasi yang digunakan untuk mengelola data pada database yang terdiri dari Create, Read, Update, Delete
- **Try-Catch Exception** digunakan untuk menangani kesalahan ketika terjadi saat program di eksekusi
- **Throws Exception** berfungsi untuk melempar kesalahan dan kesalahan ditangkap oleh Try-Catch
- **Custom Exception** dirancang untuk memberikan penanganan kesalahan yang lebih spesifik
---
### 💡Selamat Belajar dan Bereksplorasi menggunakan konsep CRUD, Exception Handling, dan Custom Exception FIGHTING!!!🔍


