import java.util.*;

/**
 * Class Session describes sessions organized by a swimming centre.
 * 
 * @author Chris Pritchard
 * @version 0.1
 */
public class Session
{
    private String SessionCode;
    private String description;
    private double fee;
    public  Date startDate;
    private double totalFees;
    private ArrayList<Member> members;
     
    public Session (String SessionCode, String description, 
                    double fee, Date date)
    {
        startDate = date;
        this.SessionCode = SessionCode;
        this.description = description;
        this.fee = fee;
        totalFees = 0;
        members = new ArrayList<>();
     }
     
    public String getSessionCode () {return SessionCode;}

    public double getFee () {return fee;}

    public Date getStartDate () {return startDate;}
       
    public String toString()
    {              
        String separator = ", ";
        return SessionCode + separator + description + separator + 
                            "\nDate: " + startDate.toString() + 
                            "\nFee: " + fee + " Total fees: " + totalFees;
    }

    public void signUp(Member member){
        members.add(member);
        totalFees = totalFees + fee;
    }

    public void showMembersOnSession(){
        for ( Member member : members){
            System.out.println(member.toString());
        }
    }
}
