package project.lopuedo.presenter;

import android.content.Context;

import project.lopuedo.model.IMatchModel;
import project.lopuedo.model.MatchModel;
import project.lopuedo.view.interfaces.IRoundView;

public class RoundPresenter implements IRoundPresenter {
    private IRoundView mRoundView;
    private IMatchModel mMatchModel;
    private int matchId;
    @Override
    public void onCreate(IRoundView view, int matchID) {
        mRoundView = view;
        matchId = matchID;
        mMatchModel = new MatchModel();
        mMatchModel.setMatchId(matchID);
    }

    public void setScore(Context context, int round, String name, int score) {
        mMatchModel.updatePlayer(context, matchId, round, name, score);
    }
}
