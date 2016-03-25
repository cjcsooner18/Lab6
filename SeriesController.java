import java.awt.event.*;

import javax.swing.JOptionPane;

/**
 * Lab #6
 * CS 2334, Lab Section 013
 * March 24, 2016
 * <p>
 * The MVC controller for the program.
 * </p>
 * @author Cori Cook, Linh Vu
 * @version 1.0
 * 
 */
public class SeriesController {
	private SeriesModel model;
	private SeriesInputWindow inputView;

	/**
	 * Creates new SeriesController
	 */
	public SeriesController() {
		// intentionally empty
	}

	/**
	 * AddEpisodeListener provides a method to create a new episode. The episode
	 * should then be added to the episode list of the model. The values for the
	 * new episode come from the fields of the inputView. If the model is null
	 * when the method is called, it returns without taking any action.
	 */
	private class AddEpisodeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (model == null) return;	// No model associated.  Can't do anything.
			
			String title = inputView.jtfTitle.getText();
			String seasonNumber = inputView.jtfSeasonNumber.getText();
			String episodeNumber = inputView.jtfEpisodeNumber.getText();
			String year = inputView.jtfYear.getText();

			if (model.contains(title)) {  // Episode already in collection so ask what to do

				// TODO: Use a JOptionPane here to ask what to do
				new JOptionPane();
				String message = "Are you sure you want to replace the existing episode?";
				Object[] buttonoptions = {"Replace Episode", "Cancel"};
				int replace = JOptionPane.showOptionDialog(inputView, message, "Would you like to replace the existing episode data or...", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttonoptions, buttonoptions[1]);
				
				int response;  // assign returned value of JOptionPane to response
				response = replace;
				if (response == 0) {
					// option 0 is cancel so do nothing
					
				}
				else if (response == 1) {
					// TODO: call mutator method to replace episode (note that option 1 should be replace)
					model.replaceEpisode(new Episode(title, seasonNumber, episodeNumber, year));
				}
				else {
					// Should handle error case here (we won't for this lab).
				}
			}
			else {  // Episode not in collection, so add
				model.addEpisode(new Episode(title, seasonNumber, episodeNumber, year));
			}
		}
	}

	/**
	 * ClearEpisodeListener provides a method to clear the episode list of the
	 * model. If the model is null when the method is called, it returns without
	 * taking any action.
	 */
	private class ClearEpisodeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (model == null) return;
			model.clearEpisodes();
		}
	}

	/**
	 * ClearInputFieldsListener provides a method to clear the input fields of
	 * the inputView.
	 */
	private class ClearInputFieldsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (model == null) return;
			inputView.clearInputFields();
		}
	}
	
	// TODO:  Create additional listener classes for menu and toolbar.


	/**
	 * @param model
	 * 			to set as the model
	 */
	public void setModel(SeriesModel model) {
		this.model = model;
	}

	/**
	 * @return SeriesModel the model
	 */
	public SeriesModel getModel() { // future use
		return model;
	}

	/**
	 * @param theView
	 *            on which the listeners should be set
	 */
	public void setInputWindow(SeriesInputWindow theView) {
		inputView = theView;

		// Register listeners
		inputView.addAddEpisodeButtonListener(new AddEpisodeListener());		 
		inputView.addClearEpisodesButtonListener(new ClearEpisodeListener());
		inputView.addClearInputButtonListener(new ClearInputFieldsListener());

		// TODO: Register additional listeners for menu and toolbar.

		System.out.println("listeners registered in controller for input window");
	}
	
	/**
	 * @return the window (in case it needs to be sent messages from elsewhere)
	 */
	public SeriesInputWindow getInputWindow() { // future use
		return inputView;
	}
}