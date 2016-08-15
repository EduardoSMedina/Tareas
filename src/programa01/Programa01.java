/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa01;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author edosi_000
 */
public class Programa01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 0;
        char respuestas[][] = new char [2][n];
        String r = "";
        do{
           r = IngresarPersona(r);
           if(r.charAt(0)!='n' && r.charAt(0)!='N'){
               n++;
               respuestas = NuevaMatriz(respuestas,n);
           }
        }while(r.charAt(0)!='n' && r.charAt(0)!='N');
        Respuestas(respuestas, n);
    }
    
    public static String EncuestaSexo(String resp){
        do{
            System.out.println("Ingrese sexo ");
            System.out.println("M = Másculino");
            System.out.println("F = Femenino");
            resp = Leer(resp);
            if(resp.charAt(0)!= 'M' && resp.charAt(0)!= 'F'&& resp.charAt(0)!= 'm' && resp.charAt(0)!= 'f'){
                System.out.println("Error! Ingrese sólo F ó M");
            }
        }while(resp.charAt(0)!= 'M' && resp.charAt(0)!= 'F'&& resp.charAt(0)!= 'm' && resp.charAt(0)!= 'f');  
        return resp;
    }
    public static String EncuestaAprobacion(String resp){
        do{
            System.out.println("Ingrese respuesta de aprobación a la gestión de gobierno");
            System.out.println(" s = aprueba");
            System.out.println(" n = no aprueba");
            System.out.println(" x = no sabe o no responde");
            resp = Leer (resp);
            if(resp.charAt(0)!='s' && resp.charAt(0)!='n' && resp.charAt(0)!='x'){
                System.out.println("Error, limítace a responder s, n ó x");
            }
        }while(resp.charAt(0)!='s' && resp.charAt(0)!='n' && resp.charAt(0)!='x');    
        return resp;
    }
    public static String IngresarPersona(String resp){
        do{
            System.out.println("Desea Ingresar un encuestado");
            System.out.println("S = si / N = no");
            resp = Leer(resp);
            if(resp.charAt(0)!='s' && resp.charAt(0)!='n' && resp.charAt(0)!='S'&& resp.charAt(0)!='N'){
                System.out.println("Error!! Limitace a las opciones");
            }
        }while(resp.charAt(0)!='s' && resp.charAt(0)!='n' && resp.charAt(0)!='S'&& resp.charAt(0)!='N');    
            return resp;
    }
    public static String Leer(String x){
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        boolean estado = true;
        do{
            try{
                x = leer.readLine();
                estado = true;
            }catch(Exception e){
                estado = false;
            }
        }while(estado == false);
        return x;
}
    public static char [][] NuevaMatriz(char [][] matriz, int n){
        String resp = "";
        char sexo ;
        char NuevaMatriz [][] = new char [2][n];
        sexo = EncuestaSexo(resp).charAt(0);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < (n-1); j++) {
                NuevaMatriz[i][j] = matriz[i][j];
            }
        }
        if(sexo== 'M' && sexo=='m'){
            NuevaMatriz[0][n-1]= EncuestaAprobacion(resp).charAt(0);
        } else{
            NuevaMatriz[1][n-1]= EncuestaAprobacion(resp).charAt(0);
        }
        return NuevaMatriz;
    }
    public static void Respuestas(char [][] matriz, int n){
        System.out.println("");
        System.out.println("Resultados");
        System.out.println("");
        System.out.println(EncontrarAprobHombres(matriz,n)+" hombres aprobaron la gestión del Gobierno");
        System.out.println(EncontrarDesapMujeres(matriz,n)+ " mujeres desaprobaron la gestión del Gobierno");
        System.out.println("Un "+PorcentajeAprobados(matriz,n)+"% de los encuestados aprueba la gestión ");
        System.out.println("En la encuesta participaron un total de "+n+" personas");
        
    }
    public static int EncontrarAprobHombres (char[][] matriz, int n){
        int canthombres = 0;
        for (int i = 0; i < n; i++) {
            if(matriz[1][i] == 's'){
                canthombres++;
            }
        }
        return canthombres;
    }
    public static int EncontrarDesapMujeres(char[][] matriz, int n){
        int cantmujeres = 0;
        for (int i = 0; i < n; i++) {
            if(matriz[1][i] == 'n'){
                cantmujeres++;
            }
        }
        return cantmujeres;
    }
    public static double PorcentajeAprobados(char[][] matriz, int n){
    double porcentaje = 0;
    double cantaprob = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                if(matriz[i][j] == 's'){
                    cantaprob++;
                }
            }
        }
        porcentaje = cantaprob*100/n;
        return porcentaje;
    }
}

