package com.tutorial.article.entity;

import java.util.List;

public class AuthorAlias {
    private String name;
    private List<String> authorAliases;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAuthorAliases() {
        return authorAliases;
    }

    public void setAuthorAliases(List<String> authorAliases) {
        this.authorAliases = authorAliases;
    }
}
