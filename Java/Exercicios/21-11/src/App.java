import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.*;

public class App {
    //inicio das variaveis globais
    static Scanner teclado = new Scanner(System.in);

    static String CAMINHO_ARQUIVO = "dados.txt";
    static int TAMANHO_MAXIMO = 50;

    static String[] nomes = new String[TAMANHO_MAXIMO];
    static int[] idades = new int[TAMANHO_MAXIMO];
    static float[] pesos = new float[TAMANHO_MAXIMO];

    //controlar quantas posicoes ja foram gravadas no vetor
    static int contador = 0;
    //variavel para controlar quando se deve ou nao limpar a
    static boolean limparTela = true;

    //fim das variaveis globais
    public static void main(String[] args) {
        //variavel que armazena a resposta do menu
        int opcao;
        
        carregarDados();

        do {
            limparTela();
            opcao = lerOpcaoMenu();
            processarOpcaoMenu(opcao);
        } while(opcao != 3);

        teclado.close();
    }

    static void processarOpcaoMenu(int opcao){
        switch (opcao) {
            case 1:
                adicionarDados();
                break;
            case 2:
                limparTela();
                mostrarDados();
                limparTela = false;
                break;
            case 3:
                limparTela();
                salvarDados();
                System.out.println("Encerrando...");
                break;
            
            case 4:
                exibirQTDEPessoas();
                break;
            
            case 5:
                mostrarPessoaMenorIdade();
                break;
            
            case 6:
                mostrarPessoaMaiorPeso();
                break;

            case 7:
                mostrarPessoasAcimaPeso();
                break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
    
    static void adicionarDados() {
        limparTela = true;
        limparTela();
        
        boolean entradaValida = false;

        //Verifico se tem espaco nos vetores
        if (contador >= TAMANHO_MAXIMO) {
            System.out.println("Limite de dados atingido! Não é possível adicionar mais.");
            //estou usando um retorne para forcar o fim da execucao
            //do metodo adicionarDados quando nao tiver mais posicoes livres 
            //no vetor. 
            return;
        }

        System.out.print("Digite o nome: ");
        nomes[contador] = teclado.nextLine();

        while(!entradaValida){
            try {            
                System.out.print("Digite a idade: ");
                idades[contador] = teclado.nextInt();

                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println("\nApenas valores inteiros são aceitos. Tente novamente: ");
                teclado.nextLine();
            }
        }

        while(true){
            try {            
                System.out.print("Digite o peso (em kg): ");
                pesos[contador] = teclado.nextFloat();
                break;

            } catch (InputMismatchException e) {
                System.out.println("\nApenas valores numéricos são aceitos. Tente novamente: ");
                teclado.nextLine();
            }
        }
        
        
        teclado.nextLine(); // Limpar buffer

        contador++;
    }
    
    static int lerOpcaoMenu(){
        int opcao = 0;
        System.out.println("\n############## Menu ##############\n");
        System.out.println("1. Adicionar dados");
        System.out.println("2. Mostrar dados");
        System.out.println("3. Sair");
        System.out.println("4. Exibir a QTDE de pessoas");
        System.out.println("5. Exibir a pessoa com menor idade");
        System.out.println("6. Exibir a pessoa com maior peso");
        System.out.println("7. Contar QTDE de Pessoas acima de Peso");



        try {
            System.out.print("\nEscolha uma opção: ");
            opcao = teclado.nextInt();

        } catch (InputMismatchException e) {
        
        }
        teclado.nextLine(); // Limpar buffer
        
        return opcao;
    }

    static void carregarDados() {
        FileReader arquivo = null;
        BufferedReader bufferLeitura = null;

        try {
            //define o arquivo que sera abert
            arquivo = new FileReader(CAMINHO_ARQUIVO);
            bufferLeitura = new BufferedReader(arquivo);
            String linha;

            linha = bufferLeitura.readLine();
            
            while (linha != null) {
                String[] campos = linha.split(";");
                if (campos.length == 3 && contador < TAMANHO_MAXIMO) {
                    nomes[contador] = campos[0];
                    //como o split devolve o resultado como string
                    //é necessario converter a idade do arquivo para int 
                    idades[contador] = Integer.parseInt(campos[1]);
                    //é necessário converter o peso do arquivo para float
                    pesos[contador] = Float.parseFloat(campos[2]);
                    contador++;
                }
                linha = bufferLeitura.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Um novo será criado ao salvar.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro nos dados do arquivo: formato inválido.");
        } finally {
            // Fechamento do arquivo e do bufferLeitura
            try {
                if (bufferLeitura != null) {
                    bufferLeitura.close();
                }
                if (arquivo != null) {
                    arquivo.close();
                }
            } catch (IOException e) {
                System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
            }
        }
    }

    static void mostrarDados() {
        int qtdeEspacos;

        if (contador == 0) {
            System.out.println("Nenhum dado disponível.");
            return;
        }

        System.out.println("\nNome                Idade               Peso");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < contador; i++) {
            qtdeEspacos = 0;

            System.out.print(nomes[i]);
            //calcula quantos espacos sao necessarios para alinhar
            //o valor da idade na posicao da coluna idade
            qtdeEspacos = (20 - nomes[i].length());
            //imprime a quantidade de espacos para alinhar os salarios
            System.out.print(gerarEspacos(qtdeEspacos));

            System.out.print(idades[i]);
            qtdeEspacos = (20 - String.valueOf(idades[i]).length());
            System.out.print(gerarEspacos(qtdeEspacos));

            System.out.println(pesos[i]);
        }
    }

    static void salvarDados() {
        BufferedWriter gravador = null;
    
        try {
            // Inicializa o BufferedWriter para escrever no arquivo
            gravador = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO));
            
            // Escreve os dados no arquivo
            for (int i = 0; i < contador; i++) {
                //escreve os dados no arquivo
                gravador.write(nomes[i] + ";" + idades[i] + ";" + pesos[i]);
                //cria uma nova linha no arquivo
                gravador.newLine();
            }
    
            System.out.println("Dados salvos no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        } finally {
            // Fechamento do BufferedWriter 
            if (gravador != null) {
                try {
                    gravador.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
                }
            }
        }
    }

    static String gerarEspacos(int qtde){
        String espacos = "";

        for (int i = 0; i < qtde; i++) {
            espacos += " ";
        }

        return espacos;
    }

    static void limparTela(){
        if (limparTela){
            try {
                if (System.getProperty("os.name").contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                }
            } catch (Exception e) {
                System.out.println("Erro ao limpar a tela: " + e.getMessage());
            }
        }
    }

    static void exibirQTDEPessoas(){
        limparTela = true;
        limparTela();
        if(contador == 1 ) System.out.println("Existe "+ contador+ " pessoa cadastrada");
        else System.out.println("Existem "+ contador+ " pessoas cadastradas");
        System.out.print("Aperte qualquer tecla para continuar.");
        teclado.nextLine();
        limparTela = false;
    }

    static void mostrarPessoaMenorIdade(){
        limparTela = true;
        int indiceMenorIdade = 0, menorIdade = 1000;
        limparTela();
        System.out.println();

        if(contador == 0){
            System.out.println("Não há nenhuma pessoa cadastrada");
        }else{
            for(int i = 0; i <= contador -1; i++){
                
                if(menorIdade > idades[i]){
                    menorIdade = idades[i];
                    indiceMenorIdade = i;
                }
            }

            String pessoaMenorIdade = nomes[indiceMenorIdade];
    
            System.out.println("A pessoa com menor idade é: "+ pessoaMenorIdade+ " com "+ menorIdade+" anos.");
        }
        
        System.out.print("Aperte qualquer tecla para continuar.");
        teclado.nextLine();
        limparTela = false;
    }

    
    static void mostrarPessoaMaiorPeso(){
        limparTela = true;
        int indiceMaiorPeso = 0;
        float maiorPeso = 0;
        limparTela();
        System.out.println();

        if(contador == 0){
            System.out.println("Não há nenhuma pessoa cadastrada");
        }else{
            for(int i = 0; i <= contador -1; i++){
                
                if(maiorPeso < pesos[i]){
                    maiorPeso = pesos[i];
                    indiceMaiorPeso = i;
                }
            }

            String pessoaMaiorPeso = nomes[indiceMaiorPeso];
    
            System.out.println("A pessoa com maior peso é: "+ pessoaMaiorPeso+ " com "+ maiorPeso+" kgs.");
        }
        
        System.out.print("Aperte qualquer tecla para continuar.");
        teclado.nextLine();
        limparTela= false;
    }

    static void mostrarPessoasAcimaPeso(){
        limparTela = true;
        limparTela();
        float peso_ref = 0;
        int qt = 0;

        if(contador == 0){
            System.out.println("Não há nenhuma pessoa cadastrada");
        }else{
            while (true) {
                try {
                    System.out.print("Digite um peso de referência: ");
                    peso_ref = teclado.nextFloat();
    
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Apenas valores numéricos são aceitos.");
                    teclado.nextLine();
                }   
            }
            for(int i = 0; i <= contador-1; i++){
                if(pesos[i] > peso_ref) qt++;
            }
    
            if(qt == 1) System.out.println("Existe 1 pessoa com peso igual acima de "+ peso_ref+ " kgs");
            else System.out.println("Existem "+qt +" pessoas com pesos iguais ou acima de "+ peso_ref+ " kgs");
        }

        System.out.println();
        limparTela = false;
    }

}