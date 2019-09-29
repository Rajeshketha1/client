package com.example.client.model;

public class Personal {
    @Override
    public String toString() {
        return "Personal{" +
                "age='" + age + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    private String age;

  private String email;

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
