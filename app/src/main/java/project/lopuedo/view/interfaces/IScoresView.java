package project.lopuedo.view.interfaces;


import android.widget.ListAdapter;

import java.util.List;

import project.lopuedo.model.Player;

public interface IScoresView {

    void createList(ListAdapter scores);

    ListAdapter createListAdapter(List<Player> scores);

    void setScores (String[] names, String[] scores);

    void showNextButton();

    void hideNextButton();

    void showFinishButton();

    void hideFinishButton();

    void goToRoundActivity(int match_id);
}
