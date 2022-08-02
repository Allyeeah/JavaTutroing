import java.util.InputMismatchException;
import java.util.Scanner;

public class Supermarket {
    public static void inform(Goods goods){
        goods.inform();
    }
    public static void main(String[] args) {
        System.out.println("다예마켓 온 것을 환영합니다~~!"); //ln은 한칸 뛰어주는 것
        Scanner scanner = new Scanner(System.in);
       Goods[] goodsArr =new Goods[5];
        //int index = 0;
        boolean onoff = true;

        for(int n = 0; n<goodsArr.length;n++)
            goodsArr[n] = new Goods();

        while(onoff) {
            System.out.println("1. 상품등록 | 2. 상품조회 | 3. 계산 | 4. 사용종료");
            System.out.print("메뉴를 선택해주세요.>>");
            try {
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        System.out.print("상품명을 입력해주세요.>> ");
                        String name = scanner.next();
                        System.out.print("생산일자를 입력해주세요.>> ");
                        String pDate = scanner.next();
                        System.out.print("가격을 입력해주세요.>> ");
                        int price = scanner.nextInt();
                        if(pDate.equals("0")) {
                            goodsArr[Goods.index%5] = new Goods(Goods.index, name, price);
                        }
                        else{
                            System.out.print("할인율을 입력해주세요.>> ");
                            float discount = scanner.nextFloat();
                            System.out.print("유통기한을 입력해주세요.>> ");
                            String eDate = scanner.next();
                            if(eDate.equals("0")){
                                goodsArr[Goods.index % 5] = new Goods(Goods.index, pDate, name, price, discount);
                            }
                            else{ //업캐스팅
                                goodsArr[Goods.index % 5] = new FreshFood(Goods.index, name, pDate, price, discount, eDate);
                            }
                        }
                        Goods.index++;
//                        if(index>=5){  %아니면 이거를 써야함
//                            index = 0;
//                        }
                        break;
                    case 2:
                        System.out.println("--------------------------------------------------------------");
                        for (int n = 0; n < goodsArr.length; n++) {
                            //for (Goods goods : goodsArr)같음
                            inform(goodsArr[n]);
                        }
                        break;
                    case 3:
                        System.out.print("상품번호를 입력헤수세요.>>");
                        int i = scanner.nextInt();
                        System.out.println(goodsArr[i%5].getName() + "의 가격은 " + goodsArr[i%5].discountedPrice() + "원입니다.");

                    case 4:
                        System.out.println("이용해주셔서 감사합니다.");
                        onoff = false;
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("형식에 맞지 않습니다.");
                scanner.next();
            }
        }

        scanner.close();

        /*
        Test a = new Test();
        a.num = 10;
        Test b = new Test();
        b.num = 5;
        int c = 10;
        int d = 5;
        Calculator.add(c,d);
        Calculator.add2(a, b);

        System.out.println(a.num + ", " + b.num);
        System.out.println(c + ", " + d);

         */
    }
}
