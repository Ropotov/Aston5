package com.example.aston5;

import java.util.ArrayList;

public class Repository {

    public static final Repository INSTANCE = new Repository();

    public static Repository getInstance(){
        return INSTANCE;
    }

    public ArrayList<ListItem> getList() {
        return list;
    }

    public void setList(ArrayList<ListItem> list) {
        this.list = list;
    }

    public ArrayList<ListItem> list = new ArrayList<ListItem>() {{
        add(new ListItem(1, "Nikita", "Ropotov", "78889995552"));
        add(new ListItem(2, "Boris", "Britva", "76325695450"));
        add(new ListItem(3, "Grigory", "Malkov", "79632584455"));
    }};
}
