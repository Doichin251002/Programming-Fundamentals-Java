import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    static class Message {
        private String phrase;
        private String event;
        private String author;
        private String city;

        public Message(String phrase, String event, String author, String city) {
            this.phrase = phrase;
            this.event = event;
            this.author = author;
            this.city = city;
        }

        public String getPhrase() {
            return this.phrase;
        }

        public String getEvent() {
            return this.event;
        }

        public String getAuthor() {
            return this.author;
        }

        public String getCity() {
            return this.city;
        }

        public void setPhrase(String phrase) {
            this.phrase = phrase;
        }

        public void setEvent(String event) {
            this.event = event;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countMessage = Integer.parseInt(scan.nextLine());

        Random randomText = new Random();
        List<Message> listMessages = new ArrayList<>();
        for (int i = 1; i <= countMessage; i++) {
            String phrase = selectPhrase(randomText);
            String event = getEvent(randomText);
            String author = getAuthor(randomText);
            String city = getCity(randomText);

            Message message = new Message(phrase, event, author, city);

            message.setPhrase(phrase);
            message.setEvent(event);
            message.setAuthor(author);
            message.setCity(city);

            listMessages.add(message);
        }

        for (Message element : listMessages) {
            System.out.printf("%s %s %s - %s%n", element.getPhrase(), element.getEvent(), element.getAuthor(), element.getCity());
        }
    }

    public static String selectPhrase(Random randomText) {
        String[] phrases = new String[]{"Excellent product.", "Such a great product.", "I always use that product."
                , "Best product of its category.", "Exceptional product.", "I can't live without this product."};

        int randomIndex = randomText.nextInt(phrases.length);
        return phrases[randomIndex];
    }

    public static String getEvent(Random randomText) {
        String[] events = new String[]{"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!"
                , "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};

        int randomIndex = randomText.nextInt(events.length);
        return events[randomIndex];
    }

    public static String getAuthor(Random randomText) {
        String[] authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

        int randomIndex = randomText.nextInt(authors.length);
        return authors[randomIndex];
    }

    public static String getCity(Random randomText) {
        String[] cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        int randomIndex = randomText.nextInt(cities.length);
        return cities[randomIndex];
    }
}
