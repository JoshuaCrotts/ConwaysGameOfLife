/**
 * @file ClearButton.java
 * @author Joshua Crotts
 * @date September 1 2020
 * @version 1.0
 *
 * @section LICENSE
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * @section DESCRIPTION
 *
 */
package com.joshuacrotts.ui.model;

import com.joshuacrotts.main.GameOfLife;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ClearButton extends JButton implements ActionListener {

  private final GameOfLife gameOfLife;
  
  public ClearButton(GameOfLife gol) {
    super("CLEAR");
    this.gameOfLife = gol;
    
    super.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent ex) {
    this.gameOfLife.getParentPanel().getGridPanel().clearGrid();
    this.gameOfLife.getParentPanel().getGridPanel().setGeneration(0);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
  }
}