package assignment3.assignment3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reptiles")

public class Reptile {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long reptileId;

 @Column(nullable = false)
 private String name;
 private String description;
 private String species;

 @Column(nullable = false)
 private Double age;

 public Reptile (){
 }

 public Reptile(Long reptileId, String name, String description, Double age, String species) {
     this.reptileId = reptileId;
     this.name = name;
     this.description = description;
     this.age = age;
     this.species = species;
 }

 public Reptile(String name, String description, Double age, String species){
    this.name = name;
    this.description = description;
    this.age = age;
    this.species = species;
 }

 public Long getReptileId(){
    return reptileId;
 }

 public void setReptileId(Long id) {
    this.reptileId = id;
 }
 
 public String getName() {
    return name;
 }

 public void setName(String name) {
    this.name = name;
 }

 public String getDescription() {
    return description;
 }

 public void setDescription(String description) {
    this.description = description;
 }

 public Double getAge() {
    return age;
 }

 public void setAge(Double age) {
    this.age = age;
 }

 public String getSpecies() {
    return species;
 }

 public void setSpecies(String species) {
    this.species = species;
 }

}
