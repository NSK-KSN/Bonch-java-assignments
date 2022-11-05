package lab2;

public class Desktop extends Computer{
    private int yearsWarranty = 2;
    
    public void power_on_action(){
        if(!turn){
            System.out.println("Power-On");
            this.turn = true;
        }else{
            System.out.println("Power-Off");
            this.turn = false;
        }
    }

    public void set(int yearsWarranty, String m){
        this.yearsWarranty=yearsWarranty;
    }

    public void get_unique(){
        System.out.println("Years of warranty: "+yearsWarranty);
    }
    public Desktop() {
        System.out.println("Desktop constructor is done!");
    }

}
