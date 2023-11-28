package org.example;

import Task_1.Task_1;
import Task_2.Task_2;
import Task_3.Task_3;
import Users.*;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpClient;

public class Main {
    public static final String url = "https://jsonplaceholder.typicode.com/";
    public static final HttpClient client = HttpClient.newBuilder().build();

    public static void main(String[] args) throws IOException, InterruptedException {

        User user = new User("John Rambo", "JR", "JoRe@com.org", "097-500-6070 x321", "Jonny.gov");
        user.setAddress("Wall street","Apt. 77","Toronto","03033-9099");
        user.address.setGeo(27.4572,64.2990);
        user.setCompany("Rambo&Co", "Multi-tiered zero tolerance productivity", "any orders");

        Gson gson = new Gson();
        String newUserJson = gson.toJson(user);

        Task_1 task1 = new Task_1();
//        Створення нового об'єкта
//        task1.creating(url,newUserJson,client);

//        Оновлення об'єкта за вказаним id
//        task1.updating(url, newUserJson, client);

//        Видалення об'єкта за вказаним id
//        task1.deleting(url, client);

//        Отримання інформації про всіх користувачів
//        task1.getAllUsers(url, client);

//        отримання інформації про користувача за id
//        task1.getUserById(url,client);

//        отримання інформації про користувача за username
//        task1.getUserByUsername(url,client);

        Task_2 task2 = new Task_2();
//        метод виводить всі коментарі до останнього поста певного користувача і записує їх у файл.
//        task2.getAndWriteComments(url, client);

        Task_3 task3 = new Task_3();
//        виводить всі відкриті задачі для користувача з ідентифікатором X у форматі JSON
//        task3.getFalseTodos(url,client);
//        or
//        виводить вміст поля tiltle, якщо відкрита задача для користувача з ідентифікатором X
//        task3.getFalseTodos1(url,client);
    }
}