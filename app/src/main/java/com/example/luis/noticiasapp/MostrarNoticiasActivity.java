package com.example.luis.noticiasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;

import java.util.ArrayList;

public class MostrarNoticiasActivity extends AppCompatActivity implements Parser.OnTaskCompleted {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_noticias);

        listView = (ListView) findViewById(R.id.list_view);

        String url = getIntent().getExtras().getString("url");
        Parser parser = new Parser();
        parser.onFinish(this);
        parser.execute(url);
    }

    @Override
    public void onTaskCompleted(ArrayList<Article> list) {
        listView.setAdapter(new ListArrayAdapter(getApplicationContext(), list));
    }

    @Override
    public void onError() {

    }
}
