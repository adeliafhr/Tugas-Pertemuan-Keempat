# CRUD DATABASE, TRY CATCH EXCEPTION, THROWS EXCEPTION, CUSTOM EXCEPTION
## Crud Database
CRUD adalah singkatan dari Create, Read, Update, dan Delete, yaitu operasi dasar dalam pengolahan data di database khususnya pada database yang relasional. CRUD dapat diterapkan secara luas di berbagai jenis database seperti MySQL, PostgreeSQL, MongoDB, dan sejenisnya. Namun, pada tugas ini kita menerapkan pada jenis database PostgreeSQL. Selain itu, CRUD adalah fondasi dasar dalam pengembangan sistem atau aplikasi yang berhubungan dengan pengolahan data. Ini karena hampir semua aplikasi yang menggunakan database melibatkan operasi CRUD dalam penggunaannya.<br>

## Fungsi Crud
- Create -> Pembuatan database dan juga aktivitas memasukkan data baru ke dalam database.
- Read -> Menampilkan data atau record yang tersimpan dalam database.
- Update -> Mengupdate atau memperbarui data yang sudah ada dalam database.
- Delete -> Menghapus database maupun data atau record yang berada di database.
## Program yang Digunakan
- Bahasa Pemrogaraman : Java
- Database : PostgreeSQL
<br><br>Jika program pada crud.java di jalankan maka akan keluar output seperti ini :
<pre>
   MENU UTAMA 
1. Input Data dalam tabel
2. Tampilkan Data dalam tabel
3. Delete Data dalam tabel
4. Update Data dalam tabel
0. Selesai
Pilihlah Sesuai Keingininan ->
</pre>
  
# Try Catch Exception
## Pengertian Exception 
Exceptions adalah objek yang mewakili kesalahan ketika menjalankan kode program. Exceptions dapat dipakai untuk menghentikan program secara terkendali dan memberikan pesan kesalahan kepada user.
## Jenis Exception dalam Bahasa Java
- ArithmeticException : Terjadi kesalahan aritmatika, seperti pembagian dengan nol.
- NullPointerException : Terjadi kesalahan karena mencoba mengakses objek yang null.
- ArrayIndexOutOfBoundsException : Terjadi kesalahan karena mencoba mengakses elemen array di luar batas.
- NumberFormatException : Terjadi kesalahan karena mencoba mengubah string ke tipe data numerik yang tidak valid.
- FileNotFoundException : Terjadi kesalahan karena mencoba membuka file yang tidak ada.

