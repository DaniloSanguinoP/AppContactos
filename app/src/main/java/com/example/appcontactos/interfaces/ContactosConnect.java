package com.example.appcontactos.interfaces;

import com.example.appcontactos.interactors.Contactos;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContactosConnect {
    @GET("users")
    Call<ArrayList<Contactos>> obtenerListaContactos();
}
