import javaNIO.LeitorArquivo;
import model.Jogador;
import model.Partida;
import model.Time;
import utils.Impressora;

import java.io.IOException;
import java.util.*;

/*

Falta realizar a consulta e a impressão dos atributos:
O Estado que teve menos jogos dentro do período 2003 e 2022;

 */
public class Terminal {

    public static void main(String[] args) throws IOException {
        Impressora.imprimirJogadorMaisCartaoCor("Amarelo");
        Impressora.imprimirJogadorMaisCartaoCor("Vermelho");
        Impressora.imprimirJogadorMaisGolTipo("");
        Impressora.imprimirJogadorMaisGolTipo("Penalty");
        Impressora.imprimirJogadorMaisGolTipo("Gol Contra");
        Impressora.imprimirPlacarPartidaComMaisGols();
//        Impressora.imprimirTimeMaisVitoriaAno("2008");
    }

    public static void imprimirEstadoMenosVitoriaIntervaloAno() throws IOException {
        List<String> linhasCSV = LeitorArquivo.lerArquivoCSVGols();
        List<Partida> partidas = new ArrayList<>();

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
            Partida partida = new Partida(partidaId, rodada, clube, jogador, minuto);

            partidas.add(partida);
        }
    }
}
