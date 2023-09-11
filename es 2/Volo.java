import java.io.Serializable;

public class Volo implements Serializable {
    private String codiceVolo;
    private String aeroportoPartenza;
    private String aeroportoArrivo;
    private String data;
    private String oraPartenza;
    private String oraArrivo;
    private int numeroPosti;
    private double costo;

    public Volo(String codiceVolo, String aeroportoPartenza, String aeroportoArrivo, String data, String oraPartenza, String oraArrivo, int numeroPosti, double costo) {
        this.codiceVolo = codiceVolo;
        this.aeroportoPartenza = aeroportoPartenza;
        this.aeroportoArrivo = aeroportoArrivo;
        this.data = data;
        this.oraPartenza = oraPartenza;
        this.oraArrivo = oraArrivo;
        this.numeroPosti = numeroPosti;
        this.costo = costo;
    }

    public String getCodiceVolo() {
        return codiceVolo;
    }

    public String getAeroportoPartenza() {
        return aeroportoPartenza;
    }

    public String getAeroportoArrivo() {
        return aeroportoArrivo;
    }

    public String getData() {
        return data;
    }

    public String getOraPartenza() {
        return oraPartenza;
    }

    public String getOraArrivo() {
        return oraArrivo;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public double getCosto() {
        return costo;
    }

    public void setAeroportoPartenza(String aeroportoPartenza) {
        this.aeroportoPartenza = aeroportoPartenza;
    }

    public void setAeroportoArrivo(String aeroportoArrivo) {
        this.aeroportoArrivo = aeroportoArrivo;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setOraPartenza(String oraPartenza) {
        this.oraPartenza = oraPartenza;
    }

    public void setOraArrivo(String oraArrivo) {
        this.oraArrivo = oraArrivo;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getOrarioPartenza() {
        return oraPartenza;
    }
}
