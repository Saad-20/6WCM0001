package CCSTest;

import CustomerComplaintsSystemAssignment.*;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//cheating because someone's already done the hard work of creating random name/address generators
//needs java-faker - https://github.com/DiUS/java-faker
import com.github.javafaker.*;

/**
 * A utility class that contains a collection of static random generator methods
 */
public abstract class RandomGenerators {

    private static Faker faker = new Faker(new Locale("en", "GB"));
    /**
     * gets a random first name
     * @return a random first name
     */
    public static String getRandomFirstName(){
        return faker.name().firstName();
    }

    /**
     * gets a random surname
     * @return a random surname
     */
    public static String getRandomLastName(){
        return faker.name().lastName();
    }

    /**
     * gets a random address
     * @return a random street address
     */
    public static String getRandomAddress(){
        return faker.address().fullAddress();
    }

    /**
     * a random email based on firstname and lastname
     * @param firstname the first name of the person whose email address we are generating
     * @param lastname the last name of the person whose email address we are generating
     * @return an email address
     */
    public static String getRandomEmail(String firstname, String lastname){
        return firstname+"."+lastname+"@"+faker.company().url().replaceFirst("www.","");
    }

    /**
     * a random phone number
     * @return a random phone number
     */
    public static String getRandomPhone(){
        String phoneNumber;
        int random = ThreadLocalRandom.current().nextInt(0,2);
        if(random == 0){
            phoneNumber = faker.phoneNumber().cellPhone();
        }else{
            phoneNumber = faker.phoneNumber().phoneNumber();
        }
        return phoneNumber;
    }

    /**
     * get a random job department
     * @return a random department
     */
    public static String getRandomDepartment(){
        return faker.job().field();
    }

    /**
     * get a random job role
     * @return a random role
     */
    public static String getRandomRole(){
        return faker.job().position();
    }

    /**
     * get a random comment / complaint (at this time it's harry potter, game of thrones or shakespeare quotes)
     * @return a random comment / complaint
     */
    public static String getRandomComment(){
        String comment;
        int random = ThreadLocalRandom.current().nextInt(0,3);
        if(random == 0){
            comment = faker.harryPotter().quote();
        }else if (random == 1){
            comment = faker.gameOfThrones().quote();
        }else{
            comment = faker.shakespeare().asYouLikeItQuote();
        }
        return comment;
    }

    /**
     * get a random (valid) customer ID from the CCS
     * @param ccs the CCS instance to compare against
     * @return a random (valid) customer ID
     */
    public static int getRandomCustomerId(CCS ccs){
        List<Customer> customerList = ccs.getCustomerList();
        int random = ThreadLocalRandom.current().nextInt(0,customerList.size());
        return customerList.get(random).getId();
    }

    /**
     * get a random lift name (currently using ancient gods to name our lifts)
     * @return a random lift name
     */
    public static String getRandomLiftName(){
        //we name our lifts after ancient Gods
        return faker.ancient().god();
    }

    /**
     * a random floor between 0 (ground) and maxfloor
     * @param maxFloor the highest floor
     * @return a random floor
     */
    public static int getRandomFloor(int maxFloor){
        return ThreadLocalRandom.current().nextInt(0,maxFloor+1);
    }
    /**
     * a random floor between minFloor and maxfloor
     * @param minFloor the lowest floor
     * @param maxFloor the highest floor
     * @return a random floor
     */
    public static int getRandomFloor(int minFloor, int maxFloor){
        return ThreadLocalRandom.current().nextInt(minFloor,maxFloor+1);
    }

    /**
     * get a random (valid) staff ID from the CCS
     * @param ccs the CCS instance to compare against
     * @return a random (valid) staff ID
     */
    public static int getRandomStaffId(CCS ccs){
        List<Staff> staffList = ccs.getStaffList();
        int random = ThreadLocalRandom.current().nextInt(0,staffList.size());
        return staffList.get(random).getId();
    }


    /**
     * generate a random date
     * @param minYear the earliest year the date can be in (1st January)
     * @param maxYear the latest year the date can be in (31st December)
     * @return a Date object of the random date
     */
    public static Date getRandomDate(int minYear, int maxYear){
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

    /**
     * get a random (valid) customer ID from the CCS
     * @param ccs the CCS instance to compare against
     * @return a random (valid) complaint ID
     */
    public static int getRandomComplaintId(CCS ccs){
        List<Complaint> complaintList = ccs.getComplaintList();
        int random = ThreadLocalRandom.current().nextInt(0,complaintList.size());
        return complaintList.get(random).getId();
    }
}
