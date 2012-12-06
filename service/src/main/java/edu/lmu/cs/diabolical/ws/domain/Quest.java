package edu.lmu.cs.diabolical.ws.domain;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A quest is a specific predetermined mission for a character to accomplish.
 */
// @Entity
@XmlRootElement
public class Quest {

 private Long id;
 private String name;
 private String description;
 private String clues;
 private String reward;
 //TODO private List<NPCs> npcs; 

 public Quest() {

 }

 public Quest(Long id, String name, String description, String clues, String reward) {
  this.id = id;
  this.name = name;
  this.description = description;
  this.clues = clues;
  this.reward = reward;
 }

// @Id
// @GeneratedValue(strategy = GenerationType.AUTO)
 @XmlAttribute
 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

// @Lob
 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

// @Lob
 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

// @Lob
 public String getClues() {
  return clues;
 }

 public void setClues(String clues) {
  this.clues = clues;
 }

// @Lob
 public String getReward() {
  return reward;
 }

 public void setReward(String reward) {
  this.reward = reward;
 }

 /* TODO Getters and setters from List<NPCs>
 public List<NPC> getNpcs() {
  return npcs;
 }

 public void setNpcs(List<Npcs> npcs) {
  this.npcs = npcs;
 }

 public void addNpcs(Npcs npcs){
  this.npcs.add(npcs);
 }
 */

}
