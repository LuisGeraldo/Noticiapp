package com.example.luis.noticiasapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Typeface tituloFuente;
    TextView textTitulo;
    TextView textSeleccione;
    Button btnVerNoticias;
    Spinner opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnVerNoticias = (Button) findViewById(R.id.btn_ver_noticias);
        btnVerNoticias.setOnClickListener(this);
        opciones = (Spinner) findViewById(R.id.diario_spinner);
        textTitulo = (TextView) findViewById(R.id.titulo_text_view);
        textSeleccione = (TextView) findViewById(R.id.seleccione_text_view);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.urls, android.R.layout.simple_spinner_item);
        opciones.setPrompt("Seleccione un noticiario");
        opciones.setAdapter(adapter);
        String ruta = "fuentes/fuente.ttf";
        this.tituloFuente = Typeface.createFromAsset(getAssets(), ruta);

        textTitulo.setTypeface(tituloFuente);
        btnVerNoticias.setTypeface(tituloFuente);
    }

    @Override
    public void onClick(View v) {
        if(v == btnVerNoticias){
            Intent intent = new Intent(this, MostrarNoticiasActivity.class);
            intent.putExtra("url", "https://www.diariolibre.com/rss/portada.xml");
            startActivity(intent);
        }
    }
}
