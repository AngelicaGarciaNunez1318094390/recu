package com.example.recu.models;

import android.widget.EditText;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class regis {
    @SerializedName("preguntas")
    @Expose
    public List<PREGUNTAS> preguntas;
    @SerializedName("duracionExamen")
    @Expose
    public String duracionExamen;
    @SerializedName("nivel")
    @Expose
    public String nivel;
    @SerializedName("tipoExamen")
    @Expose
    public String tipoExamen;
    @SerializedName("idExamen")
    @Expose
    public int idExamen;

    public List<PREGUNTAS> getPreguntas()
    {
        return preguntas;
    }

    public void setPreguntas(List<PREGUNTAS> preguntas)
    {
        this.preguntas = preguntas;
    }

    public String getDuracionExamen()
    {
        return duracionExamen;
    }

    public void setDuracionExamen(String duracionExamen)
    {
        this.duracionExamen = duracionExamen;
    }

    public String getNivel()
    {
        return nivel;
    }

    public void setNivel(String nivel)
    {
        this.nivel = nivel;
    }

    public String getTipoExamen()
    {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen)
    {
        this.tipoExamen = tipoExamen;
    }

    public int getIdExamen()
    {
        return idExamen;
    }

    public void setIdExamen(int idExamen)
    {
        this.idExamen = idExamen;
    }

}
