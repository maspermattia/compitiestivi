import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class CircoloPrivato {
    private LinkedList<Socio> soci = new LinkedList<>();
public void caricaSociDaFile(String nomeFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String nome = parts[0];
                    String cognome = parts[1];
                    int eta = Integer.parseInt(parts[2]);
                    char sesso = parts[3].charAt(0);
                    Socio socio = new Socio(nome, cognome, eta, sesso);
                    soci.add(socio);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public void aggiungiSocio(Socio socio) {
        soci.add(socio);
    }
public void modificaSocio(int index, Socio nuovoSocio) {
        if (index >= 0 && index < soci.size()) {
            soci.set(index, nuovoSocio);
        }
    }
public void rimuoviSocio(int index) {
        if (index >= 0 && index < soci.size()) {
            soci.remove(index);
        }
    }
public void incrementaEtaDiTutti(int anni) {
        for (Socio socio : soci) {
            socio.setEta(socio.getEta() + anni);
        }
    }
public double calcolaEtaMedia() {
        if (soci.isEmpty()) {
            return 0;
        }

        int sumEta = soci.stream().mapToInt(Socio::getEta).sum();
        return (double) sumEta / soci.size();
    }
 public double calcolaEtaMediaMaschile() {
        List<Socio> maschi = soci.stream().filter(socio -> socio.getSesso() == 'M').collect(Collectors.toList());
        if (maschi.isEmpty()) {
            return 0;
        }

        int sumEtaMaschile = maschi.stream().mapToInt(Socio::getEta).sum();
        return (double) sumEtaMaschile / maschi.size();
    }
public double calcolaEtaMediaFemminile() {
        List<Socio> femmine = soci.stream().filter(socio -> socio.getSesso() == 'F').collect(Collectors.toList());
        if (femmine.isEmpty()) {
            return 0;
        }

        int sumEtaFemminile = femmine.stream().mapToInt(Socio::getEta).sum();
        return (double) sumEtaFemminile / femmine.size();
    }
 public Map<Character, Double> calcolaDistribuzioneSesso() {
        Map<Character, Double> distribuzione = new HashMap<>();
        long totale = soci.size();

        long maschi = soci.stream().filter(socio -> socio.getSesso() == 'M').count();
        double percentualeMaschi = (maschi / (double) totale) * 100;
        distribuzione.put('M', percentualeMaschi);

        double percentualeFemmine = 100 - percentualeMaschi;
        distribuzione.put('F', percentualeFemmine);

        return distribuzione;
    }
public void esportaSociSuFile(String nomeFile) {
        try (PrintWriter writer = new PrintWriter(nomeFile)) {
            for (Socio socio : soci) {
                writer.println(socio.getNome() + "," + socio.getCognome() + "," + socio.getEta() + "," + socio.getSesso());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 public LinkedList<Socio> getSoci() {
        return soci;
    }
    public void visualizzaSoci() {
        for (int i = 0; i < soci.size(); i++) {
            System.out.println((i + 1) + ". " + soci.get(i));
        }
    }
}