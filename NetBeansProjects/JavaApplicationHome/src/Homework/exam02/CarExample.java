
package Homework.exam02;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.setGas(5);
        
        
        boolean gasState =myCar.isLeftGas();
        if(gasState){
            myCar.run();
        }
        if(myCar.isLeftGas()){
            System.out.println("주입필요없다");
        }else{
            System.out.println("주입요망");
        }
        
    }
}
