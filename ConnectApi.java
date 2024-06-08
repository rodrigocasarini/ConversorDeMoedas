import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.io.IOException;
import com.google.gson.Gson;

public class ConnectApi {
    private CurrencyApi value;
    public CurrencyApi getValue() {
        return value;
    }
    public void dataCurrency(String base, String target){
        var key = "27bcca65e38bcd2895f4d5bc";
        URI url = URI.create("https://v6.exchangerate-api.com/v6/"+key+"/pair/"+base+"/"+target+"/");
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(url).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            String json = response.body();
            value = gson.fromJson(json, CurrencyApi.class);

        } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Erro a descobrir :)");
            }
    }
}