package project.lopuedo.view.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import project.lopuedo.R;
import project.lopuedo.model.Player;
import project.lopuedo.presenter.ScoresPresenter;
import project.lopuedo.view.activities.ScoresActivity;
import project.lopuedo.view.interfaces.IScoresView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ScoresActivityFragment extends Fragment  implements IScoresView, View.OnClickListener {

    private Button mNextButton;
    private ScoresPresenter mScoresPresenter;
    private ListView mList;

    public ScoresActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mScoresPresenter = new ScoresPresenter();
        mNextButton.setOnClickListener(this);

        // TODO Quitar mierdas de Dani
        String[] data={
                "Today - Sunny - 88/66",
                "Tomorrow - Cloudy - 88/66",
                "Weds - Sunny - 88/66",
                "Thurs - Sunny - 88/66",
                "Fri - Sunny - 88/66",
                "Sat - Sunny - 88/66",
                "Sun - Sunny - 88/66",
                "Mon - Sunny - 88/66"

        };
        List<String> list_score= new ArrayList<String>();
        list_score= Arrays.asList(data);
        View rootView = inflater.inflate(R.layout.fragment_scores, container, false);
        ArrayAdapter<String> adapter= new ArrayAdapter<>(getActivity(),R.layout.list_item_score,R.id.score_points,list_score);
        ListView vist=(ListView) rootView.findViewById(R.id.list_score);
        vist.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        // Change to scores assignment
        mScoresPresenter.goToRoundActivity();
    }

    @Override
    public void createList(ListAdapter adapter) {
        mList.setAdapter(adapter);
    }

    @Override
    public ListAdapter createListAdapter(List<Player> scores) {
        // TODO Dani, haz tu magia
        return null;
    }

    @Override
    public void setScores(String[] names, String[] scores) {
        // TODO Aqui actualizar la lista
    }

    @Override
    public void showNextButton() {
        mNextButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNextButton() {
        mNextButton.setVisibility(View.GONE);
    }

    @Override
    public void showFinishButton() {

    }

    @Override
    public void hideFinishButton() {

    }

    @Override
    public void goToRoundActivity(int match_id) {
        Intent intent = new Intent(getActivity(), ScoresActivity.class);
        intent.putExtra("MATCH", match_id);
        startActivity(intent);
    }
}
