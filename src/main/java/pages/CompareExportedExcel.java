package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import POM.HomepagePOM;
import base.SuperTestNG;

public class CompareExportedExcel extends SuperTestNG {

	private File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	public void CompareExcel() throws Exception {
		HomepagePOM H = new HomepagePOM(driver);
		int menucount = H.leftsidemenus().size();
		String user = H.userprofilename().getText();

		File file = getLatestFilefromDir(Exceldownloadpath);

		FileInputStream fileInputStream1 = new FileInputStream(new File(String.valueOf(file)));
		HSSFWorkbook workbook1 = new HSSFWorkbook(fileInputStream1);
		HSSFSheet worksheet1 = workbook1.getSheetAt(0);
		int rowCount1 = worksheet1.getPhysicalNumberOfRows();
		FileInputStream fileInputStream2;

		if (menucount == Integer.parseInt(prop.getProperty("Superadminmenucount")) && user.equalsIgnoreCase(prop.getProperty("superAdmin"))) {
			fileInputStream2 = new FileInputStream(xlpath2);
		} else if (menucount == Integer.parseInt(prop.getProperty("AdminMenucount"))) {
			fileInputStream2 = new FileInputStream(xlpath3);
		} else if (menucount == Integer.parseInt(prop.getProperty("customerMenuCount"))) {
			fileInputStream2 = new FileInputStream(xlpath4);
		} else {
			fileInputStream2 = new FileInputStream(xlpath5);
		}

		HSSFWorkbook workbook2 = new HSSFWorkbook(fileInputStream2);
		HSSFSheet worksheet2 = workbook2.getSheetAt(0);
		int rowCount2 = worksheet2.getPhysicalNumberOfRows();

		if (rowCount1 == rowCount2) {
			for (int i = 1; i < rowCount1; i++) {

				HSSFRow row1 = worksheet1.getRow(i);
				HSSFRow row2 = worksheet2.getRow(i);
//------------------------------ Comparing SALE TYPE Column --------------------------  
				String saletypestring1 = "";
				HSSFCell saletype1 = row1.getCell(0);
				if (saletype1 != null) {
					saletype1.setCellType(CellType.STRING);
					saletypestring1 = saletype1.getStringCellValue().trim().toLowerCase();
				}

				String saletypestring2 = "";
				HSSFCell saletype2 = row2.getCell(0);
				if (saletype2 != null) {
					saletype2.setCellType(CellType.STRING);
					saletypestring2 = saletype2.getStringCellValue().trim().toLowerCase();
				}

				if (!saletypestring1.equals(saletypestring2)) {
					System.out.println("[ERROR] :" + "Diference for Saletype (book1) " + saletypestring1
							+ "| Book 1 SaleType = " + saletypestring1 + " | Book 2 SaleType = " + saletypestring2);

				}
//------------------------------ Comparing Order Number Column -------------------------- 
				String Orderno1 = "";
				HSSFCell Order1 = row1.getCell(1);
				if (Order1 != null) {
					Order1.setCellType(CellType.STRING);
					Orderno1 = Order1.getStringCellValue().trim().toLowerCase();
				}

				String Orderno2 = "";
				HSSFCell Order2 = row2.getCell(1);
				if (Order2 != null) {
					Order2.setCellType(CellType.STRING);
					Orderno2 = Order2.getStringCellValue().trim().toLowerCase();
				}

				if (!Orderno1.equals(Orderno2)) {
					System.out.println("[ERROR] :" + "Diference for Order Number (book1) " + Orderno1
							+ "| Book 1 Order Number = " + Orderno1 + " | Book 2 SaleType = " + Orderno2);

				}
//------------------------------ Comparing Web Invoice Number Column --------------------------
				String webinv1 = "";
				HSSFCell web1 = row1.getCell(2);
				if (web1 != null) {
					web1.setCellType(CellType.STRING);
					webinv1 = web1.getStringCellValue().trim().toLowerCase();
				}

				String webinv2 = "";
				HSSFCell web2 = row2.getCell(2);
				if (web2 != null) {
					web2.setCellType(CellType.STRING);
					webinv2 = web2.getStringCellValue().trim().toLowerCase();
				}

				if (!webinv1.equals(webinv2)) {
					System.out.println("[ERROR] :" + "Diference for Web Invoice (book1) " + webinv1
							+ "| Book 1 WEb Invoice Number = " + webinv1 + " | Book 2 Web Invoce Number = " + webinv2);

				}
//------------------------------ Comparing Invoice Received Date Column --------------------------
				String inv_received_date1 = "";
				HSSFCell invrecieved1 = row1.getCell(3);
				if (invrecieved1 != null) {
					invrecieved1.setCellType(CellType.STRING);
					inv_received_date1 = invrecieved1.getStringCellValue().trim().toLowerCase();
					SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd");
					Date date = sdfSource.parse(inv_received_date1);
					SimpleDateFormat sdfDestination = new SimpleDateFormat("MM/dd/yyyy");
					inv_received_date1 = sdfDestination.format(date);
				}

				String inv_received_date2 = "";
				HSSFCell invrecieved2 = row2.getCell(3);
				if (invrecieved2 != null) {
					invrecieved2.setCellType(CellType.STRING);
					inv_received_date2 = invrecieved2.getStringCellValue().trim().toLowerCase();
				}

				if (!inv_received_date1.equals(inv_received_date2)) {
					System.out.println("[ERROR] :" + "Diference for Invoice Riceived date (book1) " + inv_received_date1
							+ "| Book 1 WEb Invoice Received date = " + inv_received_date1
							+ " | Book 2 Invoice Received date = " + inv_received_date2);

				}
//------------------------------ Comparing Web Invoice Date Column --------------------------
				String web_inv_date1 = "";
				HSSFCell webinvoice1 = row1.getCell(4);
				if (webinvoice1 != null) {
					webinvoice1.setCellType(CellType.STRING);
					web_inv_date1 = webinvoice1.getStringCellValue().trim().toLowerCase();

					SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd");
					Date date = sdfSource.parse(web_inv_date1);
					SimpleDateFormat sdfDestination = new SimpleDateFormat("MM/dd/yyyy");
					web_inv_date1 = sdfDestination.format(date);
				}

				String web_inv_date2 = "";
				HSSFCell webinvoice2 = row2.getCell(4);
				if (webinvoice2 != null) {
					webinvoice2.setCellType(CellType.STRING);
					web_inv_date2 = webinvoice2.getStringCellValue().trim().toLowerCase();
				}

				if (!web_inv_date1.equals(web_inv_date2)) {
					System.out.println("[ERROR] :" + "Diference for Web invoice date (book1) " + web_inv_date1
							+ "| Book 1  Web invoice date = " + web_inv_date1 + " | Book 2  Web invoice date = "
							+ web_inv_date2);

				}

//------------------------------ Comparing Order Receipt Time  Column --------------------------
				String order_receipt_time_in_wh1 = "";
				HSSFCell ordetime1 = row1.getCell(5);
				if (ordetime1 != null) {
					ordetime1.setCellType(CellType.STRING);
					order_receipt_time_in_wh1 = ordetime1.getStringCellValue().trim().toLowerCase();
				}

				String order_receipt_time_in_wh2 = "";
				HSSFCell ordetime2 = row2.getCell(5);
				if (ordetime2 != null) {
					ordetime2.setCellType(CellType.STRING);
					order_receipt_time_in_wh2 = ordetime2.getStringCellValue().trim().toLowerCase();
				}

				if (!order_receipt_time_in_wh1.equals(order_receipt_time_in_wh2)) {
					System.out.println("[ERROR] :" + "Diference for Order Receipt time (book1) "
							+ order_receipt_time_in_wh1 + "| Book 1  Order Receipt time = " + order_receipt_time_in_wh1
							+ " | Book 2  Order Receipt time = " + order_receipt_time_in_wh2);

				}

//------------------------------ Comparing CS Time TAT  Column --------------------------
				String cs_team_tat1 = "";
				HSSFCell cstat1 = row1.getCell(6);
				if (cstat1 != null) {
					cstat1.setCellType(CellType.STRING);
					cs_team_tat1 = cstat1.getStringCellValue().trim().toLowerCase();
				}

				String cs_team_tat2 = "";
				HSSFCell cstat2 = row2.getCell(6);
				if (cstat2 != null) {
					cstat2.setCellType(CellType.STRING);
					cs_team_tat2 = cstat2.getStringCellValue().trim().toLowerCase();
				}

				if (!cs_team_tat1.equals(cs_team_tat2)) {
					System.out.println("[ERROR] :" + "Diference for CS team TAT (book1) " + cs_team_tat1
							+ "| Book 1  CS team TAT = " + cs_team_tat1 + " | Book 2  CS team TAT = " + cs_team_tat2);

				}
//------------------------------ Comparing Invoice QTY  Column --------------------------
				String inv_qty1 = "";
				HSSFCell invqty1 = row1.getCell(7);
				if (invqty1 != null) {
					invqty1.setCellType(CellType.STRING);
					inv_qty1 = invqty1.getStringCellValue().trim().toLowerCase();
				}

				String inv_qty2 = "";
				HSSFCell invqty2 = row2.getCell(7);
				if (invqty2 != null) {
					invqty2.setCellType(CellType.STRING);
					inv_qty2 = invqty2.getStringCellValue().trim().toLowerCase();
				}

				if (!inv_qty1.equals(inv_qty2)) {
					System.out.println("[ERROR] :" + "Diference for Invoice QAT (book1) " + inv_qty1
							+ "| Book 1  Invoice QAT = " + inv_qty1 + " | Book 2  Invoice QAT = " + inv_qty2);

				}

//------------------------------ Comparing Invoice Value  Column --------------------------
				String inv_value1 = "";
				HSSFCell invvalue1 = row1.getCell(8);
				if (invvalue1 != null) {
					invvalue1.setCellType(CellType.STRING);
					inv_value1 = invvalue1.getStringCellValue().trim().toLowerCase();
				}

				String inv_value2 = "";
				HSSFCell invvalue2 = row2.getCell(8);
				if (invvalue2 != null) {
					invvalue2.setCellType(CellType.STRING);
					inv_value2 = invvalue2.getStringCellValue().trim().toLowerCase();
				}

				if (!inv_value1.equals(inv_value2)) {
					System.out.println("[ERROR] :" + "Diference for Invoice Value (book1) " + inv_value1
							+ "| Book 1  Invoice Value = " + inv_value1 + " | Book 2  Invoice Value = " + inv_value2);

				}
// ------------------------------ Comparing Number of Boxes Column --------------------------
				String no_of_boxes1 = "";
				HSSFCell noofboxes1 = row1.getCell(9);
				if (noofboxes1 != null) {
					noofboxes1.setCellType(CellType.STRING);
					no_of_boxes1 = noofboxes1.getStringCellValue().trim().toLowerCase();
				}

				String no_of_boxes2 = "";
				HSSFCell noofboxes2 = row2.getCell(9);
				if (noofboxes2 != null) {
					noofboxes2.setCellType(CellType.STRING);
					no_of_boxes2 = noofboxes2.getStringCellValue().trim().toLowerCase();
				}

				if (!no_of_boxes1.equals(no_of_boxes2)) {
					System.out.println("[ERROR] :" + "Diference for Number of Boxes (book1) " + no_of_boxes1
							+ "| Book 1  Number of Boxes = " + no_of_boxes1 + " | Book 2 Number of Boxes = "
							+ no_of_boxes2);

				}
// ------------------------------ Comparing Distributor Name Column--------------------------
				String distributor_name1 = "";
				HSSFCell distributorname1 = row1.getCell(10);
				if (distributorname1 != null) {
					distributorname1.setCellType(CellType.STRING);
					distributor_name1 = distributorname1.getStringCellValue().trim().toLowerCase();
				}

				String distributor_name2 = "";
				HSSFCell distributorname2 = row2.getCell(10);
				if (distributorname2 != null) {
					distributorname2.setCellType(CellType.STRING);
					distributor_name2 = distributorname2.getStringCellValue().trim().toLowerCase();
				}

				if (!distributor_name1.equals(distributor_name2)) {
					System.out.println("[ERROR] :" + "Diference for Distributor Name (book1) " + distributor_name1
							+ "| Book 1  Distributor Name = " + distributor_name1 + " | Book 2 Distributor Name = "
							+ distributor_name2);

				}
// ------------------------------ Comparing Distributor ID Column--------------------------
				String distributor_id1 = "";
				HSSFCell distributorid1 = row1.getCell(11);
				if (distributorid1 != null) {
					distributorid1.setCellType(CellType.STRING);
					distributor_id1 = distributorid1.getStringCellValue().trim().toLowerCase();
				}

				String distributor_id2 = "";
				HSSFCell distributorid2 = row2.getCell(11);
				if (distributorid2 != null) {
					distributorid2.setCellType(CellType.STRING);
					distributor_id2 = distributorid2.getStringCellValue().trim().toLowerCase();
				}

				if (!distributor_id1.equals(distributor_id2)) {
					System.out.println("[ERROR] :" + "Diference for Distributor ID (book1) " + distributor_id1
							+ "| Book 1 Distributor ID = " + distributor_id1 + " | Book 2 Distributor ID = "
							+ distributor_id2);

				}
// ------------------------------ Comparing Distributor phone Column--------------------------
				String distributor_phone1 = "";
				HSSFCell distributorphone1 = row1.getCell(12);
				if (distributorphone1 != null) {
					distributorphone1.setCellType(CellType.STRING);
					distributor_phone1 = distributorphone1.getStringCellValue().trim().toLowerCase();
				}

				String distributor_phone2 = "";
				HSSFCell distributorphone2 = row2.getCell(12);
				if (distributorphone2 != null) {
					distributorphone2.setCellType(CellType.STRING);
					distributor_phone2 = distributorphone2.getStringCellValue().trim().toLowerCase();
				}

				if (!distributor_phone1.equals(distributor_phone2)) {
					System.out.println("[ERROR] :" + "Diference for Distributor phone (book1) " + distributor_phone1
							+ "| Book 1 Distributor phone = " + distributor_phone1 + " | Book 2 Distributor phone = "
							+ distributor_phone2);

				}

// ------------------------------ Comparing Location Column--------------------------
				String Location1 = "";
				HSSFCell Locat1 = row1.getCell(13);
				if (Locat1 != null) {
					Locat1.setCellType(CellType.STRING);
					Location1 = Locat1.getStringCellValue().trim().toLowerCase();
				}

				String Location2 = "";
				HSSFCell Locat2 = row2.getCell(13);
				if (Locat2 != null) {
					Locat2.setCellType(CellType.STRING);
					Location2 = Locat2.getStringCellValue().trim().toLowerCase();
				}

				if (!Location1.equals(Location2)) {
					System.out.println("[ERROR] :" + "Diference for Location (book1) " + Location1
							+ "| Book 1 Location = " + Location1 + " | Book 2 Location = " + Location2);

				}
// ------------------------------ Comparing Area pin code Column--------------------------
				String area_pin_code1 = "";
				HSSFCell areapincode1 = row1.getCell(14);
				if (areapincode1 != null) {
					areapincode1.setCellType(CellType.STRING);
					area_pin_code1 = areapincode1.getStringCellValue().trim().toLowerCase();
				}

				String area_pin_code2 = "";
				HSSFCell areapincode2 = row2.getCell(14);
				if (areapincode2 != null) {
					areapincode2.setCellType(CellType.STRING);
					area_pin_code2 = areapincode2.getStringCellValue().trim().toLowerCase();
				}

				if (!area_pin_code1.equals(area_pin_code2)) {
					System.out.println("[ERROR] :" + "Diference for Area pin code (book1) " + area_pin_code1
							+ "| Book 1 Area pin code = " + area_pin_code1 + " | Book 2 Area pin code = "
							+ area_pin_code2);

				}
// ------------------------------ Comparing State Column--------------------------
				String State1 = "";
				HSSFCell st1 = row1.getCell(15);
				if (st1 != null) {
					st1.setCellType(CellType.STRING);
					State1 = st1.getStringCellValue().trim().toLowerCase();
				}

				String State2 = "";
				HSSFCell st2 = row2.getCell(15);
				if (st2 != null) {
					st2.setCellType(CellType.STRING);
					State2 = st2.getStringCellValue().trim().toLowerCase();
				}

				String IsoState = "";
				HashMap<String, String> countryCapitalMap = new HashMap<String, String>();
				countryCapitalMap.put("Andaman Nicobar", "AN");
				countryCapitalMap.put("Andhra Pradesh", "AP");
				countryCapitalMap.put("Arunachal Pradesh", "AR");
				countryCapitalMap.put("Bihar", "BR");
				countryCapitalMap.put("Chandigarh", "CH");
				countryCapitalMap.put("Chhattisgarh", "CT");
				countryCapitalMap.put("Daman and Diu", "DD");
				countryCapitalMap.put("Delhi", "DL");
				countryCapitalMap.put("Dadra and Nagar Haveli", "DN");
				countryCapitalMap.put("Goa", "GA");
				countryCapitalMap.put("Gujarat", "GJ");
				countryCapitalMap.put("Haryana", "HR");
				countryCapitalMap.put("Himachal Pradesh", "HP");
				countryCapitalMap.put("Jammu and Kashmir", "JK");
				countryCapitalMap.put("Jharkhand", "JH");
				countryCapitalMap.put("Karnataka", "KA");
				countryCapitalMap.put("Kerala", "KL");
				countryCapitalMap.put("Lakshadweep", "LD");
				countryCapitalMap.put("Madhya Pradesh", "MP");
				countryCapitalMap.put("Maharashtra", "MH");
				countryCapitalMap.put("Manipur", "MN");
				countryCapitalMap.put("Meghalaya", "ML");
				countryCapitalMap.put("Mizoram", "MZ");
				countryCapitalMap.put("Nagaland", "NL");
				countryCapitalMap.put("Orissa", "OR");
				countryCapitalMap.put("Punjab", "PB");
				countryCapitalMap.put("pondicherry", "PY");
				countryCapitalMap.put("Rajasthan", "RJ");
				countryCapitalMap.put("Sikkim", "SK");
				countryCapitalMap.put("Tamilnadu", "TN");
				countryCapitalMap.put("Telangana", "TG");
				countryCapitalMap.put("Tripura", "TR");
				countryCapitalMap.put("Uttarakhand", "UT");
				countryCapitalMap.put("uttaranchal", "UK");
				countryCapitalMap.put("Uttar Pradesh", "UP");
				countryCapitalMap.put("WestBengal", "WB");

				for (String countryKey : countryCapitalMap.keySet()) {
					if (countryKey.trim().toLowerCase().equals(State2)) {
						IsoState = countryCapitalMap.get(countryKey).trim().toLowerCase();
						break;
					}

				}

				if (!State1.equals(IsoState)) {
					System.out.println("[ERROR] :" + "Diference for State (book1) " + State1 + "| Book 1 State = "
							+ State1 + " | Book 2 State = " + IsoState);

				}
// ------------------------------ Comparing regional zone name Column--------------------------

				String rz = "";
				HSSFCell zone1 = row1.getCell(16);
				if (zone1 != null) {
					zone1.setCellType(CellType.STRING);
					rz = zone1.getStringCellValue().trim().toLowerCase();
				}

				String rz1 = "";
				HSSFCell zone2 = row2.getCell(16);
				if (zone2 != null) {
					zone2.setCellType(CellType.STRING);
					rz1 = zone2.getStringCellValue().trim().toLowerCase();
				}

				if (!rz.equals(rz1)) {
					System.out.println("[ERROR] :" + "Diference for Regional Zone Time (book1) " + rz
							+ "| Book 1 Regional Zone Time = " + rz + " | Book 2 Regional Zone Time = " + rz1);

				}
// ------------------------------ Comparing Remarks Column--------------------------
				String Remark1 = "";
				HSSFCell rem1 = row1.getCell(17);
				if (rem1 != null) {
					rem1.setCellType(CellType.STRING);
					Remark1 = rem1.getStringCellValue().trim().toLowerCase();
				}

				String Remark2 = "";
				HSSFCell rem2 = row2.getCell(17);
				if (rem2 != null) {
					rem2.setCellType(CellType.STRING);
					Remark2 = rem2.getStringCellValue().trim().toLowerCase();
				}

				if (!Remark1.equals(Remark2)) {
					System.out.println("[ERROR] :" + "Diference for Remarks (book1) " + Remark1 + "| Book 1 Remarks = "
							+ Remark1 + " | Book 2 Remarks = " + Remark2);

				}

// ------------------------------ Comparing Warehouse Column--------------------------
				String warehouse1 = "";
				HSSFCell wh1 = row1.getCell(18);
				if (wh1 != null) {
					wh1.setCellType(CellType.STRING);
					warehouse1 = wh1.getStringCellValue().trim().toLowerCase();
				}

				String warehouse2 = "";
				HSSFCell wh2 = row2.getCell(18);
				if (wh2 != null) {
					wh2.setCellType(CellType.STRING);
					warehouse2 = wh2.getStringCellValue().trim().toLowerCase();
				}

				if (!warehouse1.equals(warehouse2)) {
					System.out.println("[ERROR] :" + "Diference for Warehouse (book1) " + warehouse1
							+ "| Book 1 Warehouse = " + warehouse1 + " | Book 2 Warehouse = " + warehouse2);

				}

// ------------------------------ Comparing Weight Column--------------------------
				String weight1 = "";
				HSSFCell wg1 = row1.getCell(19);
				if (wg1 != null) {
					wg1.setCellType(CellType.STRING);
					weight1 = wg1.getStringCellValue().trim().toLowerCase();
				}

				String weight2 = "";
				HSSFCell wg2 = row2.getCell(19);
				if (wg2 != null) {
					wg2.setCellType(CellType.STRING);
					weight2 = wg2.getStringCellValue().trim().toLowerCase();
				}

				if (!weight1.equals(weight2)) {
					System.out.println("[ERROR] :" + "Diference for Weight (book1) " + weight1 + "| Book 1 Weight = "
							+ weight1 + " | Book 2 Weight = " + weight2);

				}

// ----------------------------- Comparing Dispatch Date from WH Column--------------------------
				String DispatchDateWH1 = "";
				HSSFCell ddwh1 = row1.getCell(20);
				if (ddwh1 != null) {
					ddwh1.setCellType(CellType.STRING);
					DispatchDateWH1 = ddwh1.getStringCellValue().trim().toLowerCase();

					SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd");
					Date date = sdfSource.parse(DispatchDateWH1);
					SimpleDateFormat sdfDestination = new SimpleDateFormat("MM/dd/yyyy");
					DispatchDateWH1 = sdfDestination.format(date);
				}

				String DispatchDateWH2 = "";
				HSSFCell ddwh2 = row2.getCell(20);
				if (ddwh2 != null) {
					ddwh2.setCellType(CellType.STRING);
					DispatchDateWH2 = ddwh2.getStringCellValue().trim().toLowerCase();
				}

				if (!DispatchDateWH1.equals(DispatchDateWH2)) {
					System.out.println("[ERROR] :" + "Diference for Dispatch Date from WH (book1) " + DispatchDateWH1
							+ "| Book 1 Dispatch Date from WH = " + DispatchDateWH1
							+ " | Book 2 Dispatch Date from WH = " + DispatchDateWH2);

				}

// ----------------------------- Comparing Transporter Column--------------------------
				String transporter1 = "";
				HSSFCell tr1 = row1.getCell(21);
				if (tr1 != null) {
					tr1.setCellType(CellType.STRING);
					transporter1 = tr1.getStringCellValue().trim().toLowerCase();
				}

				String transporter2 = "";
				HSSFCell tr2 = row2.getCell(21);
				if (tr2 != null) {
					tr2.setCellType(CellType.STRING);
					transporter2 = tr2.getStringCellValue().trim().toLowerCase();
				}

				if (!transporter1.equals(transporter2)) {
					System.out.println("[ERROR] :" + "Diference for Transporter (book1) " + transporter1
							+ "| Book 1 Transporter = " + transporter1 + " | Book 2 Transporter = " + transporter2);

				}
// ----------------------------- Comparing Docket Number Column--------------------------
				String docketnumber1 = "";
				HSSFCell dno1 = row1.getCell(22);
				if (dno1 != null) {
					dno1.setCellType(CellType.STRING);
					docketnumber1 = dno1.getStringCellValue().trim().toLowerCase();
				}

				String docketnumber2 = "";
				HSSFCell dno2 = row2.getCell(22);
				if (dno2 != null) {
					dno2.setCellType(CellType.STRING);
					docketnumber2 = dno2.getStringCellValue().trim().toLowerCase();
				}

				if (!docketnumber1.equals(docketnumber2)) {
					System.out.println("[ERROR] :" + "Diference for Docket Number (book1) " + docketnumber1
							+ "| Book 1 Docket Number = " + docketnumber1 + " | Book 2 Docket Number = "
							+ docketnumber2);

				}

// ----------------------------- Comparing Mode of Transport Column-------------------------
				String transportmode1 = "";
				HSSFCell tm1 = row1.getCell(23);
				if (tm1 != null) {
					tm1.setCellType(CellType.STRING);
					transportmode1 = tm1.getStringCellValue().trim().toLowerCase();
				}

				String transportmode2 = "";
				HSSFCell tm2 = row2.getCell(23);
				if (tm2 != null) {
					tm2.setCellType(CellType.STRING);
					transportmode2 = tm2.getStringCellValue().trim().toLowerCase();
				}

				if (!transportmode1.equals(transportmode2)) {
					System.out.println("[ERROR] :" + "Diference for Mode of Transport (book1) " + transportmode1
							+ "| Book 1 Mode of Transport = " + transportmode1 + " | Book 2 Mode of Transport = "
							+ transportmode2);

				}

// ----------------------------- Comparing Standard TAT Column-------------------------
				String standardTAT1 = "";
				HSSFCell sTAT1 = row1.getCell(24);
				if (sTAT1 != null) {
					sTAT1.setCellType(CellType.STRING);
					standardTAT1 = sTAT1.getStringCellValue().trim().toLowerCase();
				}

				String standardTAT2 = "";
				HSSFCell sTAT2 = row2.getCell(24);
				if (sTAT2 != null) {
					sTAT2.setCellType(CellType.STRING);
					standardTAT2 = sTAT2.getStringCellValue().trim().toLowerCase();
				}

				if (!standardTAT1.equals(standardTAT2)) {
					System.out.println("[ERROR] :" + "Diference for Standard TAT (book1) " + standardTAT1
							+ "| Book 1 Standard TAT = " + standardTAT1 + " | Book 2 Standard TAT = " + standardTAT2);

				}
// ----------------------------- Comparing Expected Date Column -------------------------

				String ExpectedDate1 = "";
				HSSFCell expecdate1 = row1.getCell(25);
				if (expecdate1 != null) {
					expecdate1.setCellType(CellType.STRING);
					ExpectedDate1 = expecdate1.getStringCellValue().trim().toLowerCase();

					SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd");
					Date date = sdfSource.parse(ExpectedDate1);
					SimpleDateFormat sdfDestination = new SimpleDateFormat("MM/dd/yyyy");
					ExpectedDate1 = sdfDestination.format(date);
				}

				String ExpectedDate2 = "";
				HSSFCell expecdate2 = row2.getCell(25);
				if (expecdate2 != null) {
					expecdate2.setCellType(CellType.STRING);
					ExpectedDate2 = expecdate2.getStringCellValue().trim().toLowerCase();
				}

				if (!ExpectedDate1.equals(ExpectedDate2)) {
					System.out.println("[ERROR] :" + "Diference for Expected Date (book1) " + ExpectedDate1
							+ "| Book 1 Expected Date = " + ExpectedDate1 + " | Book 2 Expected Date = "
							+ ExpectedDate2);

				}

// ----------------------------- Comparing Actual Date Column-------------------------
				String ActualDate1 = "";
				HSSFCell Actual1 = row1.getCell(26);
				if (Actual1 != null) {
					Actual1.setCellType(CellType.STRING);
					ActualDate1 = Actual1.getStringCellValue().trim().toLowerCase();

					SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd");
					Date date = sdfSource.parse(ActualDate1);
					SimpleDateFormat sdfDestination = new SimpleDateFormat("MM/dd/yyyy");
					ActualDate1 = sdfDestination.format(date);
				}

				String ActualDate2 = "";
				HSSFCell Actual2 = row2.getCell(26);
				if (Actual2 != null) {
					Actual2.setCellType(CellType.STRING);
					ActualDate2 = Actual2.getStringCellValue().trim().toLowerCase();
				}

				if (!ActualDate1.equals(ActualDate2)) {
					System.out.println("[ERROR] :" + "Diference for Actual Date (book1) " + ActualDate1
							+ "| Book 1 Actual Date = " + ActualDate1 + " | Book 2 Actual Date = " + ActualDate2 + "--i value--" +i);

				}
// ----------------------------- Comparing received by Column -------------------------
				String received_by1 = "";
				HSSFCell rb1 = row1.getCell(27);
				if (rb1 != null) {
					rb1.setCellType(CellType.STRING);
					received_by1 = rb1.getStringCellValue().trim().toLowerCase();
				}

				String received_by2 = "";
				HSSFCell rb2 = row2.getCell(27);
				if (rb2 != null) {
					rb2.setCellType(CellType.STRING);
					received_by2 = rb2.getStringCellValue().trim().toLowerCase();
				}

				if (!received_by1.equals(received_by2)) {
					System.out.println("[ERROR] :" + "Diference for received by (book1) " + received_by1
							+ "| Book 1 received by = " + received_by1 + " | Book 2 received by = " + received_by2);

				}
// ----------------------------- Comparing Status Column -------------------------
				String status1 = "";
				HSSFCell stat1 = row1.getCell(28);
				if (stat1 != null) {
					stat1.setCellType(CellType.STRING);
					status1 = stat1.getStringCellValue().trim().toLowerCase();
				}

				String status2 = "";
				HSSFCell stat2 = row2.getCell(28);
				if (stat2 != null) {
					stat2.setCellType(CellType.STRING);
					status2 = stat2.getStringCellValue().trim().toLowerCase();
				}

				if (!status1.equals(status2)) {
					System.out.println("[ERROR] :" + "Diference for Status (book1) " + status1 + "| Book 1 Status = "
							+ status1 + " | Book 2 Status = " + status2);

				}

// ----------------------------- Comparing ds_team_order_sent_to_wh_tat_days Column -------------------------
				String ds_team_order_sent_to_wh_tat_days1 = "";
				HSSFCell dsteam1 = row1.getCell(29);
				if (dsteam1 != null) {
					dsteam1.setCellType(CellType.STRING);
					ds_team_order_sent_to_wh_tat_days1 = dsteam1.getStringCellValue().trim().toLowerCase();
				}

				String ds_team_order_sent_to_wh_tat_days2 = "";
				HSSFCell dsteam2 = row2.getCell(29);
				if (dsteam2 != null) {
					dsteam2.setCellType(CellType.STRING);
					ds_team_order_sent_to_wh_tat_days2 = dsteam2.getStringCellValue().trim().toLowerCase();
				}

				if (!ds_team_order_sent_to_wh_tat_days1.equals(ds_team_order_sent_to_wh_tat_days2)) {
					System.out.println("[ERROR] :" + "Diference for ds_team_order_sent_to_wh_tat_days (book1) "
							+ ds_team_order_sent_to_wh_tat_days1 + "| Book 1 ds_team_order_sent_to_wh_tat_days = "
							+ ds_team_order_sent_to_wh_tat_days1 + " | Book 2 ds_team_order_sent_to_wh_tat_days = "
							+ ds_team_order_sent_to_wh_tat_days2);

				}

// ----------------------------- Comparing wh_processing_tat_days Column-------------------------
				String wh_processing_tat_days1 = "";
				HSSFCell whtat1 = row1.getCell(30);
				if (whtat1 != null) {
					whtat1.setCellType(CellType.STRING);
					wh_processing_tat_days1 = whtat1.getStringCellValue().trim().toLowerCase();
				}

				String wh_processing_tat_days2 = "";
				HSSFCell whtat2 = row2.getCell(30);
				if (whtat2 != null) {
					whtat2.setCellType(CellType.STRING);
					wh_processing_tat_days2 = whtat2.getStringCellValue().trim().toLowerCase();
				}

				if (!wh_processing_tat_days1.equals(wh_processing_tat_days2)) {
					System.out.println("[ERROR] :" + "Diference for wh_processing_tat_days (book1) "
							+ wh_processing_tat_days1 + "| Book 1 wh_processing_tat_days = " + wh_processing_tat_days1
							+ " | Book 2 wh_processing_tat_days = " + wh_processing_tat_days2);

				}
// ----------------------------- Comparing actual_order_delivery_tat Column -------------------------
				String actual_order_delivery_tat1 = "";
				HSSFCell actualtat1 = row1.getCell(31);
				if (actualtat1 != null) {
					actualtat1.setCellType(CellType.STRING);
					actual_order_delivery_tat1 = actualtat1.getStringCellValue().trim().toLowerCase();
				}

				String actual_order_delivery_tat2 = "";
				HSSFCell actualtat2 = row2.getCell(31);
				if (actualtat2 != null) {
					actualtat2.setCellType(CellType.STRING);
					actual_order_delivery_tat2 = actualtat2.getStringCellValue().trim().toLowerCase();
				}

				if (!actual_order_delivery_tat1.equals(actual_order_delivery_tat2)) {
					System.out.println("[ERROR] :" + "Diference for actual_order_delivery_tat (book1) "
							+ actual_order_delivery_tat1 + "| Book 1 actual_order_delivery_tat = "
							+ actual_order_delivery_tat1 + " | Book 2 actual_order_delivery_tat = "
							+ actual_order_delivery_tat2);

				}
			}

		} else {
			System.out.println("Row count 1 =" + rowCount1 + "  Rocunt 2 = " + rowCount2);
		}
	}

}
