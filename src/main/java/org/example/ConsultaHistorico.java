package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConsultaHistorico {

    public ConsultaHistorico(String conteudo) {
        boolean existe = false;
        String data = Terminal.lertexto("Informe a Data. (DD/MM/AAAA)");
        JsonArray array = JsonParser.parseString(conteudo).getAsJsonArray();
        for (JsonElement element : array) {
            JsonObject obj = element.getAsJsonObject();
            String dataarray = obj.get("data").getAsString();
            if (dataarray.equals(data)) {
                existe = true;
                System.out.println("A quantidade de leite nessa data foi: " + obj.get("quantidadeleite").getAsString());
                boolean fora = obj.get("fora").getAsBoolean();
                if (fora) {
                    System.out.println("Atenção: parte do leite foi retirada para consumo interno.");
                }
            }

        }
        if (!existe) {
            System.out.println("Não há registro para a data informada.");
        }
//        String resposta = Console.lertexto("Deseja fazer um registro?");
//        if (!resposta.equals("s")) {
//            System.exit(0);
//        }
    }

}
