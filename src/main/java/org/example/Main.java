package org.example;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option = 0;

        do {
            System.out.println("-------------------");
            System.out.println("Aplicacion de Mensajes");
            System.out.println("-------------------");
            System.out.println("1. Crear Mensaje");
            System.out.println("2. Listar Mensaje");
            System.out.println("3. Editar Mensaje");
            System.out.println("4. Eliminar Mensaje");
            System.out.println("5. Salir");
            //leemos la opcion del usuario
            option = sc.nextInt();

            switch (option) {
                case 1:
                    MessagesService.CreateMessage();
                    break;
                case 2:
                    MessagesService.ListMessage();
                    break;
                case 3:
                    MessagesService.EditMessage();
                    break;
                case 4:
                    MessagesService.DeleteMessage();
                    break;
                default:
                    break;
            }
        } while (option != 5);
    }
}