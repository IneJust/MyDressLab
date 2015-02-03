package com.example.justine.mydresslab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by justine on 03/02/2015.
 */
public class VetementsBDD {

    private static final int VERSION_BDD = 3;
    private static final String NOM_BDD = "monDressing.db";

    private static final String TABLE_VETEMENTS = "table_vetements";

    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_TYPE = "TYPE";
    private static final int NUM_COL_TYPE = 1;
    private static final String COL_SSTYPE = "SSTYPE";
    private static final int NUM_COL_SSTYPE = 2;
    private static final String COL_COULEURVET = "COULEURVET";
    private static final int NUM_COL_COULEURVET = 3;
    private static final String COL_LIEN_PHOTO = "LIEN_PHOTO";
    private static final int NUM_COL_LIEN_PHOTO = 4;

    private SQLiteDatabase bdd;

    private MaBaseSQLite maBaseSQLite;

    public VetementsBDD(Context context){
        //On créer la BDD et sa table
        maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insertVetement(Vetements vetement){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(vetement.getType(), COL_TYPE);
        values.put(vetement.getSsType(), COL_SSTYPE);
        values.put(vetement.getCouleurVet(), COL_COULEURVET);
        values.put(vetement.getLienPhoto(), COL_LIEN_PHOTO);
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_VETEMENTS, null, values);
    }

    public int updateVetement(int id, Vetements vetement){
        //La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simple préciser quelle livre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(vetement.getType(), COL_TYPE);
        values.put(vetement.getSsType(), COL_SSTYPE);
        values.put(vetement.getCouleurVet(), COL_COULEURVET);
        values.put(vetement.getLienPhoto(), COL_LIEN_PHOTO);
        return bdd.update(TABLE_VETEMENTS, values, COL_ID + " = " +id, null);
    }

    public int removeVetementWithID(int id){
        //Suppression d'un livre de la BDD grâce à l'ID
        return bdd.delete(TABLE_VETEMENTS, COL_ID + " = " +id, null);
    }

    public Vetements [] recupereTSdepuisType(String type)
    {

        ArrayList<Vetements> vetements = new ArrayList<Vetements>();

        String selectQuery = "SELECT  * FROM " + TABLE_VETEMENTS + " WHERE "
                + COL_TYPE + " = " + type;

        Cursor c = bdd.rawQuery(selectQuery, null);

        if (c != null) {
            c.moveToFirst();
        }
        do {
            Vetements vet = new Vetements();
            vet.setId(c.getInt(c.getColumnIndex(COL_ID)));
            vet.setType(c.getString(c.getColumnIndex(COL_TYPE)));
            vet.setSsType(c.getString(c.getColumnIndex(COL_SSTYPE)));
            vet.setCouleurVet(c.getString(c.getColumnIndex(COL_COULEURVET)));
            vet.setLienPhoto(c.getString(c.getColumnIndex(COL_LIEN_PHOTO)));

            vetements.add(vet);
        }while(c.moveToNext());

        Vetements[] vetm = (Vetements[]) vetements.toArray();
        return vetm;
    }



    public Vetements getVetementWithType(String type){
        //Récupère dans un Cursor les valeur correspondant à un vetement contenu dans la BDD (ici on sélectionne le vetement grâce à son type)
        Cursor c = bdd.query(TABLE_VETEMENTS, new String[] {COL_ID, COL_TYPE, COL_SSTYPE, COL_COULEURVET, COL_LIEN_PHOTO}, COL_TYPE + " LIKE \"" + type +"\"", null, null, null, null);
        return cursorToVetement(c);
    }

    //Cette méthode permet de convertir un cursor en un vetement
    private Vetements cursorToVetement(Cursor v){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (v.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        v.moveToFirst();
        //On créé un vetement
        Vetements vetement = new Vetements();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        vetement.setId(v.getInt(NUM_COL_ID));
        vetement.setType(v.getString(NUM_COL_TYPE));
        vetement.setSsType(v.getString(NUM_COL_SSTYPE));
        vetement.setCouleurVet(v.getString(NUM_COL_COULEURVET));
        vetement.setLienPhoto(v.getString(NUM_COL_LIEN_PHOTO));
        //On ferme le cursor
        v.close();

        //On retourne le livre
        return vetement;
    }
}
