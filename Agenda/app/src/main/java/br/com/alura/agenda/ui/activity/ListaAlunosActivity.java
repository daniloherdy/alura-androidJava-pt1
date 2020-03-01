package br.com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.alura.agenda.R;
import br.com.alura.agenda.dao.AlunoDAO;

//Aula 04 - AppCompatActivity implementa a AppBar Automaticamente e dar suporte a versões antigas do Android
public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Alunos";
    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Aula 02
        //setContentView = Buscar a View da Activity
        //R. = Resources
        setContentView(R.layout.activity_lista_alunos);
        //Aula 04 - Titulo da App
        setTitle(TITULO_APPBAR);
        configuraFabNovoAluno();
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_adicionar_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abriFormularioAlunoActivity();
            }
        });
    }

    private void abriFormularioAlunoActivity() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    //Aula 05
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        //Aula 02
        // findViewById = Busca a View(View neste caso é o objetc (controle de tela))
        ListView listaAlunos = findViewById(R.id.activity_lista_alunos_listview);
        //Aula 02
        //android.R = Resources do pacote Android
        //setAdapter = setando o Adapter necessario para o uso dinâmico
        listaAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));
    }
}
