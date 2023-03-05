package entities;

public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual (){

    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome); // estou reaproveitando a implementacao do construtor da super classe
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override

    public double tax() {

        /*forma ternaria de fazer   double basicTax = (getAnualIncome() < 20000.0)
         ? getAnualIncome() * 0.15:getAnualIncome() * 0.25;*/
        double basicTax;
        if (getAnualIncome() < 20000.0) {
            basicTax = getAnualIncome() * 0.15;
        } else {
            basicTax = getAnualIncome() * 0.25;

        }
        basicTax = basicTax - (getAnualIncome() * 0.5);
        if (basicTax < 0.0) {
            basicTax = 0.0;
        }

        return basicTax;
    }
}
