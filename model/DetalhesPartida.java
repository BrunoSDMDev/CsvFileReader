package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class DetalhesPartida {
    private Integer id;
    private Integer rodada;
    private LocalDate data;
    private LocalTime hora;
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
}
