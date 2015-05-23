/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoriavirtualprubasmp;

import java.util.List;


/**
 *
 * @author Jespi_000
 */
public class Main {

    public static List<String> lineas_archivos_procesos;
    public static List<String> lineas_archivos_referencias;
    public static List<Proceso> lista_Procesos;
    public static Frame[][] memoria_fisica = new Frame[5][5];
    public static Frame[][] memoria_virtual = new Frame[6][5];
    public static int tamaño_fijo; 
    
    public static void main(String[] args) {
        Proceso p1 = new Proceso("P1",2,50);
        Proceso p2 = new Proceso("P2",2,50);
        Proceso p3 = new Proceso("P3",2,70);
        Frame f1 = new Frame (1,p1,10); 
        Frame f2 = new Frame (2,p1,10); 
        Frame f3 = new Frame (3,p1,10); 
        Frame f4 = new Frame (3,p1,10); 
        Frame f5 = new Frame (1,p2,10); 
        Frame f6 = new Frame (1,p3,10); 
        Frame f7 = new Frame (2,p3,10); 
        Frame f8 = new Frame (3,p3,10); 
        Frame f9 = new Frame (4,p3,10); 
        Frame f10 = new Frame (5,p3,10); 
        Frame f11 = new Frame (6,p3,10); 
     
        memoria_virtual[0][0]=f1; 
        memoria_virtual[0][1]=f2;
        memoria_virtual[0][2]=f3;
        memoria_virtual[0][3]=f4;
        memoria_virtual[0][4]=f5;
        
        memoria_virtual[1][0]=f6; 
        memoria_virtual[1][1]=f7;
        memoria_virtual[1][2]=f8;
        memoria_virtual[1][3]=f9;
        memoria_virtual[1][4]=f10;
        
        memoria_virtual[2][0]=f11; 
        
        ResidentSet res = new ResidentSet(); 
        res.ResidentSetFijo();
        System.out.println(memoria_fisica[0][0]); 
        System.out.println(memoria_fisica[0][1]); 
        System.out.println(memoria_fisica[0][2]); 
        System.out.println(memoria_fisica[0][3]); 
        System.out.println(memoria_fisica[0][4]); 
        System.out.println(memoria_fisica[1][0]); 
        System.out.println(memoria_fisica[1][1]); 
        System.out.println(memoria_fisica[1][2]); 
    }
    
}
