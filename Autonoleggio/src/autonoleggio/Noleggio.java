/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autonoleggio;

/**
 *
 * @author nicolabernardi
 */
public class Noleggio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Furgone f1 = new Furgone(12, "EL289CC", 536, "Fiat", "Duplo", 1200, 2015, 82);
        Furgone f2 = new Furgone(10, "FA222JK", 611, "Volkswagen", "Caddie", 161, 2018, 79);
        Vettura auto1 = new Vettura(4, "EX123PP", 467, "Fiat", "500", 720, 2013, 60);
        Vettura auto2 = new Vettura(4, "AB227CJ", 111, "Fiat", "Panda4x4", 320, 1983, 51);
        System.out.println("\t\tAutonoleggio da peppino:");
        System.out.println("Auto1 noleggio: Euro: " + noleggio(auto1, 120, 25, 12));
        System.out.println("Furgone 1 noleggio: Euro: " + noleggio(f1, 191, 61, 67));
        System.out.println("Auto2 noleggio: Euro: " + noleggio(auto2, 80, 60, 15));
        System.out.println("Furgone 2 noleggio: Euro: " + noleggio(f2, 100, 2, 88));
    }

    /**
     * 
     * @param noleggiato veicolo noleggiato
     * @param km km percorsi durante il noleggio
     * @param litri quanta benzina c'era nel serbatoio alla fine del noleggio
     * @param giorni i giorni del noleggio
     * @return 
     */
    public static double noleggio(Veicolo noleggiato, float km, int litri, int giorni){
        double prezzo = 0;
        if(noleggiato instanceof Vettura){
            prezzo = 50 * giorni;
            prezzo += km / 25;
            if(litri > noleggiato.getSerbatoio())
                litri = noleggiato.getSerbatoio();
            prezzo += (noleggiato.getSerbatoio() - litri) * 2;
        } else if(noleggiato instanceof Furgone) {
            prezzo = 70 * giorni;
            if(km >= 130){
                km -= 100;
                prezzo += km / 30;
            }
            if(litri > noleggiato.getSerbatoio())
                litri = noleggiato.getSerbatoio();
            prezzo += (noleggiato.getSerbatoio() - litri) * 2;
        }
        return prezzo;
    }

}
