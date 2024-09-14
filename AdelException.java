/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

/**
 *
 * @author Lenovo
 */
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
