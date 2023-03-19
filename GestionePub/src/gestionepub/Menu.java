package gestionepub;

/**
 *
 * @author nicolabernardi
 */

public enum Menu {
    /**
     * NON è CASE SENSITIVE perché ho usato il metodo .toUpperCase()
     */
    ACQUA_N(1.80),
    ACQUA_F(1.80),
    PATATINE(3.10),
    TOAST(5.10),
    BRANDY(4.0),
    GIN(4.0),
    APEROL(3.70),
    CAMPARI(3.70),
    PROSECCO(4.10), 
    ARANCIATA(2.20),
    COLA(2.20),
    CHINOTTO(2.20),
    VINO_ROSSO(3.80),
    VINO_BIANCO(3.80),
    BIRRA_BIONDA(4.30),
    BIRRA_ROSSA(4.30),
    TRAMMEZZINO(1.80),
    ANELLI_CIPOLLA(4.20),
    MOZZARELLINE(4.30),
    OLIVE_ASCOLANE(4.40),
    PEPITE_POLLO(4.0),
    ACQUA_MENTA(2.40),
    LEMONSODA(2.10),
    SAMBUCA(4.20),
    THE(2.20),
    CRODINO(3.80),
    PIADINA(4.40),
    PIZZETTA(4.40);
    private double prezzo;

    public double getPrezzo() {
        return prezzo;
    }


    private Menu(double prezzo) {
        this.prezzo = prezzo;
    }

    
    
    
}
