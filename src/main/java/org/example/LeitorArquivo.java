package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.example.ConsultaHistorico.verificarOrdem;
import static org.example.Main.caminho;

public class LeitorArquivo {
    public static String verificarExiste() throws IOException {
        Terminal.aviso("verificando se o arquivo existe");
        File arquivo = new File(caminho);
        String conteudo;
        if (arquivo.exists()) {
            Path path = Paths.get(arquivo.getPath());
            conteudo = Files.readString(path);
            JsonArray arrayA = JsonParser.parseString(conteudo).getAsJsonArray();
            Terminal.aviso("Ordenando o arquivo existente");
            arrayA = verificarOrdem(arrayA);
            String array;
            array = arrayA.toString();
            Terminal.aviso("O arquivo existe");
            return array;
        }
        else {
            Terminal.aviso("O arquivo ainda não existe");
            return null;
        }
    }
}
