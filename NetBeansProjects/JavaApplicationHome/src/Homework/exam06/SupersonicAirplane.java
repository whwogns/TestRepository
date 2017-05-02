
package Homework.exam06;

public class SupersonicAirplane extends Airplane{
    public static final int NORMAL=1;
    public static final int SUPERSONIC=2;
    
    public int flymode = NORMAL;

    @Override
    public void fly() {
        if(flymode == NORMAL){
            super.fly();
        }else{
        System.out.println("초음속비행합니다.");
        }
    }
    
    
}
