import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int money;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();

            switch (action) {
                case "buy":
                    buy(scanner);
                    break;
                case "fill":
                    fill(scanner);
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    printState();
                    break;
                case "exit":
                    return;
            }
        }
    }

    private void buy(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                break;
            default:
                break;
        }
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int price) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= coffeeBeansNeeded && disposableCups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= coffeeBeansNeeded;
            money += price;
            disposableCups--;
        } else {
            if (water < waterNeeded) {
                System.out.println("Sorry, not enough water!");
            } else if (milk < milkNeeded) {
                System.out.println("Sorry, not enough milk!");
            } else if (coffeeBeans < coffeeBeansNeeded) {
                System.out.println("Sorry, not enough coffee beans!");
            } else {
                System.out.println("Sorry, not enough disposable cups!");
            }
        }
    }

    private void fill(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        int waterToAdd = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int milkToAdd = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffeeToAdd = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        int cupsToAdd = scanner.nextInt();
        scanner.nextLine();
        water += waterToAdd;
        milk += milkToAdd;
        coffeeBeans += coffeeToAdd;
        disposableCups += cupsToAdd;
    }

    private void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }


    public void printState() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n", water);
        System.out.printf("%d ml of milk%n", milk);
        System.out.printf("%d g of coffee beans%n", coffeeBeans);
        System.out.printf("%d disposable cups%n", disposableCups);
        System.out.printf("$%d of money%n", money);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        coffeeMachine.run();
            }
}
