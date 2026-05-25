package org.example;

import java.io.IOException;

import static org.example.Criar.criar;
import static org.example.Inicializador.iniciador;
import static org.example.SomaFinal.soma;
import static org.example.Verificador.verificador;

public class UI {
    public static void iniciar() throws IOException {
        boolean continua = true;
        Console.mensagem("\u001B[1m\u001B[36m" + "Iniciando Registro de Leite" + "\u001B[0m");
        while (continua) {

            String existe = verificador();
            if (existe != null) {
                int resposta = Console.lerint("""
                        MENU\u001B[34m
                        1 - Fazer registro
                        2 - Ver histórico
                        3 - Fazer soma
                        4 - Fechar\
                        \u001B[0m""");
                switch (resposta) {
                    case 1:
                        Console.limpar();
                        String passar = iniciador(existe);
                        criar(passar);
                        break;
                    case 2:
                        Console.limpar();
                        Visualizar visualizar = new Visualizar(existe);
                        break;
                    case 3:
                        Console.limpar();
                        soma();
                        break;
                    case 4:
                        Console.limpar();
                        continua = false;
                        break;
                }
            } else {
                int resposta = Console.lerint("MENU" + "\u001B[34m" + "\n1 - Fazer registro\nX - Ver histórico (indisponível)\nX - Fazer soma (indisponível)" + "\u001B[0m");
                if (resposta == 1) {
                    String passar = iniciador(existe);
                    criar(passar);
                }
            }
        }
    }
}
