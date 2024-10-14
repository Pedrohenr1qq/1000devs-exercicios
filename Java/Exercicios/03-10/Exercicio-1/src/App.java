//Exercicio 1:
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado;
        int valor=0;
        boolean ehImpar;

        teclado = new Scanner(System.in);

        try {
            System.out.print("Digite um valor qualquer: ");
            valor = teclado.nextInt();            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Vocẽ digitou um valor errado");
            System.exit(0);
        }

        ehImpar = (valor % 2 != 0);
        String valueType = (ehImpar) ? "Impar" : "Par";
        System.out.println("O valor "+ valor+ " é "+ valueType);

    }
}
