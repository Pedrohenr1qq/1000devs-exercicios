//Exercicio 2:

import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado;
        int a =0,  b =0, c = 0;

        teclado = new Scanner(System.in);

        try{
            System.out.print("Digite o primeiro valor: ");
            a = teclado.nextInt();
    
            System.out.print("Digite o segundo valor: ");
            b = teclado.nextInt();
    
            System.out.print("Digite o terceiro valor: ");
            c = teclado.nextInt();
      
        }catch(Exception e){
            System.out.println("Vocẽ digitou um valor errado");
            System.exit(0);
        }

        teclado.close();

        String isValid = (a + b < c) ? "A soma de A + B é menor C" : "A soma de A + B não é menor C";

        System.out.println(isValid);

    }
}
