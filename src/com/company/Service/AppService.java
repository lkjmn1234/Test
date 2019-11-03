package Service;

import dataContainer.LeaveApplication;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import position.*;
import progressStatus.StatusFactory;
import leaveType.LeaveTypeFactory;

public class AppService {
	
	private static AppService instance = new AppService();
	private final static String filePath = "data.txt";
	
	private ArrayList<LeaveApplication> allApplications;
	
	private AppService(){
		allApplications = new ArrayList<>();
		readRecordFromTxt();
	}
	
	public static AppService getInstance(){
		return instance;
	}
	
	public static void init(){}
	
	/**
	 * @param la
	 * Replace the old application object by the new one and update the txt file
	 */
	public void UpdateApplicationRecord(LeaveApplication la){
		//replace the applicationObject in arrayList
		for (LeaveApplication app : allApplications){
			if(app.getApplicationID().equals(la.getApplicationID())){
				app = la;
				break;
			}
		}
		
		writeRecordToTxt();
	}
	
	public ArrayList<LeaveApplication> searchApplicationRecordByPosition(Position position){
		ArrayList<LeaveApplication> result = new ArrayList<>();
		if(position instanceof Manager){
			for (LeaveApplication app : allApplications){
				if(app.getpStatus().canApproveByDepartment()){
					result.add(app);
				}
			}
		}
		else if(position instanceof Admin){
			for (LeaveApplication app : allApplications){
				if(app.getpStatus().canApproveByAdmin()){
					result.add(app);
				}
			}
		}
		
		return result;	
	}
	
	/**
	 * 
	 * @param employeeID
	 * @return an array list containing all applications of the specific employee
	 */
	public ArrayList<LeaveApplication> searchApplicationRecord(String employeeID){
		ArrayList<LeaveApplication> result = new ArrayList<>();
		boolean found = false;
		
		for (LeaveApplication app : allApplications){
			if(app.getEmployeeID().equals(employeeID)){
				result.add(app);
				found = true;
			}
		}
		
		return (found)?result:null;		
	}
	
	public boolean addRecord(LeaveApplication la){
		boolean isSuccess = allApplications.add(la);
		
		if(isSuccess)
			writeRecordToTxt();
		
		return isSuccess;
	}
	
	public LeaveApplication removeRecord(String appID){
		int targetIndex = -1;
		int counter = 0;
		
		for (LeaveApplication la : allApplications){
			if (la.getApplicationID().equals(appID)){
				if (la.getpStatus().canCancel())
					targetIndex = counter;
				break;
			}
			counter++;
		}
		
		if (targetIndex != -1){	
			LeaveApplication temp = allApplications.remove(targetIndex);
			writeRecordToTxt();
			return temp;
		}

		return null;
	}
	
	//get data from txt
	private void readRecordFromTxt(){
		Scanner inFile = null;
		File file = null;
		try{
			file = new File(filePath);
			inFile = new Scanner(file);
			
			while(inFile.hasNext()){
				String data = inFile.nextLine();
				String[] dataArr = data.split(",");
				
				allApplications.add(new LeaveApplication(dataArr[0],dataArr[1],Integer.parseInt(dataArr[2])
				,LeaveTypeFactory.generateLeaveType(dataArr[3], dataArr[4]),StatusFactory.generateStatus(dataArr[5])));
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			inFile.close();
		}
	}
	
	private void writeRecordToTxt(){
		try{
			//data to LongString
			String data = "";
			for (LeaveApplication app : allApplications){
				data = data + app.toData() + String.format("%n");
			}
			
			//write to .txt
			PrintWriter printer = new PrintWriter(filePath);
			printer.write(data.trim());
			printer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
