import java.util.Scanner;

public class Humano extends Jogador implements InterfaceJogarComoHumano {
    private String cpf;
    private String agencia;
    private String conta;
    private int numeroBanco;
    private int opcao;
    private JogoGeneral General;
    private JogoAzar Azar;

    public Humano (String cpf,String agencia,String conta,int numeroBanco){
        this.cpf = cpf;
        this.agencia = agencia;
        this.conta = conta;
        this.numeroBanco = numeroBanco;
        this.General = new JogoGeneral();
        this.Azar = new JogoAzar();
    }
    public String getCPF(){
        return cpf;
    }
    public String getAgencia(){
        return agencia;
    }
    public String getConta(){
        return conta;
    }
    public int getNumeroBanco(){
        return numeroBanco;
    }
    public void escolherJogo(){
        Scanner menu = new Scanner (System.in);
        
        do{
            System.out.println("            > Escolha um Jogo:");
            System.out.println("|--------------------------------------------------------------|");
            System.out.println("|(1) Jogo General                                              |");
            System.out.println("|(2) Jogo Azar                                                 |");
            System.out.println("|--------------------------------------------------------------|");
            System.out.print("Escolha uma opção: ");
            opcao = menu.nextInt();
            escolherJogada(opcao);

            if (opcao != 1 || opcao != 2)
                System.out.println("Opção inválida. Tente novamente.");

        }while (opcao != 1 || opcao != 2); 
            
    }
    public void escolherJogada(int opcao){
        do {
            switch (opcao){
                case 1:
                    int escolha;
                    System.out.println("\nJogador " + getNome() + " (Humano)");
                    //jogador.jogarDados();
                    System.out.print("\n>Para qual jogada deseja marcar: [1 - 13]\n1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S-) 11(S+) 12(G) 13(X)\n");
                    do{
                        Scanner decisao = new Scanner(System.in);
                        escolha = decisao.nextInt();

                        if (escolha == 1 || escolha == 2 || escolha == 3 || escolha == 4 || escolha == 5 || escolha == 6)
                            General.Jogada_de_n(escolha);
                        else if (escolha == 7)
                            General.Trinca();
                        else if (escolha == 8)
                            General.Quadra();
                        else if (escolha == 9)
                            General.FullHand();
                        else if (escolha == 10)
                            General.Sequencia_alta();
                        else if (escolha == 11)
                            General.Sequencia_baixa();  
                        else if (escolha == 12)
                            General.General();
                        else if (escolha == 13)
                            General.Jogada_aleatoria();
                        else
                            System.out.println("Opcao invalida. Tente novamente");

                    }while(verificaBoolean(escolha-1) == true);
                    BooleanTrue(escolha-1);
                    //mostraJogadasExecutadas();
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