package com.test.load.day001;

/**
 * @Package: com.test.load
 * @ClassName: Polymorphic
 * @Author: 86150
 * @Description:
 * @Date: 2021/9/25 10:12
 */
public class Polymorphic {




    public static void main(String[] args) {
        Person person = new Person() {
            @Override
            public void run() {

            }
        };
        // 给一个有普通收入、工资收入和享受国务院特殊津贴的小伙伴算税:
        Income[] incomes = new Income[] {
                new Income(3000),
                new Salary(7500),
                new StateCouncilSpecialAllowance(15000)
        };
        System.out.println(totalTax(incomes));
    }

    public static double totalTax(Income... incomes) {
        double total = 0;
        for (Income income: incomes) {
            total = total + income.getTax();
        }
        return total;
    }
    static class Income {
        protected double income;

        public Income(double income) {
            this.income = income;
        }

        public double getTax() {
            return income * 0.1; // 税率10%
        }
    }

    static class Salary extends Income {
        public Salary(double income) {
            super(income);
        }

        @Override
        public double getTax() {
            if (income <= 5000) {
                return 0;
            }
            return (income - 5000) * 0.2;
        }
    }

    static class StateCouncilSpecialAllowance extends Income {
        public StateCouncilSpecialAllowance(double income) {
            super(income);
        }

        @Override
        public double getTax() {
            return 0;
        }
    }

}
