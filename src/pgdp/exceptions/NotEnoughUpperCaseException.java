package pgdp.exceptions;

public class NotEnoughUpperCaseException extends NotEnoughLetterException{
    public NotEnoughUpperCaseException(int should, int is) {
        super(should, is);
    }

    @Override
    public String toString() {
        return "Password does not have upper case letter enough.Password contains " + getIs() + " but upper case letters should be " + getShould() + ".";
    }
}
