package pgdp.exceptions;

public class NotEnoughLowerCaseException extends NotEnoughLetterException{
    public NotEnoughLowerCaseException(int should, int is) {
        super(should, is);
    }

    @Override
    public String toString() {
        return "Password does not have lower case letter enough.Password contains " + getIs() + " but lower case letters should be " + getShould() + ".";
    }
}
