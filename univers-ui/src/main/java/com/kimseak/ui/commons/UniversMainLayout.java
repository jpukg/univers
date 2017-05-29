package com.kimseak.ui.commons;

import com.kimseak.ui.navigator.UniversNavigator;
import com.kimseak.ui.students.StudentLayoutFactory;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by kimseak on 5/25/17.
 */
@SpringUI(path = UniversMainLayout.NAME)
@Title(" u n v e r s")
@Theme("valo")
public class UniversMainLayout extends UI{

    public static final  String NAME="ui";

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SpringViewProvider viewProvider;

    @Autowired
    private UniversLogoLayoutFactory universLogoLayoutFactory;

    @Autowired
    private UniversMenuFactory universMenuFactory;

    private Panel changeTab = new Panel();

    protected void init(VaadinRequest vaadinRequest) {

        changeTab.setHeight("100%");

        //root
        VerticalLayout rootLayout =  new VerticalLayout();
        rootLayout.setSizeFull();
        rootLayout.setMargin(true);

        //content
        Panel content = new Panel();
        content.setWidth("75%");
        content.setHeight("100%");
        content.setContent(new Label("This is content layout"));

        //logo
        Panel logoContent = new Panel();
        logoContent.setWidth("75%");
        logoContent.setHeightUndefined();

        //uilayout in content
        HorizontalLayout uiLayout = new HorizontalLayout();
        uiLayout.setSizeFull();
        uiLayout.setMargin(true);

        //component
        Component logo = universLogoLayoutFactory.createComponent();
        Component menu = universMenuFactory.createComponent();


        uiLayout.addComponent(menu);
        uiLayout.addComponent(changeTab);

        uiLayout.setComponentAlignment(menu,Alignment.TOP_CENTER);
        uiLayout.setComponentAlignment(changeTab,Alignment.TOP_CENTER);

        uiLayout.setExpandRatio(menu, 1);
        uiLayout.setExpandRatio(changeTab, 2);


        logoContent.setContent(logo);
        content.setContent(uiLayout);


        rootLayout.addComponent(logoContent);
        rootLayout.addComponent(content);

        rootLayout.setComponentAlignment(logoContent, Alignment.TOP_CENTER);
        rootLayout.setComponentAlignment(content, Alignment.MIDDLE_CENTER);

        rootLayout.setExpandRatio(content, 1);

        initNavigator();

        setContent(rootLayout);

    }

    private void initNavigator() {

        UniversNavigator navigator = new UniversNavigator(this, changeTab);
        applicationContext.getAutowireCapableBeanFactory().autowireBean(navigator);
        navigator.addProvider(viewProvider);
        navigator.navigateTo(StudentLayoutFactory.NAME);

    }
}
