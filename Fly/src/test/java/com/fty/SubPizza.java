package com.fty;

import java.util.Objects;

public class SubPizza extends  Pizza {
    public  enum  Size{
        SMALL,MEDIUM,LARGE
    }
    private final Size size;
    SubPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
    public  static class  Builder extends Pizza.Builder<Builder>{
        private  final  Size size;
        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }
        @Override
        Pizza build() {
           return  new SubPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
    @Override
    public  void print(){
        System.out.println(toppings);
        System.out.println(size);
    }
}
