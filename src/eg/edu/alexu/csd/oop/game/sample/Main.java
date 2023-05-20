package eg.edu.alexu.csd.oop.game.sample;

import MVC.Control;
import MVC.Model;
import MVC.view;

public class Main {

    public static void main(String[] args) {
        System.out.println("Uncomment any of the lines in the Main to run a new game, Have Fun :)");
        final Model model = new Model();
        final view view = new view() ;
        Control control = new Control(view, model);
        view.setVisible(true);
    }

}
