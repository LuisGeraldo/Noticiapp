package com.example.luis.noticiasapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.prof.rssparser.Article;

import java.util.ArrayList;
import java.util.List;

public class ListArrayAdapter extends ArrayAdapter<Article> {

    private ArrayList<Article> lista;
    private Context context;
    private Button verNoticia;

    public ListArrayAdapter(@NonNull Context context, @NonNull ArrayList<Article> lista) {
        super(context,0, lista);
        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Article article = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_mostrar_noticias, parent, false);
        }

        TextView titulo = (TextView) convertView.findViewById(R.id.titulo_text_view);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.noticia_Image_view);
        TextView fecha = (TextView) convertView.findViewById(R.id.txt_fecha);
        verNoticia = (Button) convertView.findViewById(R.id.btn_vistar_noticia);


        Glide.with(context).load(article.getImage()).into(imageView);
        titulo.setText(article.getTitle());
        fecha.setText(article.getPubDate().toString());
        
        return convertView;
    }
}
