//Converter uma temperatura de fahrenheit para celcius

/*
Desafio: Reescreva este código adicionando:
    Método que retorna um float chamado lerFloat. 
    Este método deve receber um parâmetro que será o teclado e outro parâmetro chamado mensagem que sera uma string. 
    O teclado sera utilizado para ler o valor e a mensagem deve ser utilizada para imprimir na tela o que o usuário deve digitar.

    Método que retorna um float chamado converterParaCelcius. 
    Este método deve receber um float como parâmetro e devolver um float que é o valor de fahrenheit convertido para celsius. 
    A impressão do resultado da conversão deve ser mantida no método main.
*/

import java.util.Scanner;

public class App {
    public static float lerFloat(Scanner input, String message){
        System.out.print(message);
        return input.nextFloat();
    }

    public static float convertToCelsius(float fahrenheit){
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float fahrenheit = lerFloat(input, "Type a float: ");
        float celsius = convertToCelsius(fahrenheit);

        System.out.println("Temperature in Celsius: " + celsius);

        input.close();
    }
}