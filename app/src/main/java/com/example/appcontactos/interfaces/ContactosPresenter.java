package com.example.appcontactos.interfaces;

import com.example.appcontactos.interactors.Contactos;

import java.util.ArrayList;

public interface ContactosPresenter {

    void obtenerContactos();

    void enviarListaContactos(ArrayList<Contactos> listaContactos);
}
