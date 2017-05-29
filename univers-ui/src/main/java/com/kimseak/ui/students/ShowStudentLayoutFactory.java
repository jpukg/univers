package com.kimseak.ui.students;

import com.kimseak.entity.Student;
import com.kimseak.service.showstudent.ShowStudentService;
import com.kimseak.ui.commons.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by kimseak on 5/28/17.
 */

@org.springframework.stereotype.Component
public class ShowStudentLayoutFactory implements UIComponentBuilder {

    private List<Student> students;
    private BeanItemContainer<Student> container;

    public class ShowStudentLayout extends VerticalLayout{

        private Grid studentTable;
        private ComboBox combo;

        public ShowStudentLayout init(){

            setMargin(true);

            container = new BeanItemContainer<Student>(Student.class, students);

            studentTable = new Grid(container);

            studentTable.setColumnOrder("firstName", "lastName", "gender");
            studentTable.removeColumn("id");
            studentTable.setImmediate(true);

            return this;
        }

        public ShowStudentLayout load(){

            students = showStudentService.getAllStudents();

            return this;
        }

        public ShowStudentLayout layout(){

            addComponent(studentTable);
            return this;
        }

    }

    @Autowired
    private ShowStudentService showStudentService;


    public void refreshTable() {

        students = showStudentService.getAllStudents();
        container.removeAllItems();
        container.addAll(students);

    }


    public Component createComponent() {
        return new ShowStudentLayout().load().init().layout();
    }
}
