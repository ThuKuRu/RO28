package com.vti.entity;

import java.time.LocalDate;

public class GroupAccount {
    private Group       group;

    private Account     account;

    private LocalDate joinDate;

    @Override
    public String toString() {
        return "GroupAccount{" +
                "groupID=" + group +
                ", accountID=" + account +
                ", joinDate=" + joinDate +
                '}';
    }

    public Group getIDGroup(){
        return group;
    }

    public void setGroup(){
        this.group = group;
    }

    public Account getAccount(){
        return account;
    }

    public Account setAccount(){
        this.account = account;
        return null;
    }

    public LocalDate getCreateDate() {
        return joinDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.joinDate = joinDate;
    }


}
