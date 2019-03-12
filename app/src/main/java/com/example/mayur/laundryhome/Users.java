package com.example.mayur.laundryhome;

public class Users {
    public int id;
    public String u_name;
    public String u_mno;
    public String u_add;


    public Users(String u_name,String u_mno,String u_add)
    {
        this.u_name = u_name;
        this.u_mno = u_mno;
        this.u_add = u_add;
    }

    public Users(int id,String u_name, String u_mno,String u_add)
    {
        this.id = id;
        this.u_name = u_name;
        this.u_mno = u_mno;
        this.u_add = u_add;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_mno() {
        return u_mno;
    }

    public void setU_mno(String u_mno) {
        this.u_mno = u_mno;
    }

    public String getU_add() {
        return u_add;
    }

    public void setU_add(String u_add) {
        this.u_add = u_add;
    }
}
