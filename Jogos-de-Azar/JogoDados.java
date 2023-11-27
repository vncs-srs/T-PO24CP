import java.io.Serializable;

public abstract class JogoDados implements Serializable, Estatistica{
    
    private Dado[] dados;
    private int[] jogadas;
    private float saldo; 
    private int [] Faces;
    private boolean vitoria;

    public JogoDados()
    {
        this.Faces = new int[numFaces];
        //this.jogadas = new int[10];
        //this.vitoria = false;
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
            Faces[dados[i].getSideUp()] += 1;
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
        somarFacesSorteadas(n);
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
    public void apostar(float valorApostado)
    {
        if ((saldo != 0)&&(valorApostado<=saldo))
        {
            if (vitoria==true) 
            {
                saldo=saldo+valorApostado;
            }
            else
            {
                saldo = saldo- valorApostado;
            }
        }
        else
        {
            System.out.println("Quantia de dinheiro invalida para aposta.");
        }
    }

    public float getSaldo()
    {
        return saldo;
    }
    public void setSaldo()
    {
        saldo=100.00F;
    }
}