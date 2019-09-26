package com.example.myapplication58;

public class Calculator {
    String num1,num2,num3;
    public Calculator()
    {
num1="1";
num2="2";
num3="3";

    }


    public Calculator(String n1,String n2,String n3) {
        num1=n1;
        num2=n2;
        num3=n3;

    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }
    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }
    public String getNum3() {
        return num3;
    }

    public void setNum3(String num3) {
        this.num3 = num3;
    }

}
