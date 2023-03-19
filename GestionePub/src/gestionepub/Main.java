package gestionepub;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nicolabernardi
 */
public class Main {
    private static ArrayList comande = new ArrayList<Comanda>();
    
    public static void main(String[] args) {
        boolean continua = true;
        String opzione = "";    // Uso una stringa perché così non serve fare il try catch se qualcuno inserisce una lettera
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t Benvenuto in PubOS 1.0.1\n\n");
        while(continua){
            System.out.println("1 - Prendere un ordinazione");
            System.out.println("2 - Lista ordinazioni bar");
            System.out.println("3 - Pagare il conto");
            System.out.println("0 - Esci\n");
            System.out.print("\t--> ");
            opzione = sc.next();
            switch (opzione) {
                case "0":
                    continua = false;
                    break;
                case "1":
                    prendiOrdinazione();
                    break;
                case "2":
                    stampaOrdinazioni();
                    break;
                case "3":
                    conto();
                    break;
                default:
                    break;
            }
            
        }
    }
    
    public static void prendiOrdinazione(){
        boolean cont = true;
        String inp = "";
        int tavolo = 0;
        ArrayList lista = new ArrayList<Ordinazione>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Inanzitutto, inserire il numero del tavolo");
        try{
            while(!(tavolo > 0 && tavolo <= 40)){
                System.out.println("I tavoli vanno da 1 a 40");
                System.out.print("--> ");
                tavolo = sc.nextInt();
            }
        }catch(RuntimeException en){
            System.out.println("Non è stato inserito un numero valido");
            return;
        }
        System.out.println("Prendere ordinazioni. Digita un asterisco per terminare (*)");
        while (cont) {
            System.out.print("--> ");
            inp = sc.next();
            if(inp.equals("*"))
                break;
            if(aggiungiAllaComanda(inp)!=null)
                lista.add(aggiungiAllaComanda(inp));
            else
                System.out.println("Hai digitato una cosa fuori menu. Riprova");
        }
        comande.add(new Comanda(tavolo, lista));
        System.out.println("Successo.");
    }
    /**
     * Stampa le ordinazioni al banco bar
     */
    public static void stampaOrdinazioni(){     // al banco bar
        Scanner sc = new Scanner(System.in);
        for(Object c: comande){
            System.out.println(c);
            System.out.println("Premi qualsiasi tasto e dai invio per inviare in cassa la comanda, cancellarla dalla tua lista e visualizzarne un'altra");
            try{
                String s = sc.next();   // Serve a dare il tempo di leggere la comanda e farla una per una
            }catch(RuntimeException e){
                
            }
            Cassa.addInCassa((Comanda)c);
        }
        comande = null; // Ho fatto null e non ho fatto .clear perché mi sono accorto che copiava l'indirizzo del puntatore 
        comande = new ArrayList<Comanda>();
        System.out.println("Non hai altre ordinazioni");
        
    }
    
    public static void conto(){
        Scanner sc = new Scanner(System.in);
        int cont = 0;
        try{
            System.out.println("Inserisci il tavolo per trovare il suo conto:");
            System.out.print("--> ");
            cont = sc.nextInt();
        }catch(RuntimeException e){
            System.out.println("Inserisci un numero di tavolo valido");
            return;
        }
        if(Cassa.cercaConto(cont)!=null){
            System.out.println(Cassa.cercaConto(cont) + "\n Totale da pagare: " + Cassa.totaleDaPagare(cont));
        }else{
            System.out.println("Nessun conto associato al numero di tavolo indicato");
        }
    }
    /**
     * L'input viene convertito in maiuscolo e confrontato per l'enum
     * @param input input
     * @return l'oggetto enum da aggiungere
     */
    public static Menu aggiungiAllaComanda(String input){
        switch (input.toUpperCase()) {
            case "ACQUA_N":
                return Menu.ACQUA_N;
            case "ACQUA_F":
                return Menu.ACQUA_F;
            case "PATATINE":
                return Menu.PATATINE;
            case "TOAST":
                return Menu.TOAST;
            case "BRANDY":
                return Menu.BRANDY;
            case "GIN":
                return Menu.GIN;
            case "APEROL":
                return Menu.APEROL;
            case "CAMPARI":
                return Menu.CAMPARI;
            case "PROSECCO":
                return Menu.PROSECCO;
            case "ARANCIATA":
                return Menu.ARANCIATA;
            case "COLA":
                return Menu.COLA;
            case "CHINOTTO":
                return Menu.CHINOTTO;
            case "VINO_ROSSO":
                return Menu.VINO_ROSSO;
            case "VINO_BIANCO":
                return Menu.VINO_BIANCO;
            case "BIRRA_BIONDA":
                return Menu.BIRRA_BIONDA;
            case "BIRRA_ROSSA":
                return Menu.BIRRA_ROSSA;
            case "TRAMMEZZINO":
                return Menu.TRAMMEZZINO;
            case "ANELLI_CIPOLLA":
                return Menu.ANELLI_CIPOLLA;
            case "MOZZARELLINE":
                return Menu.MOZZARELLINE;
            case "ACQUA_MENTA":
                return Menu.ACQUA_MENTA;
            case "OLIVE_ASCOLANE":
                return Menu.OLIVE_ASCOLANE;
            case "CRODINO":
                return Menu.CRODINO;
            case "THE":
                return Menu.THE;
            case "SAMBUCA":
                return Menu.SAMBUCA;
            case "LEMONSODA":
                return Menu.LEMONSODA;
            case "PEPITE_POLLO":
                return Menu.PEPITE_POLLO;
            case "PIADINA":
                return Menu.PIADINA;
            case "PIZZETTA":
                return Menu.PIZZETTA;
            default:
                return null;
            
        }
    }
}
