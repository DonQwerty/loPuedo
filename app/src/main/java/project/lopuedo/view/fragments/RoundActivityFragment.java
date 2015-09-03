package project.lopuedo.view.fragments;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import project.lopuedo.R;
import project.lopuedo.model.MatchModel;
import project.lopuedo.presenter.RoundPresenter;
import project.lopuedo.presenter.ScoresPresenter;
import project.lopuedo.view.adapters.EditAdapter;
import project.lopuedo.view.adapters.ScoreAdapter;
import project.lopuedo.view.interfaces.IRoundView;

/**
 * A placeholder fragment containing a simple view.
 */
public class RoundActivityFragment extends Fragment implements IRoundView, View.OnClickListener {
    private RoundPresenter mScoresPresenter;
    private ListView mList;
    private RoundPresenter mRoundPresenter;

    public RoundActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mScoresPresenter = new RoundPresenter();
        View rootView = inflater.inflate(R.layout.fragment_scores, container, false);
        mList=(ListView) rootView.findViewById(R.id.list_score);
        //mNextButton.setOnClickListener(this);  //ESTA LINEAAAA PETAAAAAAAAAAAA

        MatchModel mm = new MatchModel();
        Cursor round=mm.getRound(getContext());
        EditAdapter adapter = createListAdapter(round);
        createList(adapter);



        return rootView;
    }

    @Override
    public void createList(ListAdapter adapter) {
        mList.setAdapter(adapter);
    }

    @Override
    public EditAdapter createListAdapter(Cursor c) {
        return new EditAdapter(getContext(),c, R.layout.list_item_edit_score);
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
