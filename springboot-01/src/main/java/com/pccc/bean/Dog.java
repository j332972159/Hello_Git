package com.pccc.bean;

/**
 * @Author jinquanhua
 * @date 2020/6/4 23:21
 */
public class Dog {
    private String name;
    private Integer age;

    /*public Dog(String name,Integer age) {
        this.name = name;
        this.age = age;
    }*/

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
