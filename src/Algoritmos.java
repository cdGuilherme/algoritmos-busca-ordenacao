import java.util.Random;

public class Algoritmos {
    // Funções de algoritmos de busca e ordenação //
    // /////////////////////////////////////////////


    // Listar elementos do array
    public static void ListarArray(int[] array, int input) {
        // Esta variável pergunta se você quer quebrar linhas ao exibir o array
        boolean quebrarLinha = false;
        // Esta variável define após quantos elementos deve-se quebrar linha
        int qtdElementosQuebrarLinha = 10;

        if (input == 1) quebrarLinha = true;

        System.out.print("int array[] = {");
        if (quebrarLinha) {
            // Exibindo o array com a formatação de quebrar linhas
            for (int i = 0; i < array.length; i++) {
                if (i % qtdElementosQuebrarLinha == 0) System.out.print("\n    ");

                if (i == array.length - 1) System.out.print(array[i]);
                else System.out.print(array[i] + ", ");
            }
            System.out.println("\n};");
        } else {
            // Exibindo o array usando apenas uma linha
            for (int i = 0; i < array.length; i++) {
                if (i == array.length - 1) System.out.print(array[i]);
                else System.out.print(array[i] + ", ");
            }
            System.out.println("};");
        }
    }


    // Algoritmo de Busca Linear
    // https://www.geeksforgeeks.org/dsa/linear-search/
    public static int[] BuscaLinear(int[] array, int num, boolean exibirIteracoes) {
        // Este algoritmo procura o elemento visitando linearmente do começo ao fim do array até encontrar
        // o número que está sendo procurado. Ele possui uma complexidade de O(n) em notação Big O

        int iteracoes = 0;

        int i;
        for (i = 0; i < array.length; i++) {
            iteracoes++;

            if (array[i] == num) {
                if (exibirIteracoes)
                    Utils.PrintNumIteracoes(iteracoes);

                return new int[]{i, iteracoes};
            }
        }

        if (exibirIteracoes)
            Utils.PrintNumIteracoes(iteracoes);

        return new int[]{-1, iteracoes};
    }


    // Algoritmo de Busca Binária
    // https://www.geeksforgeeks.org/dsa/binary-search/
    public static int[] BuscaBinaria(int[] array, int num, boolean exibirIteracoes) {
        // O algoritmo de busca binária procura o elemento definindo um ponto baixo e um ponto alto, e depois verifica
        // se o meio desses 2 pontos corresponde ao elemento que está sendo procurado. Caso encontrado, basta retornar
        // o index no qual foi encontrado, caso contrário, verifica se este meio é maior ou menor que o elemento que
        // está sendo procurado, e ajusta o ponto baixo ou alto de acordo com essa resposta para fazer mais uma
        // verificação. Para este algoritmo funcionar corretamente, o array deve estar obrigatoriamente ordenado.
        // A complexidade desse algoritmo é de O(log N) em notação Big O

        int iteracoes = 0;

        int baixo = 0;
        int alto = array.length - 1;

        while (baixo <= alto) {
            iteracoes++;

            int meio = baixo + (alto - baixo) / 2;

            // Elemento encontrado no meio
            if (array[meio] == num) {
                if (exibirIteracoes)
                    Utils.PrintNumIteracoes(iteracoes);

                return new int[]{meio, iteracoes};
            }

            if (array[meio] < num)
                // Se o número é maior, ignore a metade à esquerda
                baixo = meio + 1;
            else
                // Se o número é menor, ignore a metade à direita
                alto = meio - 1;
        }

        if (exibirIteracoes)
            Utils.PrintNumIteracoes(iteracoes);
        return new int[]{-1, iteracoes};
    }


    // Algoritmo de embaralhar o array utilizando Fisher-Yates
    // How to shuffle an array (Fisher-Yates algorithm) - Inside code: https://www.youtube.com/watch?v=4zx5bM2OcvA
    public static void EmbaralharArray(int[] array) {
        Random r = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);

