/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcurso;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Curso {
    ArrayList<Alumno> curso;
    public Curso(){
        this.curso = new ArrayList <Alumno>();
    }
    public void Menu(){
        System.out.println("Menu:");
        System.out.println("1 = Ingresar Alumno");
        System.out.println("2 = Eliminar Alumno");
        System.out.println("3 = Ver si existe Alumno");
        System.out.println("4 = Mostar Curso");
        System.out.println("5 = Salir");
    }
    public boolean Opcion(){
        String op = "";
        do{
            op = Leer(op);
        }while(ValidarNumero(op)==false);
        switch(op){
            case "1" :IngresarAlumno() ;break;
            case "2" :EliminarAlumno();break;
            case "3" :VerSiExisteAlumno() ;break;
            case "4" :ToString(); break;
            case "5" : return false;   
        }
        return true;
    }
    public String Leer(String str){
        Scanner leer = new Scanner(System.in);
        str = leer.nextLine();
        return str;
    }
    public boolean ValidarNumero(String str){
     Pattern pattern = Pattern
                .compile("[1-5]$");
        Matcher mather = pattern.matcher(str);
        if(mather.find() == true) {
            return true;
        } else {
            System.out.println("Error!!");
            return false;
        }
    }
    public void IngresarAlumno(){
        String nombre = "";
        String apellido = "";
        String rut ="";
        String Mat = "";
        System.out.println("Ingrese los datos del Alumno");
        System.out.println("");
        System.out.println("Nombre:");
        nombre = Leer(nombre);
        System.out.println("Apellido");
        apellido = Leer(apellido);
        do{
        System.out.println("Rut:");
        System.out.println("(Ejemplo: 12345678-9)");
        rut = Leer(rut);
        }while(ValidarRut(rut)==false);
        System.out.println("Número de Matrícula");
        Mat= Leer(Mat);
        Alumno al = new Alumno(nombre,apellido,rut,Mat);
        curso.add(al);
        
    }
     public boolean ValidarRut(String str){
        Pattern pattern = Pattern
                .compile("[0-9]+[-]{1}+[[0-9,k]{1}]$");
        Matcher mather = pattern.matcher(str);
        if(mather.find() == true) {
            return true;
        } else {
            System.out.println("Error!!");
            return false;
        }
     }
     public void VerSiExisteAlumno(){
        String rut = "";
         do{
         System.out.println("Ingrese rut del Alumno a buscar");
         System.out.println("(Ejemplo: 12345678-9)");
         rut = Leer(rut);
         }while(ValidarRut(rut)==false);
         if(ExisteAlumno(rut)== true){
             System.out.println("Este Alumno existe dentro del curso");
         }else { System.out.println("Este Alumno no existe dentro del curso");   }
     }
     public boolean ExisteAlumno(String str){
         for (int i = 0; i < this.curso.size(); i++) {
             if(this.curso.get(i).getRut().indexOf(str) != -1){
                 return true;
             }
         }
         return false;
     }
     public void EliminarAlumno(){
         String rut = "";
         do{
         System.out.println("Ingrese rut del Alumno que desea eliminar");
         System.out.println("(Ejemplo: 12345678-9)");
         rut = Leer(rut);
         }while(ValidarRut(rut)==false);
         if(ExisteAlumno(rut)==true){
             Eliminar(rut);
         }else{ System.out.println("Este Alumno no existe dentro del curso");}
     }
     public void Eliminar(String str){
         for (int i = 0; i < this.curso.size(); i++) {
             if(this.curso.get(i).getRut().indexOf(str) != -1){
                 this.curso.remove(i);
                 System.out.println("Alumno "+str+" Eliminado");
             }
         }
     }
     public void ToString(){
         if(this.curso.size()>0){
            System.out.println("Lista del Curso");
            System.out.println("");
            for (int i = 0; i < this.curso.size(); i++) {
                System.out.println((i+1)+" "+this.curso.get(i).getNombre()+" "+this.curso.get(i).getApellido());
                System.out.println("Rut: "+this.curso.get(i).getRut()+"  Número de matrícula: "+this.curso.get(i).getNumMatri() );          
            }
        }else{
             System.out.println("En este Curso, no hay Alumnos");
         }
     } 
     
}
