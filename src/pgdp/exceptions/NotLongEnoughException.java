package pgdp.exceptions;

public class NotLongEnoughException extends NotEnoughException{
    public NotLongEnoughException(int should, int is) {
        super(should, is);
    }

    @Override
    public String toString() {
        return "Password is not long enough.Password lenght is " + getIs() + " but is should be " + getShould() + ".";
    }
}
