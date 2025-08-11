package com.jpueyodev.integrationtest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jpueyodev.AppConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {AppConfig.class})
@WebAppConfiguration
public class ViewResolverIT {
	
	@Autowired
	InternalResourceViewResolver viewResolver;
	
	@Test
	void resolvesHomeToInternalJsp() throws Exception{
		View view = viewResolver.resolveViewName("home", Locale.getDefault());
		assertTrue(view instanceof InternalResourceView);
		InternalResourceView irv = (InternalResourceView) view;
		assertEquals("/WEB-INF/views/home.jsp", irv.getUrl());
	}
}

