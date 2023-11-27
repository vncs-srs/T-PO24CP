import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class usaCampeonato {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";

    //Funcao para limpar o terminal quando chamado.
    public static void limpaTerminal(){
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
    }
    public static void menu(Campeonato jogo) {
        String tipoJogador;
        String nome;
        String cpf;
        String agencia;
        String conta;
        int numeroBanco;
        char opcao;
        Scanner menu = new Scanner (System.in);

        do {
            System.out.println("                > Menu: ");
            System.out.println("|--------------------------------------------------------------|");
            System.out.println("| (a) Adicionar jogador                                        |");
            System.out.println("| (r) Remover jogador                                          |");
            System.out.println("| (i) Iniciar Jogo                                             |");
            System.out.println("| (m) Mostrar cartela                                          |");
            System.out.println("| (g) Gravar os dados                                          |");
            System.out.println("| (l) Ler os dados do campeonato                               |");
            System.out.println("| (s) Sair                                                     |");
            System.out.println("|--------------------------------------------------------------|");
            System.out.print("Escolha uma opção: ");
            opcao = menu.next().charAt(0);
            limpaTerminal();
            
            switch (opcao) {
                case 'a':    
                    Scanner entrada = new Scanner (System.in);
                    do{    
                        System.out.print("Tipo de Jogador Humano ou Maquina(H/m): ");
                        tipoJogador = entrada.next();
                        if(!(tipoJogador.equalsIgnoreCase("H") || tipoJogador.equalsIgnoreCase("M")))
                            System.out.println("Opção inválida. Tente novamente.");
                    }while(!(tipoJogador.equalsIgnoreCase("H") || tipoJogador.equalsIgnoreCase("M")));
                    
                    System.out.print("Nome do jogador: ");
                    nome = entrada.next();
                    if(tipoJogador.equalsIgnoreCase("H")){
                        System.out.println("                > Dados Bancarios: ");
                        System.out.print("CPF: ");
                        cpf = entrada.next();
                        System.out.print("Agencia: ");
                        agencia = entrada.next();
                        System.out.print("Conta: ");
                        conta = entrada.next();
                        System.out.print("Numero do Banco: ");
                        numeroBanco = entrada.nextInt();

                        Jogador jogador = new Humano(nome,tipoJogador,cpf,agencia,conta,numeroBanco);
                        jogo.adicionarJogador(jogador);
                    }
                    else{
                        Jogador jogador = new Maquina(nome, tipoJogador);
                        jogo.adicionarJogador(jogador);
                    }
                    limpaTerminal();
                    //jogo.adicionarJogador(jogador);

                    break;
                case 'r':
                    Scanner name = new Scanner(System.in);
                    System.out.println("Qual Jogador deseja remover: ");
                    nome = name.next();
                    limpaTerminal();
                    jogo.removerJogador(nome);
                    break;
                case 'i':
                    limpaTerminal();
                    jogo.iniciarCampeonato();
                    break;
                case 'm':
                    limpaTerminal();
                    jogo.mostrarCartela();
                    break;
                case 'g':
                    limpaTerminal();
                    jogo.gravarEmArquivo();
                    break;
                case 'l':
                    limpaTerminal();
                    jogo.lerDoArquivo();
                    break;
                case 's':
                    limpaTerminal();
                    System.out.println("Saindo do jogo. Até mais!");
                    break;
                default:
                limpaTerminal();
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 's');
    }

    public static void main(String[] args) {
        Campeonato jogo = new Campeonato();

        //Mostra Escrito na tela JogoGeneal
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
                                
