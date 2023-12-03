import java.util.Random;

public class Maquina extends Jogador implements InterfaceJogarComoMaquina{
    private int opcao;
    private int turno;
    private int numeroJogos;

    public Maquina(String nome, String tipo){
        super (nome, tipo);
    }
    public void escolherJogo(){
        //opcao = Estrategia(2); //Verificar se isso funciona.. 
        opcao = 2;//isso e so para testar a maquina..
        if (opcao == 1 || opcao == 2){
            JogoDados jogo = incluirJogo(opcao,numeroJogos);
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
                int escolha;
                System.out.println("\nJogador " + getNome() + " (Humano)");
                jogarDados(5,turno);
                System.out.print("\n>Para qual jogada deseja marcar: [1 - 13]\n1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S-) 11(S+) 12(G) 13(X)\n");
                do{
                    escolha = Estrategia(13);
                    validarJogada(escolha, (JogoGeneral) jogo);
                }while(verificaBoolean(escolha-1) == true);
                BooleanTrue(escolha-1);
                mostraJogadasExecutadas((JogoGeneral) jogo);
            }
            else if (jogo instanceof JogoAzar){
                ((JogoAzar)jogo).ExecutarJogo();
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