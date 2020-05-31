package com.desarrollo.receptor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receptorIntent = getIntent();
        String action = receptorIntent.getAction();
        String tipo = receptorIntent.getType();
        if(Intent.ACTION_SEND.equals(action) && tipo != null){
            if("text/plain".equals(tipo)){
                manipularTexto(receptorIntent);
            }
        }
    }

    private void manipularTexto(Intent intent){
        String texto = intent.getStringExtra(Intent.EXTRA_TEXT);
        if(texto != null){
            ((TextView)findViewById(R.id.txt_receptor)).setText(texto);
            Toast.makeText(getBaseContext(),texto,Toast.LENGTH_LONG).show();
        }
    }
}
