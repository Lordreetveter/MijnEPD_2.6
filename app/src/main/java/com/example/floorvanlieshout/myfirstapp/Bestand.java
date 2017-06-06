package com.example.floorvanlieshout.myfirstapp;

import android.net.Uri;

import java.util.Date;

/**
 * Created by Floor van Lieshout on 17-5-2017.
 */

public class Bestand {
    private String naam;
    private String beschrijving;
    private Date datum;
    private Uri fotoUri;

    public Bestand(String deNaam, String deBeschrijving, Date deDatum, Uri deFotoUri) {
        naam = deNaam;
        beschrijving = deBeschrijving;
        datum = deDatum;
        fotoUri = deFotoUri;
    }
}
