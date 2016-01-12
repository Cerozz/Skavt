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
                "Ambulantni vozel je namenjen medsebojnemu povezovanju dveh koncev vrvi. Vozel je precej nestabilen in se ne sme uporabljati za namen varovanja ali pri večjih obremenitvah(izjema je, če na obeh straneh dodamo dodatne zaščitne vozle). Prednosti vozla so enostavnost ter možnost hitrega razdrtja.",
                "• Prva pomoč pri določenih zavezih in obvezah\n• Povezovanje dveh vrvi\n• Zavezovanje pasov, trakov in zlaganje jader",
                "★★☆☆☆",
                R.drawable.vozel_ambulanti));
        vozli.add(new Vsebina("Bičev",
                "Bičev vozel je srednje zahteven vozel, ki se najpogosteja uporablja pli plezanju. Prednost bičevega vozla je, da lahko brez izpenjanja prilagodimo dolžino vrvi med nami in vozlom. S tem vozlom se pripenjamo na nevarnem terenu. Ta vozel uporabljajo samo na vrvi, kjer sta oba konca zasedena(npr. na vsakem koncu je pripet plezalec).",
                "• Plezanje po dolgi poti, ki ima vmesne postaje in varovališča\n• Fiksno sidrišče\n• Pritrditev vrvi v sidrišče\n• Samovarovanje",
                "★★★☆☆",
                R.drawable.vozel_bicev));
        vozli.add(new Vsebina("Osmica",
                "Osmica je enostaven vozel ki se primarno uporablja v aplinizmu. Uporabimo ga, ko potrebujemo zanko ali pa končni zaščitni vozel. Poznamo dve izvedbi; Osnovna izvedba, ki jo lahko naprimer uporabimo kot varovalno sredstvo pri spustu na vrvi ter vpletena izvedba, ki ima izboljšano varnost. Zaradi manjše možnosti napake se uporablja pri pritrditvi plezalnega pasu.",
                "• Spust ob vrvi\n• Pri izdelovanju škripčevja\n• Navezovanje na plezalni pas\n• Izdelava fiksne zanke",
                "★☆☆☆☆",
                R.drawable.vozel_osmica));
        vozli.add(new Vsebina("Prusikov",
                "Prusikov vozel spada med drsne vozle. Uporablja se za pritrditev tanjše vrvi na večjo(če je možno, v merilu 1:2). Znan je po tem, da izredno drži obremenitev na obeh straneh vrvi. Zaradi tega, ker se med obremenitvijo vse bolj zateguje, je težava vozla, da se po uporabi težko razdre in ga je težko popustiti, da bi ga dodatno pozicionirali. Neuporaben je, ko je vrv zaledenela, saj potrebuje trenje za med vrvema.",
                "• Reševanje soplezalca in razni reševalni nameni\n• Samovarovanje pri spustu ob vrvi",
                "★★★★☆",
                R.drawable.vozel_prusikov));
        return vozli;
    }

    public ArrayList<Vsebina> getOgnji() {
        ArrayList<Vsebina> ognji = new ArrayList<>();
        ognji.add(new Vsebina("Piramida",
                "V tla na sredino zapičimo večjo vejo. Okoli sredinske veje dodamo netivo, dračje in podobna goreča sredstva. V obliki piramide nato prislonimo srednjo velike veje. V smeri, od koder piha veter, pustimo odprtino, da lahko ogenj prižgemo in mu pustimo dihati.",
                "• Osnovni ogenj pri gretju manjšega števila ljudi\n• Kot začetni ogenj pri večjih konstrukcijah(npr. pagoda, zvezdasti ogenj...)",
                "★★☆☆☆",
                R.drawable.ogenj_piramida));
        ognji.add(new Vsebina("Pagoda",
                "Pagoda je časovno bolj zahteven ogenj. V notranjosti postavimo piramidni ogenj, okoli njega pa postavimo štiri stranice pagode. Za zunanje stranice uporabimo debelejša drva. Z vsakim slojem zmanjšamo obseg ognja, da se konstrukcija ne podre. Ta vrsta ognja ponavadi da visok plamen, ki enakomerno gori na vseh straneh.",
                "• Taborjenje\n• Kot osrednji ogenj na večjih prireditvah\n • Kresi",
                "★★★☆☆",
                R.drawable.ogenj_pagoda));
        ognji.add(new Vsebina("Zvezdasti",
                "Zelo stara tehnika ognja, ki so jo uporabljali že Indijanci. Okoli ognja položimo debelejša polena, ki segajo v ogenj samo z enim koncem. Polena gorijo počasi, mi pa jih moramo potiskati proti središču ognja. Ogenj gori počasi in dlje časa. Lahko ga izvedemo preprosto kot veliko večjih polen okoli netiva, ali pa kot večja polena okoli manjšega ognja kot piramidni ogenj(prikazano na sliki). ",
                "• Ko imamo opravka z večjimi poleni, ki bi pri drugih ognjih težko zagoreli\n• Ko potrebujemo ogenj, ki gori dlje časa\n• Ko potrebujemo dostop do sredice, da lahko dodamo dodatno netivo",
                "★★★☆☆",
                R.drawable.ogenj_zvezdasti));
        ognji.add(new Vsebina("Lovski",
                "Najbolj osnovna oblika ognja. V sredini postavimo netivo, manjše palice in stvari, ki nam pomagajo ogenj vneti na začetku. Okoli sredice postavimo dve debelejši poleni, ki služita dvem funkcijam; Kontrolirata pretok zraka preko odprtih koncev in služita kot podloga, na katero odložimo kotliček ali posodo.",
                "• Ko smo časovno omejeni in potrebujemo hitro postavitev\n• Ko želimo razkužiti vodo ali kuhati v posodi\n• Kot naravna alternative, ko nimamo opreme kot gorilnik",
                "★☆☆☆☆",
                R.drawable.ogenj_lovski));
        ognji.add(new Vsebina("Stražni",
                "Naredimo osnoven ogenj po izbiri. Ob ognju postavimo lojtro, na katero naložimo polena. Ta polena naj bodo čim bolj okrogla. Ko poleno v ognju dogori, se vsa naložena polena premaknejo bližje ognju. Ogenj gori dolgo časa. Uporablja se kot za ogrevanje ali stražo čez celo noč.",
                "• Ko želimo dolgogoreči ogenj, kateremu lahko za dodatno gorenje samo priložimo polena\n• Ko imamo na voljo samo polena, ki niso dosti dolga za zvezdasti ogenj\n• Kot stražni/nočni ogenj",
                "★★★★★",
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
                "false",
                R.drawable.orientacija_kompas));
        orientacije.add(new Vsebina("Zvezde",
                "V jasnih nočeh se najbolje orientiramo po zvezdi Severnici. Najprej poiščemo veliki voz. To ozvezdje stalno kroži okrog severnega nebesnega pola in v naših krajih nikoli ne zaide. Isto velja za zvezdo Severnico. " +
                        "Razdaljo med zvezdama zadnje osi velikega voza petkrat podaljšamo in tako pridemo do močne zvezde Severnice, ki nam določa točno smer na sever.",
                "false",
                R.drawable.orientacija_severnica));
        orientacije.add(new Vsebina("Luna",
                "- mlaj se vidi po zahodu sonca ob 18h na Z\n" +
                        "- prvi krajec je okrog 18h na J, ob 24h na Z\n" +
                        "- polna luna vzhaja po zahodu sonca ob 18h na V, ob 24h na J, ob 6h pa na Z.\n" +
                        "- zadnji krajec vzhaja ob 24h na V, ob 6h je na J, ob 12h je na Z\n",
                "false",
                R.drawable.orientacija_luna));
        orientacije.add(new Vsebina("Navigacija ostalo",
                " podnevi si lahko pomagamo s Soncem. Sonce je opoldne najvišje na obzorju. Senca je takrat najkrajša in kaže proti severu.\n" +
                        "- drevesna debla so na severu bolj poraščena z mahom\n" +
                        "- razmiki med letnicami na štorih so proti severu manjši\n" +
                        "- krošnje dreves so proti jugu bolj bujne\n" +
                        "- mravljišča so proti jugu položnejša\n" +
                        "- mravljišča so na južni strani dreves\n" +
                        "- sneg se dlje obdrži na severnih pobočjih\n",
                "false",
                R.drawable.orientacija_mlaj));

        return orientacije;
    }

    public ArrayList<Vsebina> getZavetje() {
        ArrayList<Vsebina> zavetje = new ArrayList<>();
        zavetje.add(new Vsebina("Snežna luknja",
                "V strmini izkopljemo snežno luknjo v obliki zvona. " +
                        "Če je snega dovolj, lahko pustimo, da bo streha iz vsaj enega metra snega. " +
                        "Na vrhu vedno naredimo luknjo v premeru vsaj 10 centimetrov, ki" +
                        "je namenjena zračenju. Na koncu dodelajte še vhod. Pustite vhodno luknjo čim manjšo in s tem" +
                        "zmanjšajte izgubo toplote. Če je teren bolj položen, naredimo snežno kočo(najdete jo v meniju). Če je več ljudi, lahko naredite več posameznih lukenj, ali pa, bolj priporočljivo, naredito eno večjo, saj vas bo medsebojna toplota še bolj grela.",
                "• Pozimi\n• V globokem in trdnem snegu\n• Na strmejših pobočjih",
                "★★★★★",
                R.drawable.zavetje_sneznaluknja));
        zavetje.add(new Vsebina("Snežna koča",
                "Izkopljemo dovolj veliko luknjo, da bomo v njej lahko sedeli. Luknjo izkopljemo tako, da bomo v " +
                        "njej imeli improvizirano klop. Če je snega dovolj, naj bo streha iz snega, drugače nanjo položimo veje" +
                        "ali šotorsko krilo.  Na vrhu vedno naredimo luknjo v premeru vsaj 10 centimetrov, ki je namenjena" +
                        "zračenju. Na koncu dodelajte še vhod. Pustite vhodno luknjo čim manjšo in s tem zmanjšajte izgubo" +
                        "toplote.",
                "• Pozimi\n• V globokem snegu\n• Na ravnih predelih",
                "★★★★☆",
                R.drawable.zavetje_sneznakoca));
        zavetje.add(new Vsebina("Bivak za eno osebo",
                "Začnemo tako, da na eni strani postavimo dve palici, ki jih med seboj na koncu zvežemo. Na" +
                        "drugo stran na tla postavimo štor, skalo ali podoben pripomoček. Izberemo primerno slemensko palico, ki bo povezovala" +
                        "oba konca, od skale na koncu do dveh prednjih palic. Daljša kot bo palica, daljši bo naš bivak. Priporočeno je, da je dolga vsaj toliko kolikor ste visoki. Ko imamo osnovno konstrukcijo, pričnemo z" +
                        "nalaganjem vej na slemensko palico. Veje zložimo eno zraven druge in naj ne segajo preveč nad slemensko palico. Sedaj na našo" +
                        "konstrukcijo naložimo mah, nato lubje, ki bosta izboljšala zadrževanje toplote v bivaku. Nadaljujemo s travo, ki jo zvijemo v snope in na koncu še z" +
                        "listjem. Vhod v bivak lahko založimo s svojo opremo ali vejami.",
                "• V vseh letnih časih\n• Bivak za eno osebo\n• Improvizacijsko zavetje, ki ga uporabimo, ko nimamo primerne opreme(npr. šotor)",
                "★★★☆☆",
                R.drawable.zavetje_bivakenaoseba));
        zavetje.add(new Vsebina("Bivak s šotorskim krilom",
                "Sestavljen je iz šotorskih kril, ki jih skozi kovinske odprtine povežemo z vrvico. Nato ga v spojih," +
                        "spredaj in zadaj podpremo s palicami in pričvrstimo s klini. Spredaj in zadaj napnemo vrv, zadnjo" +
                        "stran pa zapremo z dodatno šotorko. Bivak je lahko poljubno dolg, odvisno koliko šotorskih kril bomo" +
                        "povezali enega za drugim.",
                "• Na taborjenjih\n• Ko imamo pri sebi potrebno opremo\n• Če opreme ni, lahko improviziramo z naravnimi pripomočki(bivak za eno osebo)",
                "★★☆☆☆",
                R.drawable.zavetje_sotorskakrila));
        return zavetje;
    }

    public ArrayList<Vsebina> getNasveti() {
        ArrayList<Vsebina> nasveti = new ArrayList<>();
        nasveti.add(new Vsebina("Sledovi živali",
                "",
                "",
                "false",
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
                "false"
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
                "false"));
        return nasveti;
    }
}
