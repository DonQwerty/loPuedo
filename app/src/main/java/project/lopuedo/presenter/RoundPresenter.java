package project.lopuedo.presenter;

import project.lopuedo.model.IMatchModel;
import project.lopuedo.model.MatchModel;
import project.lopuedo.view.interfaces.IRoundView;

public class RoundPresenter implements IRoundPresenter {
    private IRoundView mRoundView;
    private IMatchModel mMatchModel;
    @Override
    public void onCreate(IRoundView view) {
        mRoundView = view;
        mMatchModel = new MatchModel();
        // TODO Obtener del intent y pasar el ID
        mMatchModel.setMatchId(0);
    }

    @Override
    public void showList() {

    }

    @Override
    public void setScores() {

    }

    @Override
    public void goToScoresActivity() {
        mRoundView.goToScoresActivity(mMatchModel.getMatchId());
    }
}
