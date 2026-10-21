public class ContatoEmergencia extends Contato {
    private int grauPrioridade;
    private String observacao;

    public ContatoEmergencia() {
        super();
        grauPrioridade = 1;
        observacao = "";
    }

    public ContatoEmergencia(String nome, String email, String telefone, int grauPrioridade, String observacao) {
        super(nome, email, telefone);
        setGrauPrioridade(grauPrioridade);
        this.observacao = observacao;
    }

    public int getGrauPrioridade() {
        return grauPrioridade;
    }

    public void setGrauPrioridade(int grauPrioridade) {
        if (grauPrioridade < 1) {
            this.grauPrioridade = 1;
        } else if (grauPrioridade > 5) {
            this.grauPrioridade = 5;
        } else {
            this.grauPrioridade = grauPrioridade;
        }
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public void exibirDados() {
        System.out.println("--- Contato de Emergencia ---");
        super.exibirDados();
        System.out.println("Prioridade: " + grauPrioridade);
        System.out.println("Observacao: " + observacao);
    }
}
