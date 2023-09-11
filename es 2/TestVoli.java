import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TestVoli {

    private ContenitoreVoli contenitoreVoli;

    @Before
    public void setUp() {
        contenitoreVoli = new ContenitoreVoli();
    }

    @Test
    public void testAggiungiVolo() {
        Volo volo = new Volo("V001", "JFK", "LAX", "2023-09-20", "09:00", "12:00", 150, 300.0);
        contenitoreVoli.aggiungiVolo(volo);
        assertEquals(1, contenitoreVoli.getNumeroVoli());
    }

    @Test
    public void testEliminaVolo() {
        Volo volo = new Volo("V001", "JFK", "LAX", "2023-09-20", "09:00", "12:00", 150, 300.0);
        contenitoreVoli.aggiungiVolo(volo);
        contenitoreVoli.eliminaVolo(volo.getCodiceVolo());
        assertNull(contenitoreVoli.cercaVoloPerCodice(volo.getCodiceVolo()));
    }

    @Test
    public void testModificaVolo() {
        Volo volo = new Volo("V001", "JFK", "LAX", "2023-09-20", "09:00", "12:00", 150, 300.0);
        contenitoreVoli.aggiungiVolo(volo);
        String nuovoAeroportoPartenza = "LHR";
        volo.setAeroportoPartenza(nuovoAeroportoPartenza);
        contenitoreVoli.modificaVolo(volo);
        Volo voloModificato = contenitoreVoli.cercaVoloPerCodice(volo.getCodiceVolo());
        assertEquals(nuovoAeroportoPartenza, voloModificato.getAeroportoPartenza());
    }

    @Test
    public void testCercaVoloPerCodice() {
        Volo volo = new Volo("V001", "JFK", "LAX", "2023-09-20", "09:00", "12:00", 150, 300.0);
        contenitoreVoli.aggiungiVolo(volo);
        Volo voloTrovato = contenitoreVoli.cercaVoloPerCodice(volo.getCodiceVolo());
        assertNotNull(voloTrovato);
    }

    @Test
    public void testCercaVoloPerParametri() {
        Volo volo1 = new Volo("V001", "JFK", "LAX", "2023-09-20", "09:00", "12:00", 150, 300.0);
        Volo volo2 = new Volo("V002", "LHR", "CDG", "2023-09-21", "10:00", "13:00", 200, 350.0);
        contenitoreVoli.aggiungiVolo(volo1);
        contenitoreVoli.aggiungiVolo(volo2);

        List<Volo> voliTrovati = contenitoreVoli.cercaVoloPerParametri("2023-09-20", "JFK", "LAX", "09:00");
        assertEquals(1, voliTrovati.size());
        assertEquals("V001", voliTrovati.get(0).getCodiceVolo());
    }
}
