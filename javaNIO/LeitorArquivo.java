package javaNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

public class LeitorArquivo {

    public static final String CAMINHO_ARQUIVO_CARTOES =
            "E:/JAVA/Web-Programming/CSVFileReader/CsvFileReader/CSVFiles/campeonato-brasileiro-cartoes";
    public static final String CAMINHO_ARQUIVO_GOLS =
            "E:/JAVA/Web-Programming/CSVFileReader/CsvFileReader/CSVFiles/campeonato-brasileiro-gols";
    public static final String EXTENSAO_CSV = ".csv";

    public static List<String> lerArquivoCSVCartoes() throws IOException {
        Path path = Paths.get(CAMINHO_ARQUIVO_CARTOES + EXTENSAO_CSV);
        return Files.readAllLines(path);
    }
    public static List<String> lerArquivoCSVGols() throws IOException {
        Path path = Paths.get(CAMINHO_ARQUIVO_GOLS + EXTENSAO_CSV);
        return Files.readAllLines(path);
    }
}
