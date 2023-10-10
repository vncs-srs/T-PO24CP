import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;

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
        int entrada;
        boolean[] valida = new boolean[13];
        Scanner decisao = new Scanner(System.in);
        for (int i = 0; i < rodadas; i++) {
            System.out.println("\nRodada " + (i + 1) + ":");
            for (Jogador jogador : jogadores) 
            {
                if(jogador!=null)
                {
                    System.out.println("\nJogador " + jogador.getNome() + " (" + jogador.getTipo() + ")");
                    jogador.jogarDados();
                    System.out.print("\n>para qual jogada deseja marcar: [1 - 13]\n1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S-) 11(S+) 12(G) 13(X)\n");
                    do{
                        entrada = decisao.nextInt();
                        jogador.validarJogada(entrada);
                        
                    }while(valida[entrada-1] == true);
                    valida[entrada-1] = true;
                    jogador.mostraJogadasExecutadas();
                }
                
            }
        }        
    }
    public void mostrarCartela()
    {
        int i;
        for(i=0;i<10;i++)
        {
            if(jogadores[i]!=null)
            {
                jogadores[i].getNome();
                jogadores[i].getTipo();
                jogadores[i].mostraJogadasExecutadas();
            }
        }

    }
    public void gravarEmArquivo()
    {
        /*Gravar em arquivo*/
        File arquivo = new File("Placar.dat");
        try 
        {
            FileOutputStream fout = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            // gravando o vetor de pessoas no arquivo
            oos.writeObject(jogadores);
            oos.flush();
            oos.close();
            fout.close();
        }
        catch (Exception ex) {
            System.err.println("erro: " + ex.toString());
        }    
    }
    public void lerDoArquivo(){
        File arquivo = new File("Placar.dat");
  
        try 
        {
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream oin = new ObjectInputStream(fin);
            /*Lendo os objetos de um arquivo e fazendo a
            coercao de tipos*/
            
            jogadores = (Jogador[]) oin.readObject();
            oin.close();
            fin.close();
            
            //Uma forma de diferente do for para percorrer vetores
            //isso provavelmente nao vai dar certo
            for (Jogador j : jogadores) 
            {
                j.getNome();
                j.getTipo();
                j.mostraJogadasExecutadas();
            }

        }
        catch (Exception ex) 
        {
            System.err.println("erro: " + ex.toString());
        }
    }
}