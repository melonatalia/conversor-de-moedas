import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorDeMoedas {

    // 🔑 Sua chave da API (ExtendedRate)
    private static final String API_KEY = System.getenv("EXCHANGE_API_KEY");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("=== 💱 Conversor de Moedas ===");

        while (continuar) {
            try {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1. Dólar (USD) -> Real (BRL)");
                System.out.println("2. Real (BRL) -> Dólar (USD)");
                System.out.println("3. Euro (EUR) -> Real (BRL)");
                System.out.println("4. Real (BRL) -> Euro (EUR)");
                System.out.println("5. Libra (GBP) -> Dólar (USD)");
                System.out.println("6. Dólar (USD) -> Peso Argentino (ARS)");
                System.out.println("0. Sair");
                System.out.print("Opção: ");

                int opcao = scanner.nextInt();

                if (opcao == 0) {
                    continuar = false;
                    System.out.println("👋 Encerrando o programa. Obrigado por usar o conversor!");
                    break;
                }

                System.out.print("Digite o valor a converter: ");
                double valor = scanner.nextDouble();

                String from = "";
                String to = "";

                switch (opcao) {
                    case 1 -> { from = "USD"; to = "BRL"; }
                    case 2 -> { from = "BRL"; to = "USD"; }
                    case 3 -> { from = "EUR"; to = "BRL"; }
                    case 4 -> { from = "BRL"; to = "EUR"; }
                    case 5 -> { from = "GBP"; to = "USD"; }
                    case 6 -> { from = "USD"; to = "ARS"; }
                    default -> {
                        System.out.println("⚠️ Opção inválida. Tente novamente.");
                        continue;
                    }
                }

                double taxa = obterTaxaCambio(from, to);
                double convertido = valor * taxa;

                System.out.printf("💹 Taxa atual de %s -> %s: %.4f%n", from, to, taxa);
                System.out.printf("💰 %.2f %s equivalem a %.2f %s%n", valor, from, convertido, to);

            } catch (InputMismatchException e) {
                System.out.println("⚠️ Entrada inválida. Digite apenas números.");
                scanner.nextLine(); // limpa buffer
            } catch (Exception e) {
                System.out.println("❌ Erro ao obter cotação: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static double obterTaxaCambio(String from, String to) throws Exception {
        // 🔗 Endpoint da API ExtendedRate (usando a API key)
        String urlStr = String.format(
                "https://v6.exchangerate-api.com/v6/%s/latest/%s",
                API_KEY, from
        );

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Erro na conexão: " + conn.getResponseCode());
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder resposta = new StringBuilder();
        String linha;
        while ((linha = reader.readLine()) != null) {
            resposta.append(linha);
        }
        reader.close();

        String json = resposta.toString();

        // 👇 Extração simples da taxa (sem bibliotecas externas)
        String busca = "\"" + to + "\":";
        int inicio = json.indexOf(busca);
        if (inicio == -1) {
            throw new RuntimeException("Moeda não encontrada na resposta da API.");
        }
        int fim = json.indexOf(",", inicio);
        if (fim == -1) fim = json.indexOf("}", inicio);
        String valorStr = json.substring(inicio + busca.length(), fim);

        return Double.parseDouble(valorStr);
    }
}
