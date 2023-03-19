package gestionepub;

/**
 *
 * @author nicolabernardi
 */
public class Ordinazione {
    private Menu articolo;

    public Ordinazione(Menu articolo) {
        this.articolo = articolo;
    }

    public Menu getArticolo() {
        return articolo;
    }

    @Override
    public String toString() {
        return articolo + " ";
    }
    
    
    
    
}
