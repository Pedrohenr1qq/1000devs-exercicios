/*
 * Desafio: Reescreva este código adicionando:
    Método que retorna um int chamado lerInt. 
    Este método deve receber um parâmetro que será o teclado e outro parâmetro chamado mensagem que sera uma string.
    O teclado sera utilizado para ler o valor e a mensagem deve ser utilizada para imprimir na tela o que o usuário deve digitar.
    
    Método que imprime na tela se o número valor de a + b é maior que c, chamado mostrarResultado. 
    Este método deve receber três parâmetros. Os parâmetros devem ser o valor de a, de b e de c.
 */

import java.util.Scanner;

public class App {

    public static int readInt(Scanner input, String message){
        System.out.print(message);
        return input.nextInt();
    }

    public static void showResult(int a, int b, int c){
        if (a + b < c) {
            System.out.println("The sum of A + B is less than C");
        } else {
            System.out.println("The sum of A + B is not less than C");
        }
    }

    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        int a, b, c;

        a = readInt(input, "Type the first value: ");

        b = readInt(input, "Type the second value: ");

        c = readInt(input, "Type the third value: ");

        showResult(a, b, c);

        input.close();
    }
}