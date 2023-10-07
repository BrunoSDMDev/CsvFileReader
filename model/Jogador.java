package model;

public class Jogador {
    private Integer id;
    private String nome;
    private String posicao;
    private String numeroCamisa;

    public Jogador(Integer id, String nome, String posicao, String numeroCamisa) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.numeroCamisa = numeroCamisa;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getNumeroCamisa() {
        return numeroCamisa;
    }
}
