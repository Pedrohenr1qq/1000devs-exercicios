//Exercicio 3:
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado;
        int valor = 0, resultado;

        teclado = new Scanner(System.in);

        try {
            System.out.print("Digite um valor qualquer: ");
            valor = teclado.nextInt();            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Vocẽ digitou um valor errado");
            teclado.close();
            System.exit(0);
        }
        
        resultado = (valor % 2 != 0) ? valor + 8 : valor +5;
        
        teclado.close();

        System.out.println("Resultado: " + resultado);

    }
}
