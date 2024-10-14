//Exercicio 8:

import java.util.Scanner;
public class App {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        float altura = 1;
        int sexo = 0;

        try {
            System.out.print("Digite a sua altura em mts: ");
            altura = teclado.nextFloat();   

            System.out.println("\nDigite 1 para masculino. ");
            System.out.println("Digite 2 para feminino. ");
            try {
                System.out.print("\nDigite o seu sexo: ");
                sexo = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Esse valor é incorreto para o sexo");
                altura = 1;
            }
    

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Esse valor é incorreto para a altura");
            altura = 1;
        }


        float resultado = (sexo == 1) ? ((72.7f * altura) - 58) : ((62.1f * altura) - 44.7f);

        if(altura != 1) System.out.println("Seu peso ideal é: " + resultado);

        teclado.close();
    }
}