package kayttoliittyma;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Kaynnistin
 *
 * Käynnistin tulostaa käyttäjälle ohjelman toiminnan kannalta oleelliseet
 * ohjeet, lukee syötteen, jonka avulla luodaan kenttä, ja kutsuu
 * verkonläpikäyntialgoritmia.
 *
 * @author tuomo
 */
public class Kaynnistin {

    /**
     * Tulostaa ohjeet käyttäjälle, lukee lueKentta()-metodin avulla syötettävän
     * kentän, jonka perusteella kutsutaan reitinetsimis-luokkaa.
     */
    public void kaynnista() {
        tulostaOhjeet();

        char[][] kentta = lueKentta();

//        etsiReitti(kentta);
    }

    
    /**
     * Tulostaa algoritmin käyttöohjeet
     */
    private void tulostaOhjeet() {
        System.out.println("tässä tulostuu kauniit ohjeet");
        //millainen syötetyn kentän tulee olla, kirjoita "help" niin ohjeet uusiksi,
        //tyhjän rivin syöttäminen päättää kentän syötön,
        //
    }

    /**
     * Luo käyttäjän syötteisiin perustuvan kentän
     * @return valmis kenttä
     */
    private char[][] lueKentta() {
        Scanner lukija = new Scanner(System.in);
        int leveys = lueLeveys(lukija);
        int korkeus = lueKorkeus(lukija);
        String rivi = "";
        char[][] kentta = new char[korkeus][leveys];

        System.out.println("syötä rivit:");

        while (true) {

            for (int i = 0; i < korkeus; i++) {
                //tarkistetaan rivin pituus ja oikeellisuus
                while (rivi.length() != leveys && !riviOnOikeaaMuotoa(rivi)) {
                    rivi = lukija.nextLine().toUpperCase();
                    if (rivi.length() != leveys) {
                        System.out.println("Rivin pituus väärä, odotettiin " + leveys
                                + ", syötit " + rivi.length());
                    }
                    if (!riviOnOikeaaMuotoa(rivi)) {
                        System.out.println("Rivi väärää muotoa, tarkista syötteesi oikeellisuus");
                    }
                }
                for (int j = 0; j < leveys; j++) {
                    kentta[i][j] = rivi.charAt(j);
                }
                rivi = "";
            }
            if (kentassaOnLahtoJaMaali(kentta)) {
                break;
            }
        }
        System.out.println("");
        tulostaKentta(kentta);
        return kentta;

    }

    /**
     * Tulostaa kutsutun kentän
     *
     * @param kentta
     */
    private void tulostaKentta(char[][] kentta) {
        for (char[] kentta1 : kentta) {
            for (char l : kentta1) {
                System.out.print(l);
            }
            System.out.println("");
        }
    }

    /**
     * Lukee käyttäjältä kenttään halutun leveyden ja tarkistaa oikeellisuuden
     *
     * @param lukija
     * @return kentän leveys
     */
    public int lueLeveys(Scanner lukija) {
        System.out.println("Kuinka leveä kenttä luodaan? (väh. 2)");
        int leveys = -1;
        while (leveys < 2) {
            try {
                leveys = Integer.parseInt(lukija.nextLine());
            } catch (Exception e) {
                System.out.println("Syötä luku numeroina");
            }
            if (leveys < 2) {
                System.out.println("Leveyden pitää olla vähintään 2");
            }
        }
        return leveys;

    }

    /**
     * Lukee käyttäjältä kenttään halutun korkeuden ja tarkistaa oikeellisuuden
     *
     * @param lukija
     * @return kentän leveys
     */
    private int lueKorkeus(Scanner lukija) {
        System.out.println("Kuinka korkea? (väh. 2)");

        int korkeus = -1;
        while (korkeus < 2) {
            try {
                korkeus = Integer.parseInt(lukija.nextLine());
            } catch (Exception e) {
                System.out.println("Syötä luku numeroina");
            }
            if (korkeus < 2) {
                System.out.println("Korkeuden pitää olla vähintään 2");
            }
        }
        return korkeus;
    }

    /**
     *Tarkistaa metodille tarjotun rivin (joista kenttä koostuu) oikeellisuuden
     * @param rivi
     * @return onko rivi oikeaa muotoa
     */
    private boolean riviOnOikeaaMuotoa(String rivi) {
        Pattern p = Pattern.compile("([1-9]|[xyXY]|[#])+");
        Matcher m = p.matcher(rivi);
        return m.matches();
    }

    /**
     * Tarkistaa, löytyykö syötetystä kentästä tasan yksi lähtö- ja maalipiste
     * @param kentta
     * @return 
     */
    private boolean kentassaOnLahtoJaMaali(char[][] kentta) {

        boolean lahto = false;
        boolean maali = false;
        for (char[] kentta1 : kentta) {
            for (char l : kentta1) {
                if (l == 'X' && lahto == true) {
                    System.out.println("Lähtöjä enemmän kuin yksi, "
                            + "syötä kenttä uudelleen");
                    return false;
                } else if (l == 'X') {
                    lahto = true;
                } else if (l == 'Y' && maali == true) {
                    System.out.println("Maaleja enemmän kuin yksi, "
                            + "syötä kenttä uudelleen");
                    return false;
                } else if (l == 'Y') {
                    maali = true;
                }
            }
        }
        if (!maali && !lahto) {
            System.out.println("Kentästä puuttuu maali ja lähtö (X ja Y), "
                    + "syötä kenttä uudelleen");
            return false;
        } else if (!maali) {
            System.out.println("Kentästä puuttuu maali (Y), "
                    + "syötä kenttä uudelleen");
            return false;
        } else if (!lahto) {
            System.out.println("Kentästä puuttuu lähtö (X), "
                    + "syötä kenttä uudelleen");
            return false;
        }
        return true;

    }
}
