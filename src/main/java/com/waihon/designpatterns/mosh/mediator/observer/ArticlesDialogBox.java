package com.waihon.designpatterns.mosh.mediator.observer;

public class ArticlesDialogBox {
    private ListBox articlesListBox = new ListBox();
    private TextBox titleTextBox = new TextBox();
    private Button saveButton = new Button();

    public ArticlesDialogBox() {
        articlesListBox.attach(() -> articleSelected());
        titleTextBox.attach(this::titleChanged);
    }

    public void simulateValidListBoxSelection() {
        articlesListBox.setSelection("Article 1");

        printControlInfo();
    }

    public void simulateEmptyListBoxSelection() {
        articlesListBox.setSelection("");

        printControlInfo();
    }

    public void simulateTextBoxOverridersWithEmptyContent() {
        articlesListBox.setSelection("Article 1");
        titleTextBox.setContent("");

        printControlInfo();
    }

    public void simulateTextBoxOverridersWithNonEmptyContent() {
        articlesListBox.setSelection("Article 1");
        titleTextBox.setContent("Article 2");

        printControlInfo();
    }

    private void articleSelected() {
        titleTextBox.setContent(articlesListBox.getSelection());
    }

    private void titleChanged() {
        var content = titleTextBox.getContent();
        var isEmpty = content == null || content.isEmpty();

        saveButton.setEnabled(!isEmpty);
    }

    private void printControlInfo() {
        System.out.println("ArticleListBox: " + articlesListBox.getSelection());
        System.out.println("TitleTextBox: " + titleTextBox.getContent());
        System.out.println("SaveButton: " + saveButton.isEnabled());
    }
}
