package org.example;

import java.util.Scanner;

public class Console {
    static String lertexto (String pergunta) {
        System.out.println(pergunta);
        Scanner ler = new Scanner (System.in);
        return ler.nextLine();
    }
    static int lerint (String pergunta) {
        System.out.println(pergunta);
        Scanner ler = new Scanner (System.in);
        return ler.nextInt();
    }

    static boolean lerboolean (String pergunta) {
        System.out.println(pergunta);
        Scanner ler = new Scanner (System.in);
        return ler.nextBoolean();
    }

    static void mensagem (String pergunta) {
        System.out.println(pergunta);
    }

    static void aviso(String mensagem) {
        System.out.println("\u001B[33m" + mensagem + "\u001B[0m");
    }

    static void erro(String mensagem) {
        System.out.println("\u001B[31m" + mensagem + "\u001B[0m");
    }

    static void sucesso(String mensagem) {
        System.out.println("\u001B[32m" + mensagem + "\u001B[0m");
    }

    static void limpar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
