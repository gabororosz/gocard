package com.go.gocard.card;

public interface CardViewEventHandler {
    void mailEdited(String mail);
    void phoneEdited(String phone);
    void nameEdited(String name);
    void titleEdited(String title);
    void sendClicked();
    void goToSiteClicked();
}
