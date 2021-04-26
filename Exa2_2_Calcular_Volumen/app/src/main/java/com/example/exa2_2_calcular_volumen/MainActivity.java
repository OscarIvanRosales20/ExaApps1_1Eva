package com.example.exa2_2_calcular_volumen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtTexRadio;
    TextView edtTxtAngulo;
    SeekBar skBrAngulo;
    Double Radio, Angulo, Volumen;
    Button Calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vinculo componentes
        edtTexRadio = (EditText) findViewById(R.id.edtTxRadio);
        skBrAngulo = (SeekBar) findViewById(R.id.skBrAngulo);
        Calcular = (Button) findViewById(R.id.btnCalcular);
        edtTxtAngulo = (TextView) findViewById(R.id.edtTxAngulo);

        //Valor inicial
        skBrAngulo.setProgress(0);
        //Valor Final
        skBrAngulo.setMax(360);

        Calcular.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        skBrAngulo.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //Hacemos un llamado a la perilla cuando se arrasta
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        edtTxtAngulo.setText("" + String.valueOf(progress));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }

    @Override
    public void onClick(View v) {

        //Obtener el valor del radio
        String txtRadio = edtTexRadio.getText().toString();
        Radio = Double.parseDouble(txtRadio);

        //Obtener el valor de Angulp
        String txtAngulo = edtTxtAngulo.getText().toString();
        Angulo = Double.parseDouble(txtAngulo);

        //Calcular Volumen
        Volumen = (0.66666666666666666666667 * (Radio * Angulo * 3));

        Toast.makeText(this, "El resultado es: " + Volumen, Toast.LENGTH_SHORT).show();
    }
}