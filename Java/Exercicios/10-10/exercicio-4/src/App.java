/*
    Desafio: Reescreva este código adicionando:

    Método que retorna um int chamado lerInt. 
    Este método deve receber um parâmetro que será o teclado e outro parâmetro chamado mensagem que sera uma string. 
    O teclado sera utilizado para ler o valor e a mensagem deve ser utilizada para imprimir na tela o que o usuário deve digitar.

    Método que retorna um float chamado lerFloat. 
    Este método deve receber um parâmetro que será o teclado e outro parâmetro chamado mensagem que sera uma string. 
    O teclado serautilizado para ler o valor e a mensagem deve ser utilizada para imprimir na tela o que o usuário deve digitar.

    Método que retorna um float chamado calcularAreaCirculo. 
    Este método receberá um parâmetro que será o teclado. 
    O método deve ler do usuário utilizando o lerFloat os valores para calcular a área do círculo e retornar um float que será a área calculada.

    Método que retorna um float chamado calcularAreaQuadrado. 
    Este método receberá um parâmetro que será o teclado. 
    O método deve ler do usuário utilizando o lerFloat os valores para calcular a área do quadrado e retornar um float que será a área calculada.

    Método que retorna um float chamado calcularAreaTriangulo. 
    Este método receberá um parâmetro que será o teclado. 
    O método deve ler do usuário utilizando o lerFloat os valores para calcular a área do triângulo e retornar um float que será a área calculada.

    Método que retorna um float chamado calcularAreaRetangulo. 
    Este método receberá um parâmetro que será o teclado. 
    O método deve ler do usuário utilizando o lerFloat os valores para calcular a área do retângulo e retornar um float que será a área calculada.


    Método que nao retorna valor chamado imprimir menu. 
    Este método não recebe nenhum parametro e imprime as opções do menu.
*/

import java.util.Scanner;

public class App {

    public static int readInt(Scanner input, String message){
        System.out.print(message);
        return input.nextInt();
    }

    public static float readFloat(Scanner input, String message){
        System.out.print(message);
        return input.nextFloat();
    }

    public static float computeCircleArea(Scanner input){
        float radio = readFloat(input,"Type the circle radio: ");
        return (float) (Math.PI * Math.pow(radio, 2));
    }

    public static float computeSquareArea(Scanner input){
        float side = readFloat(input, "Type the side size: ");
        return (float) Math.pow(side,2);
    }

    public static float computeRectangleArea(Scanner input){
        float width = readFloat(input, "Type the width: ");
        float height = readFloat(input, "Type the height: ");
        return (width * height);
    }

    public static float computeTriangleArea(Scanner input){
        float width = readFloat(input, "Type the base length: ");
        float height = readFloat(input, "Type the height: ");
        return (width * height)/2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Choose a option: ");
        System.out.println("\n1: Square: ");
        System.out.println("2: Rectangle: ");
        System.out.println("3: Circle: ");
        System.out.println("4: Triangle: \n");

        System.out.print("Your choice: ");
        int userChoice = input.nextInt();
        
        switch (userChoice) {
            case 1:
                float squareArea = computeSquareArea(input);
                System.out.println("The square area is: " + squareArea);
                break;
                
            case 2:
                float rectangleArea = computeRectangleArea(input);
                System.out.println("The rectangle area is: " + rectangleArea);
                break;
            
                
            case 3:
                float circleArea = computeCircleArea(input);
                System.out.println("The rectangle area is: " + circleArea);
                break;
                
            case 4:
                float triangleArea = computeTriangleArea(input);
                System.out.println("The rectangle area is: " + triangleArea);
                break;
                
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
}