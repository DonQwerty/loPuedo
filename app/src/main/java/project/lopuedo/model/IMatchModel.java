package project.lopuedo.model;


import android.content.Context;

public interface IMatchModel {

    void setMatchId(int id);

    int getMatchId();

    boolean isFinished();

    void updatePlayer(Context context,int id, int round,String player, int score);
}
