public class Context {

    public static Strategy select(String mode, String word, int key) {
        switch (mode) {
            case "enc":
                return new Encrypted(word, key);
            case "dec":
                return new Desencrypted(word, key);
            default:
                return null;
        }
    }

    public static String este(Strategy w, String alg) {
        if (alg.equals("shift")) {
            return w.shift();
        }
        else if (alg.equals("unicode")) {
            return w.unicode();
        }
        return null;
    }
}