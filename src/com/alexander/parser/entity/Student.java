package com.alexander.parser.entity;

public class Student {
    private String login;
    private String name;
    private String faculty;
    private int telephone;
    private Address address = new Address();

    public Student() {}

    public Student(String login, String name, String faculty, int telephone, Address address) {
        this.login = login;
        this.name = name;
        this.faculty = faculty;
        this.telephone = telephone;
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return telephone == student.telephone &&
                login.equals(student.login) &&
                name.equals(student.name) &&
                faculty.equals(student.faculty) &&
                address.equals(student.address);
    }

    @Override
    public int hashCode() {
        return login.hashCode() +
                name.hashCode() +
                faculty.hashCode() +
                address.hashCode() +
                telephone;
    }

    public String toString() {
        return "\nLogin: " + login + "\nName: " + name + "\nTelephone: " + telephone
                + "\nFaculty: " + faculty + address.toString();
    }

    public static class Address {
        private String country;
        private String city;
        private String street;

        public Address() {}

        public Address(String country, String city, String street) {
            this.country = country;
            this.city = city;
            this.street = street;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String toString() {
            return "\nAddress:" + "\n\tCountry: " + country
                    + "\n\tCity: " + city + "\n\tStreet: " + street + "\n";
        }
    }
}
