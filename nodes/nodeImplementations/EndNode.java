package projects.APD_DM.nodes.nodeImplementations;

import java.awt.Color;

import projects.APD_DM.nodes.messages.FloodMessage;

public class EndNode extends ElectionNode {

	/* EndNode() { ... } */
	public void init() {
		super.init(); 
		setColor(Color.BLUE);
	}

	public String toString() {
		return super.toString() + "(end)";
	}
	
	/** when the node receives the message, it stops it! */
	public void handleMessages(sinalgo.nodes.messages.Inbox inbox) {
		while(inbox.hasNext()){
			sinalgo.nodes.messages.Message msg = inbox.next();
			if(msg instanceof FloodMessage){ /* do nothing! */
				System.out.println(this + " received message " + msg + " and stops it!");
				setColor(Color.CYAN);
			}
		}
	}
}
