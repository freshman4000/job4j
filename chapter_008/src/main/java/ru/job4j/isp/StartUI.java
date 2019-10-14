package ru.job4j.isp;

import ru.job4j.isp.inputs.Input;
import ru.job4j.isp.inputs.UserInput;
import ru.job4j.isp.menus.IMenu;
import ru.job4j.isp.menus.Menu;
import ru.job4j.isp.menus.MenuItem;

/**This class is responsible for starting user interface.
 */
public class StartUI {
    private IMenu menu;
    private Input input;

    /**
     * Constructor.
     * @param menu menu object passed to constructor.
     * @param input particular input.
     */
    public StartUI(IMenu menu, Input input) {
        this.menu = menu;
        this.input = input;
    }

    /**
     * Method that starts user interface and communicates with user, asking him(her) to input
     * the action number from displayed list. After user makes his(her) choice, this method
     * seeks in list of menu items, if name of command is in list. If it is, it does action
     * associated with this menu item.
     */
    public void start() {
        System.out.println("Choose action or type \"exit\":");
        menu.show();
        while (true) {
            boolean hasAnswer = false;
            String answer = input.getInput();
            if ("exit".equals(answer)) {
                break;
            }
            for (MenuItem item : menu.getMenuList()) {
                if (answer.equals(item.getName().split(" ")[0])) {
                    item.doAction();
                    hasAnswer = true;
                    break;
                }
            }
            System.out.println(hasAnswer ? "" : "No such command");
        }
    }

    /**
     * Application entrance point. It starts application.
     * @param args
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.init();
        new StartUI(menu, new UserInput()).start();
    }
}