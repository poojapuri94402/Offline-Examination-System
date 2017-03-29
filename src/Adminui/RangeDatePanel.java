package Adminui;

import java.sql.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Grapess2
 */
public class RangeDatePanel extends javax.swing.JPanel {

    private Date startdate;
    private Date enddate;
    private int syear, smonth, sdate;
    private int eyear, emonth, edate;

    public Date getStartdate() {
        return startdate;
    }

    public Date getSelectedDate() {
        Date dt = null;
        try {
            if (jcbYear.getSelectedIndex() > 0 && jcbMonth.getSelectedIndex() > 0 && jcbDate.getSelectedIndex() > 0) {
                int year = Integer.parseInt(jcbYear.getSelectedItem().toString());
                MonthNames mon = MonthNames.valueOf(jcbMonth.getSelectedItem().toString());

                int month = mon.ordinal() + 1;
                int date = Integer.parseInt(jcbDate.getSelectedItem().toString());
                String datevalue = year + "-" + month + "-" + date;
                dt = Date.valueOf(datevalue);
            }
        } catch (Exception ex) {

        }
        return dt;
    }

    public void setDate(Date dtvalue) {
        try {
            String[] values = dtvalue.toString().split("-");
            int year = Integer.parseInt(values[0]);
            int month = Integer.parseInt(values[1]);
            int date = Integer.parseInt(values[2]);
            for (int i = 1; i < jcbYear.getItemCount(); i++) {
                int syear = Integer.parseInt(jcbYear.getItemAt(i).toString());
                if (syear == year) {
                    jcbYear.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 1; i < jcbMonth.getItemCount(); i++) {
                MonthNames mon = MonthNames.valueOf(jcbMonth.getItemAt(i).toString());
                if (mon.ordinal() + 1 == month) {
                    jcbMonth.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 1; i < jcbDate.getItemCount(); i++) {
                int dt = Integer.parseInt(jcbDate.getItemAt(i).toString());
                if (dt == date) {
                    jcbDate.setSelectedIndex(i);
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) throws InvalidDateRangeException {
        if (startdate == null) {
            throw new InvalidDateRangeException("First Set Start Date");
        }
        if (enddate == null) {
            throw new InvalidDateRangeException("End Date must be valid reference");
        }
        if (enddate.getTime() < startdate.getTime()) {
            throw new InvalidDateRangeException("End Date must be Greater than Start Date");
        }
        this.enddate = enddate;
        refreshDatePanel();
    }

    public void refreshDatePanel() {
        try {
            String sdate[] = startdate.toString().split("-");
            String edate[] = enddate.toString().split("-");
            syear = Integer.parseInt(sdate[0]);
            eyear = Integer.parseInt(edate[0]);
            smonth = Integer.parseInt(sdate[1]);
            emonth = Integer.parseInt(edate[1]);
            this.sdate = Integer.parseInt(sdate[2]);
            this.edate = Integer.parseInt(edate[2]);
            jcbYear.removeAllItems();
            jcbYear.addItem("Year");
            for (int y = syear; y <= eyear; y++) {
                jcbYear.addItem(String.valueOf(y));
            }
        } catch (Exception ex) {

        }
    }

    public RangeDatePanel() {
        initComponents();
        jcbYear.removeAllItems();
        jcbYear.addItem("Year");
        jcbMonth.removeAllItems();
        jcbMonth.addItem("Month");
        jcbDate.removeAllItems();
        jcbDate.addItem("Date");
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
                .addComponent(jcbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcbYear, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
            .addComponent(jcbMonth)
            .addComponent(jcbDate)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbYearItemStateChanged
        String mvalue = jcbMonth.getSelectedItem().toString();
        String dvalue = jcbDate.getSelectedItem().toString();
        jcbMonth.removeAllItems();
        jcbMonth.addItem("Month");
        if (jcbYear.getSelectedIndex() > 0) {
            int selyear = Integer.parseInt(jcbYear.getSelectedItem().toString());
            MonthNames[] allmonths = MonthNames.values();
            int startindex = 0;
            int endindex = allmonths.length - 1;
            if (selyear == syear) {
                startindex = smonth - 1;
            } else if (selyear == eyear) {
                endindex = emonth - 1;
            }
            for (int i = startindex; i <= endindex; i++) {
                jcbMonth.addItem(allmonths[i].toString());
            }
            for (int i = 1; i < jcbMonth.getItemCount(); i++) {
                String val = jcbMonth.getItemAt(i).toString();
                if (val.equals(mvalue)) {
                    jcbMonth.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 1; i < jcbDate.getItemCount(); i++) {
                String val = jcbDate.getItemAt(i).toString();
                if (val.equals(dvalue)) {
                    jcbDate.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_jcbYearItemStateChanged

    private void jcbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbMonthItemStateChanged
        String dvalue = jcbDate.getSelectedItem().toString();
        jcbDate.removeAllItems();
        jcbDate.addItem("Date");
        if (jcbYear.getSelectedIndex() > 0 && jcbMonth.getSelectedIndex() > 0) {
            int selyear = Integer.parseInt(jcbYear.getSelectedItem().toString());
            MonthNames mn = MonthNames.valueOf(jcbMonth.getSelectedItem().toString());
            int selmonth = mn.ordinal() + 1;
            int startdate = 1;
            int enddate = 31;
            switch (selmonth) {
                case 4:
                case 6:
                case 9:
                case 11:
                    enddate = 30;
                    break;
                case 2:
                    GregorianCalendar gcal = new GregorianCalendar();
                    enddate = gcal.isLeapYear(selyear) ? 29 : 28;
                    break;
            }
            if (selyear == syear && selmonth == smonth) {
                startdate = sdate;
            } else if (selyear == eyear && selmonth == emonth) {
                enddate = edate;
            }
            for (int i = startdate; i <= enddate; i++) {
                jcbDate.addItem(String.valueOf(i));
            }
            for (int i = 1; i < jcbDate.getItemCount(); i++) {
                String val = jcbDate.getItemAt(i).toString();
                if (val.equals(dvalue)) {
                    jcbDate.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_jcbMonthItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jcbDate;
    private javax.swing.JComboBox<String> jcbMonth;
    private javax.swing.JComboBox<String> jcbYear;
    // End of variables declaration//GEN-END:variables
}
