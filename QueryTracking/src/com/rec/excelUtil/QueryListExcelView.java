package com.rec.excelUtil;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.rec.model.Admin;
import com.rec.model.Discom;
import com.rec.model.StateDiscom;

public class QueryListExcelView extends AbstractXlsxView {
	private static Logger log= Logger.getLogger(QueryListExcelView.class);
	private SessionFactory sf;
	

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try
		{
			
		response.setHeader("Content-Disposition", "attachment; filename=\"D:\\queryTracking.xlsx\"");
         
		List<Discom> AdminPanel = (List<Discom>) model.get("AdminPanel");
		 Sheet sheet = workbook.createSheet("QueryTracking Report");
		 Row header = sheet.createRow(0);
		 header.createCell(0).setCellValue("userId");
		 header.createCell(1).setCellValue("Name of the State");
		 header.createCell(2).setCellValue("Name of the Discom");
		 header.createCell(3).setCellValue("Employee Name");
		 header.createCell(4).setCellValue("Query No");
		 header.createCell(5).setCellValue("Facility Name");
		 header.createCell(6).setCellValue("Description");
		 header.createCell(7).setCellValue("Query Registered on");
		 header.createCell(8).setCellValue("Status");
		 header.createCell(9).setCellValue("QUERY COMPLIANCE DATE");
		 header.createCell(10).setCellValue("Remarks");
		 int row_count=1;
		 
		 //connecting to database
		 log.info("connecting to the database");
		 log.info("-------------------------------------------------------------");
		 log.info("***********Opening Session******************");
		 Session session = sf.openSession();
		 
		 
		 
		 
		 
		 for(Discom records:AdminPanel)
		 {
			 log.info("records are: Id:\n"+records.getUserId()+"Discom name: \n"+records.getDiscomName());
			 Row datarow = sheet.createRow(row_count++);
			 log.info("row count"+row_count);
			 datarow.createCell(0).setCellValue(records.getUserId());
			 datarow.createCell(1).setCellValue(records.getState());
			 datarow.createCell(2).setCellValue(records.getDiscomName());
			 datarow.createCell(3).setCellValue(records.getUsername());
			 datarow.createCell(4).setCellValue(records.getQueryNo());
			 datarow.createCell(5).setCellValue(records.getFacility());
			 datarow.createCell(6).setCellValue(records.getQueryDescription());
			 datarow.createCell(7).setCellValue(records.getQueryRegistered());
			 datarow.createCell(8).setCellValue(records.getAdmin().getStatus());
			 datarow.createCell(9).setCellValue(records.getAdmin().getQueryComplianceDate());
			 datarow.createCell(10).setCellValue(records.getAdmin().getRemarks());
			 
			 
		 }
		 
		}
		catch (Exception e) {
			log.info(e);
			e.printStackTrace();
			e.getMessage();
			// TODO: handle exception
		}
		
	
		 
		
		
		
		
		
		
		
		
		
		
	}

}
