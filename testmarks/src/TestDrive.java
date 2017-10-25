public class TestDrive {
    public static void main (String[] args){
        System.out.println("Creating 2 new MarksArray objects (csm1 and csm2)");
        MarksArray csm1 = new MarksArray(new int[] {12, 45,34,78, 55, 63});
        MarksArray csm2 = new MarksArray(new int[] {15, 20, 45, 72, 63, 81, 100, 12, 17, 50});
        System.out.println("Listing the marks in both objects");
        csm1.listMarks();
        System.out.println("---------");
        csm2.listMarks();
        nextLine();
        System.out.println("Modifying some marks in csm1");
        csm1.put(10, 20);
        csm1.put(2,40);
        csm1.put(6,200);
        System.out.println(csm1.get(0));
        System.out.println(csm1.get(2));
        System.out.println(csm1.get(10));
        System.out.println(csm1.get(6));
        System.out.println("---------");
        System.out.println(csm1.sizeOf());
        System.out.println(csm2.sizeOf());
        System.out.println("---------");
        csm1.listMarks();
        System.out.println("---------");
        csm1.assessMarks();
        System.out.println("---------");
        csm2.assessMarks();
        System.out.println("---------");
        System.out.println(csm1.meanMark());
        System.out.println(csm2.meanMark());
        System.out.println("---------");
        csm1.aboveAverage();
        System.out.println("---------");
        csm2.aboveAverage();
        System.out.println("---------");
        System.out.println(csm1.numberOfPasses());
        System.out.println(csm2.numberOfPasses());
        System.out.println("---------");
        System.out.println(csm1.highestMark());
        System.out.println(csm2.highestMark());
        System.out.println("---------");
        System.out.println(csm1.getRange());
        System.out.println(csm2.getRange());
        System.out.println("---------");
        System.out.println(csm1.bestStudent());
        System.out.println(csm2.bestStudent());
    }
    private static void nextLine(){
        System.out.println("Press Enter to continue...");
        try {
            System.in.read();
        } catch (Exception e){}
    }
}
