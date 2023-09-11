import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CircoloPrivatoTest {
    private CircoloPrivato circolo;

    @Before
    public void setUp() {
        circolo = new CircoloPrivato();
    }

    @Test
    public void testAggiungiSocio() {
        Socio socio = new Socio("Mario", "Rossi", 35, 'M');
        circolo.aggiungiSocio(socio);
        assertEquals(1, circolo.getSoci().size());
    }

    @Test
    public void testModificaSocio() {
        Socio socio1 = new Socio("Mario", "Rossi", 35, 'M');
        Socio socio2 = new Socio("Luigi", "Bianchi", 40, 'M');

        circolo.aggiungiSocio(socio1);
        circolo.modificaSocio(0, socio2);

        assertEquals(socio2, circolo.getSoci().get(0));
    }

    @Test
    public void testRimuoviSocio() {
        Socio socio1 = new Socio("Mario", "Rossi", 35, 'M');
        Socio socio2 = new Socio("Luigi", "Bianchi", 40, 'M');

        circolo.aggiungiSocio(socio1);
        circolo.aggiungiSocio(socio2);

        circolo.rimuoviSocio(0);
        assertEquals(1, circolo.getSoci().size());
        assertEquals(socio2, circolo.getSoci().get(0));
    }

    @Test
    public void testIncrementaEtaDiTutti() {
        Socio socio1 = new Socio("Mario", "Rossi", 35, 'M');
        Socio socio2 = new Socio("Luigi", "Bianchi", 40, 'M');

        circolo.aggiungiSocio(socio1);
        circolo.aggiungiSocio(socio2);

        circolo.incrementaEtaDiTutti(5);

        assertEquals(40, circolo.getSoci().get(0).getEta());
        assertEquals(45, circolo.getSoci().get(1).getEta());
    }

    @Test
    public void testCalcolaEtaMedia() {
        Socio socio1 = new Socio("Mario", "Rossi", 35, 'M');
        Socio socio2 = new Socio("Luigi", "Bianchi", 40, 'M');

        circolo.aggiungiSocio(socio1);
        circolo.aggiungiSocio(socio2);

        double etaMedia = circolo.calcolaEtaMedia();
        assertEquals(37.5, etaMedia, 0.01);
    }

    @Test
    public void testCalcolaEtaMediaMaschile() {
        Socio socio1 = new Socio("Mario", "Rossi", 35, 'M');
        Socio socio2 = new Socio("Luigi", "Bianchi", 40, 'M');
        Socio socio3 = new Socio("Anna", "Verdi", 30, 'F');

        circolo.aggiungiSocio(socio1);
        circolo.aggiungiSocio(socio2);
        circolo.aggiungiSocio(socio3);

        double etaMediaMaschile = circolo.calcolaEtaMediaMaschile();
        assertEquals(37.5, etaMediaMaschile, 0.01);
    }

    @Test
    public void testCalcolaEtaMediaFemminile() {
        Socio socio1 = new Socio("Mario", "Rossi", 35, 'M');
        Socio socio2 = new Socio("Luigi", "Bianchi", 40, 'M');
        Socio socio3 = new Socio("Anna", "Verdi", 30, 'F');

        circolo.aggiungiSocio(socio1);
        circolo.aggiungiSocio(socio2);
        circolo.aggiungiSocio(socio3);

        double etaMediaFemminile = circolo.calcolaEtaMediaFemminile();
        assertEquals(30.0, etaMediaFemminile, 0.01);
    }
}
