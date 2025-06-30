public class FinancialForecast {

   
    public static double forecast(int year, double currentValue, double growthRate) {
        if (year == 0) {
            return currentValue;
        }
        return forecast(year - 1, currentValue, growthRate) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double currentValue = 1000.0; 
        double growthRate = 0.1;     
        int targetYear = 5;         

        double futureValue = forecast(targetYear, currentValue, growthRate);
        System.out.printf("Predicted value after %d years: ?%.2f\n", targetYear, futureValue);
    }
}
