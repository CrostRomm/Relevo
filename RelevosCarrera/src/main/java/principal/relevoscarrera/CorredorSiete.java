package principal.relevoscarrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author NATHALY SALAZAR
 * @author Cristian Romero
 * @version 1.0
 */
public class CorredorSiete extends Thread{
    /**
     * Sobreescritura del metodo RUN
     */
    @Override
    public void run(){
int paso=0;
        int numAleatorio;
        int aux;
        camino.setCharAt(paso,'&');
        Sincronizada.imprimirTres(camino);
        Sincronizada.Espacio();
        synchronized(camino){
            while (paso<=32) {
                numAleatorio = (int)(Math.random()*3);
                paso+= numAleatorio;
                if(paso>33){
                    aux=paso-33;
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
                camino.setCharAt(paso,'&');
                try {
                    Thread.sleep(600);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CorredorUno.class.getName()).log(Level.SEVERE, null, ex);
                }
                Sincronizada.imprimirTres(camino);
                Sincronizada.Espacio();
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
    public CorredorSiete(int codigo, int equipo, StringBuffer camino) {
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
