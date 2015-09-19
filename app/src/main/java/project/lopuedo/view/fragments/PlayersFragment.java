package project.lopuedo.view.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import project.lopuedo.R;


public class PlayersFragment extends Fragment {

    private int matchId;
    private ListView playersList;
    private ArrayList<String> players;
    private ArrayAdapter<String> adapter;

    public static PlayersFragment newInstance(int matchId) {
        PlayersFragment fragment = new PlayersFragment();
        Bundle args = new Bundle();
        args.putInt("matchId", matchId);
        fragment.setArguments(args);
        return fragment;
    }

    public PlayersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            matchId = getArguments().getInt("matchId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        players = new ArrayList<>();
        adapter = new ArrayAdapter<>(getActivity(), R.layout.list_item_players, players);

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_players, container, false);
        playersList=(ListView) rootView.findViewById(R.id.list_players);

        return rootView;
    }
}
