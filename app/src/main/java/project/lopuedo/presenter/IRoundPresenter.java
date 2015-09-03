package project.lopuedo.presenter;

import project.lopuedo.view.interfaces.IRoundView;

public interface IRoundPresenter {
    void onCreate(IRoundView view);
    void showList();
    void goToScoresActivity();
    void setScores();
}
