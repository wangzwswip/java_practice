import javax.sound.midi.*;
public class MiniMusicCmdLine {
    public static void main(String[] args){
        MiniMusicCmdLine mini = new MiniMusicCmdLine();
        if (args.length < 2){
            System.out.println("Don't forget the instrument and note args");
        }else {
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mini.play(instrument,note);
        }
    }//关闭main

    public void play(int instrument, int note) {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track track = seq.createTrack();

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(192,1,instrument,0);
            MidiEvent changeInstrument = new MidiEvent(first,1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,note,100);
            MidiEvent noteOn = new MidiEvent(a,1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,note,100);
            MidiEvent noteoff = new MidiEvent(b,16);
            track.add(noteoff);
            player.setSequence(seq);
            player.start();
        }catch (Exception ex) {ex.printStackTrace();}
    }//关闭播放
}//关闭类
