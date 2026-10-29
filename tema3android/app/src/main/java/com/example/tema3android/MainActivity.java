package com.example.tema3android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView pantalla;
    private Button miBoton1;
    private Button miBoton2;
    private Button miBoton3;
    private Button miBoton4;
    private Button miBoton5;
    private Button miBoton6;
    private Button miBoton7;
    private Button miBoton8;
    private Button miBoton9;
    private Button miBoton0;
    private Button miBotondiv;
    private Button miBotonmult;
    private Button miBotonresta;
    private Button miBotonpunto;
    private Button miBotonigual;
    private Button miBotonsuma;
    private Button miBotonc;
    private Button miBotonca;

    private double primerNumero = 0;
    private String operacion = "";
    private boolean nuevaEntrada = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.grid_layout_ejercicio);

        pantalla = findViewById(R.id.pantalla);
        miBoton0 = findViewById(R.id.miBoton0);
        miBoton1 = findViewById(R.id.miBoton1);
        miBoton2 = findViewById(R.id.miBoton2);
        miBoton3 = findViewById(R.id.miBoton3);
        miBoton4 = findViewById(R.id.miBoton4);
        miBoton5 = findViewById(R.id.miBoton5);
        miBoton6 = findViewById(R.id.miBoton6);
        miBoton7 = findViewById(R.id.miBoton7);
        miBoton8 = findViewById(R.id.miBoton8);
        miBoton9 = findViewById(R.id.miBoton9);
        miBotonsuma = findViewById(R.id.miBotonsuma);
        miBotonresta = findViewById(R.id.miBotonresta);
        miBotonmult = findViewById(R.id.miBotonmult);
        miBotondiv = findViewById(R.id.miBotondiv);
        miBotonpunto = findViewById(R.id.miBotonpunto);
        miBotonigual = findViewById(R.id.miBotonigual);
        miBotonc = findViewById(R.id.miBotonc);
        miBotonca = findViewById(R.id.miBotonac);

        miBoton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumero("0");
            }
        });

        miBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumero("1");
            }
        });

        miBoton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumero("2");
            }
        });

        miBoton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumero("3");
            }
        });

        miBoton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumero("4");
            }
        });

        miBoton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumero("5");
            }
        });

        miBoton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumero("6");
            }
        });

        miBoton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumero("7");
            }
        });

        miBoton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumero("8");
            }
        });

        miBoton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumero("9");
            }
        });

        miBotonpunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNumero(".");
            }
        });

        miBotonsuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarOperacion("+");
            }
        });

        miBotonresta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarOperacion("-");
            }
        });

        miBotonmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarOperacion("*");
            }
        });

        miBotondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarOperacion(":");
            }
        });

        miBotonigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado();
            }
        });

        miBotonca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pantalla.setText("0");
                primerNumero = 0;
                operacion = "";
                nuevaEntrada = true;
            }
        });

        miBotonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nuevaEntrada) {
                    String texto = pantalla.getText().toString();

                    if (texto.length() > 1) {
                        pantalla.setText(
                                texto.substring(0, texto.length() - 1)
                        );
                    } else {
                        pantalla.setText("0");
                    }
                }
            }
        });
    }

    public void agregarNumero(String numero) {
        String texto = pantalla.getText().toString();

        if (texto.equals("Error")) {
            pantalla.setText("0");
            texto = "0";
            nuevaEntrada = true;
        }

        if (nuevaEntrada) {
            if (numero.equals(".")) {
                pantalla.setText("0.");
            } else {
                pantalla.setText(numero);
            }

            nuevaEntrada = false;
        } else {
            texto = pantalla.getText().toString();

            if (numero.equals(".") && texto.contains(".")) {
                return;
            }

            if (texto.equals("0") && !numero.equals(".")) {
                pantalla.setText(numero);
            } else {
                pantalla.setText(texto + numero);
            }
        }
    }

    public void seleccionarOperacion(String op) {
        try {
            String texto = pantalla.getText().toString();

            if (texto.equals("Error")) {
                return;
            }

            primerNumero = Double.parseDouble(texto);
            operacion = op;
            nuevaEntrada = true;

        } catch (NumberFormatException e) {
            pantalla.setText("Error");
            nuevaEntrada = true;
        }
    }

    public void calcularResultado() {
        try {
            if (operacion.isEmpty()) {
                return;
            }

            double segundoNumero = Double.parseDouble(
                    pantalla.getText().toString()
            );

            double resultado;

            switch (operacion) {
                case "+":
                    resultado = primerNumero + segundoNumero;
                    break;

                case "-":
                    resultado = primerNumero - segundoNumero;
                    break;

                case "*":
                    resultado = primerNumero * segundoNumero;
                    break;

                case ":":
                    if (segundoNumero == 0) {
                        pantalla.setText("Error");
                        operacion = "";
                        nuevaEntrada = true;
                        return;
                    }

                    resultado = primerNumero / segundoNumero;
                    break;

                default:
                    return;
            }

            if (Double.isNaN(resultado) || Double.isInfinite(resultado)) {
                pantalla.setText("Error");
            } else if (resultado == (long) resultado) {
                pantalla.setText(String.valueOf((long) resultado));
            } else {
                pantalla.setText(String.valueOf(resultado));
            }

            primerNumero = resultado;
            operacion = "";
            nuevaEntrada = true;

        } catch (NumberFormatException e) {
            pantalla.setText("Error");
            operacion = "";
            nuevaEntrada = true;
        }
    }
}
