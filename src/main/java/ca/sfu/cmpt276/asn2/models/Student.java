// Source code is decompiled from a .class file using FernFlower decompiler.
package ca.sfu.cmpt276.asn2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.RequestBody;

@Entity
@Table(
   name = "Student"
)
public class Student {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private int uid;
   private String name;
   private double weight;
   private double height;
   private String hairColor;
   private double gpa;

   public Student() {
   }

   public Student(String name, double weight, double height, String hairColor, double gpa) {
      this.name = name;
      this.weight = weight;
      this.height = height;
      this.hairColor = hairColor;
      this.gpa = gpa;
   }

   public String getName() {
      return this.name;
   }

   public void setName(@RequestBody String name) {
      this.name = name;
   }

   public double getWeight() {
      return this.weight;
   }

   public void setWeight(@RequestBody double weight) {
      this.weight = weight;
   }

   public double getHeight() {
      return this.height;
   }

   public void setHeight(@RequestBody double height) {
      this.height = height;
   }

   public String getHairColor() {
      return this.hairColor;
   }

   public void setHairColor(@RequestBody String hairColor) {
      this.hairColor = hairColor;
   }

   public double getGpa() {
      return this.gpa;
   }

   public void setGpa(@RequestBody double gpa) {
      this.gpa = gpa;
   }

   public int getUid() {
      return this.uid;
   }

   public void setUid(@RequestBody int uid) {
      this.uid = uid;
   }
}
