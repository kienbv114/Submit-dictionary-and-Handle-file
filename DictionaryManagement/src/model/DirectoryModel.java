package model;

public class DirectoryModel {
    private String wordEnglish;
    private String wordVietnamese;

    public DirectoryModel() {
    }

    public DirectoryModel(String wordEnglish, String wordVietnamese) {
        this.wordEnglish = wordEnglish;
        this.wordVietnamese = wordVietnamese;
    }

    public String getWordEnglish() {
        return wordEnglish;
    }

    public void setWordEnglish(String wordEnglish) {
        this.wordEnglish = wordEnglish;
    }

    public String getWordVietnamese() {
        return wordVietnamese;
    }

    public void setWordVietnamese(String wordVietnamese) {
        this.wordVietnamese = wordVietnamese;
    }
}

