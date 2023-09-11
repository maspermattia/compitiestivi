import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContenitoreClienti {
    private List<Cliente> clienti = new ArrayList<>();

    public void aggiungiCliente(Cliente cliente) {
        clienti.add(cliente);
    }

    public void eliminaCliente(String codiceCliente) {
        clienti.removeIf(cliente -> cliente.getCodiceCliente().equals(codiceCliente));
    }

    public void modificaCliente(Cliente clienteModificato) {
        for (int i = 0; i < clienti.size(); i++) {
            Cliente cliente = clienti.get(i);
            if (cliente.getCodiceCliente().equals(clienteModificato.getCodiceCliente())) {
                clienti.set(i, clienteModificato);
                break;
            }
        }
    }

    public Cliente cercaClientePerCodice(String codiceCliente) {
        for (Cliente cliente : clienti) {
            if (cliente.getCodiceCliente().equals(codiceCliente)) {
                return cliente;
            }
        }
        return null;
    }
public int getNumeroClienti() {
        return clienti.size();
    }

    public void salvaSuFile(String nomeFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            oos.writeObject(clienti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ripristinaDaFile(String nomeFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))) {
            clienti = (List<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
