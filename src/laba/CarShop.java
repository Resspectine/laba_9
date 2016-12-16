package laba;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

public class CarShop implements Serializable {
    private BigDecimal phoneNumber;
    private Calendar dateOfOpening;
    private ArrayList<String> marks;
    private ArrayList<String> masters;

    CarShop() {
        phoneNumber = null;
        dateOfOpening = Calendar.getInstance();
        dateOfOpening.set(Calendar.YEAR, 0);
        marks = new ArrayList<>();
        masters = new ArrayList<>();
    }

    CarShop(CarShop cp) {
        this.phoneNumber = cp.phoneNumber;
        this.dateOfOpening = Calendar.getInstance();
        this.dateOfOpening = cp.dateOfOpening;
        this.marks = cp.marks;
        this.masters = cp.masters;
    }

    CarShop(BigDecimal phoneNumber, int dateOfOpening, ArrayList<String> marks, ArrayList<String> masters) {
        this.phoneNumber = phoneNumber;
        this.dateOfOpening = Calendar.getInstance();
        this.dateOfOpening.set(Calendar.YEAR, dateOfOpening);
        this.marks = marks;
        this.masters = masters;
    }

    @Override
    public String toString() {
        return "+" + phoneNumber + " " + dateOfOpening.get(Calendar.YEAR) + " " + marks + " " + masters;
    }

    public void setPhoneNumber(BigDecimal phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfOpening(int dateOfOpening) {
        this.dateOfOpening.set(Calendar.YEAR, dateOfOpening);
    }

    public void setMarks(ArrayList<String> marks) {
        this.marks = marks;
    }

    public void setMasters(ArrayList<String> masters) {
        this.masters = masters;
    }

    public BigDecimal getPhoneNumber() {
        return this.phoneNumber;
    }

    public int getDateOfOpening() {
        return this.dateOfOpening.get(Calendar.YEAR);
    }

    public ArrayList<String> getMarks() {
        return this.marks;
    }

    public ArrayList<String> getMasters() {
        return this.masters;
    }
}
