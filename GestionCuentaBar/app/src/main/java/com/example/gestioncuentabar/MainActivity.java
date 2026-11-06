package com.example.gestioncuentabar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText edtCuenta;
    private CheckBox chkPropina;
    private SeekBar seekPropina;
    private TextView txtPorcentaje;
    private RadioGroup radioPago;
    private RadioButton radioEfectivo;
    private RadioButton radioTarjeta;
    private RatingBar ratingServicio;
    private Button btnCalcular;
    private TextView txtResultado;
    private TextView txtTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtCuenta = findViewById(R.id.edtCuenta);
        chkPropina = findViewById(R.id.chkPropina);
        seekPropina = findViewById(R.id.seekPropina);
        txtPorcentaje = findViewById(R.id.txtPorcentaje);
        radioPago = findViewById(R.id.radioPago);
        radioEfectivo = findViewById(R.id.radioEfectivo);
        radioTarjeta = findViewById(R.id.radioTarjeta);
        ratingServicio = findViewById(R.id.ratingServicio);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);
        txtTitulo = findViewById(R.id.txtTitulo);


    }
}