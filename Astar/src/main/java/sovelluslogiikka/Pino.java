package sovelluslogiikka;

import java.util.Stack;

public class Pino {
    private Stack pino;

    public Pino(int koko) {
        this.pino = new Stack();
    }
    
    public void lisaa(int i) {
        pino.push(i);
    }
    
    public int pop() {
        return (int) pino.pop();
    }
    
    public boolean tyhja() {
        return this.pino.empty();
    }
    
}
