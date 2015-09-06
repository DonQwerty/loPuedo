package project.lopuedo.model;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class  MatchModel implements IMatchModel {
    // TODO Utilizar la base de datos
    private int matchId = 0;

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

    public SQLiteDatabase getScoreDatabase(Context context){
        ScoreOpenHelper dbHelper = new ScoreOpenHelper(context);
        return dbHelper.getWritableDatabase();
    }

    public Cursor getRound(Context context){
        SQLiteDatabase db=getScoreDatabase(context);
        return db.query("score", null, null, null, null, null, null);
    }

    public static class ScoreOpenHelper extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 2;
        private static final String GAME_TABLE_NAME = "score";
        private static final String GAME_TABLE_CREATE =
                "CREATE TABLE " + GAME_TABLE_NAME + " (" +
                        "_id INTEGER,round INTEGER, player TEXT, score INTEGER);";

        ScoreOpenHelper(Context context) {
            super(context, GAME_TABLE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(GAME_TABLE_CREATE);
            db.execSQL("INSERT INTO "+GAME_TABLE_NAME+" VALUES (1,1,'Pedro',33);");
            db.execSQL("INSERT INTO "+GAME_TABLE_NAME+" VALUES (2,1,'Juan',22);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
