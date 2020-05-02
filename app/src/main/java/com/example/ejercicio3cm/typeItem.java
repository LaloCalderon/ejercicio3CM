package com.example.ejercicio3cm;
public class typeItem {
    private String mtype;
    private int mtypeimage;
    public typeItem(String typeName, int typeimage) {
        mtype = typeName;
        mtypeimage = typeimage;
    }
    public String getTypeName(){
        return mtype;
    }
    public int gettypeimage(){
        return mtypeimage;
    }

}
