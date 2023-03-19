/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoleggio;

/**
 *
 * @author nicolabernardi
 */
public class Veicolo {
    private String targa;
    private int matricola;
    private String marca;
    private String modello;
    private int cilindrata;
    private int anno;
    private int serbatoio;

    public Veicolo(String targa, int matricola, String marca, String modello, int cilindrata, int anno, int serbatoio) {
        this.targa = targa;
        this.matricola = matricola;
        this.marca = marca;
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.anno = anno;
        this.serbatoio = serbatoio;
    }

    public int getSerbatoio() {
        return serbatoio;
    }
    
    
}
