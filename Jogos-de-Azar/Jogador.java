import java.io.Serializable;

public abstract class Jogador implements Serializable{

    private String nome;
    private String tipo;
    //private JogoGeneral General ;
    private JogoDados[] Jogo;
    private boolean[] valida;
    //private int pontos;
    private float saldoJogador;

    public Jogador(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
        //this.General = new JogoGeneral();
        this.Jogo = new JogoDados[10];
        this.valida = new boolean[13] ;
        //this.pontos = pontos;

    }
    public float getSaldoJogador()
    {
        return saldoJogador;
    }
    public void setSaldoJogador()
    {
        saldoJogador = 100F;
    }
    public void apostarValorX(float X, int n)
    {
        saldoJogador = saldoJogador - X;
        if(saldoJogador>=0F)
        {
            Jogo[n].setvalorDaAposta(X);
        }
        else
        {
            saldoJogador = saldoJogador + X;
            System.out.println("Valor invalido para a aposta !!!");
        }

    }
    public JogoDados incluirJogo(int n,int turno){
        switch (n) {
            case 1:
                this.Jogo[turno] = new JogoGeneral();
                //talvez isso esteja errado
                return Jogo[turno];
            case 2:
                this.Jogo[turno] = new JogoAzar();
                return Jogo[turno];
            default:
                return null;
        }
    }

    //chamar isso so quando tiver o resultado de vitoria ou derrota do jogo de azar ou general
    public float resultadoDaAposta(int n)
    {
        Jogo[n].apostar();
        return Jogo[n].getvalorDaAposta();
    }
    //Valida as Jogadas feitas pelo Jogador.
    public void validarJogada(int escolha,JogoGeneral General)
    {
        if (escolha >= 1 && escolha <= 6) {
            General.Jogada_de_n(escolha);
        } else if (escolha == 7) {
            General.Trinca();
        } else if (escolha == 8) {
            General.Quadra();
        } else if (escolha == 9) {
            General.FullHand();
        } else if (escolha == 10) {
            General.Sequencia_alta();
        } else if (escolha == 11) {
            General.Sequencia_baixa();
        } else if (escolha == 12) {
            General.General();
        } else if (escolha == 13) {
            General.Jogada_aleatoria();
        } else {
            System.out.println("Opcao invalida. Tente novamente");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void BooleanTrue (int i)
    {
        valida[i] = true;
    }
    public void BooleanFalse (int i)
    {
        valida[i] = false;
    }
    public void resetBoolean()
    {
        for(int i=0;i<13;i++)
            BooleanFalse(i);
    }
    public boolean verificaBoolean (int i)
    {
        return valida[i];
    }
    /*public void resetPontos(JogoGeneral General)
    {
        General.inicializaJogadas();
    }*/
    /*public int mostraPontosJogadaN (int N)
    {
        return General.retornaValor(N) ;
    }*/


    //Rola os dados e mostra os valores obtidos
    //ARRUMAR ISSO AQUI , TIPO O QUE ESSE X TA FAZENDO ?
    public void jogarDados( int x,int turno) {   
        System.out.println("turno="+(turno)+"   num="+5);
        System.out.println("Jogador " + nome + " jogou o dado e obteve: " );
        //JogoDados jogoAtual = (JogoDados) Jogo[turno];
        Jogo[turno].rolarDados(5);
        Jogo[turno].mostraValorDados(5);         
    }
    //Mostra as jogadas execultadas pelo jogador
    public void mostraJogadasExecutadas(JogoGeneral General) {
        System.out.println("\nJogadas executadas por " + nome + ": ");
        General.mostraJogadas();
    }

   /*  public int salvaPontos()
    {
        pontos = General.somaPontos();

        return pontos;
    }*/
}