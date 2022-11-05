package lab2;

public abstract class Computer {
    protected boolean turn = false;
    protected int price = 30000;

    protected Computer() {
        System.out.println("Computer constructor is done");
    }
    protected void On(){
        System.out.println("Turned On");
        this.turn = true;
    }
    protected void Off(){
        System.out.println("Turned Off");
        this.turn = false;
    }
    protected void get_price(){
        System.out.println("Price: "+ price);
    }

    protected void get_OnOff(){
        if(turn){
            System.out.println("State: Is On");
        }else{
            System.out.println("State: Is Off");
        }
    }

    protected abstract void power_on_action();

    protected abstract void set(int n, String m);

    public abstract void get_unique();
}
