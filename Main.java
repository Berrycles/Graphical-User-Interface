package application;
	
import java.util.ArrayList;

import application.ShapeGenerator.ResetEventHandler;
import exercise_hotel_rooms_ver1.DeluxeRoom;
import exercise_hotel_rooms_ver1.Hotel;
import exercise_hotel_rooms_ver1.RegularRoom;
import exercise_hotel_rooms_ver1.Room;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	protected Button btnCreateHotel, btnShowAll, btnReset, btnSearchHotel, btnRegAddRoom, btnDelxAddRoom,btnRemoveRoom, btnReset2;
	protected TextField txfParameters, txfParameters2, txfParameters3;
	protected ArrayList<Hotel> hotels = new ArrayList<>();
	protected TextArea txaMessage, txaMessage2;
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane grdRootPane = buildGui();
			Scene scene = new Scene(grdRootPane,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	private GridPane buildGui() {
		GridPane root = new GridPane();
		root.add(buildButtonRow(), 0, 1);
		return root;
		
	}
	
	private Pane buildButtonRow() {
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		btnCreateHotel = new Button("Create Hotel");
		vBox.getChildren().add(btnCreateHotel);
		txfParameters = new TextField("");
		vBox.getChildren().add(txfParameters);
		btnShowAll = new Button("Show All");
		vBox.getChildren().add(btnShowAll);
		btnReset = new Button("Reset");
		vBox.getChildren().add(btnReset);
		txaMessage = new TextArea("");
		vBox.getChildren().add(txaMessage);
		
		vBox.getStyleClass().add("h_or_v_box");
		btnSearchHotel = new Button("Search Hotel");
		vBox.getChildren().add(btnSearchHotel);
		txfParameters2 = new TextField("");
		vBox.getChildren().add(txfParameters2);
		btnRegAddRoom = new Button("Add Regular Room");
		vBox.getChildren().add(btnRegAddRoom);
		btnDelxAddRoom = new Button("Add Deluxe Room");
		vBox.getChildren().add(btnDelxAddRoom);
		btnRemoveRoom = new Button("Remove Room");
		vBox.getChildren().add(btnRemoveRoom);
		txfParameters3 = new TextField("");
		vBox.getChildren().add(txfParameters3);
		btnReset2 = new Button("Reset");
		vBox.getChildren().add(btnReset2);
		txaMessage2 = new TextArea("");
		vBox.getChildren().add(txaMessage2);
		
		CreateHotelEventHandler btnEventHandler = new CreateHotelEventHandler();
		btnCreateHotel.setOnAction(btnEventHandler);
		
		SearchHotelEventHandler btnSearchEventHandler = new SearchHotelEventHandler();
		btnSearchHotel.setOnAction(btnSearchEventHandler);
		
		ShowAllEventHandler btnShowAllEventHandler = new ShowAllEventHandler();
		btnShowAll.setOnAction(btnShowAllEventHandler);
		
		AddRoomEventHandler btnAddRoomEventHandler = new AddRoomEventHandler();
		btnRegAddRoom.setOnAction(btnAddRoomEventHandler);
		ResetEventHandler btnResetEventHandler = new ResetEventHandler();
        btnReset.setOnAction(btnResetEventHandler );
        
        AddDelxRoomEventHandler btnAddDelxRoomEventHandler = new AddDelxRoomEventHandler();
        btnDelxAddRoom.setOnAction(btnAddDelxRoomEventHandler);
        
        RemoveRoomEventHandler btnRemoveRoomEventHandler = new RemoveRoomEventHandler();
        btnRemoveRoom.setOnAction(btnRemoveRoomEventHandler);
        
        ResetEventHandler2 btnResetEventHandler2 = new ResetEventHandler2();
        btnReset2.setOnAction(btnResetEventHandler2);
        
		return vBox;
	}
	
	
	private class CreateHotelEventHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent event) {	
			String input = txfParameters.getText();
			String name = input;
			Hotel hotel = new Hotel(name); 
			hotels.add(hotel);
			String output = "Hotel Successfuly Created";
			txaMessage.setText(output);
		}
    }
	
	private class SearchHotelEventHandler implements EventHandler<ActionEvent>{
		
		@Override
		public void handle(ActionEvent event) {	
			
			String input = txfParameters2.getText();
			String name = input;
			Hotel key = null;
//			int index = hotels.indexOf(key);
//			Hotel hotel = hotels.get(index); 
			for(Hotel x : hotels) {
				if(x.getName().equals(name)) {
					key = x;
					String msg = "All Hotels:\n";
					msg += String.format("%4d. %s\n", 1, x);
					txaMessage2.setText(msg);
				}					
			}
			if(hotels.contains(key)) {
				
			}
			else {
				txaMessage2.setText("Invalid Hotel Name");
			}
			
			
			
			
		}
		
		

		
    }
	
	private class ShowAllEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			txaMessage.setText("Needs to be implemented");
			String msg = "All Hotels:\n";

			int i=1;
			for(Hotel x : hotels) {
				msg += String.format("%4d. %s\n", i++, x);
			}
			txaMessage.setText(msg);
			// Erase fields
			txfParameters.setText(null);
			
		}
    }
	
	private class AddRoomEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			String input = txfParameters2.getText();
			String name = input;
			Hotel hotelAdd = null;
			for(Hotel x : hotels) {
				if(x.getName().equals(name)) {		
					hotelAdd= x;
				}
			}
			String input2 = txfParameters3.getText();
			String [] splitInput = input2.split("\\s+");
			int x = Integer.parseInt(splitInput[0]);
			int y = Integer.parseInt(splitInput[1]);
			int z = Integer.parseInt(splitInput[2]);
			if (y>0) {
				boolean added = hotelAdd.addRoom(new RegularRoom(x,y,z));
				
				if(added) {
					String msg = String.format("Room succesfully added!");			
					txaMessage2.setText(msg);
				}
				else {
					String msg = String.format("Room already exists");			
					txaMessage2.setText(msg);
				}
			}
			else {
				String msg = String.format("Invalid Number of People");			
				txaMessage2.setText(msg);
			}
			
		}
    }
	
	private class AddDelxRoomEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			String input = txfParameters2.getText();
			String name = input;
			Hotel hotelAdd = null;
			for(Hotel x : hotels) {
				if(x.getName().equals(name)) {		
					hotelAdd= x;
				}
			}
			String input2 = txfParameters3.getText();
			String [] splitInput = input2.split("\\s+");
			int x = Integer.parseInt(splitInput[0]);
			int y = Integer.parseInt(splitInput[1]);
			int z = Integer.parseInt(splitInput[2]);
			if (y>0) {
				if(splitInput.length==4) {
					int l = Integer.parseInt(splitInput[3]);
					boolean added = hotelAdd.addRoom(new DeluxeRoom(x,y,z,l));
					
					if(added) {
						String msg = String.format("Room succesfully added!");			
						txaMessage2.setText(msg);
					}
					else {
						String msg = String.format("Room already exists");			
						txaMessage2.setText(msg);
					}
				}
				else {
					boolean added = hotelAdd.addRoom(new DeluxeRoom(x,y,z));
					
					if(added) {
						String msg = String.format("Room Succesfully Added!");			
						txaMessage2.setText(msg);
					}
					else {
						String msg = String.format("Room already exists");			
						txaMessage2.setText(msg);
					}
				}
			}
			else {
				String msg = String.format("Invalid Number of People");			
				txaMessage2.setText(msg);
			}
			
		}
    }
	
	private class RemoveRoomEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			String input = txfParameters2.getText();
			String name = input;
			Hotel hotelRemove = null;
			for(Hotel x : hotels) {
				if(x.getName().equals(name)) {		
					hotelRemove= x;
				}
			}
			String input2 = txfParameters3.getText();
			int x = Integer.parseInt(input2);
			boolean removed = hotelRemove.removeRoom(x);
			if(removed) {
				String msg = String.format("Room successfuly removed");			
				txaMessage2.setText(msg);
			}
			else {
				String msg = String.format("Room unsuccessfuly removed");			
				txaMessage2.setText(msg);
			}
			
		}
    }
	
	private class ResetEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			hotels.removeAll(hotels);
			
		}
    }
	
	private class ResetEventHandler2 implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			txaMessage2.setText("");
			
		}
    }
	
	
	
	
}
