package projects.APD_DM.nodes.messages;

import sinalgo.nodes.messages.Message;

public class ElectionMessage extends Message {

	public enum TYPE {
		ASK, REP
	};

	private int nodeId;
	private int l;
	private TYPE t;

	public ElectionMessage(TYPE t, int nodeId, int l) {
		super();
		this.nodeId = nodeId;
		this.l = l;
		this.t = t;
	}

	public Message clone() {
		return this;
	}

	public TYPE getType() {
		return t;
	}

	public int getId() {
		return nodeId;
	}

	public int getl() {
		return l;
	}

	@Override
	public String toString() {
		return "msg nodeId " + nodeId + "distance " + l;
	}
}