import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class usaCampeonato {
    private List<Jogador> jogadores;
    private String tipoJogador;
    private String nome;

    public void menu() {
        
        this.jogadores = new ArrayList<>();
        char opcao;
        String arquivo = "jogogeneralASCII.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        }

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
                do {    
                    Scanner entrada = new Scanner (System .in);
                    System.out.print("Tipo de Jogador Humano ou Maquina(H/m): ");
                    opcao = entrada.nextInt();
            
                    if(opcao == 'm' || opcao == 'M'){
                        tipoJogador = 'Maquina';
                        this.tipoJogador = tipoJogador;
                        nome = 'Bob-bot';
                        this.nome = nome;
                    }
            
                    else if(opcao == 'h' || opcao == 'H'){
                        tipoJogador = 'Humano';
                        this.tipoJogador = tipoJogador;
                        System.out.print("Nome do Jogador: ");
                        nome = entrada.nextInt();
                        this.nome = nome;
                        } 
                    else {
                        Syetem.out.println("Opção inválida. Tente novamente.")
                    }
                    adicionadoJogador(nome, tipoJogador);
                    System.out.print("Deseja Inserir um novo Jogador(s/n): ")
                    System.out.flush();
                } while (opcao == 's');
                    break;
                case 'r':
                    System.out.println("Qual Jogador deseja remover: ");
                    nome = opcao.next();
                    removerJogador(nome);
                    break;
                case 'i':
                    iniciarCampeonato()
                    break;
                case 'm':
                    mostrarCartela()
                    break;
                case 'g':
                    gravarEmArquivo()
                    break;
                case 'd':
                    lerDoArquivo();
                    break;
                case 's':
                    System.out.println("Saindo do jogo. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            System.out.flush();
        } while (opcao != 's');
    }

    public static void main(String[] args) {
        Scanner menu = new Scanner (System.in);
        Campeonato jogo = new Campeonato();
        jogo.menu();
    }
}
                                
