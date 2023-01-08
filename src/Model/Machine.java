package Model;

import javax.crypto.Mac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {
    private List<String> names;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> createGoodsName(){
        List<String> names = new ArrayList<>();
        names.add("Water");
        names.add("Pepsi");
        names.add("Cola");
        names.add("Lays");
        names.add("Skittles");
        names.add("Pir");
        return names;
    }

    public List<Good> createMachine(){
        List<Good> goods = new ArrayList<>();
        List<String>names = createGoodsName();
        for (int i = 0; i < names.size(); i++) {
            int price = 20;
            Good good = new Good();
            String s = "w";
            if (i==3){
                price = 70;
                s="l";
            } else if (i==4) {
                price= 30;
                s="s";
            } else if (i==5) {
                price = 60;
                s="p";
            } else if (i==1) {
                s="ps";
            } else if (i==2) {
                s="c";
            }
            good.setName(names.get(i));
            good.setPrice(price);
            good.setCh(s);
            goods.add(good);
        }
        return goods;
    }
}
