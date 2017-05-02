
package Homework.exam08;

public class Tire {
    public int maxRotation;
    public int accumulation;
    public String location;
    
    public Tire(String location, int maxRocation){
        this.maxRotation=maxRocation;
        this.location=location;
    }
    
    public roll(){
        if(accumulation<maxRotation){
            
            System.out.println(location+"굴러간다"+"("+accumulation")"+);
            System.out.println();
        }
    }
}
