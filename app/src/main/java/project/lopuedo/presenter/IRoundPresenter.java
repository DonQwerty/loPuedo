package project.lopuedo.presenter;

import android.content.Context;

import project.lopuedo.view.interfaces.IRoundView;

public interface IRoundPresenter {
    void onCreate(IRoundView view, int matchID);
    void setScore(Context context, int round, String name, int score);
}
