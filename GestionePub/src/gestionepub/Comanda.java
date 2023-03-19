package gestionepub;
import java.util.ArrayList;

/**
 *
 * @author nicolabernardi
 */
public class Comanda {
    private ArrayList lista = new ArrayList<Ordinazione>();
    private int tavolo;

    public void setLista(Ordinazione ord) {
        this.lista.add(ord);
    }

    public Comanda(int tavolo, ArrayList lista) {
        this.tavolo = tavolo;
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Tavolo: \t\t" + tavolo + "\n" + lista;
    }

    public ArrayList getLista() {
        return lista;
    }

    public int getTavolo() {
        return tavolo;
    }
    
    
    
}
