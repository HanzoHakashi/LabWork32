package Util;

import Model.Good;
import Model.Machine;

import java.util.*;
import java.util.stream.Collectors;

public class Simulation {
    public void run(){
        Machine m = new Machine();
        List<Good> machine = m.createMachine();
        int coin = 0;
        mainSimulation(machine,coin);
    }

    public void printGoods(List<Good>goods){
        System.out.println("В автомате доступны:");
        for (int i = 0; i < goods.size(); i++) {
            String s = "w";
            if (i==1){
                s="ps";
            } else if (i==2) {
                s="c";
            } else if (i==3) {
                s="l";
            }else if (i==4) {
                s="s";}
            else if (i==5) {
                s="p";}
            System.out.printf("%s (%s)%n",goods.get(i).getName(),goods.get(i).getPrice());
        }
    }
    private static String action(String message) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println(message);
            try {
                return input.nextLine().toLowerCase(Locale.ROOT);
            }
            catch (java.util.InputMismatchException e) {
                input.nextLine();
            }
        }
    }

    public void mainSimulation(List<Good>machine,int coins){
        printGoods(machine);
        System.out.printf("Количество монет %s.%n",coins);
        String choice ="";
        if(coins<20){
            choice = action("a-добавить монет\n"+
                    "q-выйти");
        }else {
            var goods = machine.stream()
                    .filter(e->e.getPrice()<=coins)
                    .collect(Collectors.toList());
            choice = action("a-добавить монет\n"+
                    goods.toString()+
                    "q-выйти");
        }

        switch (choice){
            case "a":
                int pushCoin=coins+20;
                mainSimulation(machine,pushCoin);
                break;
            case "w":
                int price=coins;
                int test = 0;
                if (coins>=20){
                    for (int i = 0; i < machine.size(); i++) {
                        if(machine.get(i).getCh().equals("w")){
                            System.out.printf("Вы купили %s%n",machine.get(i).getName());
                            test=1;
                            price=coins-machine.get(i).getPrice();
                            machine.remove(i);
                        }
                    }
                    if (test==0){
                        System.out.println("Данное действие недоступно");
                    }
                }else {
                    System.out.println("Данное действие недоступно");
                }

                mainSimulation(machine,price);
                break;
            case "ps":
                int price1=coins;
                int test1 = 0;
                if (coins>=20){
                    for (int i = 0; i < machine.size(); i++) {
                        if(machine.get(i).getCh().equals("ps")){
                            System.out.printf("Вы купили %s%n",machine.get(i).getName());
                            test1=1;
                            price1=coins-machine.get(i).getPrice();
                            machine.remove(i);
                        }
                    }
                    if (test1==0){
                        System.out.println("Данное действие недоступно");
                    }
                }else {
                    System.out.println("Данное действие недоступно");
                }
                mainSimulation(machine,price1);
                break;

        }
    }
}
