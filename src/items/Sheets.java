package items;

import interfaces.Dirtiable;

public class Sheets extends Item implements Dirtiable {
        public Sheets(int x, int y) {
            super(3, x, y);
        }

        @Override
        public String toString() {
            return "sheets";
        }

        public String getDescription() {
            return "the bedclothes off the bed.";
        }

        private int dirtinessLevel;

        @Override
        public void adjustDirtiness(int level) {
            dirtinessLevel += level;
        }

        @Override
        public void decreaseDirtiness(int level) {
            dirtinessLevel -= level;
        }
        public void beDirty() {
            this.adjustDirtiness(5);
            System.out.printf("The %s were mucky and dirty.", this.toString());
        }
    }

