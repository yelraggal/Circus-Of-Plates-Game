package MVC;

public class Control {
    public view view;
    public Model model;
    public Control(view view , Model model)
    {
        this.view=view;
        this.model=model;
        this.view.setLevels(this.model.getLevels());
    }

}
