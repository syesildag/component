package component;

public class CompoundProductItemData extends Data {
    private String code;
    private Integer quantity;

    public CompoundProductItemData(String code, Integer quantity) {
        this.code = code;
        this.quantity = quantity;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}