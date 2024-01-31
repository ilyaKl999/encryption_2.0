import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Encryption encryption = new Encryption("she named our ginger cat Bo"+
                "My father’s name is Igor. He is a little older than mom and he used to be a police officer. He" +
                " retired at a quite young age and has been running his own business ever since. He has a small ");
        System.out.println(encryption.method_Encryption());
        String a = encryption.method_Encryption();
        Encryption encryption2 = new Encryption(a);
        System.out.println(encryption2.method_Decryption_File());
        System.out.println("\n");

        Encryption encryption1 = new Encryption("Обычно в генерируемом тексте используется «мешанка» предложений, " +
                "взятых из различных текстов. Источниками могут быть сборки рассказов в несколько мегабайтов текста, или " +
                "страницы сайтов схожей тематики. Но если источниками являются только ");
        System.out.println(encryption1.method_Encryption());
        String c = encryption1.method_Encryption();
        Encryption encryption4 = new Encryption(c);
        System.out.println(encryption4.method_Decryption_File());

        System.out.println("\n");
        Encryption encryption6 = new Encryption("Привети");
        System.out.println(encryption6.method_Encryption());
        String cc = encryption6.method_Encryption();
        Encryption encryption7 = new Encryption(cc);
        System.out.println(encryption7.method_Decryption_File());
        System.out.println("\n");



    }

    static class Encryption {
        private static int getRandom(int min, int max) {
            int range = (max - min) + 1;
            int random = (int) ((range * Math.random()) + min);
            return random;
        }

        private static final int CONST = 20;
        private String text;
        private static final String KEY_SEPARATOR = ":_<";
        private static final String SEPARATOR = "'@>";

        public String getText() {
            return text;
        }

        public Encryption(String text) {
            this.text = text;
        }

        public String method_Encryption() {
            if (text.length()<20){return new String("Ограничение по длине текста- минимум 20 символов");}
            byte key_1, key_2, key_3;
            key_1 = (byte) getRandom(1, 9);
            key_2 = (byte) getRandom(10, 99);
            key_3 = (byte) getRandom(100, 127);
            StringBuilder secret_file = new StringBuilder();
            byte counter = 1;
            secret_file = secret_file.append(KEY_SEPARATOR + SEPARATOR + key_1 +
                    SEPARATOR + key_2 + SEPARATOR + key_3 + SEPARATOR + KEY_SEPARATOR);
            for (int i = 0; i < text.length(); i++) {
                if (i % CONST == 0) {
                    counter++;
                }
                if (counter == 1) {
                    secret_file = secret_file.append((char) (text.charAt(i) + key_1));

                } else if (counter == 2) {
                    secret_file = secret_file.append((char) (text.charAt(i) + key_2));
                } else if (counter == 3) {
                    secret_file = secret_file.append((char) (text.charAt(i) + key_3));
                }
                counter=1;
            }
            return secret_file.toString();
        }
        public  String method_Decryption_File() {
            String [] find_key= text.split(KEY_SEPARATOR);
            if (find_key.length<2){return new String("В тексте не найдено ключей.Расшифровка невозможна"); }
            String [] get_Key = text.split(SEPARATOR);

            int key_1,key_2,key_3;
            key_1= Integer.parseInt(get_Key[1]);
            key_2= Integer.parseInt(get_Key[2]);
            key_3= Integer.parseInt(get_Key[3]);
            int counter= 1 ;
            String a = text.substring(24);
            StringBuilder secret_file = new StringBuilder();
            for (int i = 0; i < a.length(); i++) {
                if (i % CONST == 0) {
                    counter++;
                }
                if (counter == 1) {
                    secret_file = secret_file.append((char) (a.charAt(i) - key_1));

                } else if (counter == 2) {
                    secret_file = secret_file.append((char) (a.charAt(i) - key_2));
                } else if (counter == 3) {
                    secret_file = secret_file.append((char) (a.charAt(i) - key_3));
                }
                counter=1;
            }
            return secret_file.toString();

        }

    }
}