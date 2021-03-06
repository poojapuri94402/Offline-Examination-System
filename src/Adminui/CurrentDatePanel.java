/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adminui;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CurrentDatePanel extends javax.swing.JPanel {

    GregorianCalendar gcal;
    public CurrentDatePanel() {
        initComponents();
        
        jcbYear.removeAllItems();
        jcbYear.addItem("Year");
        jcbMonth.removeAllItems();
        jcbMonth.addItem("Month");
        jcbDate.removeAllItems();
        jcbDate.addItem("Date");
        gcal=new GregorianCalendar();
        int currentyear=gcal.get(Calendar.YEAR);
        int endyear= currentyear+40;
        for(int Year=currentyear;Year<=endyear;Year++){
            jcbYear.addItem(String.valueOf(Year));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbYear = new javax.swing.JComboBox<>();
        jcbMonth = new javax.swing.JComboBox<>();
        jcbDate = new javax.swing.JComboBox<>();

        jcbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbYearItemStateChanged(evt);
            }
        });

        jcbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbMonthItemStateChanged(evt);
            }
        });

        jcbDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcbYear, 0, 85, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbYearItemStateChanged
        jcbMonth.removeAllItems();
        jcbMonth.addItem("Month");
        if(jcbYear.getSelectedIndex()>0){
            int syear=Integer.parseInt(jcbYear.getSelectedItem().toString());
            int cyear=gcal.get(Calendar.YEAR);
            MonthName[] months=MonthName.values();
            int startindex=0;
            int endindex=months.length-1;
            if(syear==cyear){
                endindex=gcal.get(Calendar.MONTH);
            }
            for(int index=startindex;index<=endindex;index++){
                jcbMonth.addItem(months[index].toString());
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbYearItemStateChanged

    private void jcbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMonthItemStateChanged
        jcbDate.removeAllItems();
        jcbDate.addItem("Date");
        if(jcbYear.getSelectedIndex()>0&& jcbMonth.getSelectedIndex()>0){
            int syear=Integer.parseInt(jcbYear.getSelectedItem().toString());
            int cyear=gcal.get(Calendar.YEAR);
            int cmonth=gcal.get(Calendar.MONTH);
            MonthName smonth=MonthName.valueOf(jcbMonth.getSelectedItem().toString());
            int startdate=1;
            int enddate=smonth.getDays();
             if(syear==cyear&&cmonth==smonth.ordinal()){
                enddate=gcal.get(Calendar.DATE);
            }
             else if(smonth==MonthName.Febraury){
                 enddate=gcal.isLeapYear(syear)?29:28;
        }
            for(int date=startdate;date<=enddate;date++){
                jcbDate.addItem(String.valueOf(date));
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbMonthItemStateChanged

    public Date getSelectedDate(){
        Date dt=null;
        try{
            if(jcbYear.getSelectedIndex()>0&& jcbMonth.getSelectedIndex()>0&&jcbDate.getSelectedIndex()>0){
                int year=Integer.parseInt(jcbYear.getSelectedItem().toString());
                int month=jcbMonth.getSelectedIndex();
                int date=jcbDate.getSelectedIndex();
                String datevalue = year+"-"+month+"-"+date;   
                dt=Date.valueOf(datevalue);
            }   
           }catch(Exception ex){
            
        }
        return dt;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jcbDate;
    private javax.swing.JComboBox<String> jcbMonth;
    private javax.swing.JComboBox<String> jcbYear;
    // End of variables declaration//GEN-END:variables

    public void setDate(Date dtvalue) {
    try{
        String[] values=dtvalue.toString().split("-");
        int year=Integer.parseInt(values[0]);
        int month=Integer.parseInt(values[1]);
        int date=Integer.parseInt(values[2]);
        for(int i=1;i<jcbYear.getItemCount();i++){
            int syear=Integer.parseInt(jcbYear.getItemAt(i).toString());
            if(syear==year){
                jcbYear.setSelectedIndex(i);
                break;
            }
        }
        jcbMonth.setSelectedIndex(month);
        jcbDate.setSelectedIndex(date);
    }catch(Exception ex){
        System.out.println(ex);   
    }
    }
}
