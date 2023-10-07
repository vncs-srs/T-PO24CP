import java.util.Scanner;

public class usaCampeonato {

    public void menu() {
        private Scanner scanner;
        char opcao;
        do {
            System.out.println("       _                      _____                           _ ");
            System.out.println("      | |                    / ____|                         | |");
            System.out.println("      | | ___   __ _  ___   | |  __  ___ _ __   ___ _ __ __ _| |");
            System.out.println("  _   | |/ _ \\ / _` |/ _ \\  | | |_ |/ _ \\ '_ \\ / _ \\ '__/ _` | |");
            System.out.println(" | |__| | (_) | (_| | (_) | | |__| |  __/ | | |  __/ | | (_| | |");
            System.out.println("  \\____/ \\___/ \\__, |\\___/   \\_____|\\___|_| |_|\\___|_|  \\__,_|_|");
            System.out.println("                __/ |                                           ");
            System.out.println("               |___/                                            ");
            System.out.println("|------------------------------------------------|");
            System.out.println("| a) Adicionar jogador                           |");
            System.out.println("| r) Remover jogador                             |");
            System.out.println("| j) Jogar rodada                                |");
            System.out.println("| m) Mostrar cartela                             |");
            System.out.println("| s) Sair                                        |");
            System.out.println("|------------------------------------------------|");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.next().charAt(0);
            
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
        } while (opcao != 's');
    }

    public static void main(String[] args) {
        JogoGeneral jogo = new JogoGeneral();
        jogo.menu();
    }
}
                                