            // Trocando o elemento
            Utils.TrocarElementos(array, i, j);
        }
    }


    // Algoritmo de Ordenação por Troca
    // Ordenação de bolhas em 2 minutos: https://www.youtube.com/watch?v=xli_FI7CuzA
    public static long[] OrdenacaoTroca(int[] array, int input, boolean exibirResultados) {
        // Bubble sort compara 2 elementos de uma vez, se eles estiverem fora de ordem, uma troca é realizada
        // O maior número vai ser movido para a direita a cada iteração. Uma partição ordenada irá formar no final
        // do array. A complexidade desse algoritmo em notação Big O é de O(n^2)

        boolean exibirTrocas = false;
        if (input == 1) exibirTrocas = true;

        if (exibirTrocas) {
            System.out.print("0: ");
            ListarArray(array, 2);
        }

        long iteracoes = 0;
        long comparacoes = 0;
        long trocas = 0;

        // Laço externo
        for (int i = 1; i < array.length; i++) {
            iteracoes++;
            boolean houveTroca = false;

            // Laço interno
            for (int j = 0; j < array.length - i; j++) {
                iteracoes++;
                comparacoes++;

                // Condição de troca
                if (array[j] > array[j + 1]) {

                    // Trocando o elemento
                    Utils.TrocarElementos(array, j, j + 1);

                    houveTroca = true;
                    trocas++;

                    if (exibirTrocas) {
                        System.out.print(trocas + ": ");
                        ListarArray(array, 2);
                    }
                }
            }

            // Interrupção antecipada
            if (!houveTroca) break;
        }
        if (exibirResultados)
            Utils.PrintNumIteracoesComparacoesTrocas(iteracoes, comparacoes, trocas);
        return new long[]{iteracoes, comparacoes, trocas};
    }


    // Algoritmo de Ordenação por Inserção
    // Ordenação por inserção em 2 minutos: https://www.youtube.com/watch?v=JU767SDMDvA
    public static long[] OrdenacaoInsercao(int[] array, int input, boolean exibirResultados) {
        // Começa pelo index 1 e executa o loop até o último elemento do array, cada iteração verifica todos os itens à
        // esquerda e insere o elemento selecionado na posição correta, movendo apenas um ou vários elementos para isso.
        // A complexidade em Big O desse algoritmo é de O(n^2)

        boolean exibirTrocas = false;
        if (input == 1) exibirTrocas = true;

        if (exibirTrocas) {
            System.out.print("0: ");
            ListarArray(array, 2);
        }

        long iteracoes = 0;
        long comparacoes = 0;
        long trocas = 0;

        for (int i = 1; i < array.length; i++) {
            iteracoes++;
            int j = i;

            /*
            // Versão resumida da comparação
            while (j > 0 && array[j - 1] > array[j]) {
                Utils.TrocarElementos(array, j, j - 1);
                j--;
                trocas++;
            }
             */

            while (j > 0) {
                iteracoes++;
                comparacoes++;
                if (array[j - 1] > array[j]) {
                    Utils.TrocarElementos(array, j, j - 1);
                    j--;

                    trocas++;
                    if (exibirTrocas) {
                        System.out.print(trocas + ": ");
                        ListarArray(array, 2);
                    }
                } else {
                    break;
                }
            }
        }
        if (exibirResultados)
            Utils.PrintNumIteracoesComparacoesTrocas(iteracoes, comparacoes, trocas);
        return new long[]{iteracoes, comparacoes, trocas};
    }


    // Algoritmo de Ordenação por Seleção
    // Seleção de ordenação em 3 minutos: https://www.youtube.com/watch?v=g-PGLbMth_g
    public static long[] OrdenacaoSelecao(int[] array, int input, boolean exibirResultados) {
        // A cada iteração do algoritmo de ordenação por seleção é selecionado o menor elemento da parte não ordenada e
        // esse elemento é movido para a parte ordenada. A complexidade em Big O desse algoritmo é de O(n^2)

        boolean exibirTrocas = false;
        if (input == 1) exibirTrocas = true;

        if (exibirTrocas) {
            System.out.print("0: ");
            ListarArray(array, 2);
        }

        long iteracoes = 0;
        long comparacoes = 0;
        long trocas = 0;

        // Laço externo
        for (int j = 0; j < array.length - 1; j++) {
            iteracoes++;

            // Variável iMin guarda o índice do menor elemento já encontrado
            int iMin = j;

            // Laço interno
            for (int i = j + 1; i < array.length; i++) {
                iteracoes++;
                comparacoes++;

                // Procurando um elemento menor do que o menor já conhecido
                if (array[i] < array[iMin]) {
                    iMin = i;
                }
            }

            // Condição de troca
            if (iMin != j) {

                // Trocando o elemento
                Utils.TrocarElementos(array, j, iMin);

                trocas++;
                if (exibirTrocas) {
                    System.out.print(trocas + ": ");
                    ListarArray(array, 2);
                }
            }
        }
        if (exibirResultados)
            Utils.PrintNumIteracoesComparacoesTrocas(iteracoes, comparacoes, trocas);
        return new long[]{iteracoes, comparacoes, trocas};
    }


    // Verifica se o array está ordenado ou não
    public static boolean VerificarOrdenacao(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}