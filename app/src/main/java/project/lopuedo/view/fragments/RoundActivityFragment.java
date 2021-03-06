package project.lopuedo.view.fragments;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import project.lopuedo.R;
import project.lopuedo.model.MatchModel;
import project.lopuedo.presenter.RoundPresenter;
import project.lopuedo.view.adapters.EditAdapter;
import project.lopuedo.view.interfaces.IRoundView;

/**
 * Fragment to set each round scores.
 */
public class RoundActivityFragment extends Fragment implements IRoundView {
    private RoundPresenter mRoundPresenter;
    private ListView mList;
    private Cursor scores;
    private int matchId;
    private int round;

    public RoundActivityFragment() {
    }

    public static RoundActivityFragment newInstance(int matchId,int round) {
        RoundActivityFragment instance = new RoundActivityFragment();
        Bundle args = new Bundle();
        args.putInt("matchId", matchId);
        args.putInt("round", round);
        instance.setArguments(args);
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Get matchId
        Bundle bundle = getArguments();
        matchId = bundle.getInt("matchId");
        round = bundle.getInt("round");
        MatchModel mm = new MatchModel();
        mRoundPresenter = new RoundPresenter();
        mRoundPresenter.onCreate(this, matchId);
        
        View rootView = inflater.inflate(R.layout.fragment_scores, container, false);
        mList=(ListView) rootView.findViewById(R.id.list_score);
        if(round==1){
            mm.updatePlayer(getActivity(),matchId,0,"Pedro",0);
            mm.updatePlayer(getActivity(),matchId,0,"Juan",0);
        }
        scores=mm.getRound(getActivity(),matchId,0);

        EditAdapter adapter = createListAdapter(scores);
        createList(adapter);

        return rootView;
    }

    public void saveScores() {

        int mCount = mList.getCount();

        for (int i = 0; i < mCount; i++) {
            View curr = mList.getChildAt(i);
            TextView tName = (TextView) curr.findViewById(R.id.list_item_name);
            TextView tScores = (TextView) curr.findViewById(R.id.list_item_score);
            mRoundPresenter.setScore(getActivity(), round,
                    tName.getText().toString(), Integer.parseInt(tScores.getText().toString()));
        }

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
}