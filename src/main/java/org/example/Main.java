package org.example;

import com.google.gson.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws IOException {
        verificador();


    }

    private static String iniciador (String conteudo){
        System.out.println("informe os dados: quantidade de leite, a data e se tirou(true ou false).");
        Scanner sc = new Scanner(System.in);
        int leite = sc.nextInt();
        int data = sc.nextInt();
        boolean fora = sc.nextBoolean();

        int hoje = LocalDate.now().getDayOfMonth();
        System.out.println("Hoje: " + hoje);
        LocalDate date;

        if (data != hoje) {
            System.out.printf("%s%n%s", "A data informada não é hoje!", "digite a Data informada (ano-mês-dia).");
            Scanner leitor = new Scanner(System.in);
            String texto = leitor.nextLine();
            date = LocalDate.parse(texto);
            System.out.println("data informada " + texto);
        } else {
            LocalDate realHoje = LocalDate.now();
            date = realHoje;
        }

        System.out.println("Data informada: " + date);
        gerenciador novo = new gerenciador(leite, date, fora);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        if (conteudo.equals("null")) {
            JsonArray array = new JsonArray();

            String textoJsonFinal = gson.toJson(novo);

            JsonObject object = JsonParser.parseString(textoJsonFinal).getAsJsonObject();

            array.add(object);
            return array.toString();
        } else {
            JsonArray array = JsonParser.parseString(conteudo).getAsJsonArray();

            String textoJsonFinal = gson.toJson(novo);

            JsonObject object = JsonParser.parseString(textoJsonFinal).getAsJsonObject();
            array.add(object);
            return gson.toJson(array);
        }

    }

    private static void verificador() throws IOException {
        System.out.println("verificando se o arquivo existe.");
        File arquivo = new File("arquivo.json");
        String conteudo = "null";

        if (arquivo.exists()) {
            System.out.println("Arquivo foi encontrado.");
            Path path = Paths.get(arquivo.getPath());
            conteudo = Files.readString(path);
            System.out.println("Deseja visualizar algum item do histórico? (s/n)");
            Scanner leitor = new Scanner(System.in);
            String resposta = leitor.nextLine();
            if (resposta.equals("s")) {
                visualizar visualizar = new visualizar(conteudo);
            }
            String passar = iniciador(conteudo);
            criar(passar);
        }
        else {
            System.out.println("Arquivo nao encontrado. Criando arquivo.");
            String passar = iniciador(conteudo);
            criar(passar);
        }
    }

    private static void criar (String conteudo){
        try {
            Path arquivoPath = Path.of("arquivo.json");
            Files.writeString(arquivoPath, conteudo);

        }
        catch (Exception e) {
            System.out.println("Erro ao criar arquivo.");
        }
    }
}
