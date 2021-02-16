package projects.APD_DM.nodes.messages;

import projects.APD_DM.nodes.nodeImplementations.ElectionNode;
import sinalgo.nodes.messages.Message;

public class ElectionMessage extends Message {

	public enum TYPE {
		ASK, REP
	};

	private int nodeId;
	private int l;
	private TYPE t;
	public ElectionNode sender;

	public ElectionMessage(TYPE t, int nodeId, int l, ElectionNode sender) {
		super();
		this.nodeId = nodeId;
		this.l = l;
		this.t = t;
		this.sender = sender;
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