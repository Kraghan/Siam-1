package Siam.Sons;

import Siam.Enum.Theme;

import java.util.Random;

public class Musique extends Thread {

    private static Random random = new Random();

    private Thread thread;

    private MP3 dj;
    private String[] bandeSonStandard;
    private String[] bandeSonNoel;

    private Theme theme;

    public Musique(Theme theme){
        this.theme = theme;
        bandeSonStandard = new String[]{"res/Standard/Musiques/Standard1.mp3",
                                        "res/Standard/Musiques/Standard2.mp3",
                                        "res/Standard/Musiques/Standard3.mp3"};
        bandeSonNoel = new String[]{"res/Noel/Musiques/Noel1.mp3",
                                    "res/Noel/Musiques/Noel2.mp3",
                                    "res/Noel/Musiques/Noel3.mp3"};
    }

    public synchronized void start() {
        thread = new Thread(this, "Musique");
        thread.start();
    }

    public void run(){
        String[] bandeSon;
        switch (theme) {
            case STANDARD:
                bandeSon = bandeSonStandard;
                break;
            case NOEL:
                bandeSon = bandeSonNoel;
                break;
            default:
                bandeSon = null;
                break;
        }
        int nouvCompteur;
        int compteur = random.nextInt(bandeSon.length);
        dj = new MP3(bandeSon[compteur]);

        dj.play();

        while (true){

            if (dj == null) {
                return;
            }
            if (dj.getPlayer().isComplete()) {
                nouvCompteur = random.nextInt(bandeSon.length);

                while (compteur == nouvCompteur) {
                    nouvCompteur = random.nextInt(bandeSon.length);
                }

                compteur = nouvCompteur;

                dj = new MP3(bandeSon[compteur]);
            }

            dj.play();
        }
    }

    public void arret() {
        dj.stop();
        dj = null;
    }
}