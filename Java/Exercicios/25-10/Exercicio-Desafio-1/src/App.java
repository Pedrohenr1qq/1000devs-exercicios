/*
O código abaixo recebe um nome completo de uma pessoa e interage com cada palavra deste nome. 
Você deve fazer com que o nome e os sobrenomes sejam convertidos para a primeira letra em maiúsculo.
Ou seja, se o nome fornecido for:
    rogerio de freitas ribeiro

O resultado deverá ser:
    Rogério de Freitas Ribeiro

Note que os conectores do, da e outros não devem ser convertidos para maíusculos.

do - utilizado para indicar posse ou origem, como em "João do Brasil".
da - similar ao "do", mas usado com nomes femininos, como em "Maria da Silva".
de - usado para indicar origem ou pertencimento, como em "Carlos de Souza".
e - usado para ligar dois nomes, como em "Ana e Costa e Silva".
dos - forma plural de "do", como em "André dos Santos".
das - forma plural de "da", como em "Lúcia das Dores". 
*/

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String nome, subNome= "", nomePadrao = "";
        Scanner teclado = new Scanner(System.in);
        int posicaoAtual = 0;
        int posicaoAnterior = 0;
        int tamanhoNome;
        
        System.out.print("Digite o seu nome completo: ");
        nome = teclado.nextLine();
        tamanhoNome = nome.length();

        do {
            posicaoAtual = nome.indexOf(" ", posicaoAnterior);

            //para evitar erro quando estiver extraindo o ultimo sobrenome
            if (posicaoAtual == -1){
                posicaoAtual = tamanhoNome;  
            }
            subNome = nome.substring(posicaoAnterior, posicaoAtual);
            if(!subNome.equals("do") && !subNome.equals("da") && !subNome.equals("de") && !subNome.equals("e") && !subNome.equals("dos") && !subNome.equals("das")){
                subNome = capitalizate(subNome);
            }
            nomePadrao += subNome+" ";
            posicaoAnterior = posicaoAtual + 1;

        } while (posicaoAtual <  tamanhoNome);

        System.out.println(nomePadrao);
        teclado.close();
    }

    public static String capitalizate(String subnome){
        String primeiraLetra, restoNome;

        primeiraLetra = subnome.substring(0, 1);
        restoNome = subnome.substring(1, subnome.length());

        return primeiraLetra.toUpperCase() + restoNome;
    }
}