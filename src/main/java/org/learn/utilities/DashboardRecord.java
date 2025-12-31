package org.learn.utilities;

import java.util.List;

public record DashboardRecord(
    String username,
    String password,
    String searchText,
    List<Object> dashParm,
    int count
) {}
