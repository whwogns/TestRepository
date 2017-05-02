
package Homework.exam06;

public class AirplaneExample {
    public static void main(String[] args) {
        SupersonicAirplane sa = new SupersonicAirplane();
        sa.takeOff();
        sa.fly();
        sa.flymode=SupersonicAirplane.SUPERSONIC;
        sa.fly();
        sa.flymode=SupersonicAirplane.NORMAL;
        sa.fly();
        sa.land();
    }
}
