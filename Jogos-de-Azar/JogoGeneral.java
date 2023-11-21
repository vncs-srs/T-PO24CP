public class JogoGeneral extends JogoDados{

    private Dado[] dados;
    private int[] jogadas;
    
    public void inicializaJogadas()
    {
        int i;
        //inicializa jogadas com -1
        for(i=0;i<13;i++){
           
            jogadas[i]= -1;
        }
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
    public JogoGeneral()
    {
        dados = new Dado[5];
        jogadas = new int [13];
        inicializaJogadas();
        for (int i=0;i<5;i++)
        {
            dados[i]=new Dado();
        }
    }
    //Jogada de 1: um certo n ́umero de dados (de 0 a 5) marcando o numero 1.
    public void Jogada_de_1 ()
    {
        int i, pontos=0;
        if( jogadas[0] == -1)
        {
            for(i=0;i<5;i++)
            { 
                if(dados[i].getSideUp() == 1)
                {
                    pontos = pontos +1;
                }
            }
            if (pontos>0)
                jogadas[0]= pontos;
        
            else
            {
                jogadas[0] = 0;
                System.out.println("Seus valores nao sao validos pra a jogada, pontucao = 0");
            }
        }
    }
    public void Jogada_de_n (int n)
    {
        int i, pontos=0;
        if( jogadas[n-1] == -1)
        {
            for(i=0;i<5;i++)
            { 
                if(dados[i].getSideUp() == n)
                {
                    pontos = pontos + n;
                }
            }
            if (pontos>0)
                jogadas[n-1]= pontos;
        
            else
            {
                jogadas[n-1] = 0;
                System.out.println("Seus valores nao sao validos pra a jogada, pontucao = 0");
            }
        }
    }
    //Jogadas de 2, 3, 4, 5 e 6: correspondentes a jogada de 1 para os demais numeros.
    public void Jogada_de_2 ()
    {
        int i, pontos=0;
        if( jogadas[1] == -1)
        {
            for(i=0;i<5;i++)
            { 
                if(dados[i].getSideUp() == 2)
                {
                    pontos = pontos +2;
                }
            }
            if (pontos>0)
                jogadas[1]= pontos;
        
            else
            {
                jogadas[1] = 0;
                System.out.println("Seus valores nao sao validos pra a jogada, pontucao = 0");
            }
        }
    }
    public void Jogada_de_3 ()
    {
        int i, pontos=0;
        if( jogadas[2] == -1)
        {
            for(i=0;i<5;i++)
            { 
                if(dados[i].getSideUp() == 3)
                {
                    pontos = pontos +3;
                }
            }
            if (pontos>0)
                jogadas[2]= pontos;
        
            else
            {
                jogadas[2] = 0;
                System.out.println("Seus valores nao sao validos pra a jogada, pontucao = 0");
            }
        }
    }
    public void Jogada_de_4 ()
    {
       int i, pontos=0;
        if( jogadas[3] == -1)
        {
            for(i=0;i<5;i++)
            { 
                if(dados[i].getSideUp() == 4)
                {
                    pontos = pontos +4;
                }
            }
            if (pontos>0)
                jogadas[3]= pontos;
        
            else
            {
                jogadas[3] = 0;
                System.out.println("Seus valores nao sao validos pra a jogada, pontucao = 0");
            }
        }
    }
    public void Jogada_de_5 ()
    {
       int i, pontos=0;
        if( jogadas[4] == -1)
        {
            for(i=0;i<5;i++)
            { 
                if(dados[i].getSideUp() == 5)
                {
                    pontos = pontos +5;
                }
            }
            if (pontos>0)
                jogadas[4]= pontos;
        
            else
            {
                jogadas[4] = 0;
                System.out.println("Seus valores nao sao validos pra a jogada, pontucao = 0");
            }
        }
    }
    public void Jogada_de_6 ()
    {
        int i, pontos=0;
        if( jogadas[5] == -1)
        {
            for(i=0;i<5;i++)
            { 
                if(dados[i].getSideUp() == 6)
                {
                    pontos = pontos +6;
                }
            }
            if (pontos>0)
                jogadas[5]= pontos;
        
            else
            {
                jogadas[5] = 0;
                System.out.println("Seus valores nao sao validos pra a jogada, pontucao = 0");
            }
        }
    }
    public void Trinca()
    {
        int i,j, pontos=0, acumulador=0;
        if( jogadas[6] == -1)
        {
            for(i=0;i<5;i++)
            {
                for(j=i+1;j<5;j++)
                { 
                    if(dados[i].getSideUp() == dados[j].getSideUp())
                    {
                        acumulador= acumulador+1;
                    }
                } 
            }
            if (acumulador>=3)
            {
                for(i=0;i<5;i++)
                {
                    pontos = pontos +dados[i].getSideUp();
                }
                jogadas[6]= pontos;
            }
            else
            {
                jogadas[6] = 0;
                System.out.println("Seus valores nao sao validos pra a jogada, pontucao = 0");
            }
        }
    } 
    public void  Quadra()
    {
        int i,j, pontos=0, acumulador=0;
        if( jogadas[7] == -1)
        {
            for(i=0;i<5;i++)
            {
                for(j=i+1;j<5;j++)
                { 
                    if(dados[i].getSideUp() == dados[j].getSideUp())
                    {
                        acumulador= acumulador+1;
                    }
                } 
            }
            if (acumulador>=4)
            {
                for(i=0;i<5;i++)
                {
                    pontos = pontos+ dados[i].getSideUp();
                }
                jogadas[7]= pontos;
            }
            else
            {
                jogadas[7] = 0;
                System.out.println("Seus valores nao sao validos pra a jogada, pontucao = 0");
            }
        }
    } 
    public void FullHand()
    {
        int i,contaTrio=0, numerosDeValoresDistintos=1;
        boolean ehDistinto;
        

        if( jogadas[8] == -1)
        {
            numerosDeValoresDistintos = 0;
            for (i = 0; i < 5; i++) 
            {
                ehDistinto = true;

                for (int j = 0; j < i; j++) 
                {
                    
                    if (dados[i].getSideUp() ==dados[j].getSideUp()) 
                    {
                        contaTrio++;
                        ehDistinto = false;
                    }
                }

                if (ehDistinto) 
                {
                    numerosDeValoresDistintos++;
                }
            }

            if ((numerosDeValoresDistintos<=2)&&(contaTrio!=6))
            {
                jogadas[8]= 25;
                 
            }
            else
            {
                jogadas[8] = 0;
                System.out.println("Seus valores nao sao validos pra a jogada, pontucao = 0");
            }
        }
    }
   
    public void Sequencia_alta()
    {
        int i,aux;
        boolean dois=false, tres=false, quatro=false, cinco=false, seis=false;
        if( jogadas[9] == -1)
        {
            for(i=0;i<5;i++)
            {
               aux= dados[i].getSideUp();
               
               switch(aux)
               {
                    case 2:
                        dois=true;
                        break;
                    case 3:
                        tres=true;
                        break;
                    case 4:
                        quatro=true;
                        break;
                    case 5:
                        cinco=true;
                        break;
                    case 6:
                        seis=true;
                        break;
                    default:
                        break;
               }
            }
            if((dois==true) && (tres==true)&&(quatro==true) && (cinco==true)&&(seis==true))
            {
                jogadas[9] = 30;
            }
            else
            {
                jogadas[9] = 0;
                System.out.println("Seus valores nao sao validos pra a jogada, pontucao = 0");
            }
        }
    }
    public void Sequencia_baixa()
    {
        int i,aux;
        boolean um=false, dois=false, tres=false, quatro=false, cinco=false;
        if( jogadas[10] == -1)
        {
            for(i=0;i<5;i++)
            {
               aux= dados[i].getSideUp();
               
               switch(aux)
               {
                    case 1:
                        um = true;
                        break;
                    case 2:
                        dois=true;
                        break;
                    case 3:
                        tres=true;
                        break;
                    case 4:
                        quatro=true;
                        break;
                    case 5:
                        cinco=true;
                        break;
                    default:
                        break;
               }
            }
            if((um==true)&&(dois==true) && (tres==true)&&(quatro==true) && (cinco==true))
            {
                jogadas[10] = 40;
            }
            else
            {
                jogadas[10] = 0;
                System.out.println("Seus valores nao sao validos pra a jogada, pontucao = 0");
            }
        }
    }
    public void General ()
    {
        int i, acumulador=0;
        boolean valido = true;
        if( jogadas[11] == -1)
        {
            acumulador= dados[0].getSideUp();
            for(i=0;i<5;i++)
            {
                if (dados[i].getSideUp() != acumulador)
                {
                    valido = false;
                }
            }
            if ( valido == true)
            {
                jogadas[11] = 50;
            }
            else
            {
                jogadas[11] = 0;
                System.out.println("Seus valores nao sao validos pra a jogada, pontucao = 0");
            }
        }
    } 
 
    public void Jogada_aleatoria()
    {
        int i, pontos=0;
        
        if( jogadas[12] == -1)
        {
           for(i=0;i<5;i++)
           {
                pontos = pontos + dados[i].getSideUp();
           }
           jogadas[12] = pontos;
        }
    }
    public int somaPontos()
    {
        int i ,resultados=0;
        for(i=0;i<13;i++)
        {
            if(jogadas[i]!=-1)
            { 
                resultados = resultados + jogadas[i];
            }
        }
        return resultados;
    }
    public boolean Vitoria ()
    {
        //lembrando que isso so pode ser usado no final;
        boolean vitoria=false;
        int pontos, alvo;
        pontos=somaPontos();
        pontos= pontos - jogadas[12];
        alvo= jogadas[12] * 2;
        if(pontos>alvo)
        {
            vitoria=true;
        }

        return vitoria;
    }
}