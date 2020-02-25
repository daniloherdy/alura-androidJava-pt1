package br.com.alura.agenda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Aula 02
        //setContentView = Buscar a View da Activity
        //R. = Resources
        setContentView(R.layout.activity_main);
        List<String> nomesAluno = new ArrayList<>(Arrays.asList("Danilo","Herdy","Oliveira","Ryuu"));
        //Aula 02
        // findViewById = Busca a View(View neste caso é o objetc (controle de tela))
        ListView listaAlunos = findViewById(R.id.activity_main_lista_alunos);
        //Aula 02
        //android.R = Resources do pacote Android
        //setAdapter = setando o Adapter necessario para o uso dinâmico
        listaAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,nomesAluno));

    }
}
