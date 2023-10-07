package javaNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

public class LeitorArquivo {

    public static final String CAMINHO_ARQUIVO =
            "C:/Program Files/Projetos/CsvFileReader/CSVFiles/campeonato-brasileiro-cartoes";
    public static final String EXTENSAO_CSV = ".csv";

    public static List<String> lerArquivoCSV() throws IOException {
        Path path = Paths.get(CAMINHO_ARQUIVO + EXTENSAO_CSV);
        return Files.readAllLines(path);
    }
}
