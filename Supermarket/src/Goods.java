public class Goods { //class는 무조건 대문자로
    int id;
    String pDate;
    String name;
    int price;
    float discount;
    //Goods i = new goods();
    Goods(){
        this(0, "0000/00/00", "비어있음", 0, 0);
    }

    Goods(int id, String name, int price){
        this.id = id;
        this.pDate = "0000/00/00";
        this.name = name;
        this.price = price;
        this.discount = 0;
    }
    Goods(int id, String pDate, String name, int price, float discount){
        this.id = id;
        this.pDate = pDate;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    void inform(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("상품번호: "+ this.id +" | 상품명: " + this.name + "| 가격: " + price);
        System.out.println("생산일자: "+ pDate + " | 할인율: " + discount);
        System.out.println("--------------------------------------------------------------");

    }

    int discountedPrice() {
        return (int) (price - price * (discount / 100));
    }
}
