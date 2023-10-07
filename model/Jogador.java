package model;

import java.util.Objects;

public class Jogador {
    private String nome;
    private String posicao;
    private String numeroCamisa;
    private int qtdCartaoAmarelo;
    private int qtdCartaoVermelho;

    public Jogador() {
    }

    public Jogador(String nome, String posicao, String numeroCamisa) {
        this.nome = nome;
        this.posicao = posicao;
        this.numeroCamisa = numeroCamisa;
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

    public int getQtdCartaoAmarelo() {
        return qtdCartaoAmarelo;
    }

    public int getQtdCartaoVermelho() {
        return qtdCartaoVermelho;
    }

    public void incrementarCartoesAmarelos() {
        qtdCartaoAmarelo++;
    }
    public void incrementarCartoesVermelhos() {
        qtdCartaoVermelho++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return qtdCartaoAmarelo == jogador.qtdCartaoAmarelo && qtdCartaoVermelho == jogador.qtdCartaoVermelho && Objects.equals(nome, jogador.nome) && Objects.equals(posicao, jogador.posicao) && Objects.equals(numeroCamisa, jogador.numeroCamisa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, posicao, numeroCamisa, qtdCartaoAmarelo, qtdCartaoVermelho);
    }
}
