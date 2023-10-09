import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

public class Campeonato {
    private Jogador[] jogadores;
    private int quantidadeJogadores;

    public Campeonato() {
        int maxJogadores = 10;
        this.jogadores = new Jogador[maxJogadores];
        this.quantidadeJogadores = 0;
    }
    public void adicionarJogador(Jogador jogador) {
        if (quantidadeJogadores < jogadores.length) {
            jogadores[quantidadeJogadores] = jogador;
            quantidadeJogadores++;
            System.out.println("Jogador " + jogador.getNome() + " adicionado.");
        } else {
            System.out.println("Não é possível adicionar mais jogadores. Limite atingido.");
        }
        return;
    }
    public void removerJogador(String nome) {
        for (int i = 0; i < quantidadeJogadores; i++) {
            if (jogadores[i].getNome().equals(nome)) {
                for (int j = i; j < quantidadeJogadores - 1; j++) {
                    jogadores[j] = jogadores[j + 1];
                }
                jogadores[quantidadeJogadores - 1] = null;
                quantidadeJogadores--;
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
                jogador.mostraJogadasExecutadas();
            }
        }
    }
    public void mostrarCartela(){

    }
    public void gravarEmArquivo(){
        
    }
    /*public void lerDoArquivo(){
        String arquivo = "Resulados.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
           String linha;
                while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        }
    }*/
}