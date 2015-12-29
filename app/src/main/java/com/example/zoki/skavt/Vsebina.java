package com.example.zoki.skavt;

import java.io.Serializable;
import java.util.ArrayList;

public class Vsebina implements Serializable{

    public String ime;
    public String opis;
    public String uporaba;
    public int slika;

    public Vsebina() {
    }

    public Vsebina(String ime, String opis, String uporaba, int slika) {
        this.ime = ime;
        this.opis = opis;
        this.uporaba = uporaba;
        this.slika = slika;
    }

    public Vsebina(String ime, String opis , int slika) {
        this.ime = ime;
        this.opis = opis;
        this.slika = slika;
    }

    public ArrayList<Vsebina> getVozli() {
        ArrayList<Vsebina> vozli = new ArrayList<>();
        vozli.add(new Vsebina("Ambulantni",
                        "OPIS:  sestavljen je iz dveh polvozlov.Se ne zatika in zato ga tudi preprosto odvežemo. Je zelo enostaven in močno drži. Če so vrvi gladke, raje uporabimo ribiški ali podaljševalni vozel.\n\n",
                        "UPORABA: pri prvi pomoči(fiksiranje zlomljenega uda, zavezovanje s trikotno ruto), pri podaljševanju dveh krajši vrvi, a samo v primeru, da sta enako debeli, ustvarjanje zanke\n",
                         R.drawable.vozel_ambulanti));
        vozli.add(new Vsebina("Bičev",
                        "je boljši od kavbojskega, ker se pri enostranski obremenitvi zateguje in ne drsi. Vsebina se lahko tudi vplete.\n\n",
                         "UPORABA: v alpinizmu za privezovanje na karabin, za pritrjevanje vrvi na drog, za postavljanje šotora\n",
                         R.drawable.vozel_bicev));
        vozli.add(new Vsebina("Osmica",
                         "OPIS: Osmico lahko izdelamo kot osnovno ali kot vpleteno. Primerna je predvsem za varovanje v gorah.\n\n",
                         "UPORABA: spust ob vrvi pri zimski tehniki, pri izdelovanju škripčevja, vrvna ograja, vmesni vozli pri ledeniškem navezovanju\n",
                        R.drawable.vozel_osmica));
        vozli.add(new Vsebina("Podaljševalni",
                         "OPIS: služi povezovanju dveh vrvi, ali pa ene same vrvice, da tako dobimo neskončno zanka. Priporočljiva je izdelava s trojnim ovojem.\n\n",
                         "UPORABA: kadar imamo dve prekratki vrvi, kadar želimo dve vrvi povezati. \n",
                        R.drawable.vozel_podaljsevalni));
        vozli.add(new Vsebina("Prusikov",
                         "OPIS: Spada med drsne vozle. Pri obremenitvi se zateguje, če ga razbremenimo, pa ga lahko pomikamo po vrvi, drogu,…  Naredimo ga s tanjšo vrvico na debelejši. Prusikov vozel drži v obe smeri.\n",
                         "UPORABA: samoreševanje, samovarovanje pri spustu ob vrvi\n",
                         R.drawable.vozel_prusikov));
        return vozli;
    }

