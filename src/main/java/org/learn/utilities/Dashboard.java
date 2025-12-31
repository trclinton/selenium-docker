package org.learn.utilities;

import java.util.List;

public class Dashboard {

    String username, password, searchText;
    List<Object> dashParm;
    int count;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public List<Object> getDashParm() {
        return dashParm;
    }

    public void setDashParm(List<Object> dashParm) {
        this.dashParm = dashParm;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
