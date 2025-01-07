import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.util.Scanner;

public class Main extends Thread {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
//        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_time_awb.AlanVoiceDirectory");
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
//        Voice voice = VoiceManager.getInstance().getVoice("alan");
        Voice[] voicelist = VoiceManager.getInstance().getVoices();
        for (int i = 0; i < voicelist.length; i++) {
            System.out.println("voice " + voicelist[i].getName());
        }
        if (voice != null) {
            boolean b = true;
            voice.allocate();
            voice.setPitch(100);
            voice.setRate(250);
            System.out.println("Voice Rate" + voice.getRate());
            System.out.println("Voice Pitch" + voice.getPitch());
            System.out.println("Voice Volume" + voice.getVolume());
//            boolean status = voice.speak("238798");
//                LocalTime now = LocalTime.now();
            String s=String.valueOf((int) (Math.random() * 10000));
            boolean status = voice.speak(s);
//            System.out.println(String.valueOf(now));
            System.out.println("Status " + status);
            voice.deallocate();
            System.out.println("Enter the number");
            String n = sc.next();
            if (n.equals(s)){
                System.out.println("Verified");
            }
            else{
                System.out.println("Not Verified");
            }

//                currentThread().wait(1000);

        } else {
            System.out.println("Voice not found");
            return;
        }
    }
}
