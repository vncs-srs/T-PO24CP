import java.util.Scanner;

public class Humano extends Jogador implements InterfaceJogarComoHumano {
    private String cpf;
    private String agencia;
    private String conta;
    private int numeroBanco;
    private int opcao;
    private String menu;
    private JogoGeneral General;

    public void(String cpf,String agencia,String conta,int numeroBanco){
        this.cpf = cpf;
        this.agencia = agencia;
        this.conta = conta;
        this.numeroBanco = numeroBanco;
        //this.General = new JogoGeneral();
    }
    public escolherJogo(){

        Scanner menu = new Scanner (System.in);

        System.out.println("            > Escolha um Jogo:");
        System.out.println("|--------------------------------------------------------------|");
        System.out.println("|(1) Jogo General                                              |");
        System.out.println("|(2) Jogo Azar                                                 |");
        System.out.println("|--------------------------------------------------------------|");
        System.out.print("Escolha uma opção: ");
        opcao = menu.next().int(0);
        escolherJogada(opcao);
    }
    public escolherJogada(int opcao){
        do {
            swich (opcao){
                case 1:

                    break;
                case 2:
                    
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 1 || opcao != 2);        
    }
}