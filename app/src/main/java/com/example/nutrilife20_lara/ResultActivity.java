package com.example.nutrilife20_lara;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity{
    private Button btnVoltar, btnCompartilhar;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        btnCompartilhar = findViewById(R.id.btnCompartilhar);
        btnVoltar = findViewById(R.id.btnVoltar);
        textView = findViewById(R.id.textResultado);
        String nome = intent.getStringExtra("nome");
        String sexo = intent.getStringExtra("sexo");
        float peso = intent.getFloatExtra("peso", 0);
        float altura = intent.getFloatExtra("altura", 0);
        float cintura = intent.getFloatExtra("cintura", 0);
        float quadril = intent.getFloatExtra("quadril", 0);

        float imc = peso / (altura * altura);
        float rcq = cintura / quadril;

        if (imc < 17.0) {
            StringBuilder resultado = new StringBuilder("Olá, " + nome);
            resultado.append("\n\n");
            resultado.append("O calculo do seu IMC resultou em: " + String.format("%.2f", imc)).append("\n");
            resultado.append("Clasificado como: Muito Abaixo do Peso!").append("\n");
            resultado.append("O que pode acontecer: Maior risco de problemas de saúde, deficiências nutricionais, \n " +
                    "redução do desempenho físico e fraqueza/letargia").append("\n");
            resultado.append("Entre em contado com médicos para melhorar sua saúde!").append("\n");
            textView.setText(resultado.toString());
        } else if (17.0 <= imc && imc <= 18.4) {
            StringBuilder resultado = new StringBuilder("Olá, " + nome);
            resultado.append("\n\n");
            resultado.append("O calculo do seu IMC resultou em: " + String.format("%.2f", imc)).append("\n");
            resultado.append("Clasificado como: Abaixo do Peso!").append("\n");
            resultado.append("O que pode acontecer: deficiências nutricionais, \n " +
                    "e problemas relacionados ao baixo peso").append("\n");
            resultado.append("Entre em contado com médicos para melhorar sua saúde!").append("\n");
            textView.setText(resultado.toString());
        } else if (18.5 <= imc && imc <= 24.9) {
            StringBuilder resultado = new StringBuilder("Olá, " + nome);
            resultado.append("\n\n");
            resultado.append("O calculo do seu IMC resultou em: " + String.format("%.2f", imc)).append("\n");
            resultado.append("Clasificado como: Peso Normal!").append("\n");
            resultado.append("Faixa de peso considerada adequada para a maioria dos adultos").append("\n");
            resultado.append("Viva Saudável, Nutri Life!").append("\n");
            textView.setText(resultado.toString());
        } else if (25.0 <= imc && imc <= 29.9) {
            StringBuilder resultado = new StringBuilder("Olá, " + nome);
            resultado.append("\n\n");
            resultado.append("O calculo do seu IMC resultou em: " + String.format("%.2f", imc)).append("\n");
            resultado.append("Clasificado como: Sobrepeso!").append("\n");
            resultado.append("O que pode acontecer: Maior risco de alterações metabólicas, " +
                    "diabetes tipo 2 e doenças cardiovasculares").append("\n");
            resultado.append("Entre em contado com médicos para melhorar sua saúde!").append("\n");
            textView.setText(resultado.toString());
        } else if (30.0 <= imc && imc <= 34.9) {
            StringBuilder resultado = new StringBuilder("Olá, " + nome);
            resultado.append("\n\n");
            resultado.append("O calculo do seu IMC resultou em: " + String.format("%.2f", imc)).append("\n");
            resultado.append("Clasificado como: Obesidade Grau I!").append("\n");
            resultado.append("O que pode acontecer: Risco elevado de diabetes tipo 2, hipertensão e doenças cardiovasculares").append("\n");
            resultado.append("Entre em contado com médicos para melhorar sua saúde!").append("\n");
            textView.setText(resultado.toString());
        } else if (35.0 <= imc && imc <= 39.9) {
            StringBuilder resultado = new StringBuilder("Olá, " + nome);
            resultado.append("\n\n");
            resultado.append("O calculo do seu IMC resultou em: " + String.format("%.2f", imc)).append("\n");
            resultado.append("Clasificado como: Obesidade Grau II").append("\n");
            resultado.append("O que pode acontecer: Risco muito elevado de complicações metabólicas, cardiovasculares e respiratórias").append("\n");
            resultado.append("Entre em contado com médicos para melhorar sua saúde!").append("\n");
            textView.setText(resultado.toString());
        }else{
            StringBuilder resultado = new StringBuilder("Olá, " + nome);
            resultado.append("\n\n");
            resultado.append("O calculo do seu IMC resultou em: " + String.format("%.2f", imc)).append("\n");
            resultado.append("Clasificado como: Obesidade Grau III").append("\n");
            resultado.append("O que pode acontecer: Risco muitíssimo elevado de comorbidades e comprometimento da\n" +
                    "saúde e qualidade de vida").append("\n");
            resultado.append("Entre em contado com médicos para melhorar sua saúde!").append("\n");
            textView.setText(resultado.toString());
        }


        if(sexo.equals("Masculino")){
            if(rcq < 0.90){
                StringBuilder resultado = new StringBuilder("RCQ:");
                resultado.append(" "+ String.format("%.2f", rcq)).append("\n");
                resultado.append("Classificação: Normal\n");
                textView.append(resultado.toString());
            }
            else{
                StringBuilder resultado = new StringBuilder("RCQ:");
                resultado.append(" "+ String.format("%.2f", rcq)).append("\n");
                resultado.append("Classificação: Risco Aumentado\n");
                textView.append(resultado.toString());
            }
        }else{
            if(rcq < 0.85){
                StringBuilder resultado = new StringBuilder("RCQ:");
                resultado.append(" "+ String.format("%.2f", rcq)).append("\n");
                resultado.append("Classificação: Normal\n");
                textView.append(resultado.toString());
            }
            else{
                StringBuilder resultado = new StringBuilder("RCQ:");
                resultado.append(" "+ String.format("%.2f", rcq)).append("\n");
                resultado.append("Classificação: Risco Aumentado\n");
                textView.append(resultado.toString());
            }
        }
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnCompartilhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto = textView.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, texto);

                startActivity(Intent.createChooser(intent, "Compartilhar resultado"));
            }
        });
    }

}
