//Exercicio 4: 
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado;
        int valor = 0, resultado = 0;

        teclado = new Scanner(System.in);

        try {
            System.out.print("Digite um numero: ");
            valor = teclado.nextInt();            
        } catch (Exception e) {
            System.out.println("Vocẽ digitou um valor errado");
            teclado.close();
            System.exit(0);
        }

        if (valor!=0) {
            resultado = (valor < 0 ) ? valor * 3 : valor *2;
            System.out.println("Resultado: " + resultado);
        }        

    }
}