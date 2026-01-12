import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoeda {
    public double converte(String moedaBase, String moedaDestino, double valor) throws IOException, InterruptedException {
        URI path = URI.create("https://v6.exchangerate-api.com/v6/f3064bd5f4206d98bdd95689/pair/" + moedaBase + "/" + moedaDestino + "/" + valor);

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(path).build();
        HttpResponse<String> resposta = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        if (resposta.statusCode() != 200) {
            throw new RuntimeException("Erro na API: código HTTP " + resposta.statusCode());
        }

        return new Gson().fromJson(resposta.body(), RespostaTaxaCambio.class).conversion_result();
    }
}
