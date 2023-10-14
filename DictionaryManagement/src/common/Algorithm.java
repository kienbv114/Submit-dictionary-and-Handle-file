package common;

import java.util.HashMap;
import java.util.Scanner;
import model.DirectoryModel;

public class Algorithm {

    Validation validation = new Validation();
    HashMap<String, DirectoryModel> hm = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void addWord() {
        System.out.println("------------- Add -------------");
        System.out.print("Enter Vietnamese: ");
        String vietnamese = validation.checkInputString();
        if (!checkKeywordExist(vietnamese)) {
            if (!validation.checkInputYN()) {
                return;
            }
        }
        System.out.print("Enter English: ");
        String english = validation.checkInputString();
        DirectoryModel directoryModel = new DirectoryModel(english, vietnamese);
        hm.put(vietnamese, directoryModel);
        System.err.println("Successful.");
    }

    public void deleteWord() {
        System.out.println("------------ Delete ------------");
        System.out.print("Enter Vietnamese: ");
        String vietnamese = validation.checkInputString();
        hm.remove(vietnamese);
        System.err.println("Successful.");
    }

    public void translate() {
        System.out.println("------------- Translate ------------");
        System.out.println("Enter language to translate:(1. English, 2. Vietnamese) ");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter Vietnamese: ");
                String vietnamese = validation.checkInputString();
                DirectoryModel directoryModelEng = hm.get(vietnamese);
                if (directoryModelEng != null) {
                    System.out.println("English: " + directoryModelEng.getWordEnglish());
                } else {
                    System.err.println("Not found in data");
                }
                break;
            case 2:
                System.out.print("Enter English: ");
                String english = validation.checkInputString();
                boolean found = false;
                for (DirectoryModel directoryModel : hm.values()) {
                    if (directoryModel.getWordEnglish().equalsIgnoreCase(english)) {
                        System.out.println("Vietnamese: " + directoryModel.getWordVietnamese());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.err.println("Not found in data");
                }
                break;
        }

    }

    public boolean checkKeywordExist(String vietnamese) {
        return !hm.containsKey(vietnamese);
    }
}

