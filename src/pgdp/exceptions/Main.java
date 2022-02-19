package pgdp.exceptions;

public class Main {
    public static void main(String[] args) throws NotEnoughException, IllegalCharException {
        //NotEnoughException a = new NotEnoughException(3,4);
        //System.out.println(a.getIs());
        String pass = "sadfasf//";
        String illegalChars = "/&+^ '/?()";
        char[] arrayversion = illegalChars.toCharArray();
        int illegalAmount = (int)  pass.chars().filter(c -> Password.matchesIllegalCharacter(arrayversion,(char) c)).count();
        System.out.println(illegalAmount);
        Password password = new Password(1,4,10, arrayversion);
        password.checkFormatWithLogging("Mee rıd2333");
    }
}
