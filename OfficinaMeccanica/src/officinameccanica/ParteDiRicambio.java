package officinameccanica;

/**
 *
 * @author nicolabernardi
 */
public abstract class ParteDiRicambio {
    private int codice;
    private String descrizione;
    private int quantita;

    public ParteDiRicambio(int codice, String descrizione, int quantita) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.quantita = quantita;
    }

    @Override
    public String toString() {
        return descrizione + ", " + codice + ", rimanenti: " + quantita;
    }

    public int getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getQuantita() {
        return quantita;
    }


    public void subQuantita(int mod) {
        this.quantita -= mod;
    }
    
    
}
