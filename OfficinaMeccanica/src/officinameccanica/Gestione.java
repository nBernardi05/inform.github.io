package officinameccanica;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author nicolabernardi
 */
public class Gestione {
    private static ArrayList auto = new ArrayList<Auto>();
    
    public static void main(String[] args) {
        aggiuntaAuto();
        boolean continua = true;
        String opzione;
        Scanner sc = new Scanner(System.in);
        
        while (continua) {
            System.out.println("\n\n1 - Parti di ricambio da acquistare");
            System.out.println("2 - Ricerca globale di un componente tramite codice");
            System.out.println("3 - Ricerca della descrizione");
            System.out.println("4 - Prelievo di una parte dal codice");
            System.out.println("5 - Aggiunta al magazzino di parti dal codice");
            System.out.println("0 - Esci\n");
            System.out.print("--> ");
            opzione = sc.next();
            switch (opzione) {
                case "0":
                    continua = false;
                    break;
                case "1":
                    cercaPartiDaAcquistare();
                    break;
                case "2":
                    System.out.println("Inserisci il codice: ");
                    int inpu = sc.nextInt();
                    if(cercaCodice(inpu)==null){
                        System.out.println("Nessun oggetto trovato");
                    }
                    break;
                case "3":
                    System.out.println("Inserisci la descrizione: ");
                    String inp = sc.next();
                    if(cercaDescrizione(inp)==null){
                        System.out.println("Nessun oggetto trovato");
                    }
                    break;
                case "4":
                    System.out.println("Inserisci il codice dell'oggetto da prelevare: ");
                    int in = sc.nextInt();
                    if(modCodice(in, 1)==null){
                        System.out.println("Nessun oggetto trovato");
                    }else{
                        System.out.println("Successo");
                    }
                    break;
                case "5":
                    System.out.println("Inserisci il codice dell'oggetto da aggiungere: ");
                    int i = sc.nextInt();
                    System.out.println("Inserisci la quantita da aggiungere: ");
                    int quant = sc.nextInt();
                    quant *= -1;
                    if(modCodice(i, quant)==null){
                        System.out.println("Nessun oggetto trovato");
                    }else{
                        System.out.println("Successo");
                    }
                    break;
            }
        }
    }
    
    public static void aggiuntaAuto(){
        ArrayList parti = new ArrayList<ParteDiRicambio>();
        ArrayList sottoparti = new ArrayList<ParteDiRicambio>();
        sottoparti.add(new ParteComplessa(26, 161500, "candela"));
        sottoparti.add(new ParteElementare(123311, "cilindri", 27));
        parti.add(new ParteComplessa(15, 121211, "motore", sottoparti));
        auto.add(new Auto("fiat", "500", 2013, parti));
        
        parti = null;
        parti = new ArrayList<ParteDiRicambio>();
        sottoparti = null;
        sottoparti = new ArrayList<ParteDiRicambio>();
        sottoparti.add(new ParteComplessa(28, 991299, "candela"));
        sottoparti.add(new ParteElementare(164040, "cilindri", 14));
        parti.add(new ParteComplessa(15, 110809, "motore", sottoparti));
        parti.add(new ParteElementare(277781, "radio", 8)); // Non ha senso metterla come parte complessa in quanto non ha senso dire che la radio è composta da un display
        parti.add(new ParteElementare(910012, "cerchi", 24));
        auto.add(new Auto("volkswagen", "golf", 2012, parti));
    }
    
    public static void cercaPartiDaAcquistare(){
        for(Object a: auto){
            for(Object p: ((Auto)a).getParti()){
                if(((ParteDiRicambio)p).getQuantita()<15){
                    System.out.println("!! Da Acquistare: " + p + " (auto):" + a);
                }
                if(p instanceof ParteComplessa){
                   for(Object s: ((ParteComplessa)p).getComposizione()){
                       if(((ParteDiRicambio)s).getQuantita()<15)
                        System.out.println("!! Da Acquistare: " + s + " (sottoparte di): " + p + " (auto): " + a);
                    } 
                }
            }
        }
    }
    
    /**
     * Ricerca globale per descrizione
     * @param daCercare
     * @return quello che trova
     */
    public static ParteDiRicambio cercaDescrizione(String daCercare){
        daCercare = daCercare.toLowerCase();
        for(Object a: auto){
            for(Object p: ((Auto)a).getParti()){
                if((((ParteDiRicambio)p).getDescrizione()).equals(daCercare)){
                    stampa((ParteDiRicambio)p, null, (Auto)a);
                    return (ParteDiRicambio)p;
                }
                if(p instanceof ParteComplessa){
                   for(Object s: ((ParteComplessa)p).getComposizione()){
                       if(((ParteDiRicambio)s).getDescrizione().equals(daCercare)){
                           stampa((ParteDiRicambio)s, (ParteDiRicambio)p, (Auto)a);
                           return (ParteDiRicambio)s;
                       }
                           
                    } 
                }
            }
        }
        return null;
    }
    
    public static void stampa(ParteDiRicambio a, ParteDiRicambio b, Auto c){
        System.out.println("Trovato!!");
        String st = a.getDescrizione() + " " + a.getCodice() + " (" + a.getQuantita() + ")";
        if(b!=null){
            st += " -> " + b.getDescrizione() + " " + b.getCodice() + " (" + b.getQuantita() + ")"; 
        }
        if(c!=null){
                st += " -> " + c.getMarca() + " " + c.getModello() + " (" + c.getAnno() + ")";
            }
        System.out.println(st);
    }
    
    public static ParteDiRicambio cercaCodice(int daCercare){
        for(Object a: auto){
            for(Object p: ((Auto)a).getParti()){
                if((((ParteDiRicambio)p).getCodice())==daCercare){
                    stampa((ParteDiRicambio)p, null, (Auto)a);
                    return (ParteDiRicambio)p;
                }
                if(p instanceof ParteComplessa){
                   for(Object s: ((ParteComplessa)p).getComposizione()){
                       if(((ParteDiRicambio)s).getCodice()==(daCercare)){
                           stampa((ParteDiRicambio)s, (ParteDiRicambio)p, (Auto)a);
                           return (ParteDiRicambio)s;
                       }
                           
                    } 
                }
            }
        }
        return null;
    }
    
    public static ParteDiRicambio modCodice(int daCercare, int quanto){
        for(Object a: auto){
            for(Object p: ((Auto)a).getParti()){
                if((((ParteDiRicambio)p).getCodice())==daCercare){
                    ((ParteDiRicambio)p).subQuantita(quanto);
                    return (ParteDiRicambio)p;
                }
                if(p instanceof ParteComplessa){
                   for(Object s: ((ParteComplessa)p).getComposizione()){
                       if(((ParteDiRicambio)s).getCodice()==(daCercare)){
                           ((ParteDiRicambio)s).subQuantita(quanto);
                           return (ParteDiRicambio)s;
                       }
                           
                    } 
                }
            }
        }
        return null;
    }
}
