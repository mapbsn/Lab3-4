package items;

import items.states.ItemState;

public class Bed extends Item {


    public Bed(String name) {
        super(name);
    }

    public void littered() {
        setState(ItemState.DIRTY);
        System.out.printf("The foot of the %s was littered with needles.", name);
    }

    public static class Blanket extends Bed {

        public Blanket(String name) {
            super(name);
        }

        public void beOkay() {
            setState(ItemState.DEFAULT);
            System.out.printf("%s were okay.", name);
        }
    }

    public static class Rug extends Bed {


        public Rug(String name) {
            super(name);
        }

        @Override
        public String getDescription() {
            return "hooked";
        }
    }

    public static class Sheets extends Bed {
        public Sheets(String name) {
            super(name);
        }
        public void beDirty() {
            setState(ItemState.DIRTY);
            System.out.printf("The %s were mucky and dirty.", name);
        }

        public String getDescription() {
            return "the bedclothes off the bed.";
        }
    }


}
