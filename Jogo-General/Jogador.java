import java.util.List;

public class Jogador {
    private String nome;
    private String tipo;
    private List<Integer> jogadasExecutadas;
    private int[] dados;

    public Jogador(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
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
    public void jogarDados(int dados) { 
        dados.rolarDados();
        System.out.println("Jogador " + nome + " jogou o dado e obteve: " + dados);
    }
    public void mostraJogadasExecutadas() {
        System.out.println("Jogadas executadas por " + nome + ": " + jogadasExecutadas);
    }
}