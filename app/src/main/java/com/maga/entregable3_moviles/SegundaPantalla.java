package com.maga.entregable3_moviles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class SegundaPantalla extends AppCompatActivity {
    String txtnombre, txttelefono, txtfecha, txtmensaje;
    int imagen;
    CircleImageView foto;
    TextView textoNombre, textoTelefono, textoFecha, textoMensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_pantalla);

        textoNombre = findViewById(R.id.txtnombre);
        textoTelefono = findViewById(R.id.txttelefono);
        textoFecha = findViewById(R.id.txtfecha);
        textoMensaje = findViewById(R.id.txtmensaje);
        foto = findViewById(R.id.imagen);

        Intent recibir = this.getIntent();
        if(recibir != null) {
            txtnombre = recibir.getStringExtra("nombre");
            txttelefono = recibir.getStringExtra("telefono");
            txtfecha = recibir.getStringExtra("fecha");
            txtmensaje = recibir.getStringExtra("mensaje");
            imagen = recibir.getIntExtra("imagen", R.drawable.imagenpordefecto);


            textoNombre.setText(txtnombre);
            textoTelefono.setText(txttelefono);
            textoFecha.setText(txtfecha);
            textoMensaje.setText(txtmensaje);
            foto.setImageResource(imagen);

            Button buttonVolver = findViewById(R.id.btnvolver);
            buttonVolver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    finish();
                }
            });
        }
    }
}