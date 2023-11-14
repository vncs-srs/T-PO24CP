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

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";

    public Campeonato() {
        int maxJogadores = 10;
        this.jogadores = new Jogador[maxJogadores];
        this.quantidadeJogadores = 0;
    }
    //Adiciona os Jogadores e verifica se nao estrapolou o limite permitido
    public void adicionarJogador(Jogador jogador) {
        if (quantidadeJogadores < jogadores.length) {
            jogadores[quantidadeJogadores] = jogador;
            quantidadeJogadores++;
            System.out.println("Jogador " +GREEN+ jogador.getNome() +RESET+ " adicionado.");
        } else {
            System.out.println("Não é possível adicionar mais jogadores. Limite atingido.");
        }
        return;
    }
    //Remove os jogadores pelo nome
    public void removerJogador(String nome) {
        for (int i = 0; i < quantidadeJogadores; i++) {
            if (jogadores[i].getNome().equals(nome)) {
                for (int j = i; j < quantidadeJogadores - 1; j++) {
                    jogadores[j] = jogadores[j + 1];
                }
                jogadores[quantidadeJogadores - 1] = null;
                quantidadeJogadores--;
                System.out.println("Jogador "+GREEN+ nome +RESET+ " removido.");
                return;
            }
        }
        System.out.println("Jogador " +GREEN+ nome +RESET+ " não encontrado.");
    }

    //Inicia o Jogo
    public void iniciarCampeonato(){
        int rodadas = 13; 
        int entrada;
        String verificaTipo;
        Scanner decisao = new Scanner(System.in);
        for (int i = 0; i < rodadas; i++) {
            System.out.println("\nRodada " + (i + 1) + ":");
            for (Jogador jogador : jogadores) 
            { 
                entrada = 0;
                if(jogador!=null)
                {
                    if(i==0)
                    {
                        jogador.resetPontos();
                    }
                    switch(jogador.getTipo()){
                    case "h":
                        System.out.println("\nJogador " + jogador.getNome() + " (Humano)");
                        jogador.jogarDados();
                        System.out.print("\n>Para qual jogada deseja marcar: [1 - 13]\n1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S-) 11(S+) 12(G) 13(X)\n");
                        do{
                            entrada = decisao.nextInt();
                            jogador.validarJogada(entrada);
                            
                            if(jogador.verificaBoolean(entrada-1)== true)
                                System.out.println("Opcao invalida. Tente novamente");
                        }while(jogador.verificaBoolean(entrada-1) == true);
                        jogador.BooleanTrue(entrada-1);
                        jogador.mostraJogadasExecutadas();

                        break;
                    case "m":
                        System.out.println("\nJogador " + jogador.getNome() + " (Maquina)");
                        jogador.jogarDados();
                        System.out.print("\nPara qual jogada deseja marcar: [1 - 13]\n1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S-) 11(S+) 12(G) 13(X)\n");
                        do{
                            entrada = jogador.maquina();
                            jogador.validarJogada(entrada);
                            
                        }while(jogador.verificaBoolean(entrada-1) == true);
                        jogador.BooleanTrue(entrada-1);
                        jogador.mostraJogadasExecutadas();
                        break;
                    }
                    if(i==12)
                    jogador.resetBoolean();

                }
                
            }
        } 
    }
    //Mostra a cartela de resultados

    public void mostrarCartela(){
        System.out.println("-- Cartela de Resultados --");

        System.out.printf("%-10s", "");
        for (Jogador jogador : jogadores) {
            if(jogador!=null)
                System.out.printf("%-8s", jogador.getNome() + "(" + jogador.getTipo() + ")\t");
        }
        System.out.println();
        for (int i = 1; i <= 13; i++) {
            System.out.printf("%-10s", i);
            for (Jogador j : jogadores) {
                if(j!=null)
                    System.out.print(j.mostraPontosJogadaN(i-1)+"\t\t");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
        System.out.print("Total:");
        for (Jogador jogador : jogadores) {
            if(jogador!=null)
                System.out.printf("\t("+jogador.salvaPontos()+")\t");
        }
        System.out.println();
    }
    //Grava os dados do jogo em arquivo. 
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
        System.out.println("Arquivo gravado em Placar.dat.");
    }
    //ler o arquivo gravado
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
                if(j!=null)
                {
                    quantidadeJogadores++;
                }
            }

        }
        catch (Exception e) 
        {
            System.err.println("Erro ao ler o arquivo!" + e.getMessage());
        }
        System.out.println("Dados Restaurados.");
    }
}
