import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConsoleInputExample example = new ConsoleInputExample();
        String a;
        do {
            a = sc.nextLine();
            example.printMethod(a);
            System.out.println("a raidziu skaicius yra: " + example.getNumOfA(a, 'a'));
        }
        while(!a.toLowerCase().equals("pabaiga"));{
            int b = a.length();
            if ((b % 2) == 0) {
                System.out.println("Zodis: " + a + " | yra lyginis" + b);
            } else {
                System.out.println("Zodis: " + a + " | yra nelyginis" + b);
            }
        }
        }
        private void printMethod(String a){
            if(a.toLowerCase().equals("pabaiga")){
                return;
            }
            if(a.length() % 2 == 0){
                System.out.println(a + " yra lyginis, jo ilgis: " + a.length());
            }
            else{
                System.out.println(a + " yra nelyginis, jo ilgis: " + a.length());
            }
        }
        private int getNumOfA(String a, char letter){
        int count =0;
            for(int i=0; i < a.length(); i++){
                char l = a.charAt(i);
                if (l == letter) {
                    count++;
                }
            }
            return count;
        }
    }
