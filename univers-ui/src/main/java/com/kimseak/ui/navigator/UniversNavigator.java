package com.kimseak.ui.navigator;

import com.google.gwt.thirdparty.guava.common.base.Strings;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

/**
 * Created by kimseak on 5/26/17.
 */
public class UniversNavigator extends Navigator {

    public UniversNavigator(UI ui, SingleComponentContainer container) {
        super(ui, container);
    }

    private static UniversNavigator getNavigator(){
        UI ui = UI.getCurrent();
        Navigator navigator = ui.getNavigator();
        System.out.println("getNavigator");
        return (UniversNavigator) navigator;
    }

    public static void navigate(String path){
        try{

            UniversNavigator.getNavigator().navigateTo(path);
            System.out.print("==============navigate do function");

        }catch (Exception e){
            return;
        }
    }

    @Override
    public void navigateTo(String viewName) {
        super.navigateTo(Strings.nullToEmpty(viewName));
        System.out.print("==============navigateTo do function");

    }
}
