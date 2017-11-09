package CCSTest;
import CustomerComplaintsSystemAssignment.*;
import java.util.List;

public class CCSTest {

    public static void main(String[] args){
        CCSImplementation ccs = new CCSImplementation();
        CCSGenerator ccsGenerator = new CCSGenerator(ccs);
        ccsGenerator.generateCustomer(200);
        ccsGenerator.generateStaff(100);
        ccsGenerator.generateStaffComplaint(20);
        ccsGenerator.generateLiftComplaint(30);
        ccsGenerator.generateComment(27);
        ccsGenerator.generateGeneralComplaint(15);
        ccs.recordComplaintResolved(RandomGenerators.getRandomComplaintId(ccs));
        List<Customer> customers = ccs.getCustomerList();
        List<Staff> staff = ccs.getStaffList();
        List<Submission> submissions = ccs.getSubmissionList();
        List<Complaint> newComplaints = ccs.getNewComplaints();
        List<Complaint> complaints = ccs.getComplaintList();
        return;
    }

}

