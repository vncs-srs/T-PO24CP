import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Iterator;

public class usaCampeonato {

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
                do {    

                    Scanner entrada = new Scanner (System.in);
                    System.out.print("Nome: ");
                    nome = entrada.next();
                    System.out.print("Tipo: ");
                    tipoJogador = entrada.next();
                    Jogador jogador = new Jogador(nome,tipoJogador);
                    System.out.print("Tipo de Jogador Humano ou Maquina(H/m): ");
                    opcao = entrada.next().charAt(0);
            
                    if(opcao == 'm' || opcao == 'M'){
                        tipoJogador = "Maquina";
                        //this.tipoJogador = tipoJogador;
                        nome = "Bob-bot";
                        //this.nome = nome;
                    }
            
                    else if(opcao == 'h' || opcao == 'H'){
                        tipoJogador = "Humano";
                        //this.tipoJogador = tipoJogador;
                        System.out.print("Nome do Jogador: ");
                        nome = entrada.next();
                        //this.nome = nome;
                        } 
                    else {
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                    jogo.adicionarJogador(jogador);
                    System.out.print("Deseja Inserir um novo Jogador(s/n): ");
                    System.out.flush();
                } while (opcao == 's');
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
                    //campeonato.lerDoArquivo();
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
        Campeonato jogo = new Campeonato();

        /*String arquivo = "jogogeneralASCII.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        }*/
        menu(jogo);
    }
}
                                
