import java.util.Random;

public class Maquina extends Jogador implements InterfaceJogarComoMaquina{
    private int opcao;
    private JogoGeneral General;
    private JogoAzar Azar;
    public Maquina(String nome, String tipo){
        super (nome, tipo);
        this.General = new JogoGeneral();
        this.Azar = new JogoAzar();
    }
    public void escolherJogo(){
        opcao = Estrategia(2); //Verificar se isso funciona.. 
    }
    
    //mudei pra void
    public void escolherJogada(int opcao){
        do {
            switch (opcao){
                case 1:
                    int escolha;
                    System.out.println("\nJogador " + getNome() + " (Humano)");
                    System.out.print("\n>Para qual jogada deseja marcar: [1 - 13]\n1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S-) 11(S+) 12(G) 13(X)\n");
                    do{
                        escolha = Estrategia(13);
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
                    Azar.Vitoria(); // Verificar se funciona
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 1 || opcao != 2);        
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