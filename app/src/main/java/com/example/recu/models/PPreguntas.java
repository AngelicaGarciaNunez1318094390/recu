package com.example.recu.models;

import com.example.recu.interfaces.RegistroAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PPreguntas {
    public static class Peticiones {
        Retrofit ret=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://t27.herokuapp.com/api/").build();
        public RegistroAPI api=ret.create(RegistroAPI.class);
    }
}
