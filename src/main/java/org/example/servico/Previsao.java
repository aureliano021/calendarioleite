package org.example.servico;

import java.time.LocalDateTime;
import java.util.List;

public class Previsao {
    private Current current;
    private Hourly hourly;

    public Current getCurrent() { return current; }
    public Hourly getHourly() { return hourly; }

    @Override
    public String toString() {
        return "Clima atual: " + current.getTemperatura() + "°C | " +
                "Probabilidade de chuva hoje: " + hourly.getProbabilidadeChuva();
    }

    public class Current {
        private String time;

        @com.google.gson.annotations.SerializedName("temperature_2m")
        private Double temperatura;

        private Double rain;

        public Double getTemperatura() { return temperatura; }
        public Double getRain() { return rain; }
        public LocalDateTime getData() {
            if (this.time == null) return null;
            return LocalDateTime.parse(this.time);
        }
    }

    public class Hourly {
        @com.google.gson.annotations.SerializedName("precipitation_probability")
        private List<Integer> probabilidadeChuva;

        public double getProbabilidadeChuva() {
            int soma = probabilidadeChuva.stream().mapToInt(Integer::intValue).sum();
            double somaPrevisao = (double) soma / 2;

            return somaPrevisao; }
    }
}