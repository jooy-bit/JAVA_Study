package JDBCteamProject.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class PlaceVo {
    private int place_seq;
    private String name;
    private String phone;
    private int rate;
    private String open_time;
    private String close_time;
    private String food_type;

    @Override
    public String toString() {
      return String.format("%8d %-15s %40s \t %,6d %4d %30s",
                  buy_idx,pcode,pname,price,quantity,buy_date);
    }
}
