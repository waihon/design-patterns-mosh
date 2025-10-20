package com.waihon.designpatterns.mosh.mediator;

import org.w3c.dom.Text;

import java.util.List;

public class ArticlesDialogBox extends DialogBox {
    private ListBox articlesListBox = new ListBox(this);
    private TextBox titleTextBox = new TextBox(this);
    private Button saveButton = new Button(this);

    @Override
    void changed(UIControl control) {
        if (control == articlesListBox) {
            articleSelected();
        } else if (control == titleTextBox) {
            titleChanged();
        }
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
