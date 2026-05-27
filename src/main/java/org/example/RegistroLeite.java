package org.example;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegistroLeite {
    int quantidadeleite;
    String data;
    Boolean fora;

    public RegistroLeite(int leite, LocalDate data, boolean fora) {
        this.quantidadeleite = leite;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedData = data.format(dtf);
        this.data = formattedData;
        this.fora = fora;

    }


}

