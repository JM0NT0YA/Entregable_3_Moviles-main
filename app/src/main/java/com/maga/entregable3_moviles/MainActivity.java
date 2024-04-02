package com.maga.entregable3_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView ListarCorreos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        View mainLayout = findViewById(android.R.id.content);


        TextView myMailTextView = new TextView(this);
        myMailTextView.setTextSize(24);
        myMailTextView.setTextColor(Color.WHITE);
        ViewGroup layout = (ViewGroup) findViewById(android.R.id.content);
        layout.addView(myMailTextView);


        String[] nombres = {
                "Jhon Montoya",
                "Juan Pablo",
                "Maria José",
                "Youtube",
                "Gmail",
                "Github",
                "Twitter"
        };
        String[] telefonos = {
                "3508157027",
                "3562487984",
                "3215789632",
                "0",
                "0",
                "0",
                "0"
        };
        String[] fechas = {
                "07/02/2024",
                "06/02/2024",
                "05/02/2024",
                "04/02/2024",
                "01/02/2024",
                "25/01/2024",
                "24/01/2024"
        };
        String[] mensaje = {
                "Usted Recibio un Correo ",
                "Usted Recibio un Correo",
                "Usted Recibio un Correo",
                "Usted Recibio un Correo",
                "Usted Recibio un Correo",
                "Usted Recibio un Correo",
                "Usted Recibio un Correo"
        };
        int[] fotoperfil = {
                R.drawable.hombre1,
                R.drawable.hombre2,
                R.drawable.mujer1,
                R.drawable.youtube,
                R.drawable.gmail,
                R.drawable.github,
                R.drawable.twitter
        };
        int[] estadoPerfiles = {
                0,
                0,
                0,
                0,
                0,
                0,
                0
        };


        ListAdapter personas = new ListAdapter(MainActivity.this, nombres, telefonos, fechas, mensaje, fotoperfil, estadoPerfiles);
        ListarCorreos = (ListView) findViewById(R.id.listausuarios);
        ListarCorreos.setAdapter(personas);


        ListarCorreos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View vista, int posicion, long id) {
                // Marcar el email como visto
                SharedPreferences sharedPreferences = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(nombres[posicion], true);
                editor.apply();

                Intent enviarInfo = new Intent(MainActivity.this, SegundaPantalla.class)
                        .putExtra("nombre", nombres[posicion])
                        .putExtra("telefono", telefonos[posicion])
                        .putExtra("fecha", fechas[posicion])
                        .putExtra("mensaje", mensaje[posicion])
                        .putExtra("imagen", fotoperfil[posicion])
                        .putExtra("estado",estadoPerfiles[posicion]);

                TextView statusTextView = findViewById(R.id.tvestado);
                statusTextView.setText("Visto");

                estadoPerfiles[posicion] = 1;
                personas.notifyDataSetChanged();

                startActivity(enviarInfo);
            }
        });
    }
}