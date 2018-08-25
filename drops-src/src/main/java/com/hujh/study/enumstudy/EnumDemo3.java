package com.hujh.study.enumstudy;

public enum EnumDemo3 {

    FIRST{
        @Override
        public String getInfo() {
            return "FIRST TIME";
        }
    },
    SECOND{
        @Override
        public String getInfo() {
            return "SECOND TIME";
        }
    }

    ;

    /**
     * 定义抽象方法
     * @return
     */
    public abstract String getInfo();

    //测试
    public static void main(String[] args){
        System.out.println("F:"+EnumDemo3.FIRST.getInfo());
        System.out.println("S:"+EnumDemo3.SECOND.getInfo());
        System.out.println("class:" + EnumDemo3.class.getName());
        /**
         输出结果:
         F:FIRST TIME
         S:SECOND TIME
         */
    }
}