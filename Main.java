import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        CircoloPrivato circolo = new CircoloPrivato();
        circolo.caricaSociDaFile("soci.txt");

        circolo.visualizzaSoci();
        circolo.aggiungiSocio(new Socio("Mario", "Rossi", 35, 'M'));
        circolo.modificaSocio(0, new Socio("Luigi", "Bianchi", 40, 'M'));
        circolo.rimuoviSocio(1);
        circolo.incrementaEtaDiTutti(5);

        System.out.println("Età media dei soci: " + circolo.calcolaEtaMedia());
        System.out.println("Età media dei soci maschili: " + circolo.calcolaEtaMediaMaschile());
        System.out.println("Età media dei soci femminili: " + circolo.calcolaEtaMediaFemminile());

        Map<Character, Double> distribuzioneSesso = circolo.calcolaDistribuzioneSesso();
        System.out.println("Distribuzione percentuale dei soci per sesso:");
        for (Map.Entry<Character, Double> entry : distribuzioneSesso.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "%");
        }
        circolo.esportaSociSuFile("soci_modificati.txt");
    }
}
