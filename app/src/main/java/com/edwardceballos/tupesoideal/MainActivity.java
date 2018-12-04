package com.edwardceballos.tupesoideal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class MainActivity extends AppCompatActivity {

    EditText etAltura;
    EditText etPeso;
    Button btnCalcular;
    TextView resultado;
    ImageView imagen;
    String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = (EditText) findViewById(R.id.etPeso);
        etAltura = (EditText) findViewById(R.id.etAltura);
        resultado = (TextView) findViewById(R.id.resultado);
        btnCalcular = (Button) findViewById(R.id.calcular);
        imagen = (ImageView) findViewById(R.id.imagen);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double peso, altura, imc;

                if (etPeso.getText().toString().length() < 1 || etAltura.getText().toString().length() < 1) {
                    Toast.makeText(getApplicationContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                }
                else {
                    peso = Double.parseDouble(etPeso.getText().toString());
                    altura = Double.parseDouble(etAltura.getText().toString());

                    imc = peso / Math.pow(altura, 2);

                    /*
                     * Menor a 18,5: Peso insuficiente
                     * 18,5 – 24,9: Peso normal (normopeso, el comúnmente conocido como peso ideal)
                     * 25 – 26,9: Puede haber sobrepeso grado I
                     * 27 – 29,9: Sobrepeso tipo I (preobesidad)
                     * 30 – 34,9: Obesidad tipo I (leve)
                     * 35 – 39,9: Obesidad tipo II (moderada)
                     * 40 – 19,9: Obesidad tipo III (mórbida)
                     * Mayor a 50: Obesidad extrema
                     */

                    if (imc < 18.5) {
                        texto = "Peso insuficiente";
                        resultado.setText(texto+" (IMC = "+String.format("%.2f", imc)+")");
                        Picasso.get().load(R.drawable.img0).into(imagen);
                        Crouton.makeText(MainActivity.this, texto, Style.INFO).show();
                    }
                    else if (imc < 25) {
                        texto = "Peso normal";
                        resultado.setText(texto+" (IMC = "+String.format("%.2f", imc)+")");
                        Picasso.get().load(R.drawable.img1).into(imagen);
                        Crouton.makeText(MainActivity.this, texto, Style.CONFIRM).show();
                    }
                    else if (imc < 27) {
                        texto = "Puede haber sobrepeso grado I";
                        resultado.setText(texto+" (IMC = "+String.format("%.2f", imc)+")");
                        Picasso.get().load(R.drawable.img2).into(imagen);
                        Crouton.makeText(MainActivity.this, texto, Style.ALERT).show();
                    }
                    else if (imc < 30) {
                        texto = "Sobrepeso tipo I";
                        resultado.setText(texto+" (IMC = "+String.format("%.2f", imc)+")");
                        Picasso.get().load(R.drawable.img3).into(imagen);
                        Crouton.makeText(MainActivity.this, texto, Style.ALERT).show();
                    }
                    else if (imc < 35) {
                        texto = "Sobrepeso tipo II";
                        resultado.setText(texto+" (IMC = "+String.format("%.2f", imc)+")");
                        Picasso.get().load(R.drawable.img4).into(imagen);
                        Crouton.makeText(MainActivity.this, texto, Style.ALERT).show();
                    }
                    else if (imc < 40) {
                        texto = "Sobrepeso tipo III";
                        resultado.setText(texto+" (IMC = "+String.format("%.2f", imc)+")");
                        Picasso.get().load(R.drawable.img5).into(imagen);
                        Crouton.makeText(MainActivity.this, texto, Style.ALERT).show();
                    } else {
                        texto = "Obesidad extrema";
                        resultado.setText(texto+" (IMC = "+String.format("%.2f", imc)+")");
                        Picasso.get().load(R.drawable.img6).into(imagen);
                        Crouton.makeText(MainActivity.this, texto, Style.ALERT).show();
                    }
                }
            }
        });
    }
}
