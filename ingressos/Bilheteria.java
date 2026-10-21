import java.util.ArrayList;
import java.util.List;

public class Bilheteria {
    private List<Ingresso> ingressos;

    public Bilheteria() {
        ingressos = new ArrayList<>();
    }

    public void adicionarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    public boolean removerIngresso(int codigo) {
        Ingresso ingresso = buscarIngresso(codigo);
        if (ingresso == null) {
            return false;
        }
        ingressos.remove(ingresso);
        return true;
    }

    public Ingresso buscarIngresso(int codigo) {
        for (Ingresso ingresso : ingressos) {
            if (ingresso.getCodigo() == codigo) {
                return ingresso;
            }
        }
        return null;
    }

    public void listarIngressos() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }
        for (Ingresso ingresso : ingressos) {
            ingresso.exibirInformacoes();
            System.out.println();
        }
    }

    public double calcularArrecadacaoTotal() {
        double total = 0;
        for (Ingresso ingresso : ingressos) {
            total += ingresso.calcularValorFinal();
        }
        return total;
    }

    public void listarBeneficios() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }
        for (Ingresso ingresso : ingressos) {
            System.out.println("Codigo " + ingresso.getCodigo() + ": " + ingresso.obterBeneficios());
        }
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }
}
