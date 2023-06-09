package singlefiles;

public class ItemInBox {
    public static void main(String[] args) {
        Box firstBox = new Box(new Book(100, 1999, "Lorem ipsum", "Dolor sit", "Tempor incididunt")),
                secondBox = new Box(new Journal(5, "Adipiscing elit", "Magna aliqua", "Quis nostrud"));
        System.out.printf("1. %s,\n 2. %s", firstBox, secondBox);
    }
}

class Box {
    /**
     * 2. content - variable of type ItemInteface
     */
    private ItemInteface content;

    public Box() {
    }

    public Box(ItemInteface content) {
        setContent(content);
    }

    public ItemInteface getContent() {
        return content;
    }

    public void setContent(ItemInteface content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Box [content=" + content.toString() + "]";
    }

    /*
     * 3 https://github.com/dorinesinenco/EDUQATION/blob/
     * 1ea7bcd0ec16691197d75d37239ffd6f0305e392/programming/java/oop/encapsulation/
     * blox.DYN.ru.md?plain=1#LL36C1-L36C1
     * No, it can't directly access it, because anotherBook.title is private.
     */
}

/*
 * 1. All classes that implement ItemInteface must provide implementation of
 * these methods,
 * any variable of this type has these methods that must be specific.
 */
interface ItemInteface {
    public void setName(String name);

    public String getName();


}

class Book implements ItemInteface {
    private int pages, publishingYear;
    private String name, title, authorName;

    public Book() {
    }

    public Book(int pages, int publishingYear, String name, String title, String authorName) {
        setPages(pages);
        setPublishingYear(publishingYear);
        setTitle(title);
        setAuthorName(authorName);
        setName(authorName);
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book [pages=" + pages + ", publishingYear=" + publishingYear + ", name=" + name + ", title=" + title
                + ", authorName=" + authorName + "]";
    }

}

class Journal implements ItemInteface {
    private int pages;
    private String name, title, category;

    public Journal() {
    }

    public Journal(int pages, String name, String title, String category) {
        setPages(pages);
        setTitle(title);
        setCategory(category);
        setName(name);
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Journal [pages=" + pages + ", name=" + name + ", title=" + title + ", category=" + category + "]";
    }

}
