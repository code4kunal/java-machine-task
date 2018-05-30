/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;
/**
 *
 * @author kunalsaxena
 */
public enum Runs {
  
  ZERO("dot-ball"), ONE("single-run-scored"), TWO("double-scored"), 
  THREE("tripple-scored"), FOUR("boundary"), FIVE("five-run-scored"), SIX("sixer");

  public String getValue() {
    return value;
  }

  private final String value;
  
  Runs(String run){
     this.value = run;
  }
}
