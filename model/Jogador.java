package model;

import java.util.Objects;

public class Jogador {
    private String nome;
    private String posicao;
    private String numeroCamisa;
    private int qtdCartaoAmarelo;
    private int qtdCartaoVermelho;
    private int qtdGols;
    private String tipoGol;

    public Jogador() {
    }

    public Jogador(String nome, String posicao, String numeroCamisa) {
        this.nome = nome;
        this.posicao = posicao;
        this.numeroCamisa = numeroCamisa;
    }

    public Jogador(String nome, String tipoGol) {
        this.nome = nome;
        this.tipoGol = tipoGol;
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

    public int getQtdGols() {
        return qtdGols;
    }

    public String getTipoGol() {
        return tipoGol;
    }

    public void setQtdCartaoVermelho(int qtdCartaoVermelho) {
        this.qtdCartaoVermelho = qtdCartaoVermelho;
    }

    public void incrementarCartoesAmarelos() {
        qtdCartaoAmarelo++;
    }
    public void incrementarCartoesVermelhos() {
        qtdCartaoVermelho++;
    }

    public void incrementarGol() {
        qtdGols++;
    }
}
