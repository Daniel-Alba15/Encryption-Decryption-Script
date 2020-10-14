public abstract class Strategy {
    private String word;
    private int key;

    public Strategy(String word, int key) {
        this.word = word;
        this.key = key;
    }

    public abstract String unicode();
    public abstract String shift();

    public String getWord() {
        return word;
    }

    public int getKey() {
        return key;
    }
}