package com.example.justine.mydresslab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Created by justine on 03/02/2015.
 */
public class MaBaseSQLite extends SQLiteOpenHelper{

    private static final String TABLE_VETEMENTS = "table_vetements";
    private static final String COL_ID = "ID";
    private static final String COL_TYPE = "TYPE";
    private static final String COL_SSTYPE = "SSTYPE";
    private static final String COL_COULEURVET = "COULEURVET";
    private static final String COL_LIEN_PHOTO = "LIEN_PHOTO";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_VETEMENTS + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_TYPE + " TEXT NOT NULL, "
            + COL_SSTYPE + " TEXT NOT NULL," + COL_COULEURVET + " TEXT NOT NULL,"
            + COL_LIEN_PHOTO + " TEXT NOT NULL);";


    public MaBaseSQLite(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut fait ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
        //comme ça lorsque je change la version les id repartent de 0
        db.execSQL("DROP TABLE " + TABLE_VETEMENTS + ";");
        onCreate(db);
    }
}
