package org.example;

import com.google.gson.*;
import org.example.servico.Previsao;
import org.example.servico.ServicoPrevisao;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.example.GravadorArquivo.criar;
import static org.example.GeradorRelatorio.soma;

public class UI {
    public static Previsao servico;

    static {
        try {
            servico = ServicoPrevisao.pegarPrevisao();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static LocalDateTime dataTime = servico.getCurrent().getData();

    public static void iniciar() throws Exception {
        boolean continua = true;
        Terminal.mensagem("\u001B[1m\u001B[36m" + "Iniciando Registro de Leite" + "\u001B[0m");



        while (continua) {

            String existe = LeitorArquivo.verificarExiste();
            if (existe != null) {
                Terminal.mensagem(servico.toString());
                criar(existe);
                int resposta = Terminal.lerint("""
                        MENU\u001B[34m
                        1 - Fazer registro
                        2 - Ver histórico
                        3 - Fazer soma
                        4 - Fechar\
                        \u001B[0m""");
                switch (resposta) {
                    case 1:
                        Terminal.limpar();

                        try{
                        String passar = fluxoDeRegistro(existe);
                            criar(passar);
                        }
                        catch (Exception e){
                            System.err.println(e.getMessage());
                        }
                        break;
                    case 2:
                        Terminal.limpar();
                        new ConsultaHistorico(existe);
                        break;
                    case 3:
                        Terminal.limpar();
                        soma();
                        break;
                    case 4:
                        Terminal.mensagem("Fechando o programa...");
                        continua =  false;
                        break;
                }
            } else {
                int resposta = Terminal.lerint("""
                        MENU\u001B[34m
                        1 - Fazer registro
                        2 - Fechar
                        X - Ver histórico (indisponível)
                        X - Fazer soma (indisponível)\u001B[0m""");
                if (resposta == 1) {
                    String passar = fluxoDeRegistro(null);
                    criar(passar);
                } else {
                    continua =  false;
                }
            }
        }
    }

    private static String fluxoDeRegistro(String conteudoAtual) {
        RegistroLeite registro = new RegistroLeite();
        String escolha = Terminal.lertexto("Deseja fazer um registro da data de hoje?");
        LocalDate data;
        boolean escolhaValida = false;
        while (!escolhaValida) {
        if (escolha.equals("sim")){
            data = dataTime.toLocalDate();
            System.out.println(data);
        }
        else {
            data = LocalDate.parse(Terminal.lertexto("Informe a data. (AAAA-MM-DD)"));
        }

        try{
            registro.setData(data);
            escolhaValida = true;
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        }


        int leite = Terminal.lerint("informe a quantidade de leite:");
        registro.setLeite(leite);

        boolean fora = Terminal.lerboolean("Informe a fora:");
        registro.setFora(fora);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        if (conteudoAtual == null) {
            JsonArray array = new JsonArray();
            String textoJsonFinal = gson.toJson(registro);
            JsonObject obj = JsonParser.parseString(textoJsonFinal).getAsJsonObject();
            array.add(obj);
            return gson.toJson(array);
        } else {
            JsonArray array = JsonParser.parseString(conteudoAtual).getAsJsonArray();
            String textoJsonFinal = gson.toJson(registro);
            JsonObject obj = JsonParser.parseString(textoJsonFinal).getAsJsonObject();
            array.add(obj);
            return gson.toJson(array);
        }
     }
}
