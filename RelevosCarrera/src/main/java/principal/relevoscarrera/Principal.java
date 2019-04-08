package principal.relevoscarrera;
/**
 * @author NATHALY SALAZAR
 * @author Cristian Romero
 * @version 1.0
 * Esta clase contiene algunas operaciones de los diferentes hilos
 */
public class Principal{
    /**
     * Constructor
     */
    public Principal() {
    }
    /**
     * Inicia los hilos
     */
    public void Iniciador(){
        StringBuffer camino1 = new StringBuffer("****************************************************************************************************");
        StringBuffer camino2 = new StringBuffer("****************************************************************************************************");
        StringBuffer camino3 = new StringBuffer("****************************************************************************************************");
        
        CorredorUno c11= new CorredorUno(1,1,camino1);
        CorredorDos c12= new CorredorDos(2,1,camino1);
        CorredorTres c13= new CorredorTres(3,1,camino1);
        
        CorredorCuatro c21= new CorredorCuatro(4,2,camino2);
        CorredorCinco c22= new CorredorCinco(5,2,camino2);
        CorredorSeis c23= new CorredorSeis(6,2,camino2);
        
        CorredorSiete c31= new CorredorSiete(7,3,camino3);
        CorredorOcho c32= new CorredorOcho(8,3,camino3);
        CorredorNueve c33= new CorredorNueve(9,3,camino3);
        
        c11.start();
        c12.start();
        c13.start();
        
        c21.start();
        c22.start();
        c23.start();
        
        c31.start();
        c32.start();
        c33.start();
    }
    public void Pasos(){
        
    }
}
