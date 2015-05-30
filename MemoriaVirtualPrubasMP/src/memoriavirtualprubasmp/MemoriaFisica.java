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
public class MemoriaFisica {
    
    public boolean esta_reservado;
    public String proceso_reserva;
    public Frame frame;
    
   
    public MemoriaFisica(boolean reservado, String proceso_reserva, Frame frame) {
        this.esta_reservado = reservado;
        this.proceso_reserva = proceso_reserva;
        this.frame = frame;
    }
}
