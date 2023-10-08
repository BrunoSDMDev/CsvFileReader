package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class DetalhesPartida {
    private Integer id;
    private Integer rodada;
    private Time mandante;
    private Time visitante;
    private String formacaoMandante;
    private String formacaoVisitante;
    private String tecnicoMandante;
    private String tecnicoVisitante;
    private String vencedor;
    private String arena;
    private Integer mandantePlacar;
    private Integer visitantePlacar;
    private String mandanteEstado;
    private String visitanteEstado;

    public DetalhesPartida(Integer id, Integer rodada, Time mandante, Time visitante, String formacaoMandante, String formacaoVisitante, String tecnicoMandante, String tecnicoVisitante, String vencedor, String arena, Integer mandantePlacar, Integer visitantePlacar, String mandanteEstado, String visitanteEstado) {
        this.id = id;
        this.rodada = rodada;
        this.mandante = mandante;
        this.visitante = visitante;
        this.formacaoMandante = formacaoMandante;
        this.formacaoVisitante = formacaoVisitante;
        this.tecnicoMandante = tecnicoMandante;
        this.tecnicoVisitante = tecnicoVisitante;
        this.vencedor = vencedor;
        this.arena = arena;
        this.mandantePlacar = mandantePlacar;
        this.visitantePlacar = visitantePlacar;
        this.mandanteEstado = mandanteEstado;
        this.visitanteEstado = visitanteEstado;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRodada() {
        return rodada;
    }

    public Time getMandante() {
        return mandante;
    }

    public Time getVisitante() {
        return visitante;
    }

    public String getFormacaoMandante() {
        return formacaoMandante;
    }

    public String getFormacaoVisitante() {
        return formacaoVisitante;
    }

    public String getTecnicoMandante() {
        return tecnicoMandante;
    }

    public String getTecnicoVisitante() {
        return tecnicoVisitante;
    }

    public String getVencedor() {
        return vencedor;
    }

    public String getArena() {
        return arena;
    }

    public Integer getMandantePlacar() {
        return mandantePlacar;
    }

    public Integer getVisitantePlacar() {
        return visitantePlacar;
    }

    public String getMandanteEstado() {
        return mandanteEstado;
    }

    public String getVisitanteEstado() {
        return visitanteEstado;
    }
}
