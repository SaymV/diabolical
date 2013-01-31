package edu.lmu.cs.diabolical.ws.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;


/**
 * A quest is a specific predetermined mission for a character to accomplish.
 */
@Entity
@XmlRootElement
public class Quest {

 private Long id;
 private String name;
 private String description;
 private String clues;
 private String reward;
 private List<Character> character; 

 public Quest() {

 }

 public Quest(Long id, String name, String description, String clues, String reward, List<Character> character) {
  this.id = id;
  this.name = name;
  this.description = description;
  this.clues = clues;
  this.reward = reward;
 }

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @XmlAttribute
 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 @Lob
 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 @Lob
 public String getClues() {
  return clues;
 }

 public void setClues(String clues) {
  this.clues = clues;
 }

public String getReward() {
  return reward;
 }

 public void setReward(String reward) {
  this.reward = reward;
 }
 
 @LazyCollection(LazyCollectionOption.FALSE)
 @ManyToMany(cascade = CascadeType.ALL)
 public List<Character> getCharacter() {
  return character;
 }

 public void setCharacter(List<Character> character) {
  this.character = character;
 }
 
}
