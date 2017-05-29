package com.kimseak.ui.commons;

import com.kimseak.ui.navigator.UniversNavigator;
import com.kimseak.utils.StringUtils;
import com.vaadin.data.Property;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by kimseak on 5/26/17.
 */

@org.springframework.stereotype.Component
public class UniversMenuFactory implements UIComponentBuilder  {

    private class UniversMenu extends VerticalLayout implements Property.ValueChangeListener{

        private Tree mainMenu;

        private UniversMenu init(){

            mainMenu = new Tree();
            mainMenu.addValueChangeListener(this);

            return this;
        }

        public UniversMenu layout(){

            setWidth("100%");
            setHeightUndefined();

            mainMenu.addItem(StringUtils.MENU_STUDENT.getString());
            mainMenu.addItem(StringUtils.MENU_UNIVERSITY.getString());

            mainMenu.expandItem(StringUtils.MENU_STUDENT.getString());
            mainMenu.expandItem(StringUtils.MENU_UNIVERSITY.getString());

            mainMenu.addItem(StringUtils.MENU_ADD_STUDENT.getString());
            mainMenu.addItem(StringUtils.MENU_REMOVE_STUDENT.getString());
            mainMenu.setChildrenAllowed(StringUtils.MENU_ADD_STUDENT.getString(), false);
            mainMenu.setChildrenAllowed(StringUtils.MENU_REMOVE_STUDENT.getString(), false);
            mainMenu.setParent(StringUtils.MENU_ADD_STUDENT.getString(), StringUtils.MENU_STUDENT.getString());
            mainMenu.setParent(StringUtils.MENU_REMOVE_STUDENT.getString(), StringUtils.MENU_STUDENT.getString());

            mainMenu.addItem(StringUtils.MENU_OPERATIONS.getString());
            mainMenu.setChildrenAllowed(StringUtils.MENU_OPERATIONS.getString(), false);
            mainMenu.setParent(StringUtils.MENU_OPERATIONS.getString(), StringUtils.MENU_UNIVERSITY.getString());

            addComponent(mainMenu);

            return this;
        }

        public void valueChange(Property.ValueChangeEvent event) {

            String selectItemPath = (String) event.getProperty().getValue();
            System.out.println("Before ----------->" + selectItemPath);

            String path = selectItemPath.toLowerCase().replaceAll("\\s+", "");
            System.out.println("After  ----------->" + path);

            UniversNavigator.navigate(path);

        }
    }

    public Component createComponent() {
        return new UniversMenu().init().layout();
    }
}
