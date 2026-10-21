public class IngressoComum extends Ingresso {

    public IngressoComum() {
        super();
    }

    public IngressoComum(int codigo, String nomeEvento, String setor, double valorBase) {
        super(codigo, nomeEvento, setor, valorBase);
    }

    @Override
    public double calcularValorFinal() {
        return getValorBase();
    }

    @Override
    public String obterBeneficios() {
        return "Nenhum beneficio adicional.";
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("--- Ingresso Comum ---");
        super.exibirInformacoes();
    }
}
