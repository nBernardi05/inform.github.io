package officinameccanica;
import java.util.ArrayList;

/**
 *
 * @author nicolabernardi
 */
public class ParteComplessa extends ParteDiRicambio{
    private ArrayList composizione = new ArrayList<ParteDiRicambio>();

    public ParteComplessa(int quantita, int codice, String descrizione, ArrayList composizione) {
        super(codice, descrizione, quantita);
        this.composizione = composizione;
    }

    public ParteComplessa(int quantita, int codice, String descrizione) {
        super(codice, descrizione, quantita);
    }

    @Override
    public String toString() {
        return super.getDescrizione() + ", " + super.getCodice() + " rimanenti: " + super.getQuantita();
    }

    public ArrayList getComposizione() {
        return composizione;
    }
    
    
    
    
    
}
