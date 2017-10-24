public class MarksArray {
    private int[] marks;

    public MarksArray(int[] marks) {
        this.marks = marks;
    }

    public void put(int index, int value){
        if(this.marks.length > index){
            this.marks[index] = value;
        }
    }

    public int get(int index){
        if(this.marks.length > index){
            return this.marks[index];
        }
        else{
            return -1;
        }
    }

    public int sizeOf(){
        return this.marks.length;
    }

    public void listMarks(){
        for(int i = 0; i < this.marks.length; i++){
            System.out.println(this.marks[i]);
        }
    }

    public void assessMarks(){
        int n = 0;
        while(n < this.marks.length){
            if(this.marks[n] < 45){
                System.out.println(this.marks[n] + ": " + "FAIL");
            }
            else if(this.marks[n] >= 45 && this.marks[n] < 75){
                System.out.println(this.marks[n] + ": " + "PASS");
            }
            else if(this.marks[n] >= 75){
                System.out.println(this.marks[n] + ": " + "DISTINCTION");
            }
            n++;
        }
    }

    public double meanMark(){
        int sum = 0;
        int num = this.marks.length;
        for(int i=0; i < this.marks.length; i++){
            sum = sum+this.marks[i];
        }
        return (double) sum/num;
    }

    public void aboveAverage(){
        double mean = this.meanMark();
        for(int i=0; i < this.marks.length; i++){
            if(this.marks[i] > mean) {
                System.out.println(this.marks[i]);
            }
        }
    }

    public int numberOfPasses(){
        int count = 0;
        for(int i=0; i < this.marks.length; i++){
            if(this.marks[i] >= 45){
                count++;
            }
        }
        return count;
    }

    public int highestMark(){
        return this.highest()[0];
    }

    public int lowestMark(){
        return this.lowest()[0];
    }

    public int getRange(){
        return this.highestMark()-this.lowestMark();
    }

    public int bestStudent(){
        return this.highest()[1];
    }
    private int[] lowest(){
        int n = this.marks.length-1;
        int lowestSoFar = -1;
        for (int i : this.marks){
            if (i < lowestSoFar || lowestSoFar == -1){
                lowestSoFar = i;
            }
        }
        return new int[] {lowestSoFar, n};
    }

    private int[] highest(){
        int n = 0;
        int highestSoFar = -1;
        while(n < this.marks.length){
            if(this.marks[n] > highestSoFar){
                highestSoFar = this.marks[n];
            }
            n++;
        }
        n--;
        return new int[] {highestSoFar,n};
    }

}
