package chat;

import java.time.LocalDateTime;

public class Mensagem {
    private String texto;
    private LocalDateTime timestamp;
    private Usuario usuario;

    public Mensagem(String texto, Usuario usuario){
        this.texto = texto;
        this.timestamp = LocalDateTime.now();
        this.usuario = usuario;
    }

    public String getMensagem(){
        return String.format(
                "Autor: %s\nMensagem: %s\nData/Hora: %s",
                this.usuario.getUsername(), this.texto, this.timestamp);
    }
}
