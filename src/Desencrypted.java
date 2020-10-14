public class Desencrypted extends Strategy {
    public Desencrypted(String word, int key) {
        super(word, key);
    }

    @Override
    public String unicode() {
        String wordDesencrypted = "";
        String w = super.getWord()

        for (int i = 0; i < w.length(); i++) {
            int count = 0;
            char c = w.charAt(i);
            int a = (int) c;
            int iter = a;

            while (count < super.getKey()) {
                if (iter == 32) {
                    iter = 127;
                    count++;
                    continue;
                }

                iter--;
                count++;
            }

            wordDesencrypted += (char) iter;

        }

        return wordDesencrypted;
    }

    @Override
    public String shift() {
        String vocabulary = "abcdefghijklmnopqrstuvwxyz";
        String wordEncry = "";
        String w = super.getWord();

        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);
            int a = vocabulary.indexOf(Character.toLowerCase(c));

            if (a >= 0) {
                a -= super.getKey();

                if (a < 0) {
                    a += vocabulary.length();
                }

                if (Character.isUpperCase(c)) {
                    wordEncry += Character.toUpperCase(vocabulary.charAt(a));
                }

                else {
                    wordEncry += vocabulary.charAt(a);
                }
            }
            else {
                wordEncry += c;
            }
        }

        return wordEncry;
    }
}
