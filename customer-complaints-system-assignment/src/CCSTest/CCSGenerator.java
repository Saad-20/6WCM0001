package CCSTest;

import CustomerComplaintsSystemAssignment.CCS;
import CustomerComplaintsSystemAssignment.Date;

public class CCSGenerator {

    private CCS ccs;

    public CCSGenerator(CCS ccs) {
        this.ccs = ccs;
    }

    public void generateStaff(){
        String firstName = RandomGenerators.getRandomFirstName();
        String lastName = RandomGenerators.getRandomLastName();
        String fullName = firstName+" "+lastName;
        ccs.addStaff(ccs.getNewStaffId(), fullName, RandomGenerators.getRandomRole(), RandomGenerators.getRandomDepartment());
    }

    public void generateStaff(int number){
        for(int i=0; i<number; i++){
            generateStaff();
        }
    }

    public void generateCustomer(){
        String firstName = RandomGenerators.getRandomFirstName();
        String lastName = RandomGenerators.getRandomLastName();
        String fullName = firstName+" "+lastName;
        ccs.addCustomer(ccs.getNewCustomerId(), fullName, RandomGenerators.getRandomAddress(), RandomGenerators.getRandomEmail(firstName, lastName), RandomGenerators.getRandomPhone());
    }

    public void generateCustomer(int number){
        for(int i=0; i<number; i++){
            generateCustomer();
        }
    }

    public void generateComment(){
        //generate an array containing the arguments for creating a new submission - avoiding code duplication
        Object[] submissionArgs = generateGenericSubmissionArgs();
        //not ideal, but downcast the Objects returned in the array to their correct types
        ccs.addComment(ccs.getNewSubmissionId(), (int) submissionArgs[0], (String) submissionArgs[1], (Date) submissionArgs[2] );
    }

    public void generateComment(int number){
        for(int i=0; i<number; i++){
            generateComment();
        }
    }

    public void generateGeneralComplaint(){
        Object[] submissionArgs = generateGenericSubmissionArgs();
        ccs.addGeneralComplaint(ccs.getNewSubmissionId(), (int) submissionArgs[0], (String) submissionArgs[1], (Date) submissionArgs[2] );
    }

    public void generateGeneralComplaint(int number){
        for(int i=0; i<number; i++){
            generateGeneralComplaint();
        }
    }
    public void generateStaffComplaint(){
        Object[] submissionArgs = generateGenericSubmissionArgs();
        ccs.addStaffComplaint(ccs.getNewSubmissionId(), (int) submissionArgs[0], (String) submissionArgs[1], RandomGenerators.getRandomStaffId(ccs), (Date) submissionArgs[2]);
    }

    public void generateStaffComplaint(int number){
        for(int i=0; i<number; i++){
            generateStaffComplaint();
        }
    }

    public void generateLiftComplaint(){
        Object[] submissionArgs = generateGenericSubmissionArgs();
        ccs.addLiftComplaint(ccs.getNewSubmissionId(), (int) submissionArgs[0], (String) submissionArgs[1], RandomGenerators.getRandomLiftName(), RandomGenerators.getRandomFloor(15), (Date) submissionArgs[2]);
    }

    public void generateLiftComplaint(int number){
        for(int i=0; i<number; i++){
            generateLiftComplaint();
        }
    }


    private Object[] generateGenericSubmissionArgs(){
        return new Object[]{RandomGenerators.getRandomCustomerId(ccs), RandomGenerators.getRandomComment(), RandomGenerators.getRandomDate(2010,2017)};
    }
}
