package officinameccanica;
import java.util.ArrayList;

/**
 *
 * @author nicolabernardi
 */
public class Auto {
    private String marca;
    private String modello;
    private int anno;
    private ArrayList parti = new ArrayList<ParteDiRicambio>();

    public Auto(String marca, String modello, int anno) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
    }
    public Auto(String marca, String modello, int anno, ArrayList parti) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.parti = parti;
    }
    
    public void addParte(ParteDiRicambio parte){
        this.parti.add(parte);
    }

    public void setParti(ArrayList parti) {
        this.parti = parti;
    }

    public ArrayList getParti() {
        return parti;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public int getAnno() {
        return anno;
    }
    
    @Override
    public String toString(){
        return marca + " " + modello + " (" + anno + "), numero parti: " + parti.size();
    }
    
}
