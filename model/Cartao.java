package model;

public class Cartao {
    private Integer id;
    private Time time;
    private String cartao;
    private Jogador jogador;
    private String numCamisa;
    private String posicao;
    private Integer minuto;


    public Cartao(Integer id, Time time, String cartao, Jogador jogador, String numCamisa, String posicao, Integer minuto) {
        this.id = id;
        this.time = time;
        this.cartao = cartao;
        this.jogador = jogador;
        this.numCamisa = numCamisa;
        this.posicao = posicao;
        this.minuto = minuto;
    }

    public Integer getId() {
        return id;
    }

    public Time getTime() {
        return time;
    }

    public String getCartao() {
        return cartao;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public String getNumCamisa() {
        return numCamisa;
    }

    public String getPosicao() {
        return posicao;
    }

    public Integer getMinuto() {
        return minuto;
    }
}
