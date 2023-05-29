package ss17_iobinary_file_and_serialization.bai_tap.bai_tap_1_quan_ly_san_pham.model;

public class Product {
    private String id;
    private String name;
    private int price;
    private String company;
    private String description;

    public Product() {
    }

    public Product(String id, String name, int price, String company, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.company = company;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", company='" + company + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
