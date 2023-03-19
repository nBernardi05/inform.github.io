/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoleggio;

/**
 *
 * @author nicolabernardi
 */
public class Vettura extends Veicolo {
    private int nPosti;

    public Vettura(int nPosti, String targa, int matricola, String marca, String modello, int cilindrata, int anno, int serbatoio) {
        super(targa, matricola, marca, modello, cilindrata, anno, serbatoio);
        this.nPosti = nPosti;
    }
    
    
}
