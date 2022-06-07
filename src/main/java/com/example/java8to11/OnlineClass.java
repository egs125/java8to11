package com.example.java8to11;

import java.util.Optional;

public class OnlineClass {

    private Integer id;
    private String title;
    private Boolean closed;

    private Progress progress;

    public OnlineClass() {}

    public OnlineClass(Integer id, String title, Boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Boolean getClosed() {
        return this.closed;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

//    public Progress getProgress() {
//        return this.progress;
//    }

//    public void setProgress(Progress progress) {
//        this.progress = progress;
//    }

    public Optional<Progress> getProgress() {
        // Optional 리턴 시 null을 리턴하지 말것
//        return Optional.ofNullable(progress);
        return Optional.empty();
    }

    public void setProgress(Optional<Progress> progress) {
        // 이렇게 하면 오류가 나지 않지만 가급적 리턴값으로만 쓰기 권장.
        if ( progress != null ) {
            progress.ifPresent(p -> this.progress = p);
        }
    }


}
