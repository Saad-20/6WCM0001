import java.util.Scanner;

public class ArrayExercisesTest {
    private static boolean wait = true;
    private static boolean[] tests = {false, false, false, false};
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        ArrayExercises arrayExercises = new ArrayExercises();
        parseArgs(args);
        if (!tests[0] || tests[1]){
            System.out.println("Testing the MonthLength method");
            monthLengthTest(arrayExercises);
            waitForNextLine();
        }
        if (!tests[0] || tests[2]){
            System.out.println("Testing the testMarks method");
            testMarksTest(arrayExercises);
            waitForNextLine();
        }
        if (!tests[0] || tests[3]) {
            System.out.println("Testing the numVowels method");
            numVowelsTest(arrayExercises);
            waitForNextLine();
        }
    }

    private static void monthLengthTest(ArrayExercises a){
        final String[] months = {"January (31)", "February (28)", "March (31)", "April (30)", "May (31)", "June (30)", "July (31)", "August (31)", "September (30)", "October (31)", "November (30)", "December (31)"};
        for(int i=1; i<=12; i++){
            System.out.println("Testing for " + months[i-1] + ": " + a.monthLength(i));
        }
        System.out.println("Testing for leap year (29): " + a.monthLength(2, true));
        System.out.println("Testing for non leap year (28): " + a.monthLength(2, false));
        System.out.println("Testing for January in a leap year (31): " + a.monthLength(1, true));
        System.out.println("Testing for out of bounds (13) arguments (-1): " + a.monthLength(13));
        System.out.println("Testing for out of bounds (-2567) arguments (-1): " + a.monthLength(-2567));
        System.out.println("Testing for out of bounds (0) arguments (-1): " + a.monthLength(0));
        System.out.println("Testing for out of bounds (72357) arguments (-1): " + a.monthLength(72357));
        System.out.println("We haven't crashed...");
    }

    private static void testMarksTest(ArrayExercises a){
        System.out.println("Trying with an array including marks 0-100:");
        System.out.println("Expected - 4,5,3,6");
        a.testMarks(new int[]{0,24,25,49,50,74,75,100,13,15,28,58,27,32,78,82,98,79});
        System.out.println("Trying with an array with any positive integers:");
        System.out.println("Expected - 1,2,1,1 (4 elements not counted)");
        a.testMarks(new int[]{1,78,32,25,67, 101, 19999, 2357, 264578});
        System.out.println("Trying with an array with negative integers");
        System.out.println("Expected - 1,2,1,1 (5 elements not counted)");
        a.testMarks(new int[]{1,78,32,25,67,-123, -1, -25, -198726, -100});
        System.out.println("Trying with an empty array");
        a.testMarks(new int[]{});
        System.out.println("We haven't crashed...");
    }

    private static void numVowelsTest(ArrayExercises a){
        String s1 = "\"The quick brown fox jumped over the lazy dog\"";
        String s2 = "\"Ăngström the æthereal\"";
        System.out.println("Trying with the string: " + s1 );
        System.out.println("Expected: A: 1, E: 4 I: 1, O: 4, U: 2");
        a.numVowels(s1);
        System.out.println("Trying with the string: " + s2 );
        System.out.println("Expected: A: 1, E: 3, I: 0, O: 0, U: 0");
        a.numVowels(s2);
        System.out.println("We haven't crashed...");
    }

    private static void waitForNextLine(){
        if (wait){
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
        }
    }

    private static void parseArgs(String[] args){
        for (String s: args) {
            if (s.equals("-y")){
                wait = false;
            }
            else if (s.equals("-t")){
                tests[0] = true;
            }
            else if (s.equals("--months")){
                tests[1] = true;
            }
            else if (s.equals("--marks")){
                tests[2] = true;
            }
            else if (s.equals("--vowels")){
                tests[3] = true;
            }
            else if (s.equals("-h")){
                System.out.println("Usage: java ArrayExercisesTest [OPTIONS]");
                System.out.println("ArrayExercises Test, a set of test routines for the ArrayExercises Class from the 6WCM0001 Module, part of the University of Hertfordshire Computer Science MSc Program");
                System.out.println("The ArrayExercises class file must be in the same directory as this class file");
                System.out.println("Arguments (must be separate):");
                System.out.println("-h          Prints this help and exits");
                System.out.println("-y          Runs through the program without pausing");
                System.out.println("-t          Only runs specified tests");
                System.out.println("--months    Runs the months test (must be used with the -t option)");
                System.out.println("--marks     Runs the marks test (must be used with the -t option)");
                System.out.println("--vowels    Runs the vowels test (must be used with the -t option)");
                System.exit(0);
            }
        }
    }

}
