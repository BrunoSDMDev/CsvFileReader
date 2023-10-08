package utils;

import javaNIO.LeitorArquivo;
import model.Jogador;
import model.Partida;

import java.io.IOException;
import java.sql.SQLOutput;
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

    public static void imprimirPlacarPartidaComMaisGols() throws IOException {
        Map<String, Integer> qtdGols = new HashMap<>();
        varrerArquivoCSVFull(qtdGols);

        Map.Entry<String, Integer> partidaMaisGols = Collections.max(qtdGols.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue));

        System.out.println("Placar da partida com mais gols " + partidaMaisGols.getKey());
    }

    public static void imprimirTimeMaisVitoriaAno(String ano) throws IOException {
        Map<String, Integer> qtdVitorias = new HashMap<>();
        varrerArquivoCSVFull2(qtdVitorias, ano);

        Map.Entry<String, Integer> timeMaisVitoria = Collections.max(qtdVitorias.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue));

        System.out.println("Time com mais vitórias em " + ano + " " + timeMaisVitoria.getKey());
    }

    private static void varrerArquivoCSVFull2(Map<String, Integer> qtdVitorias, String ano) throws IOException {
        List<String> linhasCSV = LeitorArquivo.lerArquivoCSVFull();
        boolean ignorarCabecalho = true;

        for (String linha : linhasCSV) {

            if (ignorarCabecalho) {
                ignorarCabecalho = false;
                continue;
            }

            String[] campos = linha.split(",");

            String partidaIdStr = campos[0].replace("\"", "");
            String rodadaStr = campos[1].replace("\"", "");
            String data = campos[2].replace("\"", "");
            String hora = campos[3].replace("\"", "");
            String mandante = campos[4].replace("\"", "");
            String visitante = campos[5].replace("\"", "");
            String formacaoMandante = campos[6].replace("\"", "");
            String formacaoVisitante = campos[7].replace("\"", "");
            String tecnicoMandante = campos[8].replace("\"", "");
            String tecnicoVisitante = campos[9].replace("\"", "");
            String vencedor = campos[10].replace("\"", "");
            String arena = campos[11].replace("\"", "");
            Integer mandantePlacar = Integer.valueOf(campos[12].replace("\"", ""));
            Integer visitantePlacar = Integer.valueOf(campos[13].replace("\"", ""));
            String mandanteEstado = campos[14].replace("\"", "");
            String visitanteEstado = campos[15].replace("\"", "");

            Integer partidaId = Integer.parseInt(partidaIdStr);
            Integer rodada = Integer.parseInt(rodadaStr);

            if (ano.equals(data.substring(0, 4))) {
                String time = vencedor;
                if (qtdVitorias.containsKey(time)) {
                    qtdVitorias.put(time, qtdVitorias.get(time) + 1);
                } else {
                    qtdVitorias.put(time, 1);
                }
            }
        }
    }

    private static void varrerArquivoCSVFull(Map<String, Integer> qtdGols) throws IOException {
        List<String> linhasCSV = LeitorArquivo.lerArquivoCSVFull();
        boolean ignorarCabecalho = true;

        for (String linha : linhasCSV) {

            if (ignorarCabecalho) {
                ignorarCabecalho = false;
                continue;
            }

            String[] campos = linha.split(",");

            String partidaIdStr = campos[0].replace("\"", "");
            String rodadaStr = campos[1].replace("\"", "");
            String data = campos[2].replace("\"", "");
            String hora = campos[3].replace("\"", "");
            String mandante = campos[4].replace("\"", "");
            String visitante = campos[5].replace("\"", "");
            String formacaoMandante = campos[6].replace("\"", "");
            String formacaoVisitante = campos[7].replace("\"", "");
            String tecnicoMandante = campos[8].replace("\"", "");
            String tecnicoVisitante = campos[9].replace("\"", "");
            String vencedor = campos[10].replace("\"", "");
            String arena = campos[11].replace("\"", "");
            Integer mandantePlacar = Integer.valueOf(campos[12].replace("\"", ""));
            Integer visitantePlacar = Integer.valueOf(campos[13].replace("\"", ""));
            String mandanteEstado = campos[14].replace("\"", "");
            String visitanteEstado = campos[15].replace("\"", "");

            Integer partidaId = Integer.parseInt(partidaIdStr);
            Integer rodada = Integer.parseInt(rodadaStr);

            Integer placarTotal = mandantePlacar + visitantePlacar;

            String placarFormatado = mandantePlacar + " x " + visitantePlacar;

            Partida partida = new Partida(partidaId, placarTotal);

            qtdGols.put(placarFormatado, placarTotal);
        }
    }

    private static void varrerArquivoCSVCartoes(Map<String, Integer> qtdCartoes, String cor) throws IOException {
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

    private static void varrerArquivoCSVGols(Map<String, Integer> qtdGols, String tipo) throws IOException {
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
}