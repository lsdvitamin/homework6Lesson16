package ru.otus.homework6.lesson16;

/**
 * @author Sergei on 17.11.2024 19:23.
 * @project homework6Lesson16
 */
public class Item {
    Integer id;
    String title;
    Integer price;

    public Item(Integer id, String title, Integer price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Item() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
