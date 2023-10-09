package utils;

import javaNIO.LeitorArquivo;
import model.Jogador;
import model.Partida;


import java.io.IOException;
import java.util.*;

public class Impressora {

    public static void imprimirJogadorMaisCartaoCor(String cor) throws IOException {
        Map<String, Integer> qtdCartoes = new HashMap<>();
        Consulta.inspecionarArquivoCSVCartoes(qtdCartoes, cor);

        Map.Entry<String, Integer> jogadorMaisCartoes = Collections.max(qtdCartoes.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue));

        System.out.println("O jogador com mais cartões " + cor + " entre 2003 - 2022 foi " + jogadorMaisCartoes.getKey());
    }

    public static void imprimirJogadorMaisGolTipo(String tipo) throws IOException {
        Map<String, Integer> qtdGols = new HashMap<>();
        Consulta.inspecionarArquivoCSVGols(qtdGols, tipo);

        Map.Entry<String, Integer> jogadorMaisGols = Collections.max(qtdGols.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue));

        System.out.println("O jogador com mais gols " + tipo + " entre 2003 - 2022 foi " + jogadorMaisGols.getKey());
    }

    public static void imprimirPlacarPartidaComMaisGols() throws IOException {
        Map<String, Integer> qtdGols = new HashMap<>();
        Consulta.inspecionarArquivoCSVFull(qtdGols);

        Map.Entry<String, Integer> partidaMaisGols = Collections.max(qtdGols.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue));

        System.out.println("O placar da partida com mais gols foi " + partidaMaisGols.getKey());
    }


}