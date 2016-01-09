package com.example.zoki.skavt;

import java.io.Serializable;
import java.util.ArrayList;

public class Vsebina implements Serializable {

    public String ime;
    public String opis;
    public String uporaba;
    public String zahtevnost;
    public int slika;

    public Vsebina() {
    }

    public Vsebina(String ime, String opis, String zahtevnost, int slika) {
        this.ime = ime;
        this.opis = opis;
        this.slika = slika;
        this.zahtevnost = zahtevnost;
    }

    public Vsebina(String ime, String opis, String uporaba, String zahtevnost, int slika) {
        this.ime = ime;
        this.opis = opis;
        this.uporaba = uporaba;
        this.slika = slika;
        this.zahtevnost = zahtevnost;
    }

    public Vsebina(String ime, String opis, String uporaba, String zahtevnost) {
        this.ime = ime;
        this.opis = opis;
        this.uporaba = uporaba;
        this.zahtevnost = zahtevnost;
    }


    public ArrayList<Vsebina> getVozli() {
        ArrayList<Vsebina> vozli = new ArrayList<>();
        vozli.add(new Vsebina("Ambulantni",
                "OPIS: Ambulantni vozel je sestavljen iz dveh polvozlov. Se ne zatika in zato ga tudi preprosto odvežemo. Znan je po enostavnosti in moči. Če so vrvi gladke, raje uporabimo ribiški ali podaljševalni vozel.\n\n",
                "UPORABA: Prva pomoč(fiksiranje zlomljenega uda, zavezovanje s trikotno ruto), pri podaljševanju dveh krajših vrvi(če sta obe vrvi enako široki), ustvarjanje zanke.\n",
                "**",
                R.drawable.vozel_ambulanti));
        vozli.add(new Vsebina("Bičev",
                "Bičev vozel je boljši od kavbojskega, ker se pri enostranski obremenitvi zateguje in ne drsi. Vsebina se lahko tudi vplete.\n\n",
                "UPORABA: V alpinizmu za privezovanje na karabin, za pritrjevanje vrvi na drog, za postavljanje šotora.\n",
                "***",
                R.drawable.vozel_bicev));
        vozli.add(new Vsebina("Osmica",
                "OPIS: Osmico lahko izdelamo kot osnovno ali kot vpleteno. Primerna je predvsem za varovanje v gorah(plezanje).\n\n",
                "UPORABA: Spust ob vrvi pri zimski tehniki, pri izdelovanju škripčevja, vrvna ograja, vmesni vozli pri ledeniškem navezovanju.\n",
                "**",
                R.drawable.vozel_osmica));
        vozli.add(new Vsebina("Podaljševalni",
                "OPIS: Služi povezovanju dveh vrvi, ali pa ene same vrvice, da tako dobimo neskončno zanko. Priporočljiva je izdelava s trojnim ovojem.\n\n",
                "UPORABA: Kadar imamo dve prekratki vrvi, kadar želimo dve vrvi povezati. \n",
                "****",
                R.drawable.vozel_podaljsevalni));

        vozli.add(new Vsebina("Prusikov",
                "OPIS: Spada med drsne vozle. Pri obremenitvi se zateguje, če ga razbremenimo, pa ga lahko pomikamo po vrvi, drogu,…  Naredimo ga s tanjšo vrvico na debelejši. Prusikov vozel drži v obe smeri.\n",
                "UPORABA: Samoreševanje, samovarovanje pri spustu ob vrvi.\n",
                "****",
                R.drawable.vozel_prusikov));

        return vozli;
    }

