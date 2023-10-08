package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Partida {
    private Integer id;
    private Integer rodada;
    private String clube;
    private String cartao;
    private Jogador jogador;
    private LocalDate data;
    private LocalTime hora;
    private String minuto;

    public Partida(Integer id, Integer rodada, String clube, String cartao, Jogador jogador, String minuto) {
        this.id = id;
        this.rodada = rodada;
        this.clube = clube;
        this.cartao = cartao;
        this.jogador = jogador;
        this.minuto = minuto;
    }

    public Partida(Integer id, Integer rodada, String clube, Jogador jogador, String minuto) {
        this.id = id;
        this.rodada = rodada;
        this.clube = clube;
        this.jogador = jogador;
        this.minuto = minuto;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRodada() {
        return rodada;
    }

    public String getClube() {
        return clube;
    }

    public String getCartao() {
        return cartao;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public String getMinuto() {
        return minuto;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }
}
