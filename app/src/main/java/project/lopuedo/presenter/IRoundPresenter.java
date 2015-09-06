package project.lopuedo.presenter;

import project.lopuedo.view.interfaces.IRoundView;

public interface IRoundPresenter {
    void onCreate(IRoundView view, int matchID);
    void showList();
    void setScores();
}
