import java.awt.Color;
/**
 * Write a description of class Tester here.
 * 
 * @author Chris Pritchard
 * @version  v0.1
 */
public class Tester
{
    private Date date1 = new Date (1, 3, 2008);
    private Date date2 = new Date (8, 4, 2008);
    
    private Session s1 = new Session ("S08_01", "BreastStroke Level 3", 0.00, date1);
    private Session s2 = new Session ("S08_02", "ButterFly Level 1", 16.00, date2); 
    
    private Member m1 = new Member (1, "Mick Wood",'A');
    private Member m2 = new Member (2, "Olenka Marczyk",'A');    
    private Member m3 = new Member (3, "David Pearson",'A');
    private Member m4 = new Member (4, "Bodo Scholtz",'A');
    
    private Centre centre1 = new Centre("Hatfield");

    public void doTest ()
    {
        System.out.println (m1.toString());
        System.out.println ("--------------------------");
        System.out.println (s2.toString());
        s1.signUp(m1);
        s1.signUp(m2);
        s1.signUp(m3);
        s1.signUp(m4);
        s1.showMembersOnSession();
        centre1.addSession(s1);
        centre1.addSession(s2);
        System.out.println(s1.toString());
        centre1.searchSessionsByDate(date2);
        centre1.searchSessionsByDate(new Date(1, 3, 2008));
        centre1.cancelSession(s1);
        System.out.println(s1.startDate.compareTo(date1));
        System.out.println(s1.startDate.compareTo(date2));
        System.out.println(s2.startDate.compareTo(date1));
        System.out.println(s2.startDate.compareTo(date2));
        System.out.println(s1.startDate.compareTo(new Date(1, 3, 2008)));
        System.out.println(date2.compareTo(new Date(19, 1, 1991)));
    }
}

