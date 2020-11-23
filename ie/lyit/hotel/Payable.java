package ie.lyit.hotel;

public interface Payable{
public abstract double calculatePay(double taxPerc);

double incrementPay(double incPerc); 
}
