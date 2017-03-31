package jvang.cs.cis3334.devogellaandroidsqlitefirst;

/**
 * Created by Jenni V on 3/31/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_COMMENTS = "comments";                     // This is the name of our table
    public static final String COLUMN_ID = "_id";                               // This is the id # that is used to store this comment in the db
    public static final String COLUMN_COMMENT = "comment";                      // This is one of the various comments available

    private static final String DATABASE_NAME = "commments.db";                 // Setting up the name of the DB
    private static final int DATABASE_VERSION = 1;                              // Used to keep track of what version or upgrade we are on

    // Database creation sql statement
    // This method is used to create the DB or table.
    //
    // create table Comments ( _id integer primary key autoincrement, comment text to null);
    //              Comments ( 0, comment text not null);
    //
    private static final String DATABASE_CREATE = "create table "
            + TABLE_COMMENTS + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_COMMENT
            + " text not null);";

    // this method is used to help create and upgrade the DB
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // this method is always needed and will be called when the trying to access the DB but it is not yet created
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }


    // this method is always needed and will be called when the version numbers are different.
    // it will drop the old table and create a new table.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }

}
