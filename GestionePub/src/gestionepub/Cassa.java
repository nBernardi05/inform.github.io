package gestionepub;

import java.util.ArrayList;

/**
 *
 * @author nicolabernardi
 */
public class Cassa {
    private static ArrayList cassa = new ArrayList<Comanda>();
    
    public static void addInCassa(Comanda toAdd){
        cassa.add(toAdd);
    }
    
    public static Comanda cercaConto(int daCercare){
        for(Object c: cassa){
            if(((Comanda)c).getTavolo()==daCercare){
                return (Comanda)c;
            }
        }
        return null;
    }
    
    public static double totaleDaPagare(int tavolo){
        Comanda com = Cassa.cercaConto(tavolo);
        double totale = 0;
        for(Object a: ((Comanda)com).getLista()){
            totale += (((Menu)a).getPrezzo());
        }
        return totale;
    }
    
}
