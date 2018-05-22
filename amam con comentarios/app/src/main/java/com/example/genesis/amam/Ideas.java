package com.example.genesis.amam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

//Clase del layout activity_ideas para visualizar un WebView
public class Ideas extends AppCompatActivity {

    //Atributos del layout activity_ideas que se utilizarán para visualizar el WebView
    WebView wvTasty;

    //Método para relacionar las variables del layout activity_ideas con las de esta clase
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideas);

        wvTasty = (WebView)findViewById(R.id.wvTasty);

        //Se establece la página a la que se redirecciona el WebView y se le da funcionalidad
        wvTasty.loadUrl("https://tasty.co/");
        wvTasty.getSettings().setJavaScriptEnabled(true);
        wvTasty.setWebViewClient(new WebViewClient());
    }

}
