import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner teclado;
        teclado = new Scanner(System.in);     

        //declaramos e já inicializamos as 
        //variaveis com 400 posicoes vazias
        String nomes[] = new String[400];
        int numeroDeps[] = new int[400];
        float salarios[] = new float[400];
        
        //variavel utilizada para armazenar a ultima 
        //posicao preenchida do vetor
        int ultimaPosicaoGravada = 0 ;
        
        //variavel para guardar a resposta do 
        //usuario se ele deseja digitar os dados
        //de um novo habitante
        char resposta; 

        //leitura dos habitantes e gravacao na memoria (vetores)
        for (int posicaoVetor = 0; posicaoVetor < 400; posicaoVetor++) {
    
            nomes = lerNome(teclado, nomes, posicaoVetor);
            salarios = lerSalario(teclado, salarios, posicaoVetor);
            numeroDeps = lerDependentes(teclado, numeroDeps, posicaoVetor);

            System.out.print("\nDeseja entrar com dados do próximo habitante [s/n]: ");
            resposta = teclado.nextLine().toLowerCase().charAt(0);
            
            if (resposta == 'n'){
                ultimaPosicaoGravada = posicaoVetor;               
                break;
            }
        }

        imprimirDados(nomes, salarios, numeroDeps, ultimaPosicaoGravada);

        teclado.close();
    }

    static void imprimirDados(String nomes[], float salarios[], int numeroDeps[], int ultimaPosicaoGravada){
        //acessando os dados para imprimir na tela
        int qtdeEspacos;
        System.out.println("\nNome                Salario                QtdeDependentes");
        System.out.println("----------------------------------------------------------");
        
        for (int posicaoVetor = 0; posicaoVetor <= ultimaPosicaoGravada; posicaoVetor++) {
            //imprime o nome do habitante
            System.out.print(nomes[posicaoVetor]);
            
            //calcula quantos espacos sao necessarios para alinhar
            //o valor do salario na posicao da coluna salario
            qtdeEspacos = (20 - nomes[posicaoVetor].length());
            //imprime a quantidade de espacos para alinhar os salarios
            System.out.print(geraEspacos(qtdeEspacos));

            //imprime o salario
            System.out.print("R$ " + salarios[posicaoVetor]);
            //calcula quantos espacos sao necessarios para alinhar
            //a quantidade de dependentes
            qtdeEspacos = (20 - Float.toString(salarios[posicaoVetor]).length());
            //imprime os espacos
            System.out.print(geraEspacos(qtdeEspacos));

            //imprime a quantidade de dependentes
            System.out.println(numeroDeps[posicaoVetor]);
        }
    }

    static String geraEspacos(int qtde){
        String espacos = "";

        for (int i = 0; i < qtde; i++) {
            espacos += " ";
        }

        return espacos;
    }

    static String[] lerNome(Scanner teclado, String nomes[], int posicaoLivre){
        System.out.print("Digite o nome do habitante: ");
        nomes[posicaoLivre] = teclado.nextLine(); 
        return nomes;
    }

    static float[] lerSalario(Scanner teclado, float salarios[], int posicaoLivre){
        System.out.print("Digite o salario R$: ");
        salarios[posicaoLivre] = teclado.nextFloat(); 
        
        //resolve o problema da limpeza do buffer
        teclado.nextLine();

        return salarios;
    }

    static int[] lerDependentes(Scanner teclado, int numeroDeps[], int posicaoLivre){
        System.out.print("Digite a quantidade de dependentes: ");
        numeroDeps[posicaoLivre] = teclado.nextInt(); 

        //resolve o problema da limpeza do buffer
        teclado.nextLine();
        
        return numeroDeps;
    }
     
}