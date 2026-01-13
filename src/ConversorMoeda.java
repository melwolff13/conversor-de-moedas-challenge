import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoeda {
    private static final String API_KEY = obterApiKey();
    private final HttpClient cliente;
    private final Gson gson;

    public ConversorMoeda() {
        this.cliente = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    private static String obterApiKey() {
        String api_key = System.getenv("EXCHANGE_RATE_API_KEY");

        if (api_key == null || api_key.isEmpty()) {
            System.err.println("Erro: Variável de ambiente não configurada");
            System.err.println("\nComo configurar:");
            System.err.println("Na sua IDE:");
            System.err.println("  - Vá em Run > Edit Configurations");
            System.err.println("  - Adicione em Environment Variables:");
            System.err.println("    - Nome: EXCHANGE_RATE_API_KEY");
            System.err.println("    - Valor: sua_chave_api");

            throw new IllegalStateException("API_KEY não configurada");
        }

        return api_key;
    }

    public double converte(String moedaBase, String moedaDestino, double valor) throws IOException, InterruptedException {
        URI path = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + moedaBase + "/" + moedaDestino + "/" + valor);

        HttpRequest request = HttpRequest.newBuilder().uri(path).build();
        HttpResponse<String> resposta = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        if (resposta.statusCode() != 200) {
            throw new RuntimeException("Erro na API: código HTTP " + resposta.statusCode());
        }

        RespostaTaxaCambio resultado = gson.fromJson(resposta.body(), RespostaTaxaCambio.class);
        return resultado.conversion_result();
    }
}
