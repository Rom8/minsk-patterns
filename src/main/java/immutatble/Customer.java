package immutatble;

import lombok.ToString;

/**
 * Created by Jeka on 27/09/2015.
 */
@ToString
public class Customer {
    private final String name;
    private final int bonus;
    private final int debt;




    public static class Builder{
        private String name;
        private int bonus;
        private int debt;
        private volatile boolean alreadyUsed;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder bonus(int bonus) {
            this.bonus = bonus;
            return this;
        }

        public Builder debt(int debt) {
            this.debt = debt;
            return this;
        }

        public synchronized Customer build(){
            validate();
            if (alreadyUsed) {
                throw new IllegalStateException("builder can't be used twice");
            }
            Customer customer = new Customer(name, bonus, debt);
            alreadyUsed = true;
            return customer;
        }

        private void validate() {
            if (name == null) {
                throw new RuntimeException("name can't be null");
            }
        }
    }


    private Customer(String name, int bonus, int debt) {
        this.name = name;
        this.bonus = bonus;
        this.debt = debt;
    }


    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }

    public int getDebt() {
        return debt;
    }
}
