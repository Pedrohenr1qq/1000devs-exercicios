/*
    Desafio: Reescreva este código adicionando:

    Método que retorna um int chamado lerInt.
    Este método deve receber um parâmetro que será o teclado e outro parâmetro chamado mensagem que sera uma string. 
    O teclado sera utilizado para ler o valor e a mensagem deve ser utilizada para imprimir na tela o que o usuário deve digitar.

    Método que retorna um float chamado lerFloat. 
    Este método deve receber um parâmetro que será o teclado e outro parâmetro chamado mensagem que sera uma string. 
    O teclado serautilizado para ler o valor e a mensagem deve ser utilizada para imprimir na tela o que o usuário deve digitar.

    Com base nos exercícios anteriores, 
    escreva um método que retone o cálculo da conversão para cada um das unidades de medias: metros, quilometros, milhas, jardas, polegadas e pés.  
*/

import java.util.Scanner;

public class App {

    public static int readInt(Scanner input, String message){
        System.out.print(message);
        return input.nextInt();
    }

    public static float readFloat(Scanner input, String message){
        System.out.print(message);
        return input.nextInt();
    }

    public static float convertTo(int unit, float measure){
        float result = -1;

        switch (unit) {
            case 1:
                result = (measure / 100f); // 1 meter = 100 centimeters
                break;
            
            case 2:
                result = (measure / 100000f); // 1 kilometer = 100.000 centimeters
                break;
            
            case 3:
                result = (measure / 160934f); // 1 mile = 160934 centimeters
                break;

            case 4:
                result = (measure / 91.44f); // 1 yard = 91.44 centimeters
                break;
            
            case 5: 
                result = (measure / 30.48f); // 1 feet = 30.48 centimeters
                break;

            case 6:
                result = (measure / 2.54f); // 1 inche = 2.54 centimeters;
                break;

            default:
                System.out.println("Choice invalid!");
                break;
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        float centimeters = readFloat(input,"Type the measure in centimeters: ");
        
        System.out.println("For");

        System.out.println("Which unit do you want a converter for?\n");
        System.out.println("1 - Meters");
        System.out.println("2 - Kilometers");
        System.out.println("3 - miles");
        System.out.println("4 - Yards");
        System.out.println("5 - Feet");
        System.out.println("6 - Inches");

        int userChoice = readInt(input,"Your choice: ");
        
        float result = convertTo(userChoice, centimeters);

        if(result >= 0)System.out.println("The result is: "+ result);

    }
}