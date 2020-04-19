package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText numeroUsuario;
    private TextView numeroParaMotrar;
    private int numeroGenerado;
    private Button calcular;
    private Button salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numeroUsuario = (EditText)findViewById(R.id.txtnumero);
        numeroParaMotrar = (TextView)findViewById(R.id.lblnumero);
        calcular = (Button)findViewById(R.id.btngenerar);
        salir = (Button)findViewById(R.id.btnsalir);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Random aleatorio = new Random();

                 if(numeroUsuario.getText().toString().isEmpty())
                 {
                     Toast.makeText(MainActivity.this, "Por favor digite un número", Toast.LENGTH_SHORT).show();
                 }
                 else {
                     numeroGenerado = (int)(aleatorio.nextDouble()*100+1);

                     numeroParaMotrar.setText("El número es: " + Integer.toString(numeroGenerado));
                     numeroParaMotrar.setVisibility(View.VISIBLE);

                     if(numeroGenerado == Integer.parseInt(numeroUsuario.getText().toString()))
                     {
                         Toast.makeText(MainActivity.this, "¡Has ganado!", Toast.LENGTH_LONG).show();
                     }
                     else
                     {
                         Toast perder = Toast.makeText(MainActivity.this, "Sigue intentando.", Toast.LENGTH_SHORT);
                         perder.setGravity(Gravity.TOP,0,150);
                         perder.show();
                     }
                 }
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
