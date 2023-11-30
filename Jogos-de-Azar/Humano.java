import java.util.Scanner;

public class Humano extends Jogador implements InterfaceJogarComoHumano {
    private String cpf;
    private String agencia;
    private String conta;
    private int numeroBanco;
    private int opcao;

    public Humano (String nome, String tipo,String cpf,String agencia,String conta,int numeroBanco){
        super (nome, tipo);
        this.cpf = cpf;
        this.agencia = agencia;
        this.conta = conta;
        this.numeroBanco = numeroBanco;
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
    public JogoDados getTipoJogo(int opcao){
        return incluirJogo(opcao);
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

            if (opcao == 1 || opcao == 2){
                JogoDados jogo = incluirJogo(opcao);
                escolherJogada(jogo);
            }
            else{
                System.out.println("Opção inválida. Tente novamente.");
                opcao = -1;
            }

        }while (opcao == -1); 
            
    }
    public void escolherJogada(JogoDados jogo){
        int j=0;
        do {
            if (jogo instanceof JogoGeneral){
                int escolha;
                System.out.println("\nJogador " + getNome() + " (Humano)");
                jogarDados(5,j);
                System.out.print("\n>Para qual jogada deseja marcar: [1 - 13]\n1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S-) 11(S+) 12(G) 13(X)\n");
                do{
                    Scanner decisao = new Scanner(System.in);
                    escolha = decisao.nextInt();

                    if (escolha == 1 || escolha == 2 || escolha == 3 || escolha == 4 || escolha == 5 || escolha == 6)
                        ((JogoGeneral)jogo).Jogada_de_n(escolha);
                    else if (escolha == 7)
                        ((JogoGeneral)jogo).Trinca();
                    else if (escolha == 8)
                        ((JogoGeneral)jogo).Quadra();
                    else if (escolha == 9)
                        ((JogoGeneral)jogo).FullHand();
                    else if (escolha == 10)
                        ((JogoGeneral)jogo).Sequencia_alta();
                    else if (escolha == 11)
                        ((JogoGeneral)jogo).Sequencia_baixa();  
                    else if (escolha == 12)
                        ((JogoGeneral)jogo).General();
                    else if (escolha == 13)
                        ((JogoGeneral)jogo).Jogada_aleatoria();
                    else
                        System.out.println("Opcao invalida. Tente novamente");

                }while(verificaBoolean(escolha-1) == true);
                BooleanTrue(escolha-1);
                //mostraJogadasExecutadas();
            }
            else if (jogo instanceof JogoAzar){
                ((JogoAzar)jogo).ExecutarJogo();
            }
            else{
                System.out.println("Opção inválida. Tente novamente.");
                opcao = -1;
            }

            j++;
        } while (opcao == -1);        
    }
}