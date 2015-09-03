package project.lopuedo.view.fragments;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import project.lopuedo.R;
import project.lopuedo.presenter.RoundPresenter;
import project.lopuedo.view.adapters.ScoreAdapter;
import project.lopuedo.view.interfaces.IRoundView;

/**
 * A placeholder fragment containing a simple view.
 */
public class RoundActivityFragment extends Fragment implements IRoundView, View.OnClickListener {

    private RoundPresenter mRoundPresenter;

    public RoundActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_round, container, false);
    }

    @Override
    public void createList(ListAdapter scores) {

    }

    @Override
    public ScoreAdapter createListAdapter(Cursor c) {
        return null;
    }

    @Override
    public String[] getPlayers() {
        return new String[0];
    }

    @Override
    public String[] getScores() {
        return new String[0];
    }

    @Override
    public void setScores(String[] players, String[] scores) {

    }

    @Override
    public void goToScoresActivity() {

    }

    @Override
    public void onClick(View v) {

    }
}
