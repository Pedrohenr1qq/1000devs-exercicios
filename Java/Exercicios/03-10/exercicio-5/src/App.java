//exercicio 5:
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado;
        int a = 0, b = 0, c;

        teclado = new Scanner(System.in);

        try {
            System.out.print("Digite o valor de A: ");
            a = teclado.nextInt();
    
            System.out.print("Digite o valor de B: ");
            b = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("Vocẽ digitou um valor errado");
            teclado.close();
            System.exit(0);
        }

        c = (a == b) ? (a+b) : (a*b) ;

        System.out.println("O valor de C é: " + c);
    }
}