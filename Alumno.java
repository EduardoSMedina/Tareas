package testcurso;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Alumno {
    private String nombre;
    private String apellido;
    private String rut;
    private String numMatri;
    public Alumno(){
        this.nombre = "";
        this.apellido = "";
        this.rut = "";
        this.numMatri = "";
    }
    public Alumno(String nom, String ap, String rt, String num){
        this.nombre = nom;
        this.apellido = ap;
        this.rut = rt;
        this.numMatri = num;
    }
    public String getNombre (){
        return this.nombre;
    }
    public void setNombre(String nom){
        this.nombre = nom;
    }
    public String getApellido (){
        return this.apellido;
    }
    public void setApellido(String ap){
        this.apellido = ap;
    }
    public String getRut (){
        return this.rut;
    }
    public void setRut(String rt){
        this.rut = rt;
    }
    public String getNumMatri (){
        return this.numMatri;
    }
    public void setNumMatri(String num){
        this.numMatri = num;
    }
    public void ToString(){
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Apellido: "+this.apellido);
        System.out.println("Rut: "+this.rut);
        System.out.println("Número de matrícula: "+this.numMatri);
    }
}
