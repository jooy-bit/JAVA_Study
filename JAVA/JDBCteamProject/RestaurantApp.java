package JDBCteamProject;

public class RestaurantApp {
    private RestaurantMain main = new RestaurantMain();

    public static void main(String[] args) {
        RestaurantApp app = new RestaurantApp();
        app.start();
    }// main

    public void start() {
        boolean run = true;
        while (run) { // 메뉴 선택 반복
            main.joinAdressBook();
            System.out.print("선택 >>> ");
            // int select = Integer.parseInt(System.console().readLine());
            String select = System.console().readLine();
            switch (select) {
                case "A", "a":
                    System.out.println("[A] 이름으로 맛집 찾기");
                    main.findName();
                    break;

                case "B", "b":
                    System.out.println("[B]지역 별로 맛집 찾기");
                    main.findArea();
                    break;

                case "C", "c":
                    System.out.println("[C]평점 순위 보기");
                    main.showRate();
                    break;

                case "D", "d":
                    System.out.println("[D] 랜덤 맛집 뽑기");
                    main.randomFind();
                    break;

                case "E", "e":
                    System.out.println("[E] 맛집 추가");
                    main.addRasturant();
                    break;

                case "F", "f":
                    System.out.println("[F]맛집 수정");
                    main.modifyResturant();
                    break;

                case "G", "g":
                    System.out.println("[G]삭제");
                    main.removeAdressBook();
                    break;

                case "H", "h":
                    System.out.println("[H]종료");
                    System.out.println("프로그램을 종료합니다");
                    run = false;
                    break;

                default:
                    System.out.println("잘못된 번호 입력입니다. 다시확인하시고 입력해주세요.");
                    break;
            }// switch
        } // while
    }// start

    // private void showRestaurant(String address);//주인찾아요~~ 주석어디갔나요?
    // System.out.println("지역을 입력해주세요. [1. 서울 2. 인천 3. 경기 4. 대구 5. 광주 6. 제주 ]");
    // System.out.print("지역 입력__");
    // String customerid = System.console().readLine();

}
