import java.util.concurrent.TimeUnit;

public class JogoAzar extends JogoDados {
  
    private Dado[] dados;
    private int[] jogadas;
    
    public int retornaValor(int numeroDaJogada)
    {
        return jogadas[numeroDaJogada]; 
    }

    public void rolarDados(int n)
    {
        int i;
        for(i=0;i<n;i++)
        {   
            dados[i].roll();
        }
    }

    public void mostraValorDados(int n)
    {
        int i, aux;
        for(i=0;i<n;i++)
        {   
            aux =dados[i].getSideUp();
            System.out.print(aux);
            if(i!=(n-1))
            {
                System.out.print(" + ");
            }
        }
        System.out.println(" = "+somaDados(n));
        
    }
    public void mostraJogadas()
    {
        int i;
        for(i=0;i<13;i++)
        {   
            if(jogadas[i] == -1)
            {
                System.out.print("-");
            }
            else
            {
                System.out.print(jogadas[i]);
            }
            if(i!=12)
            {
                System.out.print(" ");
            }
        }
    }
    public int somaDados(int n)
    {
        int soma=0,i;
        for(i=0;i<n;i++)
        {
            soma += dados[i].getSideUp();
        }
        return soma;
    }

    public JogoAzar()
    {
        dados = new Dado[2];
        for (int i=0;i<2;i++)
        {
            dados[i]=new Dado();
        }
    }

    public boolean seteEonze()
    {
        boolean verdade=false;
        if(somaDados(2)==7 || somaDados(2)==11)
        {
            verdade=true;
        } 
        return verdade;
    }

    public boolean derrota()
    {
        boolean verdade=false;
        if(somaDados(2)==2 || somaDados(2)==3 || somaDados(2)==12)
        {
            verdade=true;
        } 
        return verdade;
    }

    //atualmente isso eh um "exe." e a funcao que devolve vitoria ou derrota, tenho que expandir pra ser a uma funcao que roda com pausa
    public void ExecutarJogo ()
    {
        boolean resultado=false;
        int dados=2,i=1, alvo=0;
        do
        {
            // o delay e pq eu achei estranho so brotar tudo de uma vez
            try {
                Thread.sleep((int) (110));
                
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
            System.out.println(i+"° lancamento");
            rolarDados(dados);
            mostraValorDados(dados);
            resultado=seteEonze();
            if(resultado==true&&alvo==0)
            {
                System.out.println("eba, vc venceu!");
                setVitoria(true);
                break;
            }
            resultado=derrota();
            if(resultado==true)
            {
                System.out.println("poxa, vc perdeu!");
                setVitoria(false);
                break;
            }
            if(somaDados(dados)==alvo)
            {
                System.out.println("eba, vc venceu!");
                setVitoria(true);
                break;
            }
            if(alvo==0)
            {
                alvo=somaDados(dados);
                System.out.println("Numero a ser buscado "+alvo);
            }
            i++;
        }while(i!=0);
        
    }
}