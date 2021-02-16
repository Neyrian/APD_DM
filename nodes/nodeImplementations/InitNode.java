package projects.APD_DM.nodes.nodeImplementations;

import java.awt.Color;

import projects.APD_DM.nodes.messages.ElectionMessage;
import projects.APD_DM.nodes.messages.ElectionMessage.TYPE;
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
		resultat = false;
		l = 1;
		n = 0;
		ElectionMessage em = new ElectionMessage(TYPE.ASK, ID, l - 1, this);
		broadcast(em);
	}

	public String toString() {
		return super.toString() + "(init)";
	}
}
