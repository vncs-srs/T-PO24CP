import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Campeonato {
    private List<Jogador> jogadores;

    public Campeonato() {
        this.jogadores = new ArrayList<>();
    }

    public void adicionarJogador(String nome, String tipo) {
        Jogador jogador = new Jogador(nome, tipo);
        jogadores.add(jogador);
        System.out.println("Jogador " + nome + " adicionado.");
    }

    public void removerJogador(String nome) {
        Iterator<Jogador> iterator = jogadores.iterator();
        while (iterator.hasNext()) {
            Jogador jogador = iterator.next();
            if (jogador.getNome().equals(nome)) {
                iterator.remove();
                System.out.println("Jogador " + nome + " removido.");
                return;
            }
        }
        System.out.println("Jogador " + nome + " não encontrado.");
    }
    public void iniciarCampeonato(){
        int rodadas = 13; 
        for (int i = 0; i < rodadas; i++) {
            System.out.println("\nRodada " + (i + 1) + ":");
            for (Jogador jogador : jogadores) {
                System.out.println("\nJogador " + jogador.getNome() + " (" + jogador.getTipo() + ")");
                jogador.jogarDados();
                jogador.mostrarJogadasExecutadas();
            }
        }
    }
    public void mostrarCartela(){

    }
    public void gravarEmArquivo(){
        
    }
    public void lerDoArquivo(){
        String arquivo = "Resulados.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
           String linha;
                while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        }
    }
}