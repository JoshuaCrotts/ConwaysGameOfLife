/**
 * @file UIButtonPanel.java
 * @author Joshua Crotts
 * @date August 30 2020
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
package com.joshuacrotts.main;

import com.joshuacrotts.ui.model.ClearButton;
import com.joshuacrotts.ui.controller.FramerateChangeController;
import com.joshuacrotts.ui.model.GenerationLabel;
import com.joshuacrotts.ui.model.PauseButton;
import com.joshuacrotts.ui.model.RandomizeButton;
import com.joshuacrotts.ui.model.ResumeButton;
import com.joshuacrotts.ui.controller.SaveLoadController;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JToolBar;

public class UIButtonPanel extends JToolBar {

  //
  private final GameOfLife gameOfLife;

  //
  private final SaveLoadController saveLoadController;
  private final PauseButton pauseButton;
  private final ResumeButton resumeButton;
  private final RandomizeButton randomizeButton;
  private final ClearButton clearButton;
  private final FramerateChangeController framerateSlider;
  private final GenerationLabel generationLabel;

  //
  private static final int ROWS = 1;
  private static final int COLS = 7;

  //
  private static final int SAVE_LOAD_CONTROLLER_COL = 0;
  private static final int PAUSE_BUTTON_COL = 1;
  private static final int RESUME_BUTTON_COL = 2;
  private static final int RANDOMIZE_BUTTON_COL = 3;
  private static final int CLEAR_BUTTON_COL = 4;
  private static final int FRAMERATE_SLIDER_COL = 5;
  private static final int GENERATION_LABEL_COL = 6;

  public UIButtonPanel(GameOfLife gameOfLife) {
    this.gameOfLife = gameOfLife;
    this.saveLoadController = new SaveLoadController(this.gameOfLife);
    this.pauseButton = new PauseButton(this.gameOfLife);
    this.resumeButton = new ResumeButton(this.gameOfLife);
    this.randomizeButton = new RandomizeButton(this.gameOfLife);
    this.clearButton = new ClearButton(this.gameOfLife);
    this.framerateSlider = new FramerateChangeController(this.gameOfLife);
    this.generationLabel = new GenerationLabel(this.gameOfLife);

    super.setFloatable(false);
    super.setPreferredSize(new Dimension(this.gameOfLife.getScreenWidth(), 60));
    
    this.addComponents();
  }

  /**
   * Updates the pause, resume buttons, and the generation label.
   */
  public void updateUIElements() {
    this.pauseButton.setEnabled(!this.gameOfLife.isPaused());
    this.resumeButton.setEnabled(this.gameOfLife.isPaused());
    this.generationLabel.updateGeneration();
  }

  /**
   * 
   */
  private void addComponents() {
    super.setLayout(new GridLayout(ROWS, COLS)); // set JPanel's layout
    super.add(this.saveLoadController, 0, SAVE_LOAD_CONTROLLER_COL);
    super.add(this.pauseButton, 0, PAUSE_BUTTON_COL);
    super.add(this.resumeButton, 0, RESUME_BUTTON_COL);
    super.add(this.randomizeButton, 0, RANDOMIZE_BUTTON_COL);
    super.add(this.clearButton, 0, CLEAR_BUTTON_COL);

    super.add(this.framerateSlider, 0, FRAMERATE_SLIDER_COL);
    super.add(this.generationLabel, 0, GENERATION_LABEL_COL);
  }

  public PauseButton getPauseButton() {
    return this.pauseButton;
  }

  public ResumeButton getResumeButton() {
    return this.resumeButton;
  }
}
