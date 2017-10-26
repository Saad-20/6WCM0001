import java.util.HashMap;
import java.util.HashSet;

/**
import java.util.*;
/**
 * An amateur swimming club.
 * 
 * @author Mick Wood 
 * @version November 2004
 */
public class Centre
{
    private String name;
    private HashMap<String,Session> sessions;
    
    public Centre(String name)
    {
        this.name = name;
        this.sessions = new HashMap<>();
    }

    public void addSession(Session session){
        String code = session.getSessionCode();
        sessions.putIfAbsent(code, session);
    }

    public void cancelSession(Session sess){
        sessions.remove(sess.getSessionCode());
    }


    public void searchSessionsByDate(Date date){
        sessions.forEach((code, session)->{
            if (session.startDate.equals(date)){
                System.out.println(session.toString());
            }
        });
    }

    /*public void searchSessionsByDate(Date date){
        for(Session session: sessions.values()){
            if (session.startDate.equals(date)){
                System.out.println(session.toString());
            }
        }
    }*/

}
