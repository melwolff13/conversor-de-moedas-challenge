import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ConversorMoeda conversor = new ConversorMoeda();
        var dicionario = criaDicionario();

        while (true) {
            try {
                exibeMenu();
                var opcaoEscolhida = Integer.parseInt(scanner.nextLine());

                if (opcaoEscolhida < 0 || opcaoEscolhida > dicionario.size()) {
                    System.err.println("Erro: valor fora das opções válidas.\n");
                    continue;
                }
                if (opcaoEscolhida == 0) {
                    System.out.println("Programa finalizado.");
                    break;
                }

                var moedaBase = dicionario.get(opcaoEscolhida)[0];
                var moedaDestino = dicionario.get(opcaoEscolhida)[1];

                System.out.println("Digite o valor a ser convertido:");
                var valorInicial = Double.parseDouble(scanner.nextLine().replace(",", "."));

                if (valorInicial <= 0) {
                    System.err.println("Erro: o valor deve ser maior que 0\n");
                    continue;
                }

                var valorConvertido = conversor.converte(moedaBase, moedaDestino, valorInicial);
                System.out.println("\nValor " + valorInicial + " [" + moedaBase + "] corresponde a >>> " + valorConvertido + " [" + moedaDestino + "]\n");
            } catch (NumberFormatException e) {
                System.err.println("Erro: valor inválido\n");
            }
        }

    }

    private static void exibeMenu() {
        System.out.println("***************************************");
        System.out.println("BEM-VINDO(A) AO CONVERSOR DE MOEDA $-$\n");
        System.out.println("[1] Dólar -> Peso argentino");
        System.out.println("[2] Peso argentino -> Dólar");
        System.out.println("[3] Dólar -> Real brasileiro");
        System.out.println("[4] Real brasileiro -> Dólar");
        System.out.println("[5] Dólar -> Peso colombiano");
        System.out.println("[6] Peso colombiano -> Dólar");
        System.out.println("[0] Sair\n");
        System.out.println("Escolha uma opção válida:");
        System.out.println("***************************************");
    }

    private static Map<Integer, String[]> criaDicionario() {
        Map<Integer, String[]> dicionario = new HashMap<>();
        dicionario.put(1, new String[]{"USD", "ARS"});
        dicionario.put(2, new String[]{"ARS", "USD"});
        dicionario.put(3, new String[]{"USD", "BRL"});
        dicionario.put(4, new String[]{"BRL", "USD"});
        dicionario.put(5, new String[]{"USD", "COP"});
        dicionario.put(6, new String[]{"COP", "USD"});
        return dicionario;
    }
}
