package io.swagger;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public final class Item extends Object {
	@XmlAttribute
	private String id;

	@XmlElement
	private String value;

	public Item() {
		super();
	}

	public Item(final String id, final String value) {
		super();

		setId(id);
		setValue(value);
	}

	public String getId() { return this.id; }

	public void setId(String id) { this.id = id; }

	public String getValue() { return this.value; }

	public void setValue(String value) { this.value = value; }
}
