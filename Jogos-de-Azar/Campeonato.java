import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            //se der BO aqui fazer isso no h/m
            jogadores[quantidadeJogadores].setSaldoJogador();
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
        for (Jogador jogador : jogadores){
            if (jogador != null){
                if (jogador instanceof Humano){
                    System.out.println("\nJogador " + jogador.getNome() + " (Humano)");
                    ((Humano)jogador).escolherValorDaAposta();
                }
                else if (jogador instanceof Maquina){
                    System.out.println("\nJogador " + jogador.getNome() + " (Maquina)");
                    ((Maquina)jogador).escolherValorDaAposta();
                }
            }
        }
    }

    //Mostra a cartela de resultados

    public void mostrarCartela(){
        int opcao;
        Scanner menu = new Scanner (System.in);
        do {
            System.out.println("                > Cartela de Resultados:");
            System.out.println("|--------------------------------------------------------------|");
            System.out.println("| (1) Mostrar dados de todos os jogadores                      |");
            System.out.println("| (2) Mostrar dados dos Jogadores do tipo Humanos              |");
            System.out.println("| (3) Mostrar dados dos Jogadores do tipo Maquinas             |");
            System.out.println("| (0) Sair                                                     |");
            System.out.println("|--------------------------------------------------------------|");
            System.out.print("Escolha uma opção: ");
            opcao = menu.nextInt();

            switch (opcao) { 
                case 1:
                        System.out.println("Dados de todos os jogadores:");
                        mostrarDadosTodosJogadores();
                    break;
                case 2:
                    System.out.println("Dados dos Jogadores do tipo Humanos:");
                    mostrarDadosJogadoresPorTipo("H");
                    break;
                
                case 3:
                    System.out.println("Dados dos Jogadores do tipo Máquinas:");
                    mostrarDadosJogadoresPorTipo("M");
                    break;

                case 0:
                    System.out.println("Saindo do menu.");
                    break;
            
                default:
                    System.out.println("Opção inválida. Tente novamente.");           
                    break;
            }
        }while (opcao != 0);
        
    }
    private void mostrarDadosTodosJogadores() {
        for (Jogador jogador : jogadores) {
            if (jogador != null) {
                System.out.printf("%-8s", jogador.getNome() + "(" + jogador.getTipo() + ")");
    
                for (int i = 0; i < jogador.getTurno(); i++) {
                    System.out.printf("(" + obterTipoJogoAbreviado(jogador) + ")");
                    System.out.printf("%.2f\t\t", + jogador.getterGetSaldoTemporario(i));
                }
                System.out.print("Total:");
                System.out.printf("\t(%.2f)\t\t", jogador.getSaldoJogador());
                System.out.println();
            }
        }
        System.out.println();
    }
    
    private void mostrarDadosJogadoresPorTipo(String tipo) {
        for (Jogador jogador : jogadores) {
            if (jogador != null && jogador.getTipo().equalsIgnoreCase(tipo)) {
                System.out.printf("%-8s", jogador.getNome() + "(" + jogador.getTipo() + ")");
    
                for (int i = 0; i < jogador.getTurno(); i++) {
                    System.out.printf("(" + obterTipoJogoAbreviado(jogador) + ")");
                    System.out.printf("%.2f\t\t", + jogador.getterGetSaldoTemporario(i));

                }
                System.out.print("Total:");
                System.out.printf("\t(%.2f)\t\t", jogador.getSaldoJogador());
                System.out.println();
            }
        }
        System.out.println();
    }

    private String obterTipoJogoAbreviado(Jogador jogador) {
        int tipoJogo = jogador.getTipoJogo();

        switch (tipoJogo) {
            case 1:
                return "J.G";
            case 2:
                return "J.A";
            default:
                return "";
        }
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