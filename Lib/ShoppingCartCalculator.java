import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * เขียน Javadoc ที่นี่เพื่ออธิบายกฎการทำงานและกรณีพิเศษ:
     * - จะทำอย่างไรถ้า items เป็น null หรือ empty?
     * - จะทำอย่างไรถ้า CartItem มี price หรือ quantity ติดลบ?
     * - กฎส่วนลด BOGO (ซื้อ 1 แถม 1)
     * - กฎส่วนลด BULK (ซื้อ >= 6 ชิ้น ลด 10%)
     * ฟังชันก์สำหรับการคำนวณราคาสุทธิของสินค้าในตะกร้า
     * BOGO จะเป็นโปรโมชั่นซื้อ 1 แถม 1 หากซื้อสินค้าที่มีรหัส BOGO สองชิ้น ตะกร้าจะreturn ราคาสิ้นค้า 1 ชิ้น
     * BULK เป็นโปรโมชั่นซื้อตั้งแต่ 6 ชิ้นขึ้นไปจะได้รับส่วนลด 10% 
     * @param sku รหัสการซื้อ
     * @param name ชื่อสินค้า
     * @param price ราาต่อชิ้น
     * @param quantity จำนวนที่ซื้อ
     * @return ราคาสุทธิของสินค้าในตะกร้า
     
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        // TODO: เขียนโค้ด Implementation ที่นี่
        int i = 0;
        double total = 0 ;
        

        if(items != null && items.size() != 0) {
            for(i=0; i <= items.size()-1; i++){
                if(items.get(i).sku() == "BOGO"){
                   double price = items.get(i).price();
                   int n = items.get(i).quantity();
                   total = total + (price *(n-(n/2)));  
                }else if(items.get(i).sku() == "BULK"){
                   if(items.get(i).quantity() >5){
                    double price = items.get(i).price();
                    int n = items.get(i).quantity();
                    total += (price * n)*0.9;
                   }else{
                    double price = items.get(i).price();
                    int n = items.get(i).quantity();
                    total += (price * n);

                   }
                }else{
                double price = items.get(i).price();
                int n = items.get(i).quantity();
                total += (price * n);
                }
               
            }
            return total;

        }
        
        return 0.0;
    }
}