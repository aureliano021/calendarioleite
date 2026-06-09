package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConsultaHistorico {

    public ConsultaHistorico(String conteudo) {
        boolean existe = false;
        String data = Terminal.lertexto("Informe a Data. (AAAA-MM-DD)");
        JsonArray array = JsonParser.parseString(conteudo).getAsJsonArray();
        for (JsonElement element : array) {
            JsonObject obj = element.getAsJsonObject();
            String dataarray = obj.get("data").getAsString();
            if (dataarray.equals(data)) {
                existe = true;
                Terminal.aviso("A quantidade de leite nessa data foi: " + obj.get("quantidadeleite").getAsString());
                boolean fora = obj.get("fora").getAsBoolean();
                if (fora) {
                    System.out.println("Atenção: parte do leite foi retirada para consumo interno.");
                }
            }

        }
        if (!existe) {
            System.out.println("Não há registro para a data informada.");
        }
    }

//    public static JsonArray verificarOrdem(JsonArray array) {
//        List<JsonElement> lista = new ArrayList<>();
//        array.forEach(lista::add);
//
//        lista.sort((a, b)->
//                String dataA = a.getAsJsonObject().get("data").getAsString;
//                );
//    }
public static JsonArray verificarOrdem(JsonArray array) {
    List<JsonElement> lista = new ArrayList<>();
    array.forEach(lista::add);

    lista.sort((a, b) -> {
        String dataA = a.getAsJsonObject().get("data").getAsString();
        String dataB = b.getAsJsonObject().get("data").getAsString();
        // converte e compara
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ldA = LocalDate.parse(dataA, fmt);
        LocalDate ldB = LocalDate.parse(dataB, fmt);
        return ldA.compareTo(ldB);
    });

    JsonArray ordenado = new JsonArray();
    lista.forEach(ordenado::add);
    return ordenado;
}

}
