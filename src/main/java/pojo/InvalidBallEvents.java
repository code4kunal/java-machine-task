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
public enum InvalidBallEvents {
  
  WIDE("wide"), NOBALL("no-ball"), DEADBALL("dead-ball");
  private final String value;

  public String getValue() {
        return value;
    }

  InvalidBallEvents(String event){
     this.value  = event;
  }
}
