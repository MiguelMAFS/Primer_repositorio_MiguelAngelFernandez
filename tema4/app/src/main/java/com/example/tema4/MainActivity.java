package com.example.tema4;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Estos son los elementos que se sugerirán
        String[] opciones = {"Opción1", "Opción2", "Opción3", "Opción4", "Opción5"};

        // Aquí se asigna el elemento AutoCompleteTextView creado en el XML al Java
        AutoCompleteTextView textoUnido = findViewById(R.id.miTexto);

        // Creamos un ArrayAdapter al que le pasamos el array de strings
        // La misión de este "ArrayAdapter" es adaptar los datos del array al AutoCompleteTextView
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, opciones);

        // Por último se le pasa al adaptador la instancia del texto definido en el XML
        textoUnido.setAdapter(adaptador);

        //setContentView(R.layout.spinner);
        Spinner miSpinner = (Spinner) findViewById(R.id.miSpinner);

        String[] valores = {"Star Wars", "Reservoir dogs", "El Club de la Lucha", "Snatch: Cerdos y Diamantes"};

        miSpinner.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                valores
        ));

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                AdapterView<Adapter> adapter;
                System.out.println("Has seleccionado el valor: " + adapterView.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                System.out.println("No has seleccionado nada");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button boton1 = findViewById(R.id.boton1);
        Button boton2 = findViewById(R.id.boton2);
        Button boton3 = findViewById(R.id.boton3);
        TextView texto = findViewById(R.id.texto);

        texto.setTextColor(Color.RED);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("Se ha pulsado el boton");
            }
        });

        Animation rotar = AnimationUtils.loadAnimation(this, R.anim.rotar);

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.startAnimation(rotar);
            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.clearAnimation();
            }
        });
    }
}