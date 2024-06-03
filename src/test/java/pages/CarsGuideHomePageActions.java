package pages;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import hooks.SeleniumDriver;
import org.testng.Assert;
import pagesLocators.CarsGuideHomePageLocators;
import utilities.CommonActions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CarsGuideHomePageActions {
	CarsGuideHomePageLocators carsGuideHomePageLocators = null;
	CommonActions commonActions;
	
	public CarsGuideHomePageActions() {
		this.carsGuideHomePageLocators = new CarsGuideHomePageLocators();
		this.commonActions = new CommonActions();
		PageFactory.initElements(SeleniumDriver.getWebDriver(), carsGuideHomePageLocators);
	}
	
	public void verifyTheLogoIsPresent() throws IOException, InterruptedException {
		//commonActions.checkIfElementIsDisplayed(carsGuideHomePageLocators.carsGuideHomePageLogo);
		FileReader file = new FileReader("C:\\Users\\mdsai\\eclipse-workspace\\testPlace\\LearningCurveUIs\\db.json");

		BufferedReader br = new BufferedReader(file);
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line).append("\n");
		}
		br.close();
		String fileContent = sb.toString();

		List<List<String>> tableData = extractTableData(carsGuideHomePageLocators.table);
		List<List<String>> jsonData = parseJson(fileContent);

		boolean isDataMatched = compareData(tableData, jsonData);
		// Print result
		if (isDataMatched) {
			System.out.println("Table data matches JSON response.");
		} else {
			System.out.println("Table data does not match JSON response.");
		}

		clickOnColumnHeaderAndValidateTheColumnIsSorted(carsGuideHomePageLocators.table);
	}


	public void verifySeachFieldIsPresent() {
		commonActions.checkIfElementIsDisplayed(carsGuideHomePageLocators.searchFeild);
	}
	
	public void verifySellMyCarButton() {
		commonActions.checkIfElementIsDisplayed(carsGuideHomePageLocators.sellMyCarButton);
	}
	
	public void verifyShortListButtonIsPresent() {
		commonActions.checkIfElementIsDisplayed(carsGuideHomePageLocators.myShortlistButton);
	}
	
	public void verifySignUpButtonIsPresent() {
		commonActions.checkIfElementIsDisplayed(carsGuideHomePageLocators.signUpButton);
	}

	public static List<List<String>> extractTableData(WebElement table) {
		List<List<String>> tableData = new ArrayList<>();
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Start iterating from the second row (skipping the first row)
		for (int i = 1; i < rows.size(); i++) {
			WebElement row = rows.get(i); // Get the current row
			List<String> rowData = new ArrayList<>();
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				rowData.add(cell.getText());
			}
			tableData.add(rowData);
		}
		return tableData;
	}

	public static List<List<String>> parseJson(String jsonResponse) {
		List<List<String>> jsonData = new ArrayList<>();
		JSONObject jsonObject = new JSONObject(jsonResponse);
		JSONArray dataArray = jsonObject.getJSONArray("data");

		for (int i = 0; i < dataArray.length(); i++) {
			JSONObject dataObject = dataArray.getJSONObject(i);
			List<String> rowData = new ArrayList<>();
			rowData.add(dataObject.getString("name"));
			rowData.add(dataObject.getString("salary"));
			rowData.add(dataObject.getString("extension"));
			rowData.add(dataObject.getString("startDate"));
			rowData.add(dataObject.getString("startDateA"));
			jsonData.add(rowData);
		}
		return jsonData;
	}

	public static boolean compareData(List<List<String>> tableData, List<List<String>> jsonData) {

		sortList(tableData);
		sortList(jsonData);

		if (tableData.size() != jsonData.size()) {
			return false;
		}

		for (int i = 0; i < tableData.size(); i++) {
			List<String> tableRow = tableData.get(i);
			List<String> jsonRow = jsonData.get(i);

			if (!tableRow.equals(jsonRow)) {
				return false;
			}
		}

		return true;
	}

	private static void sortList(List<List<String>> list) {
		list.sort((row1, row2) -> {
			// Compare the first elements of each row
			String element1 = row1.get(0);
			String element2 = row2.get(0);
			return element1.compareTo(element2);
		});
	}

	public void clickOnColumnHeaderAndValidateTheColumnIsSorted(WebElement table) {
		List<String> columnData = new ArrayList<String>();
		List<WebElement> headers = table.findElements(By.xpath("thead/tr/th"));
		List<WebElement> rowCount = table.findElements(By.xpath("tbody/tr/td[1]"));
					for(int i=0;i<headers.size();i++) {
						headers.get(i).click();
						for(int j=1;j<rowCount.size()+1;j++) {
								columnData.add(table.findElement(By.xpath("tbody/tr[" + j + "]/td[" + (i + 1) + "]")).getText());
						}
						List<String> sortedColumn = new ArrayList<String>(columnData);
						if(columnData.get(0).startsWith("$")) {
							Collections.sort(sortedColumn, (s1, s2) -> {
								double amount1 = Double.parseDouble(s1.replace("$", ""));
								double amount2 = Double.parseDouble(s2.replace("$", ""));
								return Double.compare(amount1, amount2);
							});
						}else if(columnData.get(0).contains("/")){
							Collections.sort(sortedColumn, (s1, s2) -> {
								DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
								try {
									Date date1 = dateFormat.parse(s1);
									Date date2 = dateFormat.parse(s2);
									return date1.compareTo(date2);
								} catch (ParseException e) {
									e.printStackTrace();
									return 0; // Handle parse exception
								}
							});
						}else{
							Collections.sort(sortedColumn);
						}
						System.out.println("columnData:"+columnData);
						System.out.println("sortedColumn:"+sortedColumn);
						Assert.assertEquals(columnData, sortedColumn);
						columnData.clear();
					}
		}



}
