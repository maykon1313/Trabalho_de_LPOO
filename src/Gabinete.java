package src;

public class Gabinete {
    private int id;
    private Porta abracadabra;
    private Monstro monstroPrincipal;
    private MonstroDeSuporte monstroAuxiliar;
    private Cilindro cilindro;

    public Gabinete(int id, Porta abracadabra, Monstro monstroPrincipal, MonstroDeSuporte monstroAuxiliar) {
        this.id = id;
        this.abracadabra = abracadabra;
        this.monstroPrincipal = monstroPrincipal;
        this.monstroAuxiliar = monstroAuxiliar;
    }

    public void setId(int id) { this.id = id; }
    public void setPorta(Porta abracadabra) { this.abracadabra = abracadabra; }
    public void setMonstroPrincipal(Monstro monstroPrincipal) { this.monstroPrincipal = monstroPrincipal; }
    public void setMonstroAuxiliar(MonstroDeSuporte monstroAuxiliar) { this.monstroAuxiliar = monstroAuxiliar; }
    public void setCilindro(Cilindro cilindro) { this.cilindro = cilindro; }

    public int getId() { return this.id; }
    public Porta getPorta() { return this.abracadabra; }
    public Monstro getMonstroPrincipal() { return this.monstroPrincipal; }
    public MonstroDeSuporte getMonstroAuxiliar() { return this.monstroAuxiliar; }
    public Cilindro getCilindro() { return this.cilindro; }

    public String toString() { return "Gabinete ID: " + id + ", Porta: " + abracadabra + ", Monstro Principal: " + monstroPrincipal + ", Monstro Auxiliar: " + monstroAuxiliar + ", Cilindro: " + cilindro; }

    public static void processarEnergia(Cilindro c, Porta p, Monstro m_principal, MonstroDeSuporte m_auxiliar) {
        if (c == null || p == null || m_principal == null || m_auxiliar == null) {
            System.out.println("Erro: Cilindro, Porta ou Monstros inválidos.");
            return;
        }

        Crianca crianca = p.getCrianca();
        if (crianca == null) {
            System.out.println("Erro: Não há criança na porta.");
            return;
        }

        int energiaTotal = m_principal.coletarEnergiaDaCrianca(crianca);

        m_auxiliar.receberEnergia(energiaTotal, c);

        System.out.println("Processamento concluído:");
        System.out.println("Criança: " + crianca.getNome());
        System.out.println("Monstro Principal (" + m_principal.getNome() + ")");
        System.out.println("Monstro Auxiliar (" + m_auxiliar.getNome() + ")");
        System.out.println("Energia total adicionada ao Cilindro (" + c.getId() + "): " + energiaTotal);
    }
}
