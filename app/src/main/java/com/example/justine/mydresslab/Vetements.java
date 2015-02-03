package com.example.justine.mydresslab;

/**
 * Created by justine on 03/02/2015.
 */
public class Vetements {

    private int id;
    private String type;
    private String ssType;
    private String couleurVet;
    private String lienPhoto;

    public Vetements(){};

    public Vetements(int id, String type, String ssType, String couleurVet, String lienPhoto)
    {
        super();
        this.id = id;
        this.type = type;
        this.ssType = ssType;
        this.couleurVet = couleurVet;
        this.lienPhoto = lienPhoto;
    }

    public Vetements(String type, String ssType, String couleurVet, String lienPhoto)
    {
        super();
        this.type = type;
        this.ssType = ssType;
        this.couleurVet = couleurVet;
        this.lienPhoto = lienPhoto;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getSsType()
    {
        return ssType;
    }

    public void setSsType(String ssType)
    {
        this.ssType = ssType;
    }

    public String getCouleurVet()
    {
        return couleurVet;
    }

    public void setCouleurVet(String couleurVet)
    {
        this.couleurVet = couleurVet;
    }

    public String getLienPhoto()
    {
        return couleurVet;
    }

    public void setLienPhoto(String lienPhoto)
    {
        this.lienPhoto = lienPhoto;
    }

    public String totalite()
    {
        return "TYPE : "+type+"\nSSTYPE : "+ssType+"\nCOULEUR : "+couleurVet+"\nLIEN_PHOTO : "+lienPhoto;
    }
}
