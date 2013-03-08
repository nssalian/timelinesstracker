/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StatusByRoutePanel.java
 *
 * Created on Jan 27, 2013, 4:08:32 PM
 */
package edu.ncsu.csc510.project.guilayer;

import edu.ncsu.csc510.project.commlayer.AirportStatusComm;
import edu.ncsu.csc510.project.commlayer.FlightStatusComm;
import edu.ncsu.csc510.project.utillayer.DelayData;
import edu.ncsu.csc510.project.utillayer.ResourceFetcher;
import edu.ncsu.csc510.project.utillayer.WeatherData;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author svpendse1
 */
public class FlightStatusByRoutePanel extends FlightStatusPanel {

	/** Creates new form StatusByRoutePanel */
	public FlightStatusByRoutePanel(javax.swing.JTabbedPane parentTab, FlightStatusByFlightPanel flightPanel) {
        this.parentTab = parentTab;
        this.flightPanel = flightPanel;
		initComponents();
        this.jTable1.setDefaultRenderer(Object.class, new CustomCellRenderer());
        this.jTable1.setSelectionBackground(Color.GRAY);
        this.jTable1.setGridColor(Color.GRAY);
		ResourceFetcher fetcher = new ResourceFetcher();
        sourceWeatherPanel = new WeatherPanel();
        destWeatherPanel = new WeatherPanel();

		try {
			this.departureField.setModel(new DefaultComboBoxModel(fetcher.getAirportCodesAndNames().toArray()));
			this.arrivalField.setModel(new DefaultComboBoxModel(fetcher.getAirportCodesAndNames().toArray()));
	        	 AutoCompleteDecorator.decorate(departureField);
			 AutoCompleteDecorator.decorate(arrivalField);
		} catch (Exception e) {
		    System.err.println("Error in setting up Route Panel");
		}
        this.removeAll();
        this.setLayout(new MigLayout("fillx, insets 10", "[]10[]", "[]10[]"));
        this.add(this.jPanel1, "center, span 2 1, wrap, w 100%");
        this.add(this.jScrollPane1, "center, span 2 1, wrap, w 100%");
        this.add(this.sourceWeatherPanel, "left, w 50%, height 150:150:150");
        this.add(this.destWeatherPanel, "right, w 50%, height 150:150:150, wrap");
        this.add(this.trackButton, "center, span 2 1, wrap, w 100%");
        this.jScrollPane1.setVisible(false);
        this.sourceWeatherPanel.setVisible(false);
        this.destWeatherPanel.setVisible(false);
        this.trackButton.setVisible(false);
        
        listSelectionModel = this.jTable1.getSelectionModel();
        listSelectionModel.addListSelectionListener(new SharedListSelectionHandler(this));
        this.jTable1.setSelectionModel(listSelectionModel);
        
        dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        DateFormat df[] = new DateFormat[1];
        df[0] = dateFormat; 
        this.jXDatePicker1.setFormats(df);
        this.jXDatePicker1.setDate(new Date());
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        departureField = new javax.swing.JComboBox();
        arrivalField = new javax.swing.JComboBox();
        busyLabel = new org.jdesktop.swingx.JXBusyLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        trackButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable() {
            public String getToolTipText(MouseEvent me) {
                String tip = null;
                java.awt.Point p = me.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);
                int realColumnIndex = convertColumnIndexToModel(colIndex);

                return jTable1.getValueAt(rowIndex, realColumnIndex).toString();
            }
        };

        setPreferredSize(new java.awt.Dimension(600, 464));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Parameters"));

        jLabel1.setText("Departure Airport");

        jLabel2.setText("Date");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Arrival Airport");