    public ArrayList<Vsebina> getOgnji() {
        ArrayList<Vsebina> ognji = new ArrayList<>();
        ognji.add(new Vsebina("Piramida",
                "OPIS: V tla zapičimo večjo vejo, okoli nje dodamo netivo, dračje, ter na koncu še debelejša drva.",
                "**",
                R.drawable.ogenj_piramida));
        ognji.add(new Vsebina("Pagoda",
                "OPIS: Postavimo ga ob posebnih priložnostih, kot je zaključek tabora in podelitev priznanj. Časovno bolj zahteven. V notranjosti postavimo piramido, okoli nje pa postavimo štiri stranice pagode. Za zunanje stranice uporabimo debelejša drva.",
                "***",
                R.drawable.ogenj_pagoda));
        ognji.add(new Vsebina("Zvezdasti",
                "OPIS: Zelo stara tehnika ognja, ki so jo uporabljali že Indijanci. Okoli ognja položimo debelejša polena, ki segajo v ogenj samo z enim koncem. Polena gorijo počasi, mi pa jih moramo potiskati proti središču ognja. Ogenj gori počasi in dlje časa.",
                "***",
                R.drawable.ogenj_zvezdasti));
        ognji.add(new Vsebina("Strešni",
                "OPIS: Strešni ogenj je podolgovate oblike. Na vsako stran namestimo dve rogovili. Rogovili na vrhu povežemo s slemensko palico, ki je namenjena opori. Nanjo namreč položimo drva. V notranjost položimo netivo in dračje po celi dolžini. Daje močno toploto, uporablja pa se ga predvsem za pečenje.",
                "****",
                R.drawable.ogenj_stresni));
        ognji.add(new Vsebina("Stražni",
                "OPIS: Naredimo osnoven ogenj po izbiri. Ob ognju postavimo lojtro, na katero naložimo polena. Ta polena naj bodo čim bolj okrogla. Ko poleno v ognju dogori, se vsa naložena polena premaknejo bližje ognju. Ogenj gori dolgo časa. Uporablja se kot za ogrevanje ali stražo čez celo noč.",
                "*****",
                R.drawable.ogenj_strazni));
        return ognji;
    }

    public ArrayList<Vsebina> getOrientacije() {
        ArrayList<Vsebina> orientacije = new ArrayList<>();
        orientacije.add(new Vsebina("Kompas",
                "Kompas je naprava s prosto vrtečo magnetno iglo za določanje smeri neba.\n" +
                        "Uporabe:\n" +
                        "- določanje smeri neba\n" +
                        "- orientacija glede na topografsko karto\n" +
                        "- smerni kot ali azimut in razdalja poljubne točke na območju\n\n " +
                        "UPORABA: Kompas ima magnetno iglo, ki se vedno obrne proti magnetnemu severu. Ta nekoliko odstopa od dejanskega geografskega severa, vendar odstopanje ni veliko. Pazljivi moramo biti na oznake na kompasu. Če so oznake angleške (N, E, S, W), je sever označen s črko N. " +
                        "Če so oznake slovenske(S, V, J, Z), sever označuje črka S. Na smer igle lahko vplivajo tudi druga magnetna polja, ki jih povzročajo daljnovodi, električni aparati in kovinski predmeti. Poskrbeti moramo, da teh stvari ni v bližini.\n",
                "**",
                R.drawable.orientacija_kompas));
        orientacije.add(new Vsebina("Zvezde",
                "V jasnih nočeh se najbolje orientiramo po zvezdi Severnici. Najprej poiščemo veliki voz. To ozvezdje stalno kroži okrog severnega nebesnega pola in v naših krajih nikoli ne zaide. Isto velja za zvezdo Severnico. " +
                        "Razdaljo med zvezdama zadnje osi velikega voza petkrat podaljšamo in tako pridemo do močne zvezde Severnice, ki nam določa točno smer na sever.",
                "**",
                R.drawable.orientacija_severnica));
        orientacije.add(new Vsebina("Luna",
                "- mlaj se vidi po zahodu sonca ob 18h na Z\n" +
                        "- prvi krajec je okrog 18h na J, ob 24h na Z\n" +
                        "- polna luna vzhaja po zahodu sonca ob 18h na V, ob 24h na J, ob 6h pa na Z.\n" +
                        "- zadnji krajec vzhaja ob 24h na V, ob 6h je na J, ob 12h je na Z\n",
                "***",
                R.drawable.orientacija_luna));
        orientacije.add(new Vsebina("Navigacija ostalo",
                " podnevi si lahko pomagamo s Soncem. Sonce je opoldne najvišje na obzorju. Senca je takrat najkrajša in kaže proti severu.\n" +
                        "- drevesna debla so na severu bolj poraščena z mahom\n" +
                        "- razmiki med letnicami na štorih so proti severu manjši\n" +
                        "- krošnje dreves so proti jugu bolj bujne\n" +
                        "- mravljišča so proti jugu položnejša\n" +
                        "- mravljišča so na južni strani dreves\n" +
                        "- sneg se dlje obdrži na severnih pobočjih\n",
                "***",
                R.drawable.orientacija_mlaj));

        return orientacije;
    }

