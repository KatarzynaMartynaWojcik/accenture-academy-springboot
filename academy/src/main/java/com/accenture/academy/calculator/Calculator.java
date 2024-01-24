package com.accenture.academy.calculator;

public class Calculator {

    public Integer add(int x, int y){
        if((x<0||x>100) || (y<0||y>100)){
            throw new IllegalArgumentException("Number must be between 0 and 100");
        }
        return x+y;
    }

    public Integer substract(int x, int y){
        if((x<0||x>100) || (y<0||y>100)){
            throw new IllegalArgumentException("Number must be between 0 and 100");
        }
        return x-y;
    }

    public Integer multiply(int x, int y){
        if((x==0 || y==0) || (x<0||x>30) || (y<0||y>30)){
            throw new IllegalArgumentException("Number must be between 1 and 30");
        }
        return x*y;
    }

    public Integer divide(int x, int y){

        if((x==0 || y==0) || (x<0||x>100) || (y<0||y>100)){
            throw new IllegalArgumentException("Number must be between 1 and 100");
        }
        return x/y;
    }
}