    public ArrayList<Vsebina> getOgnji() {
        ArrayList<Vsebina> ognji = new ArrayList<>();
        ognji.add(new Vsebina("Piramida",
                "OPIS: v tla zabijemo debelejšo vejo, okoli nje netivo, dračje, ter na koncu še debelejša drva.",
                R.drawable.ogenj_piramida));
        ognji.add(new Vsebina("Pagoda",
                "OPIS: postavimo ga ob posebnih priložnostih, kot je zaključek tabora in podelitev priznanj. Vzame nam nekoliko več časa. V notranjosti postavimo piramido, okoli nje pa zložimo štiri stranice pagode. Za zunanje stranice uporabimo debelejša drva.",
                R.drawable.ogenj_pagoda));
        ognji.add(new Vsebina("Zvezdasti",
                "OPIS: uporabljali so ga že Indijanci. Okoli ognja položimo debelejša polena, ki segajo v ogenj samo z enim koncem. Polena gorijo počasi, mi pa jih moramo potiskati proti središču ognja. Ogenj gori počasi in dlje časa.",
                R.drawable.ogenj_zvezdasti));
        ognji.add(new Vsebina("Strešni",
                "OPIS: je podolgovate oblike. Na vsako stran namestimo dve rogovili. Rogovili na vrhu povežemo s slemensko palico, ki je namenjena opori. Nanjo namreč položimo drva. V notranjost nabašemo netivo in dračje po celi dolžini. Daje močno toploto, uporablja pa se ga predvsem za pečenje.",
                R.drawable.ogenj_stresni));
        ognji.add(new Vsebina("Stražni",
                "OPIS: Naredimo osnoven ogenj po izbiri. Ob ognju postavimo lojtro, na katero naložimo polena. Ta polena naj bodo čim bolj okrogla. Ko poleno v ognju dogori, se vsa naložena polena premaknejo bližje ognju. Ogenj gori precej časa. Uporablja se kot za ogrevanje ali stražo čez celo noč.",
                R.drawable.ogenj_strazni));
        return ognji;
    }

    public ArrayList<Vsebina> getOrientacije() {
        ArrayList<Vsebina> orientacije = new ArrayList<>();
        orientacije.add(new Vsebina("Kompas",
                "Kompas je naprava s prosto vrtečo magnetno iglo za določanje smeri neba.\n" +
                        "Z njim določamo:\n" +
                        "- smeri neba\n" +
                        "- orientiramo topografsko karto\n" +
                        "- smerni kot ali azimut in razdaljo poljubni točki na območju\n\n " +
                "UPORABA: kompas ima magnetno iglo, ki se vedno obrne proti magnetnemu severu. Ta nekoliko odstopa od dejanskega geografskega severa, vendar odstopanje ni veliko. Pazljivi moramo biti na oznake na kompasu. Če so oznake angleške (N, E, S, W), je sever označen s črko N. " +
                        "Če so oznake slovenske(S, V, J, Z), sever označuje črka S. Na smer igle lahko vplivajo tudi druga magnetna polja, ki jih povzročajo daljnovodi, električni aparati in kovinski predmeti. Poskrbeti moramo, da teh stvari ni v bližini.\n",
                R.drawable.orientacija_kompas));
        orientacije.add(new Vsebina("Zvezde",
                "V jasnih nočeh se najbolje orientiramo po zvezdi Severnici. Najprej poiščemo veliki voz. To ozvezdje stalno kroži okrog severnega nebesnega pola in v naših krajih nikoli ne zaide. Isto velja za zvezdo Severnico. " +
                        "Razdaljo med zvezdama zadnje osi velikega voza petkrat podaljšamo in tako pridemo do močne zvezde Severnice, ki nam določa točno smer na sever.",
                R.drawable.orientacija_kompas));
        orientacije.add(new Vsebina("Luna",
                "- mlaj se vidi po zahodu sonca ob 18h na Z\n" +
                        "- prvi krajec je okrog 18h na J, ob 24h na Z\n" +
                        "- polna luna vzhaja po zahodu sonca ob 18h na V, ob 24h na J, ob 6h pa na Z.\n" +
                        "- zadnji krajec vzhaja ob 24h na V, ob 6h je na J, ob 12h je na Z\n",
                R.drawable.orientacija_kompas));
        orientacije.add(new Vsebina("Navigacija ostalo",
                " podnevi si lahko pomagamo s Soncem. Sonce je opoldne najvišje na obzorju. Senca je takrat najkrajša in kaže proti severu.\n" +
                "- drevesna debla so na severu bolj poraščena z mahom\n" +
                        "- razmiki med letnicami na štorih so proti severu manjši\n" +
                        "- krošnje dreves so proti jugu bolj bujne\n" +
                        "- mravljišča so proti jugu položnejša\n" +
                        "- mravljišča so na južni strani dreves\n" +
                        "- sneg se dlje obdrži na severnih pobočjih\n",
                R.drawable.orientacija_kompas));

        return orientacije;
    }
}
