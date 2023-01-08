package Model;

import java.util.Objects;

public class Good {
    private String ch;

    public String getCh() {
        return ch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return price == good.price && Objects.equals(ch, good.ch) && Objects.equals(name, good.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ch, name, price);
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    private String name;
    private int price;

    @Override
    public String toString() {
        return ch + "-" + name + "\n";
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
}
