package org.example.Menu;

public class MenuItem {
    private String name;
    MenuCust menuCust;
    public MenuItem(String name, MenuCust menuCust) {
        this.name = name;
        this.menuCust = menuCust;
    }
    public String getName() {
        return this.name;
    }
    public void runMethod(){
        this.menuCust.execute();
    }
}
