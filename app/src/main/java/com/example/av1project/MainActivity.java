package com.example.av1project;

import android.content.DialogInterface;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDialog(View view){

        TextInputEditText editName = findViewById(R.id.editName);
        TextInputEditText editIdade = findViewById(R.id.editIdade);
        RadioButton sexoMasc  = findViewById(R.id.sexoMasc);
        RadioButton sexoFem   = findViewById(R.id.sexoFem);
        RadioButton sexoOutro = findViewById(R.id.sexoOutro);
        CheckBox opc20a40 = findViewById(R.id.opc20a40);
        CheckBox opcMaisD60 = findViewById(R.id.opcMaisD60);
        CheckBox levPeso = findViewById(R.id.levPeso);
        CheckBox caminhando = findViewById(R.id.caminhando);
        CheckBox coracao = findViewById(R.id.coracao);
        CheckBox pAlta = findViewById(R.id.pAlta);
        CheckBox idPai = findViewById(R.id.idPai);
        CheckBox idMae = findViewById(R.id.idMae);
        CheckBox idavo = findViewById(R.id.idavo);
        CheckBox idMuscular = findViewById(R.id.idMuscular);

        String name = editName.getText().toString();
        int idade = Integer.parseInt(editIdade.getText().toString());
        String sexo = "";
        String resultado = "";

        if( sexoMasc.isChecked() ){
            sexo = "Masculino";
        }else if( sexoFem.isChecked() ){
            sexo = "Feminino";
        }else{
            sexo = "LGBTQA+ ou não binario";
        }

        if( idade > 45 && opcMaisD60.isChecked() && levPeso.isChecked() && idPai.isChecked() || idMae.isChecked() && coracao.isChecked() || pAlta.isChecked() ){
            resultado = "O paciente " + name + " precisa com urgencia ser atendido por um cardiologista!";
        }

        if( idade < 45 && opc20a40.isChecked() && caminhando.isChecked() && idavo.isChecked() && idMuscular.isChecked() ){
            resultado = "O paciente " + name + " no momento não apresenta nehuma queixa que possa ser encaminhado a alguma especialidade";
        }

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Resultado da pesquisa");
        dialog.setMessage("A mensagem vem logo abaixo\n" + name + "\n" + "Idade: "+ idade +"\n"+  "Sexo: "+ sexo + "\n"+ resultado);
        dialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.create();
        dialog.show();
    }

}