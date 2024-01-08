public class PatientBill extends HostFatal{
    private double amount;

    public void setAmount(double amount){
        this.amount = amount;
    }
public double getAmount(){
        return amount;
    }

   public static void main(String[] args){
        PatientBill pb = new PatientBill();
        
        pb.setAmount(3000.00);
        System.out.println("Patient's Bill Amount: Php." + pb.getAmount());
    }
}     
        
