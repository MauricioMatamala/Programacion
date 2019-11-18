public class Player {

    public void play(Song song){
        System.out.println("Reproduciendo canción " + song.getFileName());
    }

    public void stop(Song song){
        System.out.println(song.getFileName() + "detenida");
    }
}
