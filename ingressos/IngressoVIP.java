public class IngressoVIP extends Ingresso {
    private boolean acessoBackstage;
    private int numeroLounge;

    public IngressoVIP() {
        super();
        acessoBackstage = false;
        numeroLounge = 0;
    }

    public IngressoVIP(int codigo, String nomeEvento, String setor, double valorBase, boolean acessoBackstage, int numeroLounge) {
        super(codigo, nomeEvento, setor, valorBase);
        this.acessoBackstage = acessoBackstage;
        this.numeroLounge = numeroLounge;
    }

    public boolean isAcessoBackstage() {
        return acessoBackstage;
    }

    public void setAcessoBackstage(boolean acessoBackstage) {
        this.acessoBackstage = acessoBackstage;
    }

    public int getNumeroLounge() {
        return numeroLounge;
    }

    public void setNumeroLounge(int numeroLounge) {
        this.numeroLounge = numeroLounge;
    }

    @Override
    public double calcularValorFinal() {
        return getValorBase() * 1.8;
    }

    @Override
    public String obterBeneficios() {
        String beneficios = "Acesso ao lounge " + numeroLounge;
        if (acessoBackstage) {
            beneficios += " e acesso ao backstage";
        }
        return beneficios + ".";
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("--- Ingresso VIP ---");
        super.exibirInformacoes();
        System.out.println("Lounge: " + numeroLounge);
        if (acessoBackstage) {
            System.out.println("Possui acesso ao backstage.");
        }
    }
}
