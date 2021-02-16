package projects.APD_DM.nodes.messages;

import sinalgo.nodes.messages.Message;

public class ElectionMessage extends Message {

	private static int msgCounter = 0;
	private int msgId;
	public ElectionMessage() {
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