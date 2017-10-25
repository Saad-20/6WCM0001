public class ArrayExercisesTest {
    private static boolean wait = true;
    public static void main(String[] args){
        for (String s: args) {
            if (s.equals("-y")){
                wait = false;
            }
        }
        ArrayExercises arrayExercises = new ArrayExercises();
        System.out.println("Testing the MonthLength method");
        monthLengthTest(arrayExercises);
        waitForNextLine();
        System.out.println("Testing the testMarks method");
        testMarksTest(arrayExercises);
        waitForNextLine();
        System.out.println("Testing the numVowels method");
        numVowelsTest(arrayExercises);
        waitForNextLine();
    }

    private static void monthLengthTest(ArrayExercises a){
        final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for(int i=1; i<=12; i++){
            System.out.println("Testing for " + months[i-1] + ": " + a.monthLength(i));
        }
        System.out.println("Testing for leap year: " + a.monthLength(2, true));
        System.out.println("Testing for non leap year: " + a.monthLength(2, false));
        System.out.println("Testing for non-feb in a leap year: " + a.monthLength(1, true));
        System.out.println("Testing for out of bounds arguments (13): " + a.monthLength(13));
        System.out.println("Testing for out of bounds arguments (-2567): " + a.monthLength(-2567));
        System.out.println("Testing for out of bounds arguments (0): " + a.monthLength(0));
        System.out.println("Testing for out of bounds arguments (72357): " + a.monthLength(72357));
        System.out.println("We haven't crashed...");
    }

    private static void testMarksTest(ArrayExercises a){
        System.out.println("Trying with an array including marks 0-100:");
        System.out.println("Expected - 4,5,3,6");
        a.testMarks(new int[]{0,24,25,49,50,74,75,100,13,15,28,58,27,32,78,82,98,79});
        System.out.println("Trying with an array with any positive integers:");
        System.out.println("Expected - 1,2,1,1 (3 elements not counted)");
        a.testMarks(new int[]{1,78,32,25,67, 19999, 2357, 264578});
        System.out.println("Trying with an array with negative integers");
        System.out.println("Expected - 1,2,1,1 (5 elements not counted)");
        a.testMarks(new int[]{1,78,32,25,67,-123, -1, -25, -198726, -100});
        System.out.println("Trying with an empty array");
        a.testMarks(new int[]{});
        System.out.println("We haven't crashed...");
    }

    private static void numVowelsTest(ArrayExercises a){

    }

    private static void waitForNextLine(){
        if (wait){
            System.out.println("Press Enter to continue...");
            try {
                System.in.read();
            } catch (Exception e){}
        }
    }

}
