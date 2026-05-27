package org.example;

import java.nio.file.Files;
import java.nio.file.Path;

public class GravadorArquivo {
    static void criar(String conteudo){
        try {
            Path arquivoPath = Path.of("arquivoan.json");
            Files.writeString(arquivoPath, conteudo);

        }
        catch (Exception e) {
            System.out.println("Erro ao criar arquivo.");
        }
    }
}
