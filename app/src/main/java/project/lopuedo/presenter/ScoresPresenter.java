package project.lopuedo.presenter;


import project.lopuedo.model.IMatchModel;
import project.lopuedo.model.MatchModel;
import project.lopuedo.view.interfaces.IScoresView;

public class ScoresPresenter implements IScoresPresenter{

    private IScoresView mScoresView;
    private IMatchModel mMatchModel;

    public void onCreate (IScoresView view) {
        mScoresView = view;
        mMatchModel = new MatchModel();
        // TODO Obtener del intent y pasar el ID
        mMatchModel.setMatchId(0);
    }

    @Override
    public void goToRoundActivity() {
        mScoresView.goToRoundActivity(mMatchModel.getMatchId());
    }

    public void loadScores () {

    }

    public boolean isFinished() {
        return mMatchModel.isFinished();
    }

}
