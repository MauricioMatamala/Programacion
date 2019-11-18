public class Song {
    private String songName;
    private String fileName;

    public Song(){

    }

    public Song(String songName){
        this.songName = songName;
    }

    public void setSongName(String songName){
        this.songName = songName;
    }

    public String getSongName(){
        return songName;
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
                "songName='" + songName + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
