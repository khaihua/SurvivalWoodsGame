package com.example.khai.survivalwoods;

public class Story {
    private Page[] mPages;

    public Story() {
        mPages = new Page[25];

        mPages[0] = new Page(
                R.drawable.survivalwoodsbackground,
                "You are driving to see your grandma when your car breaks down in the middle of the road. You are stranded in the forest and must get out. Food and water is limited; you must act fast.",
                new Choice("Continue", 1));

        mPages[1] = new Page(
                R.drawable.survivalwoodsbackground,
                "You start walking around the forest and come across a fork in the path. There is a river to the right, and a cave to the left.",
                new Choice("Go towards the river", 2),
                new Choice("Go towards the cave", 3));

        mPages[2] = new Page(
                R.drawable.survivalwoodsbackground,
                "You move towards the river, and stop on the bank. You see a sign on the other side, but can’t make out the words. However, the current is very strong at this time.",
                new Choice("Try to swim across the river", 4),
                new Choice("Wait for the current to die down", 5));

        mPages[3] = new Page(
                R.drawable.survivalwoodsbackground,
                "You move towards the cave, and go inside. You keep walking forward until you see another split in the path, veering to the right and left.",
                new Choice("Go towards the left path",7),
                new Choice("Go towards the right path", 4));

        mPages[4] = new Page(
                R.drawable.survivalwoodsbackground,
                "You were a fool for doing so. The current is too strong, you struggle and drown.",true);

        mPages[5] = new Page(
                R.drawable.survivalwoodsbackground,
                "You wait for the current to die down, then swim across the river. You walk to the sign. It reads:\n" +
                        "\n" +
                        "\t‘Beyond this lies Bear Territory. Proceed with caution. Nearest town 10 miles from here.’",
                new Choice("Go towards the town by passing through Bear Territory",6),
                new Choice("Go back", 24));

        mPages[6] = new Page(
                R.drawable.survivalwoodsbackground,
                "You start walking through the Bear Territory. You suddenly hear a rustle in the bushes.",
                new Choice("Keep walking forward.",24),
                new Choice("Go hide in some nearby bushes.",24));


        mPages[7] = new Page(
                R.drawable.survivalwoodsbackground,
                "You walk towards the left path, but step into a hole and fall.",
                new Choice("Try to climb out.",8),
                new Choice("Wait and see if someone will come save you by chance.",21));

        mPages[8] = new Page(
                R.drawable.survivalwoodsbackground,
                "You try to climb, but the rocks are too steep and sharp. You fall back down and hurt yourself. But as you hit the ground again the ground opens up again and you fall into a underground tunnel. You can go left or right.",
                new Choice("Go left.",24),
                new Choice("Go right.",24));

        mPages[9] = new Page(
                R.drawable.survivalwoodsbackground,
                "You walk through the right tunnel, and start to see light coming out from the end of it.",
                new Choice("Keep walking towards the end of the light.",24),
                new Choice("Go back.",24));

        mPages[10] = new Page(
                R.drawable.survivalwoodsbackground,
                "You whirl around, startled. \"What?\"\n" +
                        "The cat regards you curiously. \"Hmm? Are you going to eat this flan or what?\"\n" +
                        "You look back and forth between the cat and the flan.",
                new Choice("There's no way that was the flan talking. Dig in.",12),
                new Choice("Something's fishy here.",16));

        mPages[11] = new Page(
                R.drawable.survivalwoodsbackground,
                "You freeze, and the voice continues.  \"%s, don’t eat me!  This cat is a trickster!  He’s here to conquer your planet!\"",
                new Choice("Whaaa?!",10),
                new Choice("Okay, it’s way past time to run! RUN!",16));

        mPages[12] = new Page(
                R.drawable.survivalwoodsbackground,
                "You take a seat at the table and dig in to the flan while the cat starts telling you a crazy story about space travel and the future of its planet or something. You're not really listening, though, because your ears are ringing, and the room is getting dark....\n" +
                        "\n" +
                        "You wake to find yourself surrounded by flan of various shapes, sizes, and colors. \"LOOK AWAY!\" cries a chorus of tiny voices. \"Your gaze paralyzes our kind!\"",
                new Choice("No thank you, I've had enough crazy for tonight.",13),
                new Choice("I'm outnumbered...better obey the flan.",20));

        mPages[13] = new Page(
                R.drawable.survivalwoodsbackground,
                "You draw the line at talking cats! You plow forward through the flan wall, kicking left and right and scattering desserts to all corners of the living room. \"Please, %s! We're trying to help you!\" cries a flan from behind you. \"That's what the cat said, and now my kitchen is full of talking desserts!\" you retort. And where did that cat go, anyway?",
                new Choice("Check outside",14),
                new Choice("Check the house",15));

        mPages[14] = new Page(
                R.drawable.survivalwoodsbackground,
                "You make a beeline for the front door. In your haste to find the talking cat, you fail to notice the flan amassing behind you! A big voice booms out: \"%s, we tried to help you, even after you ate our brother...\" You turn to find a giant flan looming above you, and this time your gaze does nothing to stop it! \"Clearly you are much too narrow minded of a species to accept our wisdom. We will take this planet for our own and deal with the problem ourselves!\" The giant flan slithers closer to you....",
                new Choice("Accept your fate...",5),
                new Choice("Never give up!!  RUN!!!",5));

        mPages[15] = new Page(
                R.drawable.survivalwoodsbackground,
                "You run for the living room with the flan close behind. How do they move so fast? You turn to paralyze them, backing into the living room, but they're behind you too! Before you know it you're surrounded. Suddenly the cat appears! \"Get down!\" You duck as the cat unleashes a blinding rainbow light upon the room. The flan disintegrate." + "\n" + "\"Phew. I'm sorry, I had no idea eating the flan would incapacitate you. I thought it was an easy way to dispatch them. Will you hear me out?\"",
                new Choice("No way. You poisoned me with sentient flan! Run!",16),
                new Choice("Oh sure, why not.",17));

        mPages[16] = new Page(
                R.drawable.survivalwoodsbackground,
                "You're not trusting this cat! You run for the front door, but the cat beats you to it! The cat sighs. \"I had hoped our kinds could work together. But you humans are so primitive. My people will have to find another way to wipe out the flan. As for you...\"",
                new Choice("Wait, wait! I'll help!",19),
                new Choice("Pssh. What's the worst this cat can do?",22));

        mPages[17] = new Page(
                R.drawable.survivalwoodsbackground,
                "\"I have journeyed here to save you. The flan have destroyed my planet, and now they have come for yours. The flan and my people are mortal enemies, but we have no natural defense against them as you do. The weapon I just used is our only hope, and it must recharge for one of your Earth days. Alone, it appears we stand no chance. Together, we must make sure the entire invading force is destroyed!\"",
                new Choice("No. I don't trust you!",22),
                new Choice("Okay! Let's save the planet.",19));

        mPages[18] = new Page(
                R.drawable.survivalwoodsbackground,
                "\"Listen buddy, I don't--\"  The cat suddenly and slowly looks up at you.  \"Oh, uh, hi!  Didn’t see you there!  Why don’t you come in and have a chat with me?\"",
                new Choice("Talking cat.  Run!",6),
                new Choice("Well, since it asked so nicely...",8));

        mPages[19] = new Page(
                R.drawable.survivalwoodsbackground,
                "It's a strange alliance, but somehow it works. You and the cat take to the streets, hunting the flan in secret. It's more than a year before you're certain the flan invasion has been quashed, but your cat ally promises to stay in touch. It gives a final salute before you part ways the same as you met: in the kitchen at 2 AM.");

        mPages[20] = new Page(
                R.drawable.survivalwoodsbackground,
                "You obey the flan and stare at the ceiling.  A squishy, squelchy, gooey kind of sound builds behind you, and you feel...a presence.",
                new Choice("Turn around",5),
                new Choice("I can’t look!",5));

        mPages[21] = new Page(
                R.drawable.survivalwoodsbackground,
                "Before you can get very far, the cat explains in a rush: \"Stop!  I have journeyed here to save you! The flan have destroyed my planet, and now they have come for yours.  We must work together to stop them!\"",
                new Choice("No! I don't trust you!",22),
                new Choice("Ok! Let's save the planet!",19));

        mPages[22] = new Page(
                R.drawable.survivalwoodsbackground,
                "\"A pity we could not work together,\" laments the cat before it pounces.  You clearly underestimated it. Sleeper agent cats awaken across the world, and it's mere days before the flan invasion is ended and the entire human race is enslaved. If only you'd made better decisions...in the kitchen at 2 AM.");

        mPages[23] = new Page(
                R.drawable.survivalwoodsbackground,
                "It's far too early in the morning and you're far too preoccupied to deal with a crazy panhandler. You push past the guy and head for the police station. When the police come back to your house, the hobo is gone. All you find out of the ordinary is a rainbow scarf on the kitchen table. You'll never know what was going on...in the kitchen at 2 AM.");

        mPages[24] = new Page(
                R.drawable.survivalwoodsbackground,
                "Ow!  You snap awake in your bed, feeling strangely empty and cheated.  It’s as if you missed out on something important...in the kitchen at 2 AM.");

    }

    public Page getPage(int pageNumber) {
        return this.mPages[pageNumber];
    }
}
