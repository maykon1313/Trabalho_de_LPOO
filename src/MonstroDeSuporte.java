package src;
import java.util.ArrayList;

public class MonstroDeSuporte extends Monstro {
    public MonstroDeSuporte(String nome){
        super(nome);
    }

    public int receberEnergia(int energia, Cilindro c) {
        int energia_real = energia + (int) (Math.random() * energia * this.getEficiencia());
        c.armazenarEnergia(energia_real);
        System.out.println(getNome() + " amazenou " + energia_real + " unidades de energia no cilindro " + c.getId() + ".");
        return energia_real;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + " | Eficiencia: " + String.format("%.4f", this.getEficiencia()) + " | Tipo: Suporte";
    }
}
