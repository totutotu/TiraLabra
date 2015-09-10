A*

A*-algoritmi etsii syötetyn kentän lyhyimmän reitin määritellystä lähtöpisteestä määriteltyyn maaliin. Reitin varrella, voi olla esteitä, ja jostain pisteistä voi olla "raskaampi" liikkua eteenpäin kuin toisesta suunnasta, ja algoritmi etsii esteet kiertävän, kevyimmän reitin alusta loppuun.

Algoritmi on muunnelma Dijkstran algoritmista.

Algoritmissa käytetään perustoiminnalisuudessaan painollisen sekä painottoman verkon läpikäyntiä.

Lyhimpiä reittejä etsiessä paras vaihtoehto valitaan lyhimpien etäisyyksien perusteella apuna käyttäen minimikekoa.

Ohjelmaan lähtökohtaisesti käytän syötteenä käsin naputeltuja "kenttiä", joissa algoritmille syötetään haluttu kenttä seuraavanlaisesti: Ensin algoritmi kysyy mahdollisesti syötettävän kentän koon (esim 10x5), ja tämän jälkeen pyytää käyttäjää syöttämään kentän. Kentän koostumus on seuraavanlainen:

213X9#2122
1421##41Y2
213##3##12
2134123434
12######21,

jossa numerot kertovat kuinka raskasta on liikkua kyseiselle ruudulle, # on merkki esteestä, X on lähtö- ja Y on päättöpiste.

Laskettuaan reitin algoritmi tulostaa kevyimmän reitin korvaten alkuperäisen kentän käyttämättömät ruudut 0:lla, ja reitin 1:llä. Kentän perään algoritmi tulostaa reitin kokonaispainon.

Algoritmin alussa tarkistetaan onko piste ylipäätään saavutettavissa kentässä, mihin käytämme alussa Dijkstran algoritmia sellaisenaan (aikav (|E|+|V|)log|V|).

Keko-operaatioiden aikavaativuudet saadaan logaritmisiksi solmujen määrän suhteen, kekoon lisäämisiä (heap-insert (O(log|V|))) tehdään solmujen määrän verran, eli |V|log|V|. Keon relaksominen (O(log|V|) ja läpikäynninaikaisia etäisyyksiä muokataan pienemmäksi (heap-decrease-key (O(log|V|)), tehdään niin monta kertaa kuin keossa on kaaria, eli O(|E|log|V|). Täten saadaan koko algoritmin aikavaativuukseksi O((|E|+|V|)log|V|).

Tilavaativuus on algoritmissa |V|, sillä laajin tilaavievä komponentti on keko, jossa tallennettuna solmujen määrä elementtejä.

Lähteet:
http://www.cs.helsinki.fi/u/floreen/tira2015/sivut351-638.pdf
http://theory.stanford.edu/~amitp/GameProgramming/AStarComparison.html
http://www.policyalmanac.org/games/aStarTutorial.html
