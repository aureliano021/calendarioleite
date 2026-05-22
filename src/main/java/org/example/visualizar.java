package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Scanner;

public class visualizar{

    public visualizar (String conteudo) {
        boolean existe = false;
        System.out.println("informe a data");
        Scanner leitor = new Scanner(System.in);
        String data = leitor.nextLine();
        JsonArray array = new JsonParser().parse(conteudo).getAsJsonArray();
        for (JsonElement element : array) {
            JsonObject obj = element.getAsJsonObject();
            String dataarray = obj.get("data").getAsString();
            if (dataarray.equals(data)) {
                existe = true;
                System.out.println("a quantidade de leite nessa data foi: " + obj.get("quantidadeleite").getAsString());
                boolean fora = obj.get("fora").getAsBoolean();
                if (fora) {
                    System.out.println("Mas alguns litros fora ao registro (levou pra casa)");
                }
            }

        }
        if (!existe) {
            System.out.println("Não há registro para a data informada.");
        }
        System.out.println("Deseja fazer um registro?");
        if (!leitor.nextLine().equals("s")) {
            System.exit(0);
        }
    }

}
