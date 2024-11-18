/*
Atualmente muitos sistemas forçam o usuário a escolher uma senha, que seja complexa o suficiente,
para que outras pessoas não consigam descobrir a senha por tentativa e erro.
Você iniciará a construção de um sistema de validação de requisitos obrigatórios de senha.

Inicialmente o seu trabalho é identificar a quantidade de caracteres maiúsculos, caracteres especiais e dígitos, 
além de descobrir se a senha do usuário possui partes do nome.

Altere o código para para que o programa consiga identificar a qtde de caracteres especiais, 
a quantidade de dígitos e se a senha possui partes do nome.


Ex:  Se a senha do usuário for rogerio123 o sistema deve retornar:

A senha possui: 0 caracteres maiúsculos.
A senha possui: 3 caracteres dígitos.
A senha possui partes do nome.


Ex. Se a senha do usuário for freitAbc$1 o sistema deve retornar:

A senha possui: 1 caracteres maiúsculos.
A senha possui: 1 dígitos.
A senha possui: 1 caractere especial.
A senha não possui partes do nome.

 */

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int qtdeMaiusculas, qtdeDigitos, qtdeEspeciais;
        boolean temPartesDoNome;
        String senha, nome;

        System.out.print("Digite seu nome: ");
        nome = teclado.nextLine();

        System.out.print("Digite sua senha: ");
        senha = teclado.nextLine();

        qtdeMaiusculas = identificaQtdeMaiusculas(senha);

        System.out.println("A senha possui: " + qtdeMaiusculas + " caractere(s) maiúsculos.");

        qtdeDigitos = identificaQtdeDigitos(senha);

        System.out.println("A senha possui: " + qtdeDigitos + " dígito(s).");
        
        qtdeEspeciais = identificaQtdeEspeciais(senha);

        System.out.println("A senha possui: " + qtdeEspeciais + " caractere(s) especiais.");

        temPartesDoNome = identificaSeSenhaTemPartesNome(senha, nome);

        if (temPartesDoNome){
            System.out.println("A senha possui partes do nome do usuário");
        } else {
            System.out.println("A senha não possui partes do nome do usuário.");
        }

        teclado.close();
    }

    static int identificaQtdeEspeciais(String senha){
        int qtde = 0;
        int pos = 0;
        char caractere;
        boolean ehEspecial;

        //Será caractere especial se não for nem numero, nem letra maiscula nem letra minuscula
        // Tipo         |         ASCII
        // Numero       |       48 - 57
        // Maiuscula    |       65 - 90
        // Minuscula    |       98 - 122

        do {
            caractere = senha.charAt(pos);
            ehEspecial = (!((int) caractere >= 48 && (int) caractere <= 57)) && (! (caractere >= 65 && caractere <= 90)) && (!(caractere >= 97 && caractere <= 122));
            if(ehEspecial) qtde++;

            pos++;
        } while (pos < senha.length()); 

        return qtde;
    }

    static int identificaQtdeDigitos(String senha){
        int qtde = 0;
        int pos = 0;
        char caractere; 

        //Numeral | ASCII
        //0     --> 48
        //9     --> 57

        do {
            caractere = senha.charAt(pos);
            if((int) caractere >= 48 && (int) caractere <= 57) qtde++;

            pos++;
        } while (pos < senha.length());

        return qtde;
    }

    static boolean identificaSeSenhaTemPartesNome(String senha, String nome){
        boolean temPartesNome = false;
        senha = senha.toLowerCase();
        nome = nome.toLowerCase();

        int indexNome = senha.indexOf(nome);
        temPartesNome = indexNome != -1;

        return temPartesNome;
    }

    static int identificaQtdeMaiusculas(String senha){
        int qtde = 0;
        int posicao = 0;
        char caractere;

        do{
            caractere = senha.charAt(posicao);
            //aqui estamos usando a tabela ASCII para 
            //comprar com as letras maiúsculas
            //A é 65
            //Z é 90
            if (caractere >= 65 && caractere <= 90){
                qtde++;
            }
            posicao++;
        } while(posicao < senha.length());

        return qtde;
    }
}