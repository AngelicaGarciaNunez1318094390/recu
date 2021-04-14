package com.example.recu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.recu.models.PPreguntas;
import com.example.recu.models.PeticionPreguntas;
import com.example.recu.models.regis;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Preguntas extends AppCompatActivity {
    Peticiones peticion = new Peticiones();
    public TextView Duracion;
    public TextView Nivel;
    public TextView Tipo;
    public TextView Pregunta1;
    public TextView Res1Pre1;
    public TextView Res2Pre1;
    public TextView Res3Pre1;
    public TextView Pregunta2;
    public TextView Res1Pre2;
    public TextView Res2Pre2;
    public TextView Res3Pre2;
    public TextView Pregunta3;
    public TextView Res1Pre3;
    public TextView Res2Pre3;
    public TextView Res3Pre3;
    public TextView Pregunta4;
    public TextView Res1Pre4;
    public TextView Res2Pre4;
    public TextView Res3Pre4;
    public TextView Pregunta5;
    public TextView Res1Pre5;
    public TextView Res2Pre5;
    public TextView Res3Pre5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        Duracion = (TextView) findViewById(R.id.textdur);
        Nivel = (TextView) findViewById(R.id.textnivel);
        Tipo = (TextView) findViewById(R.id.texttipo);
        Pregunta1 = (TextView) findViewById(R.id.txtpregunta1);
        Res1Pre1 = (TextView) findViewById(R.id.txtres1);
        Res2Pre1 = (TextView) findViewById(R.id.txtres11);
        Res3Pre1 = (TextView) findViewById(R.id.txtres111);
        Pregunta2  = (TextView) findViewById(R.id.txtpregunta2);
        Res1Pre2 = (TextView) findViewById(R.id.txtres2);
        Res2Pre2 = (TextView) findViewById(R.id.txtres22);
        Res3Pre2 = (TextView) findViewById(R.id.txtres222);
        Pregunta3  = (TextView) findViewById(R.id.txtpregunta3);
        Res1Pre3 = (TextView) findViewById(R.id.txtres3);
        Res2Pre3 = (TextView) findViewById(R.id.txtres33);
        Res3Pre3 = (TextView) findViewById(R.id.txtres333);
        Pregunta4  = (TextView) findViewById(R.id.txtpregunta4);
        Res1Pre4 = (TextView) findViewById(R.id.txtres4);
        Res2Pre4 = (TextView) findViewById(R.id.txtres44);
        Res3Pre4 = (TextView) findViewById(R.id.ttxtres444);
        Pregunta5  = (TextView) findViewById(R.id.txtpregunta5);
        Res1Pre5 = (TextView) findViewById(R.id.txtres5);
        Res2Pre5 = (TextView) findViewById(R.id.txtres55);
        Res3Pre5 = (TextView) findViewById(R.id.txtres555);

        Call<PeticionPreguntas> lapeticion = peticion.api.getpreguntas();
        lapeticion.enqueue(new Callback <PeticionPreguntas>() {
            @Override
            public void onResponse(Call<PeticionPreguntas> call, Response<PeticionPreguntas> response) {
                    if (response.isSuccessful()) {
                        PeticionPreguntas pregun = response.body();
                        if (pregun.isS()) {
                          /*  Duracion.setText(pregun.getPreguntas().getDuracionExamen());
                            Nivel.setText(pregun.getPreguntas().getNivel());
                            Tipo.setText(pregun.getPreguntas().getTipoExamen());*/

                        }
            }
    }

            @Override
            public void onFailure(Call<PeticionPreguntas> call, Throwable t) {

            }
        });
    }
}