    package src;

    public abstract class Monstro {
        private String nome;
        private int eficiencia;

        public Monstro(String nome){
            this.nome = nome;
            this.eficiencia = (int)(Math.random()*100); 
            // o esperado é que fique 100 redondinho igual o do maykon
            // em caso de erro usar o 101* vai até 100.999....o int vai arredondar pra 100
        }

        public String getNome() { return nome; }
        public int getEficiencia() { return eficiencia; }
        public void setEficiencia(int eficiencia) { this.eficiencia = eficiencia; }

        public String getTipoMonstro() {
            if (this instanceof MonstroDoSusto) return "susto";
            else if (this instanceof MonstroDoRiso) return "riso";
            else if (this instanceof MonstroDeSuporte) return "suporte";
            return null;
        }

        // Método único para gerar energia
        public int gerarEnergia() {

            // Riso gera mais energia 
            if (this instanceof MonstroDoRiso) {
                return eficiencia;
            }

            // Susto médio
            else if (this instanceof MonstroDoSusto){
                return eficiencia * 2/3;
            }

            return 0;
        } 

        public int coletarEnergiaDaCrianca(Crianca c) {
            if (c == null) return 0;

            String tipo = getTipoMonstro(); // “susto” ou “riso”
            int energiaBase = c.getEnergia(tipo);  // energia da criança
            int energiaProcessada = gerarEnergia(); // eficiência do monstro

    return energiaBase + energiaProcessada;
}

        public void descrever() {
            System.out.println("Nome: " + nome + "| Eficiencia: " + eficiencia + "| Tipo: " + getTipoMonstro() );
        }

        public abstract void trabalhar();
    }