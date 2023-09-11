import java.io.Serializable;

public class Cliente implements Serializable {
    private String codiceCliente;
    private String cognome;
    private String nome;
    private String nazioneNascita;
    private String cittaNascita;
    private String dataNascita;

    public Cliente(String codiceCliente, String cognome, String nome, String nazioneNascita, String cittaNascita, String dataNascita) {
        this.codiceCliente = codiceCliente;
        this.cognome = cognome;
        this.nome = nome;
        this.nazioneNascita = nazioneNascita;
        this.cittaNascita = cittaNascita;
        this.dataNascita = dataNascita;
    }

    public Cliente(String rossi, String mario, String italia, String roma, String cittaNascita) {
    }

    public String getCodiceCliente() {
        return codiceCliente;
    }

    public void setCodiceCliente(String codiceCliente) {
        this.codiceCliente = codiceCliente;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNazioneNascita() {
        return nazioneNascita;
    }

    public void setNazioneNascita(String nazioneNascita) {
        this.nazioneNascita = nazioneNascita;
    }

    public String getCittaNascita() {
        return cittaNascita;
    }

    public void setCittaNascita(String cittaNascita) {
        this.cittaNascita = cittaNascita;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public String toString() {
        return "Codice Cliente: " + codiceCliente + "\n" +
                "Cognome: " + cognome + "\n" +
                "Nome: " + nome + "\n" +
                "Nazione di Nascita: " + nazioneNascita + "\n" +
                "Città di Nascita: " + cittaNascita + "\n" +
                "Data di Nascita: " + dataNascita;
    }
}
