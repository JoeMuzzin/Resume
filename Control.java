package edu.alma.muzzin1jv.CSC230Project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

//In this class we are controlling the gui
//Using 3 combo boxes to look at certain data from the covidtracking api
//we have an update button to show you the data from whichever boxes you select items

public class Control extends JPanel {

	private static final long serialVersionUID = 2L;

	private final JComboBox<Object> states;
	private final File[] StatesCurrentData;
	private final File[] DiagnosisCurrentData;
	private final File[] EndResultCurrentData;
	private final JButton update;
	private final JButton save;
	private final JComboBox<Object> diagnosis;
	private final JComboBox<Object> endResult;
	private JLabel date;
	private JTextField datetxt;
	private JLabel newDataLabel;
	private JTextField newData;
	private BufferedReader reader;

	//this arraylist is going to save every json we use that is from the covidtracking api
	ArrayList<String> myArray = new ArrayList<String>();
	
	// here we are building a client thanks to a maven dependency
	Client client = ClientBuilder.newClient();
	
	JsonApiStateCurrent response;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Control() {

		// this is for the first drop box for the states
		File A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21, A22, A23,
				A24, A25, A26, A27, A28, A29, A30, A31, A32, A33, A34, A35, A36, A37, A38, A39, A40, A41, A42, A43, A44,
				A45, A46, A47, A48, A49, A50;
		A1 = A2 = A3 = A4 = A5 = A6 = A7 = A8 = A9 = A10 = A11 = A12 = A13 = A14 = A15 = A16 = A17 = A18 = A19 = A20 = A21 = A22 = A23 = A24 = A25 = A26 = A27 = A28 = A29 = A30 = A31 = A32 = A33 = A34 = A35 = A36 = A37 = A38 = A39 = A40 = A41 = A42 = A43 = A44 = A45 = A46 = A47 = A48 = A49 = A50 = null;
		try {
			A1 = new File("al");
			A2 = new File("ak");
			A3 = new File("az");
			A4 = new File("ar");
			A5 = new File("ca");
			A6 = new File("co");
			A7 = new File("ct");
			A8 = new File("de");
			A9 = new File("fl");
			A10 = new File("ga");
			A11 = new File("hi");
			A12 = new File("id");
			A13 = new File("il");
			A14 = new File("in");
			A15 = new File("ia");
			A16 = new File("ks");
			A17 = new File("ky");
			A18 = new File("la");
			A19 = new File("me");
			A20 = new File("md");
			A21 = new File("ma");
			A22 = new File("mi");
			A23 = new File("mn");
			A24 = new File("ms");
			A25 = new File("mo");
			A26 = new File("mt");
			A27 = new File("ne");
			A28 = new File("nv");
			A29 = new File("nh");
			A30 = new File("nj");
			A31 = new File("nm");
			A32 = new File("ny");
			A33 = new File("nc");
			A34 = new File("nd");
			A35 = new File("oh");
			A36 = new File("ok");
			A37 = new File("or");
			A38 = new File("pa");
			A39 = new File("ri");
			A40 = new File("sc");
			A41 = new File("sd");
			A42 = new File("tn");
			A43 = new File("tx");
			A44 = new File("ut");
			A45 = new File("vt");
			A46 = new File("va");
			A47 = new File("wa");
			A48 = new File("wv");
			A49 = new File("wi");
			A50 = new File("wy");
		} catch (Exception e) {
			System.err.println("Error please check code");
		}

		StatesCurrentData = new File[50];
		StatesCurrentData[0] = A1;
		StatesCurrentData[1] = A2;
		StatesCurrentData[2] = A3;
		StatesCurrentData[3] = A4;
		StatesCurrentData[4] = A5;
		StatesCurrentData[5] = A6;
		StatesCurrentData[6] = A7;
		StatesCurrentData[7] = A8;
		StatesCurrentData[8] = A9;
		StatesCurrentData[9] = A10;
		StatesCurrentData[10] = A11;
		StatesCurrentData[11] = A12;
		StatesCurrentData[12] = A13;
		StatesCurrentData[13] = A14;
		StatesCurrentData[14] = A15;
		StatesCurrentData[15] = A16;
		StatesCurrentData[16] = A17;
		StatesCurrentData[17] = A18;
		StatesCurrentData[18] = A19;
		StatesCurrentData[19] = A20;
		StatesCurrentData[20] = A21;
		StatesCurrentData[21] = A22;
		StatesCurrentData[22] = A23;
		StatesCurrentData[23] = A24;
		StatesCurrentData[24] = A25;
		StatesCurrentData[25] = A26;
		StatesCurrentData[26] = A27;
		StatesCurrentData[27] = A28;
		StatesCurrentData[28] = A29;
		StatesCurrentData[29] = A30;
		StatesCurrentData[30] = A31;
		StatesCurrentData[31] = A32;
		StatesCurrentData[32] = A33;
		StatesCurrentData[33] = A34;
		StatesCurrentData[34] = A35;
		StatesCurrentData[35] = A36;
		StatesCurrentData[36] = A37;
		StatesCurrentData[37] = A38;
		StatesCurrentData[38] = A39;
		StatesCurrentData[39] = A40;
		StatesCurrentData[40] = A41;
		StatesCurrentData[41] = A42;
		StatesCurrentData[42] = A43;
		StatesCurrentData[43] = A44;
		StatesCurrentData[44] = A45;
		StatesCurrentData[45] = A46;
		StatesCurrentData[46] = A47;
		StatesCurrentData[47] = A48;
		StatesCurrentData[48] = A49;
		StatesCurrentData[49] = A50;

		// this is for the second drop box for the diagnosis box
		File B1, B2, B3, B4;
		B1 = B2 = B3 = B4 = null;
		try {
			B1 = new File("Positive");
			B2 = new File("Negative");
			B3 = new File("Pending");
			B4 = new File("Probable Cases");
		} catch (Exception e) {
			System.err.println("Error please check code");
		}
		DiagnosisCurrentData = new File[4];
		DiagnosisCurrentData[0] = B1;
		DiagnosisCurrentData[1] = B2;
		DiagnosisCurrentData[2] = B3;
		DiagnosisCurrentData[3] = B4;

		// this is for the third drop box determining
		File C1, C2, C3, C4;
		C1 = C2 = C3 = C4 = null;
		try {
			C1 = new File("Currently Hospitalized"); // Hospitalized in JsonApiStateCurrent
			C2 = new File("Deaths"); // deathConfirmed in JsonApiStateCurrent
			C3 = new File("Recovered"); // recovered in JsonApiStateCurrent
			C4 = new File("Ventilated"); // onVentilatorCurrently in JsonApiStateCurrent
		} catch (Exception e) {
			System.err.println("Error please check code");
		}
		EndResultCurrentData = new File[4];
		EndResultCurrentData[0] = C1;
		EndResultCurrentData[1] = C2;
		EndResultCurrentData[2] = C3;
		EndResultCurrentData[3] = C4;

		// here we are setting the values of the combo boxes
		states = new JComboBox(StatesCurrentData);
		diagnosis = new JComboBox(DiagnosisCurrentData);
		endResult = new JComboBox(EndResultCurrentData);

		// update button
		update = new JButton("Update Current Data");
		
		//save button
		save = new JButton("Save to file");

		newDataLabel = new JLabel("Updated Information");
		date = new JLabel("Date:");

		// size of the text field
		newData = new JTextField(60);
		datetxt = new JTextField(10);

		// this is configuring the GUI and the dimensions as well as adding the
		// different components
		setBackground(Color.gray);
		add(getStates());
		add(diagnosis);
		add(endResult);
		add(update);
		add(newDataLabel);
		add(newData);
		add(date);
		add(datetxt);
		add(save);

		// showing the actionlistener
		update.addActionListener(new ButtonListener());
		save.addActionListener(new ButtonListener());

		setFocusable(true);

	}

