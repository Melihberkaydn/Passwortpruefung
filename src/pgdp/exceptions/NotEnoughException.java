package pgdp.exceptions;

public class NotEnoughException extends Exception {
    private final int should;
    private int is;

    public NotEnoughException(int should, int is) {
        if (is >= should) {
            throw new IllegalArgumentException("Is should be smaller than should");
        }
            this.should = should;
            this.is = is;

    }

    public int getShould() {
        return should;
    }

    public int getIs() {
        return is;
    }

    public void setIs(int is) {
        this.is = is;
    }
}
