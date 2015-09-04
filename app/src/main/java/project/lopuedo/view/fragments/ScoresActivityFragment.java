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
import project.lopuedo.presenter.ScoresPresenter;
import project.lopuedo.view.activities.RoundActivity;
import project.lopuedo.view.adapters.ScoreAdapter;
import project.lopuedo.view.interfaces.IScoresView;

/**
 * Fragment to display each round scores.
 */
public class ScoresActivityFragment extends Fragment  implements IScoresView {

    private ScoresPresenter mScoresPresenter;
    private ListView mList;

    public ScoresActivityFragment() {
    }

    public static ScoresActivityFragment newInstance() {
        ScoresActivityFragment instance = new ScoresActivityFragment();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mScoresPresenter = new ScoresPresenter();
        mScoresPresenter.onCreate(this);
        View rootView = inflater.inflate(R.layout.fragment_scores, container, false);
        mList=(ListView) rootView.findViewById(R.id.list_score);

        MatchModel mm = new MatchModel();
        Cursor round=mm.getRound(getActivity());
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

    @Override
    public void goToRoundActivity(int match_id) {
        Intent intent = new Intent(getActivity(), RoundActivity.class);
        intent.putExtra("MATCH", match_id);
        startActivity(intent);
    }
}
