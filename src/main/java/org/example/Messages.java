package org.example;

public class Messages {
    int id_message;
    String message;
    String messageAuthor;
    String messageDate;

    public Messages() {

    }

    public Messages(String message, String messageAuthor, String messageDate) {
        this.message = message;
        this.messageAuthor = messageAuthor;
        this.messageDate = messageDate;
    }

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageAuthor() {
        return messageAuthor;
    }

    public void setMessageAuthor(String messageAuthor) {
        this.messageAuthor = messageAuthor;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }
}
