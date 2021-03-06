package projects.APD_DM.nodes.nodeImplementations;

import java.awt.Color;

import projects.APD_DM.nodes.messages.ElectionMessage;
import projects.APD_DM.nodes.messages.ElectionMessage.TYPE;

public class ElectionNode extends sinalgo.nodes.Node {
	
	boolean resultat;
	int l, n;
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
	
	
	public void init() {
		setColor(Color.YELLOW);
		
	}
		
	public String toString() {
		return " " + ID + " "; 
	}

	public void handleMessages(sinalgo.nodes.messages.Inbox inbox) {
		while(inbox.hasNext()) {
			sinalgo.nodes.messages.Message msg = inbox.next();
			
			if (msg instanceof ElectionMessage) {
				ElectionMessage em = (ElectionMessage) msg;
				
				if (em.getType()  == TYPE.ASK) {
					if (em.getId() == ID) {
						resultat = true;
						setColor(Color.RED);
					} else if (em.getl()  > 0) {
						if (em.getId() > ID) {
							ElectionMessage m = new ElectionMessage(TYPE.ASK, em.getId(), em.getl() - 1, this);
							if (em.sender.equals(left))
								send(m, right);
							else 
								send(m, left);
						}
							
					} else if (em.getl() == 0) {
						if (em.getId() > ID) {
							ElectionMessage m = new ElectionMessage(TYPE.REP, em.getId(),0, this);
							send(m, em.sender);
						}
					}
				} else if (em.getType() == TYPE.REP) {
					if (em.getId() != ID) {
						ElectionMessage m = new ElectionMessage(TYPE.REP, em.getId(),0, this);
						if (em.sender.equals(left))
							send(m, right);
						else 
							send(m, left);
					} else if (em.getId() == ID) {
						n ++;
						if (n == 2) {
							n = 0;
							l *= 2;
							ElectionMessage m = new ElectionMessage(TYPE.ASK, ID, l - 1, this);
							broadcast(m);
						}
					}
				} else {
					System.exit(-1);
				}

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