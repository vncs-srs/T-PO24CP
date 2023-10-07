import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class usaCampeonato {

    public void menu() {
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
            System.out.println("| a) Adicionar jogador                                         |");
            System.out.println("| r) Remover jogador                                           |");
            System.out.println("| j) Jogar rodada                                              |");
            System.out.println("| m) Mostrar cartela                                           |");
            System.out.println("| s) Sair                                                      |");
            System.out.println("|--------------------------------------------------------------|");
            System.out.print("Escolha uma opção: ");
            opcao = menu.next().charAt(0);
            
            switch (opcao) {
                case 'a':
                    // Lógica para adicionar jogador
                    break;
                case 'r':
                    // Lógica para remover jogador
                    break;
                case 'j':
                    // Lógica para executar rodada
                    break;
                case 'm':
                    // Lógica para mostrar cartela
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
        Scanner menu = new Scanner (System.in );
        JogoGeneral jogo = new JogoGeneral();
        jogo.menu();
    }
}
                                
