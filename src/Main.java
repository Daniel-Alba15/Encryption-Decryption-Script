import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        String mode = "enc";
        boolean data = false;
        String out = "";
        int key = 0;
        String word = "";
        String alg = "shift";
        Strategy pala;

        try {
            for (int i = 0; i < args.length; i++) {
                switch(args[i]) {
                    case "-mode":
                        mode = args[i + 1];
                        break;
                    case "-key":
                        key = Integer.parseInt(args[i + 1]);
                        break;
                    case "-in":
                        if (!data)
                            word = args[i + 1];
                        break;
                    case "-out":
                        out = args[i + 1];
                        break;
                    case "-data":
                        word = args[i + 1];
                        data = true;
                        break;
                    case "-alg":
                        alg = args[i + 1];
                    default:
                        break;
                }
            }
        }catch(Exception e) {
            System.out.println("Error");
        }

        if (!data) {
            word = read(word);
        }

        pala = Context.select(mode, word, key);
        word = Context.este(pala, alg);

        if (out.length() > 0) {
            write(word, out);
        }
        else {
            System.out.println(word);
        }
    }

    private static void write(String input, String out) {
        try (FileWriter writer = new FileWriter(out)) {
            writer.write(input);
        }catch(IOException e){
            System.out.println(String.format("Input file not found"));
        }
    }

    private static String read(String input) {
        String content = "";
        File file = new File(input);

        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()) {
                content += scanner.nextLine();
            }
        }catch(IOException e){
            System.out.println(String.format("File not found in: %s", input));
        }

        return content;
    }
}