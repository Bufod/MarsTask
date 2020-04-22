package com.company;

import java.util.*;

class Obj {
    private String name;
    private int weight, value;

    public Obj(String name, int weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Main {

    static final int MAX_WEIGHT = 11;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Начните заполнять список в формате: \n" +
                "\tназвание предмета, вес(тонны), ценность(камни)\n" +
                "\tвсе числа целые,\n" +
                "Для окончания ввода введите: расчет");
        ArrayList<Obj> list = new ArrayList<>();
        String line;
        while (!(line = in.nextLine()).equalsIgnoreCase("расчет")) {
            String[] param = line.split(", ");
            String name = param[0];
            int weight = Integer.parseInt(param[1]),
                    value = Integer.parseInt(param[2]);
            list.add(new Obj(name, weight, value));
        }

        int[][] table = new int[list.size() + 1][MAX_WEIGHT + 1];

        for (int j = 0; j < MAX_WEIGHT + 1; j++) {
            table[0][j] = 0;
        }

        Iterator<Obj> iterator = list.iterator();
        for (int i = 1; i < list.size() + 1; i++) {
            Obj curObj = iterator.next();
            for (int j = 0; j < MAX_WEIGHT + 1; j++) {
                int objWeight = curObj.getWeight(),
                        objValue = curObj.getValue();
                if (j >= objWeight)
                    table[i][j] = Math.max(
                            table[i - 1][j],
                            table[i - 1][j - objWeight] + objValue);
                else
                    table[i][j] = table[i - 1][j];
            }
        }

        System.out.println(table[list.size()][MAX_WEIGHT]);

        for (int i = list.size(), j = MAX_WEIGHT; i > 0; i--) {
            if (table[i][j] == table[i - 1][j])
                list.remove(i - 1);
        }


        System.out.println("В список положили: ");
        for (Obj curObj : list) {
            System.out.println(curObj.getName() + ", "
                    + curObj.getWeight() + ", "
                    + curObj.getValue());
        }


    }
}