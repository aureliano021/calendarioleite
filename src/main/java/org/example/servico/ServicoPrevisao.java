package org.example.servico;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class ServicoPrevisao {
    static String endereco = "https://api.open-meteo.com/v1/forecast?latitude=-17.3739&longitude=-40.2206&hourly=precipitation_probability,temperature_2m&models=best_match&current=temperature_2m,rain&forecast_days=1";
    static int codigoSucesso = 200;

    public static Previsao pegarPrevisao() throws Exception {
        try{
            URL url = new URL(endereco);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            if (conexao.getResponseCode() != codigoSucesso){
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
            }
            BufferedReader resposta =new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = resposta.lines()
                    .collect(Collectors.joining(System.lineSeparator()));

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, context) ->
                            LocalDateTime.parse(json.getAsString())
                    )
                    .create();

            Previsao previsao = gson.fromJson(jsonEmString, Previsao.class);
            return previsao;
        }catch (Exception e){
            throw new Exception("ERRO:" + e);
        }
    }
}
