package project.lopuedo.model;


public class MatchModel implements IMatchModel {
    private int matchId;

    @Override
    public void setMatchId(int id) {
        matchId = id;
    }

    @Override
    public int getMatchId() {
        return matchId;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
