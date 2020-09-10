package com.school.organization.model;

public enum MaritalStatus {
    MARRIED("Married & not searching", 25, Gender.MALE),
    SINGLE("Single and ready to mingle", 0, Gender.FEMALE);

    private String name;

    private int minAge;

    private Gender gender;

    MaritalStatus(String name, int minAge, Gender gender){
        this.name = name;
        this.minAge = minAge;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
