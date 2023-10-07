import javaNIO.LeitorArquivo;
import model.Jogador;
import model.Partida;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Realizar a leitura de arquivos CSV com os dados de jogos do campeonato brasileiro entre 2003 e 2022 e trazer os seguintes dados:

O time que mais venceu jogos no ano 2008
O Estado que teve menos jogos dentro do período 2003 e 2022
O jogador que mais fez gols
O jogador que mais fez gols de pênaltis
O jogador que mais fez gols contras
O jogador que mais recebeu cartões amarelos
O jogador que mais recebeu cartões vermelhos
O placar da partida com mais gols.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        List<String> linhasCSV = LeitorArquivo.lerArquivoCSV();
        List<Partida> partidas = new ArrayList<>();

        boolean ignorarCabecalho = true;

        for (String linha : linhasCSV) {

            if(ignorarCabecalho) {
                ignorarCabecalho = false;
                continue;
            }

            String[] campos = linha.split(",");

            String partidaIdStr = campos[0].replace("\"", "");;
            String rodadaStr = campos[1].replace("\"", "");;
            String clube = campos[2];
            String cartao = campos[3];
            String atleta = campos[4];
            String numCamisa = campos[5];
            String posicao = campos[6];
            String minuto = campos[7];

            Integer partidaId = Integer.parseInt(partidaIdStr);
            Integer rodada = Integer.parseInt(rodadaStr);

            Jogador jogador = new Jogador(atleta, numCamisa, posicao);
            Partida partida = new Partida(partidaId, rodada, clube, cartao, jogador, minuto);

            partidas.add(partida);
        }

        Jogador jogadorMaisCartaoAmarelo = maisCartaoAmarelo(partidas);
        System.out.println("Mais cartões amarelos: " + jogadorMaisCartaoAmarelo.getNome());

        Jogador jogadorMaisCartaoVermelho = maisCartaoVermelho(partidas);
        System.out.println("Mais cartões vermelhos: " + jogadorMaisCartaoVermelho.getNome());
    }

    // Jogar os métodos abaixo para a classe utils.Consulta<<<

    public static Jogador maisCartaoAmarelo(List<Partida> partidas) {
        return partidas.stream()
                .filter(partida -> "\"Amarelo\"".equals(partida.getCartao()))
                .collect(Collectors.groupingBy(Partida::getJogador, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static Jogador maisCartaoVermelho(List<Partida> partidas) {
        return partidas.stream()
                .filter(partida -> "\"Vermelho\"".equals(partida.getCartao()))
                .collect(Collectors.groupingBy(Partida::getJogador, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }


    public static Jogador maisGols(){
        return new Jogador(); // desfazer construtor vazio após completar essa linha.
    }

    public static Jogador maisGolsPenaltis() {
        return new Jogador(); // desfazer construtor vazio após completar essa linha.
    }

    public static Jogador maisGolsContras() {
        return new Jogador(); // desfazer construtor vazio após completar essa linha.
    }


}
