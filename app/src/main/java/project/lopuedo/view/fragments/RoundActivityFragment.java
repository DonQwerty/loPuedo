package project.lopuedo.view.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import project.lopuedo.R;
import project.lopuedo.model.MatchModel;
import project.lopuedo.presenter.RoundPresenter;
import project.lopuedo.view.activities.ScoresActivity;
import project.lopuedo.view.adapters.EditAdapter;
import project.lopuedo.view.interfaces.IRoundView;

/**
 * Fragment to set each round scores.
 */
public class RoundActivityFragment extends Fragment implements IRoundView {
    private RoundPresenter mRoundPresenter;
    private ListView mList;

    public RoundActivityFragment() {
    }

    public static RoundActivityFragment newInstance() {
        RoundActivityFragment instance = new RoundActivityFragment();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRoundPresenter = new RoundPresenter();
        mRoundPresenter.onCreate(this);
        View rootView = inflater.inflate(R.layout.fragment_scores, container, false);
        mList=(ListView) rootView.findViewById(R.id.list_score);

        MatchModel mm = new MatchModel();
        Cursor round=mm.getRound(getActivity());
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
        return new EditAdapter(getActivity(),c, R.layout.list_item_edit_score);
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
    public void goToScoresActivity(int match_id) {
        Intent intent = new Intent(getActivity(), ScoresActivity.class);
        intent.putExtra("MATCH", match_id);
        startActivity(intent);
    }
}
