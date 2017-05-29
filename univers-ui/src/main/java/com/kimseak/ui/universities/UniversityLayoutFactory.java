package com.kimseak.ui.universities;

import com.kimseak.ui.commons.UniversMainLayout;
import com.kimseak.utils.StringUtils;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.navigator.View;


/**
 * Created by kimseak on 5/26/17.
 */
@SpringView(name = UniversityLayoutFactory.NAME, ui = UniversMainLayout.class)
public class UniversityLayoutFactory extends VerticalLayout implements View {

    public static final String NAME ="operations";
    private TabSheet tabSheet;

    public void addLayout(){

        setMargin(true);

        tabSheet = new TabSheet();
        tabSheet.setWidth("100%");

        //define tab content
        Component addUniversityTab = new Label("This is add university tab");
        Component showUniversityTab = new Label("This is show university tab");
        Component chartUniversityTab = new Label("This is chart university tab");

        //define tab name match with content
        tabSheet.addTab(addUniversityTab, StringUtils.MENU_ADD_UNIVERSITY.getString());
        tabSheet.addTab(showUniversityTab, StringUtils.MENU_SHOW_UNIVERSITY.getString());
        tabSheet.addTab(chartUniversityTab, StringUtils.MENU_CHART_UNIVERSITY.getString());

        addComponent(tabSheet);


    }

    public void enter(ViewChangeListener.ViewChangeEvent event) {
        removeAllComponents();
        addLayout();
    }
}
