import javax.sound.midi.*;

public class MiniMinimusicPlayer {

    public static void main(String[] args) throws InvalidMidiDataException, InterruptedException {
        // write your code here
        MiniMinimusicPlayer mini = new MiniMinimusicPlayer();
        mini.play();

    }
    public void play() throws InvalidMidiDataException {

            try {
                Sequencer player = MidiSystem.getSequencer();
                player.open();
                Sequence seq = new Sequence(Sequence.PPQ, 4);
                Track track = seq.createTrack();



                track.add(makeEvent(144, 10, 10, 100, 1));
                player.setSequence(seq);
                player.start();

            } catch (MidiUnavailableException e) {
                e.printStackTrace();
            }



    }

    public static MidiEvent makeEvent (int comd, int chan, int one, int two,  int tick) {
        MidiEvent event =null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        }
        catch (Exception e) {}

        return event;


    }
}
