public class ArrayExercises {

    private static final int[] monthLengths = {31,28,31,30,31,30,31,31,30,31,30,31};
    /**
     *  Takes a month (in the form of a number) and returns the number of days in that month. This assumes it is not a
     *  leap year
     * @param monthNumber a value between 1 and 12 representing a month, ignoring leap years
     * @return the number of days in that month
     *
     * e.g. monthLength(2) returns 28
     */
    public int monthLength(int monthNumber){
        if(monthNumber > 12 || monthNumber <= 0){
            return -1;
        }
        else{
            return  monthLengths[monthNumber-1];
        }
    }

    /**
     *
     *  Takes a month (in the form of a number), and whether or not it is a leap year (in the form of a boolean)
     *  and returns the number of days in that month.
     * @param monthNumber a value between 1 and 12 representing a month
     * @param isLeapYear true if the year is a leap year, false if not
     * @return the number of days in that month
     *
     * e.g. monthLength(2,true) returns 29
     */
    public int monthLength(int monthNumber, boolean isLeapYear){
        if(monthNumber == 2 && isLeapYear){
            return 29;
        }
        else{
            return this.monthLength(monthNumber);
        }
    }

    /**
     * takes an array of marks and prints the number within the ranges 0-24, 25-49, 50-74, 75-100. Marks outside these ranges
     * are ignored
     * @param marks an array of marks
     */
    public void testMarks(int[] marks){
        int[] counter = {0,0,0,0};
        for (int m: marks) {
            if (m >= 0 && m < 100){
                int n = m/25;
                counter[n]++;
            }
            else if (m == 100){
                counter[3]++;
            }
        }
        System.out.println("0-24: " + counter[0]);
        System.out.println("25-49: " + counter[1]);
        System.out.println("50-74: " + counter[2]);
        System.out.println("75-100: " + counter[3]);
    }

    /**
     * Takes a string and prints the number of each vowel
     * @param s the string to be tested
     */
    public void numVowels(String s){
        int aCount = 0;
        int eCount = 0;
        int iCount = 0;
        int oCount = 0;
        int uCount = 0;
        for(int i=0; i<s.length(); i++){
            switch (s.charAt(i)){
                case 'A':
                case 'a':   aCount++;
                            break;
                case 'E':
                case 'e':   eCount++;
                            break;
                case 'I':
                case 'i':   iCount++;
                            break;
                case 'O':
                case 'o':   oCount++;
                            break;
                case 'U':
                case 'u':   uCount++;
                            break;
            }
        }
        System.out.println("There were:");
        System.out.print(aCount + " A's ");
        printStars(aCount);
        System.out.println();
        System.out.print(eCount + " E's ");
        printStars(eCount);
        System.out.println();
        System.out.print(iCount + " I's ");
        printStars(iCount);
        System.out.println();
        System.out.print(oCount + " O's ");
        printStars(oCount);
        System.out.println();
        System.out.print(uCount + " U's ");
        printStars(uCount);
        System.out.println();
    }
    private void printStars(int numberOfStars){
        for (int i = 0; i < numberOfStars; i++){
            System.out.print("*");
        }
    }
}
