import java.util.Random;

public class Maquina extends Jogador implements InterfaceJogarComoMaquina{
    private int opcao;
    private int numeroJogos;
    private float valorDaAposta;

    public Maquina(String nome, String tipo){
        super (nome, tipo);
    }
    public void escolherValorDaAposta(){
        //Scanner menu = new Scanner (System.in);
        
        do{
            if(getSaldoJogador()==0)
            {
                System.out.println("Voce esta sem dinheiro");
                break;
            }
            else if(getTurno()==10){
                System.out.println("Voce ja jogou 10 turnos");
                break;
            }
           
            System.out.println("|--------------------------------------------------------------|");
            System.out.println("|Seu saldo e: "+ getSaldoJogador()+"                                            |");
            System.out.println("|--------------------------------------------------------------|");
            //System.out.print("Quanto deseja apostar ?  ");
            opcao = 25;
            
            valorDaAposta = (float)opcao;

        }while (opcao == -1);
        if(getSaldoJogador()!=0 &&getTurno()!=10) 
        escolherJogo();
    }
    public void escolherJogo(){
        opcao = Estrategia(2); //Verificar se isso funciona.. 
        if (opcao == 1 || opcao == 2){
            JogoDados jogo = incluirJogo(opcao);
            escolherJogada(jogo);
            numeroJogos++;
        }
        else{
            System.out.println("Opção inválida. Tente novamente.");
            opcao = -1;
        }
    }
    
    public void escolherJogada(JogoDados jogo){
        do {
            if (jogo instanceof JogoGeneral){
                int aux=0;
                do{
                    int escolha;
                    System.out.println("\nJogador " + getNome() + " (Humano)");
                    jogarDados();
                    System.out.print("\n>Para qual jogada deseja marcar: [1 - 13]\n1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S-) 11(S+) 12(G) 13(X)\n");
                    do{
                        escolha = Estrategia(13);
                        validarJogada(escolha, (JogoGeneral) jogo);
                    }while(verificaBoolean(escolha-1) == true);
                    BooleanTrue(escolha-1);
                    
                    mostraJogadasExecutadas((JogoGeneral) jogo);
                    aux++;
                }while(aux !=13);
                apostarValorX(valorDaAposta,getTurno());
                passaTurno();
                resetBoolean();
                ((JogoGeneral) jogo).Vencer();
                jogo.getVitoria();
                jogo.apostar();
                valorDaAposta=jogo.getvalorDaAposta();
                somaSaldoJogador(valorDaAposta);
                if(valorDaAposta!=0F)
                {
                    System.out.println("\neba, vc venceu!");
                }
                else
                {
                    System.out.println("\npoxa, vc perdeu!");
                }
                System.out.println("\nSeu saldo atual e: "+getSaldoJogador());
            }
            else if (jogo instanceof JogoAzar){
                ((JogoAzar)jogo).ExecutarJogo();
                apostarValorX(valorDaAposta,getTurno());
                passaTurno();
                jogo.apostar();
                valorDaAposta=jogo.getvalorDaAposta();
                somaSaldoJogador(valorDaAposta);
                System.out.println("\nSeu saldo atual e: "+getSaldoJogador());
            }
            else{
                System.out.println("Opção inválida. Tente novamente.");
                opcao = -1;
            }

        } while (opcao == -1);        
    }
    public int Estrategia(int n){// n e o numero maximo de jogadas
        int min = 1;
        int max = n;
        int quantidadeNumeros = max - min + 1;
        
        boolean[] numerosGerados = new boolean[quantidadeNumeros];
        Random random = new Random();
        
        int numerosRestantes = quantidadeNumeros;

        while (numerosRestantes > 0) {
            int numeroAleatorio = random.nextInt(quantidadeNumeros);

            if (!numerosGerados[numeroAleatorio]) {
                numerosGerados[numeroAleatorio] = true;
                numerosRestantes--;
                return numeroAleatorio+1;
            }
        }
        return 0;
    }
}