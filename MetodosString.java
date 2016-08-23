/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosstring;

import java.util.Scanner;

/**
 *
 * @author edosi_000
 */
public class MetodosString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     String palabra;
        System.out.println("Ingrese una palabra");
        palabra = leerString();
        ImprimirResultados(palabra);
    }
    
    public static String leerString(){
        String c;
        Scanner leer = new Scanner(System.in);
        c = leer.nextLine();
        return c;
    }
    
    public static int largoCadena(String str){
    int larg;
    larg = str.length();
    return larg;
    }
    
    public static int contarVocales(String str){
        int cont = 0;
        char palabra[] = new char[str.length()];
            
        for (int i = 0; i < str.length(); i++) {
           char ch = str.charAt(i);
           if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
           cont++;
           }
            }
        
        return cont;
        }
        
    public static int contarConsonantes(String str){
    int cont = 0;
        char palabra[] = new char[str.length()];
            
        for (int i = 0; i < str.length(); i++) {
           char ch = str.charAt(i);
           if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u'){
               cont++;
            }
        }
        return cont;
    }
    
    public static String invertirString(String str){
        String newpalabra = "";
        char ch;
        for (int i = (str.length()-1) ; i > -1; i--) {
            ch = str.charAt(i);
            
            newpalabra = newpalabra + ch ;     
        }
           
       return newpalabra;
    }
    public static boolean existeChar(String str, char ch){
        boolean estado = false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)== ch){
                estado = true;
            } 
        }
        
        return estado;
        }
    public static boolean existeSubString(String str, String substr){
    int resultado; 
    boolean estado = true;
    resultado = str.indexOf(substr);
    
    if(resultado == -1){
    estado = false;}
    return estado;
    }
    
    public static char[] crearArrayChar(String Str){
        char[] letra = new char [Str.length()];
        for (int i = 0; i < Str.length(); i++) {
          letra[i] =  Str.charAt(i);
        }
        return letra;
            
        }
    
    public static void ImprimirResultados(String str){
        Scanner leer = new Scanner (System.in);
        String c = "";
        char letra;
        char letras[] =  crearArrayChar(str);
        String subpalabra;
        
        System.out.println("El largo de la cadena es:  "+ largoCadena(str));
        System.out.println("Cantidad de vocales es: "+ contarVocales(str));
        System.out.println("Cantidad de consonantes es: "+contarConsonantes(str));
        System.out.println("La palabra invertida es: "+invertirString(str));
        System.out.println("Ingrese una letra");
        c = leerString();
        letra = c.charAt(0);
        if (existeChar(str,letra) == true ) {
            System.out.println("La letra "+letra+ ", existe dentro de la palabra "+str);
        } else {
            System.out.println("La letra "+letra+ ", No existe dentro de la palabra "+str);}
        System.out.println("Ingrese una subpalabra");
        subpalabra = leer.nextLine();
        if(existeSubString(str, subpalabra )== true){
            System.out.println("La palabra "+subpalabra +", se encuentra dentro de "+str);
        }else{ 
            System.out.println("La palabra "+subpalabra +",  No se encuentra dentro de "+str); }
        
        System.out.println("Las letras de la palabra son: ");
        for (int i = 0; i < str.length(); i++) {
            System.out.println(" "+letras[i]+" ");
        }
        }
       
        
    }
    
   
            
            


