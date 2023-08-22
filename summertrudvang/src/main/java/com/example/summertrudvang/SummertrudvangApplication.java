package com.example.summertrudvang;

import com.example.summertrudvang.domain.Game;
import com.example.summertrudvang.domain.RuleCategory;
import com.example.summertrudvang.service.RuleBookService;
import com.example.summertrudvang.service.RuleService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

@SpringBootApplication
public class SummertrudvangApplication {


	@Autowired
	private RuleBookService ruleBookService;

	@Autowired
	private RuleService ruleService;

	public static void main(String[] args) {
		SpringApplication.run(SummertrudvangApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws IOException{
		createRuleBooks();
		createRules(importFile);
	} */

	private void createRuleBooks(){
		ruleBookService.createRuleBook("DoD", "Drakar och Demoner");
		ruleBookService.createRuleBook("DnD", "Dungeons and Dragons");
		ruleBookService.createRuleBook("CoC", "Call of Chutulu");
	}

	/**
	 * Create Rules from an external file
	 */

	private void createRules(String fileToImport) throws IOException {
		RuleFromFile.read(fileToImport).forEach(importedRule ->
				ruleService.createRule(
						importedRule.getRuleName(),
						importedRule.getDescription(),
						importedRule.getRulebook(),
						importedRule.getRuleCategory(),
						importedRule.getGame()));
	}


	private static class RuleFromFile{
		// Fields
		private String rulebook, ruleName, description, ruleCategory, game;
		// Reader
		static List<RuleFromFile> read(String fileToImport) throws IOException {
			return new ObjectMapper().setVisibility(FIELD, ANY).
					readValue(new FileInputStream(fileToImport), new TypeReference<List<RuleFromFile>>() {
					});
		}
		protected RuleFromFile() {}

		String getRulebook(){
			return rulebook;
		}
		String getRuleName(){
			return ruleName;
		}
		String getDescription(){
			return description;
		}
		RuleCategory getRuleCategory(){
			return RuleCategory.findByCategory(ruleCategory);
		}
		Game getGame(){
			return Game.valueOf(game);
		}
	}
}


