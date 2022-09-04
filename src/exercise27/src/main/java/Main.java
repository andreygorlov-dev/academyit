

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder().uri(URI.create("https://www.cbr-xml-daily.ru/daily_json.js")).build();

        HttpResponse<String> response = null;
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        DocumentContext jsonContext = JsonPath.parse(response.body());
        Double value = jsonContext.read("$['Valute']['USD']['Value']");
        System.out.println(value);
    }

}
