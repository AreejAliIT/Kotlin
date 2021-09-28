package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.CharArrayWriter;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    private String userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        int[] ages = {3, 5, 2, 6, 12, 9, 6, 7, 11};

        Dog[] dogs = {
                new Dog("Fluffy", ages[new Random().nextInt(ages.length)]),
                new Dog("Rufus", ages[new Random().nextInt(ages.length)]),
                new Dog("Brian", ages[new Random().nextInt(ages.length)]),
                new Dog("Fred", ages[new Random().nextInt(ages.length)]),
                new Dog("Spot", ages[new Random().nextInt(ages.length)])
        };

        Cat[] cats = {
                new Cat("Lili", ages[new Random().nextInt(ages.length)]),
                new Cat("Meep", ages[new Random().nextInt(ages.length)]),
                new Cat("Patchy", ages[new Random().nextInt(ages.length)]),
                new Cat("Furball", ages[new Random().nextInt(ages.length)]),
                new Cat("Snowball", ages[new Random().nextInt(ages.length)])
        };

        for(Cat cat: cats){
            cat.meow();
            for(Dog dog: dogs){
                if(cat.age < dog.age){
                    dog.bark();
                }
            }
        }
    }

}

class Dog{
    String name;
    int age;

    public Dog(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void bark(){
        System.out.println(name + ": Woof");
    }
}

class Cat{
    String name;
    int age;

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void meow(){
        System.out.println(name + ": Meow");
    }
}