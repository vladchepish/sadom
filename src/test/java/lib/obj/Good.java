package lib.obj;

import org.openqa.selenium.WebElement;

public class Good {

    private WebElement webElement;
    private String name;
    private String price;
    private String status;
    private String seller;
    private String city;

    public Good(String name, String price, String status, String seller, String city){
        this.name = name;
        this.price = price;
        this.status = status;
        this.seller = seller;
        this.city = city;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getSeller() {
        return seller;
    }

    public String getCity() {
        return city;
    }
}
