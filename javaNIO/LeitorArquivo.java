package javaNIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivo {

    public static final String CAMINHO_ARQUIVO_CARTOES =
            "CSVFiles/campeonato-brasileiro-cartoes";
    public static final String CAMINHO_ARQUIVO_GOLS =
            "CSVFiles/campeonato-brasileiro-gols";
    public static final String CAMINHO_ARQUIVO_ESTATISTICAS_FULL =
            "CSVFiles/campeonato-brasileiro-estatisticas-full";
    public static final String CAMINHO_ARQUIVO_FULL =
            "CSVFiles/campeonato-brasileiro-full";
    public static final String EXTENSAO_CSV = ".csv";

    public static List<String> lerArquivoCSVCartoes() throws IOException {
        return lerArquivoGenerico(CAMINHO_ARQUIVO_CARTOES, EXTENSAO_CSV);
    }

    public static List<String> lerArquivoCSVGols() throws IOException {
        return lerArquivoGenerico(CAMINHO_ARQUIVO_GOLS, EXTENSAO_CSV);
    }

    public static List<String> lerArquivoCSVEstatisticasFull() throws IOException {
        return lerArquivoGenerico(CAMINHO_ARQUIVO_ESTATISTICAS_FULL, EXTENSAO_CSV);
    }

    public static List<String> lerArquivoCSVFull() throws IOException {
        return lerArquivoGenerico(CAMINHO_ARQUIVO_FULL, EXTENSAO_CSV);
    }

    public static List<String> lerArquivoGenerico(String caminho, String extensao) throws IOException {
        Path path = Paths.get(caminho + extensao);
        BufferedReader reader = Files.newBufferedReader(path);
        List<String> linhas = new ArrayList<>();
        String linha;
        while ((linha = reader.readLine()) != null) {
            linhas.add(linha);
        }
        reader.close();

        return linhas;
    }
}
