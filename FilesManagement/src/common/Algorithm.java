package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import model.PersonModel;

public class Algorithm {

    Validation validation = new Validation();

    public void findPersonInfo() {
        ArrayList<PersonModel> lp = new ArrayList<>();
        if (lp == null) {
            return;
        }
        System.out.println("--------- Person info ---------");
        String pathFile = validation.checkInputPathFile();
        lp = getListPerson(pathFile);
        double money = validation.checkInputMoney();
        printListPerson(lp, money);
    }

    public void copyFile() {
        System.out.println("------------- Copy text --------------");
        String pathFileInput = validation.checkInputPathFile();
        String newFileName = validation.checkNewFileName();
        String pathFileOutput = pathFileInput.substring(0, pathFileInput.lastIndexOf(File.separator) + 1) + newFileName;
        String content = getNewContent(pathFileInput);
        writeNewContent(pathFileOutput, content);
        System.out.println("Copy done...");
    }

    public ArrayList<PersonModel> getListPerson(String pathFile) {
        ArrayList<PersonModel> lp = new ArrayList<>();
        File file = new File(pathFile);
        if (!file.exists() || !file.isFile()) {
            System.err.println("Path doesn't exist");
            return null;
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferReader.readLine()) != null) {
                String[] infoPerson = line.split(";");
                lp.add(new PersonModel(infoPerson[0], infoPerson[1],
                        getSalary(infoPerson[2])));

            }
        } catch (IOException e) {
            System.err.println("Can't read file.");
        }
        return lp;
    }

    public double getSalary(String salary) {
        double salaryResult = 0;
        try {
            salaryResult = Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            salaryResult = 0;
        } finally {
            return salaryResult;
        }
    }

    public void printListPerson(ArrayList<PersonModel> lp, double money) {
        System.out.printf("%-20s%-20s%-20s\n", "Name", "Address", "Money");
        for (PersonModel person : lp) {
            if (person.getMoney() >= money) {
                System.out.printf("%-20s%-20s%-20.1f\n", person.getName(),
                        person.getAddress(), person.getMoney());
            }
        }
        Collections.sort(lp);
        System.out.println("Max: " + lp.get(0).getName());
        System.out.println("Min: " + lp.get(lp.size() - 1).getName());
    }

    public String getNewContent(String pathFileInput) {
        ArrayList<String> newContent = new ArrayList<>();
        File file = new File(pathFileInput);
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String word = input.next();
                newContent.add(word + " ");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Can’t read file");
        }
        String content = "";
        for (String line : newContent) {
            content += line;
        }
        return content;
    }

    public void writeNewContent(String pathFileOutput, String content) {
        FileWriter fileWriter = null;
        File file = new File(pathFileOutput);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(content);
            bufferWriter.close();
            System.err.println("Write successful");
        } catch (IOException ex) {
            System.err.println("Can’t write file");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
