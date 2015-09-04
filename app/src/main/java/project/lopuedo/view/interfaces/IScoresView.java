package project.lopuedo.view.interfaces;


import android.database.Cursor;
import android.widget.ListAdapter;

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
