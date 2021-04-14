package com.example.recu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recu.models.PPreguntas;
import com.example.recu.models.PeticionModelo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Iniciar_sesion extends AppCompatActivity {
    PPreguntas.Peticiones peticionapi = new PPreguntas.Peticiones();
    public Button registrar;
    public Button iniciar;
    public EditText ce;
    public EditText cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        registrar = (Button) findViewById(R.id.btnregistrate);
        iniciar=(Button) findViewById(R.id.btniniciar);
        ce=(EditText) findViewById(R.id.edtxtnombre);
        cont=(EditText) findViewById(R.id.edtxtcontraseña);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Iniciar_sesion.this, MainActivity.class);
                startActivity(intent);
            }
        });
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correoS=ce.getText().toString();
                String contra=cont.getText().toString();
                Call<PeticionModelo> peticion= peticionapi.api.iniciarSesion(correoS,contra);
                peticion.enqueue(new Callback<PeticionModelo>() {
                    @Override
                    public void onResponse(Call<PeticionModelo> call, Response<PeticionModelo> response) {
                        if (response.isSuccessful()){
                            PeticionModelo respuesta=response.body();
                            if (respuesta.getS()){
                                String mensaje = "";
                                for (String detalle : respuesta.getPreguntas()) {
                                    mensaje += detalle + "\n";
                                }
                                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Iniciar_sesion.this, Preguntas.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(getApplicationContext(), "Error.", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<PeticionModelo> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error x", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}