    public ArrayList<Vsebina> getZavetje() {
        ArrayList<Vsebina> zavetje = new ArrayList<>();
        zavetje.add(new Vsebina("Snežna luknja",
                "Opis: V strmini izkopljemo snežno luknjo v obliki zvona. " +
                        "Če je snega dovolj, lahko pustimo, da bo streha iz vsaj enega metra snega. " +
                        "Na vrhu vedno naredimo luknjo v premeru vsaj 10 centimetrov, ki" +
                        "e namenjena zračenju. Na koncu dodelajte še vhod. Pustite vhodno luknjo čim manjšo in s tem" +
                        "zmanjšajte izgubo toplote. Če je teren bolj položen, naredimo snežno kočo.",
                "Uporaba: pozimi, v snegu, na strmejših pobočjih",
                "*****",
                R.drawable.zavetje_sneznaluknja));
        zavetje.add(new Vsebina("Snežna koča",
                "Opis: izkopljemo dovolj veliko luknjo, da bomo v njej lahko sedeli. Luknjo izkopljemo tako, da bomo v " +
                        "njej imeli improvizirano klop. Če je snega dovolj, naj bo streha iz snega, drugače nanjo položimo veje" +
                        "ali šotorko.  Na vrhu vedno naredimo luknjo v premeru vsaj 10 centimetrov, ki je namenjena" +
                        "zračenju. Na koncu dodelajte še vhod. Pustite vhodno luknjo čim manjšo in s tem zmanjšajte izgubo" +
                        "toplote.",
                "Uporaba: pozimi, v snegu, na ravnih predelih",
                "*****",
                R.drawable.zavetje_sneznakoca));
        zavetje.add(new Vsebina("Bivak za eno osebo",
                "Opis: Začnemo tako, da na eni strani postavimo rogovilo ali dve palici, ki jih med seboj zvežemo. Na" +
                        "drugo stran na tla postavimo štor ali skalo. Izberemo primerno slemensko palico, ki bo povezovala" +
                        "oba konca. Daljša kot bo palica, daljši bo naš bivak. Ko imamo osnovno konstrukcijo, pričnemo z" +
                        "nalaganjem vej na slemensko palico. Te naj ne segajo preveč nad slemensko palico. Sedaj na našo" +
                        "konstrukcijo naložimo mah, nato lubje. Nadaljujemo s travo, ki jo zvijemo v snope in na koncu še z" +
                        "listjem. Vhod v bivak lahko založimo s svojo opremo ali vejami.",
                "Uporaba: v vseh letnih časih. Je manjše velikosti in običajno namenjen eni osebi.",
                "***",
                R.drawable.zavetje_bivakenaoseba));
        zavetje.add(new Vsebina("Bivak s šotorskim krilom",
                "Opis:  Sestavljen je iz šotorskih kril, ki jih skozi kovinske odprtine povežemo z vrvico. Nato ga v spojih," +
                        "spredaj in zadaj podpremo s palicami in pričvrstimo s klini. Spredaj in zadaj napnemo vrv, zadnjo" +
                        "stran pa zapremo z dodatno šotorko. Bivak je lahko poljubno dolg, odvisno koliko šotorskih kril bomo" +
                        "povezali enega za drugim.",
                "Uporaba: uporabimo ga običajno na taborjenju. Če nimamo pri sebi  omenjenih materialov, lahko\n" +
                        "\n" +
                        "namesto njih uporabimo naravne materiale, ki jih najdemo v bližini.",
                "**",
                R.drawable.zavetje_sotorskakrila));
        zavetje.add(new Vsebina("Ostala zavetja",
                "Opis:  Bivak si lahko postavimo povsem po svoje. Glavni namen bivaka je, da nam je v njem toplo in\n" +
                        "\n" +
                        "udobno. V naravi lahko tako izkoristimo naravne danosti v bližini:",
                "Uporaba: zgradimo bivak pod podrtim drevesom\n" +
                        "\n" +
                        "- poiščemo luknjo ali manjšo votlino\n" +
                        "\n" +
                        "- poiščemo skalni previs in nanj napnemo šotorsko krilo\n" +
                        "\n" +
                        "- iglu pozimi",
                "poljubno",
                R.drawable.zavetje_ostalo));
        return zavetje;
    }

