package javaNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

public class LeitorArquivo {

    public static final String CAMINHO_ARQUIVO = "";
    public static final String EXTENSAO_CSV = ".csv";

    public static void lerArquivoCSV() throws IOException {

        Path path = Paths.get(CAMINHO_ARQUIVO + EXTENSAO_CSV);

        Collection<String> linhas = Files.readAllLines(path);

        for (int i = 1; i < linhas.size(); i++){

        }
    }
}
