package com.example.appcontactos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcontactos.R;
import com.example.appcontactos.interactors.Contactos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaContactosAdaptar extends RecyclerView.Adapter<ListaContactosAdaptar.ViewHolder> {

    private ArrayList<Contactos> dataset;
    private ArrayList<Contactos> copiaDataset;
    private Context context;

    public ListaContactosAdaptar(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.actuvity_cardview_contactos,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Contactos contactos = dataset.get(position);
        holder.id.setText(contactos.getId());
        holder.nombre.setText(contactos.getName());
        holder.nombreUsuario.setText(contactos.getUsarname());
        holder.correo.setText(contactos.getEmail());
        holder.telefono.setText(contactos.getPhone());
        holder.sitioWeb.setText(contactos.getWebsite());

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaContactos(ArrayList<Contactos> listaContactos) {
        dataset.addAll(listaContactos);
        copiaDataset = new ArrayList<>();
        copiaDataset.addAll(dataset);
    }

    public void filtrarContactos(String buscar) {
        if(buscar.length() == 0) {
            dataset.clear();
            dataset.addAll(copiaDataset);
        } else {
            List<Contactos> contactos = dataset.stream().filter(i ->
                    i.getName().toLowerCase().contains(buscar.toLowerCase())).collect(Collectors.toList());
            dataset.clear();
            dataset.addAll(contactos);
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView id;
        private TextView nombre;
        private TextView nombreUsuario;
        private TextView correo;
        private TextView telefono;
        private TextView sitioWeb;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tvId);
            nombre = itemView.findViewById(R.id.tvNombre);
            nombreUsuario = itemView.findViewById(R.id.tvNombreUsuario);
            correo = itemView.findViewById(R.id.tvEmail);
            telefono = itemView.findViewById(R.id.tvTelefono);
            sitioWeb = itemView.findViewById(R.id.tvSitioWeb);
        }
    }

}
