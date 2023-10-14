package controller;

import common.Algorithm;
import view.Menu;

public class FileController {

    private final String[] MAIN_MENU_ITEMS = {
        " Find person info",
        " Copy Text to new file",
        " Exit",};

    Algorithm algorithm = new Algorithm();

    Menu mainMenu = new Menu("========== File Processing =========", MAIN_MENU_ITEMS) {
        @Override
        public void execute(int choice) {
            switch (choice) {
                case 1:
                    algorithm.findPersonInfo();
                    break;
                case 2:
                    algorithm.copyFile();
                    break;
                case 3:
                    System.exit(0);
                    break;

            }
        }
    };

    public void run() {
        mainMenu.run();
    }
}
