import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContenitorePrenotazioni {
    private List<Prenotazione> prenotazioni = new ArrayList<>();

    public void aggiungiPrenotazione(Prenotazione prenotazione) {
        prenotazioni.add(prenotazione);
    }

    public void eliminaPrenotazione(String codiceCliente, String codiceVolo) {
        prenotazioni.removeIf(prenotazione ->
                prenotazione.getCodiceCliente().equals(codiceCliente) &&
                        prenotazione.getCodiceVolo().equals(codiceVolo));
    }

    public void modificaPrenotazione(Prenotazione prenotazioneModificata) {
        for (int i = 0; i < prenotazioni.size(); i++) {
            Prenotazione prenotazione = prenotazioni.get(i);
            if (prenotazione.getCodiceCliente().equals(prenotazioneModificata.getCodiceCliente()) &&
                    prenotazione.getCodiceVolo().equals(prenotazioneModificata.getCodiceVolo())) {
                prenotazioni.set(i, prenotazioneModificata);
                break;
            }
        }
    }

    public Prenotazione cercaPrenotazione(String codiceCliente, String codiceVolo) {
        for (Prenotazione prenotazione : prenotazioni) {
            if (prenotazione.getCodiceCliente().equals(codiceCliente) &&
                    prenotazione.getCodiceVolo().equals(codiceVolo)) {
                return prenotazione;
            }
        }
        return null;
    }

    public List<Prenotazione> cercaPrenotazioniPerCliente(String codiceCliente) {
        List<Prenotazione> prenotazioniCliente = new ArrayList<>();
        for (Prenotazione prenotazione : prenotazioni) {
            if (prenotazione.getCodiceCliente().equals(codiceCliente)) {
                prenotazioniCliente.add(prenotazione);
            }
        }
        return prenotazioniCliente;
    }

    public List<Prenotazione> cercaPrenotazioniPerVolo(String codiceVolo) {
        List<Prenotazione> prenotazioniVolo = new ArrayList<>();
        for (Prenotazione prenotazione : prenotazioni) {
            if (prenotazione.getCodiceVolo().equals(codiceVolo)) {
                prenotazioniVolo.add(prenotazione);
            }
        }
        return prenotazioniVolo;
    }

    public int getNumeroPrenotazioni() {
        return prenotazioni.size();
    }

    public void salvaSuFile(String nomeFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            oos.writeObject(prenotazioni);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ripristinaDaFile(String nomeFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))) {
            prenotazioni = (List<Prenotazione>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
