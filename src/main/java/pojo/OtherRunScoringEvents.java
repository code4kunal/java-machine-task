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
public enum OtherRunScoringEvents {
  
  LEGBYE("leg-bye"), BYES("byes");

  private final String value;

  public String getValue() {
        return value;
    }

  OtherRunScoringEvents(String event){
     this.value  = event;
  }
}
