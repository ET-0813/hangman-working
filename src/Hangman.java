import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class Hangman {
    public static int countLinesInFile(String HangmanWordList) throws FileNotFoundException {
        File file = new File(HangmanWordList);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        } scanner.close();
        return lineCount;
    }
    public static boolean checkAlphabet(String sGuessUp){
        char[] chars = sGuessUp.toCharArray();
        for (char c:chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }return true;
    }
    public static String printDashes(String dashes, String word) {
        for (int i = 0; i < word.length(); i++) {
            dashes += ("-");
        } return dashes;
    }
    public static String getWord(String[] hangManWordList){
        Random random = new Random();
        int i = random.nextInt(hangManWordList.length);
        return hangManWordList[i];
    }
    public static String[] readString(String HangmanWordList) throws FileNotFoundException {
        File file = new File(HangmanWordList);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(HangmanWordList);
        String[] array = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            array[index++]=scanner.nextLine();
        } scanner.close();
        return array;
    }
    public static String difficultyAndWord(String[] hangManWordList, String word, String difficulty) throws FileNotFoundException {
        while (true) {
            System.out.println("Choose your difficulty: 1 = default, 2 = hard");
            Scanner scanner = new Scanner(System.in);
            difficulty = scanner.nextLine();
            if (difficulty.equals("1") || difficulty.equals("2")) {
                break;
            } else {
                System.out.println("Invalid input, try again.");
            }
        } if (difficulty.equals("1")) {
            hangManWordList = readString("HangmanDefault.txt");
            word = getWord(hangManWordList);
            System.out.println("You have chosen the default difficulty.");
        } else if (difficulty.equals("2")) {
            hangManWordList = readString("HangmanWordsList.txt");
            word = getWord(hangManWordList);
            System.out.println("You have chosen hard... good luck.");
        } return word;
    }
    public static void printHangMan(int lives, StringBuilder sb, StringBuilder wrongGuess){
         if (lives == 0) {
            System.out.println(" You've been hung... womp womp");
            System.out.println("||=========");
            System.out.println("||   |");
            System.out.println("||  (>;)");
            System.out.println("||  -|-");
            System.out.println("||  / \\ ");
            System.out.println("||");
            System.out.println("||=========");
        } if (lives == 1) {
            System.out.println("||=========");
            System.out.println("||   |");
            System.out.println("||  (>;)");
            System.out.println("||  -|-");
            System.out.println("||  /  ");
            System.out.println("||");
            System.out.println("||=========");
        } if (lives == 2) {
            System.out.println("||=========");
            System.out.println("||   |");
            System.out.println("||  (>;)");
            System.out.println("||  -|-");
            System.out.println("||");
            System.out.println("||");
            System.out.println("||=========");
        } if(lives == 3) {
            System.out.println("||=========");
            System.out.println("||   |");
            System.out.println("||  (>;)");
            System.out.println("||  -|");
            System.out.println("||");
            System.out.println("||");
            System.out.println("||=========");
        } if (lives == 4) {
            System.out.println("||=========");
            System.out.println("||   |");
            System.out.println("||  (>;)");
            System.out.println("||   |");
            System.out.println("||");
            System.out.println("||");
            System.out.println("||=========");
        } if (lives == 5) {
            System.out.println("||=========");
            System.out.println("||   |");
            System.out.println("||  (>;)");
            System.out.println("||");
            System.out.println("||");
            System.out.println("||");
            System.out.println("||=========");
        } if (lives == 6) {
            System.out.println("||=========");
            System.out.println("||   |");
            System.out.println("||  ( )");
            System.out.println("||");
            System.out.println("||");
            System.out.println("||");
            System.out.println("||=========");
        } if (lives == 7) {
            System.out.println("||=========");
            System.out.println("||   |");
            System.out.println("|");
            System.out.println("||");
            System.out.println("||");
            System.out.println("||");
            System.out.println("||=========");
        }
    }

    public static void main(String[] args) throws FileNotFoundException{



    }

}