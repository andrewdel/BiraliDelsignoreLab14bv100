import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Train {
	private int x; //starting x value
	private int y;// starting y value
	private ArrayList<RailCar> train = new ArrayList<>(); //ArrayList of RailCars, filled by the addCar() methods
	private ArrayList<String> names = new ArrayList<>(); 
	private ArrayList<Color> colors = new ArrayList<>();


	public Train(int i, int j){
		x = i;
		y = j;
	}

	public void addCar(String s, Color c){
		if(s.equalsIgnoreCase("locomotive")){
			train.add(new Locomotive(c,x,y)); //starts with a locomotive at (x,y)
		}else if(s.equalsIgnoreCase("freightcar")){
			train.add(new FreightCar(c,x+train.size()*175,y)); //for every car past the first one, the position is determined by 175* whatever the size of the train is before drawing the new car
		}else if(s.equalsIgnoreCase("caboose")){
			train.add(new Caboose(c,x+(train.size()*175),y));
		}else if(s.equalsIgnoreCase("passengercar")){
			train.add(new PassengerCar(c,x+train.size()*175,y));
		}

	}
	public void addCar(int n, String s, Color c){
		ArrayList<RailCar> temp = new ArrayList<>(); //temp ArrayList will hold reference variables of all the RailCar objects in Train equal to and past the index of addition
		for(int i = n; i <train.size();i++){ 
			RailCar r = train.get(i);  //r holds a reference to the RailCar objects obtained by the .get(index) method
			temp.add(r);
		}
		train.removeAll(temp); //this removes all references of temp existing in train, so if n=2, then anything past and including index 2 has been deleted 
		
		addCar(s,c); //the desired car is now added to the end of the smaller train now 
		for(RailCar rails: temp){
			colors.add(rails.getColor()); //for the temp ArrayList, now we utilize the colors and names ArrayList objects to grab the necessary characteristics of each RailCar
			names.add(rails.getName());
		}
		for(int i = 0; i < colors.size();i++){
			addCar(names.get(i),colors.get(i));//because we know the characteristics of each RailCar beyond the index, using the other addCar method, we add a newRailCar with the same characteristics of the original train, but just moved down one
		}

	}


	public void showCar(Graphics g){
		for(RailCar cars: train){
			cars.drawCar(g);
		}

	}

}
