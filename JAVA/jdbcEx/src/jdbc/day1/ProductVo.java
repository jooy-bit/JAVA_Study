package jdbc.day1;

public class ProductVo {
    private String pcode;
    private String category;
    private String pname;
    private int price;
    public ProductVo(String pcode, String category, String pname, int price) {
        this.pcode = pcode;
        this.category = category;
        this.pname = pname;
        this.price = price;
    }
    public String getPcode() {
        return pcode;
    }
    public String getCategory() {
        return category;
    }
    public String getPname() {
        return pname;
    }
    public int getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return "ProductVo [pcode=" + pcode + ", category=" + category + ", pname=" + pname + ", price=" + price + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pcode == null) ? 0 : pcode.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((pname == null) ? 0 : pname.hashCode());
        result = prime * result + price;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductVo other = (ProductVo) obj;
        if (pcode == null) {
            if (other.pcode != null)
                return false;
        } else if (!pcode.equals(other.pcode))
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (pname == null) {
            if (other.pname != null)
                return false;
        } else if (!pname.equals(other.pname))
            return false;
        if (price != other.price)
            return false;
        return true;
    }

    
}
