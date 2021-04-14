package com.example.recu.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeticionModelo {
    @SerializedName("s")
    @Expose
    public Boolean s;
    @SerializedName("preguntas")
    @Expose
    public List<String> preguntas;

    public Boolean getS() {
        return s;
    }

    public void setS(Boolean s) {
        this.s = s;
    }

    public List<String> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<String> preguntas) {
        this.preguntas = preguntas;
    }
}
