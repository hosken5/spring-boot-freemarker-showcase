package pl.codeleak.demos;

 public   class  Product {
    public String getName() {
        return name;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  name  ;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float price ;
}