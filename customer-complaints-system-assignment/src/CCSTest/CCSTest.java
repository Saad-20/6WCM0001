package CCSTest;
import CustomerComplaintsSystemAssignment.*;
import java.util.ArrayList;
import java.util.List;

public class CCSTest {

    public static void main(String[] args){
        CCSImplementation ccs = new CCSImplementation();
        List list = java.util.Collections.synchronizedList(new ArrayList());
        Class c = list.getClass();
        try{
            if ( c == Class.forName("java.util.Collections.SynchronizedRandomAccessList.class") || c == Class.forName("java.util.Collections.SynchronizedList")){
                synchronized(list){
                    //do stuff
                }
            }else{
                //do stuff
            }
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getLocalizedMessage());
        }

    }
}