        busyLabel.setEnabled(false);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(busyLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(404, 404, 404))
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(78, 78, 78)
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel3)
                        .add(93, 93, 93))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(departureField, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(18, 18, 18)
                        .add(arrivalField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 244, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(36, 36, 36)
                        .add(jXDatePicker1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(38, 38, 38)
                        .add(searchButton))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(93, 93, 93)
                        .add(jLabel2)))
                .add(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel3)
                    .add(jLabel2))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(departureField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(arrivalField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXDatePicker1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(searchButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(busyLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(28, 28, 28))
        );

        trackButton.setText("Track this flight");
        trackButton.setEnabled(false);
        trackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trackButtonActionPerformed(evt);
            }
        });

        airportTableModel = new javax.swing.table.DefaultTableModel(null,
            new String [] {
                "Flight", "On-time Rating", "Airline", "Sched. Departure",
                "Act. Departure", "Term Gate", "Sched. Arrival", "Act. Arrival",
                "Term Gate", "Status", "Equipment"
            }
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable1.setModel(airportTableModel
        );
        jScrollPane1.setViewportView(jTable1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(27, 27, 27)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(trackButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(320, 320, 320))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(85, 85, 85)
                .add(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(trackButton)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
// TODO add your handling code here:
    this.busyLabel.setEnabled(true);
    this.busyLabel.setBusy(true);
    this.busyLabel.setText("Working...");
    new Thread(new SearchByRoute(this)).start();
    /*String departureName = this.departureField.getSelectedItem().toString();
    String arrivalName = this.arrivalField.getSelectedItem().toString();
    String date = this.dateField.getText(); 
    if (departureName.equals(arrivalName)) {
        JOptionPane.showMessageDialog(new JFrame(), "The source and destination airports must be different");
        return;
    }
    FlightStatusComm comm = new FlightStatusComm();
        //comm.queryFlightStatusByAirport(airportName, date, timePeriod, airlineName, searchOption, FlightStatusComm.SearchMethod.BY_AIRPORT);
    comm.queryFlightStatusByRoute(departureName, arrivalName, date, FlightStatusComm.SearchMethod.BY_ROUTE);
    Vector<String[]> output= comm.getFlightsByRouteTableContent();
    while (this.airportTableModel.getRowCount() != 0) {
        this.airportTableModel.removeRow(0);
    }
    if (output != null) {
        for (int i =0 ; i < output.size(); i++) {
            this.airportTableModel.addRow(output.get(i));
        }
    } else {
        System.out.println("Error fetching flight status data for the route from " +
                           departureName + " to " + arrivalName);
    }*/
}//GEN-LAST:event_searchButtonActionPerformed

    private void trackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trackButtonActionPerformed
        String airline, flightNumber, date;

        int selectedRowIndex = this.jTable1.getSelectedRow();
        airline = this.jTable1.getValueAt(selectedRowIndex, 2).toString();
        flightNumber = this.jTable1.getValueAt(selectedRowIndex, 0).toString();
        date = dateFormat.format(this.jXDatePicker1.getDate());

        flightPanel.setAirlineField(airline);
        flightPanel.setFlightNumberField(flightNumber);
        flightPanel.setDateField(date);
        parentTab.setSelectedComponent(flightPanel);
        flightPanel.searchByFlight();

    }
        // TODO add your handling code here:         String airline, flightNumber, date;          int selectedRowIndex = this.jTable1.getSelectedRow();         airline = this.jTable1.getValueAt(selectedRowIndex, 3).toString();         flightNumber = this.jTable1.getValueAt(selectedRowIndex, 1).toString();         date = this.dateField.getText();          flightPanel.setAirlineField(airline);         flightPanel.setFlightNumberField(flightNumber);         flightPanel.setDateField(date);         parentTab.setSelectedComponent(flightPanel);         flightPanel.searchByFlight();     }//GEN-LAST:event_trackButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox arrivalField;
    private org.jdesktop.swingx.JXBusyLabel busyLabel;
    private javax.swing.JComboBox departureField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.table.DefaultTableModel airportTableModel;
    private javax.swing.JTable jTable1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton trackButton;
    // End of variables declaration//GEN-END:variables
    private javax.swing.ListSelectionModel listSelectionModel;
    private FlightStatusByFlightPanel flightPanel;
    private javax.swing.JTabbedPane parentTab;
    private SimpleDateFormat dateFormat;

    private WeatherPanel sourceWeatherPanel, destWeatherPanel;

    public JButton getTrackButton() {
        return trackButton;
    }

    public void setTrackButton(JButton trackButton) {
        this.trackButton = trackButton;
    }

    class SearchByRoute implements Runnable {
        FlightStatusByRoutePanel panel;
        
        public SearchByRoute(FlightStatusByRoutePanel panel) {
            this.panel = panel;
        }
        
        public void run() {
            String departureName = panel.departureField.getSelectedItem().toString();
            String arrivalName = panel.arrivalField.getSelectedItem().toString();
            String date = panel.dateFormat.format(panel.jXDatePicker1.getDate());
           
            if (departureName.equals(arrivalName)) {
                panel.busyLabel.setText("");
                panel.busyLabel.setBusy(false);
                panel.busyLabel.setEnabled(false);
                JOptionPane.showMessageDialog(new JFrame(), "The source and destination airports must be different.");
                return;
            }
            FlightStatusComm comm = new FlightStatusComm();
            AirportStatusComm acomm = new AirportStatusComm();
 
            acomm.queryWeatherStatusByAirport(this.panel.departureField.getSelectedItem().toString());
            WeatherData swdata = acomm.getWeatherTable();
            DelayData sddata = acomm.getDelaysTable();
            panel.sourceWeatherPanel.setConditions(swdata.conditions);
            panel.sourceWeatherPanel.setDewpoint(swdata.dewpoint);
            panel.sourceWeatherPanel.setTemperature(swdata.temperature);
            panel.sourceWeatherPanel.setVisibility(swdata.visibility);
            panel.sourceWeatherPanel.setWind(swdata.wind);
            panel.sourceWeatherPanel.setSky(swdata.skyconditions);
            panel.sourceWeatherPanel.setChange(sddata.change);
            panel.sourceWeatherPanel.setDelay(sddata.delay);
            panel.sourceWeatherPanel.setTrend(sddata.trend);


            
            acomm.queryWeatherStatusByAirport(this.panel.arrivalField.getSelectedItem().toString());
            WeatherData dwdata = acomm.getWeatherTable();
            DelayData dddata = acomm.getDelaysTable();
            panel.destWeatherPanel.setConditions(dwdata.conditions);
            panel.destWeatherPanel.setDewpoint(dwdata.dewpoint);
            panel.destWeatherPanel.setTemperature(dwdata.temperature);
            panel.destWeatherPanel.setVisibility(dwdata.visibility);
            panel.destWeatherPanel.setWind(dwdata.wind);
            panel.destWeatherPanel.setSky(dwdata.skyconditions);
            panel.destWeatherPanel.setChange(dddata.change);
            panel.destWeatherPanel.setDelay(dddata.delay);
            panel.destWeatherPanel.setTrend(dddata.trend);
           
            panel.sourceWeatherPanel.setBorder(BorderFactory.createTitledBorder(panel.departureField.getSelectedItem().toString() + " Weather"));
            panel.destWeatherPanel.setBorder(BorderFactory.createTitledBorder(panel.arrivalField.getSelectedItem().toString() + " Weather"));

            
            //comm.queryFlightStatusByAirport(airportName, date, timePeriod, airlineName, searchOption, FlightStatusComm.SearchMethod.BY_AIRPORT);
            comm.queryFlightStatusByRoute(departureName, arrivalName, date, FlightStatusComm.SearchMethod.BY_ROUTE);
            Vector<String[]> output= comm.getFlightsByRouteTableContent();

            if (output == null) {
                panel.busyLabel.setText("");
                panel.busyLabel.setBusy(false);
                panel.busyLabel.setEnabled(false);
                JOptionPane.showMessageDialog(new JFrame(), "No flights between source and destination airports.");
                return; 
            }
            while (panel.airportTableModel.getRowCount() != 0) {
                panel.airportTableModel.removeRow(0);
            }
            if (output != null) {
                for (int i =0 ; i < output.size(); i++) {
                    panel.airportTableModel.addRow(output.get(i));
                }
            } else {
                System.out.println("Error fetching flight status data for the route from " +
                                   departureName + " to " + arrivalName);
            }
            panel.busyLabel.setBusy(false);
            panel.busyLabel.setText("");
            panel.busyLabel.setEnabled(false);
            panel.jScrollPane1.setVisible(true);
            panel.sourceWeatherPanel.setVisible(true);
            panel.destWeatherPanel.setVisible(true);
            panel.trackButton.setVisible(true);
        }
    }
}
