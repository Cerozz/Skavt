package com.example.zoki.skavt;

/**
 * Created by janez on 17. 12. 2015.
 */
public class Izkusnja {
    int Id;
    String Naslov;
    String Opis;
    int CatId;

    Izkusnja(int Id, String Naslov, String Opis, int CatId) {
        this.Id = Id;
        this.Naslov = Naslov;
        this.Opis = Opis;
        this.CatId = CatId;
    }

}