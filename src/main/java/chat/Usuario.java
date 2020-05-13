package chat;

import chat.Status;

public class Usuario {
    private String username;
    private Status status;

    public Usuario(String username){
        this.username = username;
        this.status = Status.ONLINE;
    }

    public String getUsername(){
        return this.username;
    }
}
