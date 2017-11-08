package CCSTest;

import CustomerComplaintsSystemAssignment.*;

import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;

abstract class RandomGenerators {

    static String getRandomName(){
        return "";
    }

    static String getRandomAddress(){
        return "";
    }

    static String getRandomEmail(){
        return "";
    }

    static String getRandomPhone(){
        return "";
    }

    static String getRandomDepartment(){
        return "";
    }

    static String getRandomRole(){
        return ""
    }

    static String getRandomComment(){
        return "";
    }

    static int getRandomCustomerId(CCS ccs){
        return 0;
    }

    static String getRandomLiftName(){
        return "";
    }

    static int getRandomFloor(int maxFloor){
        return ThreadLocalRandom.current().nextInt(0,maxFloor+1);
    }

    static int getRandomStaffId(CCS ccs){
        return 0;
    }


    /**
     * generate a random date
     * @param minYear the earliest year the date can be in (1st January)
     * @param maxYear the latest year the date can be in (31st December)
     * @return a Date object of the random date
     */
    static Date getRandomDate(int minYear, int maxYear){
        //using ThreadLocalRandom (https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ThreadLocalRandom.html#nextInt-int-int-)
        // to generate a random valid date between 2013 and 2017
        int m = ThreadLocalRandom.current().nextInt(1,13);
        int d;
        int y = ThreadLocalRandom.current().nextInt(minYear,maxYear+1);

        if (m == 2){
            if (new GregorianCalendar().isLeapYear(y)){
                d = ThreadLocalRandom.current().nextInt(1,30);
            }
            else {
                d = ThreadLocalRandom.current().nextInt(1, 29);
            }
        } else if (m == 4 || m == 6 || m == 9 || m == 11 ){
            d = ThreadLocalRandom.current().nextInt(1,31);
        } else{
            d = ThreadLocalRandom.current().nextInt(1, 32);
        }


        return new Date(d, m, y);
    }
}
