package demo_utils;

public class Ui {
    private boolean running = true;
    public void mainMenuLoop() {



        while (this.running) {
            showMenu();
            switch(Input.getInt("Vælg 1-5: ")){
                case 1:  break;
                case 2:  break;
                case 3:  break;
                case 4:  break;
                case 5: this.running = false; break;
                default:
                    System.out.println("Du forsøger at tilgå et menupunkt der ikke eksistere"); break;
            }
        }
        System.out.println("Tak for denne gang!");
    }

    private void showMenu() {
        System.out.println("\n**** Marios pizzabar - HOVDEMENU ******");
        System.out.println("[1]Opret Ordre");
        System.out.println("[2]Vis menukort");
        System.out.println("[3]Vis en enkelt pizza");
        System.out.println("[4]Admin");
        System.out.println("[5]Afslut");
    }
}
