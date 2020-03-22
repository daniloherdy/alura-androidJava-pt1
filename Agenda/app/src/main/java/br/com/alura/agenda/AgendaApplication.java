package br.com.alura.agenda;

import android.app.Application;

import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

@SuppressWarnings("WeakerAccess")
public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDAO();
    }

    private void criaAlunosDAO() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Danilo", "122233", "a@a.com"));
        dao.salva(new Aluno("Herdy", "122233", "b@a.com"));
    }

}
