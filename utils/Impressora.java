package utils;

import javaNIO.LeitorArquivo;
import model.Jogador;

import java.io.IOException;
import java.util.*;

public class Impressora {
    public static void imprimirJogadorMaisCartaoCor(String cor) throws IOException {
        Map<String, Integer> qtdCartoes = new HashMap<>();
        varrerArquivoCSVCartoes(qtdCartoes, cor);

        Map.Entry<String, Integer> jogadorMaisCartoes = Collections.max(qtdCartoes.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue));

        System.out.println("Jogador com mais cartões + " + cor + ": " + jogadorMaisCartoes.getKey());
    }

    public static void imprimirJogadorMaisGolTipo(String tipo) throws IOException {
        Map<String, Integer> qtdGols = new HashMap<>();
        varrerArquivoCSVGols(qtdGols, tipo);

        Map.Entry<String, Integer> jogadorMaisGols = Collections.max(qtdGols.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue));

        System.out.println("Jogador com mais gols " + tipo + ": " + jogadorMaisGols.getKey());
    }

//       ****************************************
public static void imprimirPartidaComMaiorPlacar() throws IOException {
    List<String> linhasCSV = LeitorArquivo.lerArquivoCSVFull();
    Map<String, Integer> qtdGolsPorPartida = new HashMap<>();
    varrerArquivoCSVFull(qtdGolsPorPartida);

    Map.Entry<String, Integer> partidaComMaisGols = null;

    boolean ignorarCabecalho = true;
    int maxGols = 0;
    String partidaMaxGols = "";

    for (String linha : linhasCSV) {

        if (ignorarCabecalho) {
            ignorarCabecalho = false;
            continue;
        }

        String[] campos = linha.split(",");

        Integer mandantePlacar = 0;
        if (!campos[6].replace("\"", "").isEmpty() && campos[6].replace("\"", "").matches("\\d+")) {
            mandantePlacar = Integer.parseInt(campos[6].replace("\"", ""));
        }

        Integer visitantePlacar = 0;
        if (!campos[7].replace("\"", "").isEmpty() && campos[7].replace("\"", "").matches("\\d+")) {
            visitantePlacar = Integer.parseInt(campos[7].replace("\"", ""));
        }

        if (mandantePlacar != null && visitantePlacar != null) {
            Integer totalGols = mandantePlacar + visitantePlacar;
            if (totalGols > maxGols) {
                maxGols = totalGols;
                partidaMaxGols = linha;
            }
        }
    }
    System.out.println("A partida com mais gols foi: " + partidaMaxGols);
}



    public static void varrerArquivoCSVCartoes(Map<String, Integer> qtdCartoes, String cor) throws IOException {
        List<String> linhasCSV = LeitorArquivo.lerArquivoCSVCartoes();
        boolean ignorarCabecalho = true;

        for (String linha : linhasCSV) {

            if (ignorarCabecalho) {
                ignorarCabecalho = false;
                continue;
            }

            String[] campos = linha.split(",");

            String partidaIdStr = campos[0].replace("\"", "");
            String rodadaStr = campos[1].replace("\"", "");
            String clube = campos[2].replace("\"", "");
            String cartao = campos[3].replace("\"", "");
            String atleta = campos[4].replace("\"", "");
            String numCamisa = campos[5].replace("\"", "");
            String posicao = campos[6].replace("\"", "");
            String minuto = campos[7].replace("\"", "");

            Integer partidaId = Integer.parseInt(partidaIdStr);
            Integer rodada = Integer.parseInt(rodadaStr);

            Jogador jogador = new Jogador(atleta, numCamisa, posicao);

            if (cartao.equals(cor)) {
                qtdCartoes.put(jogador.getNome(), qtdCartoes.getOrDefault(jogador.getNome(), 0) + 1);
            }
        }
    }

    public static void varrerArquivoCSVGols(Map<String, Integer> qtdGols, String tipo) throws IOException {
        List<String> linhasCSV = LeitorArquivo.lerArquivoCSVGols();
        boolean ignorarCabecalho = true;

        for (String linha : linhasCSV) {

            if (ignorarCabecalho) {
                ignorarCabecalho = false;
                continue;
            }

            String[] campos = linha.split(",");

            String partidaIdStr = campos[0].replace("\"", "");
            String rodadaStr = campos[1].replace("\"", "");
            String clube = campos[2].replace("\"", "");
            String atleta = campos[3].replace("\"", "");
            String minuto = campos[4].replace("\"", "");
            String tipoGol = campos[5].replace("\"", "");


            Integer partidaId = Integer.parseInt(partidaIdStr);
            Integer rodada = Integer.parseInt(rodadaStr);

            Jogador jogador = new Jogador(atleta, tipoGol);

            if (tipo.equals("")) {
                if (jogador.getTipoGol().equals(tipo)) {
                    qtdGols.put(jogador.getNome(), qtdGols.getOrDefault(jogador.getNome(), 0) + 1);
                }
            } else if (tipo.equals("Penalty")) {
                if (jogador.getTipoGol().equals(tipo)) {
                    qtdGols.put(jogador.getNome(), qtdGols.getOrDefault(jogador.getNome(), 0) + 1);
                }
            } else if (tipo.equals("Gol Contra")) {
                if (jogador.getTipoGol().equals(tipo)) {
                    qtdGols.put(jogador.getNome(), qtdGols.getOrDefault(jogador.getNome(), 0) + 1);
                }
            }
        }
    }

//            ************************************************
    public static void varrerArquivoCSVFull(Map<String, Integer> qtdGolsPorPartida) throws IOException {
        List<String> linhasCSV = LeitorArquivo.lerArquivoCSVFull();
        boolean ignorarCabecalho = true;
        int maxGols = 0;
        String partidaMaxGols = "";

        for (String linha : linhasCSV) {

            if (ignorarCabecalho) {
                ignorarCabecalho = false;
                continue;
            }

            String[] campos = linha.split(",");

            String formacaoMandante = campos[0].replace("\"", "");
            String formacaoVisitante = campos[1].replace("\"", "");
            String tecnicoMandante = campos[2].replace("\"", "");
            String tecnicoVisitante = campos[3].replace("\"", "");
            String vencedor = campos[4].replace("\"", "");
            String arena = campos[5].replace("\"", "");

            Integer mandantePlacar = 0;
            if (!campos[6].replace("\"", "").isEmpty() && campos[6].replace("\"", "").matches("\\d+")) {
                mandantePlacar = Integer.parseInt(campos[6].replace("\"", ""));
            }

            Integer visitantePlacar = 0;
            if (!campos[7].replace("\"", "").isEmpty() && campos[7].replace("\"", "").matches("\\d+")) {
                visitantePlacar = Integer.parseInt(campos[7].replace("\"", ""));
            }

            String mandanteEstado = campos[8].replace("\"", "");
            String visitanteEstado = campos[9].replace("\"", "");

            if (mandantePlacar != null && visitantePlacar != null) {
                Integer totalGols = mandantePlacar + visitantePlacar;
                if (totalGols > maxGols) {
                    maxGols = totalGols;
                    partidaMaxGols = linha;
                }
            }
        }
    }
}