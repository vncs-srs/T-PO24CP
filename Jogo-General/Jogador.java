import java.io.Serializable;

public class Jogador implements Serializable{

    private String nome;
    private String tipo;
    private JogoGeneral General ;

    public Jogador(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.General = new JogoGeneral();
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
    public void jogarDados() { 
        General.rolarDados();
        System.out.println("Jogador " + nome + " jogou o dado e obteve: " );
        General.mostraValorDados();
    }
    public void mostraJogadasExecutadas() {
        System.out.println("\nJogadas executadas por " + nome + ": ");
        General.mostraJogadas();
    }
}