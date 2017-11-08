package CCSTest;
import CustomerComplaintsSystemAssignment.*;
import java.util.List;


public class CCSTest {

    public static void main(String[] args){
        CCSImplementation ccs = new CCSImplementation();
        CCSGenerator ccsGenerator = new CCSGenerator(ccs);
        ccsGenerator.generateCustomer(20);
        ccsGenerator.generateStaff(10);
        ccsGenerator.generateStaffComplaint(2);
        ccsGenerator.generateLiftComplaint(3);
        ccsGenerator.generateComment(3);
        ccsGenerator.generateGeneralComplaint(5);
        ccs.recordComplaintResolved(RandomGenerators.getRandomComplaintId(ccs));
        List<Customer> customers = ccs.getCustomerList();
        List<Staff> staff = ccs.getStaffList();
        List<Submission> submissions = ccs.getSubmissionList();
        List<Complaint> newComplaints = ccs.getNewComplaints();
        List<Complaint> complaints = ccs.getComplaintList();
        return;
    }

}

