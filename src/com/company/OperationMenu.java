package Main;

import command.CommandController;
import dataContainer.Employee;

public class OperationMenu {
	private static final String EXIT  = "0. Exit    ------------------- Exit the System.";
	public static final String APPLY = "Add new Product.";
	public static final String SHOW = "show Product.";
	public static final String CANCEL = "Buy Product.";
	public static final String APPROVE = "Deliver Product.";
	public static final String REDO = "Redo.";
	public static final String UNDO = "Undo.";
	public static final String SHOW_REDO_UNDO = "Show undo/redo list.";
		
	private static final String[] cmdOrder = {EXIT,OperationMenu.APPLY,
												OperationMenu.CANCEL,OperationMenu.APPROVE};

	
	private Employee employee;
	private String[] menuCombination;
	
	public OperationMenu(Employee e){
		employee = e;
		menuCombination = e.getPosition().getResponsibility();
	}
	
	
	public void display(){
		String menu = "";

		for (int i = 0; i < menuCombination.length; i++){
			int num = i+1;
			menu += (num + ". ");
			menu += menuCombination[i];
		}
		
		menu += EXIT;
		
		System.out.println(menu);
	}
	
	public boolean handleInput(String s){
		int option = Integer.parseInt(s) - 1;
		boolean contineueLoop = false;
		
		if (option != -1){
			int commandIndex = -1;
			for (int i = 0; i < cmdOrder.length; i++){
				if ((cmdOrder[i]).equals(menuCombination[option])){
					commandIndex = i;
					break;
				}
			}			
			contineueLoop = CommandController.executeCommand(commandIndex, employee);
		}
		
		return contineueLoop;
	}
}
