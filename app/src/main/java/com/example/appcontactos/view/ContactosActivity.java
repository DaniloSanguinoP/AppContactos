package com.example.appcontactos.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appcontactos.R;
import com.example.appcontactos.adapter.ListaContactosAdaptar;
import com.example.appcontactos.interactors.Contactos;
import com.example.appcontactos.interfaces.ContactosPresenter;
import com.example.appcontactos.interfaces.ContactosView;
import com.example.appcontactos.presenters.ContactosPresenterImpl;

import java.util.ArrayList;

public class ContactosActivity extends AppCompatActivity implements ContactosView {

    private ListaContactosAdaptar listaContactosAdaptar;
    private ContactosPresenter contactosPresenter;
    private RecyclerView recyclerView;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        recyclerView = findViewById(R.id.recyclerViewContactos);
        searchView = findViewById(R.id.searchView);
        listaContactosAdaptar = new ListaContactosAdaptar(this);
        recyclerView.setAdapter(listaContactosAdaptar);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        contactosPresenter = new ContactosPresenterImpl(this);
        obtenerContactos();
        buscarContactos();
    }

    @Override
    public void obtenerContactos() {
        contactosPresenter.obtenerContactos();
    }

    @Override
    public void enviarListaContactos(ArrayList<Contactos> listaContactos) {
        listaContactosAdaptar.adicionarListaContactos(listaContactos);
        recyclerView.setAdapter(listaContactosAdaptar);
    }

    public void buscarContactos() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listaContactosAdaptar.filtrarContactos(newText);
                return false;
            }
        });
    }
}