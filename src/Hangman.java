import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.util.*;
public class Hangman {

    //private static String word = words[(int) (Math.random() * words.length)];
    //private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
    private static String[] easywords = {"terminator", "banana", "computer", "cow", "rain", "water" };
    private static String word="";
    private static String dashes="";
    private static List<String> incorrectchars = new ArrayList<String>();
    private static List<String> incorrectwords = new ArrayList<String>();
    private static List<String> correctChars = new ArrayList<String>();
    private static int lives = 7 ;
    private static boolean hintused = false;
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

    public static String getWord(String[] hangManWordList){
        Random random = new Random();
        int i = random.nextInt(hangManWordList.length);
        return hangManWordList[i];
    }
    public static String[] readString(String HangmanWordList) throws FileNotFoundException {

        File file = new File(HangmanWordList);
        //System.out.println(file);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(HangmanWordList);
        String[] array = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            array[index++]=scanner.nextLine();
        } scanner.close();
        return array;
    }
    public static String difficultyAndWord() throws FileNotFoundException {
        String difficulty;
        String[] words;

        while (true) {
            System.out.println("===============================================");
            System.out.println("||      WELCOME to Eric's Hangman game!      ||");
            System.out.println("||                                           ||");
            System.out.println("||                 Rules:                    ||");
            System.out.println("||      All guesses must be CAPITALIZED!     ||");
            System.out.println("||       Guess both letters OR words!        ||");
            System.out.println("||       Enter '*' for a helpful hint!       ||");
            System.out.println("||                                           ||");
            System.out.println("||         Choose your difficulty:           ||");
            System.out.println("||           1 = default, 2 = hard           ||");
            System.out.println("===============================================");
            Scanner scanner = new Scanner(System.in);
            difficulty = scanner.nextLine();
            if (difficulty.equals("1") || difficulty.equals("2")) {
                break;
            } else {
                System.out.println("Invalid input, try again.");
            }
        }

        if (difficulty.equals("1")) {
            //word = getWord(easywords);
            words = readString("HangmanDefault.txt");
            word = getWord(words);
        }
        else if (difficulty.equals("2")) {
            words = readString("HangmanWordsList.txt");
            word = getWord(words);
        }
        dashes =new String(new char[word.length()]).replace("\0", "-");
        // System.out.println(word);
        System.out.println(dashes);
        return word;
    }

    public static String playagain() throws FileNotFoundException {
        String playagain="yes";

        while (true) {
            System.out.println();
            System.out.println("Host: Do you want to play again: yes or no");
            Scanner scanner = new Scanner(System.in);
            playagain = scanner.nextLine();
            if (playagain.equals("yes") || playagain.equals("no")) {
                break;
            } else {
                System.out.println("Host: Invalid input, try again.");
                //System.out.println("Do you want to play again: yes or no");
            }
        }
        return(playagain);
    }

    public static String oneguess() throws FileNotFoundException {
        String oneguess="";
        while (true) {
            System.out.println();
            System.out.println("Host: Take a guess! ");
            Scanner scanner = new Scanner(System.in);
            oneguess = scanner.nextLine();
            if (oneguess.isEmpty() ) {
                System.out.println("Host: Invalid input, try again.");
            } else {
                System.out.println("_____________________________________________________________");
                System.out.println();
                break;
                //System.out.println("Do you want to play again: yes or no");
            }
        }
        return(oneguess);
    }
    public static void printHangMan(int lives){
        if (lives == 0) {
            System.out.println();
            System.out.println("Host: You've been hung... womp womp");
            System.out.println();
            System.out.println("||=========");
            System.out.println("||   |");
            System.out.println("||  (>;)");
            System.out.println("||  -|-");
            System.out.println("||  / \\ ");
            System.out.println("||");
            System.out.println("||=========");
            System.out.println("The correct word is " + word);
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


    public static int hang(String guess) {
        int correctguess = 0 ;
        String newdashes = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                newdashes += guess.charAt(0);
                correctChars.add(guess);
            } else if (dashes.charAt(i) != '-') {
                newdashes += word.charAt(i);
            } else {
                newdashes += "-";
            }
        }

        if (dashes.equals(newdashes)) {
            correctguess = 0 ;
        } else {
            dashes = newdashes;
            correctguess =1 ;
        }
        return(correctguess);
    }

    public static void giveahint() {
        String newdashes = "";
        Boolean hintgiven = false;
        String hint="";

        if (hintused == true) {
            System.out.println("Host: You've already used the one hint. Now do your own work. ");
            return;
        }

        if (lives < 7) {
            // can give hint
            for (int i = 0 ; i < word.length(); i++) {
                if (dashes.charAt(i) != '-') {
                    newdashes += dashes.charAt(i);
                }
                else if (hintgiven == false) {
                    newdashes += word.charAt(i);
                    hint += word.charAt(i);
                    hintgiven = true;
                    hintused = true;
                }
                else if (word.charAt(i) ==hint.charAt(0)) {
                    newdashes += word.charAt(i);
                }
                else {
                    newdashes += '-';
                }
            }
            dashes = newdashes ;
        }
        else {
            System.out.println("Host: You haven't made any wrong guesses yet. No hint for you. Keep going!");
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        String playagainchoice = "yes";
        String oneguess = "";
        int correctguess = 0 ;
        int inputlen = 0;
        boolean alreadyguessed = false;
        while (true) {
            // 1. ask for difficulty and geta word
            difficultyAndWord();

            printHangMan(lives);
            // 2. while there is life; repeat
            // ask for an input and do blah blah
            while (lives >0) {
                oneguess = oneguess();
                System.out.println("===================");
                System.out.println("Your input is: " + oneguess);
                System.out.println("===================");

                inputlen = oneguess.length();

                if (inputlen > 1) {
                    // input length > 1 ; guessing a word
                    if (word.equals(oneguess)) {
                        // correctly guessed the word
                        break;
                    }
                    else {
                        // incorrectly guessed the word
                        lives -= 1 ;
                        //printHangMan(lives);
                        //add the incorrect guess to the guess list
                        incorrectwords.add(oneguess);
                    }
                } // if inputlen > 1
                else if (inputlen == 1 ) {
                    for (String tmp : correctChars ) {
                        if (tmp.equals(oneguess)) {
                            System.out.println("Host: You've already guessed this and it's right, give it another go!");
                            alreadyguessed = true;
                            //break;
                        }

                    }
                    // if is a character then check and update etc
                    // first check if this is already guessed
                    for (String tmp : incorrectchars ) {
                        if (tmp.equals(oneguess)) {
                            System.out.println("Host: You've already guessed this and I have already told you it's wrong. Now be serious please:");
                            alreadyguessed = true;
                            //break;
                        }

                    }
                    if (alreadyguessed == false) {
                        if (oneguess.equals("*")) {
                            giveahint();
                            if (dashes.equals(word)) {
                                System.out.println("Host: Oh you sly little cheat, you found a loophole!");
                                break;
                            }
                        } else {
                            correctguess = hang(oneguess);
                            if (correctguess == 0) {
                                lives -= 1;
                                incorrectchars.add(oneguess);
                            } else if (dashes.equals(word)) {
                                break;
                            }
                            // if not a character then check if it's * and give a hint
                        }
                    }
                    else {
                        alreadyguessed = false;
                    }
                }

                printHangMan(lives);
                //PRINT
                System.out.println();
                System.out.println("Your progress so far is: ");
                System.out.println(dashes);
                //print incorrect word list
                System.out.println("The characters you have incorrectly guessed: ");
                System.out.println(incorrectchars);
                //print incorrect guessed characters
                System.out.println("The words you have incorrectly guessed: ");
                System.out.println(incorrectwords);

            } // while lives > 0

            if (lives>0) {
                printHangMan(lives);
                System.out.println();
                System.out.println("***********************************************************************************");
                System.out.println("Host: Congratulations, you guessed it right. The word is indeed: " + word);
                System.out.println("***********************************************************************************");
            }
            else {
                printHangMan(lives);
            }

            // 3. no more lives; ask if the user wants to play again
            // if yes: then repeat while true loop; reset lives to 7
            // if no: break
            lives=0;
            if (lives==0) {
                playagainchoice = playagain();

                if (playagainchoice.equals("yes")) {
                    lives= 7 ;
                    incorrectchars = new ArrayList();
                    incorrectwords = new ArrayList();
                }
                else if (playagainchoice.equals("no")) {
                    break;
                }
            }
        } // end of while (true)
    } // end of main

} // end of class hangman