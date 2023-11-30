public class JogoAzar extends JogoDados {
  
    private Dado[] dados;
    private int[] jogadas;
    //private boolean vitoria;
    
    public int retornaValor(int numeroDaJogada)
    {
        return jogadas[numeroDaJogada]; 
    }

    public void rolarDados(int n)
    {
        //n=5(general)  n=2(azar)
        int i;
        for(i=0;i<n;i++)
        {   
            dados[i].roll();
        }
    }

    public void mostraValorDados(int n)
    {
        //n=5(general)  n=2(azar)
        int i;
        for(i=0;i<n;i++)
        {   
            System.out.print(dados[i].getSideUp());
            if(i!=(n-1))
            {
                System.out.print(" + ");
            }
        }
        System.out.println(" = "+somaDados(n));
        
    }

    //essa tem que adaptar de forma diferente
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
            System.out.println(i+"° lancamento");
            rolarDados(dados);
            mostraValorDados(dados);
            resultado=seteEonze();
            if(resultado==true&&alvo==0)
            {
                System.out.println("eba, vc venceu!");
                break;
            }
            resultado=derrota();
            if(resultado==true)
            {
                System.out.println("poxa, vc perdeu!");
                break;
            }
            if(somaDados(dados)==alvo)
            {
                System.out.println("eba, vc venceu!");
                break;
            }
            else
            {
                //System.out.println("tente novamente.");   
            }
            if(alvo==0)
            {
                alvo=somaDados(dados);
                System.out.println("Numero a ser buscado "+alvo);
            }
            i++;
        }while(i!=0);
        setVitoria(resultado);
    }
}