package com.example.ejercicio14relojdigital;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RelojDigitalOptimized {
    // Constantes para evitar "Magic Numbers" (Regla crítica de SonarQube)
    private static final int LIMITE_TIEMPO = 60;
    private static final int HORAS_DIA = 24;
    private static final int MEDIODIA = 12;

    private int horas;
    private int minutos;
    private int segundos;
    private int alarmaH;
    private int alarmaM;

    public void configurarHora(int h, int m, int s) {
        // Uso de módulo para asegurar que los valores siempre sean válidos
        this.horas = h % HORAS_DIA;
        this.minutos = m % LIMITE_TIEMPO;
        this.segundos = s % LIMITE_TIEMPO;
    }

    public void configurarAlarma(int h, int m) {
        this.alarmaH = h % HORAS_DIA;
        this.alarmaM = m % LIMITE_TIEMPO;
    }

    public void avanzarSegundo() {
        // Lógica simplificada con el operador módulo
        segundos = (segundos + 1) % LIMITE_TIEMPO;
        if (segundos == 0) {
            minutos = (minutos + 1) % LIMITE_TIEMPO;
            if (minutos == 0) {
                horas = (horas + 1) % HORAS_DIA;
            }
        }

        verificarAlarma();
    }

    private void verificarAlarma() {
        if (horas == alarmaH && minutos == alarmaM && segundos == 0) {
            log.info("¡ALARMA SONANDO!");
        }
    }

    public String mostrarFormato24h() {
        // %02d asegura que siempre haya 2 dígitos con un cero a la izquierda
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public String mostrarFormato12h() {
        int displayHora = (horas % MEDIODIA == 0) ? MEDIODIA : horas % MEDIODIA;
        String amPm = (horas < MEDIODIA) ? "AM" : "PM";
        return String.format("%02d:%02d:%02d %s", displayHora, minutos, segundos, amPm);
    }
}