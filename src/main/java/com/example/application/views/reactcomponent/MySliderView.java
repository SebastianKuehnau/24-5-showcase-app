package com.example.application.views.reactcomponent;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@Menu(title = "React Component in Flow", icon = LineAwesomeIconUrl.TOOLBOX_SOLID)
@Route("react-component")
@RouteAlias("")
public class MySliderView extends VerticalLayout {

    public MySliderView() {
        MySlider mySlider = new MySlider();
        var notification = new Notification();
        notification.setDuration(5000);

        mySlider.addValueChangeListener(number -> {
            notification.setText(String.valueOf(number));
            notification.open();
        });

        add(mySlider);
    }
}
