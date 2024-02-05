package JDBCteamProject.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class MenuVo {
    private int menu_seq;
    private int place_seq;
    private String menu_name;
    private int price;

   
}
