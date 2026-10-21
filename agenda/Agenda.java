import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;
    private int quantidadeContatos;

    public Agenda() {
        contatos = new ArrayList<>();
        quantidadeContatos = 0;
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        quantidadeContatos = contatos.size();
    }

    public boolean removerContato(String nome) {
        Contato contato = buscarPorNome(nome);
        if (contato == null) {
            return false;
        }
        contatos.remove(contato);
        quantidadeContatos = contatos.size();
        return true;
    }

    public Contato buscarPorNome(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public Contato buscarPorEmail(String email) {
        for (Contato contato : contatos) {
            if (contato.getEmail().equalsIgnoreCase(email)) {
                return contato;
            }
        }
        return null;
    }

    public Contato buscarPorTelefone(String telefone) {
        for (Contato contato : contatos) {
            if (contato.getTelefone().equals(telefone)) {
                return contato;
            }
        }
        return null;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
        quantidadeContatos = contatos.size();
    }

    public int getQuantidadeContatos() {
        return quantidadeContatos;
    }
}
