package com.example.hackeru.callrecordingapp.infrastructure;



/**
 * Created by hackeru on 8/25/2016.
 */
public class Call {

    private long start, end;
    private int incoming;   // 1 - incoming, 0 - outgoing.
    private String phoneNumber, fileUri;

    public Call(int incoming, String phoneNumber, String fileUri){
        start = System.currentTimeMillis();
        this.incoming = incoming;
        this.phoneNumber = phoneNumber;
        this.fileUri = fileUri;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd() {
        end = System.currentTimeMillis();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFileUri() {
        return fileUri;
    }

    public int getIncoming() {
        return incoming;
    }
}
