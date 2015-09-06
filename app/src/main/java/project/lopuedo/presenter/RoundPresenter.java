package project.lopuedo.presenter;

import project.lopuedo.model.IMatchModel;
import project.lopuedo.model.MatchModel;
import project.lopuedo.view.interfaces.IRoundView;

public class RoundPresenter implements IRoundPresenter {
    private IRoundView mRoundView;
    private IMatchModel mMatchModel;
    @Override
    public void onCreate(IRoundView view, int matchID) {
        mRoundView = view;
        mMatchModel = new MatchModel();
        mMatchModel.setMatchId(matchID);
    }

    @Override
    public void showList() {

    }

    @Override
    public void setScores() {

    }
}
