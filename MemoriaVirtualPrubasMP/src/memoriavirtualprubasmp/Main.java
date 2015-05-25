/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoriavirtualprubasmp;

import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Jespi_000
 */
public class Main {

    public static List<String> lineas_archivos_procesos;
    public static List<String> lineas_archivos_referencias;
    public static List<Proceso> lista_Procesos;
    
    public static List<Frame> memoria_fisica = new LinkedList<Frame>();
    public static List<Frame>memoria_virtual = new LinkedList<Frame>();; 
    
    public static int tamaño_fijo; 
    
    public static void main(String[] args) {
        Proceso p1 = new Proceso("P1",2,50);
        Proceso p2 = new Proceso("P2",2,50);
        Proceso p3 = new Proceso("P3",2,70);
        
        Frame f1 = new Frame (1,p1,10); 
        Frame f2 = new Frame (2,p1,10); 
        Frame f3 = new Frame (3,p1,10); 
        Frame f4 = new Frame (4,p1,10); 
        Frame f5 = new Frame (1,p2,10); 
        Frame f6 = new Frame (1,p3,10); 
        Frame f7 = new Frame (2,p3,10); 
        Frame f8 = new Frame (3,p3,10); 
        Frame f9 = new Frame (4,p3,10); 
        Frame f10 = new Frame (5,p3,10); 
        Frame f11 = new Frame (6,p3,10); 
     
        memoria_virtual.add(f1); 
        memoria_virtual.add(f2);
        memoria_virtual.add(f3);
        memoria_virtual.add(f4);
        memoria_virtual.add(f5);
        
        memoria_virtual.add(f6); 
        memoria_virtual.add(f7);
        memoria_virtual.add(f8);
        memoria_virtual.add(f9);
        memoria_virtual.add(f10);
        
        memoria_virtual.add(f11); 
        
        ResidentSet res = new ResidentSet(); 
        res.ResidentSetFijo(2);
        
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(memoria_fisica.get(0).contenido.nombre); 
        System.out.println(memoria_fisica.get(1).contenido.nombre); 
        
        System.out.println(memoria_fisica.get(2).contenido.nombre); 
        System.out.println("Reservado"); 
        
        //System.out.println(memoria_fisica.get(3).contenido.nombre); 
        System.out.println(memoria_fisica.get(4).contenido.nombre); 
        System.out.println(memoria_fisica.get(5).contenido.nombre); 
        
        //System.out.println(memoria_fisica.get(6).contenido.nombre); 
        //System.out.println(memoria_fisica.get(7).contenido.nombre); 
    }
    
}
