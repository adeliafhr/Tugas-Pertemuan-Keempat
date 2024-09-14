/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

/**
 *
 * @author Lenovo
 */
public class BelajarException {

    // Metode dengan throws
    public void bagiBilangan(int a, int b) throws ArithmeticException {
        int bil = a / b;
        System.out.println("Hasil: " + bil);
    }

    public static void main(String[] args) {
        BelajarException pembagian = new BelajarException();
        String huruf [] = {"a","b","c"};
        try{
            pembagian.bagiBilangan(5, 5);
            System.out.println(huruf[2]);
        }catch (ArithmeticException e){
            System.out.println("Error Aritmetik");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error kapasitas array melebihi batas");
        }
    }
}

