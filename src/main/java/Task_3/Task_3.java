package Task_3;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class Task_3 {
    String url;
    HttpClient client;
    public void getFalseTodos (String url, HttpClient client) throws IOException, InterruptedException {
        System.out.println("Введіть Id користувача, щоб побачити його відкриті задачі");
        int id = new Scanner(System.in).nextInt();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url+"users/"+id+"/todos?completed=false")).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
    public void getFalseTodos1 (String url, HttpClient client) throws IOException, InterruptedException {
        System.out.println("Введіть Id користувача, щоб побачити його відкриті задачі");
        int id = new Scanner(System.in).nextInt();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url+"users/"+id+"/todos")).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        List<JsonObject>jsonObjects = gson.fromJson(response.body(), new TypeToken<List<JsonObject>>(){}.getType());

        for (JsonObject jo:jsonObjects) {
            if (!jo.get("completed").getAsBoolean()){
                System.out.println(jo.get("title"));
            }
        }
    }
}

