/*
Aqui temos o código do jogo feito em nosso encontro.
Tente implementar a possibilidade do usuário escolher se quer jogar novamente ao término da partida. 
Se ele responder que sim, o jogo deve ser executado novamente dentro de um laco do tipo do { } while ( );
Depois que implementar o item anterior, tente criar um contador para contar quantas vezes o usuário ganho e quantas vezes o computador ganhou. 
Quando o usuário responder que não deseja mais jogar, apresente a quantidade de vitórias de cada, com a quantidade de vitórias e o % de vit órias. 
*/

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        int numeroSorteado;
        int escolhaComputador;
        int escolhaJogador;

        String resultado;

        boolean continuar = false;
        
        int vitoriaComputador = 0, vitoriaJogador = 0, totalJogadas = 0;

        do {
            // Inicia a rodada
            totalJogadas++;

            //sorteia um numero entre 1 e 90
            //estamos pedindo para sortear entre um intervalo 
            //maior para evitar um sorteio viciado
            numeroSorteado = random.nextInt(1,90);
    
            //aqui separamos em bloco de numeros em 3 partes
            //para nao termos um sorteio viciado
            if (numeroSorteado >= 61)
                escolhaComputador = 3;
            else if (numeroSorteado >= 31) 
                escolhaComputador = 2;
            else 
                escolhaComputador = 1;
            
            //papel = 1
            //pedra = 2
            //tesoura = 3

            //possibilidades de jogada
            //papel ganha de pedra
            //pedra ganha de tesoura
            //tesoura ganha de papel
            //empates

            System.out.println("=============== Pedra x Papel x Tesoura ================ ");
            System.out.println(" ============ RODADA " + totalJogadas + " ============");

            mostrarOpcoes();

            System.out.print("\nDigite uma das opções: ");
            escolhaJogador = teclado.nextInt();
    
            resultado = verificarResultado(escolhaComputador, escolhaJogador);

            System.out.println("\nComputador escolheu: " + devolveEscolha(escolhaComputador));
            System.out.println("Usuário escolheu: " + devolveEscolha(escolhaJogador));

            System.out.println("\nResultado: " + resultado);

            if(verificarGanhador(resultado).equals("Computador")) vitoriaComputador++;
            else if(verificarGanhador(resultado).equals("Jogador")) vitoriaJogador++;

            
            System.out.print("\nDeseja continuar (Digite s para sim): "); 
            String escolha = teclado.next();
            continuar = (escolha.equalsIgnoreCase("s"));

        } while (continuar);

        mostrarPlacar(vitoriaComputador, vitoriaJogador, totalJogadas);

        teclado.close();
    }  

    static void mostrarOpcoes(){
        System.out.println("\n1 - papel ");
        System.out.println("2 - pedra ");
        System.out.println("3 - tesoura ");
    }

    static String devolveEscolha(int escolha){
        switch (escolha) {
            case 1:
                return "papel";
            case 2:
                return "pedra";
            default:
                return "tesoura";
        }
    }

    static String verificarResultado(int escolhaComputador, int escolhaJogador){
        String resultado;
        //jogada entre papel e pedra
        if (escolhaComputador == 1 && escolhaJogador == 2) 
            resultado = "Computador ganhou";
        else if (escolhaComputador == 2 && escolhaJogador == 1)
            resultado = "Você ganhou";
        //jogada entre tesoura e pedra
        else if (escolhaComputador == 3 && escolhaJogador == 2) 
            resultado = "Você ganhou";
        else if (escolhaComputador == 2 && escolhaJogador == 3)
            resultado = "Computador ganhou";
        //joga entre papel e tesoura
        else if (escolhaComputador == 1 && escolhaJogador == 3) 
            resultado = "Você ganhou";
        else if (escolhaComputador == 3 && escolhaJogador == 1)
            resultado = "Computador ganhou";
        //qualquer outro resultado e empate
        else 
            resultado = "Empate";
    
        return resultado;
    }

    static String verificarGanhador(String resultado){
        String ganhador = "Empate";
        if(resultado.contains("Computador")) ganhador = "Computador";
        else if(resultado.contains("Você")) ganhador = "Jogador";

        return ganhador;
    }

    static void mostrarPlacar(int vitoriaComputador, int vitoriaJogador, int totalJogadas){
        float porcentagemJogador = (vitoriaJogador != 0) ? (float) vitoriaJogador/totalJogadas * 100: 0;
        float porcentagemComputador = (vitoriaComputador != 0) ? (float) vitoriaComputador/totalJogadas *100 : 0;

        System.out.println("============== PLACAR ============");
        System.out.println("Total de jogadas: "+ totalJogadas);
        System.out.printf("Vitórias do jogador: %d (%.2f", vitoriaJogador, porcentagemJogador);
        System.out.println("%)");
        System.out.printf("Vitórias do computador: %d (%.2f", vitoriaComputador, porcentagemComputador);
        System.out.println("%)");
    }
}

