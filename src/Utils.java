import java.util.Scanner;

public class Utils {
    // Funções úteis para a execução do programa //
    // ////////////////////////////////////////////


    // Pausa o programa até o usuário apertar <ENTER>
    public static void EsperarEnter() {
        Scanner s = new Scanner(System.in);
        System.out.print("Pressione <ENTER> para continuar...");
        s.nextLine();
    }


    // Exibe a quantidade de iterações que um programa realizou
    public static void PrintNumIteracoes(int num) {
        System.out.println("Operação concluída em " + num + " iterações.");
    }


    // Exibe a quantidade de iterações, comparações e trocas em uma mensagem só
    public static void PrintNumIteracoesComparacoesTrocas(long iteracoes, long comparacoes, long trocas) {
        System.out.println("Operação concluída em " + iteracoes + " iterações, " + comparacoes + " comparações e " + trocas + " trocas.");
    }


    // Exibe se o número foi encontrado ou não, e em qual posição foi encontrado
    public static void PrintNumeroIndex(int num, int index) {
        if (index == -1) System.out.println("Número " + num + " não foi encontrado no array.");
        else System.out.println("Número " + num + " foi encontrado na posição " + index + " do array.");
    }


    // Troca 2 elementos de posição em um array com base em seus index
    public static void TrocarElementos(int[] array, int idx1, int idx2) {
        int aux = array[idx1]; // Variável auxiliar para guardar a informação a ser trocada
        array[idx1] = array[idx2];
        array[idx2] = aux;
    }


    // Exibindo o tempo de execução de um programa
    public static void ExibirTempo(long tempoNs) {
        // %.2f = Exibe um float/double com 2 casas decimais
        // %n = Quebra de linha
        if (tempoNs < 1_000) {
            System.out.println("Operação realizada em " + tempoNs + " nanossegundos.");
        } else if (tempoNs < 1_000_000) {
            double tempoUs = tempoNs / 1_000.0;
            System.out.printf("Operação realizada em %.2f microssegundos.%n", tempoUs);
        } else if (tempoNs < 1_000_000_000L) {
            double tempoMs = tempoNs / 1_000_000.0;
            System.out.printf("Operação realizada em %.2f milissegundos.%n", tempoMs);
        } else {
            double tempoS = tempoNs / 1_000_000_000.0;
            System.out.printf("Operação realizada em %.2f segundos.%n", tempoS);
        }
    }

    // Exibindo o tempo de execução resumido
    public static String ExibirTempoResumido(long tempoNs) {
        if (tempoNs < 1_000) {
            return tempoNs + " nanossegundos";
        } else if (tempoNs < 1_000_000) {
            double tempoUs = tempoNs / 1_000.0;
            tempoUs = Math.floor(tempoUs * 100) / 100;
            return tempoUs + " microssegundos";
        } else if (tempoNs < 1_000_000_000L) {
            double tempoMs = tempoNs / 1_000_000.0;
            tempoMs = Math.floor(tempoMs * 100) / 100;
            return tempoMs + " milissegundos";
        } else {
            double tempoS = tempoNs / 1_000_000_000.0;
            tempoS = Math.floor(tempoS * 100) / 100;
            return tempoS + " segundos";
        }
    }

    public static void LimparConsole() {
        try {
            String sistema = System.getProperty("os.name").toLowerCase();

            if (sistema.contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Não faz nada caso não seja possível limpar o console.
        }
    }
}