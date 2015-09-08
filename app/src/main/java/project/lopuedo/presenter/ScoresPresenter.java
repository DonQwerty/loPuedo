package project.lopuedo.presenter;


import project.lopuedo.model.IMatchModel;
import project.lopuedo.model.MatchModel;
import project.lopuedo.view.interfaces.IScoresView;

public class ScoresPresenter implements IScoresPresenter{

    private IScoresView mScoresView;
    private IMatchModel mMatchModel;

    public void onCreate (IScoresView view, int matchID) {
        mScoresView = view;
        mMatchModel = new MatchModel();
        mMatchModel.setMatchId(matchID);
    }

    public boolean isFinished() {
        return mMatchModel.isFinished();
    }

}
