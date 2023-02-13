package com.example.appcontactos.interactors;

import android.util.Log;

import com.example.appcontactos.interfaces.ContactosConnect;
import com.example.appcontactos.interfaces.ContactosInteractor;
import com.example.appcontactos.interfaces.ContactosPresenter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactosInteractorImpl implements ContactosInteractor {

    private ContactosPresenter contactosPresenter;
    public ContactosInteractorImpl(ContactosPresenter contactosPresenter) {
        this.contactosPresenter = contactosPresenter;
    }

    @Override
    public void obtenerContactos() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ContactosConnect contactosConnect = retrofit.create(ContactosConnect.class);
        Call<ArrayList<Contactos>> contactosRequestCall = contactosConnect.obtenerListaContactos();

        contactosRequestCall.enqueue(new Callback<ArrayList<Contactos>>() {
            @Override
            public void onResponse(Call<ArrayList<Contactos>> call, Response<ArrayList<Contactos>> response) {

                if (response.isSuccessful()) {
                    //ContactosRequest contactosRequest = response.body();
                    ArrayList<Contactos> listaContactos = response.body();
                    System.out.println("CONSULTA ->" + listaContactos);
                    enviarListaContactos(listaContactos);

                } else {
                    Log.e("ERROR 404", "onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Contactos>> call, Throwable t) {

            }
        });
    }

    @Override
    public void enviarListaContactos(ArrayList<Contactos> listaAnime) {
        contactosPresenter.enviarListaContactos(listaAnime);
    }
}
