package projects.APD_DM.nodes.nodeImplementations;

import java.awt.Color;

import projects.APD_DM.nodes.messages.ElectionMessage;

public class ElectionNode extends sinalgo.nodes.Node {
	
	/* WalkerNode() { 
	 *   // no constructor code, it breaks the way sinalgo builds the nodes. 
	 *   // instead use the init() method 
	 * }
	 * */
	
	public ElectionNode right;
	public ElectionNode left;
	
	public void addLeft(ElectionNode left) {
		this.addConnectionTo(left);
		left.addConnectionTo(this);
		this.left = left;
		left.right = this;
	}
	
	public void addRight(ElectionNode right) {
		this.addConnectionTo(right);
		right.addConnectionTo(this);
		this.right = right;
		right.left = this;
	}
	
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
			if (msg instanceof ElectionMessage && !hadBroadcast) {
				ElectionMessage flood = (ElectionMessage) msg;	
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