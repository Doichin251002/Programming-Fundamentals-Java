import java.util.Scanner;

public class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }
    public String getContent() {
        return this.content;
    }
    public String getAuthor() {
        return this.author;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        return this.title + " - " + this.content + ": " + this.author;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] articleParts = scan.nextLine().split(", ");

        String title = articleParts[0];
        String content = articleParts[1];
        String author = articleParts[2];

        Article article = new Article(title, content, author);

        int commandCount = Integer.parseInt(scan.nextLine());
        for (int count = 1; count <= commandCount; count++) {
            String [] currentCommand = scan.nextLine().split(": ");
            String operation = currentCommand[0];
            String newValue = currentCommand[1];

            switch (operation) {
                case "Edit":
                    article.setContent(newValue);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(newValue);
                    break;
                case "Rename":
                    article.setTitle(newValue);
                    break;
            }
        }
        System.out.println(article);
    }
}