//Converter uma valor em reais para dollar

/*
Desafio: Reescreva este código adicionando:
    Método que retorna um float chamado lerFloat. 
    Este método deve receber um parâmetro que será o teclado e outro parâmetro chamado mensagem que sera uma string. 
    O teclado sera utilizado para ler o valor e a mensagem deve ser utilizada para imprimir na tela o que o usuário deve digitar.

    Método que retorna um float chamado converterReaisParaDolares. 
    Este método deve receber um float como parâmetro e devolver um float que é o valor de reais convertido para dólares. 
    A impressão do resultado da conversão deve ser mantida no método main. 
 */

import java.util.Scanner;

public class App {
    public static float readFloat(Scanner input, String message){
        System.out.print(message);
        return input.nextFloat();
    }

    public static float realsToDollars(float reals){
        return reals * 0.19f; // Considerando 1 Real = 0.19 Dólares
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        float reals = readFloat(input, "Type the value (in reals): R$");

        float dollars = realsToDollars(reals);
        
        System.out.println("Value in dollars: " + dollars);

        input.close();
    }
}