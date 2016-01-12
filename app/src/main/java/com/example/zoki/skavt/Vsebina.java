package com.example.zoki.skavt;

import java.io.Serializable;
import java.util.ArrayList;

public class Vsebina implements Serializable {

    public String ime;
    public String opis;
    public String uporaba;
    public String[] kat;
    public String[] opisArr;
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

    public Vsebina(String ime, String[] kategorije, String[] opisi, int slika, String zahtevnost) {
        this.ime = ime;
        this.kat = kategorije;
        this.opisArr = opisi;
        this.zahtevnost = zahtevnost;
        this.slika = slika;
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
                "Kompas je naprava z magnetno iglo, ki nam pomaga določiti strani neba. Magnetna igla se poravna glede na magnetni sever, ki ni nujno isti kot geografski sever, zaradi česa se za večje natančnosti uporabljajo korekcijske formule." +
                        " Pazljivi moramo biti na oznake na kompasu. Če so oznake angleške (N, E, S, W), je sever označen s črko N. " +
                        "Če so oznake slovenske(S, V, J, Z), sever označuje črka S. Na smer igle lahko vplivajo tudi druga magnetna polja, ki jih povzročajo daljnovodi, električni aparati in kovinski predmeti. Poskrbeti moramo, da teh stvari ni v bližini.\n",
                "• Določanje smeri neba\n• Orientacija glede na karte in zemljevide",
                "★☆☆☆☆",
                R.drawable.orientacija_kompas));
        orientacije.add(new Vsebina("Zvezde",
                "V jasnih nočeh se najbolje orientiramo po zvezdi Severnici. Najprej poiščemo veliki voz. To ozvezdje stalno kroži okoli severnega nebesnega pola in v naših krajih nikoli ne zaide. Isto velja za zvezdo Severnico. " +
                        "Razdaljo med zvezdama zadnje osi velikega voza petkrat podaljšamo in tako pridemo do močne zvezde Severnice, ki nam določa točno smer na sever.",
                "• Ko so vidne zvezde\n• Ko imamo zadostno znanje o zvezdah za identificiranje Severnice",
                "★★☆☆☆",
                R.drawable.orientacija_severnica));
        orientacije.add(new Vsebina("Dodatna znanja",
                "• Podnevi si lahko pomagamo s Soncem, ki je najvišje na obzorjo točno ob opoldne. Senca je takrat najkrajša in kaže proti severu.\n" +
                        "• Drevesna debla so na severu bolj poraščena z mahom\n" +
                        "• Razmiki med letnicami na štorih so proti severu manjši\n" +
                        "• Krošnje dreves so proti jugu bolj bujne\n" +
                        "• Mravljišča so proti jugu položnejša\n" +
                        "• Mravljišča so na južni strani dreves\n" +
                        "• Sneg se dlje obdrži na severnih pobočjih\n",
                "• Splošno znanje",
                "☆☆☆☆☆",
                R.drawable.books));

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
        nasveti.add(new Vsebina("Prva pomoč",
                new String[]{"Opekline", "Žulji", "Rane in krvavitve", "Piki žuželk"},
                new String[]{"◦ Rano hladimo s hladno vodo, ki blaži bolečino in preprečuje nadaljnje poškodbe. Na rano ne dajemo ledu.\n◦ Na rano ne dajemo ledu\n◦ Rane ne mažemo z raznimi mazili\n",
                        "◦ Če nas ožuli, je pomembno, da se čim prej preobujemo\n◦ Pribor za oskrbo žulja naj bo sterilen\n◦ Manjše žulje premažemo z ustreznim mazilom in prekrijemo z obližem\n◦ Večje in moteče žulje predremo z iglo, ki jo pred tem očistimo, da je sterilna. Preboden žulj prekrijemo s sterilno gazo\n",
                        "◦  Vedno imamo čiste roke in pripomočke\n◦  Površinske rane izpiramo s tekočo vodo in prekrijemo s sterilno gazo ali obližem\n◦  Če iz rane krvavi zaustavimo prekrvavitev s kompresijsko obvezo ali neposrednim pritiskom s prsti preko gaze\n◦  Ranjeni del telesa ali ud mora mirovati\n",
                        "◦ Če je pri piku čebele v koži ostalo želo, ga odstranimo\n◦ Pik speremo pod tekočo vodo, osušimo in pohladimo z ledom. Ledu ne dajemo neposredno na kožo\n◦ Nanesemo gel za oskrbo kože po pikih\n◦ V primeru alergijske reakcije moramo imeti ob sebi ustrezno zdravo\n"},
                R.drawable.medic,
                "opis"));
        nasveti.add(new Vsebina("Hidracija",
                new String[]{"Hidracija telesa", "Prečiščevanje vode", "Iskanje vode v naravi"},
                new String[]{"◦ Telo lahko v najhujših razmerah zgubi tudi po 4 litre vode na dan, tako da je redna hidracija vedno obvezna\n◦ Najboljšo hidriranje nam omogoča navadna voda, saj nima dodatnih elemntov kot sladkor",
                        "◦ Osnovno filtriranje(npr. čez del oblačila) ne filtrira vode dokončno, vendar je hitra rešitev za zmanjšanje škodljivih delcev in izboljšanje okusa\n◦ Prevretje vode je najbol uporabljena tehnika prečiščevanja vode. Ubije skoraj vse bakterije, vendar ni nujno da odstrani kemično onesnaženost\n◦ Najbolj varno prečiščevanje je z raznimi prečiščevalnimi tabletami za vodo ki jo najdemo v veliko lovskih trgovinah",
                        "◦ Najboljša možnost za naravni vir vode so razne doline, kamor se voda naravno iztaka\n◦ Ptice pogosto krožijo nad virom vode\n◦ V hudih pokrajinah kot puščave, je izrazito zeleno rastje znak vode"},
                R.drawable.water,
                "opis"));
        nasveti.add(new Vsebina("Preživetje",
                new String[]{"Prioritete preživetja", "Signalizacija", "Splošni nasveti"},
                new String[]{"◦ Za daljše preživetje v naravi, rabimo za varnost kot toploto najprej zgraditi zavetje in ogenj\n◦ Človek lahko brez vode zdrži 3 dni, zato je zelo pomembno da v prvih dneh najdete vir vode\n◦ Brez hrane lahko zdržimo do 30 dni. Osnovno lahko preživimo na živilih kot sadje, vendar je ob dolgoročnem preživetju potrebno zaužiti tudi proteine(npr. meso)\n◦ Če imate energijo, poskrbite da vas je v primeru reševalne akcije lahko videti",
                "◦ Da vas lahko iskalne partije najdejo, rabite poskrbeti da vas je enostavno videti oz. zaznati\n◦ Kot svetlobno signalno sredstvo lahko uporabite ogledalo, ogenj ali pa svetilko(ki jo najdete tudi v aplikaciji). V najhujšem primeru lahko iz lesa ali kamnov črkujete SOS.\n◦ Kot zvočno sredstvo lahko uporabite razne pripomočke kot piščalka, hupa ali celo strelna orožja",
                "◦ Poskrbite da se vedno odpravite z zadostno količino opreme kot so noži, svetilke, vrvi in ostala orodja ki znajo biti razlika med življenjem in smrtjo v najhujšem primeru\n◦ Dobro preučite obsežnost vašega izleta in primerno pripravite količino  vode in hrane. Če možno, vzemite tudi nekaj rezerve.\n◦ Pred izletom se pozanimajte o ciljni pokrajini, da ste pripravljeni za vse možne situaciji"},
                R.drawable.bonfire,
                "opis"));
        return nasveti;
    }
}
