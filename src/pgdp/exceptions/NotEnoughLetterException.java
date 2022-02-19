package pgdp.exceptions;

public class NotEnoughLetterException extends NotEnoughException{
    public NotEnoughLetterException(int should, int is) {
        super(should, is);
    }

}
