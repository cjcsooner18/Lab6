import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Lab #6
 * CS 2334, Lab Section 013
 * March 24, 2016
 * <p>
 * Each object of this class represents a GUI display window (MVC view).
 * </p>
 * @author Cori Cook, Linh Vu
 * @version 1.0
 *
 */
public class SeriesDisplayWindow extends JFrame implements ActionListener {
	private static final long serialVersionUID = 2L;
	
	private JList<Episode> displayEpisodeList;
	private SeriesModel model;
	
	public SeriesDisplayWindow() {
		// intentionally empty
	}

	public void actionPerformed(ActionEvent e) {
		displayEpisodeList.setListData(model.getEpisodeArray());
		pack();
	}
	
	public void setModel(SeriesModel model) {
		this.model = model;
		
		if (model != null) {
			model.addActionListener(this);
			setTitle("Episodes in " + model.getTitle() + " (" + model.getStartYear() + ")");
			add(new JLabel("Episode Title (Season Number, Episode Number) Year"), BorderLayout.NORTH);
			displayEpisodeList = new JList<Episode>(model.getEpisodeArray());
			add(displayEpisodeList, BorderLayout.CENTER);
			pack();
			setVisible(true);
		}
	}

	public SeriesModel getModel() {
		return model;
	}
}