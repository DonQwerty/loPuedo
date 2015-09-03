package project.lopuedo.presenter;

import project.lopuedo.view.interfaces.IScoresView;

public interface IScoresPresenter {
    void onCreate(IScoresView view);
    void goToRoundActivity();
}
