public abstract class Action {
    Biblioteca biblioteca;

    Action(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    protected Action() {
    }

    public abstract Boolean performAction();

}
