import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class usaCampeonato {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";

    //private Campeonato campeonato;
    //private Jogador jogador;


    public static void menu(Campeonato jogo) {
        String tipoJogador;
        String nome;
        char opcao;
            Scanner menu = new Scanner (System.in);

        //this.campeonato = campeonato;

        do {
            System.out.println("                > Menu: ");
            System.out.println("|--------------------------------------------------------------|");
            System.out.println("| (a) Adicionar jogador                                        |");
            System.out.println("| (r) Remover jogador                                          |");
            System.out.println("| (i) Iniciar Jogo                                             |");
            System.out.println("| (m) Mostrar cartela                                          |");
            System.out.println("| (g) Gravar os dados                                          |");
            System.out.println("| (d) Dados do campeonato                                      |");
            System.out.println("| (s) Sair                                                     |");
            System.out.println("|--------------------------------------------------------------|");
            System.out.print("Escolha uma opção: ");
            opcao = menu.next().charAt(0);
            
            switch (opcao) {
                case 'a':    
                    Scanner entrada = new Scanner (System.in);

                    System.out.print("Tipo de Jogador Humano ou Maquina(H/m): ");
                    tipoJogador = entrada.next();
                    System.out.print("Nome do jogador: ");
                    nome = entrada.next();
                    if(tipoJogador == "H" || tipoJogador == "h"){
                        tipoJogador = "Humano";
                    }
                    else if(tipoJogador == "M" || tipoJogador == "m"){
                        tipoJogador = "Maquina";
                        nome = nome+"-bot";
                    }
                    Jogador jogador = new Jogador(nome,tipoJogador);

                    jogo.adicionarJogador(jogador);

                    break;
                case 'r':
                    Scanner name = new Scanner(System.in);
                    System.out.println("Qual Jogador deseja remover: ");
                    nome = name.next();
                    jogo.removerJogador(nome);
                    break;
                case 'i':
                    jogo.iniciarCampeonato();
                    break;
                case 'm':
                    jogo.mostrarCartela();
                    break;
                case 'g':
                    jogo.gravarEmArquivo();
                    break;
                case 'd':
                    jogo.lerDoArquivo();
                    break;
                case 's':
                    String sistemaOperacional = System.getProperty("os.name").toLowerCase();
                    try {
                        if (sistemaOperacional.contains("win")) {
                            // Para Windows
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        } else {
                            // Para Unix (Linux, macOS)
                            new ProcessBuilder("clear").inheritIO().start().waitFor();
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao limpar o terminal: " + e.getMessage());
                    }
                    System.out.println("Saindo do jogo. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
           /*  String sistemaOperacional = System.getProperty("os.name").toLowerCase();
            try {
                if (sistemaOperacional.contains("win")) {
                    // Para Windows
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    // Para Unix (Linux, macOS)
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                }
            } catch (Exception e) {
                System.out.println("Erro ao limpar o terminal: " + e.getMessage());
            }*/
        } while (opcao != 's');
    }

    public static void main(String[] args) {
        Campeonato jogo = new Campeonato();

        String nomeArquivo = "jogogeneralASCII.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(GREEN+linha+RESET);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        menu(jogo);
    }
}
                                
