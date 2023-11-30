import java.util.Random;

public class Maquina extends Jogador implements InterfaceJogarComoMaquina{
    private int opcao;

    public Maquina(String nome, String tipo){
        super (nome, tipo);
    }
    public void escolherJogo(){
        //opcao = Estrategia(2); //Verificar se isso funciona.. 
        opcao = 2;//isso e so para testar a maquina..
        if (opcao == 1 || opcao == 2){
            JogoDados jogo = incluirJogo(opcao);
            escolherJogada(jogo);
        }
        else{
            System.out.println("Opção inválida. Tente novamente.");
            opcao = -1;
        }
    }
    
    //mudei pra void
    public void escolherJogada(JogoDados jogo){
        int j=0;
        do {
            if (jogo instanceof JogoGeneral){
                int escolha;
                System.out.println("\nJogador " + getNome() + " (Humano)");
                jogarDados(5,j);
                System.out.print("\n>Para qual jogada deseja marcar: [1 - 13]\n1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S-) 11(S+) 12(G) 13(X)\n");
                do{
                    escolha = Estrategia(13);

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