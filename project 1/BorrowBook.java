package com.library;

public class BorrowBook {
    private String lib_id;
    private String name;

    public BorrowBook(String id,String name){
        this.lib_id = id;
        this.name = name;
    }
    public String getId() {
        return lib_id;
    }
    public void setId(String id) {
        this.lib_id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Name: "+name + " Library member ID Number: "+ lib_id;
    }
}
