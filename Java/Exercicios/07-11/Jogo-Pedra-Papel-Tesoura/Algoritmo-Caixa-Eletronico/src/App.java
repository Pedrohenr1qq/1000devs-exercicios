/* 
Aqui temos a implementação do algoritmo do caixa eletronico utilizando um laço para identificar a quantidade de notas a serem sacadas.

Este código não está considerando a existência de notas de 200 reais e notas de 2 reais. 
Faça as modificações necessárias para implementar a possibilidade do caixa eletronico forneceder notas de 200 e também notas de 2.

Este código possui um problema, caso o usuário digite um valor que não possa ser fornecido com as notas disponíveis, 
o laco entra em uma situação conhecida como looping infinito, ou seja o programa nunca terminará. 
Se você testar o código com o valor 48 reais esta situação de looping ocorrerá. 
Para corrigir este cenário, implemente uma função que seja responsável pela leitura do valor a ser sacado, 
e esta função deve garantir que o usuário digite um valor que seja múltiplo da menor nota que o caixa eletrônico tenha disponível.

Depois das implementações anteriores, 
modifique o algoritmo do caixa eletrônico para que ele possa ser iniciado com a quantidade de notas disponíveis no caixa. 
Este valor deve ser informado pelo usuário no início da execução do algoritmo. 
Posteriormente o algoritmo deve entrar em uma repetição sucessiva, realizando a leitura de vários saques informados pelo usuário. 
Após o usuário informar que deseja fazer o saque e o algoritmo deve mostrar a quantidade de notas que serão sacadas, 
e deve descontar a quantidade de notas fornecidas do montante de notas existentes internamente, para que o próximo saque possa ser realizado. 
O algoritmo após este ponto, perguntará se deseja realizar um novo saque e todo o procedimento se repete. 
O algoritmo finaliza quando o usuário informar que não deseja realizar novos saques. 
Caso o usuário solicite um saque que não possa ser atendido por não ter a quantidade de notas necessárias, 
deve ser exibido uma mensagem informando tal situação. 
No término da execução o algoritmo deve aprensentar a quantidade de notas restantes na máquina e qual o valor total disponível na máquina.


*/

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continuar = false;

        int valorSaque = 0;
        boolean saqueValido;


        // Variáveis para a quantidade de cada nota
        System.out.print("Digite a qt. em caixa de notas de R$ 200: ");
        int nota200 = scanner.nextInt();
        
        System.out.print("Digite o valor que deseja sacar R$ 100: ");
        int nota100 = scanner.nextInt();
        
        System.out.print("Digite a qt. em caixa de notas de R$ 50: ");
        int nota50 = scanner.nextInt();

        System.out.print("Digite a qt. em caixa de notas de R$ 20: ");
        int nota20 = scanner.nextInt();
        
        System.out.print("Digite a qt. em caixa de notas de R$ 10: ");
        int nota10 = scanner.nextInt();
        
        System.out.print("Digite a qt. em caixa de notas de R$ 5: ");
        int nota5 = scanner.nextInt();
        
        System.out.print("Digite a qt. em caixa de notas de R$ 2: ");
        int nota2 = scanner.nextInt();


        //Variáveis para guardar os valores iniciais;
        int nota200_inicial = nota200;
        int nota100_inicial = nota100;
        int nota50_inicial = nota50;
        int nota20_inicial = nota20;
        int nota10_inicial = nota10;
        int nota5_inicial = nota5;
        int nota2_inicial = nota2;

        
        System.out.print("Deseja realizar um saque? (Digite s para sim) ");

        continuar = (scanner.next().equalsIgnoreCase("s"));


        while (continuar) {

            // Solicitar o valor do saque
            do {
                System.out.print("Digite o valor que deseja sacar: R$ ");
                valorSaque = scanner.nextInt();
                saqueValido = (valorSaque%2 == 0) || (valorSaque%5 == 0);
                if(!saqueValido) System.out.println("O valor do saque precisa ser multiplo de 2 ou de 5 ");

            } while (!saqueValido);
        
            // Fazendo o calculo de notas necessárias
            while(valorSaque >= 200 && temEmCaixa(nota200)){
                nota200--;
                valorSaque-=200;
            }
            while(valorSaque >= 100 && temEmCaixa(nota100)) {
                nota100--;
                valorSaque -= 100;
            } 
            while (valorSaque >= 50 && temEmCaixa(nota50)) {
                nota50--;
                valorSaque -= 50;
            } 
            while (valorSaque >= 20 && temEmCaixa(nota20)) {
                nota20--;
                valorSaque -= 20;
            }
            while(valorSaque >= 10 && temEmCaixa(nota10)) {
                nota10--;
                valorSaque -= 10;
            } 
            while(valorSaque >= 5 && temEmCaixa(nota5) ) {
                nota5--;
                valorSaque -= 5;
            }
            while(valorSaque >= 2 && temEmCaixa(nota2) ){
                nota2--;
                valorSaque-=2;
            }

            if(valorSaque > 0) {
                if(temEmCaixa(nota2) || temEmCaixa(nota5)) System.out.println("Não há é possível sacar o valor informado.");
                else System.out.println(" Não há notas suficientes para esse saque");
                
                nota200 = nota200_inicial;
                nota100 = nota100_inicial;
                nota50 = nota50_inicial;
                nota20 = nota20_inicial;
                nota10 = nota10_inicial;
                nota2 = nota2_inicial;

            }else{

                // Exibir qt de notas fornecidas
                System.out.println("Notas a serem fornecidas:");
                mostrarNotasFornecidas(nota200_inicial, nota200, "200");
                mostrarNotasFornecidas(nota100_inicial, nota100, "100");
                mostrarNotasFornecidas(nota50_inicial, nota50, "50");
                mostrarNotasFornecidas(nota20_inicial, nota20, "20");
                mostrarNotasFornecidas(nota10_inicial, nota10, "10");
                mostrarNotasFornecidas(nota5_inicial, nota5, "5");
                mostrarNotasFornecidas(nota2_inicial, nota2, "2");


                // Exibir qt de notas restantes
                System.out.println("\nQt. de notas restantes:");
                mostrarNotasEmCaixa(nota200, "200");
                mostrarNotasEmCaixa(nota100, "100");
                mostrarNotasEmCaixa(nota50, "50");
                mostrarNotasEmCaixa(nota20, "20");
                mostrarNotasEmCaixa(nota10, "10");
                mostrarNotasEmCaixa(nota5, "5");
                mostrarNotasEmCaixa(nota2, "2");
            }
            
            nota200_inicial = nota200;
            nota100_inicial= nota100;
            nota50_inicial = nota100;
            nota20_inicial = nota20;
            nota10_inicial = nota10;
            nota5_inicial = nota5;
            nota2_inicial = nota2;

            System.out.print("Deseja continuar com o saque? (Digite s para sim) ");

            continuar = (scanner.next().equalsIgnoreCase("s"));

        }

        // Se restar algum valor menor que 5, ele não pode ser atendido com as notas disponíveis
        if (valorSaque > 0) {
            System.out.println("Valor restante não pode ser atendido com as notas disponíveis.");
        }

        
        // Exibir qt de notas restantes
        System.out.println("\nQt. de notas restantes:");
        mostrarNotasEmCaixa(nota200, "200");
        mostrarNotasEmCaixa(nota100, "100");
        mostrarNotasEmCaixa(nota50, "50");
        mostrarNotasEmCaixa(nota20, "20");
        mostrarNotasEmCaixa(nota10, "10");
        mostrarNotasEmCaixa(nota5, "5");
        mostrarNotasEmCaixa(nota2, "2");

        System.out.println("Valor total disponivel: R$" + (nota200*200 + nota100*100 + nota50*50 + nota20*20 + nota10*10+ nota5*5 + nota2*2));

        scanner.close();
    }

    static void mostrarNotasFornecidas(int notaInicial, int notaAtual, String valorNota){
        if(notaAtual != notaInicial) System.out.println((notaInicial - notaAtual) + " nota(s) de R$ "+ valorNota);
    }

    static void mostrarNotasEmCaixa(int qtNota, String valorNota){
        System.out.println("Há "+ qtNota + " nota(s) de R$ "+ valorNota);
    }

    static boolean temEmCaixa(int nota){
        return (nota > 0);
    }
}