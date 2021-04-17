package Server;



public class Translator {

	public String translator(String language, String text) {
		
		String translatedtext = "text";
		
	switch(text) {
	case "Good morning"://Good morning
	{
		if(language.equals("Bahasa Malayu"))
			translatedtext ="Selamat pagi";
		else if(language.equals("Arabic"))
			translatedtext ="الخير صباح";
		else if(language.equals("korea"))
			translatedtext ="좋은 아침";
		else
		   translatedtext = "message error";
	}
	break;
	case "Good night"://Good night
	{
		if(language.equals("Bahasa Malayu"))
			translatedtext ="Selamat malam";
		if(language.equals("Arabic"))
			translatedtext ="مساؤك طاب";
		if(language.equals("korea"))
			translatedtext ="안녕히 주무세요";
	}
	break;
	case "How are you?"://How are you?
	{
		if(language.equals("Bahasa Malayu"))
			translatedtext ="Apa khabar?";
		if(language.equals("Arabic"))
			translatedtext =" حالك؟ ك";
		if(language.equals("korea"))
			translatedtext ="어떻게 지내세요?";
	}
	break;
	case "Thank you"://Thank you
	{
		if(language.equals("Bahasa Malayu"))
			translatedtext ="Terima kasih";
		if(language.equals("Arabic"))
			translatedtext =" لك شك";
		if(language.equals("korea"))
			translatedtext ="감사합니다";
	}
	break;
	case "Goodbye"://Goodbye
	{
		if(language.equals("Bahasa Malayu"))
			translatedtext ="Selamat tinggal";
		if(language.equals("Arabic"))
			translatedtext =" السالمة مع";
		if(language.equals("korea"))
			translatedtext ="안녕";
	}
	break;
	case "What’s up?"://What’s up?
	{
		if(language.equals("Bahasa Malayu"))
			translatedtext ="Ada apa?";
		if(language.equals("Arabic"))
			translatedtext =" أخبارك؟ م";
		if(language.equals("korea"))
			translatedtext ="뭐야?";
	}
	break;
	default:
		translatedtext = "Message wrong";
		break;
	}
		
		
		return translatedtext;
	}
	
	
	}
