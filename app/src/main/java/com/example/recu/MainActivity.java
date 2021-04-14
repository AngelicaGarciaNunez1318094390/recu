package com.example.recu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recu.models.PPreguntas;
import com.example.recu.models.PeticionModelo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    PPreguntas.Peticiones peticionapi = new PPreguntas.Peticiones();
    public Button Crear; 
    public EditText Nombre;
    public EditText ApellidoP;
    public EditText ApellidoM;
    public EditText telefono;
    public EditText correoe;
    public EditText Usuario;
    public EditText contraseña;
    public EditText confirmacontraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Crear = (Button) findViewById(R.id.btncrear);
        Nombre = (EditText) findViewById(R.id.edtxtingnombre);
        ApellidoP = (EditText) findViewById(R.id.edtxtapellidop);
        ApellidoM = (EditText) findViewById(R.id.edtxtapellidom);
        telefono = (EditText) findViewById(R.id.edtxtnumerotel);
        correoe = (EditText) findViewById(R.id.edtxtcorreoe);
        Usuario = (EditText) findViewById(R.id.edtxtusuario);
        contraseña = (EditText) findViewById(R.id.edtxtcontraseña);
        confirmacontraseña = (EditText) findViewById(R.id.edtxtconfirmacontra);
        Crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Iniciar_sesion.class);
                startActivity(intent);
            }
        });
        Crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = Nombre.getText().toString();
                String apellidop = ApellidoP.getText().toString();
                String apellidom = ApellidoM.getText().toString();
                String numtel = telefono.getText().toString();
                String correo = correoe.getText().toString();
                String usuarioo = Usuario.getText().toString();
                String contra = contraseña.getText().toString();
                String confircontra = confirmacontraseña.getText().toString();
                Call<PeticionModelo> regis = peticionapi.api.crearUsuario(nombre,apellidop,apellidom,numtel,correo,usuarioo,contra,confircontra);
                regis.enqueue(new Callback<PeticionModelo>() {
                    @Override
                    public void onResponse(Call<PeticionModelo> call, Response<PeticionModelo> response) {
                        if (response.isSuccessful()) {
                            PeticionModelo respuesta = response.body();
                            if (respuesta.getS()) {
                                Toast.makeText(getApplicationContext(), "Registro exitoso.", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MainActivity.this, Iniciar_sesion.class);
                                startActivity(intent);
                            }
                        }
                    }
                    @Override
                        public void onFailure (Call < PeticionModelo > call, Throwable t){
                            Toast.makeText(getApplicationContext(), "Error x", Toast.LENGTH_LONG).show();
                        }
                });
            }
        });
    }
}

