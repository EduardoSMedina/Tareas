/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa02;
import java.util.Random;
/**
 *
 * @author edosi_000
 */
public class Programa02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { //El programa se detiene al encontrar un cuadrado mágico;
        boolean estado = true;
        do{
        int matriz [][] = new int [3][3];
        matriz = LlenarMatriz(matriz);
        MostrarMatriz(matriz);
        estado =VerificarMagico(matriz);
        if(estado == true){
            System.out.println("La Matriz es un cuadrado mágico");
        }else
            System.out.println("La Matriz no es un cuadrado mágico");
        }while(estado != true);
        
    }
    public static int [][] LlenarMatriz( int [][] mat){
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
              mat[i][j] = IngresarNumero(mat);
            }
        }
        return mat;
    }
    public static int IngresarNumero(int [][] mat){
        Random azar = new Random();
        int numero = 0, repetido;
        do{
            repetido = 0;
        numero = azar.nextInt(9)+1;  
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(numero == mat[i][j]){
                repetido++;
                    }
                }
            }
        }while(repetido!=0);
        return numero;
    }
    public static void MostrarMatriz(int [][] mat){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) 
                System.out.print(mat[i][j]+ "\t");
                System.out.println("");
            
        }
    }
    public static boolean VerificarMagico(int [][] mat){
        boolean estado = true;
        for (int i = 0; i < 3; i++) {
            if(mat[0][i]+mat[1][i]+mat[2][i] != 15){
                estado = false;
            }
            if(mat[i][0]+mat[i][1]+mat[i][2]!= 15){
                estado = false;
            }
        }
        if(mat[0][0]+mat[1][1]+mat[2][2]!= 15){
         estado = false;
        }
         if(mat[2][0]+mat[1][1]+mat[0][2]!= 15){
         estado = false;
        }
        return estado;
    } 
}
