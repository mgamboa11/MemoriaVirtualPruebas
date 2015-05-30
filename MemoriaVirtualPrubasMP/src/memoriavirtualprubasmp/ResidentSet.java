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
                MemoriaFisica espacio_reservado = new MemoriaFisica(true,nombre_proceso,null);
                Main.memoria_fisica.add(ubicacion_fisica,espacio_reservado); 
                ubicacion_fisica++; 
                contador++; 
            }
            else if ((contador < cantidad_maxima_frames) & (!(Main.memoria_virtual.get(i).contenido.nombre.equalsIgnoreCase(nombre_proceso)))){ 
                MemoriaFisica espacio_reservado = new MemoriaFisica(true,nombre_proceso,null);
                Main.memoria_fisica.add(ubicacion_fisica,espacio_reservado); 
                contador++; 
                ubicacion_fisica++; 
                //System.out.println("Segundo If, Nombre proceso espacio reservado: "+nombre_proceso+" - Contador: "+contador);   
            }
            else{
                if (!(Main.memoria_virtual.get(i).contenido.nombre.equalsIgnoreCase(nombre_proceso))){
                    nombre_proceso=Main.memoria_virtual.get(i).contenido.nombre; 
                    MemoriaFisica espacio_reservado = new MemoriaFisica(true,nombre_proceso,null);
                    Main.memoria_fisica.add(ubicacion_fisica,espacio_reservado);
                    contador=1; 
                    ubicacion_fisica++; 
                }
            }              
        }
    }
    
    
    
    
    public void ResidentSetVariableInicial(){
        int tamano_inicial= 3; 
        
        ResidentSetFijo(tamano_inicial);
        
    }
    
    public void ResidentSetVariableIncrementar(String nombre_proceso){
        int cantidad_maxima =5; //Cambiarlo por la variable global
        if (Contar_Reservados(nombre_proceso)>=cantidad_maxima){
            
        }
    }
    
    public int Contar_Reservados (String nombre_proceso){
        int contador = 0;
        for (int i = 0; i < Main.memoria_fisica.size(); i++ ) {
            if (Main.memoria_fisica.get(i).proceso_reserva.equalsIgnoreCase(nombre_proceso)){
                contador++;
            }
        }
        return contador;
    }
  
    
    
    
}
