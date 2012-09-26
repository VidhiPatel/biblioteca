public class ExitAction extends Action {
    @Override
    public Boolean performAction() {

        return true;
    }

    ExitAction(Biblioteca biblioteca) {
        super(biblioteca);
    }
}
