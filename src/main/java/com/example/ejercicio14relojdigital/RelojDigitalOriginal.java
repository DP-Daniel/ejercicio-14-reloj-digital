package com.example.ejercicio14relojdigital;

public class RelojDigitalOriginal {
    private int horas, minutos, segundos;
    private int alarmaH, alarmaM;

    public void configurarHora(int h, int m, int s) {
        this.horas = h;
        this.minutos = m;
        this.segundos = s;
    }

    public void configurarAlarma(int h, int m) {
        this.alarmaH = h;
        this.alarmaM = m;
    }

    public void avanzarSegundo() {
        segundos++;
        if (segundos >= 60) {
            segundos = 0;
            minutos++;
        }
        if (minutos >= 60) {
            minutos = 0;
            horas++;
        }
        if (horas >= 24) {
            horas = 0;
        }
    }

    public String mostrarFormato24h() {
        return horas + ":" + minutos + ":" + segundos;
    }

    public String mostrarFormato12h() {
        int h12 = horas;
        String periodo = "AM";
        if (horas >= 12) {
            periodo = "PM";
            if (horas > 12) h12 = horas - 12;
        }
        if (h12 == 0) h12 = 12;
        return h12 + ":" + minutos + ":" + segundos + " " + periodo;
    }
}