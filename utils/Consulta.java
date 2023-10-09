package utils;

import javaNIO.LeitorArquivo;
import model.Jogador;
import model.Partida;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
O time que mais venceu jogos no ano 2008
O Estado que teve menos jogos dentro do período 2003 e 2022
O jogador que mais fez gols
O jogador que mais fez gols de pênaltis
O jogador que mais fez gols contras
O placar da partida com mais gols.
 */
public class Consulta {
    public static void inspecionarArquivoCSVFull(Map<String, Integer> qtdGols) throws IOException {
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

    public static void inspecionarArquivoCSVCartoes(Map<String, Integer> qtdCartoes, String cor) throws IOException {
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

    public static void inspecionarArquivoCSVGols(Map<String, Integer> qtdGols, String tipo) throws IOException {
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


//                  ------- o que ainda precisa ser criado -----


//
//    public static void imprimirTimeMaisVitoriaAno(String ano) throws IOException {
//        List<String> vencedores = new ArrayList<>();
//        varrerArquivoCSVFull2(vencedores);
//
//        Optional<String> timeMaisVitoria = vencedores.stream()
//                .max(Comparator.comparingInt(v -> Collections.frequency(vencedores, v)));
//
//        System.out.println("Time com mais vitórias em " + ano + " " + timeMaisVitoria.get());
//    }

//
//    private static void varrerArquivoCSVFull2(List<String> vencedores) throws IOException {
//        List<String> linhasCSV = LeitorArquivo.lerArquivoCSVFull();
//        boolean ignorarCabecalho = true;
//
//        for (String linha : linhasCSV) {
//
//            if (ignorarCabecalho) {
//                ignorarCabecalho = false;
//                continue;
//            }
//
//            String[] campos = linha.split(",");
//
//            String partidaIdStr = campos[0].replace("\"", "");
//            String rodadaStr = campos[1].replace("\"", "");
//            String data = campos[2].replace("\"", "");
//            String hora = campos[3].replace("\"", "");
//            String mandante = campos[4].replace("\"", "");
//            String visitante = campos[5].replace("\"", "");
//            String formacaoMandante = campos[6].replace("\"", "");
//            String formacaoVisitante = campos[7].replace("\"", "");
//            String tecnicoMandante = campos[8].replace("\"", "");
//            String tecnicoVisitante = campos[9].replace("\"", "");
//            String vencedor = campos[10].replace("\"", "");
//            String arena = campos[11].replace("\"", "");
//            Integer mandantePlacar = Integer.valueOf(campos[12].replace("\"", ""));
//            Integer visitantePlacar = Integer.valueOf(campos[13].replace("\"", ""));
//            String mandanteEstado = campos[14].replace("\"", "");
//            String visitanteEstado = campos[15].replace("\"", "");
//
//            Integer partidaId = Integer.parseInt(partidaIdStr);
//            Integer rodada = Integer.parseInt(rodadaStr);
//
//            if (ano.equals(data.substring(0, 4))) {
//                vencedores.add(vencedor);
//            }
//        }
//    }
