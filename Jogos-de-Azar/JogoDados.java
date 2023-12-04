import java.io.Serializable;

public abstract class JogoDados implements Serializable, Estatistica{
    
    private Dado[] dados;
    private int[] jogadas;
    private float valorDaAposta; 
    private int [] Faces;
    private boolean vitoria;

    public JogoDados()
    {
        this.Faces = new int[numFaces];
        //this.jogadas = new int[10];
        //this.vitoria = false;
        dados = new Dado[5];
        for (int i=0;i<5;i++)
        {
            dados[i]=new Dado();
        }
    }

    public int retornaValor(int numeroDaJogada)
    {
        return jogadas[numeroDaJogada]; 
    }

    public void somarFacesSorteadas(int n)
    {
        //n=5(general)  n=2(azar)
        int i;
        for(i=0;i<n;i++)
        {   
            Faces[dados[i].getSideUp()] = Faces[dados[i].getSideUp()] + 1;
        }
        
    }
    public void rolarDados(int n)
    {
        //n=5(general)  n=2(azar)
        int i;
        for(i=0;i<n;i++)
        {   
            dados[i].roll();
        }
        //se descomentar a linha de baixo o codigo quebra*************************
        //somarFacesSorteadas(n);
    }

    public void mostraValorDados(int n)
    {
        //n=5(general)  n=2(azar)
        int i;
        for(i=0;i<n;i++)
        {   
            System.out.print(dados[i].getSideUp());
            if(i!=4)
            {
                System.out.print(" ");
            }
        }
    }

    public void setVitoria(boolean m)
    {
        vitoria = m;
    }

    public boolean getVitoria()
    {
        return vitoria;
    }

    //tem que sair daqui e ir pra jogador???
    public void apostar()
    {
        if ((valorDaAposta != 0))
        {
            if (vitoria==true) 
            {
                valorDaAposta=valorDaAposta+valorDaAposta;
            }
            else
            {
                valorDaAposta = 0F;
            }
        }
        else
        {
            System.out.println("Quantia de dinheiro invalida para aposta.");
        }
    }

    public float getvalorDaAposta()
    {
        return valorDaAposta;
    }
    public void setvalorDaAposta(float dinheiro)
    {
        valorDaAposta=dinheiro;
    }
}