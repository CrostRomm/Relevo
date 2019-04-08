package principal.relevoscarrera;
/**
 * @author NATHALY SALAZAR
 * @author Cristian Romero
 * @version 1.0
 */
public class Sincronizada {
    /**
     * Este metodo imprime el camino del equipo de corredores 1
     * @param camino sendero 1
     */
    public static synchronized void imprimirUno(StringBuffer camino){
        System.out.println("\033[31m"+camino);
    }
    public static synchronized void imprimirDos(StringBuffer camino){
        System.out.println("\033[37m"+camino);
    }
    public static synchronized void imprimirTres(StringBuffer camino){
        System.out.println("\033[33m"+camino);
    }
    public static synchronized void Espacio(){
        System.out.println();
    }
}