## Pengertian Try Catch 
Try-catch adalah konstruksi dalam pemrograman yang digunakan untuk menangani pengecualian (exception) atau kesalahan yang mungkin terjadi selama eksekusi program. Dengan menggunakan try-catch, kita dapat mengelola kesalahan dengan cara yang terstruktur, sehingga program tidak berhenti secara tiba-tiba dan dapat memberikan umpan balik yang berguna kepada pengguna. 
## Struktur Try Catch
Struktur ini terdiri dari dua blok kode, yaitu blok try dan blok catch. 
- Blok try berisi kode yang berpotensi menimbulkan exceptions
- Blok catch digunakan untuk menangani exceptions yang terjadi di blok try.
## Berikut adalah source code dari try catch 
<pre>
```java

 public static void main(String[] args) {
        BelajarException pembagian = new BelajarException();
        String huruf [] = {"a","b","c"};
        try{
            pembagian.bagiBilangan(5, 5);
            System.out.println(huruf[5]);
        }catch (ArithmeticException e){
            System.out.println("Error Aritmetik");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error kapasitas array melebihi batas");
        }
    }
</pre>
Output : 
<pre>
Hasil: 1
Error kapasitas array melebihi batas
</pre>
Dalam kode ini kita buat objek pembagian dari class BelajarException untuk memanggil metode yang ada di dalamnya dan buat array huruf yang berisi 3 elemen yaitu “a”, “b” , “c”
- Blok Try <br> Dalam blok try, kita memanggil metode pembagian untuk mencoba program yang akan dijalankan yaitu memasukan angka 5 dibagi dengan 5 hasilnya adalah 1 dan ini akan di cetak. Kita juga mencoba untuk mencetak elemen ke-6 dari array (huruf[5]). Namun, array tersebut hanya memiliki tiga elemen (indeks 0, 1, dan 2), jadi ini akan menyebabkan kesalahan.
- Blok Catch <br> Jika terjadi kesalahan pada blok try maka catch akan menangkap kesalahan tersebut : <br>
Jika terjadi kesalahan aritmetika (seperti pembagian dengan nol), program mencetak "Error Aritmetik". Namun, dalam kasus ini, kesalahan yang terjadi adalah ArrayIndexOutOfBoundsException karena kita mencoba mengakses indeks yang tidak ada di array. Program akan mencetak "Error kapasitas array melebihi batas".

## Throws Exception
Throws adalah keyword yang digunakan dalam deklarasi metode untuk menyatakan bahwa metode tersebut dapat melempar (throw) satu atau lebih jenis exception. Ini memberi tahu pemanggil metode bahwa mereka perlu menangani exception tersebut, baik dengan menangkapnya menggunakan blok try-catch atau dengan meneruskan exception ke metode yang lebih tinggi dalam tumpukan pemanggilan.
## Jenis Exception
- Checked Exception: Exception yang harus ditangani atau dinyatakan dengan throws. Contoh: IOException, SQLException.
- Unchecked Exception: Exception yang tidak perlu ditangani secara eksplisit. Contoh: ArithmeticException, NullPointerException. <br>
## Berikut adalah source code dari throws exception
<pre>
   public void bagiBilangan(int a, int b) throws ArithmeticException {
        int bil = a / b;
        System.out.println("Hasil: " + bil);
    }
</pre>
Dalam kode ini terdapat metode yang melakukan pembagian bilangan dimana metode ini menerima 2 parameter bertipe integer yaitu int a dan int b. Metode ini melakukan pembagian a dengan b dan menyimpan hasilnya dalam variabel bil. Jika b adalah nol, maka akan terjadi kesalahan (exception) aritmetika. Namun pada metode ini tidak ada penanganannya karena hanya menggunakan metode throws yang artinya kesalahan hanya di lempar saja tanpa di tangani. Meski kita tidak menangkapnya di sini, metode ini menyatakan bahwa bisa terjadi ArithmeticException.

## Custom Exception
Custom exception adalah exception yang dibuat oleh programmer sendiri dengan memperluas kelas Exception atau RuntimeException. Ini memungkinkan pengembang untuk mendefinisikan jenis kesalahan spesifik yang relevan dengan aplikasi mereka.
## Berikut adalah source code dari custom exception
<pre> 
  public class AdelException extends Exception {
    public AdelException(String s){
        super(s);
    }
    public static void main(String[] args) {
        try {
            throw new AdelException("ada kesalahan disini, coba lempar");
        } catch (AdelException ex) {
            System.out.println("coba tangkap kesalahan " + String.valueOf(ex));
        }
    }
}
</pre>
Output : 
<pre>
  coba tangkap kesalahan pertemuankeempat.AdelException: ada kesalahan disini, coba lempar
</pre>
Dalam kode ini kita buat kelas baru bernama AdelException yang merupakan turunan dari kelas Exception. Ini berarti AdelException adalah jenis kesalahan (exception) yang dapat kita buat sendiri. Kelas ini memiliki konstruktor yang menerima satu parameter bertipe String. Parameter ini digunakan untuk menyimpan pesan kesalahan yang akan ditampilkan saat exception ini terjadi. Kata kunci super(s) memanggil konstruktor dari kelas Exception untuk mengatur pesan kesalahan. <br>
Buat metode main untuk mengeksekusi program, dimana dalam blok try, kita "melempar" atau throw sebuah objek AdelException dengan pesan "ada kesalahan disini, coba lempar". Ini menyebabkan exception terjadi. Setelah program dilempar, maka akan di tangkap oleh blok catch dan diikuti dengan informasi tentang exception yang ditangkap. 



