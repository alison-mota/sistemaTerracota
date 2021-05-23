package br.com.terracota.sistematerracota.compartilhado.hendlers;

public class MensagensDeErro {

    private final String campo;
    private final String mensagem;
    private final String status;

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getStatus() {
        return status;
    }

    public MensagensDeErro(String campo, String mensagem, String status) {
        this.campo = campo;
        this.mensagem = mensagem;
        this.status = status;
    }
}
