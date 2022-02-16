package com.Projet.Android.typeEnum;

public enum typeDifficulty {
        EASY(""),
        MEDIUM(""),
        DIFFICULT("");

        private String level;

        typeDifficulty(String e) {
        }

        public String getLevel() {
            return level;
        }
}
