import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class BiraliDelsignoreLab14bv100 extends Applet {
	public void paint(Graphics g){
		Train t = new Train(100,300);
		t.addCar("locomotive", Color.blue);
		t.addCar("passengercar", Color.LIGHT_GRAY);
		t.addCar("passengercar", Color.LIGHT_GRAY);
		t.addCar("freightcar", Color.GREEN);
		t.addCar(3,"passengercar", Color.LIGHT_GRAY);
		t.addCar("freightcar", Color.GREEN);
		t.addCar(6,"freightcar", Color.GREEN);
		t.addCar(7,"Caboose", Color.red);
		t.showCar(g);
		
	}

}
