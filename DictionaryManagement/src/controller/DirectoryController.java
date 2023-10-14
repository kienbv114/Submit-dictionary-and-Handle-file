package controller;

import common.Algorithm;
import view.Menu;

public class DirectoryController {

    private final String[] MAIN_MENU_ITEMS = {
        " Add word",
        " Delete word",
        " Translate",
        " Exit",};

    Algorithm algorithm = new Algorithm();

    Menu mainMenu = new Menu("======== Dictionary program ========", MAIN_MENU_ITEMS) {
        @Override
        public void execute(int choice) {
            switch (choice) {
                case 1:
                    algorithm.addWord();
                    break;
                case 2:
                    algorithm.deleteWord();
                    break;
                case 3:
                    algorithm.translate();
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        }
    };

    public void run() {
        mainMenu.run();
    }
}
