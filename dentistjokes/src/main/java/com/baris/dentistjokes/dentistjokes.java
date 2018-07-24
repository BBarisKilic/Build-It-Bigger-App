package com.baris.dentistjokes;

import java.util.Random;

public class dentistjokes {

    private static String[] jokes = {
            "What Is a Dentist's Office?\n" +
                    "A filling station.","What Do Dentists Do on Roller Coasters?\n" +
            "Braces themselves.","How Did the Dentist Become a Brain Surgeon?\n" +
            "Their drill slipped.","What Did the Werewolf Eat after He Had His Teeth Taken Out?\n" +
            "The dentist.","How Do the Dentist and the Manicurist Fight?\n" +
            "Tooth and Nail. ","Why Should You Be Nice to Your Dentist?\n" +
            "Because they have fillings too.","What Does the Dentist of the Year Receive?\n" +
            "A little plaque. ", "What Time Do Most People Go to the Dentist?\n" +
            "At tooth hurty.", "What Did the Dentist Say to the Golfer?\n" +
            "\"You have a hole in one.\"","What Happens When You Get a Gold Tooth?\n" +
            "You put your money where your mouth is. ","What Was the Dentist Doing in Panama?\n" +
            "Looking for the Root Canal! ","What Do You Call a Dentist in the Army?\n" +
            "A drill sergeant.", "What Do Dentists Call X-Rays?\n" +
            "Tooth pics!","What Do Dentists Call X-Rays?\n" +
            "Tooth pics!", "What Did the Tooth Say to the Dentist on Vacation?\n" +
            "\"Just fill me in when you get back.\"", "What Happens When You Go to the Dentist Multiple Times?\n" +
            "You know the drill.","\n" +
            "Why Do Dentists Seem Moody?\n" +
            "Because they always look down in the mouth.","What's a Toothache?\n" +
            "A pain that drives people to extraction.","Who Has the Most Dangerous Job in Transylvania?\n" +
            "Dracula's dentist.","\n" +
            "What's the Difference Between a Dentist and a Sadist?\n" +
            "A dentist has newer magazines!", "What Did the Dentist See at the North Pole?\n" +
            "A molar bear!","Why Do Dentists like Potatoes?\n" +
            "Because they're so filling. ","What Game Did the Dentist Play When She Was a Child?\n" +
            "Caps and robbers.","Why Was the Dentist Considered a Guru?\n" +
            "They had their own  flossify on how to keep teeth clean.","Why Did the Buddhist Refuse Novocaine During a Root Canal?\n" +
            "They wanted to transcend dental medication!"
    };

    public dentistjokes() {
    }

    public static String getJoke() {
        return jokes[new Random().nextInt(jokes.length)];
    }
}
