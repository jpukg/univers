package com.kimseak.ui.students;

import com.kimseak.ui.commons.UniversMainLayout;
import com.kimseak.utils.StudentStringUtils;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kimseak on 5/26/17.
 */

@SpringView(name = StudentLayoutFactory.NAME, ui = UniversMainLayout.class)
public class StudentLayoutFactory extends VerticalLayout implements View , StudentSavedListener {

    public static final String NAME = "addstudent";

    @Autowired
    private AddStudentMainLayoutFactory addStudentMainLayoutFactory;

    @Autowired
    private ShowStudentLayoutFactory showStudentLayoutFactory;

    private TabSheet tabSheet;

    private void addLayout(){

        setMargin(true);

        tabSheet = new TabSheet();
        tabSheet.setWidth("100%");

        Component addStudentMainTab = addStudentMainLayoutFactory.createComponent(this);
        Component showStudentTab = showStudentLayoutFactory.createComponent();

        tabSheet.addTab(addStudentMainTab, StudentStringUtils.MAIN_MENU.getString());
        tabSheet.addTab(showStudentTab, StudentStringUtils.SHOW_ALL_STUDENTS.getString());

        addComponent(tabSheet);

    }

    public void enter(ViewChangeListener.ViewChangeEvent event) {
        removeAllComponents();
        addLayout();
    }

    public void studentSaved() {
        showStudentLayoutFactory.refreshTable();
    }
}
