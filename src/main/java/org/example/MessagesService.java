package org.example;

import java.util.Scanner;

public class MessagesService {
    public static void CreateMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje: ");
        String message = sc.nextLine();

        System.out.println("Tu nombre: ");
        String author = sc.nextLine();

        Messages read = new Messages();
        read.setMessage(message);
        read.setMessageAuthor(author);

        MensajesDAO.CreateMessageDB(read);
    }

    public static void ListMessage() {
        MensajesDAO.ReadMessageDB();
    }

    public static void DeleteMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el ID del mensaje que quieres borrar: ");
        int id_message = sc.nextInt();
        MensajesDAO.DeleteMessageDB(id_message);
    }

    public static void EditMessage() {
        Scanner sc = new Scanner(System.in);

        //System.out.println("Escribe el nuevo autor del mensaje a editar");
        String messageAuthor = sc.nextLine();

        System.out.println("Escribe el nuevo mensaje");
        String message = sc.nextLine();

        System.out.println("Escribe el ID del mensaje a editar");
        int id_message = sc.nextInt();

        Messages update = new Messages();
        update.setMessage(message);
        update.setId_message(id_message);
        //update.setMessageAuthor(messageAuthor);

        MensajesDAO.UpdateMessageDB(update);
    }

}
