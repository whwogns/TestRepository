package Homework.exam02;

public class Car {

    int gas;

    void setGas(int gas) {
        this.gas = gas;
    }

    boolean isLeftGas() {
        if (gas == 0) {
            System.out.println("gas 없음");
            return false;
        } else {
            System.out.println("gas 있음");
            return true;
        }
    }
        void run() {
        while (true) {
            if(gas > 0){
                gas -= 1;
                System.out.println("달린다 / gas 잔량: " + gas);
            }else{
                System.out.println("주행을 멈춤/ gas 잔량"+gas);
                return;
                }
        }
    }
    }


