//Exercicio 7:

import java.util.Scanner;
public class App {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        float totalCompra = 0;
        float valorFinalCompra = 1;

        int opcaoPagamento;

        try {
            System.out.print("Digite o valor total da compra: R$ ");
            totalCompra = teclado.nextFloat();
        } catch (Exception e) {
            System.out.println("Você digitou um valor errado. Operação encerrada");
            teclado.close();
            System.exit(0);
        }

        System.out.println("\nCódigo  Descrição");
        System.out.println("1       À vista em dinheiro ou cheque, recebe 10% de desconto");
        System.out.println("2       À vista no cartão de crédito, recebe 15% de desconto");
        System.out.println("3       Em duas vezes, preço normal de etiqueta sem juros");
        System.out.println("4       Em três vezes, preço normal de etiqueta mais juros de 10%");
        System.out.println("");
        System.out.print("Digite a opção de pagamento: ");


        try {
            opcaoPagamento = teclado.nextInt();
        } catch (Exception e) {
            System.out.println("Você selecionou uma opção invalida. Operação cancelada");
            opcaoPagamento = 0;
            teclado.close();
            System.exit(0);
        }

        System.out.println("Valor da compra: R$ " + totalCompra);

        switch (opcaoPagamento) {
            case 1:    
                System.out.print("Valor à vista com 10% de desconto: R$ ");
                valorFinalCompra = totalCompra * 0.9f;
                break;
        
            case 2:
                System.out.print("Valor à vista no cartão de crédito com 15% de desconto: R$ ");
                valorFinalCompra = totalCompra * 0.85f;
                break;
                
            case 3:    
                System.out.print("Em 2x sem juros: R$ ");
                valorFinalCompra = totalCompra;
                break;

            case 4:    
                System.out.print("Em 3x com 10% de juros: R$ ");
                valorFinalCompra = totalCompra * 1.1f;
                break;

            default:
                System.out.println("Valor não reconhecido. Operação encerrada");
                break;
        }

        System.out.println(valorFinalCompra);

        teclado.close();
    }
}
