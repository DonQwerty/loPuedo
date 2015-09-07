package project.lopuedo.model;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class  MatchModel implements IMatchModel {
    // TODO Utilizar la base de datos para crear el matchId
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

    public Cursor getRound(Context context,int id){
        SQLiteDatabase db=getScoreDatabase(context);
        return db.query("score", null, "round=" + 1, null, null, null, null);
    }

    public int getMatchid(Context context){
        SQLiteDatabase db=getScoreDatabase(context);
        Cursor cursor = db.query("score", null, "_id", null, null, null, "_id DESC", "1");
        if(cursor.moveToFirst())
            return cursor.getInt(0)+1;
        else
            return 1;

    }
    public void updatePlayer(Context context,int id, int round,String player, int score){
        SQLiteDatabase db=getScoreDatabase(context);
        db.execSQL("INSERT INTO score VALUES ("+id+","+round+",'"+player+"',"+score+");");
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

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
        public String getGameTableName(){
            return GAME_TABLE_NAME;
        }
    }
}
