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
}
