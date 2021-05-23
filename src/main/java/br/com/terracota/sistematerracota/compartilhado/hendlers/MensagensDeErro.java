package br.com.terracota.sistematerracota.compartilhado.hendlers;

public class MensagensDeErro {

    private String campo;
    private String mensagem;

    public MensagensDeErro(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
