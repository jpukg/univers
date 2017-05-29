package com.kimseak.ui.students;

import com.kimseak.entity.Student;
import com.kimseak.service.removestudent.RemoveStudentService;
import com.kimseak.service.showstudent.ShowStudentService;
import com.kimseak.ui.commons.UniversMainLayout;
import com.kimseak.utils.NotificationMessages;
import com.kimseak.utils.StudentStringUtils;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.vaadin.ui.Grid.*;

/**
 * Created by kimseak on 5/28/17.
 */

@SpringView(name = RemoveStudentLayoutFactory.NAME, ui = UniversMainLayout.class)
public class RemoveStudentLayoutFactory extends VerticalLayout implements View, Button.ClickListener {

    public static final String NAME = "removestudent";
    private Grid removeStudentTable;
    private Button removeStudentButton;
    private List<Student> students;

    @Autowired
    private ShowStudentService showStudentService;
    @Autowired
    private RemoveStudentService removeStudentService;

    private void addLayout(){

        removeStudentButton = new Button("Remove");

        setMargin(true);

        BeanItemContainer<Student> container = new BeanItemContainer<Student>(Student.class, students);

        removeStudentTable = new Grid(container);
        removeStudentTable.setColumnOrder("firstName", "lastName", "gender");
        removeStudentTable.removeColumn("id");
        removeStudentTable.setImmediate(true);
        removeStudentTable.setSelectionMode(SelectionMode.MULTI);

        removeStudentButton.addClickListener(this);
        removeStudentButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);

        addComponent(removeStudentTable);
        addComponent(removeStudentButton);

    }

    private void loadStudents(){

        students = showStudentService.getAllStudents();
    }

    public void buttonClick(Button.ClickEvent event) {

        MultiSelectionModel selectionModel = (MultiSelectionModel) removeStudentTable.getSelectionModel();

        for(Object selectedItem :selectionModel.getSelectedRows()){

            Student student = (Student) selectedItem;
            removeStudentTable.getContainerDataSource().removeItem(student);
            removeStudentService.removeStudent(student);

            Notification.show( NotificationMessages.STUDENT_REMOVE_SUCCESS_TITLE.getString(),
                               NotificationMessages.STUDENT_REMOVE_SUCCESS_DESCRIPTION.getString(),
                                Notification.Type.WARNING_MESSAGE);

        }


    }



    public void enter(ViewChangeListener.ViewChangeEvent event) {

        if( removeStudentTable != null ) return;

        loadStudents();
        addLayout();
    }


}
