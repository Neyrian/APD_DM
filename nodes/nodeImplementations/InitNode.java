package projects.APD_DM.nodes.nodeImplementations;

import java.awt.Color;

import projects.APD_DM.nodes.messages.FloodMessage;
import projects.APD_DM.nodes.timers.InitTimer;

/** the initiator node sends the message (the walker) */
public class InitNode extends ElectionNode {

	/* InitNode() { ... } */
	public void init() {
		super.init(); 
		setColor(Color.GREEN);
		(new InitTimer(this)).startRelative(InitTimer.timerRefresh, this); 		
	}

	public void initiate() {
		FloodMessage flood = new FloodMessage();
		System.out.println(this + " is sending now message " + flood);
		broadcast(flood);
		hadBroadcast = true;
	}

	public String toString() {
		return super.toString() + "(init)";
	}
}
