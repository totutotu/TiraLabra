package sovelluslogiikka;
/**
 * Solmu tietää sijaintinsa koordinaatistossa, sekä painon,
 * joka itseensä kuuluu.
 * @author tuomo
 */
public class Solmu {
    final private int x;
    final private int y;
    final private int paino;

    public Solmu(int x, int y, int paino) {
        this.x = x;
        this.y = y;
        this.paino = paino;
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
}
