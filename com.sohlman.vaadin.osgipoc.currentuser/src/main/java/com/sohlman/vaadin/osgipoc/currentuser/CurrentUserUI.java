package com.sohlman.vaadin.osgipoc.currentuser;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ServiceScope;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactory;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Portal;
import com.vaadin.server.VaadinPortletService;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;

@Component(scope = ServiceScope.PROTOTYPE, service = com.vaadin.ui.UI.class)
public class CurrentUserUI extends com.vaadin.ui.UI {
	@Override
	protected void init(VaadinRequest request) {
		try {
			
			User user = _portal.getUser(
				VaadinPortletService.getCurrentPortletRequest());
			if (user==null) {
				setContent(new Label("Non logged-in user"));
			}
			else {
				setContent(new Label("User " + user.getFullName()));
			}
		} 
		catch (PortalException e) {
			_log.error(e);
		}
	}

	private Log _log = LogFactoryUtil.getLog(CurrentUserUI.class);

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private Portal _portal;
}
