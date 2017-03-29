package Adminui;

public enum MonthName {
    January(31),Febraury(28),March(31),April(30),May(31),June(30),July(31),August(31),September(30),October(31),November(30),December(31);

    private int days;
    private MonthName(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}
