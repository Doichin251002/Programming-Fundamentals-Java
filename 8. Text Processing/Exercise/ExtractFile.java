import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String link = scan.nextLine();
        String [] partsLink = link.split("\\\\");
        String fullFileName = partsLink[partsLink.length - 1];
        String fileName = fullFileName.split("\\.")[0];
        String extension = fullFileName.split("\\.")[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);
    }
}
