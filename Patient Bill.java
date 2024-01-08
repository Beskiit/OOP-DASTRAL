public class PatientBill {
   private double totalAmount;
   private double amountPaid;
   
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
       return totalAmount - amountPaid;
   } 
}
