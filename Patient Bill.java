public class PatientBill {
   private double totalAmount;
   private double amountPaid;

public PatientBill(){
this.totalAmount = 0.0;
this.amountPaid = 0.0;
}   
public PatientBill(double TotalAmount, double amountPaid){
this.totalAmount = totalAmount;
this.amountPaid = amountPaid;
}
   public void setTotalAmount(double totalAmount){
    this.totalAmount = totalAmount;
   }
   public double getTotalAmount(){
    return totalAmount;
   }
   public void setAmountPaid(double amountPaid){
    this.amountPaid = amountPaid;
   }
   public double getAmountPaid(){
    return amountPaid;
   }
   public double calculateRemainingAmount(){
    return totalAmount- amountPaid;
   }
