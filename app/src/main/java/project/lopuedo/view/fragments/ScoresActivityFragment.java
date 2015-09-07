package project.lopuedo.view.fragments;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import project.lopuedo.R;
import project.lopuedo.model.MatchModel;
import project.lopuedo.presenter.ScoresPresenter;
import project.lopuedo.view.adapters.ScoreAdapter;
import project.lopuedo.view.interfaces.IScoresView;

/**
 * Fragment to display each round scores.
 */
public class ScoresActivityFragment extends Fragment  implements IScoresView {

    private ScoresPresenter mScoresPresenter;
    private ListView mList;
    private int matchId;
    private int round;

    public ScoresActivityFragment() {
    }

    public static ScoresActivityFragment newInstance(int matchId,int round) {
        ScoresActivityFragment instance = new ScoresActivityFragment();
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
        /////Estas funciones van mientras no haya el de añadir puntuaciones


        mScoresPresenter = new ScoresPresenter();
        mScoresPresenter.onCreate(this, matchId);
        View rootView = inflater.inflate(R.layout.fragment_scores, container, false);
        mList=(ListView) rootView.findViewById(R.id.list_score);

        MatchModel mm = new MatchModel();
        Cursor round=mm.getRound(getActivity(),matchId);
        ScoreAdapter adapter = createListAdapter(round);
        createList(adapter);



        return rootView;
    }

    @Override
    public void createList(ListAdapter adapter) {
        mList.setAdapter(adapter);
    }

    @Override
    public ScoreAdapter createListAdapter(Cursor c) {
        return new ScoreAdapter(getActivity(),c, R.layout.list_item_score);
    }



//    @Override
//    public void setScores(String[] names, String[] scores) {
//        // TODO Aqui actualizar la lista
//    }

    @Override
    public void showNextButton() {

    }

    @Override
    public void showList() {
        mList.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNextButton() {

    }

    @Override
    public void showFinishButton() {

    }

    @Override
    public void hideFinishButton() {

    }
}
