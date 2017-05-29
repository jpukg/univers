package com.kimseak.ui.students;

import com.kimseak.entity.Student;
import com.kimseak.service.addstudent.AddStudentService;
import com.kimseak.utils.Gender;
import com.kimseak.utils.NotificationMessages;
import com.kimseak.utils.StudentStringUtils;
import com.vaadin.data.Property;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.*;
import com.vaadin.ui.Component;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kimseak on 5/27/17.
 */
@org.springframework.stereotype.Component
public class AddStudentMainLayoutFactory {

    public class AddStudentMainLayout extends VerticalLayout implements Button.ClickListener{

        private static final long serialVersionUID = 1L;
        private TextField firstName;
        private TextField lastName;
        private TextField age;
        private ComboBox gender;
        private Button saveButton;
        private Button clearButton;
        private ComboBox university;

        private StudentSavedListener studentSavedListener;
        private Student student;
        private BeanFieldGroup<Student> fieldGroup;

        public AddStudentMainLayout(StudentSavedListener studentSavedListener){
            this.studentSavedListener = studentSavedListener;
        }

        public AddStudentMainLayout init(){

            fieldGroup = new BeanFieldGroup<Student>(Student.class);
            student = new Student();

            firstName = new TextField(StudentStringUtils.FIRST_NAME.getString());
            lastName = new TextField(StudentStringUtils.LAST_NAME.getString());
            age = new TextField(StudentStringUtils.AGE.getString());
            gender = new ComboBox(StudentStringUtils.GENDER.getString());

            firstName.setNullRepresentation("");
            lastName.setNullRepresentation("");
            age.setNullRepresentation("");

            saveButton = new Button(StudentStringUtils.SAVE.getString());
            clearButton = new Button(StudentStringUtils.CANCEL.getString());

            saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
            clearButton.setStyleName(ValoTheme.BUTTON_PRIMARY);

            //event
            saveButton.addClickListener(this);
            clearButton.addClickListener(this);

            gender.addItem(Gender.MALE.getString());
            gender.addItem(Gender.FEMALE.getString());

            //clear value of each field
            clearField();

            return  this;
        }

        public AddStudentMainLayout bind() {
            fieldGroup.bindMemberFields(this);
            fieldGroup.setItemDataSource(student);
            return this;
        }

        public Component layout(){

            setMargin(true);

            GridLayout layout = new GridLayout(2, 4);
            layout.setSizeUndefined();
            layout.setSpacing(true);

            layout.addComponent(firstName, 0, 0);
            layout.addComponent(lastName, 1, 0);

            layout.addComponent(age, 0, 1);
            layout.addComponent(gender, 1, 1);

            layout.addComponent(new HorizontalLayout(saveButton, clearButton), 0, 3);;

            return layout;
        }

        public void buttonClick(Button.ClickEvent event) {

            if(event.getSource() == saveButton){
                 save();
            }else {
                clearField();
            }

        }

        private void clearField() {

            firstName.setValue(null);
            lastName.setValue(null);
            age.setValue(null);
            gender.setValue(null);
        }

        public void save(){

            try {

                fieldGroup.commit();

            } catch (FieldGroup.CommitException e) {

                Notification.show(  NotificationMessages.STUDENT_SAVE_ERROR_TITLE.getString(),
                                    NotificationMessages.STUDENT_SAVE_VALIDATION_ERROR_DESCRIPTION.getString(),
                                    Notification.Type.ERROR_MESSAGE);
                clearField();

            }
            addStudentService.saveStudent(student);
            studentSavedListener.studentSaved();

            System.out.println(student.toString());

            Notification.show(  NotificationMessages.STUDENT_SAVE_SUCCESS_TITLE.getString(),
                    NotificationMessages.STUDENT_SAVE_SUCCESS_DESCRIPTION.getString(),
                    Notification.Type.WARNING_MESSAGE);

        }



    }

    @Autowired
    private AddStudentService addStudentService;

    public Component createComponent(StudentSavedListener studentSavedListener){
        return  new AddStudentMainLayout(studentSavedListener).init().bind().layout();
    }


}
