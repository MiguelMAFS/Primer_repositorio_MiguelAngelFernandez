package com.example.tema4;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    protected void onStart() {
        super.onStart();
        Button boton1 = findViewById(R.id.boton1);
        TextView texto = findViewById(R.id.texto);
        texto.setTextColor(Color.RED);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("Se ha pulsado el boton");
            }
        });

    }
}