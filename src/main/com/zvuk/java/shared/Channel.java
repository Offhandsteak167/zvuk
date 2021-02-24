package main.com.zvuk.java.shared;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Channel {
    private ArrayList<Chat> chats;
    private ArrayList<Account> accounts;
    private int channel_id;
    private String type;
    private String name;
    private String description;

    public Channel(){
        chats = new ArrayList<>();
        accounts = new ArrayList<>();
    }
    public void addMessage(Chat chat){
        this.chats.add(chat);
        if(!accounts.contains(chat.getOwner())){
            accounts.add(chat.getOwner());
        }
    }
}
