package com.example.nutrilife20_lara;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton btnTadioFeminino, btnRadioMasculino;
    private Button btnCalcular;
    private EditText editTextNome, editTextPeso, editTextAltura, editTextCintura, editTextQuadril;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radioGroup = findViewById(R.id.radioGroup);
        editTextNome = findViewById(R.id.editTextNome);
        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        editTextCintura = findViewById(R.id.editTextCintura);
        editTextQuadril = findViewById(R.id.editTextQuadril);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                int id = radioGroup.getCheckedRadioButtonId();
                String textPeso = editTextPeso.getText().toString();
                String textAlt = editTextAltura.getText().toString();
                String textCint = editTextCintura.getText().toString();
                String textQuad = editTextQuadril.getText().toString();

                if(nome.isEmpty()){
                    Toast.makeText(MainActivity.this, "Informe Seu Nome!", Toast.LENGTH_SHORT).show();
                }
                if(textPeso.isEmpty()){
                    Toast.makeText(MainActivity.this, "Informe Seu Peso!", Toast.LENGTH_SHORT).show();
                }
                if(textAlt.isEmpty()){
                    Toast.makeText(MainActivity.this, "Informe Sua Altura!", Toast.LENGTH_SHORT).show();
                }
                if(textCint.isEmpty()){
                    Toast.makeText(MainActivity.this, "Informe A Medida da Sua Cintura", Toast.LENGTH_SHORT).show();
                }
                if(textQuad.isEmpty()){
                    Toast.makeText(MainActivity.this, "Informe a Medida da Seu Quadril", Toast.LENGTH_SHORT).show();
                }
                if(id == -1){
                    Toast.makeText(MainActivity.this, "Informe Seu Sexo!", Toast.LENGTH_SHORT).show();
                }
                if(nome.isEmpty() || textPeso.isEmpty() || textAlt.isEmpty()
                        || textCint.isEmpty() || textQuad.isEmpty() || id == -1){
                    return;
                }

                RadioButton radioButton = findViewById(id);
                String sexo = radioButton.getText().toString();

                float peso = Float.parseFloat(textPeso);
                float altura = Float.parseFloat(textAlt);
                float cintura = Float.parseFloat(textCint);
                float quadril = Float.parseFloat(textQuad);


                AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                alerta.setTitle("Confirmação");
                alerta.setIcon(R.drawable.img);
                alerta.setMessage("Vamos Calcular?");
                alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("nome", nome);
                        intent.putExtra("peso", peso);
                        intent.putExtra("altura", altura);
                        intent.putExtra("cintura", cintura);
                        intent.putExtra("quadril", quadril);
                        intent.putExtra("sexo", sexo);

                        startActivity(intent);
                        }
                    });
                    alerta.setNegativeButton("Não", null);
                    alerta.create().show();


            }
        });

    }
}