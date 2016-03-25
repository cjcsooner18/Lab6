/**
 * Lab #6
 * CS 2334, Lab Section 013
 * March 24, 2016
 * <p>
 * This program allows information on episodes for the original Star Trek series
 * to be entered through a GUI window and adds each to a list, and displays the
 * episode list in a second GUI window. Note that the classes are quite simple,
 * sometimes using String when another data type would be more appropriate,
 * because the focus of this lab is GUI's and event handling. Also, some data is
 * hard coded that should be input.
 * </p>
 * @author Cori Cook, Linh Vu
 * @version 1.0
 *
 */

public class Lab6Driver {
	static SeriesModel theSeriesModel = new SeriesModel("Star Trek", 1966, 1969);
	static SeriesInputWindow theInputWindow = new SeriesInputWindow();
	static SeriesDisplayWindow theDisplayWindow = new SeriesDisplayWindow();
	static SeriesController theController = new SeriesController();	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		theDisplayWindow.setModel(theSeriesModel);
		theController.setModel(theSeriesModel);
		theController.setInputWindow(theInputWindow);
	}
}
