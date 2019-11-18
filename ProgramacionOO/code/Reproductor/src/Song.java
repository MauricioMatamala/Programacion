public class Song {
    private String songTitle;
    private String fileName;

    public Song(){

    }

    public Song(String songTitle){
        this.songTitle = songTitle;
    }

    public void setSongTitle(String songTitle){
        this.songTitle = songTitle;
    }

    public String getSongTitle(){
        return songTitle;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songName='" + songTitle + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
