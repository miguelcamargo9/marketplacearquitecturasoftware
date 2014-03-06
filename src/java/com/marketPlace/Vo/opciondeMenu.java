/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketPlace.Vo;

/**
 *
 * @author open12
 */
public class opciondeMenu {

  private String id;
  private String parent;
  private String text;

  public opciondeMenu() {
    this.id = null;
    this.parent = null;
    this.text = null;
  }

  public opciondeMenu(String id, String parent, String text) {
    this.id = id;
    this.parent = parent;
    this.text = text;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
