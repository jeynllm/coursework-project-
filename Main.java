import java.io.*;
import java.util.*;

public class Main {
    static final String FILE_NAME = "feedback.csv";
    static Scanner scanner = new Scanner(System.in);
    static int nextId = 1; // ID starts from 1 and increments

    public static void main(String[] args) {
        List<Feedback> feedbackList = loadFeedback();
        updateNextId(feedbackList);

        while (true) {
            System.out.println("\n=== Alchemy of Souls Feedback System ===");
            System.out.println("1. Submit Feedback");
            System.out.println("2. View All Feedback");
            System.out.println("3. Update Feedback");
            System.out.println("4. Delete Feedback");
            System.out.println("5. Generate Report");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": submitFeedback(feedbackList); break;
                case "2": viewFeedback(feedbackList); break;
                case "3": updateFeedback(feedbackList); break;
                case "4": deleteFeedback(feedbackList); break;
                case "5": generateReport(feedbackList); break;
                case "6":
                    saveFeedback(feedbackList);
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void submitFeedback(List<Feedback> list) {
        String name = promptNonEmpty("Enter your name: ");
        String email = promptValidEmail("Enter your email: ");
        String comment = promptNonEmpty("Write your comment: ");
        String rating = promptValidRating("Rate the drama (1 to 5): ");

        String id = String.valueOf(nextId++);
        Feedback fb = new Feedback(id, name, email, comment, rating);
        list.add(fb);
        saveFeedback(list);
        System.out.println("✅ Feedback submitted successfully!");
    }

    static void viewFeedback(List<Feedback> list) {
        if (list.isEmpty()) {
            System.out.println("⚠ No feedback found.");
            return;
        }
        for (Feedback fb : list) {
            System.out.println("\n-----------------------------");
            System.out.println(fb);
        }
    }


    static void updateFeedback(List<Feedback> list) {
        System.out.print("Enter the Feedback ID to update: ");
        String id = scanner.nextLine();

        Feedback fb = findById(list, id);
        if (fb == null) {
            System.out.println("⚠ Feedback not found.");
            return;
        }

        System.out.print("New name (leave blank to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) fb.setName(name);

        System.out.print("New email (leave blank to keep current): ");
        String email = scanner.nextLine();
        if (!email.isEmpty() && isValidEmail(email)) fb.setEmail(email);

        System.out.print("New comment (leave blank to keep current): ");
        String comment = scanner.nextLine();
        if (!comment.isEmpty()) fb.setComment(comment);

        System.out.print("New rating (1-5, leave blank to keep current): ");
        String rating = scanner.nextLine();
        if (!rating.isEmpty() && isValidRating(rating)) fb.setRating(rating);

        saveFeedback(list);
        System.out.println("✅ Feedback updated successfully!");
    }

    static void deleteFeedback(List<Feedback> list) {
        System.out.print("Enter the Feedback ID to delete: ");
        String id = scanner.nextLine();

        Feedback fb = findById(list, id);
        if (fb != null) {
            list.remove(fb);
            saveFeedback(list);
            System.out.println("✅ Feedback deleted.");
        } else {
            System.out.println("⚠ Feedback not found.");
        }
    }

    static void generateReport(List<Feedback> list) {
        System.out.println("📊 === Feedback Report ===");
        System.out.println("Total feedbacks: " + list.size());

        Map<String, Integer> ratingCount = new HashMap<>();
        for (Feedback fb : list) {
            ratingCount.put(fb.getRating(), ratingCount.getOrDefault(fb.getRating(), 0) + 1);
        }

        for (String rating : ratingCount.keySet()) {
            System.out.println("Rating " + rating + ": " + ratingCount.get(rating));
        }
    }

    // === Input Helpers ===

    static String promptNonEmpty(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) System.out.println("⚠ Input cannot be empty.");
        } while (input.isEmpty());
        return input;
    }

    static String promptValidEmail(String prompt) {
        String email;
        do {
            System.out.print(prompt);
            email = scanner.nextLine().trim();
            if (!isValidEmail(email)) {
                System.out.println("⚠ Invalid email format. Try again.");
            }
        } while (!isValidEmail(email));
        return email;
    }

    static String promptValidRating(String prompt) {
        String rating;
        do {
            System.out.print(prompt);
            rating = scanner.nextLine().trim();
            if (!isValidRating(rating)) {
                System.out.println("⚠ Rating must be a number from 1 to 5.");
            }
        } while (!isValidRating(rating));
        return rating;
    }

    static boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    static boolean isValidRating(String rating) {
        return rating.matches("[1-5]");
    }

    // === Data Handling ===

    static Feedback findById(List<Feedback> list, String id) {
        for (Feedback fb : list) {
            if (fb.getId().equals(id)) return fb;
        }
        return null;
    }

    static List<Feedback> loadFeedback() {
        List<Feedback> list = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists())
            return list;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Feedback fb = Feedback.fromCSV(line);
                if (fb != null) list.add(fb);
            }
        } catch (IOException e) {
            System.out.println("❌ Error loading feedback: " + e.getMessage());
        }

        return list;
    }

    static void saveFeedback(List<Feedback> list) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Feedback fb : list) {
                writer.println(fb.toCSV());
            }
        } catch (IOException e) {
            System.out.println("❌ Error saving feedback: " + e.getMessage());
        }
    }

    static void updateNextId(List<Feedback> list) {
        int maxId = 0;
        for (Feedback fb : list) {
            try {
                int idNum = Integer.parseInt(fb.getId());
                if (idNum > maxId)
                    maxId = idNum;
            } catch (NumberFormatException e) {
                // skip invalid ID
            }   
        }
        nextId = maxId + 1;
    }
}
