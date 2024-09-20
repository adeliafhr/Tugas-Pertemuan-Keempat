/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

/**
 *
 * @author Lenovo
 */
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
