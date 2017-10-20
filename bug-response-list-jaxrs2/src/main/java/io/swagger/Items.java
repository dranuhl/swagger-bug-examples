package io.swagger;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="items", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
public final class Items extends Object {
	@XmlElement(namespace="io.swagger.bug-test")
	private List<Item> item;

	public Items() {
		super();

		this.item = new ArrayList<>();
	}

	public Items(final List<Item> item) {
		super();

		this.item = item;
	}

	public List<Item> getItem() {
		return this.item;
	}
}
