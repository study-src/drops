package com.hujh.study.enumstudy;

interface food{
    void eat();
}

interface sport{
    void run();
}

public enum EnumDemo2 implements food ,sport{
    FOOD,
    SPORT,
    ; //分号分隔

    @Override
    public void eat() {
        System.out.println("eat.....");
    }

    @Override
    public void run() {
        System.out.println("run.....");
    }


    public static void main(String[] args) {
        EnumDemo2.FOOD.run();
    }

}