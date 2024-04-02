package com.maga.entregable3_moviles;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//Adaptamos la Lista de datos que van a llegar
public class ListAdapter extends BaseAdapter {
    Context Contexto;
    String[] Nombres, NumeroTelefono, FechaMensaje, Mensaje;
    int[] IdImagen, Estado;
    //boolean[] MensajesLeidos;
    LayoutInflater inflater; //-> sirve para poner datos (inflar) en una interfaz grafica

    public ListAdapter (Context contexto,String[] nombres, String[] numeroTelefono, String[] fechaMensaje, String[] mensaje, int[] idImagen, int[] estado) {
        this.Contexto = contexto;
        this.Nombres = nombres;
        this.NumeroTelefono = numeroTelefono;
        this.FechaMensaje = fechaMensaje;
        this.Mensaje = mensaje;
        this.IdImagen = idImagen;
        this.Estado = estado;


        inflater = LayoutInflater.from(Contexto);


    }

    @Override
    public int getCount() {
        return Nombres.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.list_items, null);
        ImageView fotoperfil = view.findViewById(R.id.fotoperfilusuario);
        TextView nombreusuario = view.findViewById(R.id.nombre);
        TextView telefonousuario = view.findViewById(R.id.telefono);
        TextView fechamesaje = view.findViewById(R.id.fecha);
        TextView mensaje = view.findViewById(R.id.mensajeu);
        TextView estado = view.findViewById(R.id.tvestado);
        // mostrar datos
        fotoperfil.setImageResource(IdImagen[i]);
        nombreusuario.setText(Nombres[i]);
        telefonousuario.setText(NumeroTelefono[i]);
        fechamesaje.setText(FechaMensaje[i]);
        mensaje.setText(Mensaje[i]);
        estado.setText(String.valueOf(Estado[i]));


        if (Estado[i] == 0) {
            estado.setText("Recibido");
        } else if (Estado[i] == 1) {
            estado.setText("Visto");
        }

        return view;
    }

}
