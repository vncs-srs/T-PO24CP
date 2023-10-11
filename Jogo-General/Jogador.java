import java.io.Serializable;

public class Jogador implements Serializable{

    private String nome;
    private String tipo;
    private JogoGeneral General ;
    public boolean[] valida;

    public Jogador(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.General = new JogoGeneral();
        this.valida = new boolean[13] ;
    }
    //Valida as Jogadas feitas pelo Jogador.
    public void validarJogada(int escolha)
    {
        switch (escolha){
            case 1:
                General.Jogada_de_1();
                break;
            case 2:
                General.Jogada_de_2();
                break;
            case 3:
                General.Jogada_de_3();
                break;
            case 4:
                General.Jogada_de_4();
                break;
            case 5:
                General.Jogada_de_5();
                break;
            case 6:
                General.Jogada_de_6();
                break;
            case 7:
                General.Trinca();
                break;
            case 8:
                General.Quadra();
                break;
            case 9:
                General.FullHand();
                break;
            case 10:
                General.Sequencia_alta();
                break;
            case 11:
                General.Sequencia_baixa();
                break;
            case 12:
                General.General();
                break;
            case 13:
                General.Jogada_aleatoria();
                break;
            default:
                System.out.println("Opcao invalida. Tente novamente");
                break;
        }
        
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    //Rola os dados e mostra os valores obtidos
    public void jogarDados() { 
        General.rolarDados();
        System.out.println("Jogador " + nome + " jogou o dado e obteve: " );
        General.mostraValorDados();
    }
    //Mostra as jogadas execultadas pelo jogador
    public void mostraJogadasExecutadas() {
        System.out.println("\nJogadas executadas por " + nome + ": ");
        General.mostraJogadas();
    }
}