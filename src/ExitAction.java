public class ExitAction extends Action {
    public ExitAction() {
    }

    @Override
    public Boolean performAction() {

        return true;
    }

    ExitAction(Biblioteca biblioteca) {
        super(biblioteca);
    }
}
