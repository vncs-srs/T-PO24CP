public class JogoGeneral{
    private int Dado[] dados;
    private int[] jogadas;

    public jogoGeneral(int dados, int jogadas){
        dados = new Dado[5];
        jogadas = new int[13];

        for(int i = 0; i < 12;i++){
            jogadas[i] = -1;
        }
        public void rolarDados(int dados){
            for(int i = 0;0 < 5;i++){
                dados[i].roll();
                toString();
            }
        
        }
        //Regras
        //Jogadas de 1 2 3 4 5 6

        switch (expressão) {

        case '1':

       

        break;

        case '2':

        

        break;

        case '3':

        

        break;        
        
        case '4':

        

        break;
        case '5':

        

        break;

        default:


}
        /*public jogada1(){
            
        }
        public jogada2(){

        }        
        public jogada3(){

        }        
        public jogada4(){

        }
        public jogada5(){

        } 
        public jogada6(){

        }
        public trinca(){

        }
        public quadra(){

        }
        public fullHand(){

        }
        public sequenciaAlta(){

        }
        public sequenciaBaixa(){

        }
        public general(){

        }
        public jogadaAleatoria(){

        }*/
        
    }

}