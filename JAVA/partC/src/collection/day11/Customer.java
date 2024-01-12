package collection.day11;
//고객정보 관리
public class Customer {
    private String name;
    private String phone;
    private int group; //1.일반 2.vip 3.기타

    //커스텀 생성자
    public Customer(String name,String phone,int group){
        this.name = name;
        this.group = group;
        this.phone = phone;
    }
    //getter
    public int getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }



    //setter xx 
    //
    public void modify(String phone,int group){
        this.phone = phone;
        this.group = group;
    }

    @Override
    public String toString() {
        // 테스트용
        
        return this.name+", "+this.phone+", "+this.group;
    }
}
