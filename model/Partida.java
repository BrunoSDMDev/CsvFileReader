package model;

public class Partida {
    private DetalhesPartida detalhesPartida;
    private EstatisticasPartida estatisticasPartida;
    private Integer id;
    private Integer rodada;
    private Time time;
    private Jogador jogador;
    private Integer minute;
    private TipoGol tipoGol;

    public Partida(DetalhesPartida detalhesPartida, EstatisticasPartida estatisticasPartida, Integer id, Integer rodada, Time time, Jogador jogador, Integer minute, TipoGol tipoGol) {
        this.detalhesPartida = detalhesPartida;
        this.estatisticasPartida = estatisticasPartida;
        this.id = id;
        this.rodada = rodada;
        this.time = time;
        this.jogador = jogador;
        this.minute = minute;
        this.tipoGol = tipoGol;
    }

    public DetalhesPartida getDetalhesPartida() {
        return detalhesPartida;
    }

    public EstatisticasPartida getEstatisticasPartida() {
        return estatisticasPartida;
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

    public Jogador getJogador() {
        return jogador;
    }

    public Integer getMinute() {
        return minute;
    }

    public TipoGol getTipoGol() {
        return tipoGol;
    }
}
