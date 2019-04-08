package principal.relevoscarrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author NATHALY SALAZAR
 * @author Cristian Romero
 * @version 1.0
 */
public class CorredorDos extends Thread{
    /**
     * Sobreescritura del metodo RUN
     */
    @Override
    public void run(){
        int paso=34;
        int numAleatorio;
        int aux;
        synchronized(camino){
            if(camino.charAt(33)!='█'){
                try{
                    camino.wait();
                }catch(InterruptedException e){}
            }
            camino.setCharAt(paso-1,'*'); // AQUI PUEDE SER DONDE SE ELIMINE QUIEN YA COMPLETO SU RUTA
            while(paso<=65){
                numAleatorio = (int)(Math.random()*3);
                paso+= numAleatorio;
                if(paso>66){
                    aux=paso-66;
                    paso=paso-aux;
                    camino.setCharAt((paso-numAleatorio+aux),'*');
                }   switch (numAleatorio) {
                    case 1:
                        camino.setCharAt((paso-1),'*');
                        break;
                    case 2:
                        camino.setCharAt((paso-2),'*');
                        break;
                    case 3:
                        camino.setCharAt((paso-3),'*');
                        break;
                    default:
                        break;
                }
                camino.setCharAt(paso,'█');
                try {
                    Thread.sleep(600);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CorredorUno.class.getName()).log(Level.SEVERE, null, ex);
                }
                Sincronizada.imprimirUno(camino);
            }
            camino.notify();
        }
    }
    /*
    Variable que se usa para asignar el codigo de un corredor
    */
    private int codigo;
    /*
    Variable que se usa para saber a que equipo pertenece el corredor
    */
    private int equipo;
    /*
    Se usa para saber el camino que tiene que reccorrer el corredor
    */
    private StringBuffer camino;
    /**
     * Constructor de la clase corredor uno
     * @param codigo
     * @param equipo
     * @param camino 
     */
    public CorredorDos(int codigo, int equipo, StringBuffer camino) {
        this.codigo = codigo;
        this.equipo = equipo;
        this.camino = camino;
    }
    /**
     * Get codigo del corredor 
     * @return  int
     */
    public int getCodigo() {
        return codigo;
    }
    /**
     * Set codigo del corredor
     * @param codigo 
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    /**
     * Get equipo del corredor
     * @return int
     */
    public int getEquipo() {
        return equipo;
    }
    /**
     * Set equipo del corredor
     * @param equipo 
     */
    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }
    /**
     * Get Camino a recorrer
     * @return StringBuffer
     */
    public StringBuffer getCamino() {
        return camino;
    }
    /**
     * Set camino a recorrer
     * @param camino 
     */
    public void setCamino(StringBuffer camino) {
        this.camino = camino;
    }
}
