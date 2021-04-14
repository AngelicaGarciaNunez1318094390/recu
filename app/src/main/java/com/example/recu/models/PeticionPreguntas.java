package com.example.recu.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PeticionPreguntas {
    public boolean isS() {
        return s;
    }
    public void setS(boolean s) {
        this.s = s;
    }
    @SerializedName("s")
    @Expose
    private boolean s;

    public PPreguntas getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(PPreguntas preguntas) {
        this.preguntas = preguntas;
    }

    @SerializedName("preguntas")
    @Expose
    private PPreguntas preguntas;

}
