package com.example.recu.interfaces;
import com.example.recu.models.PeticionModelo;
import com.example.recu.models.PeticionPreguntas;
import com.example.recu.models.regis;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface RegistroAPI {
    @POST("crearUsuarioAppP")
    @FormUrlEncoded
    Call<PeticionModelo> crearUsuario(@Field("nombre")String nombre,
                                      @Field("apellido_pat")String apellido_pat,
                                      @Field("apellido_mat")String apellido_mat,
                                      @Field("telefono")String telefono,
                                      @Field("correo")String correo,
                                      @Field("usuario")String usuario,
                                      @Field("contrasennia")String contrasennia,
                                      @Field("rcontrasennia")String rcontrasennia);
    @POST("iniciarSesionAppP")
    @FormUrlEncoded
    Call<PeticionModelo> iniciarSesion(@Field("correo")String correo,
                                      @Field("contrasennia")String contrasennia);
    @GET("preguntasAppP")
    Call<PeticionPreguntas> getpreguntas();
}