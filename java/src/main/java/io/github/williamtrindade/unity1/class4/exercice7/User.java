package io.github.williamtrindade.unity1.class4.exercice7;

import java.util.Date;

public class User {

    private Integer id;
    private String name;
    private String text;
    private Date date;
    private String[] phones;
    private boolean admin;
    private Owner owner;

    @Json
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Json
    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    @Json()
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Json
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Json
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Json
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Json(format = "yy-MM-dd")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static class Owner {
        private Integer id;
        private String name;

        public Owner(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Json
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Json
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


    }
}
