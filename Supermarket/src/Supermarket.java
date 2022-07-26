import java.util.InputMismatchException;
import java.util.Scanner;

public class Supermarket {
    public static void main(String[] args) {
        System.out.println("다예마켓 온 것을 환영합니다~~!"); //ln은 한칸 뛰어주는 것
        Scanner scanner = new Scanner(System.in);
        String[] goods = new String[5];
        int price[] = new int[5];
        int index = 0;
        boolean onoff = true;

        while(onoff) {
            System.out.println("1. 상품등록 | 2. 상품조회 | 3. 계산 | 4. 사용종료");
            System.out.print("메뉴를 선택해주세요.>>");
            try {
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        System.out.print("상품명을 입력해주세요.>> ");
                        goods[index%5] = scanner.next();
                        System.out.print("가격을 입력해주세요.>> ");
                        price[index%5] = scanner.nextInt();
                        index++;
//                        if(index>=5){
//                            index = 0;
//                        }
                        break;
                    case 2:
                        for (int n = 0; n < goods.length; n++) {
                            System.out.println("상품번호: "+ n +" | 상품명: " + goods[n] + "| 가격: " + price[n]);
                        }
                        break;
                    case 3:
                        System.out.print("상품번호를 입력헤수세요.>>");
                        int i = scanner.nextInt();
                        System.out.print(goods[i] + "할인율을 입력해주세요.>> ");
                        float discount = scanner.nextFloat();
                        int p = (int) (price[i] - price[i] * (discount / 100));
                        System.out.println(goods[i] + "의 가격은 " + p + "원입니다.");
                        break;
                    case 4:
                        System.out.println("이용해주셔서 감사합니다.");
                        onoff = false;
                }
            }
            catch(InputMismatchException e){
                System.out.println("형식에 맞지 않습니다.");
                scanner.next();
            }
        }

        scanner.close();
    }
}
