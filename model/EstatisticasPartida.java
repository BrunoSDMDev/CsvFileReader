package model;

public class EstatisticasPartida {
    private Integer id;
    private Integer rodada;
    private Time time;
    private Integer chutes;
    private Integer chutesAlvo;
    private String posseBola;
    private Integer passes;
    private String precisaoPasses;
    private Integer faltas;
    private Integer cartaoAmarelo;
    private Integer cartaoVermelho;
    private Integer impedimentos;
    private Integer escanteios;

    public EstatisticasPartida(Integer id, Integer rodada, Time time, Integer chutes, Integer chutesAlvo, String posseBola, Integer passes, String precisaoPasses, Integer faltas, Integer cartaoAmarelo, Integer cartaoVermelho, Integer impedimentos, Integer escanteios) {
        this.id = id;
        this.rodada = rodada;
        this.time = time;
        this.chutes = chutes;
        this.chutesAlvo = chutesAlvo;
        this.posseBola = posseBola;
        this.passes = passes;
        this.precisaoPasses = precisaoPasses;
        this.faltas = faltas;
        this.cartaoAmarelo = cartaoAmarelo;
        this.cartaoVermelho = cartaoVermelho;
        this.impedimentos = impedimentos;
        this.escanteios = escanteios;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRodada() {
        return rodada;
    }

    public Time getTime() {
        return time;
    }

    public Integer getChutes() {
        return chutes;
    }

    public Integer getChutesAlvo() {
        return chutesAlvo;
    }

    public String getPosseBola() {
        return posseBola;
    }

    public Integer getPasses() {
        return passes;
    }

    public String getPrecisaoPasses() {
        return precisaoPasses;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public Integer getCartaoAmarelo() {
        return cartaoAmarelo;
    }

    public Integer getCartaoVermelho() {
        return cartaoVermelho;
    }

    public Integer getImpedimentos() {
        return impedimentos;
    }

    public Integer getEscanteios() {
        return escanteios;
    }
}
