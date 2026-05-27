package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LeitorArquivo {
    public static String verificador() throws IOException {
        Terminal.aviso("verificando se o arquivo existe.");
        File arquivo = new File("arquivoan.json");
        String conteudo = "null";

        /*if (arquivo.exists()) {
            Console.aviso("Arquivo existe!");
            Path path = Paths.get(arquivo.getPath());
            conteudo = Files.readString(path);
            String resposta = Console.lertexto("Deseja visualizar algum item do histórico? (s/n)");
            if (resposta.equals("s")) {
                Visualizar visualizar = new Visualizar(conteudo);
            }
            String passar = iniciador(conteudo);
            criar(passar);
        }
        else {
            Console.erro("Arquivo não encontrado!");
            Console.aviso("Criando novo histórico!");
            String passar = iniciador(conteudo);
            criar(passar);
        }*/
        if (arquivo.exists()) {
            Path path = Paths.get(arquivo.getPath());
            conteudo = Files.readString(path);
            return conteudo;
        }
        else {
            return null;
        }
    }
}
