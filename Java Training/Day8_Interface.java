
interface MusicPlayer
{
    void play();
    void stop();
    void change();;
}
class Spotify implements MusicPlayer
{
    public void play()
    {
        System.out.println("Spotify! Play Music...");
    }
    public void stop()
    {
        System.out.println("Spotify! Stop Music...");
    }
    public void change()
    {
        System.out.println("Spotify! Change Music...");
    }
    public void follow()
    {
        System.out.println("Spotify! Follow Artist...");
    }
}
class Hungama implements MusicPlayer
{
    public void play()
    {
        System.out.println("Hungama! Play Music...");
    }
    public void stop()
    {
        System.out.println("Hungama! Stop Music...");
    }
    public void change()
    {
        System.out.println("Hungama! Change Music...");
    }
    public void follow()
    {
        System.out.println("Hungama! Follow Artist...");
    }
}
public class  Day8_Interface
{
    public static void main(String[] args)
    {
        Spotify spot = new Spotify();
        spot.play();
        spot.stop();
        spot.change();
        spot.follow();

    }
}
