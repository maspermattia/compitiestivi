import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class Socio {
    private String nome;
    private String cognome;
    private int eta;
    private char sesso;
    public Socio(String nome, String cognome, int eta, char sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.sesso = sesso;
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public int getEta() {
        return eta;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }
    public char getSesso() {
        return sesso;
    }
    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    //toString
    @Override
    public String toString() {
        return nome + " " + cognome + " (età: " + eta + ", sesso: " + sesso + ")";
    }
}
