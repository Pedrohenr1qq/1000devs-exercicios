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

        System.out.println();

        mostrarMediaSalarios(mediaSalarios(salarios, ultimaPosicaoGravada));

        float mediaDependentes = calcularMediaDependentes(numeroDeps, ultimaPosicaoGravada);
        mostrarMediaDependentes(mediaDependentes);
        System.out.println();

        int indiceMenorQuantidadeDependentes = obterIndiceMenorQuantidadeDependentes(numeroDeps, ultimaPosicaoGravada);
        mostrarMenorQuantidadeDependentes(indiceMenorQuantidadeDependentes, nomes, numeroDeps);
        System.out.println();

        int indiceMaiorSalario = obterIndiceMaiorSalario(salarios, ultimaPosicaoGravada);
        mostrarMaiorSalario(indiceMaiorSalario, nomes, salarios);
        System.out.println();

        mostrarDependentesAbaixoMedia(mediaDependentes, nomes, numeroDeps, ultimaPosicaoGravada);
        System.out.println();

        teclado.close();
    }

    static void imprimirDados(String nomes[], float salarios[], int numeroDeps[], int ultimaPosicaoGravada){
        //acessando os dados para imprimir na tela
        int qtdeEspacos;
        String nomePadronizado = "";
        System.out.println("\nNome                Salario                QtdeDependentes");
        System.out.println("----------------------------------------------------------");
        
        for (int posicaoVetor = 0; posicaoVetor <= ultimaPosicaoGravada; posicaoVetor++) {
            //imprime o nome do habitante
            if(nomes[posicaoVetor].length() > 19){
                nomePadronizado = nomes[posicaoVetor].substring(0, 16) + "...";
            }
            else nomePadronizado = nomes[posicaoVetor];

            System.out.print(nomePadronizado);
            
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

    static float mediaSalarios(float[] salarios, int ultimaPosicaoGravada){
        float soma = 0, media = 0;
        for(float salario: salarios){
            soma += salario; 
        }

        media = soma/(ultimaPosicaoGravada+1);

        return media;
    }

    static void mostrarMediaSalarios(float mediaSalarios){
        System.out.printf("Média dos salários: R$%.2f%n", mediaSalarios);
    }

    static float calcularMediaDependentes(int[] numeroDeps, int ultimaPosicaoGravada){
        int soma = 0;
        float media = 0;
        for(int dependentes: numeroDeps){
            soma += dependentes; 
        }

        media = (float) soma / (float) (ultimaPosicaoGravada+1);
        
        return media;
    }

    static void mostrarMediaDependentes(float mediaDependentes){
        System.out.printf("Média de dependentes: %.1f%n", mediaDependentes);
    }

    static int obterIndiceMenorQuantidadeDependentes(int[] numeroDeps, int ultimaPosicaoGravada){
        int menorQuantidade = numeroDeps[0], indiceMenorQuantidadeDependentes = 0;
        for(int i = 1; i <= ultimaPosicaoGravada; i++){
            if(menorQuantidade > numeroDeps[i]){
                menorQuantidade = numeroDeps[i];
                indiceMenorQuantidadeDependentes = i;
            }
        }

        return indiceMenorQuantidadeDependentes;
    }

    static void mostrarMenorQuantidadeDependentes(int indiceMenorQuantidadeDependentes, String[] nomes, int[] numeroDeps){
        String habitante = nomes[indiceMenorQuantidadeDependentes];
        int dependentes = numeroDeps[indiceMenorQuantidadeDependentes];
        System.out.println("Habitante com a menor quantidade de dependentes: "+ habitante);
        System.out.println("Quantidade de dependentes de "+ habitante +": "+ dependentes);
    }

    static int obterIndiceMaiorSalario(float[] salarios, int ultimaPosicaoGravada){
        float menorSalario = salarios[0];
        int indiceMaiorSalario = 0;
        for(int i = 1; i <= ultimaPosicaoGravada; i++){
            if(menorSalario < salarios[i]){
                menorSalario = salarios[i];
                indiceMaiorSalario = i;
            }
        }

        return indiceMaiorSalario;
    }

    static void mostrarMaiorSalario(int indiceMaiorSalario, String[] nomes, float[] salarios){
        String habitante = nomes[indiceMaiorSalario];
        float salario = salarios[indiceMaiorSalario];
        System.out.println("Nome do habitante com maior salário: "+ habitante);
        System.out.printf("Valor do salário de %s R$%.2f%n", habitante, salario);
    }

    static void mostrarDependentesAbaixoMedia(float mediaDependentes, String[] nomes, int[] numeroDeps, int ultimaPosicaoGravada){
        String nomePadronizado;
        System.out.println(("Nome                   Qtde de dependentes"));

        for(int i = 0; i <= ultimaPosicaoGravada; i++){
            if(numeroDeps[i] < mediaDependentes){
                if(nomes[i].length() > 19){
                    nomePadronizado = nomes[i].substring(0, 16) + "...";
                }
                else nomePadronizado = nomes[i];

                System.out.println(nomePadronizado+"               "+numeroDeps[i]);
            }
        }
    }

}