    public ArrayList<Vsebina> getNasveti() {
        ArrayList<Vsebina> nasveti = new ArrayList<>();
        nasveti.add(new Vsebina("Sledovi živali",
                "",
                "",
                "***",
                R.drawable.nasveti_sledi));
        nasveti.add(new Vsebina("Listi dreves",
                "-smreka:  Iglice so dolge od 10-25 milimetrov, ter so ravne. Na koncu vej rastejo spodaj podolgovati storži, ki so obrnjeni navzdol.\n" +
                        "-jelka: Iglice so dolge 15 - 30 mm, razporejene v dveh vrstah, ploske, zgoraj bleščeče temno zelene, spodaj z dvema belima progama. Storži rastejo navzgor, dolgi 10 - 16 cm in razpadejo na drevesu.\n" +
                        "\n" +
                        "-bukev: Listi so enostavni, celorobi in bleščeče zeleni, dolžine od 5-12 cm in širine od 3-8 cm, s 5-9 parov listnih žil. ima plodove imenovane žir. To so majhne kroglice, ki imajo dlačice, majhne bodičke in so rjave barve.\n" +
                        "-hrast: Listi imajo navadno priostrene konice režnjev s ščetinami.  Cvetove, ki se razvijejo spomladi, imenujemo mačice. Plod, ki ga imenujemo želod, je orešek in zraste v čašasti strukturi, imenovani kapica.\n" +
                        "-lipa: Listi: srčaste oblike, pecljati, dolgi nad 8 cm. Plod: majhni oreški s pecljem, ki se konča s krilcem; pokriti so z debelo lupino, ki ima pet močno vidnih robov\n" +
                        "-breza:  Poznamo jo po beli skorji. Enostavni listi so lahko nažagani ali režnjati. Plod breze je krilati orešek, ki pa ima pri nekaterih vrsta zelo drobna krilca.\n",
                "",
                "***"
        ));
        nasveti.add(new Vsebina("Prva pomoč",
                "Opis: Opekline:\n" +
                        "- rano hladimo s hladno vodo, ki blaži bolečino in preprečuje nadaljnje poškodbe. Na rano ne dajemo ledu.\n" +
                        "- na rano ne dajemo ledu\n" +
                        "-rane ne mažemo z mazili\n" +
                        "Žulji:\n" +
                        "- če nas ožuli, je pomembno, da se čim prej preobujemo\n" +
                        "- pribor za oskrbo naj bo sterilen\n" +
                        "-manjše žulje premažemo z ustreznim mazilom in prekrijemo z obližem\n" +
                        "- večje in moteče žulje predremo z iglo, ki jo pred tem očistimo z medicinskim alkoholom, ter jo za nekaj sekund držimo nad vročim ognjem. Preboden žulj prekrijemo s sterilno gazo\n" +
                        "Rane in krvavitve:\n" +
                        "- vedno imamo čiste roke in pripomočke\n" +
                        "-  površinske rane izpiramo s tekočo vodo in prekrijemo s sterilno gazo ali obližem\n" +
                        "-  če iz rane krvavi zaustavimo prekrvavitev s kompresijsko obvezo ali neposrednim pritiskom s prsti preko gaze\n" +
                        "- ranjeni del telesa ali ud mora mirovati\n" +
                        "Piki žuželk:\n" +
                        "- če je pri piku čebele v koži ostalo želo, ga odstranimo\n" +
                        "- pik speremo pod tekočo vodo, osušimo in pohladimo z ledom. Ledu ne dajemo neposredno na kožo\n" +
                        "- nanesemo gel za oskrbo kože po pikih\n" +
                        "- v primeru alergijske reakcije moramo imeti ob sebi ustrezno zdravo\n",
                "Uporaba: v vseh letnih časih. Je manjše velikosti in običajno namenjen eni osebi.",
                "***"));
        return nasveti;
    }
}
