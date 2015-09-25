package sovelluslogiikka;
/**
 * Solmu tietää sijaintinsa koordinaatistossa, sekä painon,
 * joka itseensä kuuluu, ja indeksin, jossa sijaitsee verkossa
 * @author tuomo
 */
public class Solmu {
    final private int x;
    final private int y;
    final int indeksi;
    private int paino;
    
    public Solmu(int x, int y, int paino, int indeksi) {
        this.x = x;
        this.y = y;
        this.paino = paino;
        this.indeksi = indeksi;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public int getPaino() {
        return paino;
    }

    void setPaino(int uusiPaino) {
        this.paino = uusiPaino;
    }

    public int getIndeksi() {
        return indeksi;
    }
    
    
}
