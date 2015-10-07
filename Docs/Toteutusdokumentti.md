Ohjelma koostuu paketeist kayttoliittyma, sovelluslogiikka ja toiminta.

Käyttöliittymä koostuu Käynnistimesta, joka sisältää käyttäjän syötteen lukemisen ja oikeellisuuden tarkistamisen. Oikeanmuotoisen luvun jälkeen Käyttöliittymä lähettää tiedot Toimintaan Astarille etsimään lyhintä polkua.

Sovelluslogiikka sisältää kaikki tietorakenteet, joita algoritmissa tarvitaan. Minimikeon, Pinon, Solmun ja Verkon.

Toiminta-paketissa on itse ohjelman ydintominta, luokka Astar, jossa sovelluslogiikan keinoin ruvetaan etsimään syötettyyn kenttään lyhintä polkua.

Käynnistimen oma toimina käydään kerran läpi, joten toiminta vakioaikainen.

Keossa alkion asettaminen vie ajan O(logn), sillä keossa alkio lisätään viimeiselle indeksille, jonka jälkeen sitä nostetaan tarvittaessa vertailujen avulla keon 'päällimmäiseksi'. Vertailuja jouduteen keon tehokkaasta rakenteesta johtuen suorittamaan enimmillään logn kertaa. Jos et tiedä, miten keko toimii, suosittelen käymään tietorakenteet ja algoritmit -kurssin uudestaan. (Puurakenteen ideaa käytetään taulukossa, asettaen alkiot siten, että vanhempi löytyy indeksistä i/2, vasen lapsukainen indeksistä 2*i ja oikea 2*1+1, ja oikea järjestys takaa, että parentti on aina lastaan pienempi ja juuressa on keon pienin alkio)

Pienimmän alkion palauttaminen toimii myös ajassa O(logn), sillä tällöin suurin alkio lisätään keon juureen, ja vertailulla liu'utetaan se takaisin alimmalle riville oikealle paikalleen (eli korjataan keko), ja saadaan keko oikeaan järjestykseen taas tekemällä maksimissaan logn määrä vertailuja.

Toistaiseksi painon kasvattaminen on keon ongelma, sillä se käy kaikki alkiot läpi, ja vasta oikean solmun kasvattaa painoa, eli tehokkuus pahimmillaan O(n).

Pinon kaikki operaatiot ovat vakioaikaisia. Solmun myös.

Verkon luominen vie aikaa solmujen määrän verran O(n), mutta se tehdään vain kerran eli ei hätää. Muut metodit vakioaikaisia.

Astarin ydintoimintaan kuuluu alustaminen, joka vie solmujen määrän aikaa O(n), minkä jälkeen toiminta perustuu vierussolmujen tehokkaaseen tutkimiseen, kunnes maali on saavutettu. Suoritamme keon operaation pieninSolmu O(logn) niin monta kertaa, kunnes maali saavutetaan, mikä on maksimissaan solmujen määrä, eli toistaiseksi maksimi vaikuttaisi olevan O(nlogn). Vierussolmujen päivittämisessä tulee ongelma: Ensin tehdään vakioaikaisia vertailuja, kunnes päivitetään vierussolmujen painot. Koska toistaiseksi keon painojen päivitys metodi on tehokkuutta n, tulee kokonaistehokkuudeksi huonoimmassa tapauksessa algoritmille O(n^2), ei tarpeeksi hyvä! Ongelmalle haetaan vielä ratkaisua, tämä ei ole hyvä.

Tilavaativuus algoritmille O(n), sillä algoritmi vaatii pelkästään solmujen määrään suhteellisen määrän tilaa, mikä kasvaa pelkästään solmujen määrän mukaan.

Lähteet: http://www.cs.helsinki.fi/u/floreen/tira2015/sivut351-638.pdf
http://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
https://en.wikipedia.org/wiki/A*_search_algorithm
http://theory.stanford.edu/~amitp/GameProgramming/AStarComparison.html
http://www.redblobgames.com/pathfinding/a-star/introduction.html

