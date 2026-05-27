package org.example;

import java.io.IOException;

import static org.example.GravadorArquivo.criar;
import static org.example.ColetorDados.iniciador;
import static org.example.GeradorRelatorio.soma;
import static org.example.LeitorArquivo.verificador;

public class UI {
    public static void iniciar() throws IOException {
        boolean continua = true;
        Terminal.mensagem("\u001B[1m\u001B[36m" + "Iniciando Registro de Leite" + "\u001B[0m");
        while (continua) {

            String existe = verificador();
            if (existe != null) {
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
                        String passar = iniciador(existe);
                        criar(passar);
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
                        Terminal.limpar();
                        continua = false;
                        break;
                }
            } else {
                int resposta = Terminal.lerint("MENU" + "\u001B[34m" + "\n1 - Fazer registro\nX - Ver histórico (indisponível)\nX - Fazer soma (indisponível)" + "\u001B[0m");
                if (resposta == 1) {
                    String passar = iniciador(existe);
                    criar(passar);
                }
            }
        }
    }
}
