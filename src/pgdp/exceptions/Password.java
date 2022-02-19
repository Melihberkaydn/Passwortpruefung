package pgdp.exceptions;

public class Password {
    private final int nrUpperShould, nrLowerShould, lengthShould;
    private final char[] illegalChars;

    static boolean matchesIllegalCharacter(
            char[] illegalChars,
            char c
    ) {
        for (char illegalChar : illegalChars)
            if (c == illegalChar) {
                return true;
            }
        return false;
    }

    public Password(int nrUpperShould, int nrLowerShould, int lengthShould, char[] illegalChars) {
        if (nrLowerShould + nrUpperShould > lengthShould) {
            throw new IllegalArgumentException("Sum of the lower and upper characters cannot be bigger than whole lenght.");
        }
        this.nrUpperShould = nrUpperShould;
        this.nrLowerShould = nrLowerShould;
        this.lengthShould = lengthShould;
        this.illegalChars = illegalChars;
    }


    public void checkFormat(String pwd) throws NotEnoughException, IllegalCharException{
        int upperCaseAmount = (int)  pwd.chars().filter(c-> c>='A' && c<='Z').count();
        int lowerCaseAmount = (int)  pwd.chars().filter(c-> c>='a' && c<='z').count();
        int illegalCharacterAmount = (int)  pwd.chars().filter(c -> matchesIllegalCharacter(illegalChars,(char) c)).count();
        int stringLenght = pwd.length();

        if (illegalCharacterAmount > 0) {
            char firstIllegalCharacter =  Character.toChars(pwd.chars().filter(c -> matchesIllegalCharacter(illegalChars,(char) c)).findFirst().getAsInt())[0];
            throw new IllegalCharException(firstIllegalCharacter);
        } else if (upperCaseAmount < nrUpperShould) {
            throw new NotEnoughUpperCaseException(nrUpperShould, upperCaseAmount);
        } else  if (lowerCaseAmount < nrLowerShould) {
            throw new NotEnoughLowerCaseException(nrLowerShould, lowerCaseAmount);
        } else if (stringLenght < lengthShould) {
            throw new NotLongEnoughException(lengthShould, stringLenght);
        } else {
            System.out.println("Success!");
        }

    }

    public void checkFormatWithLogging(String pwd) throws NotEnoughException, IllegalCharException {
        try{
            checkFormat(pwd);
        } catch (NotEnoughException | IllegalCharException e) {
            System.out.println(e);
            throw e;
        }
    }
}
