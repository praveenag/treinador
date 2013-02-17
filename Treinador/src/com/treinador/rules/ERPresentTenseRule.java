package com.treinador.rules;

public class ERPresentTenseRule implements IRule{

    @Override
    public String eu(String verbInfinitive) {
        return verbInfinitive.substring(0, verbInfinitive.length() - 2).concat("o");
    }

    @Override
    public String tu(String verbInfinitive) {
        return verbInfinitive.substring(0, verbInfinitive.length() - 2).concat("es");
    }

    @Override
    public String ele(String verbInfinitive) {
        return verbInfinitive.substring(0, verbInfinitive.length() - 2).concat("e");
    }

    @Override
    public String ela(String verbInfinitive) {
        return verbInfinitive.substring(0, verbInfinitive.length() - 2).concat("e");

    }

    @Override
    public String voce(String verbInfinitive) {
        return verbInfinitive.substring(0, verbInfinitive.length() - 2).concat("e");
    }

    @Override
    public String nos(String verbInfinitive) {
        return verbInfinitive.substring(0, verbInfinitive.length() - 2).concat("emos");
    }

    @Override
    public String vos(String verbInfinitive) {
        return verbInfinitive.substring(0, verbInfinitive.length() - 2).concat("eis");
    }

    @Override
    public String eles(String verbInfinitive) {
        return verbInfinitive.substring(0, verbInfinitive.length() - 2).concat("em");
    }

    @Override
    public String elas(String verbInfinitive) {
        return verbInfinitive.substring(0, verbInfinitive.length() - 2).concat("em");
    }

    @Override
    public String voces(String verbInfinitive) {
        return verbInfinitive.substring(0, verbInfinitive.length() - 2).concat("em");
    }
}
