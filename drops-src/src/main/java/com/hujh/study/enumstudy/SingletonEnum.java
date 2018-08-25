package com.hujh.study.enumstudy;

public enum  SingletonEnum {
    instance()
    // INSTANCE
    ;
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }



    public static void main(String[] args) {
        SingletonEnum.instance.setName("ads");
        System.out.println(SingletonEnum.instance.name);
    }

}