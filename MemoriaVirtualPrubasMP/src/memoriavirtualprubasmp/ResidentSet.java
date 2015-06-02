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
                Frame espacio_reservado = new Frame(true,nombre_proceso);
                Main.memoria_fisica.add(ubicacion_fisica,espacio_reservado); 
                ubicacion_fisica++; 
                contador++; 
            }
            else if ((contador < cantidad_maxima_frames) & (!(Main.memoria_virtual.get(i).contenido.nombre.equalsIgnoreCase(nombre_proceso)))){ 
                Frame espacio_reservado = new Frame(true,nombre_proceso);
                Main.memoria_fisica.add(ubicacion_fisica,espacio_reservado); 
                contador++; 
                ubicacion_fisica++; 
                //System.out.println("Segundo If, Nombre proceso espacio reservado: "+nombre_proceso+" - Contador: "+contador);   
            }
            else{
                if (!(Main.memoria_virtual.get(i).contenido.nombre.equalsIgnoreCase(nombre_proceso))){
                    nombre_proceso=Main.memoria_virtual.get(i).contenido.nombre; 
                    Frame espacio_reservado = new Frame(true,nombre_proceso);
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
    
    //Si hay espacio de sobra le doy, en primera instancia vacios totalmente
    //En segunda a los que estan reservados pero no ocupados ni bloqueados > LLamo a place(First y Next). 
    //Si no hay campo,sobre los no ocupados por el mismo si es local llamando a core
    //Sino lo hace reemplazo global llamando a global
    
    public void ResidentSetVariableIncrementar(String nombre_proceso){
        int cantidad_maxima =5; //Cambiarlo por la variable global
        int crecimiento=1; // crecimiento igualarlo a la variable global. 
        int contador=0;
        while (crecimiento!=0){
        if (Contar_Reservados(nombre_proceso)<cantidad_maxima){
            if (Main.placement_first_available){
                PrimeroDisponible(nombre_proceso); 
                crecimiento--; 
            }
            else{ //next available
                if (Main.memoria_fisica.size()< Main.tamaño_memoria_fisica){
                    while ((((Main.memoria_fisica.size())+crecimiento)<Main.tamaño_memoria_fisica)&(crecimiento!=0)){
                        Frame espacio_reservado = new Frame(true,nombre_proceso);
                        Main.memoria_fisica.add(espacio_reservado);
                        
                        crecimiento--; 
                    }
                }
                
            }
        }
        }
    }
    
    public void PrimeroDisponible(String nombre_proceso){
        for (int i = 0; i < Main.memoria_fisica.size(); i++ ) {
                    if ((Main.memoria_fisica.get(i).esta_ocupado)==false){ //Pinky al colocarlo poner el ocupado en verdadero
                        //&(!(Main.memoria_fisica.get(i).contenido.esta_bloqueado))
                        System.out.println("Yeahh");
                        System.out.println("Yeah "+Main.memoria_fisica.get(i));
                        Main.memoria_fisica.get(i).proceso_reserva= nombre_proceso;  
                        break; 
                    }
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
    
    public void imprimir_frames(){
        for (int i = 0; i < Main.memoria_fisica.size(); i++ ) {
            System.out.println(Main.memoria_fisica.get(i).proceso_reserva);
            
        }
    }
  
    
    
    
}
