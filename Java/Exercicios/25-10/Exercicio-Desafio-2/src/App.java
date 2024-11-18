/*
Em sistemas americanos é muito comum exibir o nome dos usuários no seguinte formato:

MR. RIBEIRO, Rogério para homens se o nome for Rogério de Freitas Ribeiro e

MS. SILVA, Paula para mulheres se o nome for Paula Oliveira da Silva.

onde MR. é a abreviação de Mister ou Senhor em português

onde MS. é a abreviação de Miss ou Senhora/Senhorita em português

O algoritmo abaixo, lê o nome completo do usuário e o sexo e você precisa exibir o nome no formato americano conforme o exemplo anterior.
 */

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
            String nome, primeiroNome, sobrenome;
            char sexo;
            int posicaoAtual = 0;
            int posicaoAnterior = 0;
            int tamanhoNome;
            
            System.out.print("Digite o nome: ");
            nome = teclado.nextLine();

            System.out.print("Digite o sexo [f/m]: ");
            sexo = Character.toLowerCase(teclado.nextLine().charAt(0));
            
            primeiroNome = descobrePrimeiroNome(nome);
            sobrenome = descobreUltimoSobrenome(nome);

            //implemente aqui o codigo para apresentar 
            //o nome no formato americano

            String abreviacao = (sexo == 'm') ? "MR." : "MS.";

            System.out.println(abreviacao + " " + sobrenome.toUpperCase() + ", " + primeiroNome);

        teclado.close();
    }

    //implementar a funcao que descobre o ultimo nome
    static String descobreUltimoSobrenome(String nome){
        return nome.substring(nome.lastIndexOf(" ")+1, nome.length());
    }

    static String descobrePrimeiroNome(String nome){
        int posEspaco;
        posEspaco = nome.indexOf(" ");

        return  nome.substring(0, posEspaco);
    }
}
  