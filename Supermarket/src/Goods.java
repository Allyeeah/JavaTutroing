public class Goods { //class는 무조건 대문자로
    public static int index = 0;
    int id;
    String pDate;
    private String name;
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
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
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
class FreshFood extends Goods{ //상속
    public String eDate;
    FreshFood(){
        super();
        this.eDate = "0000/00/00";
    }
    FreshFood(int id, String pDate, String name, int price, float discount, String eDate){
        super(id, name, pDate, price, discount); //부모 생성자 호출
        this.eDate = eDate;
    }

    public void inform() { // 매소드 오버라이딩
        System.out.println("상품번호: " + this.id + " | 상품명: " + this.getName() + "| 가격: " + price);
        System.out.println("생산일자: " + pDate + "| 유통기한: " + eDate + " | 할인율: " + discount);
        System.out.println("--------------------------------------------------------------");
    }
}