package project.lopuedo;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ScoresActivityFragment extends Fragment {

    public ScoresActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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
        List<String> list_score=new ArrayList<>();
        list_score= Arrays.asList(data);
        View rootView = inflater.inflate(R.layout.fragment_scores, container, false);
        ArrayAdapter<String> adapter= new ArrayAdapter<>(getActivity(),R.layout.list_item_score,R.id.score_points,list_score);
        ListView vist=(ListView) rootView.findViewById(R.id.list_score);
        vist.setAdapter(adapter);

        return rootView;
    }
}
