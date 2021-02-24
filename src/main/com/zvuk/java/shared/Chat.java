package main.com.zvuk.java.shared;

import java.util.ArrayList;
import java.util.Date;

public class Chat {
    private ArrayList<Chat> replies;
    private String content;
    private Account owner;
    private Date date;

    public Chat(String content, Account user){
        this.content = content;
        this.date = new Date(System.currentTimeMillis());
        this.owner = user;
        this.replies = new ArrayList<>();
    }

    public void addReply(Chat chat) {
        replies.add(chat);
    }

    public Account getOwner() {
        return owner;
    }
}
