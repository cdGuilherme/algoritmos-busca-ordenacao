// Para os algoritmos de comparação de desempenho de ordenação, vamos ter array1 e array2
// array1 vai ser o array principal que vai ser trocado a cada vez que os 3 algoritmos de ordenação nesse programa forem
// comparados, e array2 vai copiar array1 a cada vez que ele é ordenado por cada algoritmo para fazer uma comparação
// justa utilizando a mesma ordem de elementos

import java.util.Arrays;
import java.util.Random;

public class Desempenho {
    // Comparar algoritmos de busca
    public static long[] CompararBusca(int tamArray, int numComparacoes, boolean verElemento, boolean verIteracoes) {
        // totalResultados1: armazena os resultados do algoritmo de busca linear
        // totalResultados2: armazena os resultados do algoritmo de busca binária
        // totalResultadosN[0]: número total de iterações
        // totalResultadosN[1]: tempo total de execução em nanossegundos
        long[] totalResultados1 = new long[2];
        long[] totalResultados2 = new long[2];

        // Criando o array principal
        int[] array = new int[tamArray];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        for (int i = 1; i <= numComparacoes; i++) {
            Random r = new Random();
            int elementoAleatorio = r.nextInt(tamArray);

            if (verElemento)
                System.out.println("Procurando " + i + "º elemento: " + array[elementoAleatorio] + " com índice: " + elementoAleatorio + " nos algoritmos de busca.");

            // Executando o algoritmo de busca linear
            if (verIteracoes) System.out.print("Busca linear: ");
            long inicio = System.nanoTime();
            int[] resultadoLinear = Algoritmos.BuscaLinear(array, array[elementoAleatorio], verIteracoes);
            totalResultados1[0] += resultadoLinear[1];
            long fim = System.nanoTime();
            long tempoNs = fim - inicio; // Tempo em nanosegundo
            totalResultados1[1] += tempoNs;

            // Executando o algoritmo de busca binária
            if (verIteracoes) System.out.print("Busca binária: ");
            inicio = System.nanoTime();
            int[] resultadoBinaria = Algoritmos.BuscaBinaria(array, array[elementoAleatorio], verIteracoes);
            totalResultados2[0] += resultadoBinaria[1];
            fim = System.nanoTime();
            tempoNs = fim - inicio; // Tempo em nanosegundo
            totalResultados2[1] += tempoNs;
        }

        return new long[]{totalResultados1[0], totalResultados1[1], totalResultados2[0], totalResultados2[1]};
    }


    // Comparar algoritmos de ordenação
    public static long[] CompararOrdenacao(int tamArray, int numComparacoes, boolean verArrayComparado, boolean verResultados) {
        // totalResultados1: armazena os resultados do algoritmo de ordenação por troca
        // totalResultados2: armazena os resultados do algoritmo de ordenação por inserção
        // totalResultados3: armazena os resultados do algoritmo de ordenação por seleção
        // totalResultadosN[0]: número total de iterações
        // totalResultadosN[1]: número total de comparações
        // totalResultadosN[2]: número total de trocas
        // totalResultadosN[3]: tempo total de execução em nanossegundos
        long[] totalResultados1 = new long[4];
        long[] totalResultados2 = new long[4];
        long[] totalResultados3 = new long[4];

        for (int i = 1; i <= numComparacoes; i++) {
            // Criando o primeiro array principal
            int[] array1 = new int[tamArray];
            for (int j = 0; j < array1.length; j++) {
                array1[j] = j + 1;
            }

            // Embaralhando os elementos do primeiro array
            Algoritmos.EmbaralharArray(array1);

            if (verArrayComparado) {
                System.out.println(i + "º array utilizado para comparações: ");
                Algoritmos.ListarArray(array1, 2);
            }

            // Criando o segundo array que vai copiar o primeiro
            int[] array2 = Arrays.copyOf(array1, array1.length);

            // Executando o algoritmo de ordenação por troca e armazenando os resultados
            if (verResultados) System.out.print("Ordenação por troca: ");
            long inicio = System.nanoTime();
            long[] resultados1 = Algoritmos.OrdenacaoTroca(array2, 2, verResultados);
            long fim = System.nanoTime();
            long tempoNs = fim - inicio; // Tempo em nanosegundo
            totalResultados1[3] += tempoNs;
            // Desordenando o array2 conforme o array principal para a segunda comparação
            array2 = Arrays.copyOf(array1, array1.length);

            // Executando o algoritmo de ordenação por inserção e armazenando os resultados
            if (verResultados) System.out.print("Ordenação por inserção: ");
            inicio = System.nanoTime();
            long[] resultados2 = Algoritmos.OrdenacaoInsercao(array2, 2, verResultados);
            fim = System.nanoTime();
            tempoNs = fim - inicio; // Tempo em nanosegundo
            totalResultados2[3] += tempoNs;
            // Desordenando o array2 conforme o array principal para a segunda comparação
            array2 = Arrays.copyOf(array1, array1.length);

            // Executando o algoritmo de ordenação por seleção e armazenando os resultados
            if (verResultados) System.out.print("Ordenação por seleção: ");
            inicio = System.nanoTime();
            long[] resultados3 = Algoritmos.OrdenacaoSelecao(array2, 2, verResultados);
            fim = System.nanoTime();
            tempoNs = fim - inicio; // Tempo em nanosegundo
            totalResultados3[3] += tempoNs;

            // Armazenando a soma dos resultados
            totalResultados1[0] += resultados1[0];
            totalResultados1[1] += resultados1[1];
            totalResultados1[2] += resultados1[2];

            totalResultados2[0] += resultados2[0];
            totalResultados2[1] += resultados2[1];
            totalResultados2[2] += resultados2[2];

            totalResultados3[0] += resultados3[0];
            totalResultados3[1] += resultados3[1];
            totalResultados3[2] += resultados3[2];
        }

        return new long[]{totalResultados1[0], totalResultados1[1], totalResultados1[2], totalResultados1[3], totalResultados2[0], totalResultados2[1], totalResultados2[2], totalResultados2[3], totalResultados3[0], totalResultados3[1], totalResultados3[2], totalResultados3[3]};
    }
}
