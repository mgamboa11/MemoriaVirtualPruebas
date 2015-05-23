/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoriavirtualprubasmp;

/**
 *
 * @author Adrian
 */
public class Proceso {
    
    public int identificador;
    public String nombre;
    public int prioridad;
    public int tamano;
    public int cantPartes;
    public int[][] UMF = new int[cantPartes][3]; //ubicacion_memoriaF
    public int[][] UMV = new int[cantPartes][3]; //ubicacion_memoriaV

    public Proceso(String nombre, int prioridad, int tamano) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.tamano = tamano;
        //this.identificador = lista_Procesos.length();
    }
    
}
