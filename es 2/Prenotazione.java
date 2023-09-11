public class Prenotazione {
    private String codiceCliente;
    private String codiceVolo;
    private int numeroBagagli;
    private double pesoBagagli;

    public Prenotazione(String codiceCliente, String codiceVolo, int numeroBagagli, double pesoBagagli) {
        this.codiceCliente = codiceCliente;
        this.codiceVolo = codiceVolo;
        this.numeroBagagli = numeroBagagli;
        this.pesoBagagli = pesoBagagli;
    }

    public String getCodiceCliente() {
        return codiceCliente;
    }

    public void setCodiceCliente(String codiceCliente) {
        this.codiceCliente = codiceCliente;
    }

    public String getCodiceVolo() {
        return codiceVolo;
    }

    public void setCodiceVolo(String codiceVolo) {
        this.codiceVolo = codiceVolo;
    }

    public int getNumeroBagagli() {
        return numeroBagagli;
    }

    public void setNumeroBagagli(int numeroBagagli) {
        this.numeroBagagli = numeroBagagli;
    }

    public double getPesoBagagli() {
        return pesoBagagli;
    }

    public void setPesoBagagli(double pesoBagagli) {
        this.pesoBagagli = pesoBagagli;
    }

    @Override
    public String toString() {
        return "Codice Cliente: " + codiceCliente + "\n" +
                "Codice Volo: " + codiceVolo + "\n" +
                "Numero di Bagagli: " + numeroBagagli + "\n" +
                "Peso Bagagli: " + pesoBagagli;
    }
}