	public JComboBox<Object> getStates() {
		return states;
	}

	// for the button listener we are listening to the update button
	private class ButtonListener implements ActionListener {

		protected BigDecimal x;
		protected BigDecimal y;

		@Override
		public void actionPerformed(ActionEvent e) {

			//now since we have 2 buttons we need to determine whether it is the save button or
			//the update button so we would have to use e.getSource() for the button
			if (e.getSource() == save) {
				try {
					fileWriting(); //this method is for saving the arraylist full of jsons to the txtfile
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				// sets the clientbuilder's target path and giving the data to the
				// JsonApiStateCurrent class
				response = client.target(GUI.url).path("v1/states/" + getStates().getSelectedItem() + "/current.json")
						.request(MediaType.APPLICATION_JSON).get(JsonApiStateCurrent.class);

				// swingworker time
				startUpdate();

				//here we are adding the json to the arraylist
				try {
					toFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}

		}

		private void startUpdate() {
			
			//swingworker for the gui
			SwingWorker<BigDecimal, BigDecimal> worker = new SwingWorker<BigDecimal, BigDecimal>() {

				@Override
				protected BigDecimal doInBackground() throws Exception {

					Thread.sleep(100);
					
					x = getDiagnosis();
					y = getendResult();
					
					publish(x);
					publish(y);

					return null;
				}
				

				@Override
				protected void process(List<BigDecimal> chunks) {
					BigDecimal val = chunks.get(chunks.size() -1);
					
					
				}


				@Override
				protected void done() {

					// here we are setting the textfield for the updated information to whichever
					// you select on the drop boxes
					newData.setText("Current State: " + response.getState() + "  Current number for "
							+ diagnosis.getSelectedItem() + ": " + x + "  Current number for "
							+ endResult.getSelectedItem() + ": " + y);
					datetxt.setText(response.getDate().toString());
				}

			};

			worker.execute();
		}

		// This getmethod is for the second drop box so we can collect the information
		// we need from the JsonApiCurrent
		public BigDecimal getDiagnosis() {
			BigDecimal x = null;
			if (diagnosis.getSelectedIndex() == 0) {
				x = response.getPositive();
			} else if (diagnosis.getSelectedIndex() == 1) {
				x = response.getNegative();
			} else if (diagnosis.getSelectedIndex() == 2) {
				x = (BigDecimal) response.getPending();
			} else if (diagnosis.getSelectedIndex() == 3) {
				x = (BigDecimal) response.getProbableCases();
			}
			return x;
		}

		// this getmethod is for the third drop box were we also do the same thing as
		// getDiagnosis
		public BigDecimal getendResult() {
			BigDecimal x = null;
			if (endResult.getSelectedIndex() == 0) {
				x = (BigDecimal) response.getHospitalized();
			} else if (endResult.getSelectedIndex() == 1) {
				x = (BigDecimal) response.getDeathConfirmed();
			} else if (endResult.getSelectedIndex() == 2) {
				x = (BigDecimal) response.getRecovered();
			} else if (endResult.getSelectedIndex() == 3) {
				x = (BigDecimal) response.getOnVentilatorCurrently();
			}
			return x;
		}

	}

	//this method is used grab each json file we use when we click on the button update and 
	//then adds the json to the arraylist called myarray
	public void toFile() throws IOException {
		String x = (GUI.url + "/v1/states/" + states.getSelectedItem() + "/current.json");
		URL url = new URL(x);
		reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
		myArray.add(reader.readLine().toString());

	}

	//filewriting to write the jsons that we use to a file inside the program called serialx.txt
	public void fileWriting() throws IOException {
		File file = new File("serialx.txt");
		try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
			for (int i = 0; i < myArray.size(); i++) {
				br.write(myArray.get(i));
				br.newLine();
				br.flush();
				System.out.println(myArray.get(i));
			}

		}
	}
}
