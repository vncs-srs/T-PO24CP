import java.util.List;
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

}