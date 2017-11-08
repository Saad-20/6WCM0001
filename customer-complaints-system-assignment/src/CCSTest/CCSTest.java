package CCSTest;
import CustomerComplaintsSystemAssignment.*;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CCSTest {

    public static void main(String[] args){
        CCSImplementation ccs = new CCSImplementation();

        ccs.addCustomer(ccs.getNewCustomerId(), "Tom Smith", "123 Fake Street", "a@b1.com", "01234516789");
        ccs.addCustomer(ccs.getNewCustomerId(), "Tom Smith1", "123 Fake Street1", "a@b2.com", "01234516789");
        ccs.addCustomer(ccs.getNewCustomerId(), "Tom Smith2", "123 Fake Street2", "a@b3.com", "01234516789");
        ccs.addCustomer(ccs.getNewCustomerId(), "Tom Smith3", "123 Fake Street3", "a@b4.com", "012345126789");
        ccs.addCustomer(ccs.getNewCustomerId(), "Tom Smith4", "123 Fake Street4", "a@b5.com", "01234526789");
        List<Customer> list = ccs.getCustomerList();
        return;
    }


    private void generateStaff(CCS ccs){
        ccs.addStaff(ccs.getNewStaffId(), RandomGenerators.getRandomName(), RandomGenerators.getRandomRole(), RandomGenerators.getRandomDepartment());
    }

    private void generateCustomer(CCS ccs){
        ccs.addCustomer(ccs.getNewCustomerId(), RandomGenerators.getRandomName(), RandomGenerators.getRandomAddress(), RandomGenerators.getRandomEmail(), RandomGenerators.getRandomPhone());
    }

    private void generateComment(CCS ccs){
        //generate an array containing the arguments for creating a new submission - avoiding code duplication
        Object[] submissionArgs = generateGenericSubmissionArgs(ccs);
        //not ideal, but downcast the Objects returned in the array to their correct types
        ccs.addComment(ccs.getNewSubmissionId(), (int) submissionArgs[0], (String) submissionArgs[1], (Date) submissionArgs[2] );
    }

    private void generateGeneralComplaint(CCS ccs){
        Object[] submissionArgs = generateGenericSubmissionArgs(ccs);
        ccs.addGeneralComplaint(ccs.getNewSubmissionId(), (int) submissionArgs[0], (String) submissionArgs[1], (Date) submissionArgs[2] );
    }

    private void generateStaffComplaint(CCS ccs){
        Object[] submissionArgs = generateGenericSubmissionArgs(ccs);
        ccs.addStaffComplaint(ccs.getNewSubmissionId(), (int) submissionArgs[0], (String) submissionArgs[1], RandomGenerators.getRandomStaffId(ccs), (Date) submissionArgs[2]);
    }

    private void generateLiftComplaint(CCS ccs){
        Object[] submissionArgs = generateGenericSubmissionArgs(ccs);
        ccs.addLiftComplaint(ccs.getNewSubmissionId(), (int) submissionArgs[0], (String) submissionArgs[1], RandomGenerators.getRandomLiftName(), RandomGenerators.getRandomFloor(15), (Date) submissionArgs[2]);
    }

    

    private Object[] generateGenericSubmissionArgs(CCS ccs){
        return new Object[]{RandomGenerators.getRandomCustomerId(ccs), RandomGenerators.getRandomComment(), RandomGenerators.getRandomDate(2010,2017)};
    }
}

