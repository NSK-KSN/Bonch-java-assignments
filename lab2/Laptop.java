package lab2;

public class Laptop extends Computer {
    private String operatingSystem = "Windows 10";

    public void power_on_action(){
        if(!turn){
            System.out.println("Power-On");
            this.turn = true;
        }else{
            System.out.println("Power-Off");
            this.turn = false;
        }
    }

    public void set(int n, String operatingSystem){
        this.operatingSystem=operatingSystem;
    }

    public void get_unique(){
        System.out.println("Operating system: "+operatingSystem);
    }
    public Laptop() {
        System.out.println("Laptop constructor is done!");
        this.price = 15000;
    }

}
