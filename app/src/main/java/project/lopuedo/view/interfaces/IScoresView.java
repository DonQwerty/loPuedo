package project.lopuedo.view.interfaces;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListAdapter;

import java.util.List;

import project.lopuedo.model.Player;
import project.lopuedo.view.adapters.ScoreAdapter;

public interface IScoresView {

    void createList(ListAdapter scores);

    ScoreAdapter createListAdapter(Cursor c);

    // TODO Probablemente no deberia recibir dos String[]
    // void setScores (String[] names, String[] scores);

    void showNextButton();

    void hideNextButton();

    void showFinishButton();

    void hideFinishButton();

    void showList();

    void goToRoundActivity(int match_id);
}
