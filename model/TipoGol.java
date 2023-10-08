package model;

public enum TipoGol {
    GOL(""),
    PENALTY("Penalty"),
    GOLCONTRA("Gol Contra");

    private final String descricao;

    TipoGol(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
