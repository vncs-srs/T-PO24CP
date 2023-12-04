import java.util.Scanner;

public class Humano extends Jogador implements InterfaceJogarComoHumano {
    private String cpf;
    private String agencia;
    private String conta;
    private int numeroBanco;
    private int opcao;
    private int numeroJogos;

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
    //fazer um menu 'acima' desse ou expandir esse
    public void escolherValorDaAposta(){
        Scanner menu = new Scanner (System.in);
        
        do{
            System.out.println("            > Escolha um Jogo:");
            System.out.println("|--------------------------------------------------------------|");
            System.out.println("|Seu saldo e:"+ getSaldoJogador()+"                            |");
            //System.out.println("|Quanto deseja apostar ?                                       |");
            System.out.println("|--------------------------------------------------------------|");
            System.out.print("Quanto deseja apostar ?  ");
            opcao = menu.nextInt();
            apostarValorX((float)opcao,getTurno());

        }while (opcao == -1);
        if(getSaldoJogador()!=0) 
        escolherJogo();
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
                numeroJogos++;
            }
            else{
                System.out.println("Opção inválida. Tente novamente.");
                opcao = -1;
            }

        }while (opcao == -1); 
            
    }
    public void escolherJogada(JogoDados jogo){
                do {
            if (jogo instanceof JogoGeneral){
                int aux=0;
                do{
                //aux=getTurno();
                int escolha;
                System.out.println("\nJogador " + getNome() + " (Humano)");
                jogarDados();
                System.out.print("\n>Para qual jogada deseja marcar: [1 - 13]\n1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S-) 11(S+) 12(G) 13(X)\n");
                do{
                    Scanner decisao = new Scanner(System.in);
                    escolha = decisao.nextInt();
                    validarJogada(escolha, (JogoGeneral) jogo);

                }while(verificaBoolean(escolha-1) == true);
                BooleanTrue(escolha-1);
                
                mostraJogadasExecutadas((JogoGeneral) jogo);
                aux++;
            }while(aux !=13);
            passaTurno();
            resetBoolean();
            ((JogoGeneral) jogo).Vencer();
            jogo.getVitoria();
            jogo.apostar();
            }
            else if (jogo instanceof JogoAzar){
                ((JogoAzar)jogo).ExecutarJogo();
                passaTurno();
                jogo.getVitoria();
                jogo.apostar();
            }
            else{
                System.out.println("Opção inválida. Tente novamente.");
                opcao = -1;
            }

                    } while (opcao == -1);        
    }
}