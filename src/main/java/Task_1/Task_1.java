package Task_1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Task_1 {
    public String creating(String url, String newUser, HttpClient client) throws IOException, InterruptedException {
        HttpRequest create = HttpRequest.newBuilder(URI.create(url+"users/"))
                .POST(HttpRequest.BodyPublishers.ofString(newUser))
                .headers("Content-type", "application/json; charset=UTF-8")
                .build();
                System.out.println("Створено нового користувача: "+client.send(create, HttpResponse.BodyHandlers.ofString()).body());
        return client.send(create, HttpResponse.BodyHandlers.ofString()).body();
    }

    public String updating (String url, String newUser, HttpClient client) throws IOException, InterruptedException {
        System.out.println("Вкажіть id користувача для оновлення: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HttpRequest update = HttpRequest.newBuilder(URI.create(url+"users/"+s))
                .PUT(HttpRequest.BodyPublishers.ofString(newUser))
                .headers("Content-type", "application/json; charset=UTF-8")
                .build();
        System.out.println("Оновлено користувача з id: "+s);
        System.out.println(client.send(update, HttpResponse.BodyHandlers.ofString()).body());
        return client.send(update, HttpResponse.BodyHandlers.ofString()).body();
    }

    public void deleting(String url, HttpClient client) throws IOException, InterruptedException {
        System.out.println("Вкажіть id користувача для видалення: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HttpRequest delete = HttpRequest.newBuilder(URI.create(url+"users/"+s))
                .DELETE()
                .headers("Content-type", "application/json; charset=UTF-8")
                .build();
        System.out.println("Користувача з id "+s+" видалено");
        System.out.println("Статус відповіді: " + client.send(delete, HttpResponse.BodyHandlers.ofString()).statusCode());
    }

    public String getAllUsers (String url, HttpClient client) throws IOException, InterruptedException {
        HttpRequest get = HttpRequest.newBuilder()
                .uri(URI.create(url+"users/"))
                .GET()
                .build();
                System.out.println("Всі користувачі: \n" + client.send(get, HttpResponse.BodyHandlers.ofString()).body());
        return client.send(get, HttpResponse.BodyHandlers.ofString()).body();
    }

    public String getUserById(String url, HttpClient client) throws IOException, InterruptedException {
        System.out.println("Вкажіть id користувача : ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HttpRequest get = HttpRequest.newBuilder()
                .uri(URI.create(url+"/users/"+s))
                .GET()
                .build();
        System.out.println(client.send(get, HttpResponse.BodyHandlers.ofString()).body());
        return client.send(get, HttpResponse.BodyHandlers.ofString()).body();
    }

    public String getUserByUsername (String url, HttpClient client) throws IOException, InterruptedException {
        System.out.println("Вкажіть usename користувача :");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HttpRequest get = HttpRequest.newBuilder()
                .uri(URI.create(url+"/users/?username="+s))
                .GET()
                .build();
        System.out.println(client.send(get, HttpResponse.BodyHandlers.ofString()).body());
        return client.send(get, HttpResponse.BodyHandlers.ofString()).body();
    }
}
