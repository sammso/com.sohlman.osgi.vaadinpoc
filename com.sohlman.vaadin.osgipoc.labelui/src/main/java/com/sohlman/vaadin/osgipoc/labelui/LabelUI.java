package com.sohlman.vaadin.osgipoc.labelui;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@Component(scope = ServiceScope.PROTOTYPE, service = com.vaadin.ui.UI.class)
public class LabelUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		setContent(new Label("Hello world"));
	}
}
