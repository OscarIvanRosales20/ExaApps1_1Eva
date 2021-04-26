package com.example.exa2_1acredita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Creo mis componentes
    TextView txtVwCal, txtVwAcreditar, txtVwResul;
    EditText edtTxtNombre, edtTxtNumero;
    SeekBar skBr1, skBr2;
    int Cred, Cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conecto los componentes
        txtVwCal = (TextView)findViewById(R.id.txtVwCal);
        txtVwAcreditar = (TextView)findViewById(R.id.txtVwAcreditar);
        txtVwResul = (TextView)findViewById(R.id.txtResul);
        edtTxtNombre = (EditText)findViewById(R.id.edtTxtNombre);
        edtTxtNumero =  (EditText)findViewById(R.id.edtTxtNumero);

        edtTxtNombre.requestFocus(); //Asegurar que el EditText tiene el foco

        edtTxtNombre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edtTxtNombre.getWindowToken(), 0);
                }
            }
        });

        //SeekBar Acreditar
        skBr1 = (SeekBar)findViewById(R.id.seekBar1);
        //Valor inicial
        skBr1.setProgress(0);
        //Valor Final
        skBr1.setMax(100);

        //SeekBar Calificación
        skBr2 = (SeekBar)findViewById(R.id.skBr2);
        //Valor inicial
        skBr2.setProgress(0);
        //Valor Final
        skBr2.setMax(100);
    }

    @Override
    protected void onStart() {
        super.onStart();

        skBr1.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //Hacemos un llamado a la perilla cuando se arrasta
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        txtVwAcreditar.setText("Puntos para Acreditar: " + String.valueOf(progress));
                        Cred = progress;
                        Resul(Cred, Cal);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        skBr2.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //Hacemos un llamado a la perilla cuando se arrasta
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        txtVwCal.setText("Calificación: " + String.valueOf(progress));
                        Cal = progress;
                        Resul(Cred, Cal);
                    }

                    //Metodo cuando se toca la perilla
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    //Metodo cuando se detiene la periilla
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }

    public void Resul(int Acre, int Cal){
        if (Acre >= Cal){
            txtVwResul.setText("No Acreditado");
        } else if (Acre < Cal){
            txtVwResul.setText("Acreditado");
        }
    }
}