package Task_2;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_2 {
    private  static final Gson GSON = new Gson();
    public void getAndWriteComments(String url, HttpClient client) throws IOException, InterruptedException {
        boolean b = true;
        while (b){
            //        користувач вводить ID користувача
            System.out.println("\nЩоб побачити коментарі введіть ID користувача, для закінчення роботи програми введіть цифру 0: ");
            int userNumber=new Scanner(System.in).nextInt();

            //        перевіряється його наявність
            int isCorrectUser = isUser(url, client);

            if (userNumber>isCorrectUser){
                System.out.println("Такого користувача не існує");
            } else if (userNumber==0) {
                b=false;
            } else {
                    //        визначаємо останній пост даного користувача
                    int lastPost = findLastPost(url, client, userNumber);
                    //        записуємо всі коментарі до цього поста у файл
                    writeCommentsToFile(userNumber, lastPost, findComments(url, client, lastPost));
            }
        }
    }

    private int isUser (String url, HttpClient client) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url+"users/"))
                .GET()
                .headers("Content-type", "application/json; charset=UTF-8")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        List<JsonObject> jsonObjects = GSON.fromJson(response.body(), new TypeToken<List<JsonObject>>(){}.getType());

        int maxId = 0;
        for (JsonObject ig : jsonObjects) {
            maxId = Integer.parseInt(String.valueOf(ig.get("id")));
        }
        return maxId;
    }

    private int findLastPost(String url, HttpClient client, int userNumber) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url+"users/"+ userNumber + "/posts"))
                .GET()
                .headers("Content-type", "application/json; charset=UTF-8")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        List<JsonObject> jsonObjects = GSON.fromJson(response.body(), new TypeToken<List<JsonObject>>(){}.getType());

        int id = 0;
        for (JsonObject o : jsonObjects) {
            id = Integer.parseInt(String.valueOf(o.get("id")));
        }
        System.out.println("Всі коментарі до поста: "+id);
        return id;
    }

    private ArrayList<String> findComments(String url, HttpClient client, int postId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url+"posts/" + postId + "/comments"))
                .GET()
                .headers("Content-type", "application/json; charset=UTF-8")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        List <JsonObject> jsonObjects = GSON.fromJson(response.body(), new TypeToken<List<JsonObject>>(){}.getType());
        ArrayList<String>comments = new ArrayList<>();

        for (JsonObject o : jsonObjects) {
            comments.add(String.valueOf(o.get("body")));
            System.out.println(" - "+ o.get("body"));
        }
        return comments;
    }

    private void writeCommentsToFile(int userId, int postId, ArrayList<String> comments){
        try (FileWriter fileWriter = new FileWriter("user-"+userId+"-post-"+postId+"-comments.json")){
            for (String s:comments) {
                fileWriter.write(s+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
