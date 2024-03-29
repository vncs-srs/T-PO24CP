import java.io.Serializable;

public abstract class JogoDados implements Serializable, Estatistica{
    
    private Dado[] dados;
    private int[] jogadas;
    private float valorDaAposta; 
    private int [] Faces;
    private boolean vitoria;
    private float saldoTemporario;

    public JogoDados()
    {
        this.Faces = new int[numFaces];
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
        int i;
        for(i=0;i<n;i++)
        {   
            Faces[dados[i].getSideUp()-1] = Faces[dados[i].getSideUp()-1] + 1;
        }
        
    }
    public void printarFacesSorteadas()
    {
        for(int i=0;i<6;i++)
        {
            System.out.print("\nFace: "+(i+1)+"   foi sorteada: "+Faces[i]);
        }
        
    }
    public void rolarDados(int n)
    {
        int i;
        for(i=0;i<n;i++)
        {   
            dados[i].roll();
        }
        somarFacesSorteadas(n);
    }

    public void mostraValorDados(int n)
    {
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

    public void apostar()
    {
        if ((valorDaAposta != 0))
        {
            saldoTemporario=0;
            if (vitoria==true) 
            {
                saldoTemporario = valorDaAposta;
                System.out.println("teste saldo temporairo: "+saldoTemporario);
                valorDaAposta=valorDaAposta+valorDaAposta;
                
            }
            else
            {
                saldoTemporario = saldoTemporario - valorDaAposta;
                System.out.println("teste saldo temporairo: "+saldoTemporario);
                valorDaAposta = 0F;
            }
        }
        else
        {
            System.out.println("Quantia de dinheiro invalida para aposta.");
        }
    }
    public float getSaldoTemporario()
    {
        return saldoTemporario;
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