package speechtotext;

import java.io.File;

import java.io.FileNotFoundException;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechRecognitionResults;

public class SpeechtoText_main {
	MySQL mysql = new MySQL();

	
	public static void main(String[] args) {
		    SpeechToText service = new SpeechToText();
		    service.setUsernameAndPassword("ecea0172-83cb-40f3-bbfb-e8c2e5b44b8e", "sJQNQ6epkYIh");
		    
		    File audio = new File("audio/sample.mp3");
		    //言語の指定が出来るらしい。
		    RecognizeOptions options = null;
			try {
				options = new RecognizeOptions.Builder()
						.model("ja-JP_BroadbandModel")
				        .audio(audio)
				        //.contentType(RecognizeOptions.ContentType.AUDIO_WAV)
				        .contentType(RecognizeOptions.ContentType.AUDIO_MP3)				        
				        .build();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        SpeechRecognitionResults transcript = service.recognize(options).execute();

		    System.out.println(transcript);//ここが階層構造
		    
		    /*
		    String s = String.valueOf(result);
		    ObjectMapper mapper = new ObjectMapper();
		    JsonNode node = mapper.readTree(s);
		    */
		    
		    
		    

	 }
    
}
