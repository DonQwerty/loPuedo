package project.lopuedo.view.interfaces;

import android.database.Cursor;
import android.widget.ListAdapter;

import project.lopuedo.view.adapters.EditAdapter;

public interface IRoundView {

    void createList(ListAdapter scores);

    //TODO Quizá te haga falta otro adapter
    EditAdapter createListAdapter(Cursor c);

    // TODO Probablemente no deberian devolver estas estructuras
    String[] getPlayers();
    String[] getScores();

    // TODO Los status suelen estar bien
    // TODO Lo del string seria mejor un id o algo
    //      o recibir un tipo Player, eso si que sería genial
    void setScores(String[] players, String[] scores);

}
