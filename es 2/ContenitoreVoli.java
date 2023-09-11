import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContenitoreVoli {
    private List<Volo> voli = new ArrayList<>();

    public void aggiungiVolo(Volo volo) {
        voli.add(volo);
    }

    public void eliminaVolo(String codiceVolo) {
        Volo voloDaEliminare = null;
        for (Volo volo : voli) {
            if (volo.getCodiceVolo().equals(codiceVolo)) {
                voloDaEliminare = volo;
                break;
            }
        }
        if (voloDaEliminare != null) {
            voli.remove(voloDaEliminare);
        }
    }

    public void modificaVolo(Volo voloModificato) {
        for (int i = 0; i < voli.size(); i++) {
            Volo volo = voli.get(i);
            if (volo.getCodiceVolo().equals(voloModificato.getCodiceVolo())) {
                voli.set(i, voloModificato);
                break;
            }
        }
    }

    public Volo cercaVoloPerCodice(String codiceVolo) {
        for (Volo volo : voli) {
            if (volo.getCodiceVolo().equals(codiceVolo)) {
                return volo;
            }
        }
        return null;
    }

    public List<Volo> cercaVoloPerParametri(String data, String aeroportoPartenza, String aeroportoArrivo, String orarioPartenza) {
        List<Volo> voliTrovati = new ArrayList<>();
        for (Volo volo : voli) {
            if (volo.getData().equals(data) &&
                    volo.getAeroportoPartenza().equals(aeroportoPartenza) &&
                    volo.getAeroportoArrivo().equals(aeroportoArrivo) &&
                    volo.getOrarioPartenza().equals(orarioPartenza)) {
                voliTrovati.add(volo);
            }
        }
        return voliTrovati;
    }

    public int getNumeroVoli() {
        return voli.size();
    }

    public void salvaSuFile(String nomeFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            oos.writeObject(voli);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ripristinaDaFile(String nomeFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))) {
            voli = (List<Volo>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
