// # Algoritmos de Busca e Ordenação v1.0.0
//
// ## Avisos!
//
// 1. Para os algoritmos de ordenação, este programa permite que você visualize o array a cada troca realizada, porém,
// isso adiciona um custo adicional de percorrer todos os elementos e formatar a visualização adequada para o console.
// Isso acaba adicionando um custo computacional maior de O(n) em notação Big O a cada troca realizada, e isso pode
// comprometer nos resultados de desempenho ao levar mais tempo de execução do que não exibir o array a cada iteração.
// Utilize esta opção caso queira ver o funcionamento do algoritmo passo a passo a cada troca realizada, e se quiser
// medir o tempo de execução dele, execute sem a visualização.
//
// 2. O tempo de execução pode variar a depender de vários fatores,
// então para obter uma média concreta do tempo de execução de cada algoritmo,
// é recomendado que você execute o algoritmo várias vezes para montar uma média de execução.

import java.util.Scanner;

void main() {
    Utils.LimparConsole();
    Scanner s = new Scanner(System.in);

    // Criando o array que será utilizado nos algoritmos de busca e ordenação e preenchendo com números automaticamente
    int[] array = new int[100];
    for (int i = 0; i < array.length; i++) {
        array[i] = i + 1;
    }

    // Variáveis de input do usuário
    int opcao;
    int input;

    // Variável que controla se o array está desordenado ou não
    boolean arrayOrdenado = Algoritmos.VerificarOrdenacao(array);

    System.out.println("<< Busca e Ordenação >>");

    // Início do programa
    do {
        System.out.println("\nSelecione uma opção:");
        System.out.println("1 - Listar elementos do array");
        System.out.println("2 - Busca Linear");
        System.out.println("3 - Busca Binária");
        System.out.println("4 - Embaralhar Array");
        System.out.println("5 - Ordenação por Troca");
        System.out.println("6 - Ordenação por Inserção");
        System.out.println("7 - Ordenação por Seleção");
        System.out.println("8 - Verificar Ordenação");
        System.out.println("9 - Comparar Algoritmos");
        System.out.println("0 - Sair");

        System.out.print("Selecione uma opção: ");
        opcao = s.nextInt();

        switch (opcao) {
            // Listando todos os elementos do array
            case 1 -> {
                System.out.println("\nExibir o array com quebra de linhas?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                System.out.print("Sua escolha: ");
                input = s.nextInt();
                System.out.println();
                Algoritmos.ListarArray(array, input);
                Utils.EsperarEnter();
            }


            // Algoritmo de Busca Linear
            case 2 -> {
                // Input do usuário, qual número ele deseja buscar
                System.out.print("\nDigite o número que você quer procurar: ");
                input = s.nextInt();

                // Chamando o algoritmo de busca e medindo o tempo de execução
                long inicio = System.nanoTime();
                int[] resultado = Algoritmos.BuscaLinear(array, input, true);
                int index = resultado[0];
                long fim = System.nanoTime();
                long tempoNs = fim - inicio; // Tempo em nanosegundo
                Utils.PrintNumeroIndex(input, index);
                Utils.ExibirTempo(tempoNs);
                Utils.EsperarEnter();
            }


            // Algoritmo de Busca Binária
            case 3 -> {
                if (arrayOrdenado) {
                    // Input do usuário, qual número ele deseja buscar
                    System.out.print("\nDigite o número que você quer procurar: ");
                    input = s.nextInt();

                    // Chamando o algoritmo de busca e medindo o tempo de execução
                    long inicio = System.nanoTime();
                    int[] resultado = Algoritmos.BuscaBinaria(array, input, true);
                    int index = resultado[0];
                    long fim = System.nanoTime();
                    long tempoNs = fim - inicio; // Tempo em nanosegundo
                    Utils.PrintNumeroIndex(input, index);
                    Utils.ExibirTempo(tempoNs);
                } else {
                    System.out.println("\nErro! Você precisa primeiro ordenar o array antes de realizar uma busca binária");
                }
                Utils.EsperarEnter();
            }


            // Algoritmo de embaralhar o array utilizando Fisher-Yates
            case 4 -> {
                // Chamando o algoritmo de embaralhar o array e medindo o tempo de execução
                long inicio = System.nanoTime();
                Algoritmos.EmbaralharArray(array);
                long fim = System.nanoTime();
                long tempoNs = fim - inicio; // Tempo em nanosegundo

                arrayOrdenado = Algoritmos.VerificarOrdenacao(array);

                if (arrayOrdenado) {
                    System.out.println("\nNão foi possível embaralhar o array!");
                } else {
                    System.out.println("\nArray embaralhado com sucesso!");
                }

                Utils.ExibirTempo(tempoNs);
                Utils.EsperarEnter();
            }


            // Algoritmo de Ordenação por Troca
            case 5 -> {
                // Pergunta caso queira ver cada troca do array
                System.out.println("\nGostaria de ver o array a cada troca?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                System.out.print("Sua escolha: ");
                input = s.nextInt();
                System.out.println();

                // Chamando o algoritmo de ordenação e medindo o tempo de execução
                long inicio = System.nanoTime();
                Algoritmos.OrdenacaoTroca(array, input, true);
                long fim = System.nanoTime();
                long tempoNs = fim - inicio; // Tempo em nanosegundo

                // Fim do algoritmo
                arrayOrdenado = Algoritmos.VerificarOrdenacao(array);

                if (arrayOrdenado) {
                    System.out.println("Array ordenado com sucesso!");
                } else {
                    System.out.println("Não foi possível ordenar o array!");
                }

                Utils.ExibirTempo(tempoNs);
                Utils.EsperarEnter();
            }


            // Algoritmo de Ordenação por Inserção
            case 6 -> {
                // Pergunta caso queira ver cada troca do array
                System.out.println("\nGostaria de ver o array a cada troca?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                System.out.print("Sua escolha: ");
                input = s.nextInt();
                System.out.println();

                // Chamando o algoritmo de ordenação e medindo o tempo de execução
                long inicio = System.nanoTime();
                Algoritmos.OrdenacaoInsercao(array, input, true);
                long fim = System.nanoTime();
                long tempoNs = fim - inicio; // Tempo em nanosegundo

                // Fim do algoritmo
                arrayOrdenado = Algoritmos.VerificarOrdenacao(array);

                if (arrayOrdenado) {
                    System.out.println("Array ordenado com sucesso!");
                } else {
                    System.out.println("Não foi possível ordenar o array!");
                }

                Utils.ExibirTempo(tempoNs);
                Utils.EsperarEnter();
            }


            // Algoritmo de Ordenação por Seleção
            case 7 -> {
                // Pergunta caso queira ver cada troca do array
                System.out.println("\nGostaria de ver o array a cada troca?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não");
                System.out.print("Sua escolha: ");
                input = s.nextInt();
                System.out.println();

                // Chamando o algoritmo de ordenação e medindo o tempo de execução
                long inicio = System.nanoTime();
                Algoritmos.OrdenacaoSelecao(array, input, true);
                long fim = System.nanoTime();
                long tempoNs = fim - inicio; // Tempo em nanosegundo

                // Fim do algoritmo
                arrayOrdenado = Algoritmos.VerificarOrdenacao(array);

                if (arrayOrdenado) {
                    System.out.println("Array ordenado com sucesso!");
                } else {
                    System.out.println("Não foi possível ordenar o array!");
                }

                Utils.ExibirTempo(tempoNs);
                Utils.EsperarEnter();
            }

            // Verifica se o array está ordenado ou não
            case 8 -> {
                // Chamando o algoritmo de verificação de ordenação e medindo o tempo de execução
                long inicio = System.nanoTime();
                arrayOrdenado = Algoritmos.VerificarOrdenacao(array);
                long fim = System.nanoTime();
                long tempoNs = fim - inicio; // Tempo em nanosegundo

                if (arrayOrdenado) {
                    System.out.println("\nO array está ordenado.");
                } else {
                    System.out.println("\nO array não está ordenado.");
                }

                Utils.ExibirTempo(tempoNs);
                Utils.EsperarEnter();
            }

            // Comparação de desempenho de algoritmos
            case 9 -> {
                // Selecione qual tipo de algoritmo você quer comparar o desempenho
                System.out.println("\nSelecione qual tipo de algoritmo você quer comparar o desempenho:");
                System.out.println("1 - Algoritmos de Busca");
                System.out.println("2 - Algoritmos de Ordenação");
                System.out.print("Sua escolha: ");
                input = s.nextInt();
                System.out.println();
                int algoritmo = input;

                boolean verElemento = false;
                boolean verIteracoes = false;
                boolean verArrayComparado = false;
                boolean verResultados = false;
                if (input == 1) {
                    // Algoritmos de Busca
                    // Pergunta caso queira ver o elemento sendo procurado no array para cada algoritmo
                    System.out.println("Gostaria de ver qual elemento está sendo procurado para cada algoritmo?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    System.out.print("Sua escolha: ");
                    input = s.nextInt();
                    System.out.println();
                    if (input == 1)
                        verElemento = true;

                    // Pergunta caso queira ver o elemento sendo procurado no array para cada algoritmo
                    System.out.println("Gostaria de ver o número de iterações para cada algoritmo?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    System.out.print("Sua escolha: ");
                    input = s.nextInt();
                    System.out.println();
                    if (input == 1)
                        verIteracoes = true;

                } else {
                    // Algoritmos de Ordenação
                    // Pergunta caso queira ver o array a ser comparado para cada algoritmo
                    System.out.println("Gostaria de ver o array sendo comparado para cada algoritmo?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    System.out.print("Sua escolha: ");
                    input = s.nextInt();
                    System.out.println();
                    if (input == 1)
                        verArrayComparado = true;

                    // Pergunta caso queira ver o array a ser comparado para cada algoritmo
                    System.out.println("Gostaria de ver o resultado individual de cada algoritmo para cada array?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    System.out.print("Sua escolha: ");
                    input = s.nextInt();
                    System.out.println();
                    if (input == 1)
                        verResultados = true;
                }

                // Selecione o tamanho do array para as comparações
                System.out.print("Selecione o tamanho do array para as comparações: ");
                input = s.nextInt();
                int tamArray = input;

                // Selecione quantas vezes você quer fazer a comparação
                System.out.print("Selecione quantas vezes você quer fazer a comparação: ");
                input = s.nextInt();
                System.out.println();
                int numComparacoes = input;

                if (algoritmo == 1) {
                    // Comparando algoritmos de busca
                    System.out.println("Comparando algoritmos de busca " + numComparacoes + " vezes com arrays de " + tamArray + " elementos...");
                    long[] resultados = Desempenho.CompararBusca(tamArray, numComparacoes, verElemento, verIteracoes);

                    System.out.println("\nResultados dos testes em " + numComparacoes + " arrays de " + tamArray + " elementos cada um:");

                    // Resultados do algoritmo de busca linear
                    System.out.println("\nAlgoritmo de busca linear: ");
                    System.out.println("Total de iterações: " + resultados[0]);
                    System.out.println("Total de tempo de execução: " + Utils.ExibirTempoResumido(resultados[1]));
                    System.out.println("Quantidade média de iterações: " + resultados[0] / numComparacoes);
                    System.out.println("Tempo médio de execução: " + Utils.ExibirTempoResumido(resultados[1] / numComparacoes));

                    // Resultados do algoritmo de busca binária
                    System.out.println("\nAlgoritmo de busca binária: ");
                    System.out.println("Total de iterações: " + resultados[2]);
                    System.out.println("Total de tempo de execução: " + Utils.ExibirTempoResumido(resultados[3]));
                    System.out.println("Quantidade média de iterações: " + resultados[2] / numComparacoes);
                    System.out.println("Tempo médio de execução: " + Utils.ExibirTempoResumido(resultados[3] / numComparacoes));

                } else {
                    // Comparando algoritmos de ordenação
                    System.out.println("Comparando algoritmos de ordenação " + numComparacoes + " vezes com arrays de " + tamArray + " elementos...");
                    long[] resultados = Desempenho.CompararOrdenacao(tamArray, numComparacoes, verArrayComparado, verResultados);

                    System.out.println("\nResultados dos testes em " + numComparacoes + " arrays de " + tamArray + " elementos cada um:");

                    // Resultados do algoritmo de ordenação por troca
                    System.out.println("\nAlgoritmo de ordenação por troca: ");
                    System.out.println("Total de iterações: " + resultados[0]);
                    System.out.println("Total de comparações: " + resultados[1]);
                    System.out.println("Total de trocas: " + resultados[2]);
                    System.out.println("Total de tempo de execução: " + Utils.ExibirTempoResumido(resultados[3]));
                    System.out.println("Quantidade média de iterações: " + resultados[0] / numComparacoes);
                    System.out.println("Quantidade média de comparações: " + resultados[1] / numComparacoes);
                    System.out.println("Quantidade média de trocas: " + resultados[2] / numComparacoes);
                    System.out.println("Tempo médio de execução: " + Utils.ExibirTempoResumido(resultados[3] / numComparacoes));

                    // Resultados do algoritmo de ordenação por inserção
                    System.out.println("\nAlgoritmo de ordenação por inserção: ");
                    System.out.println("Total de iterações: " + resultados[4]);
                    System.out.println("Total de comparações: " + resultados[5]);
                    System.out.println("Total de trocas: " + resultados[6]);
                    System.out.println("Total de tempo de execução: " + Utils.ExibirTempoResumido(resultados[7]));
                    System.out.println("Quantidade média de iterações: " + resultados[4] / numComparacoes);
                    System.out.println("Quantidade média de comparações: " + resultados[5] / numComparacoes);
                    System.out.println("Quantidade média de trocas: " + resultados[6] / numComparacoes);
                    System.out.println("Tempo médio de execução: " + Utils.ExibirTempoResumido(resultados[7] / numComparacoes));

                    // Resultados do algoritmo de ordenação por seleção
                    System.out.println("\nAlgoritmo de ordenação por seleção: ");
                    System.out.println("Total de iterações: " + resultados[8]);
                    System.out.println("Total de comparações: " + resultados[9]);
                    System.out.println("Total de trocas: " + resultados[10]);
                    System.out.println("Total de tempo de execução: " + Utils.ExibirTempoResumido(resultados[11]));
                    System.out.println("Quantidade média de iterações: " + resultados[8] / numComparacoes);
                    System.out.println("Quantidade média de comparações: " + resultados[9] / numComparacoes);
                    System.out.println("Quantidade média de trocas: " + resultados[10] / numComparacoes);
                    System.out.println("Tempo médio de execução: " + Utils.ExibirTempoResumido(resultados[11] / numComparacoes));
                }

                System.out.println();
                Utils.EsperarEnter();
            }

            case 0 -> {
            }
            default -> {
                System.out.println("\nOpção inválida!");
                Utils.EsperarEnter();
            }
        }
        Utils.LimparConsole();
    } while (opcao != 0);
}