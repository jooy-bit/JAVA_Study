package collection.day11;

import java.util.ArrayList;
import java.util.List;
public class CustomerManageApp {
    private List<Customer> users = new ArrayList<>();
    public static void main(String[] args) {
        CustomerManageApp app = new CustomerManageApp();
        app.start();
        
    }//main

    private void start(){
        initialize();
        //메뉴선택 : 등록, 검색(이름/그룹),삭제,수정,전체출력
        System.out.println("CRM 프로그램이 작동됩니다.");
        while (true) {
            System.out.println("\t <메뉴를 선택하세요.>");
            System.out.println("\t 1. 고객 등록");
            System.out.println("\t 2. 고객 목록 출력");
            System.out.println("\t 3. 고객 검색");
            System.out.println("\t 4. 고객 삭제");
            System.out.println("\t 5. 고객 정보 수정");
            System.out.println("\t 6. CRM 프로그램 종료");
            System.out.print("선택할 메뉴를 입력하세요>>>_");

            switch (Integer.parseInt(System.console().readLine())) {
                case 1:
                    addCustomer();//
                    break;
                
                case 2:
                    PrintCustomer();//
                    break;

                case 3:
                    findCustomer();//
                    break;

                case 4:
                    removeCustomer();//
                    break;

                case 5:
                    modifyCustomer();
                    break;

                case 6:
                    System.out.println("프로그램을 종료합니다");
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("1~6 메뉴 중에 선택해주세요");
                    break;
            }//switch
        }//while
    }//start


    
    
    private void initialize() {
        users.add(new Customer("bill", "010-1234-4567", 1));
        users.add(new Customer("dello", "010-1234-2123", 2));
        users.add(new Customer("RTC", "010-1234-4567", 1));
        users.add(new Customer("nanayang", "010-1512-4567", 3));
        users.add(new Customer("cookie", "010-5521-4567", 1));
        users.add(new Customer("micheal", "010-8454-4567", 2));
        users.add(new Customer("selly", "010-1234-4567", 1));
    }

    private void findCustomer() {
        String findUser;
        List<Customer> list = null;
        System.out.println("검색 방법을 선택해주세요._ (1.이름 검색  2.등급 검색 )");
        switch (Integer.parseInt(System.console().readLine())) {
            case 1:
                System.out.print("검색할 회원 이름을 입력하세요._");
                findUser =System.console().readLine();
                list = findAllCustomer(findUser);
                break;
            case 2:
                System.out.print("검색할 회원 등급을 입력하세요._");
                int findGroup = Integer.parseInt(System.console().readLine());
                list = findAllCustomer(findGroup);
                break;
            default:
            System.out.println("1,2번 안에서 다시 선택해주세요.");
                break;
        
        }//swith
    }//findCustomer

    
    private void PrintCustomer() {
        System.out.println("회원 정보를 출력합니다");
        System.out.println(String.format("%20s %20s %20s", "NAME","PHONE","GROUP"));
        PrintCustomerlist(users);
    }

    //출력메소드
    private void  PrintCustomerlist(List<Customer>users){
        for (Customer user : users) {
            System.out.println(String.format("%20s %20s %20s", user.getName(),user.getPhone(),user.getGroup()));
        }
    }
    
    
    private void modifyCustomer() {
        String modiUser = System.console().readLine();
        String modiPhone; int modiGroup;
        for (int i =0; i<users.size(); i++) {
            if (users.get(i).getName().equals(modiUser)) {
                System.out.println("인덱스"+i+" 에서 회원을 찾았습니다");
                System.out.print("수정하려면 엔터, 취소는 n 을 눌러주세요.");
                if (System.console().readLine().equals("n")) 
                    continue;
                }else{
                    System.out.println("변경하실 정보를 입력하세요");
                    System.out.print("회원 번호를 입력하세요._");
                    modiPhone = System.console().readLine();
                    System.out.print("회원 등급을 입력하세요._");
                    modiGroup = Integer.parseInt(System.console().readLine());
                    users.get(i).modify(modiPhone,modiGroup);
                    return;
            }
            
            
        }
    
    
    }


    private void removeCustomer() {
        System.out.println("\t :: 회원을 삭제합니다 ::");
        System.out.print("삭제하실 회원을 입력하세요._");
        String removeUser =System.console().readLine();
        boolean isFind = false;
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getName().equals(removeUser)){ 
            isFind= true;
            System.out.println("인덱스"+i+" 에서 회원을 찾았습니다");
            System.out.print("삭제하려면 엔터, 취소는 n 을 눌러주세요.");
            if (System.console().readLine().equals("n")) continue;
            else users.remove(i);
             if (isFind=false)System.out.println("찾는 회원이 명단에 없습니다. 추가해주세요.");
            }
        }

    }


    private void addCustomer(){
        System.out.println("\\t :: 신규 등록합니다 ::");
        System.out.print("회원 이름을 입력하세요. _");
        String name =System.console().readLine();
        System.out.print("회원 번호을 입력하세요. _");
        String phone =System.console().readLine();
        System.out.print("회원 등급을 입력하세요. _");
        int group =Integer.parseInt(System.console().readLine());
        users.add(new Customer(name,phone,group));
    }

    private List<Customer> findAllCustomer(int group){
        List<Customer> list = new ArrayList<>();                //검색 결과 저장하는 리스트
        for(Customer user : users){
            if (user.getGroup()==group) {
                list.add(user);                                 //일치하는 단어를 만날 때마다 저장
            }
        }return list;
    }

    private List<Customer> findAllCustomer(String name){
        List<Customer> list = new ArrayList<>();                //검색 결과 저장하는 리스트
        for(Customer user : users){
            if (user.getName().equals(name)) {
                list.add(user);                                 //일치하는 단어를 만날 때마다 저장
            }
        }return list;
    }


}//class



