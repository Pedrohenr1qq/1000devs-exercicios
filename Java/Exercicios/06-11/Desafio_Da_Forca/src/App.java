/*

Com base neste código termine a implementação do jogo da forca.

Tente primeiramente implementar os itens descados na ordem TODO 01, 02, 03, 04.

Depois de implementar estes itens, tente implementar a possibilidade do usuário escolher após o termino do jogo, se ele deseja jogar novamente. 
Se a resposta for sim, executa o jogo novamente, se a resposta for não encerra o jogo. 
Para isto, utilize um novo: do { } while(); para repetir todo o código enquanto o usuário respoder que sim.
 */

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);

            int vidasRestantes = 6;
            String letrasCertas = "";
            String letrasTentadas = "";
            char letraChutada;
            boolean letraJaChutada = false;

            String palavra = "treme";

            //contagem de vidas
            do {
                System.out.println("\n\nVidas Restantes: " + vidasRestantes);
                System.out.println("Letras já Tentadas: " + letrasTentadas + "\n");

                exibeForca(vidasRestantes);
                exibePalavraTela(palavra, letrasCertas);

                System.out.println("\n\n");

                do {
                    letraJaChutada = false;
                    System.out.print("\nDigite uma letra: ");

                    letraChutada = teclado.nextLine().toLowerCase().charAt(0);
                    letraJaChutada = (letrasTentadas.indexOf(letraChutada) != -1);
                    
                    if(letraJaChutada) System.out.println("Essa letra ja foi chutada. Tente novamente.");

                } while (letraJaChutada); 

                
                //atualiza a lista de letras tentadas
                letrasTentadas += letraChutada;

                //atualiza a lista de letras certas
                if (acertouLetra(palavra, letraChutada))
                    letrasCertas += letraChutada;
                else 
                    //tira uma vida
                    vidasRestantes--;
                
                exibePalavraTela(palavra, letrasCertas);
                
                if (acertouPalavra(palavra, letrasCertas)) break;
                
                System.out.println();
            } while (vidasRestantes > 0);

            System.out.println("\n\n");

            if(vidasRestantes > 0) System.out.println("Parabéns, você ganhou o jogo");
            else{
                System.out.println("------ GAME OVER! -------");
                exibeForca(0);
            }

            teclado.close();
    }
          
    static boolean acertouLetra(String palavra, char letraChutada){
        return palavra.contains(Character.toString(letraChutada));
    }

    static void exibePalavraTela(String palavraSecreta, String letrasCertas){
        char letra;
        System.out.println("\n\n");

        for (int posicaoLetra = 0; posicaoLetra < palavraSecreta.length(); posicaoLetra++) {
            letra = palavraSecreta.charAt(posicaoLetra);

            if (letrasCertas.contains(Character.toString(letra))) {
                System.out.print("  _" + letra + "_  ");
            } else {
                System.out.print("  ____  ");
            }
        }
    }

    static boolean acertouPalavra(String palavracerta, String letrasCertas){
        boolean acertou = true;
        for(int i = 0; i < palavracerta.length(); i++){
            acertou = letrasCertas.contains(Character.toString(palavracerta.charAt(i)));
            if(!acertou) break;
        }
        System.out.println("Acertou: "+ acertou);

        return acertou;
    }

    static void exibeForca(int contagemErro){
        switch (contagemErro) {
            case 6:
                System.out.println("""        
                        +---+
                        |   |
                            |
                            |
                            |
                            |
                    ========= """);
                break;
            case 5:
                System.out.println("""        
                        +---+
                        |   |
                        O   |
                            |
                            |
                            |
                    ========= """);
                break;
            case 4:
                System.out.println("""        
                        +---+
                        |   |
                        O   |
                        |   |
                            |
                            |
                    ========= """);
                break;
            case 3:
                System.out.println("""        
                        +---+
                        |   |
                        O   |
                       /|   |
                            |
                            |
                    =========""");
                break;
            case 2:
                System.out.println("""        
                        +---+
                        |   |
                        O   |
                       /|\\  |
                            |
                            |
                    =========""");
                break;
            case 1:
                System.out.println("""        
                        +---+
                        |   |
                        O   |
                       /|\\  |
                       /    |
                            |
                    =========""");
                break;
            case 0:
                System.out.println("""
                        +---+
                        |   |
                        O   |
                       /|\\  |
                       / \\  |
                            |
                    ========= """);
                break;
            //TODO 01: implemente aqui o desenho da forca quando a 
            //qtde de vidas restantes for 5, 4, 3, 2, 1
            default:
                break;
        }
    }


           

           

           

          
            
}
