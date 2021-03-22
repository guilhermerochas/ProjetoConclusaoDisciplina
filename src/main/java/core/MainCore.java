package core;

import com.google.gson.Gson;
import models.LocalizacaoResult;
import services.LocalizarService;


public class MainCore {
	public static void main(String[] args) {
		LocalizarService req = new LocalizarService();
		String bodyResult = req.GET("http://localhost:3000/data").orElseThrow().body();
		LocalizacaoResult result = new Gson().fromJson(bodyResult, LocalizacaoResult.class);
		System.out.println(result);
		//MainPanel.main(args);
	}
}
