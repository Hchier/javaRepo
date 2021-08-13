package IOCdemo.demo1.classes;

public class Book {
    String name;
    String author;

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void getName() {
        System.out.println("name:" + this.name);
    }

    public void getAuthor() {
        System.out.println("author:" + this.author);
    }
}

