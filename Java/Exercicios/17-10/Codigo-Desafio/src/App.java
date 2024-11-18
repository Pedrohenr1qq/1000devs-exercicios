/*

Reescreva o código abaixo para a partir de uma data informada pelo usuário, seja possível extrair o dia o mês e o ano para que o restante do código seja executado.

Lembre-se que o seu código precisa prever a possibilidade do usuário informar uma data no seguinte formato:

 01/02/2024

 01/2/2024

 1/02/2024

 1/2/2024

 01-02-2024

 01-2-2024

 1-02-2024

 1-2-2024 
*/
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String data;
        int dia, mes, ano;
        boolean anoEhBissexto;

        System.out.print("Digite a data: ");
        data = teclado.nextLine();
        
        dia = obterDia(data);//faça a chamada da funcao;
        mes = obterMes(data);//faça a chamada da funcao;
        ano = obterAno(data);//faça a chamada da funcao;


        anoEhBissexto = ((ano%4 == 0) && ((ano%100 != 0) || (ano%400 == 0)));

        // se o dia for 29 e o mes for fevereiro e o ano nao é bissexto
        if (dia == 29 && mes == 2 && !anoEhBissexto) {
            System.out.print("A data é invalida pois o ano nao e bissexto.");
            // o dia e maior que 31
        } else if (dia > 31) {
            System.out.print("A data é invalida pois nao existe dia maior que 31.");
            // quando dia e 31 e (o mes for fevereiro ou abril ou junho ou setembro ou
            // novembro)
        } else if (dia == 31 && (mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
            System.out.print("A data é invalida pois não existe 31 no mes + " + mes);
            // quando o dia for 30 e o mes fevereiro
        } else if (dia == 30 && mes == 2) {
            System.out.print("A data é invalida pois nao existe 30 de fevereiro.");
            // se o mes for maior que 12
        } else if (mes < 1 || mes > 12) {
            System.out.print("A data é invalida pois os meses devem ser entre 1 e 12");
        } else {
            System.out.print("A data é valida!");
        }
        teclado.close();

        System.out.println("");

    }

    static int obterDia(String data){
        int dia = -1;
        int primeiroSeparador = data.indexOf('/');

        if(primeiroSeparador == -1) primeiroSeparador = data.indexOf('-'); // Altere a busca pelo separador '/' para o separador '-';
        if(primeiroSeparador != -1) {
            dia = Integer.parseInt(data.substring(0, primeiroSeparador));
        }else System.out.println(("A data inserida está invalida, pois o separador para 'DIA' não foi encontrado"));

        return dia;
    }

    static int obterMes(String data){
        int mes = -1;
        int primeiroSeparador = data.indexOf('/'), ultimoSeparador = data.lastIndexOf('/');

        if(primeiroSeparador == -1) { // Altere a busca pelo separador '/' para o separador '-';
            primeiroSeparador = data.indexOf('-');
            ultimoSeparador = data.lastIndexOf('-');
        }if((primeiroSeparador != -1) && (ultimoSeparador != -1) && (ultimoSeparador != primeiroSeparador) ){ // Os separadores devem ser do mesmo tipo('/' ou '-') e devem ser de index diferentes
            mes = Integer.parseInt(data.substring(primeiroSeparador+1, ultimoSeparador));
        }else System.out.println(("A data inserida está invalida, pois os separadores para 'MES' não foram encontrados"));

        return mes;
    }

    static int obterAno(String data){
        int ano = -1;

        int ultimoSeparador = data.lastIndexOf('/');

        if(ultimoSeparador == -1) ultimoSeparador = data.lastIndexOf('-'); // Altere a busca pelo separador '/' para o separador '-';
        if(ultimoSeparador != -1) {
            ano = Integer.parseInt(data.substring(ultimoSeparador+1, data.length()));
        }else System.out.println(("A data inserida está invalida, pois o separador para 'ANO' não foi encontrado"));
        
        return ano;
    }
}