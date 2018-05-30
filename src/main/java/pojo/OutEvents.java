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

public enum OutEvents {
  
  BOLD("bold"), CATCH("catch"), RUNOUT("run-out"), HITWICKET("hit-wicket"), 
          LBW("lbw"), OBSTRUCTION("field-obstruction");

  private final String value;

  public String getValue() {
        return value;
    }

  OutEvents(String out){
     this.value  = out;
  }
}
