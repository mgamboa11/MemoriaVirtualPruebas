/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoriavirtualprubasmp;

/**
 *
 * @author Mauricio Gamboa C
 */
public class ResidentSet {
    
    
    public void ResidentSetFijo(int tamano_fijo) {  
        //Validar que no se sobrepase la cantidad de frames en memoria física
        int contador=0; 
        int cantidad_maxima_frames = tamano_fijo;
        String nombre_proceso = Main.memoria_virtual.get(0).contenido.nombre; 
        //System.out.println("Nombre Primer Proceso: "+nombre_proceso);
        int ubicacion_fisica=0; 
        for (int i = 0; i < Main.memoria_virtual.size(); i++ ) {
            // Initialize each object
            if ((contador < cantidad_maxima_frames) && (Main.memoria_virtual.get(i).contenido.nombre.equalsIgnoreCase(nombre_proceso))){
                //System.out.println("Primer If, Nombre proceso: "+nombre_proceso+" - Contador: "+contador);
                Main.memoria_fisica.add(ubicacion_fisica,Main.memoria_virtual.get(i)); 
                //System.out.println("Primer If, Cambio Memoria Fisica, Proceso Actual: "+nombre_proceso+" - Nombre Cambiado: "+Main.memoria_fisica.get(ubicacion_fisica).contenido.nombre);
                ubicacion_fisica++; 
                contador++; 
            }
            else if ((contador < cantidad_maxima_frames) & (!(Main.memoria_virtual.get(i).contenido.nombre.equalsIgnoreCase(nombre_proceso)))){ 
                Main.memoria_fisica.add(ubicacion_fisica,null); 
                contador++; 
                ubicacion_fisica++; 
                //System.out.println("Segundo If, Nombre proceso espacio reservado: "+nombre_proceso+" - Contador: "+contador);   
            }
            else{
                if (!(Main.memoria_virtual.get(i).contenido.nombre.equalsIgnoreCase(nombre_proceso))){
                    nombre_proceso=Main.memoria_virtual.get(i).contenido.nombre; 
                    Main.memoria_fisica.add(ubicacion_fisica,Main.memoria_virtual.get(i));
                    contador=1; 
                    ubicacion_fisica++; 
                }
            }              
        }
    }
    
    
    
    public void ResidentSetVariable (String nombre_proceso){
        int tamano_inicial=2; 
        int tamano_maximo=5; 
        int tamano_crecimiento=2; 
        //Se ocupa el next o el first ??
        
        for (int i = 0; i < Main.memoria_virtual.size(); i++ ) {
            
        }
        
    }
    
  
    
    
    
}
