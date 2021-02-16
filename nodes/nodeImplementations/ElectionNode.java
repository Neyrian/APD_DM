package projects.APD_DM.nodes.nodeImplementations;

import java.awt.Color;
import java.util.Random;

import projects.APD_DM.nodes.messages.FloodMessage;
import sinalgo.nodes.Node;

public class ElectionNode extends sinalgo.nodes.Node {

	/* WalkerNode() { 
	 *   // no constructor code, it breaks the way sinalgo builds the nodes. 
	 *   // instead use the init() method 
	 * }
	 * */
	
	public boolean hadBroadcast;
	
	public void init() {
		setColor(Color.YELLOW);
		hadBroadcast = false;
	}
		
	public String toString() {
		return " " + ID + " "; 
	}

	public void handleMessages(sinalgo.nodes.messages.Inbox inbox) {
		while(inbox.hasNext()) {
			sinalgo.nodes.messages.Message msg = inbox.next();
			if (msg instanceof FloodMessage && !hadBroadcast) {
				FloodMessage flood = (FloodMessage) msg;	
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				hadBroadcast = true;
				broadcast(flood);
				setColor(Color.DARK_GRAY);
				System.out.println(this + " received message " + flood + 
								   " and broadcast it now");
			}
		}
	}
	
	public void preStep() {};
	public void neighborhoodChange() {};
	public void postStep() {}; 
	public void checkRequirements() throws sinalgo.configuration.WrongConfigurationException {};
	public void draw(java.awt.Graphics g, sinalgo.gui.transformation.PositionTransformation pt, 
					 boolean highlight) {
		// draw the node as a circle with the text inside
		super.drawNodeAsDiskWithText(g, pt, highlight, toString(), 20, Color.black);
	}
}