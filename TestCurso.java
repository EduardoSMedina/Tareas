/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcurso;

/**
 *
 * @author edosi_000
 */
public class TestCurso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Curso cur = new Curso();
        do{
            cur.Menu();
        }while(cur.Opcion()==true);
    }
    
}
