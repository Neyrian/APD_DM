package projects.APD_DM.nodes.messages;

import sinalgo.nodes.messages.Message;

public class FloodMessage extends Message {

	private static int msgCounter = 0;
	private int msgId;
	public FloodMessage() {
		super();
		msgId = msgCounter;
		msgCounter++;
	}

	public Message clone() {
		return this;
	}
	
	public String toString() {
		return "walker" + msgId;
	}
}