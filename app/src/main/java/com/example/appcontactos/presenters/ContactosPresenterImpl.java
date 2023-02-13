package com.example.appcontactos.presenters;

import com.example.appcontactos.interactors.Contactos;
import com.example.appcontactos.interactors.ContactosInteractorImpl;
import com.example.appcontactos.interfaces.ContactosInteractor;
import com.example.appcontactos.interfaces.ContactosPresenter;
import com.example.appcontactos.interfaces.ContactosView;

import java.util.ArrayList;

public class ContactosPresenterImpl implements ContactosPresenter {

    private ContactosInteractor contactosInteractor;
    private ContactosView contactosView;

    public ContactosPresenterImpl(ContactosView contactosView) {
        this.contactosView = contactosView;
        this.contactosInteractor = new ContactosInteractorImpl(this);
    }

    @Override
    public  void obtenerContactos() {
        contactosInteractor.obtenerContactos();
    }

    @Override
    public void enviarListaContactos(ArrayList<Contactos> listaContactos) {
        contactosView.enviarListaContactos(listaContactos);
    }
}
